<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*" %>
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
        <p><span>下午好！</span><span style="color: #fff21b"> Student</span> , 欢迎你！</p>
        <a href="../login.html">退出</a>
    </div>
</header>
<!--时间-->
<% String UserID=request.getParameter("UserID"); %>
<section class="publicTime">
    <span id="time">2018年6月21日 10:11  星期四</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
 <form action="findStudentPersonalInfoServlet"> 
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="showclassschedule.jsp?UserID=<%=UserID%>">班级课表</a></li>
                <li ><a href="showstudentInfo.jsp?UserID=<%=UserID%>">个人信息</a></li>
                <li><a href="changInformation.jsp?UserID=<%=UserID%>">信息修改</a></li>
                <li><a href="../login.html">退出系统</a></li>
            </ul>
        </nav>    
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>个人信息页面 </span>
        </div>   
   <% 
   	StudentDAO sdo = new StudentDAO();  	
    System.out.println(UserID+"55555");	
    Vector<StudentDTO> v=new Vector<StudentDTO>();
	v=sdo.findStudentInfoById(UserID);
	StudentDTO s=null;
	Iterator it=v.iterator();			
	while(it.hasNext())
   {
	   s = (StudentDTO)it.next();	   
	  //if((s.getStudentID().trim()).equals(UserID)){ 
 %>
 
 <% 
   	UserDao udao = new UserDao();  		
    Vector<UserDto> v1=new Vector<UserDto>();
	v1=udao.finduserInfoByid(UserID);
	UserDto u=null;
	Iterator it1=v1.iterator();			
	while(it1.hasNext())
   {
	   u = (UserDto)it1.next();	   
 %>
        <div class="providerView">
            <p><strong>学生号：</strong><span><%=s.getStudentID() %></span></p>
            <p><strong>学生姓名：</strong><span><%=s.getStudentName() %></span></p>
            <p><strong>学生性别：</strong><span><%=s.getStudentSex() %></span></p>
            <p><strong>学生班级：</strong><span><%=s.getClassID() %></span></p>
            <p><strong>学生年龄：</strong><span><%=s.getStudentAge() %></span></p>
            <p><strong>学生登录密码：</strong><span><%=u.getPassword() %></span></p>          
            <a href="student.jsp">返回</a>
        </div>
        <%
        }
  // }
        %>
        <%
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