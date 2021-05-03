package com.msl.rule.life.bom;

public class RuleRepoConstants {
	
	/**
	 * 全局初始化规则库
	 */
	public static final String MSL_LIFE_UW_InitRules = "/MSL_LIFE_UW_InitRulesApp/MSL_LIFE_UW_InitRules";
	
	/**
	 * 全局通用规则库
	 */
	public static final String MSL_LIFE_UW_GeneralRules = "/MSL_LIFE_UW_GeneralRulesApp/MSL_LIFE_UW_GeneralRules";
	
	/**
	 * 长险通用规则库
	 */
	public static final String MSL_LT_LIFE_UW_GeneralRules = "/MSL_LT_LIFE_UW_GeneralRulesApp/MSL_LT_LIFE_UW_GeneralRules";
	
	/**
	 * 长险网销规则库
	 */
	public static final String MSL_LT_LIFE_UW_NetRules = "/MSL_LT_LIFE_UW_NetRulesApp/MSL_LT_LIFE_UW_NetRules";
	
	public static final String MSL_ST_LIFE_UW_NetRules="/MSL_ST_LIFE_UW_NetRulesApp/MSL_ST_LIFE_UW_NetRules";
	
	// 渠道分类
	//////////////////////////////////////////////////////
	public static final String CHANNEL_CATEGORY_AG = "AG"; // 代理人
	public static final String CHANNEL_CATEGORY_BA = "BA"; // 银行
	public static final String CHANNEL_CATEGORY_BK = "BK"; // 经纪
	public static final String CHANNEL_CATEGORY_CA = "CA"; // 专业代理
	public static final String CHANNEL_CATEGORY_DG = "DG"; // 网销
	public static final String CHANNEL_CATEGORY_DS = "DS"; // 直销
	public static final String CHANNEL_CATEGORY_TM = "TM"; // 电销
	public static final String CHANNEL_CATEGORY_TP = "TP"; // 电销渠道合作模式
	//////////////////////////////////////////////////////
	
	// 规则库输入变量名
	public static final String RULESET_INPUT_VAR_NAME = "input";
	
	// 规则库输出变量名
	public static final String RULESET_REULT_VAR_NAME = "result";
	
	// 核保结果
	//////////////////////////////////////////////////////
	public static final String UWResultType_STANDARD_ACCEPT = "STANDARD_ACCEPT"; // 核保通过
	public static final String UWResultType_REJECT = "REJECT"; // 拒保
	public static final String UWResultType_TO_MUNUAL = "TO_MUNUAL"; // 转人工核保
	public static final String UWResultType_EXCLUSIVE_ACCEPT = "EXCLUSIVE_ACCEPT"; // 除外责任承保
	public static final String UWResultType_EXTRA_PREM_ACCEPT = "EXTRA_PREM_ACCEPT"; // 加费承保
	//////////////////////////////////////////////////////

}
