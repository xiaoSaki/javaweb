package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {

	//表单上提供的字段
	private String username;
	private File photo;
	//struts2在文件上传时提供的属性
	private String photoFileName;//上传的文件名。上传字段名称+FileName  注意大小写
	private String photoContentType;//上传文件的MIME类型。上传字段名称+ContentType 注意大小写
	
	
	public String upload(){
		//1.拿到ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//2.调用realPath方法，获取根据一个虚拟目录得到的真实目录
		String filePath = application.getRealPath("/WEB-INF/files");
		//3.如果这个真实的目录不存在，需要创建
		/*此次的file的包导io流*/
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		//4.把photo存过去
		//拷贝：    。注意：临时文件还在
		//FileUtils.copyFile(photo, new File(file,photoFileName));
		
		//剪切：把临时文件剪切指定的位置，并且给他重命名。 注意：临时文件没有了
		photo.renameTo(new File(file,photoFileName));
		
		return "success";
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
}