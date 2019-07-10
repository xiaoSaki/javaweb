<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>

<html>

<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>雷州文化古城</title>

<meta content="雷州文化古城" name="keywords" />

<meta content="雷州文化古城" name="description" />

<link href="css/base.css" rel="stylesheet" type="text/css">

<link href="css/pagename.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/leave.js"></script>


<script type="text/javascript">
	

	function checkMobile() {
		
		 var Str=document.getElementById("txtUserTel").value;
		 RegularExp=/^[0-9]{11}$/
		 if (RegularExp.test(Str)) {
		  return true;
		 }
		 else {
		  alert("手机号格式不正确！应该为11位长度的数字！");
		  return false;
		 }
	}
	
  
	
	
	function freset(obj){
		  obj.reset();
		}
</script>


</head>



<body>


<!--header-->

<div class="header"> 

	<div class="w1000">
	
	    	<p>你好${user.name }用户，欢迎光临雷州文化古城！                </p> 
	    	   <a href="userLogoutServlet" style="display:block;text-align: right;">退出系统</a>  
	
		</div>

</div>


<%-- <%
	String yzmcw = (String)request.getAttribute("yzmcw");
	String bnwk = (String)request.getAttribute("bnwk");
	String crcg = (String)request.getAttribute("crcg");
	if(yzmcw!=null){
		out.print("<script>alert('留言失败，验证码不正确，点击返回')</script>");
	}if(bnwk!=null){
		out.print("<script>alert('信息不能为空，点击返回')</script>");
	}if(crcg!=null){
		out.print("<script>alert('留言成功，点击返回')</script>");
	}
	
%> --%>


<div class="w1000">

	<div class="header_bottom">

			<a href="<%=basePath%>"><img src="images/logo.jpg" width="294" height="49" alt="" title="雷州文化古城"></a>

       		<ul>
            	<li><a href="<%=basePath%>User/Index">网站首页</a></li>       
				<!-- 在页面上使用网站地址调用servlet的方法 -->
              <li><a href="<%=basePath%>historic/show.do">历史</a></li> 
              
              <li><a href="<%=basePath%>User/culture.jsp">文化</a></li>      

                <li><a href="<%=basePath%>User/Scenic?action=show">景点</a></li>        

               <%--  <li><a href="<%=basePath%>tourism/showtourism.do">旅游</a></li>    --%>   

                 <li><a href="<%=basePath%>User/Food?action=show">美食</a></li>      

                <li><a href="<%=basePath%>User/Notice?action=show">动态</a></li>          

                <li><a href="<%=basePath%>User/leave.jsp"><span class="navli">留言</span></a></li>   
				
				 <li><a href="<%=basePath%>User/Team?action=show">团队介绍</a></li>      

                <li><a href="<%=basePath%>/User/Contact?action=show">联系我们</a></li>

     		</ul>  

    </div>       

</div>
<!--header结束--> 

<div class="container"> 		

		<!--banner-->

		<div class="banner_erji">

        	<img src="images/banner_erji6.jpg" width="1000" height="187" alt="" title="">        </div>

		<!--banner end--> 

		

		<!--content-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>其他目录</h1>

                	<ul class="ul_left">

                    
		 <li>
          <h3><a href="<%=basePath%>User/Index">网站首页</a></h3>

</li>
                    

        <li>
        <h3><a href="<%=basePath%>/User/Leave?action=showList">给我留言</a></h3>
	</li>

       


        <li>
          <h3><a href="<%=basePath%>User/Team?action=show">团队介绍</a></h3>

</li>


        

        <li>
          <h3><a href="<%=basePath%>/User/Contact?action=show">联系我们</a></h3>
		
</li>

        <li>
          <h3><a href="<%=basePath%>/User/Leave?action=show">查看留言</a></h3>
		
</li>


        

         	</ul>

                 
              </div>

                 <div class="left_lx">

                	<h1>联系方式</h1>

                    <p>地址：${contact.address }</p>

                      <p>联系人：${contact.contactname }</p>

                      <p>电话：${contact.tel }</p>

                      <p>QQ：${contact.qq }</p>

                      <p>网址：${contact.web }</p>

                      <p>邮编：${contact.zipcode }</p>

                </div>

            </div>

        	<div class="rightbar">

            	<div class="bread"><a href="User/Index">首页</a> >给我留言</div>

                <div class="contact_nei">
 <form id="feedback_form" name="feedback_form" method="post" action="<%=basePath%>/User/Leave?action=rightshow">
	<ul>
		<li>
			<label>您的称呼：</label><input id="txtUserName" name="txtUserName" type="text" readonly="true"  value='${user.name}' class="yuyue_in" stype="padding-left:3px;"/> 
		</li>
		<li>
			<label>您的电话：</label><input id="txtUserTel" name="txtUserTel" type="text" onblur="checkMobile()" class="yuyue_in" stype="padding-left:3px;" /> 
		</li>
		<li>
			<label>您的性别：</label><input type="radio" class="yuyue_ra" name="txtUserSex" value="男" checked /> <em>男</em> <input name="txtUserSex" value="女" type="radio" class="yuyue_ra" /> <em>女</em></li>
		<li>
			<label>你的留言：</label><textarea id="txtContent" name="txtContent" cols="" rows="" class="yuyue_te" stype="padding-left:3px;"></textarea> 
		</li>
		<li>
			<div class="line" style="margin-top:10px;">
                <div id="yzmtext">验证码：</div>
                <input type="text" class="login_inout2" id="check" name="check"  autocomplete="off"/>
                <div id="yzm" onclick="shuaxin()" style="cursor:pointer;"></div>
                <input type="hidden" name="yzm" id="yzm2"/>
            </div>
		<li>
			<input type="submit" name="btnSubmit" id="btnSubmit"  value="留言" class="btn"/>
			 <input name="" type="reset" value="重置" class="btn"  onclick="freset(obj)" /> 
		</li>
	</ul>
</form>
          

                </div>
               
               
               
            </div>
        </div>


		<!--content end--> 

</div>

<!--footer开始-->

<div class="footer"> 
	<p>
		<a href="<%=basePath%>User/Index">首页</a> | 
		<a href="<%=basePath%>historic/show.do">历史</a> | 
		<a href="<%=basePath%>User/culture.jsp">文化</a> |
		<a href="<%=basePath%>User/Scenic?action=show">风景</a> | 		 
		<a href="<%=basePath%>User/Food?action=show">美食</a> | 
		<a href="<%=basePath%>User/Notice?action=show"">动态</a> | 
		<a href="<%=basePath%>User/leave.jsp">留言</a>| 
		<a href="<%=basePath%>/User/Contact?action=show">联系我们</a>
	</p>
    <p>
   		Copyright &copy; 2018－2019 All Rights Reserved 版权所有 XXXXXXXXXXXXXXXXXX
    </p>
    <p>
       	地址：广东省湛江市赤坎区岭南师范学院
    </p>
</div>



<!--footer 结束--> 

</body>

</html>

