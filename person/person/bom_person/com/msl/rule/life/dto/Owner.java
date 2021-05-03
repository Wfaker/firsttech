package com.msl.rule.life.dto;

import java.io.Serializable;

import com.msl.rule.life.bom.CustomerBom;

/**
 * 投保人
 * 
 * @author zhou
 *
 */
public class Owner extends CustomerBom implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = -8034879578751542673L;

	// 属性
//	private String name = ""; // 姓名
//	private String idType = ""; // 证件类型
//	private String idName = ""; // 证件类型名称
//	private String idNumber = ""; // 证件号码
	private Long yearlyIncome = 0L; // 年收入
	private String nationality = ""; // 国籍
	private String mobilePhone = ""; // 手机号码
//	private String birthday = ""; // 出生日期
	private String sexCode = ""; // 性别
	private String mail = ""; // 邮箱
	private String zipCode = ""; // 邮政编码
	private String province = ""; // 地址(省)
	private String city = ""; // 地址(市)
	private String address = ""; // 联系地址
//	private Integer ageYear = 0; // 年龄(年)
	private boolean interrelatedDeal = false; // 关联交易
	private boolean fraudInvestigation = false; // 与欺诈协查名单相同
	private SearchItem[] searchItems = new SearchItem[0]; // 历史数据指标列表
	private String relationToInsured =""; //投保人与被保人关系
	
	public String getRelationToInsured() {
		return relationToInsured;
	}
	public void setRelationToInsured(String relationToInsured) {
		this.relationToInsured = relationToInsured;
	}
	// Getter && Setter
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
	public Long getYearlyIncome() {
		return yearlyIncome;
	}
	public void setYearlyIncome(Long yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	

}
