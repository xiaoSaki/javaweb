<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>留言管理-更新</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>

<body>
	<div class="x-body">
		<form action="messageManageServlet?action=updateMessage" method="post"
			class="layui-form layui-form-pane">
   		<c:if test="${!empty messages }">
		<%-- <c:forEach items="${messages}" var="messages" varStatus="loop"> --%>
           <div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>编号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="mid" name="mid" value='${messages.mid}' readonly="true"
						required lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>

			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="name" name="name" value='${messages.name }'
						required lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>性别
				</label>
				<div class="layui-input-inline">
					<input type="text" id="sex" name="sex"
						value='${messages.sex }' required lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"><span
					class="x-red">*</span>联系电话 </label>
				<div class="layui-input-inline">
					<input type="text" id="tel" name="tel" value=${messages.tel } required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="name" class="layui-form-label">留言内容 </label>
				<div class="layui-input-inline">
					<input type="text" id="message" name="message" value='${messages.message }'
						autocomplete="off" class="layui-input">
				</div>
			</div>
			</tbody>
			</table>
	</div>
	<div class="layui-form-item">
		<input type="submit" class="layui-btn"
			style="margin-left: 220px; width: 150px;" " lay-submit=""
			value="提  交">
	</div>
<%-- </c:forEach> --%>
</c:if>
	</form>
	</div>
	<script src="./lib/layui/layui.js" charset="utf-8">
        </script>
	<script src="./js/x-layui.js" charset="utf-8">
        </script>
	<script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;

              //监听提交
              form.on('submit(save)', function(data){
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("成功", {icon: 6},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
                return false;
              });
            });
			
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