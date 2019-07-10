<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史重现</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<script type="text/javascript">
	function unOnline() {
		alert("对不起，功能尚未上线");
	}
</script>
</head>

<body>

	<!-- header -->
	<div class="header">
		<p>
			学号：<%=session.getAttribute("user_id") %>
			&nbsp;&nbsp;姓名：<%=session.getAttribute("realname") %>
		</p>
		<div class="contact">
			<a href="logout" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出</a>
		</div>
	</div>
	<div class="header1">
		<p>生物考试系统</p>

		<div class="w1">您好，欢迎进入生物考试系统！</div>

		<div class="w2">
			<ul>
				<li><a href="StudentIndex.jsp">主页</a></li>
				<li><a href="exam?pageNo=1">考试</a></li>
				<li><a href="chapter">章节练习</a></li>
				<li><a href="record_exam?pageNo=1">考试答题记录</a></li>
				<li><a href="record_chapter?pageNo=1">测试答题记录</a></li>
			</ul>

		</div>

	</div>
<!-- header结束 -->
<div id="container">
<div id="findstu">	
	<table class="providerTable" cellpadding="0" cellspacing="0"> 
	          
		<c:forEach items="${requestScope.chapter_record.list}" var="i">
			<tr>
                <td width="50%">${i.exam_name}</td>             
                <td width="30%"><input type="button" value="点击查看" onclick="unOnline()"></td>   
                <td width="30%">答错：${i.error_sum}次</td>     
	      	</tr>
		</c:forEach>
            </table>
            
<div class="m3">
	<div class="paging"><a href="#">尾页</a></div>
	<div class="paging"><a href="#">下一页</a></div>
	<div class="paging"><a href="#">1</a></div>
	<div class="paging"><a href="#">上一页</a></div>
	<div class="paging"><a href="#">首页</a></div>
</div>	
</div>
</div>




</body>
</html>