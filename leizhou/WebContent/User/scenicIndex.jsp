
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>雷州文化古城</title>

<meta content="雷州文化古城" name="keywords" />

<meta content="雷州文化古城" name="description" />

<link href="../css/base.css" rel="stylesheet" type="text/css">

<link href="../css/pagename.css" rel="stylesheet" type="text/css">




</head>



<body>



<!--header-->

<div class="header"> 

	<div class="w1000">
	
	    	<p>你好${user.name }用户，欢迎光临雷州文化古城！                </p> 
	    	   <a href="userLogoutServlet" style="display:block;text-align: right;">退出系统</a>  
	
		</div>

</div>





<div class="w1000">

	<div class="header_bottom">

			<a href="<%=basePath%>"><img src="../images/logo.jpg" width="294" height="49" alt="" title="雷州文化古城"></a>

       		<ul>
            	<li><a href="<%=basePath%>User/Index">网站首页</a></li>       
				<!-- 在页面上使用网站地址调用servlet的方法 -->
              <li><a href="<%=basePath%>historic/show.do">历史</a></li> 
              
              <li><a href="<%=basePath%>User/culture.jsp">文化</a></li>      

                <li><a href="<%=basePath%>User/Scenic?action=show"><span class="navli">景点</span></a></li>        

               <%--  <li><a href="<%=basePath%>tourism/showtourism.do">旅游</a></li>    --%>   

                 <li><a href="<%=basePath%>User/Food?action=show">美食</a></li>      

                <li><a href="<%=basePath%>User/Notice?action=show">动态</a></li>          

                <li><a href="<%=basePath%>User/leave.jsp">留言</a></li>   
				
				 <li><a href="<%=basePath%>User/Team?action=show">团队介绍</a></li>      

                <li><a href="<%=basePath%>/User/Contact?action=show">联系我们</a></li>

     		</ul>  

    </div>       

</div>
<!--header结束--> 

<div class="container"> 		

		<!--banner-->

		<div class="banner_erji">

        	<img src="../images/banner_erji1.jpg" width="1000" height="187" alt="" title="">        </div>

		<!--banner end--> 

		

		<!--content-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>风景类别</h1>

                	<ul class="ul_left">
		               	<c:if test="${!empty scenictypelist }">
							<c:forEach items="${scenictypelist}" var="scenictype">					
					        <li><h3><a target="fengjing" href="<%=basePath%>/User/Scenic?action=showList&stid=${scenictype.stid}&pageNow=1">${scenictype.st}</a></h3></li>
					        </c:forEach>
						</c:if> 
         			</ul>

                 
                </div>

                <div class="left_lx">

                	<h1>联系方式</h1>
					  <p>地址：${contact.address}</p>

                      <p>联系人：${contact.contactname}</p>

                      <p>电话：${contact.tel}</p>

                      <p>QQ：${contact.qq}</p>

                      <p>网址：${contact.web}</p>

                      <p>邮编：${contact.zipcode}</p>

                </div>

            </div>
			<div class="iframe-container">
			   <iframe id="fengjing" name="fengjing" src="<%=basePath%>/User/Scenic?action=showList&stid=${firstscenictypeid}&pageNow=1"></iframe>
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

