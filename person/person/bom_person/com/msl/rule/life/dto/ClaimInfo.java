package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 索赔信息
 * 
 * @author zhou
 *
 */
public class ClaimInfo implements Serializable {


	private static final long serialVersionUID = -7205648743110931112L;

	// 属性
	
	
	private String lob=""; //l-个险 ；G-团险
	private String polNum =""; //保单号
	private String clmCd =""; //理赔类型
	private String clmReasnCd =""; //理赔原因，使用时有情况截取
	private String clmRcvDt =""; //理赔收到日yyyymmdd
	private String hospInd =""; //住院发票标记
	
	
	
	
	
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String getPolNum() {
		return polNum;
	}
	public void setPolNum(String polNum) {
		this.polNum = polNum;
	}
	public String getClmCd() {
		return clmCd;
	}
	public void setClmCd(String clmCd) {
		this.clmCd = clmCd;
	}
	public String getClmReasnCd() {
		return clmReasnCd;
	}
	public void setClmReasnCd(String clmReasnCd) {
		this.clmReasnCd = clmReasnCd;
	}
	public String getClmRcvDt() {
		return clmRcvDt;
	}
	public void setClmRcvDt(String clmRcvDt) {
		this.clmRcvDt = clmRcvDt;
	}
	public String getHospInd() {
		return hospInd;
	}
	public void setHospInd(String hospInd) {
		this.hospInd = hospInd;
	}
	
	
	
	
	
	
	// Getter && Setter
	
	
	
	
}
