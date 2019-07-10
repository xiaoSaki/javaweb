<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级名单列单</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
</head>

<body>
<c:if test="${!empty UserList }">
<c:forEach items="${UserList}" var="user" varStatus="loop">
<div id="container">
<div class="search">
	<div class="findinfo">
		<p>班级</p>
        </div>
       
    <div class="search1">
		<form action="tstudent_management?action=findClass2&user_id=${user.user_id }" method="post">
				班级查询：<input type="text" name="class_name" placeholder="请输入班级...">
            			<!-- <button type="submit" class="bt" >查询</button>	 -->
            			<input type="submit" class="bt" value="搜索"/>
		</form>
	</div>
	<div class="add">
		<form action="tstudent_management?action=insertTeaClass2&user_id=${user.user_id }" method="post">
				添加班级：<input type="text" name="class_name" placeholder="请添加班级...">
            			<input type="submit" class="bt" value="添加"/>
		</form>		
	</div>

</div>


<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
               
				<tr>
				<c:if test="${!empty ClassShow }">
				 <c:forEach items="${ClassShow}" var="ClassShow" varStatus="loop">
					<td width="10%"><input type="checkbox" name="check" > 
                    <td width="10%"> ${ClassShow.class_name }</td>             
                    <td width="70%" style="text-align:right;">
                    <a href="tstudent_management?action=findStuStatus2&class_name=${ClassShow.class_name } &user_id=${user.user_id }&class_id=${ClassShow.class_id }" >查看班级</a></td>                      
                    <td width="10%">
                    <a href="tstudent_management?action=deleteTeaClass2&class_name=${ClassShow.class_name } &user_id=${user.user_id }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a>
					</td>    
                </tr>	
       			 </c:forEach>
				 </c:if>
               
            </table>
            
<div class="m3">
	<div class="paging"><a href="tstudent_management?action=showStuClassL22&user_id=${user.user_id }&pageNum=${pageCount }&pageCount=${pageCount }">尾页</a></div>
	<div class="paging"><a href="tstudent_management?action=showStuClassL22&user_id=${user.user_id }&pageNum=${pageNum+1 }&pageCount=${pageCount }">下一页</a></div>
	<div class="paging">${pageNum }/${pageCount }</a></div>
	<div class="paging"><a href="tstudent_management?action=showStuClassL22&user_id=${user.user_id }&pageNum=${pageNum-1 }&pageCount=${pageCount }">上一页</a></div>
	<div class="paging"><a href="tstudent_management?action=showStuClassL22&user_id=${user.user_id }&pageNum=1&pageCount=${pageCount }">首页</a></div>

</div>	
</div>
</div>




</c:forEach>
</c:if>

</body>
</html>