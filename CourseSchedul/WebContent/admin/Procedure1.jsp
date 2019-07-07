<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>存储过程1</title>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>高校排课系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
            <a href="login.html">退出</a>
        </div>
    </header>
<!--时间-->
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
                <li><a href="logoutServlet">退出系统</a></li>
                </ul>
            </nav>
        </div>           
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">               
             	<form action="selectProcedure1Servlet">
             		<span>教师姓名:</span>
             		<input type="text" name="TeacherName" id="TeacherName" placeholder="请输入教师姓名"/>
             		<input type="text" name="WeekDay" id="WeekDay" placeholder="请输入星期**"/>
             		<input type="text" name="ClassTime" id="ClassTime" placeholder="请输入第*节课"/>
                	<input type="submit" style="height:33px; width:75px" value="查询"/>
             	</form>
                <a href="#">存储器一</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">教师课程编号</th>
                    <th width="10%">教师编号</th>
                    <th width="10%">课程编号</th>
                    <th width="10%">班级编号</th>
                    <th width="10%">星期</th>
                    <th width="10%">第几节课</th>
                    <th width="10%">教室编号</th>
                    <th width="10%">状态</th>
                </tr>
                <%
					Vector<teacherCourseDTO> v = new Vector<teacherCourseDTO>();
					v = (Vector<teacherCourseDTO>) session.getAttribute("TeacherUser2");
					Iterator it = v.iterator();
					teacherCourseDTO s = null;
					while (it.hasNext()) {
						s = (teacherCourseDTO) it.next();
				%>
				<tr>
					<td><%=s.getTeacherCourseID()%></td>
					<td><%=s.getTeacherID()%></td>
					<td><%=s.getCourseID()%></td>
					<td><%=s.getClassID()%></td>
					<td><%=s.getWeekDay()%></td>
					<td><%=s.getClassTime()%></td>
					<td><%=s.getClassroomID()%></td>
					<td><%=s.getTCflag()%></td>
				</tr>
				<%
					}
				%>
            </table>
        </div>
    </section>
    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
</body>
</html>