package com.zxh.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 解析request参数
 * 
 * @author zhaoxianhai 2018年4月3日
 * @version 1.0
 */
public class HttpServletRequestUtil {
	/**
	 * key解析为整形
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * key解析为Long
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static Long getLong(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1L;
		}
	}

	/**
	 * key解析为Double
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static Double getdDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	/**
	 * key解析为boolean
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 空格和空值处理
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getString(HttpServletRequest request, String key) {
		try {
			String result = request.getParameter(key);
			if (result != null) {
				//去除两边的空格
				result = result.trim();
			}
			if ("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
