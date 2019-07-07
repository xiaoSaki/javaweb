<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>教师个人授课表</title>
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
<% String userid = request.getParameter("userid");
%>
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
                <li ><a href="ATeacherCourseView.jsp?userid=<%=userid%>">教师授课表</a></li>
                <li><a href="TeacherPersonInfoView.jsp?userid=<%=userid%>">个人信息</a></li>              
                <li><a href="TeaInfoUpdate.jsp?userid=<%=userid%>">信息修改</a></li>
                <li><a href="http://localhost:8080/CourseSchedul/login.html">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>教师页面 >> 教师个人授课表页面</span>
        </div>
        <div class="providerView">
               <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="16%">教师ID</th>
                <th width="16%">班级ID</th>
                <th width="16%">课程ID</th>
                <th width="16%">星期几</th>
                <th width="16%">第几节课</th>
                <th width="16%">上课教室</th>
            </tr>
           
 <%
            teacherCourseDAO tdao = new teacherCourseDAO();
			Vector <teacherCourseDTO> v = new Vector<teacherCourseDTO> ();
		    v=tdao.findTeacherCourseByteacherID(userid);
			//v=tdao.findATeachCourseByID(userid);
            Iterator it = v.iterator();
            teacherCourseDTO t = null; 
            while(it.hasNext())
            {
    	    System.out.println(userid);
	        t = (teacherCourseDTO)it.next();
	        System.out.println("0000iii"+userid);
 %>
 <tr align="center">
    
    <td><%=t.getTeacherID() %></td>
    <td><%=t.getClassID() %></td>
    <td><%=t.getCourseID() %></td>
    <td><%=t.getWeekDay() %></td>
    <td><%=t.getClassTime() %></td>
    <td><%=t.getClassroomID() %></td>
    
</tr>
<%
	}
%>
        </table>
            <a href="http://localhost:8080/CourseSchedul/teacher/ok.jsp?userid=<%=userid %>">返回</a>
        </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>