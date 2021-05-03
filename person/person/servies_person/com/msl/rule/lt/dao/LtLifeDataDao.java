package com.msl.rule.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.msl.rule.life.bom.PolicyBom;
import com.msl.rule.life.bom.ResultBom;
import com.msl.rule.life.bom.RuleInfoBom;
import com.mysql.jdbc.Statement;

/**
 * 
 * 日志记录数据层
 * 
 * @author zhou
 *
 */
@Repository
public class LtLifeDataDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	/**
//	 * 保存JSON报文表
//	 * @param jsonString
//	 * @return
//	 */
//	public long insertJsonData(String policyJsonString, Date beginTime) {
//		String sql = "insert into T_BRM_LT_LIFE_UW_PROCESS_JSON(IN_JSON, IN_TIME, EXECEPTION_FLAG) values(?, ?, 0)";
//		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, AESUtils.encrypt(policyJsonString));
//				ps.setTimestamp(2, new Timestamp(beginTime.getTime()));
//				return ps;
//			}
//		}, keyHolder);
//		
//		long jsonId = keyHolder.getKey().longValue();
//		
//		return jsonId;
//	}
	
	/**
	 * 保存JSON报文表
	 * @param policyJsonString
	 * @param responseJsonString
	 * @param beginTime
	 * @param endTime
	 * @param exceptionFlag
	 * @param exceptionMsg
	 * @return
	 */
	public long insertJsonData(String encryptPolicyJsonString, String encryptResponseJsonString, Date beginTime, Date endTime, int exceptionFlag, String exceptionMsg) {
		String sql = "insert into T_BRM_LT_LIFE_UW_PROCESS_JSON(IN_JSON, OUT_JSON, IN_TIME, OUT_TIME, EXECEPTION_FLAG, EXCEPTION_MSG) values(?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, encryptPolicyJsonString);
				ps.setString(2, encryptResponseJsonString);
				ps.setTimestamp(3, new Timestamp(beginTime.getTime()));
				ps.setTimestamp(4, new Timestamp(endTime.getTime()));
				ps.setInt(5, exceptionFlag);
				ps.setString(6, exceptionMsg);
				return ps;
			}
		}, keyHolder);
		
		long jsonId = keyHolder.getKey().longValue();
		
		return jsonId;
	}
	
//	/**
//	 * 更新Json报文表
//	 * @param jsonId
//	 * @param resultJsonString
//	 * @param exceptionFlag
//	 * @param exceptionMsg
//	 */
//	public void updateJsonData(long jsonId, String responseJsonString, Date endTime, int exceptionFlag, String exceptionMsg) {
//		String sql = "update T_BRM_LT_LIFE_UW_PROCESS_JSON set OUT_JSON=?, OUT_TIME=?, EXECEPTION_FLAG=?, EXCEPTION_MSG=? where id=?";
//		
//		Object[] params = new Object[] {
//				AESUtils.encrypt(responseJsonString),
//				new Timestamp(endTime.getTime()),
//				exceptionFlag,
//				exceptionMsg,
//				jsonId
//		};
//		
//		jdbcTemplate.update(sql, params);
//	}
	
	/**
	 * 保存主表基本信息
	 * @return
	 */
	public long insertBasicInfo(PolicyBom policyBom, ResultBom resultBom, long jsonId, Date beginTime, Date endTime, long jsonTime, long ruleTime, int exceptionFlag) {
		String sql = "insert into T_BRM_LT_LIFE_UW_PROCESS_LOG("
				+ "JSON_ID,ORDER_ID,THIRD_ORDER_ID,CHANNEL_CATEGORY,HAS_FIXED_TERM_PLAN,UW_RESULT_TYPE,BEGIN_TIME,ENDTIME,JSON_TIME,RULE_TIME,EXECEPTION_FLAG,TRACE_ID,POL_TYP"
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				int index = 1;
				ps.setLong(index++, jsonId);
				ps.setString(index++, policyBom.getOrderId());
				ps.setString(index++, policyBom.getThirdOrderId());
				ps.setString(index++, policyBom.getChannelCategory());
				ps.setInt(index++, policyBom.getPlanInfoBom().isHasFixedTermPlan() ? 1 : 0);
				ps.setString(index++, resultBom.getUwResultType());
				ps.setTimestamp(index++, new Timestamp(beginTime.getTime()));
				ps.setTimestamp(index++, new Timestamp(endTime.getTime()));
				ps.setLong(index++, jsonTime);
				ps.setLong(index++, ruleTime);
				ps.setInt(index++, exceptionFlag);
				ps.setString(index++, policyBom.getTraceId());
				ps.setInt(index++, policyBom.getTermType().equals("L") ? 1 : 4);
				return ps;
			}
		}, keyHolder);
		
		long processId = keyHolder.getKey().longValue();
		return processId;
	}
	
	/**
	 * 保存规则触发信息
	 * @param resultBom
	 * @param processId
	 */
	public void insertRuleResule(long processId, ResultBom resultBom) {
		String sql = "insert into T_BRM_LT_LIFE_UW_RULE_RESULT("
				+ "PROCESS_ID,RULE_ID,RULE_SET_NAME,RULE_STATUS,DESCRIPTION"
				+ ") values (?,?,?,?,?)";
		
		List<RuleInfoBom> ruleInfosBom = resultBom.getRuleInfosBom();
		if (ruleInfosBom != null && ruleInfosBom.size() > 0) {
			jdbcTemplate.batchUpdate(sql, new RuleInfoBomBatchSetter(processId, ruleInfosBom));
		}
	}
}
