package en.edu.lingnan.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class target1 extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
	     try{
	    	 pageContext.getOut().print("Hello");
	    	 
	     }catch(Exception e){
	    	 e.printStackTrace();
	    	 
	     }
		return Tag.SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		return Tag.SKIP_PAGE;

}
}
