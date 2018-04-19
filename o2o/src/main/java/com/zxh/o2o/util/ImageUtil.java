package com.zxh.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zxh.o2o.dto.ImageHolder;

import ch.qos.logback.classic.Logger;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片加水印处理
 * 
 * @author zhaoxianhai 2018年4月3日
 * @version 1.0
 */
public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random random = new Random();
	private static Logger log = (Logger) LoggerFactory.getLogger(ImageUtil.class);
	
	/**
	 * CommonsMultipartFile转为File
	 * @param cFile
	 * @return
	 */
	public static File transferConsMutilpartFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			log.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}
	/**
	 * 处理缩略图，并返回新生成的图片的相对路径
	 * @param thumbnail
	 * @param targerAddr
	 * @return
	 */
	public static String generateThumbnails(ImageHolder thumbnail,String targerAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtention(thumbnail.getImageName());
		makeDirPath(targerAddr);
		String realativeAddr = targerAddr + realFileName + extension;
		log.debug("current ralativeAddr is:" + realativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + realativeAddr);
		log.debug("current completeAddr  is:"+PathUtil.getImgBasePath() + realativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return realativeAddr;
	}
	/**
	 * 创建目标路径所涉及的目录
	 * 即："/home/zhaoxianhai/image/xxx.jpg"
	 * home、zhaoxianhai、image这三个文件夹自动创建
	 * @param targerAddr
	 * 
	 */
	private static void makeDirPath(String targerAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targerAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}


	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtention(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名，当前年月日时分秒+5位随机数
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机5位数
		int rannum = random.nextInt(99999) + 10000;
		String nowTime = sDateFormate.format(new Date());
		return nowTime + rannum;
	}
	
	

	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("C:/Users/Administrator/Desktop/img/zhuli.png")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("C:/Users/Administrator/Desktop/img/newzhuli.png");
	}
	/**
	 * 判断storePath是文件路径还是目录路径，
	 * 若storePath是文件路径则伤删除文件，
	 * 若storePath是目录路径，则删除目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File FileOrPath = new File(PathUtil.getImgBasePath() + 	storePath);
		if(FileOrPath.exists()) {
			if(FileOrPath.isDirectory()){
				File files[] = FileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			FileOrPath.delete();
		}
	}
}
