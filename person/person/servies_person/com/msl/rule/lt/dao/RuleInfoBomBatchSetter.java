package com.msl.rule.lt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.msl.rule.life.bom.RuleInfoBom;

public class RuleInfoBomBatchSetter implements BatchPreparedStatementSetter {
	
	long processId;
	
	List<RuleInfoBom> ruleInfosBom;

	public RuleInfoBomBatchSetter(long processId, List<RuleInfoBom> ruleInfosBom) {
		this.processId = processId;
		this.ruleInfosBom = ruleInfosBom;
	}
	
	@Override
	public int getBatchSize() {
		return ruleInfosBom.size();
	}

	@Override
	public void setValues(PreparedStatement ps, int listIndex) throws SQLException {
		RuleInfoBom ruleInfoBom = ruleInfosBom.get(listIndex);
		int dataIndex = 1;
		ps.setLong(dataIndex++, processId);
		ps.setString(dataIndex++, ruleInfoBom.getRuleId());
		ps.setString(dataIndex++, ruleInfoBom.getRuleSetName());
		ps.setString(dataIndex++, ruleInfoBom.getRuleStatus());
		ps.setString(dataIndex++, ruleInfoBom.getDescription());
	}

}
