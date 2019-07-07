<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.StudentDto"%>
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
   <form action="updateStudentServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：读者管理</td>
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
       <th align="center" valign="middle" class="borderright">姓名</th>
       <th align="center" valign="middle" class="borderright">年龄</th>
       <th align="center" valign="middle" class="borderright">性别</th>
       <th align="center" valign="middle" class="borderright">班别</th>
       <th align="center" valign="middle" class="borderright">学院</th>
    </tr>
    <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String sid=request.getParameter("sid");
       //String aid = request.getParameter("aid");
       Vector<StudentDto> v = new Vector<StudentDto> ();
       v = (Vector<StudentDto>)session.getAttribute("allstudent");
       Iterator it = v.iterator();
       StudentDto s = null;
       while(it.hasNext())
       {
    	   s = (StudentDto)it.next();
    	   System.out.println("-----------"+s.getSid());
    	   System.out.println("-------==="+sid);
    	  if((s.getSid()).equals(sid))
    	   {
    		  System.out.println("wwwwwww");
       
    %>
    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
    
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="sid" readOnly="true"  value=<%=s.getSid() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="sname" value=<%=s.getStudentname() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="sage" value=<%=s.getStudentage() %>></td>      
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="sex"   value=<%=s.getStudentsex()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="classid"   value=<%=s.getStudentclass()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px" type="text" name="dep"   value=<%=s.getStudentdep() %>></td>
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