<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷管理</title>
<link rel="stylesheet" type="text/css" href="../css/1.css" />
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function msgbox(n) {
		document.getElementById('inputbox').style.display = n ? 'block'
				: 'none'; /* 点击按钮打开/关闭 对话框 */
}
</script>
</head>
<body>
 <c:if test="${!empty UserList }">
 <c:forEach items="${UserList}" var="user" varStatus="loop">
<div id="container">
<div class="search">
	<div class="findinfo">
		<p>试卷</p>
        </div>
       
    <div class="search1">
		<form action="question_bankServlet?action=findExamByName&user_id=${user.user_id }" method="post">
				试卷查询：<input type="text" name="exam_name" placeholder="请输入试卷...">
            			<!-- <button type="submit" class="bt" >查询</button>	 -->
            			<input type="submit" class="bt" value="搜索"/>
		</form>
	</div>
	
	<div class="search1">		
		添加试卷：<button onClick="msgbox(1)" class="bt">&nbsp;&nbsp;添加试卷&nbsp;&nbsp;</button>	
		<form action="question_bankServlet?action=insertExam&user_id=${user.user_id }" method="post">
		<div id='inputbox' class="box" style="position: absolute; z-index: 1000">
		    <a class='x' href='' onclick="msgbox(0); return false;">关闭</a> 
			<input type="text" name="exam_name" id="exam_name" placeholder="请输入试卷名称">
			<input type="text" name="exam_begin" id="exam_begin" placeholder="请输入试卷开始时间"> 
			<input type="text" name="exam_end" id="exam_end" placeholder="请输入试卷结束时间"> 
			<input type="submit"  value="&nbsp;&nbsp;确定添加&nbsp;&nbsp;" href="Que_bank.jsp"/>
		</div>
		</form>
	</div>
		
</div>

<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="15%">试卷编号</th>                    
                    <th width="20%">试卷名称</th>                   
                    <th width="20%">开始时间</th>
                    <th width="20%">结束时间</th>
                    <th width="25%">试卷操作</th>
                </tr>
                
                <c:if test="${!empty examinationVO }">
			<c:forEach items="${examinationVO}" var="examinationVO" varStatus="loop">
       			<tr>
					<td>${examinationVO.exam_id }</td> 
                    <td>${examinationVO.exam_name }</td>
                    <td>${examinationVO.exam_begin }</td>
                    <td>${examinationVO.exam_end }</td>              
                    <td><a href="question_bankServlet?action=findQueByexam_id&exam_id=${examinationVO.exam_id }&user_id=${user.user_id }">点击查看试卷详情 </a>
                        <a href="question_bankServlet?action=findUpdateExam&exam_id=${examinationVO.exam_id }&user_id=${user.user_id }">修改 </a>
                    	<a href="question_bankServlet?action=delExamByid&user_id=${user.user_id } &exam_id=${examinationVO.exam_id }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a></td>                                            
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
 </c:forEach>	
 </c:if>
</body>
</html>