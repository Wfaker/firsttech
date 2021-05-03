package com.msl.rule.life.bom;

import java.io.Serializable;

import com.msl.rule.life.dto.ClaimInfo;

public class ClaimInfoBom extends ClaimInfo implements Serializable{

	/**
	 * 索赔信息
	 */
	private static final long serialVersionUID = -7507677962375385102L;

	private String clmCd_G =""; //理赔类型
	private String clmReasnCd_G =""; //理赔原因，使用时有情况截取
	private String clmCd_I =""; //理赔类型
	private String clmReasnCd_I =""; //理赔原因，使用时有情况截取
	public String getClmCd_G() {
		return clmCd_G;
	}
	public void setClmCd_G(String clmCd_G) {
		this.clmCd_G =clmCd_G;
	}
	public String getClmReasnCd_G() {
		return clmReasnCd_G;
	}
	public void setClmReasnCd_G(String clmReasnCd_G) {
		this.clmReasnCd_G = clmReasnCd_G;
	}
	public String getClmCd_I() {
		return clmCd_I;
	}
	public void setClmCd_I(String clmCd_I) {
		this.clmCd_I = clmCd_I;
	}
	public String getClmReasnCd_I() {
		return clmReasnCd_I;
	}
	public void setClmReasnCd_I(String clmReasnCd_I) {
		this.clmReasnCd_I = clmReasnCd_I;
	}
	
	
	
	
	
	
	
	
	
}
