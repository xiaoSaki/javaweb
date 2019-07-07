<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="GB2312">
<title>高校排课系统</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>高校排课系统</h1>

	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！
		</p>
		<a href="../login.html">退出</a>
	</div>
	</header>
	<!--时间-->
	<%String UserID=(String)session.getAttribute("user"); %>
	<section class="publicTime"> <span id="time">2015年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
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
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 教师排课表修改页面</span>
		</div>
		<div class="providerAdd">
			<form action="updateTeacherCourseServlet">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<%
					Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
					v = (Vector<teacherCourseDTO>) session.getAttribute("TeacherUser");
					Iterator it = v.iterator();
					teacherCourseDTO s = null;
					while (it.hasNext()) {
						s = (teacherCourseDTO) it.next();
				%>
				<div>
					<label for="TeacherCourseID">教师课程编号:</label> <input type="text"
						name="TeacherCourseID" id="TeacherCourseID" value=<%=s.getTeacherCourseID()%>/> <span>*</span>
				</div>
				
				<div>
					<label for="TeacherCourseID">教师编号:</label> <input type="text"
						name="TeacherID" id="TeacherID" value=<%=s.getTeacherID()%>/> <span>*</span>
				</div>		
				<div>
					<label for="CourseID">课程编号:</label> <input type="text"
						name="CourseID" id="CourseID" value=<%=s.getCourseID()%>/> <span>*</span>
				</div>
				<div>
					<label for="ClassID">班级编号:</label> <input type="text"
						name="ClassID" id="ClassID" value=<%=s.getClassID()%>/> <span>*</span>
				</div>
				<div>
                    <label for="WeekDay">星期**:</label>
                    <select name="WeekDay" id="WeekDay">
	               <option value="星期一" selected="WeekDay">&nbsp;&nbsp;星期一</option>
	               <option value="星期二" selected="WeekDay">&nbsp;&nbsp;星期二</option>
	               <option value="星期三" selected="WeekDay">&nbsp;&nbsp;星期三</option>
	               <option value="星期四" selected="WeekDay">&nbsp;&nbsp;星期四</option>
	               <option value="星期五" selected="WeekDay">&nbsp;&nbsp;星期五</option>
	               <option value="星期六" selected="WeekDay">&nbsp;&nbsp;星期六</option>
	               <option value="星期天" selected="WeekDay">&nbsp;&nbsp;星期天</option>
                  </select>
                </div>

                <div>
                    <label >节数：</label>
                    <select name="ClassTime" id="classtime">
	               <option value="1,2" selected="ClassTime">&nbsp;&nbsp;1,2</option>
	               <option value="3,4" selected="ClassTime">&nbsp;&nbsp;3,4</option>
	               <option value="5,6" selected="ClassTime">&nbsp;&nbsp;5,6</option>
	               <option value="7,8" selected="ClassTime">&nbsp;&nbsp;7,8</option>
	               <option value="9,10" selected="ClassTime">&nbsp;&nbsp;9,10</option>
                  </select>
                </div>
				
				
				<div>
					<label for="ClassroomID">教室编号:</label> <input type="text"
						name="ClassroomID" id="ClassroomID" value=<%=s.getClassroomID()%>/> <span>*</span>
				</div>
				<div>
					<label for="TCflag">状态:</label> <input type="text"
						name="TCflag" id="TCflag" value=<%=s.getTCflag()%>> <span>*</span>
				</div>
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="userList.html">返回</a>-->
					<input style="line-height:10px;height:30px;width:90px;" type="submit" value="保存"/> <input
						type="button" value="返回" onclick="history.back(-1)" />
				</div>
				<%
					}
				%>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>
</body>
</html>