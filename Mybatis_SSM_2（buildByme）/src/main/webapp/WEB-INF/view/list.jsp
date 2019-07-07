<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello World!</h2>

   <table border="1" width="600px">
   			<tr>
			<td>账号id</td>
			<td>品牌id</td>
		</tr>
		  <c:forEach var="account" items="${account}">	
		<tr>
			<td>${account.account}</td>
			<td>${account.balance}</td>

		</tr>
	</c:forEach>
   </table>

<%--   <c:out  value="${a.account}"></c:out> --%>

</body>
</html>
