<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
            <span>学生管理页面 >> 学生修改页面</span>
        </div>
        <div class="providerAdd">
        <form action="updateStudentInfoServlet">
       <% 
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String StudentID=request.getParameter("StudentID");
	   Vector<StudentDTO> v=new Vector<StudentDTO>();
	   v = (Vector<StudentDTO>)session.getAttribute("allstudentinfo");
	   Iterator it=v.iterator();
	   StudentDTO s=null;
		while(it.hasNext()){
			s=(StudentDTO)it.next();
			if((s.getStudentID().trim()).equals(StudentID)){
    %>
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="StudentID">学生账号：</label>
                    <input type="text" readOnly="true" name="StudentID" value=<%=s.getStudentID()%>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="StudentName">学生姓名：</label>
                    <input type="text" name="StudentName" value=<%=s.getStudentName()%>/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="ClassID">学生班级号：</label>
                    <input type="text" name="ClassID" value=<%=s.getClassID() %>>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="StudentAge">学生年龄:</label>
                    <input type="text" name="StudentAge" value=<%=s.getStudentAge() %>>
                    <span >*</span>
                </div>
                <div>
                    <label >学生性别：</label>
                    <select name="StudentSex" id="StudentSex">
	               <option value="男" selected="StudentSex">&nbsp;&nbsp;男</option>
	               <option value="女" selected="StudentSex">&nbsp;&nbsp;女</option>
                  </select>
                </div>
                
                 <div>
                    <label >标志位：</label>
                    <select name="SIflag" id="StudentSex">
	               <option value="0" selected="SIflag">&nbsp;&nbsp;0</option>
	               <option value="1" selected="SIflag">&nbsp;&nbsp;1</option>
                  </select>
                </div>
               
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input style="line-height:10px;height:30px;width:90px;"  type="submit" value="确定">
                
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
                  <%
    	  }
       } 
    %>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>






