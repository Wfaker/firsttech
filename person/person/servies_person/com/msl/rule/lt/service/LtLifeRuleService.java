package com.msl.rule.lt.service;

import static com.msl.rule.life.bom.RuleRepoConstants.CHANNEL_CATEGORY_DG;
import static com.msl.rule.life.bom.RuleRepoConstants.MSL_LIFE_UW_InitRules;
import static com.msl.rule.life.bom.RuleRepoConstants.MSL_LT_LIFE_UW_NetRules;
import static com.msl.rule.life.bom.RuleRepoConstants.MSL_ST_LIFE_UW_NetRules;
import static com.msl.rule.life.bom.RuleRepoConstants.RULESET_INPUT_VAR_NAME;
import static com.msl.rule.life.bom.RuleRepoConstants.RULESET_REULT_VAR_NAME;
import static com.msl.rule.life.bom.RuleRepoConstants.UWResultType_REJECT;
import static com.msl.rule.life.bom.RuleRepoConstants.UWResultType_STANDARD_ACCEPT;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.msl.rule.framework.service.RuleExecuteService;
import com.msl.rule.life.bom.PolicyBom;
import com.msl.rule.life.bom.ResultBom;
import com.msl.rule.life.bom.RuleInfoBom;

import ilog.rules.res.model.IlrFormatException;
import ilog.rules.res.session.IlrSessionException;

@Service
public class LtLifeRuleService {
	
	// 日志记录器
	private static Logger logger = LoggerFactory.getLogger(LtLifeRuleService.class);
	
	@Autowired
	private RuleExecuteService ruleExecuteService;
	
	/**
	 * 执行规则规则
	 * 
	 * @param policyBom
	 * @param resultBom
	 * @throws IlrFormatException
	 * @throws IlrSessionException
	 * @throws SQLException
	 */
	public void execRulesetUwAction(PolicyBom policyBom, ResultBom resultBom)
			throws IlrFormatException, IlrSessionException, SQLException {
		logger.info("开始执行规则库");
		System.out.println("policyBom:"+JSON.toJSONString(policyBom));
		// 执行全局初始化规则库
		executeRule(policyBom, resultBom, MSL_LIFE_UW_InitRules);
		
		// 打印初始化后的policyBom
//		if (SysConstants.isPrintPolicy()) {
//			String policyBomJsonString = JSON.toJSONString(policyBom);
//			logger.info("***********************print policyBom traceId=" + policyBom.getTraceId() + "***********************");
//			logger.info(policyBomJsonString);
//		}
		System.out.println("初始化后的policyBom"+JSON.toJSONString(policyBom));
		
		String termType=policyBom.getTermType();
		if ("L".equals(termType)) {
			// 执行全局通用规则库
//			executeRule(policyBom, resultBom, MSL_LIFE_UW_GeneralRules);
			// 执行长险通用规则库
//			executeRule(policyBom, resultBom, MSL_LT_LIFE_UW_GeneralRules);
			
			String channelCategory = policyBom.getChannelCategory();
			if (CHANNEL_CATEGORY_DG.equals(channelCategory)) {
				// 长险网销规则库
				executeRule(policyBom, resultBom, MSL_LT_LIFE_UW_NetRules);
			}
		}else if("S".equals(termType)) {
			//短险规则库
			executeRule(policyBom, resultBom, MSL_ST_LIFE_UW_NetRules);
		}
		
		logger.info("执行规则库结束");
		
		// 结果处理
		processResule(resultBom);
		
	}
	
	/**
	 * 结果处理
	 * 目前只有核保通过、拒保
	 * 
	 * @param resultBom
	 */
	private void processResule(ResultBom resultBom) {
		String uwResultType = UWResultType_STANDARD_ACCEPT; // 默认核保通过
		List<RuleInfoBom> ruleInfosBoms = resultBom.getRuleInfosBom();
		for (RuleInfoBom ruleInfoBom : ruleInfosBoms) {
			String ruleStatus = ruleInfoBom.getRuleStatus();
			
			if (UWResultType_REJECT.equals(ruleStatus)) {
				uwResultType = UWResultType_REJECT;
				break;
			}
		}
		
		resultBom.setUwResultType(uwResultType);
	}

	/**
	 * 
	 * @param policyBom
	 * @param ruleRepoPath 规则集路径
	 * @return
	 * @throws IlrFormatException
	 * @throws IlrSessionException
	 * @throws SQLException
	 */
	private ResultBom executeRule(PolicyBom policyBom, ResultBom resultBom, String ruleRepoPath)
			throws IlrFormatException, IlrSessionException, SQLException {
		String[] ruleSetNames = ruleRepoPath.split("/");
		if (ruleSetNames.length >= 2) {
			String currentRuleSetName = ruleSetNames[2];
			resultBom.setCurrentRuleSetName(currentRuleSetName);
		}
		return (ResultBom) ruleExecuteService.executeRules(RULESET_INPUT_VAR_NAME, RULESET_REULT_VAR_NAME, policyBom, ruleRepoPath);
	}
	
}
