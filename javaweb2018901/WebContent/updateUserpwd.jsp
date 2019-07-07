<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.UserDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/addstyle.css" type="text/css" rel="stylesheet" />

<SCRIPT type="text/javascript">
//验证输入数据合法的函数
function check()
{
	if(form.user.value==""){
		alert("用户名不能为空");
		form.username.focus();
		return false;
	}
	if(form.password.value==""){
		alert("用户密码不能为空");
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
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;添加用户</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a href="adduser_info.html" target="mainFrame" onFocus="this.blur()" class="add">新增用户</a>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form name="form" action="updateUserpwd">
     <%
      
       Vector<UserDto> v = new Vector<UserDto> ();
       v = (Vector<UserDto>)session.getAttribute("pwd");
       Iterator it = v.iterator();
       UserDto s = null;
      
       
    %>

      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">用户名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input st yle="height:20px" type="text" name="Auser" id="user" value=<%=s.getAuser() %>></td>
        </td>
      </tr>
      
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">用户密码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input style="height:20px" type="text" name="Apassword" id="password" value=<%=s.getApassword()%>></td>
        </td>
      </tr>
     
   
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <div class="submit"><input value="确定" type="submit" name="submit" onClick="return check();" style="background: rgb(0, 142, 200); padding: 8px 12px; border-radius: 4px; border: 2px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">
        </div>
       
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>