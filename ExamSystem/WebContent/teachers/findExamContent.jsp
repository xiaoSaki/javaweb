<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看试卷详情</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<script type="text/javascript">
<c:if test="${!empty UserList }">
<c:forEach items="${UserList}" var="user" varStatus="loop">
	function insert() {
		location.href = "question_bankServlet?action=showQue_bank&user_id=${user.user_id }&exam_id=${exam_id }";
	}
</script>
</head>
<body>

<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="15%">题目编号</th> 
                    <th width="15%">章节单元</th>                   
                    <th width="15%">题目类型</th>                   
                    <th width="15%">题目内容</th>
                    <th width="15%">题目选项</th>
                    <th width="15%">正确答案</th>
                    <th width="10%">选择操作</th> 
                </tr>
            <c:if test="${!empty Que_bankVO }">
			<c:forEach items="${Que_bankVO}" var="Que_bankVO" varStatus="loop">
       			<tr>
					<td>${Que_bankVO.que_id }</td> 
                    <td>${Que_bankVO.que_charpter }</td>
                    <td>${Que_bankVO.que_type }</td>
                    <td>${Que_bankVO.que_content }</td>  
                    <td>${Que_bankVO.que_options }</td>
                    <td>${Que_bankVO.que_answer }</td>
                    <td>
				        <a href="question_bankServlet?action=findUpdateQue&que_id=${Que_bankVO.que_id } &user_id=${user.user_id }" class="removeBill">修改</a>
					    <a href="question_bankServlet?action=delExam_Que&que_id=${Que_bankVO.que_id } &user_id=${user.user_id } &exam_id=${sessionScope.exam_id }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a>
					</td>
                </tr>
            </c:forEach>
 			</c:if>
               
     </table>
            
<div class="m3">
 	<button class="layui-btn layui-btn-danger" onClick="insert();">
		<i class="layui-icon"></i>添加
	</button>
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