package com.msl.rule.life.dto;

import java.io.Serializable;

import com.msl.rule.life.bom.CustomerBom;

/**
 * 
 * 被保人
 * 
 * @author zhou
 *
 */
public class Insured extends CustomerBom implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = -7289266894723706033L;

	// 属性
	private Integer serialNum = 0; // 序号（用于判断主被保人）
//	private String name = ""; // 姓名
//	private String idType = ""; // 证件类型
//	private String idName = ""; // 证件类型名称
//	private String idNumber = ""; // 证件号码
	private String nationality = ""; // 国籍
	private String mobilePhone = ""; // 手机号码
//	private String birthday = ""; // 出生日期
	private String sexCode = ""; // 性别
	private String mail = ""; // 邮箱
	private String zipCode = ""; // 邮政编码
	private String provinceCode = ""; // 地址(省)
	private String cityCode = ""; // 地址(市)
	private String address = ""; // 联系地址
//	private Integer ageYear = 0; // 年龄(年)
	private String occupationCode = ""; // 职业代码
	private String occupationLevel = ""; // 职业等级
	private String occupationName=""; //职业名称
	private Long yearlyIncome = 0L; // 年收入
	private String relationToOwner = ""; // 与投保人关系
	private boolean blacklist = false; // 黑名单
	private Double height = 0.0; // 身高
	private Double weight = 0.0; // 体重
	private boolean interrelatedDeal = false; // 关联交易
	private boolean fraudInvestigation = false; // 与欺诈协查名单相同
	private SearchItem[] searchItems = new SearchItem[0]; // 历史数据指标列表
	private Integer insuredDays = 0; //年龄(天)
	private Integer insFirstAppDays = 0; //首次投保时的年龄（天）
	private Integer insFirstAppYears  = 0; //首次投保时的年龄（年）
	private String standardInd  = ""; //既往保单标准体判断
	private String passPortNo = ""; //护照号码
	private ClaimInfo[] claimInfos = new ClaimInfo[0]; //客户理赔记录	
	private SearchItem[] currentRisk = new SearchItem[0]; // 当前风险列表
	
	
	// Getter && Setter
	
	public Integer getSerialNum() {
		return serialNum;
	}
	
	public ClaimInfo[] getClaimInfos() {
		return claimInfos;
	}

	public void setClaimInfos(ClaimInfo[] claimInfos) {
		this.claimInfos = claimInfos;
	}

	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public String getPassPortNo() {
		return passPortNo;
	}
	public void setPassPortNo(String passPortNo) {
		this.passPortNo = passPortNo;
	}
	public Integer getInsuredDays() {
		return insuredDays;
	}
	public void setInsuredDays(Integer insuredDays) {
		this.insuredDays = insuredDays;
	}
	public Integer getInsFirstAppDays() {
		return insFirstAppDays;
	}
	public void setInsFirstAppDays(Integer insFirstAppDays) {
		this.insFirstAppDays = insFirstAppDays;
	}
	public Integer getInsFirstAppYears() {
		return insFirstAppYears;
	}
	public void setInsFirstAppYears(Integer insFirstAppYears) {
		this.insFirstAppYears = insFirstAppYears;
	}
	public String getStandardInd() {
		return standardInd;
	}
	public void setStandardInd(String standardInd) {
		this.standardInd = standardInd;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getIdType() {
//		return idType;
//	}
//	public void setIdType(String idType) {
//		this.idType = idType;
//	}
//	public String getIdName() {
//		return idName;
//	}
//	public void setIdName(String idName) {
//		this.idName = idName;
//	}
//	public String getIdNumber() {
//		return idNumber;
//	}
//	public void setIdNumber(String idNumber) {
//		this.idNumber = idNumber;
//	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
//	public String getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(String birthday) {
//		this.birthday = birthday;
//	}
	public String getSexCode() {
		return sexCode;
	}
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public Integer getAgeYear() {
//		return ageYear;
//	}
//	public void setAgeYear(Integer ageYear) {
//		this.ageYear = ageYear;
//	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getOccupationLevel() {
		return occupationLevel;
	}
	public void setOccupationLevel(String occupationLevel) {
		this.occupationLevel = occupationLevel;
	}
	public Long getYearlyIncome() {
		return yearlyIncome;
	}
	public void setYearlyIncome(Long yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}
	public String getRelationToOwner() {
		return relationToOwner;
	}
	public void setRelationToOwner(String relationToOwner) {
		this.relationToOwner = relationToOwner;
	}
	public boolean isBlacklist() {
		return blacklist;
	}
	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public boolean isInterrelatedDeal() {
		return interrelatedDeal;
	}
	public void setInterrelatedDeal(boolean interrelatedDeal) {
		this.interrelatedDeal = interrelatedDeal;
	}
	public boolean isFraudInvestigation() {
		return fraudInvestigation;
	}
	public void setFraudInvestigation(boolean fraudInvestigation) {
		this.fraudInvestigation = fraudInvestigation;
	}
	public SearchItem[] getSearchItems() {
		return searchItems;
	}
	public void setSearchItems(SearchItem[] searchItems) {
		this.searchItems = searchItems;
	}

	public SearchItem[] getCurrentRisk() {
		return currentRisk;
	}

	public void setCurrentRisk(SearchItem[] currentRisk) {
		this.currentRisk = currentRisk;
	}
	

}
