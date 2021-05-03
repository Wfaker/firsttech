package com.msl.rule.life.bom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.msl.rule.life.dto.Insured;

/**
 * 
 * 被保人
 * 
 * @author zhou
 *
 */
public class InsuredBom extends Insured implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 2225707822098433876L;

	// 属性
	private String provinceName = ""; // 地址名称(省)
	private String cityName = ""; // 地址名称(市)
	private String addressCityType = ""; // 地址(城市类型)
	private Integer monthIncome = 0; // 月收入
	private Double bmi = 0.0; // BMI
	private boolean interrelatedDeal = false; // 关联交易
	private boolean identityDoubt = false; // 身份存疑
	private boolean fraudInvestigation = false; // 与欺诈协查名单相同
//	private boolean fatca = false; // FATCA
	private boolean provinceInMsl = false; // 所在省在中宏业务经营区域内
	private String relationToOwnerName = ""; // 与投保人关系名称
	private PlanBom mainPlanBom = new PlanBom(); // 主险
	private PlanBom[] additionalPlansBom = new PlanBom[0]; // 附加险列表
	private RiskAmountBom riskAmountBom = new RiskAmountBom(); // 风险保额累计数据
	private AlphaSearchBom alphaSearchBom = new AlphaSearchBom(); // 保单历史数据
	private ClaimInfoBom[] claimInfo = new ClaimInfoBom[0];		//客户理赔史
	
	private RiskAmountBom currentRiskAmountBom = new RiskAmountBom(); // 当前风险保额列表
	
	
	// 中间属性
	private Map<String, String> searchItemMap = new HashMap<String, String>(); // 作为历史数据指标列表转换的中间变量，方便规则使用
	
	// Getter && Setter
	
	
	
	
	public String getProvinceName() {
		return provinceName;
	}
	public ClaimInfoBom[] getClaimInfo() {
		return claimInfo;
	}
	public void setClaimInfo(ClaimInfoBom[] claimInfo) {
		this.claimInfo = claimInfo;
	}
	public Integer getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(Integer monthIncome) {
		this.monthIncome = monthIncome;
	}
	public boolean isProvinceInMsl() {
		return provinceInMsl;
	}
	public void setProvinceInMsl(boolean provinceInMsl) {
		this.provinceInMsl = provinceInMsl;
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
	public String getAddressCityType() {
		return addressCityType;
	}
	public void setAddressCityType(String addressCityType) {
		this.addressCityType = addressCityType;
	}
	public Double getBmi() {
		return bmi;
	}
	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}
	public boolean isInterrelatedDeal() {
		return interrelatedDeal;
	}
	public void setInterrelatedDeal(boolean interrelatedDeal) {
		this.interrelatedDeal = interrelatedDeal;
	}
	public boolean isIdentityDoubt() {
		return identityDoubt;
	}
	public void setIdentityDoubt(boolean identityDoubt) {
		this.identityDoubt = identityDoubt;
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
	public PlanBom getMainPlanBom() {
		return mainPlanBom;
	}
	public void setMainPlanBom(PlanBom mainPlanBom) {
		this.mainPlanBom = mainPlanBom;
	}
	public PlanBom[] getAdditionalPlansBom() {
		return additionalPlansBom;
	}
	public void setAdditionalPlansBom(PlanBom[] additionalPlansBom) {
		this.additionalPlansBom = additionalPlansBom;
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
	public String getRelationToOwnerName() {
		return relationToOwnerName;
	}
	public void setRelationToOwnerName(String relationToOwnerName) {
		this.relationToOwnerName = relationToOwnerName;
	}
	public RiskAmountBom getCurrentRiskAmountBom() {
		return currentRiskAmountBom;
	}
	public void setCurrentRiskAmountBom(RiskAmountBom currentRiskAmountBom) {
		this.currentRiskAmountBom = currentRiskAmountBom;
	}
	
	
}
