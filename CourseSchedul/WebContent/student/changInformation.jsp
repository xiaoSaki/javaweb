<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,en.edu.lingnan.Dto.*,en.edu.lingnan.Dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="GB2312">
    <title>高校排课管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<script type="text/javascript">
function check(){
	if(form.StudentName.value==""){
		alert("学生姓名不能为空");
		form.StudentName.focus();
		return false;
	}
	if(form.StudentSex.value==""){
		alert("学生性别不能为空");
		form.StudentSex.focus();
		return false;
	}
	if(form.ClassID.value==""){
		alert("学生班级不能为空");
		form.ClassID.focus();
		return false;
	}
	if(form.StudentAge.value==""){
		alert("学生年龄不能为空");
		form.StudentAge.focus();
		return false;
	}
	if(form.UserPsw.value==""){
		alert("学生密码不能为空");
		form.UserPsw.focus();
		return false;
	}
        alert("保存成功！");}	
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
<% String UserID=request.getParameter("UserID"); %>
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
            <span>信息修改页面 </span>
        </div>   
        <div class="providerAdd">
        <form action="updateInfoServlet" name="form">
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
                <!--div的class 为error是验证错误，ok是验证成功-->
              <div class="">
                   <label for="providerId">学生编号:</label>
                    <input type="text" name="StudentID" readOnly="true" id="providerId" value=<%=s.getStudentID() %> />
                    <span>*</span>
                     </div> 
                <div>
                    <label for="providerName">学生姓名:</label>
                    <input type="text" name="StudentName" id="providerName" value=<%=s.getStudentName() %> >
                    <span >*</span>
                </div>
                <div>
                    <label for="people">学生性别:</label>
                    <input type="text" name="StudentSex" id="people" value=<%=s.getStudentSex() %>/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">班级编号:</label>
                    <input type="text" name="ClassID" id="phone" value=<%=s.getClassID() %>/>
                    <span></span>
                </div>
                <div>
                    <label for="address">学生年龄:</label>
                    <input type="text" name="StudentAge" id="address" value=<%=s.getStudentAge() %>>
                    <span></span>

                </div>
                <div>
                    <label for="fax">学生密码:</label>
                    <input type="text" name="UserPsw" id="fax" value=<%=u.getPassword() %>/>
                    <span></span>

                </div>
               
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input style="line-height:10px;height:30px;width:90px;"  type="submit" onClick="return check();" value="确定">
                
                    <input type="button" value="返回" onclick="history.back(-1)"/>
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






