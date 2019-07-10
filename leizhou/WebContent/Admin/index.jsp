<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>index</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
	<c:if test="${!empty user }">
		<%-- <c:forEach items="${userList}" var="userList" varStatus="loop"> --%>
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header header header-demo">
				<div class="layui-main">
					<a class="logo" href="./index.html"> <img
						src="images/banner2.png"></img>
					</a>
					<ul class="layui-nav" lay-filter="">
						<li class="layui-nav-item"><img src="images/0.jpg"
							class="layui-circle" style="border: 2px solid #A9B7B7;"
							width="35px" alt=""></li>
						<li class="layui-nav-item"><a href="javascript:;">admin</a>
							<dl class="layui-nav-child">
								<!-- 二级菜单 -->
								<dd>
									<a href="userManageServlet?action=findPerson&id=${user.id }">个人信息</a>
								</dd>
								<dd>
									<a href="../login_register.html">退出</a>
								</dd>
							</dl></li>
						<li class="layui-nav-item x-index"><a
							href="../login_register.html">注册登录</a></li>
					</ul>
				</div>
			</div>
			<div class="layui-side layui-bg-black x-side">
				<div class="layui-side-scroll">
					<ul class="layui-nav layui-nav-tree site-demo-nav"
						lay-filter="side">
						<!--用户管理-->
						<li class="layui-nav-item"><a class="javascript:;"
							href="javascript:;" _href="userManageServlet?action=findUser">
								<i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>用户管理</cite>
						</a></li>


						<!--  美景美食管理  -->
						<li class="layui-nav-item"><a class="javascript:;"
							href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>美景美食管理</cite>
						</a>
							<dl class="layui-nav-child">
								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="scenicManageServlet?action=findScenic"> <i
										class="layui-icon"></i><cite>景点管理</cite>
									</a>
								</dd>
								</dd>
								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="foodManageServlet?action=findFood"> <i
										class="layui-icon"></i><cite>美食管理</cite>
									</a>
								</dd>
								</dd>




							</dl></li>




						<!--历史文化数据管理-->
						<li class="layui-nav-item"><a class="javascript:;"
							href="javascript:;" _href="main.html"> <i class="layui-icon"
								style="top: 3px;">&#xe62d;</i><cite>内容数据管理</cite>
						</a>
							<dl class="layui-nav-child">
							
							    <dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="messageManageServlet?action=findMessage"> <cite>留言</cite>
									</a>
								</dd>
								</dd>
							
							
								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="admNoticeServlet?action=findNotice"> <cite>公告管理</cite>
									</a>
								</dd>
								</dd>
								
								<dd class="">
								<dd class="">
									<a href="javascript:;" _href="admBanarServlet?action=findBanar">
										<cite>导航管理</cite>
									</a>
								</dd>
								</dd>

								<dd class="">
								<dd class="">
									<a href="javascript:;" _href="admTeamServlet?action=findTeam">
										<cite>团队管理</cite>
									</a>
								</dd>
								</dd>

								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="admArticleServlet?action=findArticle"> <cite>文章管理</cite>
									</a>
								</dd>
								</dd>
								
								
								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="admNoticeTypeServlet?action=findNoticetype"> <cite>公告类型管理</cite>
									</a>
								</dd>
								</dd>
								

								<dd class="">
								<dd class="">
									<a href="javascript:;"
										_href="admArticletypeServlet?action=findArticletype"> <cite>文章类型管理</cite>
									</a>
								</dd>
								</dd>

							</dl></li>



					</ul>
				</div>
			</div>
			<div class="layui-tab layui-tab-card site-demo-title x-main"
				lay-filter="x-tab" lay-allowclose="true">
				<div class="x-slide_left"></div>
				<ul class="layui-tab-title">
					<li class="layui-this">用户管理 <i
						class="layui-icon layui-unselect layui-tab-close">ဆ</i>
					</li>
				</ul>
				<div class="layui-tab-content site-demo site-demo-body">
					<div class="layui-tab-item layui-show">
						<iframe frameborder="0" src="userManageServlet?action=findUser"
							class="x-iframe"></iframe>
					</div>
				</div>
			</div>

			<div class="site-mobile-shade"></div>
		</div>
		</div>
		<%-- </c:forEach> --%>
	</c:if>
	<script src="./lib/layui/layui.js" charset="utf-8"></script>
	<script src="./js/x-admin.js"></script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>