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
	if(form.sid.value==""){
		alert("读者ID号不能为空");
		form.aid.focus();
		return false;
	}
	if(form.sname.value==""){
		alert("读者姓名不能为空");
		form.username.focus();
		return false;
	}
	if(form.sage.value==""){
		alert("读者年龄不能为空");
		form.password.focus();
		return false;
	}
	if(form.sex.value==""){
		alert("读者性别不能为空");
		form.password.focus();
		return false;
	}
	if(form.classid.value==""){
		alert("读者班别不能为空");
		form.password.focus();
		return false;
	}
	if(form.dep.value==""){
		alert("读者院系不能为空");
		form.password.focus();
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
    Vector<UserDto> v = new Vector<UserDto> ();
    Vector<StudentDto> v1 = new Vector<StudentDto> ();
    String aid = null;
    UserDto a = null;
    v = (Vector<UserDto>)session.getAttribute("pwd");
    Iterator it =v.iterator();
    while(it.hasNext())
    {
 	   a = (UserDto)it.next();
 	   aid=a.getAid();
    }
    StudentDao sdo = new  StudentDao();
	StudentDto s = null;
    v1 = sdo.findStudentByid(aid);
    Iterator it1 =v1.iterator();
 	  while(it1.hasNext())
 	  {
 		// StudentDto s = null; 
 		s=(StudentDto)it1.next();
 %>
  
  <tr>
    <td align="left" valign="top">
    <form name="form" action="updatepersonServlet">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者编号：</td>
         <td align="left" valign="middle" class="borderright borderbottom main-for">
      <input name="Sid"  id="sname" class="text-word"  type="text"  value=<%= s.getSid() %> >
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sname"  id="sname" class="text-word"  type="text"  value=<%= s.getStudentname() %> >
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者年龄：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sage"  id="sage" class="text-word"  type="text" placeholder="请输入读者年龄" value=<%= s.getStudentage() %> >
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">用户性别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="Ssex" id="sex">
	    <option value="男" selected="Ssex">&nbsp;&nbsp;男</option>
	    <option value="女" selected="Ssex">&nbsp;&nbsp;女</option>
        </select>
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者班别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sclassid"  id="classid" class="text-word"  type="text" value=<%= s.getStudentclass() %> >
        </td>
        
         <td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者院系：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sdepartment"  id="dep" class="text-word"  type="text"  value=<%= s.getStudentdep() %> >
        </td>
        
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="确定修改" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">

 <%
 	  
 	 
    }
    %>
        </div>
        </td>
   
</table>
</body>
</html>