<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="aa" uri="/mytags"%>
<%@ taglib prefix="c" uri="/jstlc" %>
<%@ taglib prefix="sql" uri="/jstlsql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<aa:hello/>
	<br>
	
	<c:set var="a" value="aaa"/>
	<c:out value="${a}"/>
	<c:remove var="a"/>
	<c:out value="${a}"/>
	<c:catch var="b">
	<%=9/0%>
	</c:catch>
	<c:out value="${b}"/>
	<br>
	<%
	String[] str = new String[5];
	str[0]="aaaa";
	str[1]="bbbb";
	str[2]="cccc";
	str[3]="eeee";
	str[4]="ffff";
	request.setAttribute("st",str);
	%>
	<c:out value="${st[2]}"/>
	<c:if test="${st[2]=='cccc'}">
	ccccccccc
	</c:if>
	<br>
	<c:choose>
	<c:when test="${st[2]=='cacc'}">
	ddddddd
	</c:when>
	<c:otherwise>
	eeeeeee
	</c:otherwise>
	</c:choose>
	
	<br>
	<c:forEach var="c" items="${st}">
		<c:out value="${c}"/>
	</c:forEach>
	<br>
	<c:forEach var="d" begin="1" end="4">
		<c:out value="${d}"/>
	</c:forEach>
	<br>
	<c:forTokens var="e" items="zhangsan,lisi,wangwu,zhaolu" delims=",">
		<c:out value="${e}"/>
	</c:forTokens>
	<br>
	<a href="<c:url value="http://www.qq.com"/>">
	qq
	</a>
	<br>
	<a href="http://www.qq.com">
	wwwww
	</a>
	<br>
	<c:url var="f" value="http://www.qq.com">
		<c:param name="sname" value="zhangsan"/>
	</c:url>
	<a href="${f}">
	qqqqq
	</a>
	<br>
	<c:import url="/ok.html"/>
	<br>
	
	<sql:setDataSource
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/university"
		user="root"
		password="123456"
		var="aaa"
	/>
	/*想查询一下*/
	<sql:query var="result" dataSource="${aaa}"
		sql="select *from student"
		/>
	<table border="1">
		<c:forEach var="g" items="${result.rows}">
		<tr>
		<td><c:out value="${g.sid}"/></td>
		<td><c:out value="${g.sname}"/></td>
		<td><c:out value="${g.password}"/></td>
		<td><c:out value="${g.superuser}"/></td>
		</tr>
		</c:forEach>	
	</table>
	//修改数据
	<sql:update dataSource="${aaa}"
		sql="update student set password='ccc' where sid='s04'"
	/>
	//再查询一遍
	<table border="1">
		<c:forEach var="h" items="${result.rows}">
		<tr>
		<td><c:out value="${h.sid}"/></td>
		<td><c:out value="${h.sname}"/></td>
		<td><c:out value="${h.password}"/></td>
		<td><c:out value="${h.superuser}"/></td>
		</tr>
		</c:forEach>	
	</table>

</body>
</html>