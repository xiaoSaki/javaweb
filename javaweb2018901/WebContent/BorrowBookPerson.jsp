 <%@page import="en.edu.lingnan.Dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />


<SCRIPT type="text/javascript">
//验证输入数据合法的函数
function check()
{
	if(form.bbid.value==""){
		alert("图书Id不能为空");
		form.bbid.focus();
		return false;
	}
	if(form.bsid.value==""){
		alert("借阅编号不能为空");
		form.bsid.focus();
		return false;
	}
	if(form.borrowtime.value==""){
		alert("借阅时间为空");
		form.borrowtime.focus();
		return false;
	}
	if(form.returntime.value==""){
		alert("还书时间不能为空");
		form.returntime.focus();
		return false;
	}
	if(form.duetime.value==""){
		alert("到期时间不能为空");
		form.duetime.focus();
		return false;
	}
	if(form.mun.value==""){
		alert("借书数量不能为空");
		form.mun.focus();
		return false;
	}
	if(form.state.value==""){
		alert("还书状态不能为空");
		form.state.focus();
		return false;
	}
	if(form.fine.value==""){
		alert("罚款金额不能为空");
		form.fine.focus();
		return false;
	}
	}
</SCRIPT>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;修改用户信息</td>
     <tr><td  style="text-align:right; width:150px;font-size:14px;"><a style="text-align:right; width:150px;font-size:15px;" href="person_mian.html" target="mainFrame" onFocus="this.blur()">返回</a></td>
  </tr><tr>
      
  		 
  		
  <%  
  
 
  UserDto s = null;
  Vector<UserDto> v = new Vector<UserDto> ();
  v = (Vector<UserDto>)session.getAttribute("userinfo");
  Iterator it = v.iterator();
  String bsid = null;
  String bid = null;
  while(it.hasNext())
  {
	   s = (UserDto)it.next();
	  
	   bid=new String(request.getParameter("bid").getBytes("ISO-8859-1"));
	   System.out.println("----"+bid);
 %>
  
  <tr>
    <td align="left" valign="top">
    <form name="form" action="borrowBook_personServlet">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">图书编号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bbid"  id="bbid" class="text-word"  type="text" placeholder="" value=<%=bid%> ;">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">借阅者编号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bsid"   id="bsid" class="text-word"  type="text" placeholder="" value=<%=s.getAid() %> ;">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">借书时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bborrowtime"  id="borrowtime" class="text-word"  type="text" placeholder="借书时间" value="" onFocus="this.value='';">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">还书时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Breturntime"  readOnly="true" id="returntime" class="text-word"  type="text" placeholder="请输入还书时间" value="null" ';">
        </td>
        </tr>
        
        
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">到期时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bduetime"  id="duetime" class="text-word"  type="text" placeholder="请输入到期时间" value="" onFocus="this.value='';">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">借书数量：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bbmun"  id="mun" class="text-word"  type="text" placeholder="请输入借书数量" value="" onFocus="this.value='';">
        </td>
        </tr>
       
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">还书状态：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="Bbstate" id="state">
	    <option value="未归还" selected="Bbstate">&nbsp;&nbsp;未归还</option>
        </select>
        </td>
      </tr>
        
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">罚款金额：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Bfine"  id="fine" class="text-word"  type="text" placeholder="请输入罚款金额" value="" onFocus="this.value='';">
        </td>
        
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="提交" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">

        </div>
        </td>
        <%
  }
        %>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>