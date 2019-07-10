<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部员工</title>
</head>
<body>
	<form>
		<table>
			<thead>
				<tr>
					<th>eid</th>
					<th>pwd</th>
					<th>ename</th>
					<th>sex</th>
					<th>birth</th>
					<th>phone</th>
					<th>job</th>
					<th>dname</th>
					<th>superid</th>
					<th>power</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="employee">
					<tr>
						<td>${employee.eid }</td>
						<td>${employee.pwd }</td>
						<td>${employee.ename }</td>
						<td>${employee.sex }</td>
						<td>${employee.birth }</td>
						<td>${employee.phone }</td>
						<td>${employee.job }</td>
						<td>${employee.dname }</td>
						<td>${employee.superid }</td>
						<td>${employee.power }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>