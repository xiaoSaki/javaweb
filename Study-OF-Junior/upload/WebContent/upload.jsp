<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <s:actionerror/>
	<s:form action="upload1" enctype="multipart/form-data">
		<s:textfield name="username" label="用户名" />
		<s:file name="photo" label="照片" />
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>