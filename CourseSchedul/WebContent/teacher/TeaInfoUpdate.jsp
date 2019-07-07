<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>教师个人信息修改</title>
 <link rel="stylesheet" href="css/public.css"/>
 <link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.TeacherName.value==""){
		alert("教师姓名不能为空");
		form.TeacherName.focus();
		return false;
	}
	if(form.TeacherSex.value==""){
		alert("教师性别不能为空");
		form.TeacherSex.focus();
		return false;
	}
	if(form.TeacherTel.value==""){
		alert("教师手机号码不能为空");
		form.TeacherTel.focus();
		return false;
	}
	if(form.TeacherAge.value==""){
		alert("教师年龄不能为空");
		form.TeacherAge.focus();
		return false;
	}
	if(form.TeacherPwd.value==""){
		alert("教师登录密码不能为空");
		form.TeacherPwd.focus();
		return false;
	}
        alert("保存成功！");}	
</script>
<body>
<!--头部-->
<% String userid = request.getParameter("userid");
%>
<header class="publicHeader">
    <h1>高校排课管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="../login.html">退出</a>
    </div>
</header>
<!--时间-->
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
            <span>教师页面 >> 信息修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="teaInfoUpdate" name="form">
            
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
                        
                <!--div的class 为error是验证错误，ok是验证成功-->
                       <div class="">
                   <label for="providerId">教师ID:</label>
                    <input type="text" name="TeacherID" readOnly="true" id="providerId" value=<%=t.getTeacherID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">教师姓名:</label>
                    <input type="text" name="TeacherName" id="providerName" value=<%=t.getTeacherName() %> >
                    <span >*</span>
                </div>
                <div>
                    <label for="people">教师性别:</label>
                    <input type="text" name="TeacherSex" id="people" value=<%=t.getTeacherSex() %>/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">教师手机号码:</label>
                    <input type="text" name="TeacherTel" id="phone" value=<%=t.getTeacherTel() %>/>
                    <span></span>
                </div>
                <div>
                    <label for="address">教师年龄:</label>
                    <input type="text" name="TeacherAge" id="address" value=<%=t.getTeacherAge() %>>
                    <span></span>

                </div>
                <div>
                    <label for="fax">教师登录密码:</label>
                    <input type="text" name="TeacherPwd" id="fax" value=<%=u.getUserPsw() %>/>
                    <span></span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
                    <input type="submit" onClick="return check();" value="保存" />
                    <a href="http://localhost:8080/CourseSchedul/ok.jsp?userid=<%=userid %>"><input type="button" value="返回" /></a>
                </div>
                        
 <%
	}
%>
        
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
</html>