<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
   <title>高校排课管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<script >
function Check(){
	String CourseID=request.getParameter("CourseID");
	 MajorScheduleDAO mdao = new MajorScheduleDAO();
		boolean flag=mdao.FindMajorScheduleByID(CourseID);
         if(!flag){
	      alert("本次搜索结果为空！");
	      form.CourseID.focus();
	      return false;
          }	
}
    function allcheck(){
    	var checkObj = document.getElementsByName("check")//所有的名为check的都选出来
    	for(var i =0;i<checkObj.length;i++)//从第零个开始，到这个东西的长度
    		checkObj[i].checked=true;//复选框的被选中的值要等于true
    	}
    function allnotcheck(){
        	var checkObj = document.getElementsByName("check")//所有的名为check的都选出来
        	for(var i =0;i<checkObj.length;i++)//从第零个开始，到这个东西的长度
        		checkObj[i].checked=false;//复选框的被选中的值要等于true
        	}
    function backcheck(){
            	var checkObj = document.getElementsByName("check")//所有的名为check的都选出来
            	for(var i =0;i<checkObj.length;i++){ //从第零个开始，到这个东西的长度
            		if(checkObj[i].checked==true)
            		checkObj[i].checked=false;//复选框的被选中的值要等于false
            		else
            			checkObj[i].checked=true;
            	        }
                   }
        	
    function deleteCheck(){
    	var checkObj = document.getElementsByName("check")//所有的名为check的都选出来
    	var arr = [];//定义一个数组
    	var flag=false;
    	for(var i =0;i<checkObj.length;i++){ //从第零个开始，到这个东西的长度
    		if(checkObj[i].checked==true){
    			arr.push(checkObj[i].value);
    			flag=true;
    		}
    }
    	alert(arr);
    	if(flag==true){
    		if(confirm("您确定删除这些记录吗？"))
    			location.href="deleteCheckServlet?arr="+arr;	
    	}
    	else
    		alert("请您至少选择一条记录，再进行删除");
    }


</script>
<style>
.search input[type='submit']{
    margin-left: 20px;
    width: 100px;
    padding: 0 20px;
    height: 30px;
    border: 1px solid #7ba92c;
    border-radius: 4px;
    color: #fff;
    font-weight: bold;
    background:#87c212 url("img/search.png") 10px center no-repeat;
}
.search input[type='submit']:focus{
    outline: none;
    background-color: #5d8410;
}
</style>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>高校排课管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="../login.html">退出</a>
    </div>
</header>
<!--时间-->
<%String UserID=(String)session.getAttribute("user"); %>
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
               <li ><a href="findAllUserServlet">用户信息管理</a></li>
                <li ><a href="findStudentInfoServlet">学生信息管理</a></li>
                <li ><a href="findTeacherInformationServlet">教师信息管理</a></li>
                <li ><a href="findAllTeacher_scheduleInfoServlet">教师任课信息管理</a></li>
                <li ><a href="findAllClassRoomServlet">教室信息管理</a></li>
                <li ><a href="findAllClassRoomUseServlet">教室使用状态</a></li>
                <li ><a href="findClassIfoServlet">班级信息管理</a></li>
                <li ><a href="findMajorIfoServlet">专业信息管理</a></li>
                <li ><a href="searchAllMajorSchedule">专业课程表管理</a></li>
                <li ><a href="findTeacherCourseServlet">教师排课管理</a></li>
                <li ><a href="findClassScheduleServlet">班级排课管理</a></li>
                <li><a href="showpersonalInfo.jsp?UserID=<%=UserID%>">个人中心</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
<% 
String CourseID = (String)session.getAttribute("CourseID");
%>
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>专业课程管理页面 >> 专业课程查询页面</span>
        </div>
        <div class="search">
            
            <form action="searchByCourseID"  name="form" >
            <span>课程ID:</span>
				<input type="text" placeholder="输入课程ID" name="CourseID" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'CourseID';}"  />
				<input type="submit" value="查询"/>
				<a href="MajorScheduleAdd.jsp">添加专业课程</a>
		</form>        
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th></th>
                <th width="10%">课程ID</th>
                <th width="15%">专业ID</th>
                <th width="10%">课程名称</th>
                <th width="10%">课程学时</th>
                <th width="10%">学年</th>
                <th width="10%">学期</th>
                <th width="10%">教室类型</th>
                <th width="10%">剩余排课数</th>
                <th width="25%">操作</th>
            </tr>
<%
      Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
      v=(Vector<MajorScheduleDTO>)session.getAttribute("searchcourse");
      Iterator it = v.iterator();
      MajorScheduleDTO m = null;
      while(it.hasNext()){
	  m = (MajorScheduleDTO)it.next();
	  System.out.println(CourseID+"666");
	  String aa=m.getCourseID();
	  aa=aa.substring(0,4);
	  //System.out.println(aa+"9999");
	  if(aa.equals(CourseID)){ 
		  //System.out.println(CourseID);
%>
<tr >
<td><input type="checkbox" name="check" value=<%=m.getCourseID() %>> </td>
<td><%=m.getCourseID() %>
<td><%=m.getMajorID() %>
<td><%=m.getCourseName() %>
<td><%=m.getCourseTime() %>
<td><%=m.getYearTime() %>
<td><%=m.getTermTime() %>
<td><%=m.getClassroomType() %>
<td><%=m.getEveryWeekCourseTime() %></td>
<td >
      <a href="MajorScheduleView.jsp?CourseID=<%=m.getCourseID() %>"><img src="img/read.png" alt="查看" title="查看"/></a>
      <a href="MajorScheduleUpdate.jsp?CourseID=<%=m.getCourseID()%>"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
      <a href="deleteMajorScheduleServlet?CourseID=<%=m.getCourseID()%>"><img src="img/schu.png" alt="删除" title="删除"/></a>
    </td>
</tr>
<%
	}}
%>

        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>


<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>