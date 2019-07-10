<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


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
	</head>



<body>


<!--header-->

<div class="header"> 

	<div class="w1000">

    	<p>你好，欢迎光临雷州文化古城！</p>

	</div>

</div>





<div class="w1000">

	<div class="header_bottom">

			<a href="<%=basePath%>"><img src="images/logo.jpg" width="294" height="49" alt="" title="雷州文化古城"></a>

       		<ul>
            	<li><a href="<%=basePath%>User/Index">网站首页</a></li>       
				<!-- 在页面上使用网站地址调用控制器的方法 -->
                <li><a href="<%=basePath%>historic/show.do">历史</a></li>     

                <li><a href="<%=basePath%>User/culture.jsp">文化</a></li>        

                <li><a href="<%=basePath%>User/Scenic?action=show">景点</a></li>      

                <li><a href="<%=basePath%>User/Food?action=show">美食</a></li>      

                <li><a href="<%=basePath%>User/Notice?action=show">动态</a></li>      

                <li><a href="<%=basePath%>/User/Leave?action=showList">留言</a></li>   
				
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
	                  <hr />
	             </div>

         	</div>

        	<div class="rightbar">
            	
            	<div class="bread">
          		<a href="User/Index" style="float:left">首页</a>>查看留言 
          		<form method="post" action="<%=basePath %>/User/Leave?action=search&pageNow=1">
	          		<div style="width:200px;height:25px;float:right;">
	          			<input type="text" name="name" style="float:left;width:100px;height:30px;margin-top:5px;"/>
	          			<input type="submit" style="width:50px;height:30px;float:left;margin-top:5px;" value="搜索"/>
	          		</div>
          		</form>
          	</div>
            	
            	
            	
                <div class="contact_nei">
					 <form id="feedback_form" name="feedback_form" method="post" action="<%=basePath%>/User/Leave?action=show">
					
						 <c:forEach items="${messagearticleList }" var="message">
						
						    <p class="mesContent">昵称：${message.name }  &nbsp; &nbsp; &nbsp; &nbsp;性别：${message.sex }</p>
						<p class="mesContent">留言内容：</p>	
						<div class="mesCss">
						    <p>${message.message}</p>  	
						</div>
						<hr style="background-color:#daddde; height:1px; border:none; margin-left:0px; width:600px;">
						</c:forEach> 				
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
		<a href="<%=basePath%>User/Scenic?action=show">景点</a> | 		 
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

