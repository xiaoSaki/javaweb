<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lingnan.examsys.business.domain.Question_bankVO" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新修改试题</title>
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
                    <th width="15%">题目编号</th> 
                    <th width="15%">章节单元</th>                   
                    <th width="15%">题目类型</th>                   
                    <th width="15%">题目内容</th>
                    <th width="15%">题目选项</th>
                    <th width="15%">正确答案</th>
                    <th width="8%">操作</th> 
                </tr>
             <c:if test="${!empty Que_bankVO }">
			<c:forEach items="${Que_bankVO}" var="Que_bankVO" varStatus="loop">	  
                <form action="question_bankServlet?action=updateExam_Que&user_id=${user.user_id } &que_id=${Que_bankVO.que_id } &exam_id=${exam_id }" method="post">
                    <tr> 
                    <td>${Que_bankVO.que_id }</td>
                    <td><input type=text id="que_charpter" name="que_charpter" value=${Que_bankVO.que_charpter }></td>
                    <td><input type=text id="que_type" name="que_type" value='${Que_bankVO.que_type }'></td>
                    <td><input type=text id="que_content" name="que_content" value='${Que_bankVO.que_content }'></td>  
                    <td><input type=text id="que_options" name="que_options" value='${Que_bankVO.que_options }'></td>  <!--${Que_bankVO.que_options }要用''括起来，否则空格之后的内容无法显示  -->
                    <td><input type=text id="que_answer" name="que_answer" value='${Que_bankVO.que_answer }'></td>
					<td><input type="submit" class="bt" value="修改" /></td>
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