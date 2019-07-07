<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="GB2312">
    <title>高校排课系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>高校排课系统</h1>

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
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <%
					Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
					v = (Vector<teacherCourseDTO>) session.getAttribute("TeacherUser");
					Iterator it = v.iterator();
					teacherCourseDTO s = null;
					while (it.hasNext()) {
						s = (teacherCourseDTO) it.next();
				%>
        <div class="providerView">
            <p><strong>教师课程编号:</strong><span><%=s.getTeacherCourseID()%></span></p>
            <p><strong>教师编号:</strong><span><%=s.getTeacherID()%></span></p>
            <p><strong>课程编号:</strong><span><%=s.getCourseID()%></span></p>
            <p><strong>班级编号:</strong><span><%=s.getClassID()%></span></p>
            <p><strong>星期:</strong><span><%=s.getWeekDay()%></span></p>
            <p><strong>第几节课:</strong><span><%=s.getClassTime()%></span></p>
            <p><strong>教师编号:</strong><span><%=s.getClassroomID()%></span></p>
            <p><strong>状态:</strong><span><%=s.getTCflag()%></span></p>
            <a href="findTeacherCourseServlet">返回</a>
        </div>
        <%
					}
		%>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>