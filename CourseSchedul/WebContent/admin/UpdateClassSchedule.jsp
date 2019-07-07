<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>修改班级课程表</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>高校排课管理系统</h1>

	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！
		</p>
		<a href="../login.html">退出</a>
	</div>
	</header>
	<!--时间-->
	<%String UserID=(String)session.getAttribute("user"); %>
	<section class="publicTime"> <span id="time">2015年1月1日11:11
		星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
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
			<strong>你现在所在的位置是:</strong> <span>更新课程表管理页面</span>
		</div>
		<div class="search"></div>
    <form action="updateClassScheduleServlet">
	<% 
	String ClassScheduleID = request.getParameter("ClassScheduleID");
	Vector<ClassScheduleDTO> v1 = new Vector<ClassScheduleDTO>();
	v1 = (Vector<ClassScheduleDTO>) session.getAttribute("classSchedule");
	Iterator it = v1.iterator();
	ClassScheduleDTO sdto = null;
	while (it.hasNext()) {
		sdto = (ClassScheduleDTO) it.next();
		if ((sdto.getClassScheduleID().trim())
				.equalsIgnoreCase(ClassScheduleID)) {
    		//  System.out.println("-----------"+c.getRoomid());
       
    %>
    <div class="providerAdd">
    <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="cid">课程表编号：</label>
                    <input type="text" readOnly="true" name="ClassScheduleID" value=<%=sdto.getClassScheduleID()%>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="useid">班级编号：</label>
                    <input type="text" name="ClassID" value=<%=sdto.getClassID() %>>
                    <span >*</span>
                </div>
                
                  <div>
                    <label for="useid">课程编号：</label>
                    <input type="text" name="CourseID" value=<%=sdto.getCourseID() %>>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="weekday">星期**：</label>
                    <select name="WeekDay" id="WeekDay">
	               <option value="星期一" selected="weekday">&nbsp;&nbsp;星期一</option>
	               <option value="星期二" selected="weekday">&nbsp;&nbsp;星期二</option>
	               <option value="星期三" selected="weekday">&nbsp;&nbsp;星期三</option>
	               <option value="星期四" selected="weekday">&nbsp;&nbsp;星期四</option>
	               <option value="星期五" selected="weekday">&nbsp;&nbsp;星期五</option>
	               <option value="星期六" selected="weekday">&nbsp;&nbsp;星期六</option>
	               <option value="星期天" selected="weekday">&nbsp;&nbsp;星期天</option>
                  </select>
                </div>

                <div>
                    <label >节数：</label>
                    <select name="ClassTime" id="classtime">
	               <option value="12节" selected="ClassTime">&nbsp;&nbsp;12节</option>
	               <option value="34节" selected="ClassTime">&nbsp;&nbsp;34节</option>
	               <option value="56节" selected="ClassTime">&nbsp;&nbsp;56节</option>
	               <option value="78节" selected="ClassTime">&nbsp;&nbsp;78节</option>
                  </select>
                </div>
               
               <div>
                    <label for="TeacherID">教师编号：</label>
                    <input type="text" readOnly="true" name="TeacherID" value=<%=sdto.getTeacherId()%>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="ClassroomID">教室编号：</label>
                    <input type="text" name="ClassroomID" value=<%=sdto.getClassroomID() %>>
                    <span >*</span>
                </div>     
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input style="line-height:10px;height:30px;width:90px;" type="submit" value="确定">
                
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