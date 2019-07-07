<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>高校排课管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
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
    <span id="time">2018年6月21日 10:11  星期四</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
 <form action="findStudentInfoByIdServlet"> 
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
            <span>学生管理页面 >> 学生信息查看页面</span>
        </div>   
   <% 
    Vector<StudentDTO> v = new Vector<StudentDTO> ();
    String StudentID=request.getParameter("StudentID");
    v = (Vector<StudentDTO>)session.getAttribute("allstudentinfo");
    Iterator it = v.iterator();
    StudentDTO s = null;
    while(it.hasNext())
    {
 	   s = (StudentDTO)it.next();
 	  System.out.print("00000000kkk");
 	   if((s.getStudentID().trim()).equals(StudentID))
     {
 %>
        <div class="providerView">
            <p><strong>学生号：</strong><span><%=s.getStudentID() %></span></p>
            <p><strong>学生姓名：</strong><span><%=s.getStudentName() %></span></p>
            <p><strong>学生性别：</strong><span><%=s.getStudentSex() %></span></p>
            <p><strong>学生班级：</strong><span><%=s.getClassID() %></span></p>
            <p><strong>学生年龄：</strong><span><%=s.getStudentAge() %></span></p>          
            <a href="userList.html">返回</a>
        </div>
        <%
        }
    }
        %>
    </div>
    </form>
</section>

<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>