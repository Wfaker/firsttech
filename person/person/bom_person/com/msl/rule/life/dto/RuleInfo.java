package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 触发规则信息
 * 
 * @author zhou
 *
 */
public class RuleInfo implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 3291762646472837351L;

	// 属性
	private String ruleId = ""; // 规则名称
	private String ruleSetName = ""; // 规则库名称
	private String description = ""; // 规则话术
	private String ruleStatus = ""; // 规则类型
	private String claimTag = "";   //理赔标签
	
	// Getter && Setter
	
	public String getRuleId() {
		return ruleId;
	}
	public String getClaimTag() {
		return claimTag;
	}
	public void setClaimTag(String claimTag) {
		this.claimTag = claimTag;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleSetName() {
		return ruleSetName;
	}
	public void setRuleSetName(String ruleSetName) {
		this.ruleSetName = ruleSetName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuleStatus() {
		return ruleStatus;
	}
	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

}
