<%@page import="com.sun.webkit.ContextMenu.ShowContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
	function t1() {
		
	}
</script>
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
				<!-- 在页面上使用网站地址调用servlet的方法 -->
              <li><a href="<%=basePath%>historic/show.do"><span class="navli">历史</span></a></li> 
              
              <li><a href="<%=basePath%>User/culture.jsp">文化</a></li>      

                <li><a href="<%=basePath%>User/Scenic?action=show">景点</a></li>        

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

		<!--banner开始-->

		<div class="banner_erji">

        	<img src="images/banner_erjiHistory.jpg" width="1000" height="187" alt="" title="">

        </div>

		<!--banner结束--> 

		<!--content开始-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>热点文章</h1>
                	<ul class="ul_left">
						<c:if test="${!empty articleList}">
							<c:forEach items="${articleList }" var="article" begin="0" end ="1">
								<li><h3><a target="historic" href="<%=basePath %>historic/watch.do?aid=${article.aid}&pageNow=1">${article.articlename }</a></h3></li>
							</c:forEach>
						</c:if>
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
			<iframe id="historic" name="historic" src="<%=basePath%>historic/showlist.do?pageNow=1"  style="float:right;width:712px;height:665px;border:1px solid #cccccc;background-color:white;"></iframe>
        
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
	<c:if test="${param.type == '1'}">
		<script type="text/javascript">
			t1();
			document.getElementById('historic').src="historic/watch.do?aid=" + ${param.aid} + "&pageNow=1";
		</script>
	</c:if>
</html>

