<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>角色管理-添加</title>
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
		<form action="admArticleServlet?action=addArticle" method="post" class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>Atid
				</label>
				<div class="layui-input-inline">
					<input type="text" id="atid" name="atid" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>发布者编号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="publisher" name="publisher" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>文章名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="articlename" name="articlename" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>发布内容
				</label>
				<div class="layui-input-inline">
					<input type="text" id="content" name="content" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>发布时间
				</label>
				<div class="layui-input-inline">
					<input type="text" id="releasetime" name="releasetime" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="name" class="layui-form-label"> <span
					class="x-red">*</span>文章图片路径
				</label>
				<div class="layui-input-inline">
					<input type="text" id="image" name="image" required
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			
					</tbody>
				</table>
			</div>
			<!-- <div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 备注 </label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" id="desc" name="desc"
						class="layui-textarea"></textarea>
				</div>
			</div> -->
			<div class="layui-form-item">
				<input type="submit" class="layui-btn" style="margin-left:220px; width:150px;"" lay-submit="" value="提  交">
				<!-- <button class="layui-btn" style="margin-left:230px;" lay-submit="" lay-filter="save">保存</button> -->
				<!-- <button class="layui-btn" lay-submit="" lay-filter="cancel">取消</button> -->
			</div>
			
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
                layer.alert("保存成功", {icon: 6},function () {
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