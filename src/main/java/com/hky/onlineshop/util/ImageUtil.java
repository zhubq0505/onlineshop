package java.com.hky.onlineshop.util;

import java.com.hky.onlineshop.dto.ImageHolder;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ch.qos.logback.classic.Logger;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat DATE_FORMAT =new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random RANDOM = new Random();
	private static Logger logger = (Logger) LoggerFactory.getLogger(ImageUtil.class);
	
	/**
	 * 将CommonsMultipartFile转换成File
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}
	
	/**
	 * 处理缩略图并返回新生成图片的相对存储路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumnail(ImageHolder thumbnail, String targetAddr){
		//随机文件名
		String realFileName = getRandomFileName();
		//文件扩展名
		String extension = getFileExtension(thumbnail.getImageName());
		//创建所有相关目录
		makeDirPath(targetAddr);
		
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is:" + relativeAddr);
		// 绝对路径
		File dest = new File(PathUtil.getImgBasePath
				() + relativeAddr);
		logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try{
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")),0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch (IOException e) {
			logger.error(extension.toString());
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	/**
	 * 处理详情图并返回新生成图片的相对存储路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr){
		//随机文件名
		String realFileName = getRandomFileName();
		//文件扩展名
		String extension = getFileExtension(thumbnail.getImageName());
		//创建所有相关目录
		makeDirPath(targetAddr);
		
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is:" + relativeAddr);
		// 绝对路径
		File dest = new File(PathUtil.getImgBasePath
				() + relativeAddr);
		logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try{
			Thumbnails.of(thumbnail.getImage()).size(337, 640)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")),0.25f)
			.outputQuality(0.9f).toFile(dest);
		}catch (IOException e) {
			logger.error(extension.toString());
			throw new RuntimeException("创建详情图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	/**
	 * 生成随机文件名：当前时间 + 五位随机数
	 * @return
	 */
	public static String getRandomFileName(){
		int ranInt = RANDOM.nextInt(89999) + 10000;
		String nowTimeStr = DATE_FORMAT.format(new Date());
		return nowTimeStr + ranInt;
	}
	
	/**
	 * 获取输入文件的扩展名
	 * @param filename
	 * @return
	 */
	private static String getFileExtension(String filename){
		return filename.substring(filename.lastIndexOf("."));
	}
	
	/**
	 * 创建目标路径涉及到的所有目录，例如/home/zbq/images/xxx.jpg
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr){
		String realFileParantPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParantPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("F:\\images\\cxk.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("F:\\images\\cxknew.jpg");
	}
	
	/**
	 * 若storePath是文件路径则删除文件
	 * 若storePath是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath){
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if(fileOrPath.exists()){
			if(fileOrPath.isDirectory()){
				File files[] = fileOrPath.listFiles();
				for(int i = 0; i < files.length; i++){
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
