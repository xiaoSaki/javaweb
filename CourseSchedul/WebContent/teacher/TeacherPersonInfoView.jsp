<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>教师个人信息</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
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
            <span>教师页面 >> 个人信息查看页面</span>
        </div>     
        <%
            TeacherInformationDAO1 tdao = new TeacherInformationDAO1();
			Vector <teacherInformationDTO> v = new Vector<teacherInformationDTO> ();
			v=tdao.findATeaInfoByID(userid);
            Iterator it = v.iterator();
            teacherInformationDTO t = null;
            while(it.hasNext()){
	             t = (teacherInformationDTO)it.next();
         %>
         <%
            UserInformationDAO udao = new UserInformationDAO();
			Vector <UserInformationDTO> v1 = new Vector<UserInformationDTO> ();
			v1=udao.FindAUserInfoByID(userid);
            Iterator it1 = v1.iterator();
            UserInformationDTO u = null;
            while(it1.hasNext()){
    	    System.out.println(userid);
	        u = (UserInformationDTO)it1.next();
         %>
                <%  String a=u.getUserPsw();System.out.println(a+"111");%>
           <div class="providerView">
           <p><strong>教师ID:</strong><span><%=t.getTeacherID() %></span></p>
            <p><strong>教师姓名:</strong><span><%=t.getTeacherName() %></span></p>
            <p><strong>教师性别:</strong><span><%=t.getTeacherSex() %></span></p>
            <p><strong>教师手机号码:</strong><span><%=t.getTeacherTel() %></span></p>
            <p><strong>教师年龄:</strong><span><%=t.getTeacherAge() %></span></p>
            <p><strong>教师登录密码:</strong><span><%=u.getUserPsw() %></span></p>
            <a href="http://localhost:8080/CourseScheduling/ok.jsp?userid=<%=userid %>">返回</a>
        </div>
        
 <%
	}
%>
        
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
</body>
</html>