package com.msl.rule.life.dto;

import java.io.Serializable;

import com.msl.rule.life.bom.OwnerBom;

/**
 * 当前保单
 * 
 * @author zhou
 *
 */
public class Policy implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 9098716122306220338L;

	// 属性
	private String traceId = ""; // 交易号
	private String orderId = ""; // 订单号
	private String thirdOrderId = ""; // 第三方订单号
	private String channelCategory = ""; // 渠道分类
	private String channelCode = ""; // 渠道
	private boolean beneficiaryLegal = false; // 法定受益人
	private String premiumPeriodType = ""; // 缴费方式
	private Integer premiumPeriodValue = 0; // 缴费期
	private Double policyTotalPremium = 0.0; // 保单总保费
	private Double premiumYear = 0.0; // 年缴保费
	private OwnerBom owner = new OwnerBom(); // 投保人
	private Insured[] insureds = new Insured[0]; // 被保人列表
	private Beneficiary[] beneficiaries = new Beneficiary[0]; // 受益人列表
	private Plan[] plans = new Plan[0]; // 险种列表
	private HealthNotification[] healthNotifications = new HealthNotification[0]; // 健康告知列表
	private String destination ="";//旅游目的地 
	private String effictiveDate="";//生效日期
	private boolean renewal=false;//是否连续投保
	private String termType ="";//长短险
	// 调试字段
	private int dataSaveMode = 1; // 1--数据保存，默认设置;3--不保存所有数据
	
	// Getter && Setter
	
	public String getOrderId() {
		return orderId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getEffictiveDate() {
		return effictiveDate;
	}
	public void setEffictiveDate(String effictiveDate) {
		this.effictiveDate = effictiveDate;
	}
	public boolean isRenewal() {
		return renewal;
	}
	public void setRenewal(boolean renewal) {
		this.renewal = renewal;
	}
	public String getTermType() {
		return termType;
	}
	public void setTermType(String termType) {
		this.termType = termType;
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
	public String getChannelCategory() {
		return channelCategory;
	}
	public void setChannelCategory(String channelCategory) {
		this.channelCategory = channelCategory;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public boolean isBeneficiaryLegal() {
		return beneficiaryLegal;
	}
	public void setBeneficiaryLegal(boolean beneficiaryLegal) {
		this.beneficiaryLegal = beneficiaryLegal;
	}
	public String getPremiumPeriodType() {
		return premiumPeriodType;
	}
	public void setPremiumPeriodType(String premiumPeriodType) {
		this.premiumPeriodType = premiumPeriodType;
	}
	public Integer getPremiumPeriodValue() {
		return premiumPeriodValue;
	}
	public void setPremiumPeriodValue(Integer premiumPeriodValue) {
		this.premiumPeriodValue = premiumPeriodValue;
	}
	public Double getPolicyTotalPremium() {
		return policyTotalPremium;
	}
	public void setPolicyTotalPremium(Double policyTotalPremium) {
		this.policyTotalPremium = policyTotalPremium;
	}
	public Double getPremiumYear() {
		return premiumYear;
	}
	public void setPremiumYear(Double premiumYear) {
		this.premiumYear = premiumYear;
	}
	public OwnerBom getOwner() {
		return owner;
	}
	public void setOwner(OwnerBom owner) {
		this.owner = owner;
	}
	public Insured[] getInsureds() {
		return insureds;
	}
	public void setInsureds(Insured[] insureds) {
		this.insureds = insureds;
	}
	public Beneficiary[] getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(Beneficiary[] beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public Plan[] getPlans() {
		return plans;
	}
	public void setPlans(Plan[] plans) {
		this.plans = plans;
	}
	public HealthNotification[] getHealthNotifications() {
		return healthNotifications;
	}
	public void setHealthNotifications(HealthNotification[] healthNotifications) {
		this.healthNotifications = healthNotifications;
	}
	public int getDataSaveMode() {
		return dataSaveMode;
	}
	public void setDataSaveMode(int dataSaveMode) {
		this.dataSaveMode = dataSaveMode;
	}
	

}
