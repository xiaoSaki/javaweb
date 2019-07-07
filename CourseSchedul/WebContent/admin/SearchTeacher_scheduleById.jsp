<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"   import="java.util.* , en.edu.lingnan.Dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
    <title>高校排课管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<form action="searchTeacher_scheduleInfoServlet">
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
                <span>用户管理页面</span>
            </div>
            <form action="searchTeacher_scheduleInfoServlet">
            <div class="search">
                <span>用户名：</span>
                <input type="text" name="TeacherID"  id="TeacherID" placeholder="请输入教师ID编号"/>
                <input name="submit" type="submit" style="height:33px; width:75px" value="查询" >
                </form>
                <a href="addUser.jsp">添加教师任课</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th></th>
                    <th width="20%">教师任课表编号</th>
                    <th width="20%">教师号</th>
                    <th width="20%">课程号</th>                 
                    <th width="30%">操作</th>
                </tr>
      
    <% 
    Vector<Teacher_scheduleDTO> v=new Vector<Teacher_scheduleDTO>();
    v = (Vector<Teacher_scheduleDTO>)session.getAttribute("allTeacher_scheduleInfo");//必须强制类型转换
    Iterator it = v.iterator();
    Teacher_scheduleDTO ts=null;
    while(it.hasNext())
    {
		ts=(Teacher_scheduleDTO)it.next();	
 %>
 <tr>
       <td><input type="checkbox" name="check" value=<%=ts.getTsno() %>></td>
		<td><%=ts.getTsno() %></td>
		<td><%=ts.getTeacherID() %></td>
		<td><%=ts.getCourseID() %></td>
       <td><a href="ShowTeacher_scheduleInfoById.jsp?Tsno=<%=ts.getTsno() %>"><img src="img/read.png" alt="查看" title="查看"/></a>
       <a href="UpdateTeacher_scheduleInfo.jsp?TeacherID=<%=ts.getTeacherID() %>"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
       <a href="deleteTeacher_scheduleInfoServlet?Tsno=<%=ts.getTsno() %>" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
       </td> 
 </tr>
    <%
    }
    %>
    </table>
    </form>
</body>
</html>