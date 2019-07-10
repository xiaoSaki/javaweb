<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script src="../js/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/xcConfirm.css"/>
    <script src="../js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn2").click(function(){
                var txt=  "确认退出吗？";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm);

            });
        });
        window.onload = function ()
        {
            var oCountDown = document.getElementById("countdown");
            var aInput = oCountDown.getElementsByTagName("input")[0];
            var timer = null;
            aInput.onclick = function ()
            {
                this.className == "" ? (timer = setInterval(updateTime, 1000),updateTime()) : (clearInterval(timer));
                this.className = this.className == '' ? "cancel" : '';
            };
            function format(a)
            {
                return a.toString().replace(/^(\d)$/,'0$1');
            }
            function updateTime ()
            {
                var aSpan = oCountDown.getElementsByTagName("span");
                var oRemain = aSpan[0].innerHTML.replace(/^0/,'') * 60 + parseInt(aSpan[1].innerHTML.replace(/^0/,''));
                if(oRemain <= 0)
                {
                    clearInterval(timer);
                    return;
                }
                oRemain--;
                aSpan[0].innerHTML = format(parseInt(oRemain / 60));
                oRemain %= 60;
                aSpan[1].innerHTML = format(parseInt(oRemain));
            }
            // 加上此句即可。
            aInput.click();
            aInput.style.display="none";
        }
        function mySubmit() {
        	$('#myFrom').submit();
    	}
    </script>
    <%
    	int result = 0;
    	if(request.getAttribute("result") != null){
    		result = Integer.valueOf(request.getAttribute("result").toString());
    	}
    	if(result == -1){
    %>
    		<script>
    		$(function(){
                alert("答题错误，请注意：你还剩一次作答机会！");
            });
    		</script>
    <%
    	}else if(result == -2){
    %>
    		<script>
    		$(function(){
                confirm("答题错误，错误累计次数已到达两次,自动退出并冻结");
				window.location.href='logout';
            });
    		</script>
    <%
    	}else if(result == -3){
    		%>
    		<script>
    		$(function(){
                alert("超时答题，用户冻结");
				window.location.href='logout';
            });
    		</script>
    		<%
    	}else if(result == 2){
    		%>
    		<script>
    		$(function(){
                alert("答题结束，恭喜你完成了考试");
				window.location.href='StudentIndex.jsp';
            });
    		</script>
    		<%
    	}
		session.setAttribute("result", 0);
    %>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <style type="text/css">
        .left-one{
            height: 143px;
        }
        .remind{
            position: absolute;
            left: 91px;
            top: 88px;
        }
        .middle-one{
            height: 143px;
            text-align: center;
            font-size: 41px;

        }
        .right-one{
            height: 143px;
            text-align: center;
        }
        .two{

        }
        .left-two{
            height: 372px;
            margin: 0;
            padding: 0;
        }
        .middle-two{
            border: 1px solid #5cb85c;
            height: 372px;
            margin: 0;
            padding: 0;
            text-align: center;

        }
        .right-two{
            /*border: 1px solid #5cb85c;*/
            height:372px;
            margin: 0;
            padding: 0;
            text-align: center;

        }
        .three{
            height: 91px;
            text-align: center;
        }
        .four{
            height: 320px;
        }
        .middle-four{
            height: 320px;
            border: 1px solid #4cae4c;
        }
        h2{
            font-size: 22px;

        }
        .answer,.topic{
            font-size: 19px;
        }
        .answer{
            position: absolute;
            left: 146px;
        }
        .bigcharacter{
            position: relative;
            top: 40px;
        }
        .red{
            color: red;
        }
        #submit{
            height: 35px;
            width: 68px;
            position: absolute;
            left: 771px;
            top: 272px;
        }
        .StudentNumber{
            position: absolute;
            top: 5px;
            left: 166px;
        }
        .name{
            position: absolute;
            top: 5px;
            left: 220px;
        }
        .quit{
            position: absolute;
            top: 5px;
            left: 264px;
            color: red;
        }
        .tip{
            position: absolute;
            left: 100px;
            top: 20px;
        }
        .choice{
            position: absolute;
            left: 711px;
            top: 20px;
        }
        .answer-sheet{
            font-size: 20px;
            text-align: center;
            position: absolute;
            top: 65px;
            left: 20px;

        }
        .hand{
            position: absolute;
            left: 240px;
        }
        .timeone{
            position: absolute;
            left: 25px;
            top: 15px;
        }
        .time{
            position: absolute;
            left: 90px;
            top: 15px;
        }
        .sgBtn{
            height: 35px;
            width: 40px;
            color: red;


        }

    </style>
    <title>正式考试</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--表示出现下面四个这样的行，单位是col-lg-3-->
        <div class="col-lg-3 left-one"><span class="remind"><span class="red">注意</span>：你已进入考试状态！</span></div>
        <div class="col-lg-6 middle-one"><span class="bigcharacter">生物考试系统</span></div>
        <div class="col-lg-3 right-one"><span class="StudentNumber">学号：</span><span class="name">姓名：</span>
            <!--<span class="quit">退出！</span>-->
            <div class="" style="height: 768px;">
                <div class="sgBtn" id="btn2"><span class="quit">退出</span></div>
            </div>

        </div>
    </div>
    <div class="row two">
        <div class="col-lg-1 left-two"></div>
        <div class="col-lg-8 middle-two">
            <h2 >考试题目</h2>
            <span class="topic"><%=session.getAttribute("seq_num") %>.<%=session.getAttribute("que_content") %></span>
            <div>
                <form action="stu_test_exam_answer" class="answer" id="myFrom" method="post">
                	<c:forTokens items="${sessionScope.que_options}" delims="|" var="option">
                    	<label><input type="radio" name="option" value="${option}" />${option}</label><br>
                	</c:forTokens> 
                </form>
            </div>
            <input type="button" class="btn onebtn" id="submit" onclick="mySubmit()" value="提交">
        </div>
        <div class="col-lg-3 right-two"><span class="timeone">时间还剩:&nbsp&nbsp</span>
            <div id="countdown" class="time">
                <span>60</span>分钟<span>00</span>秒
                <input type="button" value="开始" />
            </div>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                交卷提示!
                            </h4>
                        </div>
                        <div class="modal-body">
                            <h3>
                                确认交卷吗？
                            </h3>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">返回答题
                            </button>
                            <button type="button" class="btn btn-primary">
                                确认交卷
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <div class="answer-sheet">


                <table border="1" style="text-align: center">
                    <tr>
                        <td>17</td>
                        <td>18</td>
                        <td>19</td>
                        <td>20</td>
                        <td>21</td>
                        <td>22</td>
                        <td>23</td>
                        <td>24</td>
                    </tr>
                </table>

            </div>

        </div>
    </div>

    <div>
        <div class="col-lg-12 three">
           <span class="tip">
               考试提示：您只有两次作答机会，超过两次则需要重新登录
           </span>
    </div>
        <div class="container four">
            <div class="col-lg-1"></div>
            <div class="col-lg-8 middle-four">图片/视频信息</div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</div>
</body>
</html>
</html>
