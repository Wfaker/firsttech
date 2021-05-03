package com.msl.rule.lt.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.msl.rule.life.bom.BeneficiaryBom;
import com.msl.rule.life.bom.ClaimInfoBom;
import com.msl.rule.life.bom.CustomerBom;
import com.msl.rule.life.bom.HealthNotificationBom;
import com.msl.rule.life.bom.InsuredBom;
import com.msl.rule.life.bom.PlanBom;
import com.msl.rule.life.bom.PolicyBom;
import com.msl.rule.life.dto.Beneficiary;
import com.msl.rule.life.dto.ClaimInfo;
import com.msl.rule.life.dto.HealthNotification;
import com.msl.rule.life.dto.Insured;
import com.msl.rule.life.dto.Plan;
import com.msl.rule.life.dto.Policy;
import com.msl.rule.life.dto.SearchItem;

public class PolicyBomConvert {
	
	public static String env = "";
	
	/**
	 * 保单DTO转BOM
	 * @param policy
	 * @return
	 */
	public static PolicyBom convert(Policy policy) {
		PolicyBom policyBom = new PolicyBom();
		BeanUtils.copyProperties(policy, policyBom);
		policy = null; // 赋值完成后，清除policy
		System.out.println("执行环境是："+env);
		policyBom.setEnv(env);
		List<PlanBom> allPlanListBom = new ArrayList<PlanBom>(); // 所有险种列表
		List<CustomerBom> allCustomerListBom = new ArrayList<CustomerBom>(); // 所有客户列表
		List<ClaimInfoBom> claimInfos = new ArrayList<ClaimInfoBom>();  //理赔列表
		
		if (policyBom != null) {
			BeanUtils.copyProperties(policyBom.getOwner(), policyBom.getOwnerBom());
			
		}
		
		// 投保人searchItems DTO -> searchItemMap中间变量
		if (policyBom.getOwnerBom().getSearchItems().length > 0) {
			Map<String, String> searchItemMap = new HashMap<String, String>();
			SearchItem[] searchItems = policyBom.getOwnerBom().getSearchItems();
			
			for (SearchItem searchItem : searchItems) {
				searchItemMap.put(searchItem.getType(), searchItem.getValue());
			}
			
			policyBom.getOwnerBom().setSearchItemMap(searchItemMap);
		}
		
		// 被保人 DTO -> BOM
		if (policyBom.getInsureds().length > 0 && policyBom.getPlans().length > 0) {
			// 主被保人
			InsuredBom mainInsuredBom = new InsuredBom();
			// 其他被保人列表
			List<InsuredBom> otherInsuredListBom = new ArrayList<InsuredBom>();
			
			
			Plan[] plans = policyBom.getPlans();
			Insured[] insureds = policyBom.getInsureds();
			
			
			
			// 主被保人
			flag: for (Plan plan : plans){
				// 只有一个主险
				// 只有一个主被保人
				// 主险对应主被保人
				if (plan.getMain()) { // 主被保人
					for (Insured insured : insureds) {
						if (plan.getInsuredSerialNum().intValue() == insured.getSerialNum().intValue()) {
							
							BeanUtils.copyProperties(insured, mainInsuredBom);
							for(ClaimInfo claimInfo:insured.getClaimInfos()){
								ClaimInfoBom infobom = new ClaimInfoBom();
								BeanUtils.copyProperties(claimInfo,infobom);
								if("I".equals(claimInfo.getLob())) {
									infobom.setClmCd_I(claimInfo.getClmCd());
									infobom.setClmReasnCd_I(claimInfo.getClmReasnCd());
								}else if("G".equals(claimInfo.getLob())){
									infobom.setClmCd_G(claimInfo.getClmCd());
									infobom.setClmReasnCd_G(claimInfo.getClmReasnCd());
								}
								claimInfos.add(infobom);
							}
							mainInsuredBom.setClaimInfo(claimInfos.toArray(new ClaimInfoBom[claimInfos.size()]));
							break flag;
							
						}
					}
				} 
				//
				
			}
			
			
			
			// 其他被保人
			for (Insured insured : insureds) {
				if (insured.getSerialNum().intValue() != mainInsuredBom.getSerialNum().intValue()) {
					InsuredBom otherInsuredBom = new InsuredBom();
					BeanUtils.copyProperties(insured, otherInsuredBom);
					for(ClaimInfo claimInfo:insured.getClaimInfos()){
						ClaimInfoBom infobom = new ClaimInfoBom();
						BeanUtils.copyProperties(claimInfo,infobom);
						if("I".equals(claimInfo.getLob())) {
							infobom.setClmCd_I(claimInfo.getClmCd());
							infobom.setClmReasnCd_I(claimInfo.getClmReasnCd());
						}else if("G".equals(claimInfo.getLob())){
							infobom.setClmCd_G(claimInfo.getClmCd());
							infobom.setClmReasnCd_G(claimInfo.getClmReasnCd());
						}
						claimInfos.add(infobom);
					}
					otherInsuredBom.setClaimInfo(claimInfos.toArray(new ClaimInfoBom[claimInfos.size()]));
					otherInsuredListBom.add(otherInsuredBom);
					
				}
				
			}	
			InsuredBom[] otherInsuredsBom = otherInsuredListBom.toArray(new InsuredBom[otherInsuredListBom.size()]);
			policyBom.setMainInsuredBom(mainInsuredBom);
			policyBom.setOtherInsuredsBom(otherInsuredsBom);
			
			// 所有被保人列表赋值，所有被保人与主被保人、其他被保人的对象之间有引用关系
			List<InsuredBom> allInsuredListBom = new ArrayList<InsuredBom>();  // 所有被保人列表
			allInsuredListBom.add(mainInsuredBom);
			allInsuredListBom.addAll(otherInsuredListBom);
			policyBom.setAllInsuredsBom(allInsuredListBom.toArray(new InsuredBom[allInsuredListBom.size()]));
			
//			// 测试
//			policyBom.getMainInsuredBom().setAddress("77777777777777777777777777777");
//			policyBom.getOtherInsuredsBom()[0].setAddress("0000000000000000000");
//			for (InsuredBom insuredBom : allInsuredListBom) {
//				System.out.println(insuredBom.getAddress());
//			}
		}
		
	
		List<PlanBom> shortMainPlans = new ArrayList<PlanBom>(); //短险险种列表
		
		
		// 主被保人险种 DTO -> BOM
		if (policyBom.getPlans().length > 0) {
			InsuredBom mainInsuredBom = policyBom.getMainInsuredBom();
			Plan[] plans = policyBom.getPlans();
			
			for (Plan plan : plans) {   
				if (plan.getInsuredSerialNum().intValue() == mainInsuredBom.getSerialNum().intValue()) {  //说明该险种属于主被保人
					
					if (plan.getMain()) { // 主险
						PlanBom mainPlanBom = new PlanBom();
						BeanUtils.copyProperties(plan, mainPlanBom);
						mainInsuredBom.setMainPlanBom(mainPlanBom);
						allPlanListBom.add(mainPlanBom);
					} else { // 附加险
						PlanBom additionalPlanBom = new PlanBom();
						BeanUtils.copyProperties(plan, additionalPlanBom);
						
						PlanBom[] additionalPlansBom = mainInsuredBom.getAdditionalPlansBom();
						List<PlanBom> additionalPlanListBom = new ArrayList<PlanBom>(additionalPlansBom.length);
						Collections.addAll(additionalPlanListBom, additionalPlansBom);
						additionalPlanListBom.add(additionalPlanBom);
						
						mainInsuredBom.setAdditionalPlansBom(additionalPlanListBom.toArray(new PlanBom[additionalPlanListBom.size()]));
					}
				}else if("S".equals(policyBom.getTermType())){
					PlanBom shortPlan = new PlanBom();
					BeanUtils.copyProperties(plan, shortPlan);
					shortMainPlans.add(shortPlan);
				}
			}
			
			
			// 所有险种列表赋值，所有险种与主险、附加险的对象之间有引用关系
			allPlanListBom.add(mainInsuredBom.getMainPlanBom());
			Collections.addAll(allPlanListBom, mainInsuredBom.getAdditionalPlansBom());
			if(shortMainPlans.size()>0) {
				PlanBom[] shortMainPlansAry = shortMainPlans.toArray(new PlanBom[shortMainPlans.size()]);
				Collections.addAll(allPlanListBom,shortMainPlansAry);
			}
			
		}
		
		// 其他被保人险种 DTO -> BOM
		if (policyBom.getPlans().length > 0) {
			InsuredBom[] otherInsuredsBom = policyBom.getOtherInsuredsBom();
			if (otherInsuredsBom.length > 0) {
				Plan[] plans = policyBom.getPlans();
				
				for (Plan plan : plans) {
					for (InsuredBom otherInsuredBom : otherInsuredsBom) {
						// 其他被保人没有主险
						if (plan.getInsuredSerialNum().intValue() == otherInsuredBom.getSerialNum().intValue() && !plan.getMain()) {
							PlanBom additionalPlanBom = new PlanBom();
							BeanUtils.copyProperties(plan, additionalPlanBom);
							
							PlanBom[] additionalPlansBom = otherInsuredBom.getAdditionalPlansBom();
							List<PlanBom> additionalPlanListBom = new ArrayList<PlanBom>(additionalPlansBom.length);
							Collections.addAll(additionalPlanListBom, additionalPlansBom);
							additionalPlanListBom.add(additionalPlanBom);
							
							otherInsuredBom.setAdditionalPlansBom(additionalPlanListBom.toArray(new PlanBom[additionalPlanListBom.size()]));
						}
					}
				}
				
				// 所有险种列表赋值，所有险种与主险、附加险的对象之间有引用关系
				// 其他被保人没有主险
				for (InsuredBom otherInsuredBom : otherInsuredsBom) {
					Collections.addAll(allPlanListBom, otherInsuredBom.getAdditionalPlansBom());
				}
			}
		}
		
		// 所有险种列表去重并装入policyBom
		// plancode相同的判断为重复
		if (allPlanListBom.size() > 0) {
			for (int i = 0; i < allPlanListBom.size() - 1; i++) {
				for (int j = allPlanListBom.size() -1 ; j > i; j--) {
					if (allPlanListBom.get(j).getCode().equals(allPlanListBom.get(i).getCode())
							&&allPlanListBom.get(j).getInsuredSerialNum() == allPlanListBom.get(i).getInsuredSerialNum()) {
						allPlanListBom.remove(j);
					}
				}
			}
			
			policyBom.setAllPlansBom(allPlanListBom.toArray(new PlanBom[allPlanListBom.size()]));
			
//			// 测试
//			policyBom.getMainInsuredBom().getMainPlanBom().setName("pppppppppppppppppppp");
//			policyBom.getMainInsuredBom().getAdditionalPlansBom()[0].setName("yyyyyyyyyyyyyyyyyyyyyyyy");
//			policyBom.getOtherInsuredsBom()[0].getAdditionalPlansBom()[0].setName("mmmmmmmmmmmmmmmm");
//			for (PlanBom planBom : policyBom.getAllPlansBom()) {
//				System.out.println(planBom.getName());
//			}
		}
		
		
		// 主被保人searchItems DTO -> searchItemMap中间变量
		if (policyBom.getMainInsuredBom().getSearchItems().length > 0) {
			Map<String, String> searchItemMap = new HashMap<String, String>();
			SearchItem[] searchItems = policyBom.getMainInsuredBom().getSearchItems();
			SearchItem[] currentRisk = policyBom.getMainInsuredBom().getCurrentRisk();
			
			for (SearchItem searchItem : searchItems) {
				searchItemMap.put(searchItem.getType(), searchItem.getValue());
			}
			for (SearchItem searchItem : currentRisk) {
				searchItemMap.put("CR"+searchItem.getType(), searchItem.getValue());
			}
			policyBom.getMainInsuredBom().setSearchItemMap(searchItemMap);
		}
		
		// 受益人 DTO -> BOM
		if (policyBom.getBeneficiaries().length > 0) {
			int length = policyBom.getBeneficiaries().length;
			BeneficiaryBom[] beneficiariesBom = new BeneficiaryBom[length];
			Beneficiary[] beneficiaries = policyBom.getBeneficiaries();
			
			for (int i = 0; i < length; i++) {
				BeneficiaryBom beneficiaryBom = new BeneficiaryBom();
				BeanUtils.copyProperties(beneficiaries[i], beneficiaryBom);
				beneficiariesBom[i] = beneficiaryBom;
			}
			
			policyBom.setBeneficiariesBom(beneficiariesBom);
		}
		
		// 受益人searchItems DTO -> searchItemMap中间变量
		if (policyBom.getBeneficiariesBom().length > 0) {
			BeneficiaryBom[] beneficiariesBom = policyBom.getBeneficiariesBom();
			
			for (BeneficiaryBom beneficiaryBom : beneficiariesBom) {
				if (beneficiaryBom.getSearchItems().length > 0) {
					Map<String, String> searchItemMap = new HashMap<String, String>();
					SearchItem[] searchItems = beneficiaryBom.getSearchItems();
					
					for (SearchItem searchItem : searchItems) {
						searchItemMap.put(searchItem.getType(), searchItem.getValue());
					}
					
					beneficiaryBom.setSearchItemMap(searchItemMap);
				}
			}
		}
		
		// 其他被保人searchItems DTO -> searchItemMap中间变量
		if (policyBom.getOtherInsuredsBom().length > 0) {
			InsuredBom[] otherInsuredsBom = policyBom.getOtherInsuredsBom();
			
			for (InsuredBom otherInsuredBom : otherInsuredsBom) {
				if (otherInsuredBom.getSearchItems().length > 0) {
					Map<String, String> searchItemMap = new HashMap<String, String>();
					SearchItem[] searchItems = otherInsuredBom.getSearchItems();
					SearchItem[] currentRisk = otherInsuredBom.getCurrentRisk();
					
					for (SearchItem searchItem : searchItems) {
						searchItemMap.put(searchItem.getType(), searchItem.getValue());
					}
					for (SearchItem searchItem : currentRisk) {
						searchItemMap.put("CR"+searchItem.getType(), searchItem.getValue());
					}
					
					otherInsuredBom.setSearchItemMap(searchItemMap);
				}
			}
		}
		
		// 健康告知 DTO -> BOM
		if (policyBom.getHealthNotifications().length > 0) {
			int length = policyBom.getHealthNotifications().length;
			HealthNotificationBom[] healthNotificationsBom = new HealthNotificationBom[length];
			HealthNotification[] healthNotifications = policyBom.getHealthNotifications();
			
			for (int i = 0; i < length; i++) {
				HealthNotificationBom healthNotificationBom = new HealthNotificationBom();
				
				BeanUtils.copyProperties(healthNotifications[i], healthNotificationBom);
				
				healthNotificationsBom[i] = healthNotificationBom;
			}
			
			policyBom.setHealthNotificationsBom(healthNotificationsBom);
		}
		
		
		// 所有客户列表组装、去重并装入policyBom
		// 证件号码相同的判断为重复
		allCustomerListBom.add(policyBom.getOwnerBom());
		allCustomerListBom.add(policyBom.getMainInsuredBom());
		if (policyBom.getOtherInsuredsBom().length > 0) {
			Collections.addAll(allCustomerListBom, policyBom.getOtherInsuredsBom());
		}
		if (policyBom.getBeneficiaries().length > 0) {
			Collections.addAll(allCustomerListBom, policyBom.getBeneficiariesBom());
		}
		if (allCustomerListBom.size() > 0) {
			for (int i = 0; i < allCustomerListBom.size() - 1; i++) {
				for (int j = allCustomerListBom.size() -1 ; j > i; j--) {
					if (allCustomerListBom.get(j).getIdNumber().equals(allCustomerListBom.get(i).getIdNumber())) {
						allCustomerListBom.remove(j);
					}
				}
			}
			
			policyBom.setAllCustomersBom(allCustomerListBom.toArray(new CustomerBom[allCustomerListBom.size()]));
		}
		
		
//		// 测试
//		policyBom.getOwnerBom().setBirthday("gggggggggggggggggggg");
//		policyBom.getMainInsuredBom().setBirthday("vvvvvvvvvvvvvvvvvvvvv");
//		policyBom.getOtherInsuredsBom()[0].setBirthday("nnnnnnnnnnnnnnnnnnnnn");
//		policyBom.getBeneficiariesBom()[0].setBirthday("bbbbbbbbbbbbbbbbbbb");
//		for (CustomerBom customerBom : policyBom.getAllCustomersBom()) {
//			System.out.println(customerBom.getBirthday());
//		}
		
		
		
		/*****************移除属性对象，方便测试，后续可注释 start*******************/
		policyBom.setOwner(null);
		policyBom.getOwnerBom().setSearchItems(null);
		policyBom.setInsureds(null);
		policyBom.getMainInsuredBom().setSearchItems(null);
		policyBom.setBeneficiaries(null);
		if (policyBom.getBeneficiariesBom().length > 0) {
			BeneficiaryBom[] beneficiariesBom = policyBom.getBeneficiariesBom();
			for (BeneficiaryBom beneficiaryBom : beneficiariesBom) {
				beneficiaryBom.setSearchItems(null);
			}
		}
		if (policyBom.getOtherInsuredsBom().length > 0) {
			InsuredBom[] otherInsuredsBom = policyBom.getOtherInsuredsBom();
			for (Insured otherInsuredBom : otherInsuredsBom) {
				otherInsuredBom.setSearchItems(null);
			}
		}
		policyBom.setHealthNotifications(null);
		policyBom.setPlans(null);
		/*****************移除属性对象，方便测试，后续可注释 end*******************/
		
		
		
		return policyBom;
	}
}
