package com.msl.rule.life.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import com.msl.rule.life.bom.InsuredBom;
import com.msl.rule.life.bom.PlanBom;
import com.msl.rule.life.bom.PolicyBom;

/**
 * 
 * 帮助类
 * 
 * @author zhou
 *
 */
public class Helper {
//	/**
//	 * 帮助.{0}的证件号码出生日期
//	 * bom扩展方法：getBeneficiaryBirthdayFromIdNumber、getInsuredBirthdayFromIdNumber、getOwnerBirthdayFromIdNumber
//	 * 
//	 * @param obj
//	 * @return
//	 */
//	public static String getObjBirthdayFromIdNumber(Object obj) {
//		if (obj instanceof OwnerBom) { // 投保人
//			OwnerBom ownerBom = (OwnerBom) obj;
//			return getBirthdayFromIdNumber(ownerBom.getIdNumber(), ownerBom.getIdType());
//		} else if (obj instanceof InsuredBom) { // 被保人(主被保人、其他被保人)
//			InsuredBom insuredBom = (InsuredBom) obj;
//			return getBirthdayFromIdNumber(insuredBom.getIdNumber(), insuredBom.getIdType());
//		} else if (obj instanceof BeneficiaryBom) { // 受益人
//			BeneficiaryBom beneficiaryBom = (BeneficiaryBom) obj;
//			return getBirthdayFromIdNumber(beneficiaryBom.getIdNumber(), beneficiaryBom.getIdType());
//		}
//
//		return "";
//	}
	
	/**
	 * 从证件中获取出生日期
	 * 参考DIP逻辑
	 * 
	 * 扩展方法：帮助.{0}的出生日期与证件出生日期相同
	 * bom扩展方法：isOwnerBirthdaySameNumberBirthday、isBeneficiaryBirthdaySameNumberBirthday、isInsuredBirthdaySameNumberBirthday
	 * 
	 * @param idCard
	 * @param idType
	 * @return
	 */
	public static String getBirthdayFromIdNumber(String idCard, String idType) {
		if ("1".equals(idType)) { // 身份证
			return getBirthdayFromIdCard(idCard);
		} else if ("6".equals(idType)) { // 户口本
			return getBirthdayFromIdCard(idCard);
		}else if ("A".equals(idType)) {  //港澳居民居住证
			return getBirthdayFromIdCard(idCard);
		}else if ("C".equals(idType)){   //台湾居民居住证
			return getBirthdayFromIdCard(idCard);
		}
		// 其他证件留待扩展
		
		return "";
	}

