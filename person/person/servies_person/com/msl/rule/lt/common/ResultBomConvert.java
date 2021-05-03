package com.msl.rule.lt.common;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.msl.rule.life.bom.ResultBom;
import com.msl.rule.life.bom.RuleInfoBom;
import com.msl.rule.life.dto.Result;
import com.msl.rule.life.dto.RuleInfo;

public class ResultBomConvert {
	
	/**
	 * 结果BOM转DTO
	 * @param resultBom
	 * @return
	 */
	public static Result convertResult(ResultBom resultBom) {
		Result result = new Result();
		BeanUtils.copyProperties(resultBom, result);
		
		List<RuleInfoBom> ruleInfosBom = resultBom.getRuleInfosBom();
		int length = ruleInfosBom.size();
		RuleInfo[] ruleInfos = new RuleInfo[length];
		for (int i = 0; i < length; i++) {
			RuleInfoBom ruleInfoBom = ruleInfosBom.get(i);
			RuleInfo ruleInfo = new RuleInfo();
			ruleInfo.setClaimTag(ruleInfoBom.getClaimTag());
			ruleInfo.setRuleId(ruleInfoBom.getRuleId());
			ruleInfo.setRuleSetName(ruleInfoBom.getRuleSetName());
			ruleInfo.setRuleStatus(ruleInfoBom.getRuleStatus());
			ruleInfo.setDescription(ruleInfoBom.getDescription());
			
			ruleInfos[i] = ruleInfo;
		}
		
		result.setRuleInfos(ruleInfos);
		return result;
	}
}
