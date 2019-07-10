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
 <c:if test="${!empty UserList }">
 <c:forEach items="${UserList}" var="user" varStatus="loop">
<script type="text/javascript">
function msgbox(n) {
		document.getElementById('inputbox').style.display = n ? 'block'
				: 'none'; /* 点击按钮打开/关闭 对话框 */
}

function allcheck() {
	var checkObj = document.getElementsByName("check");//找出所有名为"check"的复选框
	for (var i = 0; i < checkObj.length; i++)
		checkObj[i].checked = true; //让复选框中的被选中的值为true
}

function nocheck() {
	var checkObj = document.getElementsByName("check");
	for (var i = 0; i < checkObj.length; i++)
		checkObj[i].checked = false; //让复选框中的被选中的值为false
}

function backcheck() {
	var checkObj = document.getElementsByName("check");
	for (var i = 0; i < checkObj.length; i++)
		if (checkObj[i].checked)
			checkObj[i].checked = false;
		else
			checkObj[i].checked = true;

}

function allInsert() {
	var checkObj = document.getElementsByName("check");
	var arr = []; //定义arr数组
	var flag = false;
	for (var i = 0; i < checkObj.length; i++) {
		if (checkObj[i].checked == true) {
			arr.push(checkObj[i].value);
			flag = true;
		}
	}
	alert(arr);
	if (flag) {
		if (confirm("你确定要添加这些试题吗?"))
			location.href = "question_bankServlet?action=insertQue_Exam&user_id=${user.user_id }&exam_id=${exam_id }&arr="+arr; //调用servlet
	} else
		alert("至少要选择一条记录才能进行批量删除...");
}
</script>
</head>
<body>

<div id="container">
  <div class="search">
	<div class="findinfo">
		<p>题库</p>
        </div>
       
    <div class="search1">
		<form action="question_bankServlet?action=findQue_bank&user_id=${user.user_id }" method="post">
				试题查询：<input type="text" name="Que_content" placeholder="请输入试题内容...">
				&nbsp;&nbsp;
				<select name="Que_type"><option value=null></option><option value="单选">单选</option><option value="多选">多选</option></select>
            	&nbsp;&nbsp;		
            	<input type="submit" class="bt" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;"/>
		</form>
	</div>
	
	
	<div class="search1">		
		添加试题：<button onClick="msgbox(1)" class="bt">&nbsp;&nbsp;添加试题&nbsp;&nbsp;</button>	
		<form action="question_bankServlet?action=insertQue&user_id=${user.user_id }" method="post">
		<div id='inputbox' class="box" style="position: absolute; z-index: 1000">
		    <a class='x' href='' onclick="msgbox(0); return false;">关闭</a> 
			<input type="text" name="Que_chapter" id="Que_chapter" placeholder="请输入试题章节编号">
			<select name="Que_type" style="width:285px; height:32px; margin-left:18px; margin-top:10px;"><option value="单选题">单选题</option><option value="多选题">多选题</option></select>
			<input type="text" name="Que_content" id="Que_content" placeholder="请输入试题内容"> 
			<input type="text" name="Que_options" id="exam_begin" placeholder="请输入试题选项"> 
			<input type="text" name="Que_answer" id="exam_end" placeholder="请输入试题答案"> 
			<input type="submit"  value="&nbsp;&nbsp;确定添加&nbsp;&nbsp;"/>
		</div>
		</form>
	</div>
		
</div>
		
</div>

<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="5%"></th> 
                    <th width="13%">题目编号</th> 
                    <th width="13%">章节单元</th>                   
                    <th width="13%">题目类型</th>                   
                    <th width="13%">题目内容</th>
                    <th width="13%">题目选项</th>
                    <th width="13%">正确答案</th>
                    <th width="13%">相应操作</th>
                </tr>
            <c:if test="${!empty Que_bankVO }">
			<c:forEach items="${Que_bankVO}" var="Que_bankVO" varStatus="loop">
       			<tr>
       			    <td><input type="checkbox" name="check" value=${Que_bankVO.que_id }></td>
					<td>${Que_bankVO.que_id }</td> 
                    <td>${Que_bankVO.que_charpter }</td>
                    <td>${Que_bankVO.que_type }</td>
                    <td>${Que_bankVO.que_content }</td>  
                    <td>${Que_bankVO.que_options }</td>
                    <td>${Que_bankVO.que_answer }</td>
                    <td>
                    	<a href="question_bankServlet?action=findUpdateQue_bank&user_id=${user.user_id } &que_id=${Que_bankVO.que_id }">修改 </a>
                    	<a href="question_bankServlet?action=delQueByque_id&user_id=${user.user_id } &que_id=${Que_bankVO.que_id }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a>
                    </td>             
                </tr>

            </c:forEach>
 			</c:if>
               
     </table>
            
            
<div class="m3">
	<button class="layui-btn layui-btn-danger" id="btn1"
		onClick="allcheck();">
		<i class="layui-icon"></i>全选
	</button>
	<button class="layui-btn layui-btn-danger" id="btn2"
		onClick="nocheck();">
		<i class="layui-icon"></i>不选
	</button>
	<button class="layui-btn layui-btn-danger" id="btn3"
		onClick="backcheck();">
		<i class="layui-icon"></i>反选
	</button>
	<button class="layui-btn layui-btn-danger" onClick="allInsert();">
		<i class="layui-icon"></i>试卷添加试题
	</button>
	<div class="paging"><a href="question_bankServlet?action=showQue_bank2&user_id=${user.user_id }&pageNum=${pageCount }&pageCount=${pageCount }">尾页</a></div>
	<div class="paging"><a href="question_bankServlet?action=showQue_bank2&user_id=${user.user_id }&pageNum=${pageNum+1 }&pageCount=${pageCount }">下一页</a></div>
	<div class="paging">${pageNum }/${pageCount }</a></div>
	<div class="paging"><a href="question_bankServlet?action=showQue_bank2&user_id=${user.user_id }&pageNum=${pageNum-1 }&pageCount=${pageCount }">上一页</a></div>
	<div class="paging"><a href="question_bankServlet?action=showQue_bank2&user_id=${user.user_id }&pageNum=1&pageCount=${pageCount }">首页</a></div>
</div>	
</div>
</div>
 </c:forEach>	
 </c:if>
</body>
</html>