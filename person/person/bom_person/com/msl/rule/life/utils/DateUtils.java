/*
 * Copyright (c) 2018 - Firsttech & CCIC. All rights reserved.
 * Grant: This software can be used only granted by Firsttech or CCIC.
 */
package com.msl.rule.life.utils;


import java.util.*;
import java.util.regex.Pattern;
import java.text.*;

/**
 * 日期工具类
 * @author XiaoChen
 * 2017年12月20日
 */
public class DateUtils
{
	public static final Date NULL_DATE = getNullDate();

	public static final String DEFAULT_TIME_PATTERN = "yyyyMMdd HH:mm:ss";

	public static final String DEFAULT_DATE_PATTERN = "yyyyMMdd";
	
	public static Date parseDateFromString(String source) {
		DateFormat df = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		Date date = null;
		try {
			date = df.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getNullDate() {
		DateFormat df = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		try {
			return df.parse("9999-9-9");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(0);
	}
	
	
	/**
	 * 比较两个日期的大小（忽略小时）
	 * @param date1
	 * @param date2
	 * @return  若date1 > date2 则返回1
	 */ 
	public static int compareDate(Date date1, Date date2)
	{

		Calendar cal1 = getCalendarAtDateBegin(date1);
		Calendar cal2 = getCalendarAtDateBegin(date2);
		if (cal1.before(cal2))
			return -1;
		if (cal1.after(cal2))
			return 1;
		return 0;
	}

	/**
	 * 格式化 日期为 00:00:00
	 * @param date
	 * @return
	 */
	public static Calendar getCalendarAtDateBegin(Date date)
	{
		Calendar cal = getCalendar(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}


	public static Calendar getCalendar(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static Date getTime(String timeStr)
	{
		if(null == timeStr || timeStr.equals(""))
		{
			return null;
		}
		
		int length = timeStr.length();
		if(7 == length)
		{
			timeStr = timeStr + "-01 00:00:00";
		}
		if(10 == length)
		{
			timeStr = timeStr + " 00:00:00";
		}
		if(length > 7 && length < 10)
		{
			String str [] = timeStr.split("-");
			if(null == str || str.length != 3)
			{
				return null;
			}
			if(1 == str[1].length() )
			{
				str[1] = "0" + str[1];
			}
			if(1 == str[2].length() )
			{
				str[2] = "0" + str[2];
			}
			timeStr = str[0] + "-" + str[1] + "-" + str[2] + " 00:00:00";
		}
		
		
		String regex = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(timeStr).matches())
		{
			return null;
		}
	
		DateFormat format = new SimpleDateFormat(DEFAULT_TIME_PATTERN);
		try
		{
			return format.parse(timeStr);
		}
		catch(Exception e)
		{
			System.out.println("--------------------- DateUtils.getTime() ! ---------------------");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * <p><b>BOM描述: </b>帮助方法：{0, <日期1>}与{1, <日期2>}相差的天数（不足一天算一天）</p> 
	 * @return 获得两个日期间相差的天数(不足一天算一天)  
	 */
	public static int getAlmostDayRangeWithDay(Date beginDate, Date endDate)
	{
		if (beginDate == null || endDate == null)
		{
			return 0;
		}

		if (beginDate.after(endDate))
		{
			Date temp = beginDate;
			beginDate = endDate;
			endDate = temp;
		}

		Calendar calenderBegin = Calendar.getInstance();
		Calendar calenderEnd = Calendar.getInstance();

		calenderBegin.setTime(beginDate);
		calenderEnd.setTime(endDate);

		calenderBegin.set(Calendar.MILLISECOND, 0);
		calenderEnd.set(Calendar.MILLISECOND, 0);

		if (!calenderBegin.before(calenderEnd) && !calenderBegin.after(calenderEnd))
		{
			return 0;
		}

		int dayRange = 0;
		while (calenderBegin.before(calenderEnd))
		{
			calenderBegin.add(Calendar.DAY_OF_MONTH, 1);
			dayRange += 1;
		}
		return dayRange;
	}
}
