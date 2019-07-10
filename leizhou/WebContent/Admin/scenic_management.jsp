<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>角色管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">

<script>
	function allcheck() {
		var checkObj = document.getElementsByName("check");//找出所有名为"check"的复选框
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = true; //让复选框中的被选中的值为true
	}

	function nocheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = false; //让复选框中的被选中的值为false
	}

	function backcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++)
			if (checkObj[i].checked)
				checkObj[i].checked = false;
			else
				checkObj[i].checked = true;

	}

	function allDelete() {
		var checkObj = document.getElementsByName("check");
		var arr = []; //定义arr数组
		var flag = false;
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				arr.push(checkObj[i].value);
				flag = true;
			}
		}
		alert(arr);
		if (flag) {		
			if (confirm("你确定要删除这些记录吗?"))
				location.href = "scenicManageServlet?action=deleteCheckScenic&arr=" + arr; //调用servlet			
		} else
			alert("至少要选择一条记录才能进行批量删除...");
	}
</script>

</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>角色管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="layui-icon" style="line-height: 30px"><img
				src="images/refresh.png" width="22" height="22"></i></a>
	</div>
	<div class="x-body">

		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="allDelete()">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>
		<button class="layui-btn"
			onclick="role_management_add('添加景点','scenic_management_add.jsp','900','500')">
			<i class="layui-icon"><img src="images/add.png" width="15"
				height="15"></i>&ensp;添加
		</button>
		
		<button class="layui-btn layui-btn-danger" id="btn1"
			onClick="allcheck();">
			<i class="layui-icon"></i>全选
		</button>
		<button class="layui-btn layui-btn-danger" id="btn2"
			onClick="nocheck();">
			<i class="layui-icon"></i>不选
		</button>
		<button class="layui-btn layui-btn-danger" id="btn3"
			onClick="backcheck();">
			<i class="layui-icon"></i>反选
		</button>
		
		<!-- <span class="x-right" style="line-height: 25px">共有数据：88 条</span></xblock> -->	
		<div style="width:520px;height:30px;float:right;display:inline-block">
			<form class="layui-form x-right " action="scenicManageServlet?action=findScenicLike" method="post" style="float:left;display:inline-block">
				<select name="stid" style="height:28px;float:left;font-size:17px;border:1px solid #e6e6e6;display:block;">
					<option value="" selected></option>
					<option value="1" >自然风光</option>
					<option value="2" >古色古香</option>
					<option value="3" >风土人情</option>
				</select>
				<div class="layui-input-inline" style="width: 300px;float:left">
					<input type="text" name="sname" placeholder="搜索内容"
						autocomplete="off" class="layui-input" style="height: 28px;">
				</div>
				<div class="layui-input-inline" style="width: 80px;float:right">
					<button class="layui-btn" lay-submit="" lay-filter="sreach">
						<i class="layui-icon">查询</i>
					</button>
				</div>
			</form>
		</div>
		</xblock>
	</div>
	<table class="layui-table">
		<thead>
			<tr>
				<th width="10%"><input type="checkbox" name="" value=""></th>								
				<th width="22%">类别</th>
				<th width="25%">景点名称</th>
				<th width="25%">图片路径</th>
				<!-- <th width="20%">发布人</th> -->
				<th width="18%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty scenicList }">
				<c:forEach items="${scenicList}" var="scenicList" varStatus="loop">
					<tr>
						<td><input type="checkbox" name="check" value=${scenicList.sid }></td>
						<c:if test="${1==scenicList.stid }">
							<td>自然风光</td>
						</c:if>
						<c:if test="${2==scenicList.stid }">
							<td>古色古香</td>
						</c:if>
						<c:if test="${3==scenicList.stid }">
							<td>风土人情</td>
						</c:if>
						<td>${scenicList.sname }</td>
						<td><img style="width:50%;height:50px;margin-top: 10px;margin-left: 68px;" 
							src="${pageContext.request.contextPath }/${scenicList.image }" /></td>
						<td class="td-manage"><a title="修改" href="javascript:;"
							onclick="role_management_update('修改景点','scenicManageServlet?action=findUpdateScenic&sid=${scenicList.sid }','900','500')"
							class="ml-5" style="text-decoration: none"> <i
								class="layui-icon"><img src="images/look2.png" width="15"
									height="15"></i>
						</a> &ensp;
								<a href ="scenicManageServlet?action=deleteScenic&sid=${scenicList.sid }"> <img src="images/shanchu.png" width="15"
									height="15">
						</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

	<div id="page"></div>
	</div>
	<br />
	<br />
	<br />
	<script src="./lib/layui/layui.js" charset="utf-8"></script>
	<script src="./js/x-layui.js" charset="utf-8"></script>
	<script>
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery;//jquery
			laydate = layui.laydate;//日期插件
			lement = layui.element();//面包导航
			laypage = layui.laypage;//分页
			layer = layui.layer;//弹出层

			//以上模块根据需要引入
			/* laypage({
				cont : 'page',
				pages : 100,
				first : 1,
				last : 100,
				prev : '<em><</em>',
				next : '<em>></em>'
			}); */
		});

		//批量删除提交
		function delAll() {
			layer.confirm('确认要删除吗？', function(allDelete) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
			});
		}
		//删除提交
		/* function delbyid() {
			layer.confirm('确认要删除吗？', function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
			});
		} */
		/*添加*/
		function role_management_add(title, url, w, h) {
			x_admin_show(title, url, w, h);
		}
		/*修改*/
		function role_management_update(title, url, w, h) {
			x_admin_show(title, url, w, h);
		}
		//修改密码
		function role_management_permissions(title, url, id, w, h) {
			x_admin_show(title, url, w, h);
		}
		//查看
		function role_management_look(title, url, id, w, h) {
			x_admin_show(title, url, w, h);
		}
		//编辑
		function role_management_edit(title, url, id, w, h) {
			x_admin_show(title, url, w, h);
		}
		/*删除*/
		
	</script>
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