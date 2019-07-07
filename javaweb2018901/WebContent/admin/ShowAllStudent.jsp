<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.StudentDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>读者信息更新</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
<script>
    function allcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked = true;
    }
    function allnotcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked = false;
    }
    function backcheck()
    {
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		if(checkobj[i].checked == true)
    			  checkobj[i].checked=false;
    		else
    			checkobj[i].checked=true;
    }
    function deletecheck()
    {
    	var checkobj = document.getElementsByName("check");
    	var arr=[];
    	var flag=false;
    	for(var i=0;i<checkobj.length;i++)
    		{
    		   if(checkobj[i].checked == true)
    			   {
    			   arr.push(checkobj[i].value);
    		       flag = true;
    		}
    		}
    	if(flag == true)
    		{
    		    if(confirm("你确定要删除这些记录吗？"))
    		    	   location.href="DeleteStucheckServlet?arr="+arr;
    		    	
    		}
    	else
    		alert("请至少选择一条记录，再删除");
    	
    }
    
</script>
</head>
<body>




<form action="findstudentByIdServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：读者管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	          <form  action="findstudentByIdServlet">
	         <span>管理员：</span>
	         <input type="text" name="Sid"  id="sid" class="text-word" style="height:23px" >
	         <input name="submit" type="submit" value="查询" class="text-but" style="height:23px; width:55px">
	         </form>
	         <input type="button" style="height:23px;width:55px;margin-left:100px" id="btn1" value="全选" onClick="allcheck();"/>
             <input type="button" style="height:23px;width:55px;margin-left:30px" id="btn2" value="不选" onClick="allnotcheck();"/>
             <input type="button" style="height:23px;width:55px;margin-left:30px" id="btn3" value="反选" onClick="backcheck();"/>
             <input type="button" style="height:23px;width:64px;margin-left:30px" id="btn2" value="批量删除" onClick="deletecheck();"/>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="adduser_info.html" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
    <tr>
        <td></td>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">姓名</th>
        <th align="center" valign="middle" class="borderright">年龄</th>
        <th align="center" valign="middle" class="borderright">性别</th>
        <th align="center" valign="middle" class="borderright">班别</th>
        <th align="center" valign="middle" class="borderright">学院</th>
        <th align="center" valign="middle">操作</th>
        <th valign="middle">操作</th>
      </tr>
    <%
       Vector<StudentDto> v = new Vector<StudentDto> ();
       v = (Vector<StudentDto>)session.getAttribute("allstudent");
       Iterator it = v.iterator();
       StudentDto s = null;
       while(it.hasNext())
       {
    	   s = (StudentDto)it.next();
    %>
    <tr>
       <td align="center" valign="middle" class="borderright borderbottom"><input type="checkbox" name="check" value="<%= s.getSid() %>"></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getSid() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentname() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentage() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentsex() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentclass() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= s.getStudentdep() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="UpdateStudent.jsp?sid=<%=s.getSid()%>">修改</a></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="deleteStudentServlet?sid=<%=s.getSid()%>">删除</a></td>
    </tr>
    <% 
       }
    %>
    
    </table>
    </form>
</body>
</html>