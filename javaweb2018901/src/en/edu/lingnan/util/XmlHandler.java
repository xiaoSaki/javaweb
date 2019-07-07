package en.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {
	
	private StringBuffer sb = new StringBuffer();
	private HashMap<String,String> hm = new HashMap<String,String>(); 

	
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        //清空一个可变字符串
    	sb.delete(0, sb.length());
    }

    public HashMap<String, String> getHashMap() {
    	return hm;
		
	}

    
    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
        // 把可变字符串存到某个字符串中
    	hm.put(qName.toLowerCase(), sb.toString().trim());
    }

   

   
    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        //把读到的ch数组存到可变字符串中
    	sb.append(ch,start,length);
    }	
}
