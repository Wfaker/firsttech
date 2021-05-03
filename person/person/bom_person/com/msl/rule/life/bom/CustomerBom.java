package com.msl.rule.life.bom;

import java.io.Serializable;

/**
 * 
 *   通用客户信息
 * @author Jie_Zhou_io
 *
 */
public class CustomerBom implements Serializable {
	
	
	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 2882069097542686519L;
	
	// 属性
	private String name = ""; // 姓名
	private String idType = "null"; // 证件类型
	private	String idName = ""; // 证件类型名称
	private String idNumber = ""; // 证件号码
	private String birthday = ""; // 出生日期
	private Integer ageYear = 0; // 年龄(年)
	private boolean fatca = false; // FATCA
	private String pinyin="";//姓名拼音
	private String nationalityName=""; //国籍名称
	
	// Getter && Setter
	
	
	public String getName() {
		return name;
	}
	public String getNationalityName() {
		return nationalityName;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getAgeYear() {
		return ageYear;
	}
	public void setAgeYear(Integer ageYear) {
		this.ageYear = ageYear;
	}
	public boolean isFatca() {
		return fatca;
	}
	public void setFatca(boolean fatca) {
		this.fatca = fatca;
	}
	
}
