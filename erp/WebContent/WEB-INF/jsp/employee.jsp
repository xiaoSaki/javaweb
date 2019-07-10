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
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="employee">
					<tr>
						<td>${employee.eid }</td>
						<td>${employee.pwd }</td>
						<td>${employee.ename }</td>
						<td>${employee.sex }</td>
						<td><fmt:formatDate value="${employee.birth }" pattern="yyyy-MM-dd" /></td>
						<td>${employee.phone }</td>
						<td>${employee.job }</td>
						<td>${employee.dname }</td>
						<td>${employee.superid }</td>
						<td>${employee.power }</td>
						<td><a href="">修改</a><a href="deleteEmployeeByEid.action?eid=${employee.eid }">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<form action="insertEmployee.action">
		<input id="eid" name="eid" type="text" placeholder="eid" />
		<input id="pwd" name="pwd" type="text" placeholder="pwd" />
		<input id="ename" name="ename" type="text" placeholder="ename" />
		<input id="sex" name="sex" type="text" placeholder="sex" />
		<input id="birth" name="birth" type="text" placeholder="birth" />
		<input id="phone" name="phone" type="text" placeholder="phone" />
		<input id="job" name="job" type="text" placeholder="job" />
		<input id="dname" name="dname" type="text" placeholder="dname" />
		<input id="superid" name="superid" type="text" placeholder="superid" />
		<input id="power" name="power" type="text" placeholder="power" />
		<input type="submit" value="插入"></input>
	</form>
</body>
</html>