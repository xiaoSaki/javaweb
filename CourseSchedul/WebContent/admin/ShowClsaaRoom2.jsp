<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

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
 <form action="findClassRoomByIDServlet">
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
            <span>教室使用管理页面 >> 教室使用查看页面</span>
        </div>   
   <% 
   request.setCharacterEncoding("GB2312");
   response.setContentType("text/html;charset=GB2312");
   
   String cid=request.getParameter("cid");
   Vector<ClassRoomDto> v = new Vector<ClassRoomDto> ();
v = (Vector<ClassRoomDto>)session.getAttribute("allclassroom");
Iterator it = v.iterator();
ClassRoomDto u = null;
//System.out.println("wwwwwww");
while(it.hasNext())
{
	  u = (ClassRoomDto)it.next();
	  System.out.println("---------"+u.getRoomid());
	  System.out.println("+++++++++"+cid);
	  if((u.getRoomid().trim()).equals(cid))
	   {
		  System.out.println("kkkkk");
 %>
            
          <div class="providerView">
            <p><strong>教室编号：</strong><span><%=u.getRoomid() %></span></p>
            <p><strong>教室名称：</strong><span><%=u.getRoomname() %></span></p>
            <p><strong>教室类型：</strong><span><%=u.getRoomtype() %></span></p>
            <p><strong>最大容纳数：</strong><span><%=u.getMaxnum() %></span></p>
            <a href="ShowAllclassRoom.jsp">返回</a>
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