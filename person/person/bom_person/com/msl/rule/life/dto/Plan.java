package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 险种
 * 
 * @author zhou
 *
 */
public class Plan implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 7554432867374421990L;

	// 属性
	private String code = ""; // 代码
	private String name = ""; // 名称
	private Integer version = 0; // 版本
	private Boolean main = false; // 是主险
	private Double faceAmount = 0.0; // 保额
	private Integer insuredSerialNum = 0; // 被保人序号（当与被保人序号相同时，说明该险种属于某个被保人，且属于该被保人为主被保人）
	private String benefitPeriodType = ""; // 保险期间类型
	private Integer benefitPeriodValue = 0; // 保险期间值
	private String productCode="";//产品代码
	private String socialInd="";//社保标识
	private Integer hisCvgCount = 0;  //历史ACM保单个数
	private Double hisCvgFaceAmt =0.0; //历史ACM保额累计（我司）
	private Double totalCvgFaceAmt =0.0; //历史ACM保额累计（其他公司）
	
	
	// Getter && Setter
	
	public String getProductCode() {
		return productCode;
	}
	public Double getTotalCvgFaceAmt() {
		return totalCvgFaceAmt;
	}
	public void setTotalCvgFaceAmt(Double totalCvgFaceAmt) {
		this.totalCvgFaceAmt = totalCvgFaceAmt;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCode() {
		return code;
	}
	public Integer getHisCvgCount() {
		return hisCvgCount;
	}
	public void setHisCvgCount(Integer hisCvgCount) {
		this.hisCvgCount = hisCvgCount;
	}
	public Double getHisCvgFaceAmt() {
		return hisCvgFaceAmt;
	}
	public void setHisCvgFaceAmt(Double hisCvgFaceAmt) {
		this.hisCvgFaceAmt = hisCvgFaceAmt;
	}
	public String getSocialInd() {
		return socialInd;
	}
	public void setSocialInd(String socialInd) {
		this.socialInd = socialInd;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Boolean getMain() {
		return main;
	}
	public void setMain(Boolean main) {
		this.main = main;
	}
	public Double getFaceAmount() {
		return faceAmount;
	}
	public void setFaceAmount(Double faceAmount) {
		this.faceAmount = faceAmount;
	}
	public Integer getInsuredSerialNum() {
		return insuredSerialNum;
	}
	public void setInsuredSerialNum(Integer insuredSerialNum) {
		this.insuredSerialNum = insuredSerialNum;
	}
	public String getBenefitPeriodType() {
		return benefitPeriodType;
	}
	public void setBenefitPeriodType(String benefitPeriodType) {
		this.benefitPeriodType = benefitPeriodType;
	}
	public Integer getBenefitPeriodValue() {
		return benefitPeriodValue;
	}
	public void setBenefitPeriodValue(Integer benefitPeriodValue) {
		this.benefitPeriodValue = benefitPeriodValue;
	}

}
