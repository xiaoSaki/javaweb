<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到排课系统</title>
<script>
function allcheck(){
		var checkObj=document.getElementsByName("check");
		for(var i=0;i<checkObj.length;i++)
			checkObj[i].checked=true;
	}
	function allnotcheck(){
		var checkObj=document.getElementsByName("check");
		for(var i=0;i<checkObj.length;i++)
			checkObj[i].checked=false;
	}
	function backcheck(){
		var checkObj=document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			if(checkObj[i].checked==true)
				checkObj[i].checked=false;
			else
				checkObj[i].checked=true;
	}
	function deleteCheck(){
		var checkObj=document.getElementsByName("check");
		var arr= [];
		var flag = false;
		for(var i=0; i<checkObj.length; i++){
			if(checkObj[i].checked==true){
				arr.push(checkObj[i].value);
				flag=true;
			}
		}
		alert(arr);
		if(flag == true){
			if(confirm("你确定要删除这些记录吗？"))
				location.href="deleteStudentInfoCheckServlet?arr="+arr;
		}else
			alert("你至少选择一条记录，再进行删除");
}
</script>
</head>
<body>

<div3 style="margin-top:50px;float:right">
	<button type="button"  id="button0">
	<a href="InsertClassSchedule.jsp" >添加</a>
	</button>
	
	<form name="input" action="findAllClassScheduleInfoByClassIdServlet" method="get" style="margin-right:500px">
		班级号:<input type="text" name="ClassID">
			<input type="Submit"  value="查询">
	</form>
</div3>

	<table border=1 align="center" valign="center" style="margin-top:50px" class="altrowstable" id="alternatecolor">
		<tr>
			<td></td><td>课程表号</td><td>班级号</td><td>课程号</td><td>上课教室</td><td>星期</td><td>第几节</td><td>授课老师</td><td>上课教室</td><td></td>
		</tr>
		<%
		Vector<ClassScheduleDTO> v=new Vector<ClassScheduleDTO>();
		v = (Vector<ClassScheduleDTO>)session.getAttribute("allClassScheduleInfo");//必须强制类型转换
		Iterator it=v.iterator();
		ClassScheduleDTO sc=null;
		while(it.hasNext()){
			sc=(ClassScheduleDTO)it.next();		
		%>
		<tr>			
			<td><input type="checkbox" name="check" value=<%=sc.getClassScheduleID() %>></td>
			<td><%=sc.getClassScheduleID() %></td>
			<td><%=sc.getClassID() %></td>
			<td><%=sc.getCourseID() %></td>
			<td><%=sc.getClassroomID() %></td>
			<td><%=sc.getWeekday()%></td>
			<td><%=sc.getClassTime()%></td>
			<td><%=sc.getTeacherId()%></td>
			<td><%=sc.getClassroomID()%></td>
			<td><a href="updateStudentInfo.jsp?ClassScheduleID=<%=sc.getClassScheduleID() %>">修改</a></td>
            <td><a href="deleteClassScheduleInfoServlet?ClassScheduleID=<%=sc.getClassScheduleID() %>">删除</a></td>
			
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
#button0 {  
        width: 80px;  
        padding:3px;  
        background-color: #428bca;  
        border-color: #357ebd;  
        color: #FFFFFF;  
        -moz-border-radius: 10px;  
        -webkit-border-radius: 10px;  
        border-radius: 10px; /* future proofing */  
        -khtml-border-radius:10px; /* for old Konqueror browsers */  
        text-align: center;
        vertical-align: middle;  
        border: 1px solid transparent;  
        font-weight: 100;  
        font-size:19px;
        margin-bottom:3px;
        float:right;
        margin-right:55px;         
      } 

</style>

	<br>
	<div style="margin-left:49%;">
	<input type="button"  id="button1" value="全选" onClick="allcheck();"/>
	<input type="button"  id="button1" value="不选" onClick="allnotcheck();"/>
	<input type="button"  id="button1" value="反选" onClick="backcheck();"/>
	<input type="button" id="button3" value="批量删除" onClick="deleteCheck();"/>
	</div>

</body>
</html>