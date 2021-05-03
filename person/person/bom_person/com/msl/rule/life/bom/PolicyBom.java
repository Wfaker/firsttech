package com.msl.rule.life.bom;

import java.io.Serializable;

import com.msl.rule.life.dto.Policy;

/**
 * 
 * 当前保单
 * 
 * @author zhou
 *
 */
public class PolicyBom extends Policy implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = -3634291713948983865L;
	private String env = "";  // 运行环境

	// 属性
	private boolean hasLongTerm = false; // 有投保长险
	private OwnerBom ownerBom = new OwnerBom(); // 投保人
	private InsuredBom mainInsuredBom = new InsuredBom(); // 主被保人
	private InsuredBom[] otherInsuredsBom = new InsuredBom[0]; // 其他被保人列表
	private BeneficiaryBom[] beneficiariesBom = new BeneficiaryBom[0]; // 受益人列表
	private HealthNotificationBom[] healthNotificationsBom = new HealthNotificationBom[0]; // 健康告知列表
	private PlanInfoBom planInfoBom = new PlanInfoBom(); // 险种信息
	private CustomerBom[] allCustomersBom = new CustomerBom[0]; // 所有客户列表
	private PlanBom[] allPlansBom = new PlanBom[0]; // 所有险种列表
	private InsuredBom[] allInsuredsBom = new InsuredBom[0]; // 所有被保人列表
	private ResultBom resultBom = new ResultBom();  // 输出结果
	
	
	// Getter && Setter
	
	
	
	
	public CustomerBom[] getAllCustomersBom() {
		return allCustomersBom;
	}
	public void setAllCustomersBom(CustomerBom[] allCustomersBom) {
		this.allCustomersBom = allCustomersBom;
	}
	public PlanBom[] getAllPlansBom() {
		return allPlansBom;
	}
	public void setAllPlansBom(PlanBom[] allPlansBom) {
		this.allPlansBom = allPlansBom;
	}
	public InsuredBom[] getAllInsuredsBom() {
		return allInsuredsBom;
	}
	public void setAllInsuredsBom(InsuredBom[] allInsuredsBom) {
		this.allInsuredsBom = allInsuredsBom;
	}
	public boolean isHasLongTerm() {
		return hasLongTerm;
	}
	public void setHasLongTerm(boolean hasLongTerm) {
		this.hasLongTerm = hasLongTerm;
	}
	public OwnerBom getOwnerBom() {
		return ownerBom;
	}
	public void setOwnerBom(OwnerBom ownerBom) {
		this.ownerBom = ownerBom;
	}
	public InsuredBom getMainInsuredBom() {
		return mainInsuredBom;
	}
	public void setMainInsuredBom(InsuredBom mainInsuredBom) {
		this.mainInsuredBom = mainInsuredBom;
	}
	public InsuredBom[] getOtherInsuredsBom() {
		return otherInsuredsBom;
	}
	public void setOtherInsuredsBom(InsuredBom[] otherInsuredsBom) {
		this.otherInsuredsBom = otherInsuredsBom;
	}
	public BeneficiaryBom[] getBeneficiariesBom() {
		return beneficiariesBom;
	}
	public void setBeneficiariesBom(BeneficiaryBom[] beneficiariesBom) {
		this.beneficiariesBom = beneficiariesBom;
	}
	public ResultBom getResultBom() {
		return resultBom;
	}
	public void setResultBom(ResultBom resultBom) {
		this.resultBom = resultBom;
	}
	public HealthNotificationBom[] getHealthNotificationsBom() {
		return healthNotificationsBom;
	}
	public void setHealthNotificationsBom(HealthNotificationBom[] healthNotificationsBom) {
		this.healthNotificationsBom = healthNotificationsBom;
	}
	public PlanInfoBom getPlanInfoBom() {
		return planInfoBom;
	}
	public void setPlanInfoBom(PlanInfoBom planInfoBom) {
		this.planInfoBom = planInfoBom;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	

}
