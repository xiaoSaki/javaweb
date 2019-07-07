<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>添加专业课程</title>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.CourseID.value==""){
		alert("课程ID不能为空");
		form.CourseID.focus();
		return false;
	} 
	if(form.MajorID.value==""){
		alert("专业ID不能为空");
		form.MajorID.focus();
		return false;
	}
	//var regm1= /^(《》)/
	//var regm1= /^[a-zA-Z_]+[a-zA-Z0-9]+$/
	//if(!form.username.value.match(regm1)){
	//	alert("对不起，您输入的用户名不合法，请输入2-7位中文");
		//alert("用户名输入不合法，请以字母或下划线开头");
	//	form.username.focus();
	//	return false;
	//}
	if(form.CourseName.value==""){
		alert("课程名称不能为空");
		form.CourseName.focus();
		return false;
	}
	//var regm2= /^([\u4e00-\u9fa5])$/
	//	if(!form.bstate.value.match(regm2)){
	//		alert("作者输入不合法，请输入可借或不可借");
		//	form.bstate.focus();
		//	return false;
		//}
	if(form.CourseTime.value==""){
		alert("课程学时不能为空");
		form.CourseTime.focus();
		return false;
	}
	if(form.YearTime.value==""){
		alert("学年不能为空");
		form.YearTime.focus();
		return false;
	}

	if(form.TermTime.value==""){
		alert("学期不能为空");
		form.TermTime.focus();
		return false;
	}
	if(form.ClassroomType.value==""){
		alert("教室类型不能为空");
		form.ClassroomType.focus();
		return false;
	}
	alert("保存成功！");
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
function CourseIdCheck(){ //当失去焦点时，会触发这个函数
    var request = createXmlHttpRequest();//创建对象
    var CourseID = document.all.CourseID.value;//获取username的值
    request.open("post","courseIDCheckServlet?CourseID="+CourseID);//调用后台的servlet
    request.send();
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                //document.all.username.value="该用户名已存在";
	                alert("该课程ID已存在");
	                form.CourseID.focus();
	                return false;
	        }
    	}
    }
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
            <span>专业课程管理页面 >> 专业课程添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="addMajorScheduleServlet" name="form">            
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">课程ID:</label>
                    <input type="text" name="CourseID" onBlur="CourseIdCheck()" id="providerId"/>
                    <span>*请输入课程ID</span>
                </div>
                <div>
                    <label for="providerName">专业ID:</label>
                    <input type="text" name="MajorID" onBlur="MajorIDcheck()" id="providerName"/>
                    <span >*请输入专业ID</span>
                </div>
                <div>
                    <label for="people">课程名称:</label>
                    <input type="text" name="CourseName" id="people"/>
                    <span>*请输入课程名称</span>

                </div>
                <div>
                    <label for="phone">课程学时:</label>
                    <select name="CourseTime" id="YearTime">
                    <option value="48学时" selected="CourseTime">&nbsp;&nbsp;48学时</option>
                    <option value="36学时" selected="CourseTime">&nbsp;&nbsp;36学时</option>
                    <option value="24学时" selected="CourseTime">&nbsp;&nbsp;24学时</option>
                    <option value="20学时" selected="CourseTime">&nbsp;&nbsp;20学时</option>
                    <option value="16学时" selected="CourseTime">&nbsp;&nbsp;16学时</option>
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
                    <select name=" EveryWeekCourseTime" id="ClassroomType">
                    <option value="普通" selected="ClassroomType">&nbsp;&nbsp;普通</option>
                    <option value="多媒体" selected="ClassroomType">&nbsp;&nbsp;多媒体</option>
                    </select>
                    
                    
                </div>
                <div>
                 <label for="phone">每周上课数:</label>
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
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>


    
