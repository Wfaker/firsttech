package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 供数数据
 * 
 * @author zhou
 *
 */
public class SearchItem implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 1682926236445943237L;

	// 属性
	private String type = ""; // 类型
	private String value = ""; // 值

	// Getter && Setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
