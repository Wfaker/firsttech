package com.msl.rule.life.bom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.msl.rule.life.dto.Result;

/**
 * 
 * 输出结果
 * 
 * @author zhou
 *
 */
public class ResultBom extends Result implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 3157050642737794525L;

	// 属性
	private List<RuleInfoBom> ruleInfosBom = new ArrayList<RuleInfoBom>(); // 规则触发信息列表
	private String currentRuleSetName = ""; // 当前规则库名称

	// Getter && Setter
	public String getCurrentRuleSetName() {
		return currentRuleSetName;
	}

	public List<RuleInfoBom> getRuleInfosBom() {
		return ruleInfosBom;
	}

	public void setRuleInfosBom(List<RuleInfoBom> ruleInfosBom) {
		this.ruleInfosBom = ruleInfosBom;
	}

	public void setCurrentRuleSetName(String currentRuleSetName) {
		this.currentRuleSetName = currentRuleSetName;
	}

	/**
	 * bom扩展方法：addUnderwriteRuleInfo  向{this}增加核保结果{0, <核保结果>}，规则描述: {1, <规则描述>}
	 * @param ruleId
	 * @param description
	 * @param ruleStatus
	 */
	public void addUnderwriteRuleInfoCommon(String ruleStatus, String ruleId, String description) {
		RuleInfoBom ruleInfoBom = new RuleInfoBom();
		ruleInfoBom.setRuleId(ruleId);
		ruleInfoBom.setRuleSetName(getCurrentRuleSetName());
		ruleInfoBom.setDescription(description);
		ruleInfoBom.setRuleStatus(ruleStatus);
		getRuleInfosBom().add(ruleInfoBom);
	}
	/**
	 * bom扩展方法：addUnderwriteRuleInfo  向{this}增加核保结果{0, <核保结果>}和理赔标记为{1,<历史标记>}，规则描述: {2, <规则描述>}
	 * @param ruleId
	 * @param description
	 * @param ruleStatus
	 */
	public void addUnderwriteRuleInfotoClaimTag(String ruleStatus,String claimTag, String ruleId, String description) {
		RuleInfoBom ruleInfoBom = new RuleInfoBom();
		ruleInfoBom.setClaimTag(claimTag);
		ruleInfoBom.setRuleId(ruleId);
		ruleInfoBom.setRuleSetName(getCurrentRuleSetName());
		ruleInfoBom.setDescription(description);
		ruleInfoBom.setRuleStatus(ruleStatus);
		getRuleInfosBom().add(ruleInfoBom);
	}

}
