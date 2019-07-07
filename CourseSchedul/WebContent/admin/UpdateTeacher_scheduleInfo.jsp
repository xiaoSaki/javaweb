<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"  import="java.util.* , en.edu.lingnan.Dto.*" %>
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form action="updateTeacher_scheduleServlet">
       <% 
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String Tsno=request.getParameter("Tsno");
	   Vector<Teacher_scheduleDTO> v = new Vector<Teacher_scheduleDTO> ();
	    v = (Vector<Teacher_scheduleDTO>)session.getAttribute("allTeacher_scheduleInfo");
	    Iterator it = v.iterator();
	    Teacher_scheduleDTO tsdo = null;
	    while(it.hasNext())
	    {
	    	tsdo = (Teacher_scheduleDTO)it.next();
    	  System.out.println("+++++++++"+Tsno);
    	  if((tsdo.getTsno().trim()).equals(Tsno))
    	   {
    		  System.out.println("kkkkk");
    		//  System.out.println("-----------"+c.getRoomid());
       
    %>
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="Tsno">任课表编号：</label>
                    <input type="text" readOnly="true" name="Tsno" value=<%=tsdo.getTsno() %>/>
                    <span >*</span>
                </div>
                
                 <div>
                    <label for="TeacherID">教师编号：</label>
                    <input type="text" name="TeacherID" value=<%=tsdo.getTeacherID() %>/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="CourseID">课程编号：</label>
                    <input type="text" name="CourseID" value=<%=tsdo.getCourseID() %>/>
                    <span >*</span>
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






