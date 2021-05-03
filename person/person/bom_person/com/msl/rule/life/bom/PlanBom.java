package com.msl.rule.life.bom;

import java.io.Serializable;

import com.msl.rule.life.dto.Plan;

/**
 * 
 * 通用险种信息
 * 
 * @author Jie_Zhou_io
 *
 */
public class PlanBom extends Plan implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 4882543274810652770L;

	// 属性
	private String category = ""; // 险类
	

	// Getter && Setter
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
