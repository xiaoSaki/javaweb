<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.Timestamp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.top_div{
    top:180px;
	font-size:30px;
	font-weight:bold;
	text-align:center;
}
.content_div{
	width: 100%;
	height: 100%;
}
.left_div{
	display: inline-block;
	position: relative;
	margin-left:160px;
    width: 400px;
    height: auto;
}
.right_div{
	display: inline-block;
	vertical-align: top; 
	position: relative;
	margin-left:160px;
	margin-top:30px;
	width: 400px;
    height: auto;
    border: 1px solid #d3d3d3;
}
.ipt{
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 60%;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
}
.ipt:focus{
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
	box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
}
.foot_div{
    margin-top:60px;
	font-size:14px;
	text-align:center;
}
</style>
<body>
<c:if test="${requestScope.supervalue == 0 }">
			<script>
			alert('对不起，您输入的用户名或密码错误。')
			</script>
</c:if>

<c:if test="${requestScope.lock_status == 1 }">
			<script>
			alert('对不起！您的账号暂时被冻结，解冻时间为${requestScope.unlock_time}')
			</script>
</c:if>
<%--
	if(session.getAttribute("lock_status") != null){
		int lock_status = Integer.valueOf(session.getAttribute("lock_status").toString());
		if(lock_status == 1){
			%>
			<script>
			alert('对不起！您的账号暂时被冻结，解冻时间为<%=session.getAttribute("unlock_time")%>')
			</script>
			<%
			session.invalidate();
		}else if(request.getAttribute("supervalue") == 0){
			int supervalue = Integer.valueOf(session.getAttribute("supervalue").toString());
			if(supervalue == 0){
				%>
				<script>
				alert('用户名或密码错误')
				</script>
				<%
				session.invalidate();
			}
		}
	}
--%>
<div class="top_div">
	<p style="text-align:center; ">欢迎使用学生考试系统</p>
</div>
<div class="content_div">
	<div class="left_div">
		<img alt="" src="img/login.JPG" style="width:300px;height: auto;">
		<div style="font-size:18px;text-align:center;font-family:楷体;font-weight:bold;" >
			<p style="color:red;margin:0px;" >注意事项</p>
			<p style="width:auto;display:inline-block;text-align:left; margin:0px;">
			1：为保护你账户安全及正常使用，依据网络安全法的相关要求！<br>
			2：考生答题要注意，每道题只有两次作答机会，一道题连续答错两次，需要三小时后重新登录考试！<br>
			3：请考生认真作答，切勿作弊！</p>
		</div>
	</div>
	
	<div class="right_div">
		<form action="login" method="post">
			<P style="text-align:center;font-size:24px;font-weight:bold;">
			登&nbsp;录
			</P>
			<P style="padding: 20px 35px 10px 45px; position: relative;">
				账号：
				<INPUT name="username" class="ipt" type="text" placeholder="请输入用户帐号" onkeyup="value=value.replace(/[^\d]/g,'')" value="2016834101" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" > 
			 </P>
			<P style="padding: 0px 35px 10px 45px; position: relative;">
				密码：     
				<INPUT class="ipt" name="password" type="password" placeholder="请输入密码" value="" onfocus="this.value = '123456';" onblur="if (this.value == '') {this.value = '';}">  
			</P>
			<P style="padding: 0px 0px 0px 100px; position: relative;">
		       <input type="submit" style="background:#00FF00; width: 240px;font-size:16px;
		       padding: 7px 10px; border-radius: 4px; border: 1px solid #00FF00; 
		       border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="myFunction()" value="登录" > 
		    </P>
		    <A href="help.html" style="padding: 0px 0px 50px 100px; position: relative;color: red;font-size:0.65em;">忘记密码,点击帮助</A>
		    <br><br>
		</form>
	</div>
	<div class="foot_div">
		<p>@Lingnan 生物科学与技术学院2018-08</p>
	</div>
</div>
</body>
</html>