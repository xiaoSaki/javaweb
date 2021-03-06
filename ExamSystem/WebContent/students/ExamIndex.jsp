<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<script src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%
		HttpSession sess = request.getSession();
		int answer_status = 0;
		int exam_status = 0;
		int ans_id = 0;
		if(request.getAttribute("answer_status") != null){
			answer_status = Integer.valueOf(request.getAttribute("answer_status").toString());
		}
		if(request.getAttribute("exam_status") != null){
			exam_status = Integer.valueOf(request.getAttribute("exam_status").toString());
		}
		if(request.getAttribute("ans_id") != null){
			ans_id = Integer.valueOf(request.getAttribute("ans_id").toString());
		}
	
	if(answer_status == 1){
		%>
			 <script type="text/javascript">
				//window.location.href='main.html';
				var var1  = confirm("系统检测到您有未完成答题，您是否想要继续未完成答题？");
				if(var1 == true)
				{
					window.location.href='students/continues_answering';
				}
				else if(var1 == false)
				{
					var var2  = confirm("是否需要开始新的答题？");
					if(var2 == true){
						window.location.href='stu_test_exam?continues=0';
					}else if(var2 == false){	
					}
				}
			 </script>
		<%
	}else if(exam_status == 1){
		%>
			 <script type="text/javascript">
				alert("答题超时或不存在该测试");
						window.location.href='exam?pageNo=1';
			 </script>
		<%
	}
	sess.setAttribute("answer_status", 0);
	sess.setAttribute("exam_status", 0);
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
<div class="main">

	<p>任务提醒： </p>
		
</div>
<div id="container">
<div id="findstu">	
	<table class="providerTable" cellpadding="0" cellspacing="0"> 
		<c:forEach items="${requestScope.exam_info.list}" var="i">
			<tr>
	               <td width="50%">${i.exam_name}</td>             
	               <td width="30%"><a href="stu_test_exam?exam_id=${i.exam_id}">开始考试</a></td>     
	               <td width="50%">${i.finish_flag}</td>  
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