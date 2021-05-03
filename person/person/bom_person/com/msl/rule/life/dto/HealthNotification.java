package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 健康告知
 * 
 * @author zhou
 *
 */
public class HealthNotification implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6630308624824675343L;
	
	// 属性
	private String code = ""; // 代码
	private String name = ""; // 名称
	private String value = ""; // 值
	
	// Getter && Setter
	public String getCode() {
		return code;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
