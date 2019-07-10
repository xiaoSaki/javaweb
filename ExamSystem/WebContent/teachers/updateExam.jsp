<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lingnan.examsys.business.domain.Question_bankVO" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新修改试卷</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
</head>
<body>
 <c:if test="${!empty UserList }">
 <c:forEach items="${UserList}" var="user" varStatus="loop">
<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="20%">试卷编号</th> 
                    <th width="20%">试卷名称</th>                   
                    <th width="20%">开始时间</th>                   
                    <th width="20%">结束时间</th>
                    <th width="20%">选择操作</th> 
                </tr>
             <c:if test="${!empty ExamVO }">
			<c:forEach items="${ExamVO}" var="ExamVO" varStatus="loop">	  
                <form action="question_bankServlet?action=updateExam&user_id=${user.user_id } &exam_id=${exam_id } " method="post">
                    <tr> 
                    <td>${ExamVO.exam_id }</td>
                    <td><input type=text id="exam_name" name="exam_name" value='${ExamVO.exam_name }'></td>
                    <td><input type=text id="exam_begin" name="exam_begin" value='${ExamVO.exam_begin }'></td>
                    <td><input type=text id="exam_end" name="exam_end" value='${ExamVO.exam_end }'></td>  
					<td><input type="submit" class="bt" value="确定修改" /></td>
					</tr>
				</form>
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
 </c:forEach>	
 </c:if>
</body>
</html>