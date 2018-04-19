package com.zxh.o2o.util;

/**
 * 路径工具类
 * 
 * @author zhaoxianhai 2018年4月3日
 * @version 1.0
 */
public class PathUtil {
	/**
	 *  获取文件分隔符
	 */
	private static String seperator = System.getProperty("file.separator");
	/**
	 * 获取图片根路径
	 * @return
	 */
	public static String getImgBasePath() {
		// 获取操作系统名称
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image/";
		} else {
			basePath = "/home/zhaoxianhai/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	/**
	 * 获取图片子路径
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId){
		String imagePath = "upload/item/shop/" + shopId +"/";
		return imagePath.replace("/", seperator);
	}
}
