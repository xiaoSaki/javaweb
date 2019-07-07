<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到排课系统</title>
</head>
<body>
<div3 style="margin-top:50px;float:right">
	<form name="input" action="findAllClassScheduleInfoByClassIdServlet" method="get" style="margin-right:500px">
		班级号:<input type="text" name="ClassID">
			<input type="Submit" style="height:33px; width:75px" value="查询">
	</form>
</div3>

	<table border=1 align="center" valign="center" style="margin-top:50px" class="altrowstable" id="alternatecolor">
		<tr>
			<td></td><td>课程表号</td><td>班级号</td><td>课程号</td><td>上课教室</td><td>上课时间</td><td>授课老师</td><td>上课教室</td><td></td>
		</tr>
		<%
		Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
		v = (Vector<ClassScheduleDTO>)session.getAttribute("allClassScheduleinfobyClassID");
		Iterator it=v.iterator();		
		ClassScheduleDTO sc=null;
		while(it.hasNext()){
			sc=(ClassScheduleDTO)it.next();
			System.out.println("aaaaa");
		%>
		<tr>			
			<td><input type="checkbox" name="check" value=<%=sc.getClassScheduleID() %>></td>
			<td><%=sc.getClassScheduleID() %></td>
			<td><%=sc.getClassID() %></td>
			<td><%=sc.getCourseID() %></td>
			<td><%=sc.getWeekday() %></td>
			<td><%=sc.getClassTime() %></td>
			<td><%=sc.getTeacherId() %></td>
			<td><%=sc.getClassroomID() %></td>
			<td>
			<button ><a href="updateStudentInfo.jsp?ClassScheduleID=<%=sc.getClassScheduleID() %>">修改</a></button>
			<button ><a href="deleteClassScheduleInfoServlet?ClassScheduleID=<%=sc.getClassScheduleID() %>">删除</a></button>
			</td>
		</tr>
		<%
		 	}
		%>
	</table>

<style type="text/css">
table.altrowstable {
font-size:20px;
color:#333333;
border-width: 1px;
border-color: #a9c6c9;
border-collapse: collapse;
font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
text-align:center;
width:1050px;
height:400px;
}
table.altrowstable th {
border-width: 1px;
padding: 10px;
border-style: solid;
border-color: #a9c6c9;
}
table.altrowstable td {
border-width: 1px;
padding: 10px;
border-style: solid;
border-color: #a9c6c9;
}
.oddrowcolor{
background-color:#d4e3e5;
}
.evenrowcolor{
background-color:#c3dde0;
}
a{
	text-decoration: none;
	color:blue;
}

</style>
</body>
</html>