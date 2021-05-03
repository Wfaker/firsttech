package com.msl.rule.lt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.msl.rule.framework.contants.RuleConstants;
import com.msl.rule.framework.dao.MSLDataDao;
import com.msl.rule.framework.util.AESUtils;
import com.msl.rule.life.bom.OwnerBom;
import com.msl.rule.life.bom.PolicyBom;
import com.msl.rule.life.bom.ResultBom;
import com.msl.rule.life.bom.RuleInfoBom;
import com.msl.rule.life.dto.Response;


@Service
public class LtLifeLogService {
	// 日志记录器
//	private static Logger logger = LoggerFactory.getLogger(LtLifeLogService.class);
	
	@Autowired
	private MSLDataDao dateDao;
	
	/**
	 * 保存数据信息
	 * @param policyBom
	 * @param resultBom
	 * @param jsonId
	 * @param beginTime
	 * @param endTime
	 * @param jsonTime
	 * @param ruleTime
	 * @param exceptionFlag
	 */
	@Async
	public void saveDateToDB(String policyJsonString, Response response, PolicyBom policyBom, ResultBom resultBom, long beginTimeMillis, long endTimeMillis,
			long jsonTime, long ruleTime, int exceptionFlag, String exceptionMsg) {
		
		Date beginTime = new Date(beginTimeMillis);
		Date endTime = new Date(endTimeMillis);
		
		Map<String,String> policyInfo = new HashMap<String, String>();
		List<Map<String,String>> ruleInfoList = new ArrayList<Map<String,String>>();
		initDataInfo(policyBom,resultBom,policyInfo,ruleInfoList);
//		String policyJsonString = JSON.toJSONString(policy);
//		Policy policy = JSON.parseObject(policyJsonString, Policy.class);
		String responseJsonString = JSON.toJSONString(response);
		
//		if (SysConstants.isPrintPolicy()) {
//			logger.info("***********************print response traceId=" + resultBom.getTraceId() + "***********************");
//			logger.info(responseJsonString);
//		}
		
		// 数据加密(客户三要素加密)
//		
		String encryptPolicyJsonString = clientEncryption(policyJsonString);
		String encryptResponseJsonString = JSON.toJSONString(responseJsonString);
		System.out.println(encryptPolicyJsonString);
		// JSON报文信息
		long jsonId = dateDao.insertJsonData(encryptPolicyJsonString, encryptResponseJsonString, beginTime, endTime, exceptionFlag, exceptionMsg);
		
		// 基础信息
		long processId = dateDao.insertBasicInfo(policyInfo, jsonId, beginTime, endTime, jsonTime,
				ruleTime, exceptionFlag,policyBom.getTermType().equals("L") ? 1 : 4);
		
		// 规则触发信息
		dateDao.insertRuleResule(processId, ruleInfoList);
		
		// 清理数据
		responseJsonString = null;
		encryptPolicyJsonString = null;
		encryptResponseJsonString = null;
	}
	@SuppressWarnings("unchecked")
	public String clientEncryption(String jsonString){
		String[] info = {"name","idNumber","mobilePhone"};
		Map<String,Object> jsonStr = JSON.parseObject(jsonString);
		Map<String, Object> owner =  (Map<String, Object>) jsonStr.get("owner");
		List<Map<String, Object>> insureds =  (List<Map<String, Object>>) jsonStr.get("insureds");
		List<Map<String, Object>> beneficiaries =  (List<Map<String, Object>>) jsonStr.get("beneficiaries");
		owner.put(info[0],"".equals(owner.get(info[0])) || owner.get(info[0]) == null ? "" :AESUtils.encrypt((String) owner.get(info[0])));
		owner.put(info[1],"".equals(owner.get(info[1])) || owner.get(info[1]) == null ? "" :AESUtils.encrypt((String) owner.get(info[1])));
		owner.put(info[2],"".equals(owner.get(info[2])) || owner.get(info[2]) == null ? "" :AESUtils.encrypt((String) owner.get(info[2])));
		for(Map<String, Object> cli : insureds) {
			cli.put(info[0],"".equals(cli.get(info[0])) || cli.get(info[0]) == null ? "" :AESUtils.encrypt((String) cli.get(info[0])));
			cli.put(info[1],"".equals(cli.get(info[1])) || cli.get(info[1]) == null ? "" :AESUtils.encrypt( (String) cli.get(info[1])));
			cli.put(info[2],"".equals(cli.get(info[2])) || cli.get(info[2]) == null ? "" :AESUtils.encrypt((String) cli.get(info[2])));
		}
		if(beneficiaries == null) return JSON.toJSONString(jsonStr);
		for(Map<String, Object> bnfy : beneficiaries) {
			bnfy.put(info[0],AESUtils.encrypt((String) bnfy.get(info[0])));
			bnfy.put(info[1],AESUtils.encrypt((String) bnfy.get(info[1])));
			bnfy.put(info[2],AESUtils.encrypt((String) bnfy.get(info[2])));
		}
		return JSON.toJSONString(jsonStr);
	}
	private void initDataInfo(PolicyBom policyBom, ResultBom resultBom, Map<String,String> policyInfo, List<Map<String,String>> ruleInfoList) {
		OwnerBom owner = policyBom.getOwnerBom();
		policyInfo.put(RuleConstants.POLICY_ORDER_ID, policyBom.getOrderId());
		policyInfo.put(RuleConstants.POLICY_THIRD_ID, policyBom.getThirdOrderId());
		policyInfo.put(RuleConstants.POLICY_CHANNELCATEGORY, policyBom.getChannelCategory());
		policyInfo.put(RuleConstants.POLICY_HASFIXEDTERMPLAN, "false");
		policyInfo.put(RuleConstants.POLICY_UWRESULTTYPE, policyBom.getResultBom().getUwResultType());
		
		policyInfo.put(RuleConstants.POLICY_O_NAME, AESUtils.encrypt(owner.getName()));
		policyInfo.put(RuleConstants.POLICY_O_ID_NUM, AESUtils.encrypt(owner.getIdNumber()));
		policyInfo.put(RuleConstants.POLICY_O_MOBILE_NUM, AESUtils.encrypt(owner.getMobilePhone()));
		
		for(RuleInfoBom info : resultBom.getRuleInfosBom()) {
			Map<String,String> ruleInfo = new HashMap<String, String>();
			ruleInfo.put(RuleConstants.RULEINFO_RULE_ID, info.getRuleId());
			ruleInfo.put(RuleConstants.RULEINFO_RULESETNAME, resultBom.getCurrentRuleSetName());
			ruleInfo.put(RuleConstants.RULEINFO_DESCRIPTION, info.getDescription());
			ruleInfo.put(RuleConstants.RULEINFO_RULESTATUS, info.getRuleStatus());
			ruleInfoList.add(ruleInfo);
		}
	}
}
