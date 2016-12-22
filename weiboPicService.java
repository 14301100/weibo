package cn.edu.bjtu.weibo.service;

import java.io.File;
import java.util.List;

import cn.edu.bjtu.weibo.dao.WeiboDAO;
import cn.edu.bjtu.weibo.model.Weibo;

public class weiboPicService implements WeiboListService{
	
	@Override
	public boolean uploadWeiboPicture(String weiboId,
			MultipartFile multipartFile) {
		boolean fig;//判断是否上传成功
		 WeiboDAO weiboDao = new WeiboDAO();
		// 创建保存的文件的指定路径
		String path = "C:\\Users\\liu\\Desktop\\map_12_21_1\\img";
		// 获取该文件的文件名
		String fileName = multipartFile.getOriginalFilename();
		File targetFile = new File(path, fileName);
		String url=path+"\\"+fileName;
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			multipartFile.transferTo(targetFile);
			//存储url
			fig = weiboDao.insertWeiboPicture(weiboId,url); 
			return fig;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
