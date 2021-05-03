package com.msl.rule.life.bom;

import java.io.Serializable;

/**
 * 
 * 保单历史数据
 * 
 * @author zhou
 *
 */
public class AlphaSearchBom implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 205706753066776061L;

	// 属性
	private String p100100011 = ""; // 保单核保类别
	private String p100100010 = ""; // 客户再核保保单检查
	private String c100100007 = ""; // 保单状态（长险）
	private String p100100008 = ""; // 保单主险加费
	private String p100100007 = ""; // 保单附加险加费
	private String p100200001 = ""; // 团险主险加费
	private String p100200002 = ""; //团险附加险加费
	private String p100100006 = ""; // 保单Follow_Up_Indicator
	private String p100100005 = ""; // Medical_Remark检查
	private String p100100004 = ""; // 保单Policy_Remark
	private String p100100003 = ""; // 保单POS_Change_Exist
	private String p100100043 = ""; // 理赔标志(含个团险)
	private String p100100042 = ""; // 在我司发生意外重大疾病轻症重疾保费豁免理赔
	private String H100100001 = ""; // 是否是高净值客户
	private String H100100003 = ""; // alpha search 有CI risk或Cancer risk保单有除外决定
	private String H100100004 = ""; // ACM理赔指标
	private String c100100010 = ""; // 保单状态（ACM）
	// Getter && Setter
	
	
	
	public String getC100100010() {
		return c100100010;
	}

	public void setC100100010(String c100100010) {
		this.c100100010 = c100100010;
	}

	public String getH100100001() {
		return H100100001;
	}

	public String getP100200002() {
		return p100200002;
	}

	public void setP100200002(String p100200002) {
		this.p100200002 = p100200002;
	}

	public String getH100100003() {
		return H100100003;
	}

	public void setH100100003(String h100100003) {
		H100100003 = h100100003;
	}

	public void setH100100001(String h100100001) {
		H100100001 = h100100001;
	}

	public String getP100100011() {
		return p100100011;
	}

	public void setP100100011(String p100100011) {
		this.p100100011 = p100100011;
	}

	public String getP100100010() {
		return p100100010;
	}

	public void setP100100010(String p100100010) {
		this.p100100010 = p100100010;
	}

	public String getC100100007() {
		return c100100007;
	}

	public void setC100100007(String c100100007) {
		this.c100100007 = c100100007;
	}

	public String getP100100008() {
		return p100100008;
	}

	public void setP100100008(String p100100008) {
		this.p100100008 = p100100008;
	}

	public String getP100100007() {
		return p100100007;
	}

	public void setP100100007(String p100100007) {
		this.p100100007 = p100100007;
	}

	public String getP100200001() {
		return p100200001;
	}

	public void setP100200001(String p100200001) {
		this.p100200001 = p100200001;
	}

	public String getP100100006() {
		return p100100006;
	}

	public void setP100100006(String p100100006) {
		this.p100100006 = p100100006;
	}

	public String getP100100005() {
		return p100100005;
	}

	public void setP100100005(String p100100005) {
		this.p100100005 = p100100005;
	}

	public String getP100100004() {
		return p100100004;
	}

	public void setP100100004(String p100100004) {
		this.p100100004 = p100100004;
	}

	public String getP100100003() {
		return p100100003;
	}

	public void setP100100003(String p100100003) {
		this.p100100003 = p100100003;
	}

	public String getP100100043() {
		return p100100043;
	}

	public void setP100100043(String p100100043) {
		this.p100100043 = p100100043;
	}

	public String getP100100042() {
		return p100100042;
	}

	public void setP100100042(String p100100042) {
		this.p100100042 = p100100042;
	}

	public String getH100100004() {
		return H100100004;
	}

	public void setH100100004(String h100100004) {
		H100100004 = h100100004;
	}

}
