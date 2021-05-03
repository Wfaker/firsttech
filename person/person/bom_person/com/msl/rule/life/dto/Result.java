package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 输出结果
 * 
 * @author zhou
 *
 */
public class Result implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = -5146005160608249874L;

	// 属性
	private String traceId = ""; // 交易号
	private String orderId = ""; // 订单号
	private String thirdOrderId = ""; // 第三方订单号
	private String uwResultType = "STANDARD_ACCEPT"; // 核保结果--STANDARD_ACCEPT：核保通过(默认)；REJECT：拒保；TO_MUNUAL：转人工核保；EXCLUSIVE_ACCEPT：除外责任承保；EXTRA_PREM_ACCEPT：加费承保
	private RuleInfo[] ruleInfos = new RuleInfo[0]; // 规则触发信息列表
	
	// Getter && Setter
	
	public String getOrderId() {
		return orderId;
	}
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getThirdOrderId() {
		return thirdOrderId;
	}
	public void setThirdOrderId(String thirdOrderId) {
		this.thirdOrderId = thirdOrderId;
	}
	public String getUwResultType() {
		return uwResultType;
	}
	public void setUwResultType(String uwResultType) {
		this.uwResultType = uwResultType;
	}
	public RuleInfo[] getRuleInfos() {
		return ruleInfos;
	}
	public void setRuleInfos(RuleInfo[] ruleInfos) {
		this.ruleInfos = ruleInfos;
	}

}
