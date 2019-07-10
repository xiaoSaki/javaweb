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

                <li><a href="<%=basePath%>User/Scenic?action=show">景点</a></li>        

                 <li><a href="<%=basePath%>User/Food?action=show">美食</a></li>      

                <li><a href="<%=basePath%>User/Notice?action=show">动态</a></li>          

                <li><a href="<%=basePath%>User/leave.jsp">留言</a></li>   
				
				 <li><a href="<%=basePath%>User/Team?action=show"><span class="navli">团队介绍</span></a></li>      

                <li><a href="<%=basePath%>/User/Contact?action=show">联系我们</a></li>

     		</ul>  

    </div>       

</div>
<!--header结束--> 
<div class="container"> 		

		<!--banner开始-->

		<div class="banner_erji">

        	<img src="../images/banner_erji.jpg" width="1000" height="187" alt="" title="">

        </div>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>其他目录</h1>

                	<ul class="ul_left">

                    

                    

        <li><h3><a href="<%=basePath%>/User/leave.jsp">给我留言</a></h3>

</li>

        

        <li><h3><a href="<%=basePath%>/User/Team">团队介绍</a></h3>

</li>

        

        <li><h3><a href="<%=basePath%>/User/Contact?action=show">联系我们</a></h3>
		
</li>

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

        	<div class="rightbar">

            	<div class="bread"><a href="../index.html">首页</a> > 团队介绍</div>

                

            	<div class="con_news">

                	<p class="p_tit2">

                    	<span>团队介绍</span>
                  </p>

                	<div class="con">

               		   <p>
               		   
               		   ${team.content}
               		   
	   						</p>

                    </div>

              </div>

            </div>

        </div>

		<!--content结束--> 
 
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

