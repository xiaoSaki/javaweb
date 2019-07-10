<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<%-- <s:head/> --%>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
 <s:head/>
<body>
<%-- <s:fielderror></s:fielderror> --%>
	<!-- <form action="hello" method="post">
   		用户名：<input type="text" name="username" /><br/>
   		密码：<input type="password" name="password" /><br/>
   		生日：<input type="text" name="birthday" /><br/>
   		爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
   			<input type="checkbox" name="hobby" value="睡觉"/>睡觉
   			<input type="checkbox" name="hobby" value="写代码"/>写代码
   			<br/>
   		已婚：<input type="checkbox" name="married" value="true"/><br/>
   		<input type="submit" value="注册" />
   	</form> -->
   	
  <%--  	<s:form action="hello">
   	<s:textfield name="username" label="姓名" requiredLabel="true" requiredPosition="left"></s:textfield>
   	<s:password name="password" label="密码"> </s:password>
   	<s:textfield name="birthday" label="生日"></s:textfield>
   	<s:submit value="注册"></s:submit>
   	</s:form> --%>
 <form action="hello" method="post">  	
   	<s:textfield name="username" label="姓名" requiredLabel="true" requiredPosition="left"></s:textfield></br>
   	<s:textfield name="age" label="年龄"> </s:textfield></br>
   	<s:textfield name="email" label="邮箱"></s:textfield></br>
   	<s:textfield name="score" label="分数" ></s:textfield></br>
   	<s:password name="password" label="密码"> </s:password></br>
   	<s:password name="repassword" label="重复密码"> </s:password></br>
   	<s:textfield name="url" label="个人主页"></s:textfield></br>
   	<s:textfield name="gender" label="性别"></s:textfield></br>
   </center><s:submit value="注册" align="center"></s:submit>
 </form>
</body>
</html>