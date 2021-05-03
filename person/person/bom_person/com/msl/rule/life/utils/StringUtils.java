package com.msl.rule.life.utils;

public class StringUtils {
	/**
	 * 
	 * @param str
	 *            get from xml,html ...
	 * @return double
	 * 
	 */
	public static String getNullStringAsBlankStr(String str) {
		if ((str == null) || str == "" || str.trim().length() == 0) {
			return "";
		} else {
			return str;
		}
	}
}
