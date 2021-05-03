package com.msl.rule.lt.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.msl.rule.life.bom.PolicyBom;
import com.msl.rule.life.bom.ResultBom;
import com.msl.rule.life.dto.Policy;
import com.msl.rule.life.dto.Response;
import com.msl.rule.life.dto.Result;
import com.msl.rule.lt.common.DataSaveMode;
import com.msl.rule.lt.common.PolicyBomConvert;
import com.msl.rule.lt.common.ResultBomConvert;

@Service
public class LtLifeUwService {

	// 日志记录器
	private static Logger logger = LoggerFactory.getLogger(LtLifeUwService.class);

	@Autowired
	LtLifeRuleService ltLifeRuleService;
	
	@Autowired
	LtLifeLogService ltLifeLogService;

	/**
	 * 执行核保流程
	 * 
	 * @param policy
	 * @return
	 */
//	public Response getUnderWriteFlow(Policy policy) {
	public Response getUnderWriteFlow(String policyJsonString) {
		
		// json处理开始时间
		long beginTimeJson = System.currentTimeMillis();
		
		// json字符串转policy
		Policy policy = JSON.parseObject(policyJsonString, Policy.class);
		
//		logger.info("=======================Into Lt Life UW Service traceId=" + policy.getTraceId() + " orderId=" + policy.getOrderId() + " thirdOrderId=" + policy.getThirdOrderId() + "=======================");
//		
//		if (SysConstants.isPrintPolicy()) {
//			String policyJsonString = JSON.toJSONString(policy);
//			logger.info("***********************print policy traceId=" + policy.getTraceId() + "***********************");
//			logger.info(policyJsonString);
//		}
		
		// 异常标志 0-正常,1-异常
		int exceptionFlag = 0;
		
		// 异常信息
		String exceptionMsg = "";
		
		DataSaveMode dataSaveMode = new DataSaveMode(policy.getDataSaveMode());
//		// 保存JSON报文表
//		if (dataSaveMode.isSaveJson()) {
//			jsonId = saveJson(policy, beginTimeJson);
//		}

		Response response = new Response();
		
		PolicyBom policyBom = PolicyBomConvert.convert(policy);
		
		ResultBom resultBom = policyBom.getResultBom();
		
		// json处理结束时间
		long endTimeJson = System.currentTimeMillis();
		
		// 规则执行开始时间
		long beginTimeRule = System.currentTimeMillis();

		try {
			
			// 开始执行规则规则
			ltLifeRuleService.execRulesetUwAction(policyBom, resultBom);

		} catch (Exception e) {
			
			exceptionFlag = 1;
			
			// 将报错信息保存到日志里面
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			exceptionMsg = sw.toString();
			String exceptionSimpleName = e.getClass().getSimpleName();
			logger.error(exceptionMsg);
			
			// 将报错信息返回
			response.setStatusCode(Response.STATUS_CODE_ERROR);
			response.setErrMsg(e.getMessage());
			response.setErrorCode(exceptionSimpleName);

		} finally {
			// 规则执行结束时间
			long endTimeRule = System.currentTimeMillis();

			// 结果DTO
			Result result = new Result();
			result = ResultBomConvert.convertResult(resultBom);
			response.setData(result);
			
			long jsonTime = endTimeJson - beginTimeJson;
			long ruleTime = endTimeRule - beginTimeRule;
			
//			logger.info("Rule Execute Time:" + ruleTime);

			// 保存数据
			if (dataSaveMode.isSaveData()) {
				ltLifeLogService.saveDateToDB(policyJsonString, response, policyBom, resultBom, beginTimeRule, endTimeRule, jsonTime, ruleTime, exceptionFlag, exceptionMsg);
			}
			
//			// 更新JSON报文表
//			if (dataSaveMode.isSaveJson()) {
//				updateJson(jsonId, response, endTimeJson, exceptionFlag, exceptionMsg);
//			}
		}
		
//		logger.info("=======================Out Lt Life UW Service=======================");

		return response;
	}

	

//	/**
//	 * 保存json报文表
//	 * 
//	 * @param policy
//	 * @return
//	 */
//	private long saveJson(Policy policy, long beginTimeMillis) {
//		String policyJsonString = JSON.toJSONString(policy);
//		if (SysConstants.isPrintPolicy()) {
////			logger.info("***********************print policy orderId=" + policy.getOrderId() + " thirdOrderId=" + policy.getThirdOrderId() + "***********************");
////			logger.info(policyJsonString);
//		}
//		Date beginTime = new Date(beginTimeMillis);
//		return ltLifeDataDao.insertJsonData(policyJsonString, beginTime);
//	}

//	/**
//	 * 更新json报文表
//	 * 
//	 * @param jsonId
//	 * @param result
//	 * @param exceptionFlag
//	 * @param exceptionMsg
//	 */
//	private void updateJson(long jsonId, Response response, long endTimeMillis, int exceptionFlag, String exceptionMsg) {
//		String responseJsonString = JSON.toJSONString(response);
//		if (SysConstants.isPrintPolicy()) {
////			logger.info("***********************print response orderId=" + response.getData().getOrderId() + " thirdOrderId=" + response.getData().getThirdOrderId() + "***********************");
////			logger.info(responseJsonString);
//		}
//		Date endTime = new Date(endTimeMillis);
//		ltLifeDataDao.updateJsonData(jsonId, responseJsonString, endTime, exceptionFlag, exceptionMsg);
//	}
}
