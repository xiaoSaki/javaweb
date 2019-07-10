<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级详情</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>

<div id="container">
<div id="findstu">


	 	<div style="float:left">
		<form action="tstudent_management?action=findStu&class_id=${class_id}" method="post">
				学生查询：<input type="text" name="find_name" placeholder="请输入学生姓名...">
            			<input type="submit" class="bt" value="搜索"/>
		</form>
	</div>
	<div style="float:left">
		<form action="tstudent_management?action=insertTeaStuClass&class_id=${class_id}" method="post">
				添加学生：<input type="text" name="user_id" placeholder="请输入学生学号">
            			<input type="submit" class="bt" value="添加"/>
		</form>	
	</div>
	<div class="reture">
	<button type="button" class="qr"><a href="http://localhost:8080/ExamSys/teachers/ManagementList.jsp">返回</a></button>
	</div>
	
	<table class="providerTable" cellpadding="0" cellspacing="0">
	                
                
       				

       			<tr class="firstTr">                                     
                    <th style="text-align:left;">班级总人数：${stu_Cnum}</th>                  
                </tr>
                <tr class="firstTr">                                     
                    <th width="33%">学生学号</th>                   
                    <th width="33%">学生姓名</th>
                    <th width="33%"></th>                   
                </tr>
				  <c:if test="${!empty allStudent }">
				<c:forEach items="${allStudent}" var="AllStudent" varStatus="loop">
                <tr>
                	<td>${AllStudent.user_id }</td>
                    <td>${AllStudent.user_name }</td>
                    	
                    <td>
                    <a href="tstudent_management?action=deleteStu&user_id=${AllStudent.user_id }&class_id=${class_id }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a>
                    </td> 
                       
                </tr>
					</c:forEach>
					</c:if>
       			
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