<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>章节练习</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ExamSys/css/public.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ExamSys/css/student.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/ExamSys/css/style.css" media="screen" />
</head>
<body>
	<%
		int answer_status = 0;
		int ans_id = 0;
		if(session.getAttribute("answer_status") != null){
			answer_status = Integer.valueOf(session.getAttribute("answer_status").toString());
		}
		if(session.getAttribute("ans_id") != null){
			ans_id = Integer.valueOf(session.getAttribute("ans_id").toString());
		}
	
		if(answer_status == 1){
	%>
			 <script type="text/javascript">
				//window.location.href='main.html';
				var var1  = confirm("系统检测到您有未完成答题，您是否想要继续未完成答题？");
				if(var1 == true)
				{
					window.location.href='continues_answering';
				}
			 </script>
	<%
		}
		session.setAttribute("answer_status", 0);
		session.setAttribute("ans_id", 0);
 	%>
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
	<div class="main"></div>
	<div id="container">
		<div id="findstu">
			<div
				style="font-size: 18px; text-align: center; font-family: 楷体; font-weight: bold;">
				<p style="color: red; margin: 0px;">注意事项</p>
				<p style="width: auto; display: inline-block; text-align: left; margin: 0px;">
					1：为保护你账户安全及正常使用，依据网络安全法的相关要求！<br>
					2：考生答题要注意，每次答题只有两次作答机会，答错两次，需要等待30分钟后方可重新登录考试！<br>
					3：请考生认真作答，切勿作弊！
				</p>
			</div>
		</div>
	</div>
</body>
</html>