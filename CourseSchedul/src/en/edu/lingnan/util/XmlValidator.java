package en.edu.lingnan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	
	public static boolean validator(String xmlpath, String xsdpath)
	{
		boolean flag = false;
		String basepath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlpath = basepath+xmlpath;
		xsdpath = basepath+xsdpath;
		System.out.println(xmlpath);
		try {
			 //创建工厂模式
			  SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			//创建模式
			 File f = new File(xsdpath);
			 Schema s= sf.newSchema(f);
			 Validator v = s.newValidator();
			 Source xs = new StreamSource(xmlpath);
			 v.validate(xs);
			flag =  true;
			 
		} catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {

			System.out.println("xml文件验证失败！");
			e.printStackTrace();
		}
		return flag;
		
	}

//	public static void main(String[] args) {
//		String xmlpath = "database.conf.xml";
//		String xsdpath = "database.conf.xsd";
//		System.out.println(validator(xmlpath,xsdpath));
//
//	}

}
