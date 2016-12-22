package cn.edu.bjtu.weibo.service;

import java.io.File;
import java.util.List;

import cn.edu.bjtu.weibo.dao.WeiboDAO;
import cn.edu.bjtu.weibo.model.Weibo;

public class weiboPicService implements WeiboListService{
	
	@Override
	public boolean uploadWeiboPicture(String weiboId,
			MultipartFile multipartFile) {
		boolean fig;//�ж��Ƿ��ϴ��ɹ�
		 WeiboDAO weiboDao = new WeiboDAO();
		// ����������ļ���ָ��·��
		String path = "C:\\Users\\liu\\Desktop\\map_12_21_1\\img";
		// ��ȡ���ļ����ļ���
		String fileName = multipartFile.getOriginalFilename();
		File targetFile = new File(path, fileName);
		String url=path+"\\"+fileName;
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// ����
		try {
			multipartFile.transferTo(targetFile);
			//�洢url
			fig = weiboDao.insertWeiboPicture(weiboId,url); 
			return fig;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