	/**
	 * 从身份证中获取出生日期
	 * 参考DIP逻辑
	 * 
	 * @param idCard
	 * @return
	 */
//	@SuppressWarnings("deprecation")
	private static String getBirthdayFromIdCard(String idCard) {
//		String birthdayStr = idCard.substring(8, 14);
//		String yearStr = "20" + idCard.substring(8, 10);
//		if (Integer.parseInt(yearStr) > (new Date().getYear())) {
//			birthdayStr = "19" + birthdayStr;
//		} else {
//			birthdayStr = "20" + birthdayStr;
//		}

//		return birthdayStr;
		
		return idCard.substring(6, 14);
	}
	/**
	 * 
	 * 帮助.{0}的UTF-8编码字节长度小于等于{1}
	 * 参考DIP逻辑，校验数据库字段最大长度，防止溢出
	 * 
	 * @param str
	 *            校验字符串
	 * @param max
	 *            数据库字段最大长度
	 * @return true/false （符合/不符合）
	 */
	public static boolean checkDbLength(String str, Integer max) {
//		int valueLength = 0;
//		String chinese = "[\u0391-\uFFE5]";
//		/* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
//		for (int i = 0; i < str.length(); i++) {
//			/* 获取一个字符 */
//			String temp = str.substring(i, i + 1);
//			/* 判断是否为中文字符 */
//			if (temp.matches(chinese)) {
//				/* 中文字符长度为2 */
//				valueLength += 2;
//			} else {
//				/* 其他字符长度为1 */
//				valueLength += 1;
//			}
//		}
		
		try {
			
			int valueLength = str.getBytes("UTF-8").length;
			
			if (valueLength <= max) {
				return true;
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean Gbklenth(String str, Integer max) {
		try {
			
			int valueLength = str.getBytes("GBK").length;
			System.out.print(valueLength);
			if (valueLength <= max) {
				return true;
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
//	public static void main(String[] args) {
//		String str="一二三四五一二三四五一二三四五一二三四五一";
//		test(str,40);
//		System.out.print(test(str,40));
//	}
	
	
	/**
	 * 从证件中获取性别
	 * 参考DIP逻辑
	 * 
	 * 扩展方法：帮助.{0}的性别与证件性别相同
	 * isOwnerSexSameNumberSex、isBeneficiarySexSameNumberSex、isInsuredSexSameNumberSex
	 * 
	 * @param idCard
	 * @param idType
	 * @return
	 */
	public static String getSexFromIdNumber(String idCard, String idType) {
		if ("1".equals(idType)) { // 身份证
			return getSexFromIdCard(idCard);
		} else if ("6".equals(idType)) { // 户口本
			return getSexFromIdCard(idCard);
		}else if ("A".equals(idType)) {  //港澳居民居住证
			return getSexFromIdCard(idCard);
		}else if ("C".equals(idType)){   //台湾居民居住证
			return getSexFromIdCard(idCard);
		}
		// 其他证件留待扩展
		
		return "";
	}
	/**
	 * 从身份证中获取性别
	 * @return
	 */
	private static String getSexFromIdCard(String idCard) {
		String sexStr = "";
		if (idCard.length() == 15) {
			sexStr = idCard.substring(14, 15);
		} else {
			sexStr = idCard.substring(16, 17);
		}
		if (Integer.parseInt(sexStr) % 2 != 0) {
			return "M";
		} else {
			return "F";
		}
	}
	
	/**
	 * 帮助.{0}匹配正则表达式{1}
	 * bom暂不开放
	 * 
	 * 扩展方法：帮助.邮箱验证{0}格式正确
	 * isEmail
	 * 
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean isMatchRegular(String str, String regex) {
		return compile(str, regex);
	}
	
	/**
	 * 正则表达式比较器
	 * @param str
	 * @param regex
	 * @return
	 */
	private static boolean compile(String str, String regex) {
		if (str == null || "".equals(str)) {
			return false;
		} else {
			return Pattern.matches(regex, str);
		}
	}
	
	/**
	 * 帮助.{0}是{1}的倍数
	 * @param number
	 * @param multiple
	 * @return
	 */
	public static boolean isMultipleNumber(double number, double multiple) {
		if (number < multiple) {
			return false;
		} else {
			return number % multiple == 0 ? true : false;
		}
	}
	
	/**
	 * 帮助.{0}的前{1}位
	 * 
	 * 取字符串的前len位
	 * @param sourceStr
	 * @param len
	 * @return
	 */
	public static String getFirstSubString(String sourceStr, int len) {
		sourceStr = StringUtils.getNullStringAsBlankStr(sourceStr);
		
		if (len > sourceStr.length()) {
			return "";
		}
		
		return sourceStr.substring(0, len);
	}
	
	/**
	 * 
	 * 是否包含某些险种
	 * 
	 * 扩展方法：{this}的险种列表包含{0}
	 * 
	 * 扩展方法：{this}的险种列表包含{0, 一些险种}中的一个
	 * 
	 * @param policyBom
	 * @param planCodes
	 * @return
	 */
	public static boolean isContainPlanCode(PolicyBom policyBom, String...planCodes) {
		if (policyBom == null || planCodes.length == 0) {
			return false;
		}
		
		/**************************主被保人 start*****************************/
		if (isContainPlanCodeByInsured(policyBom.getMainInsuredBom(), planCodes)) {
			return true;
		}
		/**************************主被保人 end*****************************/
		
		
		/**************************其他被保人 start*****************************/
		InsuredBom[] otherInsuredsBoms = policyBom.getOtherInsuredsBom();
		if (otherInsuredsBoms.length > 0) {
			for (InsuredBom otherInsuredsBom : otherInsuredsBoms) {
				if (isContainPlanCodeByInsured(otherInsuredsBom, planCodes)) {
					return true;
				}
			}
		}
		/**************************其他被保人 end*****************************/
		
		return false;
	}

	/**
	 * 单个被保人是否包含某些险种
	 * 暂不提供给bom
	 * @param insuredBom
	 * @param planCodes
	 * @return
	 */
	private static boolean isContainPlanCodeByInsured(InsuredBom insuredBom, String... planCodes) {
		// 主险
		for (String planCode : planCodes) {
			PlanBom mainPlanBom =  insuredBom.getMainPlanBom();
			if (planCode.equals(mainPlanBom.getCode())) {
				return true;
			}
		}
		
		// 附加险
		PlanBom[] additionalPlansBoms = insuredBom.getAdditionalPlansBom();
		for (String planCode : planCodes) {
			for (PlanBom additionalPlansBom : additionalPlansBoms) {
				if (planCode.equals(additionalPlansBom.getCode())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 获取指定的指标值
	 * 
	 * 扩展方法：帮助.取得{0}的历史数据指标值的字符串类型(开发人员使用){1}
	 * bom扩展方法：getValueFromOwnerSearchItemTypeForDeveloper、getValueFromBeneficiarySearchItemTypeForDeveloper、getValueFromInsuredSearchItemTypeForDeveloper
	 * 
	 * @param searchItemMap
	 * @param type
	 * @return
	 */
	public static String getValueFromSearchItemTypeForDeveloper(Map<String, String> searchItemMap, String type) {
		String value = searchItemMap.get(type);
		value = value == null ? "" : value;
		return value;
	}
	
//	/**
//	 * 帮助.设置{0}的对象属性值的字符串名称{1}
//	 * @param fieldName
//	 * @param value
//	 */
//	public static void setObjectFieldValue(Object obj, String fieldName, String value) {
//		String jsonString = JSON.toJSONString(obj);
//		JSONObject jsonObject = JSON.parseObject(jsonString);
//		jsonObject.put(fieldName, value);
//		obj = JSON.parseObject(jsonObject.toJSONString(), obj.getClass());
//	}
	
	/**
	 * 
	 * 帮助.{0}保留{1}位小数
	 * 四舍五入
	 * 
	 * @param value
	 * @param place
	 * @return
	 */
	public static double round(double value, int place) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(place, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	
	/**
	 * 帮助.取大值{0}
	 * 取大值
	 * 
	 * @param valueArray
	 * @return
	 */
	public static double max(double...valueArray) {
		if (valueArray.length == 0) {
			return 0;
		} else if (valueArray.length == 1) {
			return valueArray[0];
		} else {
			double v1 = valueArray[0];
			BigDecimal b1 = new BigDecimal(v1);
			
			for (int i = 1; i < valueArray.length; i++) {
				double v2 = valueArray[i];
				BigDecimal b2 = new BigDecimal(v2);
				b1 = b1.max(b2);
			}
			
			return b1.doubleValue();
		}
	}

	
	/**
	 * 
	 * 两个证件号码相差的年数
	 * 
	 * 扩展方法：帮助.{0}与{1}生日差的年数
	 * bom扩展方法：getYearRange
	 * 
	 * @param birthday1
	 * @param birthday2
	 * @return
	 */
	public static int getYearRangeByRelationBirthday(String birthday1, String birthday2, String effictiveDate, String relation) {
		Date date1 = DateUtils.parseDateFromString(birthday1);
		Date date2 = DateUtils.parseDateFromString(birthday2);
		
		//date1是date2的父母
		if("04".equals(relation)&&date1.after(date2)) return 0;
		//date1是date2的子女
		else if("03".equals(relation)&&date1.before(date2)) return 0;
		
		if("04".equals(relation)) {
			return getYearRangeByBirthday(effictiveDate,birthday1)-getYearRangeByBirthday(effictiveDate,birthday2);
		}else if("03".equals(relation)) {
			return getYearRangeByBirthday(effictiveDate,birthday2)-getYearRangeByBirthday(effictiveDate,birthday1);
		}
		return 0;
	} 
	public static int getYearRangeByBirthday(String birthday1, String birthday2) {
		Date date1 = DateUtils.parseDateFromString(birthday1);
		Date date2 = DateUtils.parseDateFromString(birthday2);
		
		// 大小转换，calendar1必须晚于等于calendar2
		if (date1.before(date2)) {
			Date dateTemp = date1;
			date1 = date2;
			date2 = dateTemp;
		}
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		int year1 = calendar1.get(Calendar.YEAR);
		int year2 = calendar2.get(Calendar.YEAR);
		
		if (year1 == year2) { // 同年
			return 0;
		} else { // 非同年
			
			int month1 = calendar1.get(Calendar.MONTH);
			int month2 = calendar2.get(Calendar.MONTH);
			if (month1 > month2) { // 月份大
				
				return year1 - year2;
			} else if (month1 < month2) { // 月份小，要减1年
				
				return year1 - year2 - 1;
			} else { // 同月
				
				int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
				int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
				if (month1 != 2) { // 不为2月
					
					if (day1 >= day2) { // 天数大
						
						return year1 - year2;
					} else { // 天数小，要减1年
						
						return year1 - year2 - 1;
					}
				} else { // 2月
					
					if (day1 >= day2) { // 天数大
						
						return year1 - year2;
					} else {
						
						boolean leapYear1 = isLeapYear(year1);
						if (day1 == 28 && !leapYear1) { // 平年28和闰年的29一样大
							
							return year1 - year2;
						} else {
							
							return year1 - year2 - 1;
						}
					}
				}
			}
		}
	}
	
	/**
	 * 判断是否闰年
	 * @param year
	 * @return
	 */
	private static boolean isLeapYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, 2, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		return calendar.get(Calendar.DAY_OF_MONTH) == 29;
	}
	
	/**
	 * 计算预约生效日期天数
	 * @param arge
	 * @return
	 * 
	 * */
	
	
	public static Integer CalculateEffictiveDateDay(String arge) {
	    Integer Days=0;
	    DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	    String TimeToNow=simpleDateFormat.format(new Date());
	        try {
	            Date d1 = simpleDateFormat.parse(arge);
	            Date d2 = simpleDateFormat.parse(TimeToNow);
	            long diff = d1.getTime() - d2.getTime();
	            long days = diff / (1000 * 60 * 60 * 24);
	            Days = (int) days;	        
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

	    return Days;
	};
	
	
	/**
	 * 
	 * 计算多个风险历史数据的和
	 * @param 
	 * @return
	 * */
	public static double sunTerm(double... valueArray) {
	    BigDecimal sunterm = new BigDecimal(0.0D);
	    for (int i = 0; i < valueArray.length; i++) {
	      double v1 = valueArray[i];
	      BigDecimal b1 = new BigDecimal(v1);
	      sunterm = sunterm.add(b1);
	    } 
	    return sunterm.doubleValue();
	  }
    
    
 
//	public static void main(String[] args) {
//		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		 int[] p = dayComparePrecise("20180904", simpleDateFormat.format(new Date()));
//		 System.out.println(simpleDateFormat.format(new Date()));
//		 System.out.println(p[0]);
//		 System.out.println(p[1]);
//		 System.out.println(p[2]);
//	}
    /**
     * 
     *  计算两个年月日差的日期
     *@param
     *@return
     * 
     * **/
    
	 public static int[] dayComparePrecise(String fromDate, String toDate){
		    Date date1 = DateUtils.parseDateFromString(fromDate);
		    Date date2 = DateUtils.parseDateFromString(toDate);
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Period period = Period.between(LocalDate.parse(sdf.format(date1)), LocalDate.parse(sdf.format(date2)));
		    int[] num = {period.getYears(),period.getMonths(),period.getDays()}; 
	        return num;
	    }
	 
	 
	 

//    
    /**
	 * 校验身份证港澳台居住证号码第十八位
	 * @param idNum
	 * @return
	 */
	public static boolean caculationIdNumber(String idNum) {
		if(idNum.length() == 18) {
			int total = 0;
			int[] number = {7,9,10,5,8,4,2,1,6,3};
			String[] str = {"1","0","X","9","8","7","6","5","4","3","2"};
				for (int i=0,k=0;i<idNum.length()-1;i++,k++) {
					if(k==number.length) k=0;
					total = total + Integer.valueOf(idNum.substring(i,i+1))*number[k];
				}
			return str[total%11].equals(idNum.substring(17));
		}
		return false;
	}
    
}














