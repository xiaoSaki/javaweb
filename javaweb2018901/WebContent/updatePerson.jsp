<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.UserDto" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/addstyle.css" type="text/css" rel="stylesheet" />

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
 <form name="form" action="addpersonServlet">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;添加读者</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a href="addstudent.html" target="mainFrame" onFocus="this.blur()" class="add">新增读者</a>
    </td>
  </tr>
  <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   //String aid=new String(request.getParameter("aid").getBytes("ISO-8859-1"));
       //String aid = request.getParameter("aid");
       UserDto s = null;
       Vector<UserDto> v = new Vector<UserDto> ();
       v = (Vector<UserDto>)session.getAttribute("user");
       Iterator it = v.iterator();
       while(it.hasNext())
       {
    	   s = (UserDto)it.next();
    %>
  <tr>
  
    <td align="left" valign="top">
   
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者编号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sid"  id="sid" class="text-word"  type="text"  value=<%=s.getAid()%> onFocus="this.value='';">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sname"  id="sname" class="text-word"  type="text" placeholder="请输入读者姓名" value="" onFocus="this.value='';">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者年龄：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sage"  id="sage" class="text-word"  type="text" placeholder="请输入读者年龄" value="" onFocus="this.value='';">
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
        <input name="Sclassid"  id="classid" class="text-word"  type="text" placeholder="请输入读者班别" value="" onFocus="this.value='';">
        </td>
        
         <td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">读者院系：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="Sdepartment"  id="dep" class="text-word"  type="text" placeholder="请输入读者院系" value="" onFocus="this.value='';">
        </td>
        
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="提交" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">
  <%
       }
  %>
        </div>
        </td>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>