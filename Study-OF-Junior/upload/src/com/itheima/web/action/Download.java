package com.itheima.web.action;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Download extends ActionSupport {
	private InputStream inputStream;
	
	public String download() throws Exception{
		//1.找到一个路径
		String filePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/mei.png");
		//2.读到一个Stream中
		inputStream = new FileInputStream(filePath);
		//在返回之前，给filename赋值
				//filename="照片.jpg";		
		//3.返回一个成功
		return SUCCESS;
		//4.由一个叫做stream的结果类型为我们把剩下的事情做完。		
	}
	
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
