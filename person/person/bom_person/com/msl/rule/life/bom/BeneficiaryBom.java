package com.msl.rule.life.bom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.msl.rule.life.dto.Beneficiary;

/**
 * 
 * 受益人
 * 
 * @author zhou
 *
 */
public class BeneficiaryBom extends Beneficiary implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 2464842795118872710L;

	// 属性
//	private boolean fatca = false; // FATCA
	private AlphaSearchBom alphaSearchBom = new AlphaSearchBom(); // 历史数据
	private String relationToInsuredName = ""; // 与主被保险人的关系名称
	
	// 中间属性
	private Map<String, String> searchItemMap = new HashMap<String, String>(); // 作为历史数据指标列表转换的中间变量，方便规则使用
	
	// Getter && Setter
//	public boolean isFatca() {
//		return fatca;
//	}
//	public void setFatca(boolean fatca) {
//		this.fatca = fatca;
//	}
	public AlphaSearchBom getAlphaSearchBom() {
		return alphaSearchBom;
	}
	public void setAlphaSearchBom(AlphaSearchBom alphaSearchBom) {
		this.alphaSearchBom = alphaSearchBom;
	}
	public Map<String, String> getSearchItemMap() {
		return searchItemMap;
	}
	public void setSearchItemMap(Map<String, String> searchItemMap) {
		this.searchItemMap = searchItemMap;
	}
	public String getRelationToInsuredName() {
		return relationToInsuredName;
	}
	public void setRelationToInsuredName(String relationToInsuredName) {
		this.relationToInsuredName = relationToInsuredName;
	}

}
