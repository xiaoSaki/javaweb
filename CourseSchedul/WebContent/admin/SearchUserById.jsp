<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*" %>
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
<form action="searchUserServlet">
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
                <span>用户管理页面</span>
            </div>
            <form action="searchUserServlet">
            <div class="search">
                <span>用户名：</span>
                <input type="text" name="Cid"  id="cid" placeholder="请输入用户ID编号"/>
                <input name="submit" type="submit" style="height:33px; width:75px" value="查询" >
                </form>
                <a href="addUser.jsp">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th></th>
                    <th width="10%">用户账号</th>
                    <th width="20%">用户密码</th>
                    <th width="10%">用户姓名</th>
                    <th width="10%">用户性别</th>
                    <th width="10%">用户权限</th>
                    <th width="30%">操作</th>
                </tr>
      
    <% 
    Vector<UserDto> v = new Vector<UserDto> ();
    v = (Vector<UserDto>)session.getAttribute("alluser");
    Iterator it = v.iterator();
    UserDto u = null;
    while(it.hasNext())
    {
 	   u = (UserDto)it.next();
 	  // System.out.print("00000000kkk");
 %>
 <tr>
       <td><input type="checkbox" name="check" value="<%=u.getUserId()%>"></td>
       <td><%=u.getUserId()%></td>
       <td><%=u.getPassword() %></td>
       <td><%=u.getUserName()%></td>
       <td><%=u.getUserSex() %></td>
       <td><%=u.getUserAuth()%></td>
       <td><a href="ShowUserById.jsp?cid=<%=u.getUserId()%>"><img src="img/read.png" alt="查看" title="查看"/></a>
       <a href="UpdateUser.jsp?cid=<%=u.getUserId()%>"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
       <a href="deleteUserByidServlet?cid=<%=u.getUserId()%>" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
       </td> 
 </tr>
    <%
    }
    %>
    </table>
    </form>
</body>
</html>