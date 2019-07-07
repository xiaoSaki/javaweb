<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>更新专业信息</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>高校排课管理系统</h1>

	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！
		</p>
		<a href="../login.html">退出</a>
	</div>
	</header>
	<!--时间-->
	<%String UserID=(String)session.getAttribute("user"); %>
	<section class="publicTime"> <span id="time">2015年1月1日11:11
		星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
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
			<strong>你现在所在的位置是:</strong> <span>更新专业信息管理页面</span>
		</div>
		<div class="providerAdd">
			<form action="updateMajorIfoServlet">
				<%
				String MajorID = request.getParameter("MajorID");
				Vector<datebaseDto> v1 = new Vector<datebaseDto>();
				v1 = (Vector<datebaseDto>) session.getAttribute("majorIfo");
				Iterator it = v1.iterator();
				datebaseDto sdto = null;
				while (it.hasNext()) {
					sdto = (datebaseDto) it.next();
					if((sdto.getMajorID().trim()).equalsIgnoreCase(MajorID)){
				%>

				<!--div的class 为error是验证错误，ok是验证成功-->
				<div>
					<label for="MajorID">专业编号：</label> <input type="text"
						name="MajorID" value=<%=sdto.getMajorID()%> placeholder="北极" /> <span>*</span>

				</div>
				<div>
					<label for="MajorName">专业名称：</label> <input type="text"
						name="MajorName" value=<%=sdto.getMajorName()%>
						placeholder="22" /> <span>*</span>
				</div>
				<div>
					<label>标志位：</label> <select name="MIflag">
						<option value="1">1</option>
						<option value="0">0</option>
					</select>
				</div>
				<div class="providerAddBtn">
					<input style="line-height:10px;height:30px;width:90px;"  type="submit" value="保存"> <input type="button"
						value="返回" onclick="history.back(-1)" />
				</div>
				<%
					}
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