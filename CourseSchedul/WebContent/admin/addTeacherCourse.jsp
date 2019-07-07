<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , en.edu.lingnan.Dto.*, en.edu.lingnan.Dao.*" %>
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
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="addTeacherCourseServlet">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="TeacherCourseID">教师课程编号:</label>
                    <input type="text" name="TeacherCourseID" id="TeacherCourseID"/>
                    <span>*请输入教师课程编号，且不能重复</span>
                </div>
                <div>
                    <label for="TeacherID">教师编号:</label>
                    <input type="text" name="TeacherID" id="TeacherID"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="CourseID">课程编号:</label>
                    <input type="text" name="CourseID" id="CourseID"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="ClassID">班级编号:</label>
                    <input type="text" name="ClassID" id="ClassID"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="WeekDay">星期:</label>
                    <input type="text" name="WeekDay" id="WeekDay"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="ClassTime">第几节课:</label>
                    <input type="text" name="ClassTime" id="ClassTime"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="ClassroomID">教室编号:</label>
                    <input type="text" name="ClassroomID" id="ClassroomID"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="TCflag">状态:</label>
                    <input type="text" name="TCflag" id="TCflag"/>
                    <span >*</span>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input style="line-height:10px;height:30px;width:90px;" type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>