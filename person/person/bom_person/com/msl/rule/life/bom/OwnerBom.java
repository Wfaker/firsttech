package com.msl.rule.life.bom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.msl.rule.life.dto.Owner;

/**
 * 
 * 投保人
 * 
 * @author zhou
 *
 */
public class OwnerBom extends Owner implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 7438531582068836595L;

	// 属性
	private String provinceName = ""; // 地址名称(省)
	private String cityName = ""; // 地址名称(市)
	private String riskLevel = ""; // 风险等级
	private boolean identityDoubt = false; // 身份存疑
	private boolean crs = false; // CRS
	private boolean fraudInvestigation = false; // 与欺诈协查名单相同
//	private boolean fatca = false; // FATCA
	private boolean hasBranchesAtProvince = false; // 投保所在省份有分支机构
	private boolean sameWithHistoryMobilePhone = false; // 与历史单手机号码有相同
	private boolean withinMSBusinessArea = false; // 中宏业务经营区域内
	private RiskAmountBom riskAmountBom = new RiskAmountBom(); // 风险保额累计数据
	private AlphaSearchBom alphaSearchBom = new AlphaSearchBom(); // 历史数据
	private String relationToInsuredName = ""; //投保人与被保人关系名称
	
	// 中间属性
	private Map<String, String> searchItemMap = new HashMap<String, String>(); // 作为历史数据指标列表转换的中间变量，方便规则使用
	
	public String getRelationToInsuredName() {
		return relationToInsuredName;
	}
	public void setRelationToInsuredName(String relationToInsuredName) {
		this.relationToInsuredName = relationToInsuredName;
	}
	// Getter && Setter
	public String getProvinceName() {
		return provinceName;
	}
	public boolean isHasBranchesAtProvince() {
		return hasBranchesAtProvince;
	}
	public void setHasBranchesAtProvince(boolean hasBranchesAtProvince) {
		this.hasBranchesAtProvince = hasBranchesAtProvince;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public boolean isIdentityDoubt() {
		return identityDoubt;
	}
	public void setIdentityDoubt(boolean identityDoubt) {
		this.identityDoubt = identityDoubt;
	}
	public boolean isCrs() {
		return crs;
	}
	public void setCrs(boolean crs) {
		this.crs = crs;
	}
	public boolean isFraudInvestigation() {
		return fraudInvestigation;
	}
	public void setFraudInvestigation(boolean fraudInvestigation) {
		this.fraudInvestigation = fraudInvestigation;
	}
//	public boolean isFatca() {
//		return fatca;
//	}
//	public void setFatca(boolean fatca) {
//		this.fatca = fatca;
//	}
	public boolean isSameWithHistoryMobilePhone() {
		return sameWithHistoryMobilePhone;
	}
	public void setSameWithHistoryMobilePhone(boolean sameWithHistoryMobilePhone) {
		this.sameWithHistoryMobilePhone = sameWithHistoryMobilePhone;
	}
	public boolean isWithinMSBusinessArea() {
		return withinMSBusinessArea;
	}
	public void setWithinMSBusinessArea(boolean withinMSBusinessArea) {
		this.withinMSBusinessArea = withinMSBusinessArea;
	}
	public RiskAmountBom getRiskAmountBom() {
		return riskAmountBom;
	}
	public void setRiskAmountBom(RiskAmountBom riskAmountBom) {
		this.riskAmountBom = riskAmountBom;
	}
	public AlphaSearchBom getAlphaSearchBom() {
		return alphaSearchBom;
	}
	public void setAlphaSearchBom(AlphaSearchBom alphaSearchBom) {
		this.alphaSearchBom = alphaSearchBom;
	}
	public Map<String, String> getSearchItemMap() {
		return searchItemMap;
	}
	public void setSearchItemMap(Map<String, String> searchItemMap) {
		this.searchItemMap = searchItemMap;
	}
	

}
