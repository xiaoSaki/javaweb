<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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
		
		<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
		
		<script type="text/javascript" src="js/jquery.SuperSlide.2.1.js"></script>
	</head>
	<!--header结束-->
<body>
	<div class="header"> 

		<div class="w1000">
	
	    	<p>你好${user.name }用户，欢迎光临雷州文化古城！                </p> 
	    	   <a href="userLogoutServlet" style="display:block;text-align: right;">退出系统</a>  
	
		</div>
	
	</div>
  <%  HttpSession se = request.getSession();
      List banarList = (List)se.getAttribute("banarList");
      List articleList = (List)se.getAttribute("articleList"); 
      List scenicList = (List)se.getAttribute("scenicList"); 
      List foodList = (List)se.getAttribute("foodList"); 
      List historicList = (List)se.getAttribute("historicList"); 
      %>	
	<div class="w1000">
		<div class="header_bottom">
			<a href="<%=basePath%>">
				<img src="images/logo.jpg" width="294" height="49" alt="" title="雷州文化古城">
			</a>
       		<ul>
            	<li>
            		<a href="<%=basePath%>User/Index"><span class="navli">网站首页</span></a>
            	</li>       
				<!-- 在页面上使用网站地址调用servlet的方法 -->
                <li>
                	<a href="<%=basePath%>historic/show.do">历史</a>
                </li> 
              
                <li>
                	<a href="<%=basePath%>User/culture.jsp">文化</a>
                </li>      

                <li>
                	<a href="<%=basePath%>User/Scenic?action=show">景点</a>
                </li>        
                <li>
                	<a href="<%=basePath%>User/Food?action=show">美食</a>
                </li>      
                <li>
                	<a href="<%=basePath%>User/Notice?action=show">动态</a>
                </li>          
                <li>
                	<a href="<%=basePath%>User/leave.jsp">留言</a>
                </li>   
				
				 <li>
				 	<a href="<%=basePath%>User/Team?action=show">团队介绍</a>
				 </li>      
                <li>
                	<a href="<%=basePath%>/User/Contact?action=show">联系我们</a>
                </li>
     	    </ul>  
    	</div>       
	</div>

<div class="container"> 		

		<!--banner开始-->

		<div class="banner"> 

            <div class="bd">

                <ul>
					
					<c:if test="${!empty banarList }">
					<c:forEach items="${banarList}" var="banar">
						<li style="background:url(${banar.image}) no-repeat center top;"></li>
					</c:forEach>
					</c:if>
                </ul>

            </div>

            <div class="hd">

                <ul>

                    <li></li>

                    <li></li>

                </ul>

            </div>

            <a class="prev" href="javascript:void(0)"></a>

            <a class="next" href="javascript:void(0)"></a>

        </div>
		 <!--调用JS模块图片滚动--> 
        <script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",delayTime:1000,interTime:5000,autoPlay:true, autoPage:true, trigger:"click" });</script>

		<!--banner结束--> 

		<!--content开始-->

		<div class="content"> 

			<p class="p_tit1">走进雷州</p>	

			<ul class="ul_jishu clearfix">
				<c:if test="${!empty articleList }">
					<c:forEach items="${articleList}" var="article" varStatus="stat">
						
						<li class="fl ml10">
							<a href="<%=basePath%>historic/look.do?aid=${article.aid}&pageNow=1">
								<object><a href="<%=basePath%>User/culture.jsp"><img src="${article.image}" width="291" height="126" alt="" title="" class="imgs"></a></object>
							</a>
							<p>
                    		<a href="<%=basePath%>historic/look.do?aid=${article.aid}&pageNow=1">${article.articlename}</a>
                    		<!--  ${article.content}-->  
                    		
                    		<c:if test="${stat.first}">
                    		    雷州名人，陈文玉(570～638)，齐康县(今海康县)榜山村人。公元631年出任雷州首任刺史，在职八年，励精图治，功绩显赫。
                    		    他出生在一个狩猎之家，少时生得貌相超群；年长又涉猎书传，具有过人的才智和武功。在职期间，精察吏治，天下人都称赞他清廉。
                    		</c:if>
                    		
                    		<c:if test="${stat.last}">
                    		    雷州话(Leizhou dialect )，即称雷语 ， 海内外雷人同胞的共同母语。雷州话和潮汕话同属闽南语系一支，
                    		   今湛江市属的雷州市、徐闻县等地都通行雷州话，为广东省四大方言之一。现出版有《雷州话注音字汇》、《雷州话方言词典》和《雷州话字典》等。
                    		</c:if>        
                    		      		                    		
                    		<c:if test="${stat.index == 1}">
                    		    雷州石狗是古代中国民间信仰之一。随着时间的推移，其狰狞、威严的面孔让人看后总会产生不友善的感觉。
                    		    于是，崇尚礼教的雷州劳动人民便对石狗的形象进行了艺术塑新，雕刻其昂首咧嘴、含笑露善，是雷州人民时代繁衍生息中遗留下的宝贵文化。 
                    		</c:if>
                    		<c:set var="isDone" value="1" scope="page"></c:set>
                    		
                    		</p>
                		</li>
                		
					</c:forEach>
				</c:if>
            </ul>	

			<!-- 走进雷州图片 -->
            <div class="feilei">
                <c:if test="${!empty scenicList }">
					<c:forEach items="${scenicList}" var="scenic" varStatus="number">
						<div class="fl${number.count } fldiv">
		                	<!--  <a href="<%=basePath%>User/Scenic?action=watch&stid=${scenic.stid}&aid=${scenic.aid}&pageNow=1"><img src="${scenic.image }" width="75" height="76" alt="" title=""></a>-->
		                    <a href="User/Scenic?action=show"><img src="${scenic.image }" width="75" height="76" alt="" title="" class="imgs"></a>
		                    <p><a href="User/Scenic?action=show">${scenic.sname }</a></p>
                		</div>
					</c:forEach>
				</c:if>
            </div>

            <div class="zjfc">

            	<p class="p_tit1">美食雷州</p>

                <div class="picScroll-left">

                    <div class="hd">

                        <a class="next"><</a>

                        <a class="prev">></a>

                	</div>
					
					<!-- 美食南宁图片 -->
                    <div class="bd">
                        <ul class="picList">
	                       <c:if test="${!empty foodList }">
								<c:forEach items="${foodList}" var="food">
									<li>
										<!--  <a href="<%=basePath%>User/Food?action=watch&aid=${food.aid}">-->
										<a href="User/Food?action=show">
										<div class="pic">
										<img src="${food.image }" width="231" height="151" class="imgs"/></div></a>
		                           	</li>
								</c:forEach>
							</c:if>
						</ul>
                    </div>

                </div>

        		<!--为美食南宁模块图片向左滚到--> 

                <script type="text/javascript">

                jQuery(".picScroll-left").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:4,trigger:"click"});

                </script>
			
            </div>

		</div>

		<!--content 结束--> 

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

