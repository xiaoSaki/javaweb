<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<%-- <s:head/> --%>
<meta charset="utf-8">
<title>Insert title here</title>
<s:head/>
</head>

<body>
<form action="hello" method="post"> 
    <s:textfield name="username" label="姓名" requiredLabel="true" requiredPosition="left"></s:textfield><br/>
   	<s:textfield name="age" label="年龄"> </s:textfield><br/>
   	<s:textfield name="email" label="邮箱"></s:textfield><br/>
   	<s:textfield name="score" label="分数" ></s:textfield><br/>
   	<s:password name="password" label="密码"> </s:password><br/>
   	<s:password name="repassword" label="重复密码"> </s:password><br/>
   	<s:textfield name="url" label="个人主页"></s:textfield><br/>
   <s:textfield name="gender" label="性别"></s:textfield><br/>
   	<s:submit value="注册"></s:submit><br/>
 </form>
</body>
</html>