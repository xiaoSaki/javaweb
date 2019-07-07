<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.UserDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form action="updateUserServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
	         <span>管理员：</span>
	         <input type="text" name="" value="" class="text-word" style="height:23px">
	         <input name="" type="button" value="查询" class="text-but" style="height:23px; width:55px">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
    <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">账号</th>
        <th align="center" valign="middle" class="borderright">密码</th>
        <th align="center" valign="middle" class="borderright">权限</th>

      </tr>
    <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String aid=new String(request.getParameter("aid").getBytes("ISO-8859-1"));
       //String aid = request.getParameter("aid");
       Vector<UserDto> v = new Vector<UserDto> ();
       v = (Vector<UserDto>)session.getAttribute("alluser");
       Iterator it = v.iterator();
       UserDto s = null;
       while(it.hasNext())
       {
    	   s = (UserDto)it.next();
    	   System.out.println("-----------"+s.getAid());
    	   System.out.println("-------==="+aid);
    	  if((s.getAid()).equals(aid))
    	   {
    		  System.out.println("wwwwwww");
       
    %>
    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
    
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" readOnly="true" name="aid" value=<%=s.getAid()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="user" value=<%=s.getAuser()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="password" value=<%= s.getApassword()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="superuser" value=<%= s.getAsuperuser() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:72px;" type="submit" value="确定修改"></td>
       
    </tr>
    <%
    	  }
       } 
    %>
    </table>
    </form>
</body>
</html>