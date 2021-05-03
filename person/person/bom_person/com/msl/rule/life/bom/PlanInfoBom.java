package com.msl.rule.life.bom;

import java.io.Serializable;

/**
 * 
 * 险种信息
 * 
 * @author zhou
 *
 */
public class PlanInfoBom implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 7145255484052551746L;
	
	// 属性
	private boolean hasLongTermPlan = false; // 有投保长险
	private boolean hasFixedTermPlan = false; // 有投保定寿险
	
	// Getter && Setter
	public boolean isHasLongTermPlan() {
		return hasLongTermPlan;
	}
	public void setHasLongTermPlan(boolean hasLongTermPlan) {
		this.hasLongTermPlan = hasLongTermPlan;
	}
	public boolean isHasFixedTermPlan() {
		return hasFixedTermPlan;
	}
	public void setHasFixedTermPlan(boolean hasFixedTermPlan) {
		this.hasFixedTermPlan = hasFixedTermPlan;
	}
	
}
