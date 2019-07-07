<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>高校排课管理系统</title>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.CourseName.value==""){
		alert("课程名称不能为空");
		form.CourseName.focus();
		return false;	
}
	alert("保存成功!");
}
function createXmlHttpRequest(){
    var xmlreq = false;
    if (window.XMLHttpRequest){
        xmlreq = new XMLHttpRequest();
    }else
        if (window.ActiveXObject){
    	try{
    	    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
    	}catch(e1){
    	    try{
    	        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
    	    }catch(e2){
    	    }
    	}
    }
    return xmlreq;   	
}

function MajorIDcheck(){ //当失去焦点时，会触发这个函数 
    var request = createXmlHttpRequest();//创建对象
    var MajorID = document.all.MajorID.value;//获取userid的值
    request.open("post","majorIDCheckServlet?MajorID="+MajorID);//调用后台的servlet,要去web.xml里面写配置，然后写IdCheckServlet.java
    request.send();
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="false"){
	                alert("该专业ID不存在");
	                form.MajorID.focus();
	                return false;
	        }
    	}
    }
}
</script>
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
            <span>专业课程管理页面 >> 专业课程修改页</span>
        </div>
        <div class="providerAdd">


            <form action="updateMajorSchedule" name="form">
                <!--div的class 为error是验证错误，ok是验证成功-->
<%         
        String CourseID = request.getParameter("CourseID");
        MajorScheduleDAO mdao = new MajorScheduleDAO();
		Vector <MajorScheduleDTO> v = new Vector<MajorScheduleDTO> ();
		v=mdao.findMajorScheduleByID(CourseID);
        Iterator it = v.iterator();
        MajorScheduleDTO m = null;
        while(it.hasNext()){
	    m = (MajorScheduleDTO)it.next();
%>
                <div class="">
                   <label for="providerId">课程ID:</label>
                    <input type="text" name="CourseID" readOnly="true" id="providerId" value=<%=m.getCourseID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">专业ID:</label>
                    <input type="text" name="MajorID" id="providerName" value=<%=m.getMajorID() %> onBlur="MajorIDcheck()"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">课程名称:</label>
                    <input type="text" name="CourseName" id="people" value=<%=m.getCourseName() %>>
                    <span>*</span>

                </div>
                <div>
                    
                   <label for="phone">课程学时:</label>
                    <select name="CourseTime" id="YearTime">
                    <option value="48学时" selected="CourseTime">&nbsp;&nbsp;48学时</option>
                    <option value="32学时" selected="CourseTime">&nbsp;&nbsp;32学时</option>
                    <option value="24学时" selected="CourseTime">&nbsp;&nbsp;24学时</option>
                   
                    </select>
                    <span>*请选择课程学时</span>
                </div>
                <div>
                    <label for="address">学年:</label>
                    <select name="YearTime" id="YearTime">
                    <option value="大一" selected="YearTime">&nbsp;&nbsp;大一</option>
                    <option value="大二" selected="YearTime">&nbsp;&nbsp;大二</option>
                    <option value="大三" selected="YearTime">&nbsp;&nbsp;大三</option>
                    <option value="大四" selected="YearTime">&nbsp;&nbsp;大四</option>
                    </select>
                    <span></span>

                </div>
                <div>
                    <label for="fax">学期:</label>
                   <select name="TermTime" id="TermTime">
                    <option value="第一学期" selected="TermTime">&nbsp;&nbsp;第一学期</option>
                    <option value="第二学期" selected="TermTime">&nbsp;&nbsp;第二学期</option>
                    </select>
                    <span></span>

                </div>
                <div>
                    <label for="fax">教室类型:</label>
                    <select name="ClassroomType" id="ClassroomType">
                    <option value="普通" selected="ClassroomType">&nbsp;&nbsp;普通</option>
                    <option value="多媒体" selected="ClassroomType">&nbsp;&nbsp;多媒体</option>
                    </select>
                    <span></span>

                </div>
                
                <div>
                 <label for="phone">剩余排课数:</label>
                    <select name=" EveryWeekCourseTime" id="YearTime">
                    <option value="2" selected="EveryWeekCourseTime">&nbsp;&nbsp;2学时</option>
                    <option value="4" selected="EveryWeekCourseTime">&nbsp;&nbsp;4学时</option>
                  </select>
                  </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
                    <input type="submit" onClick="return check();" value="保存" />
                    <a href="MajorScheduleList.jsp"><input type="button" value="返回" /></a>

                </div>
<%
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
