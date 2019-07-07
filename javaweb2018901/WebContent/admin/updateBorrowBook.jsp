<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.BorrowBookDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link href="css/table.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form action="updateBorrowBookServlet">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：图书借阅管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form  action="">
	         <span>管理员：</span>
	         <input type="text" name="" value="" class="text-word" style="height:23px">
	         <input name="" type="button" value="查询" class="text-but" style="height:23px; width:55px">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
    <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">借阅者编号</th>
        <th align="center" valign="middle" class="borderright">借书时间</th>
        <th align="center" valign="middle" class="borderright">还书时间</th>
        <th align="center" valign="middle" class="borderright">到期时间</th>
        <th align="center" valign="middle" class="borderright">借书数量</th>
        <th align="center" valign="middle" class="borderright">还书状态</th>
        <th align="center" valign="middle" class="borderright">罚款金额</th>
        <th align="center" valign="middle">操作</th>
    </tr>
    <%
       request.setCharacterEncoding("GB2312");
	   response.setContentType("text/html;charset=GB2312");
	   String bbid=new String(request.getParameter("bbid").getBytes("ISO-8859-1"));
	   String bcid=new String(request.getParameter("bcid").getBytes("ISO-8859-1"));
       //String aid = request.getParameter("aid");
       Vector<BorrowBookDto> v = new Vector<BorrowBookDto> ();
       v = (Vector<BorrowBookDto>)session.getAttribute("allborrowbook");
       Iterator it = v.iterator();
       BorrowBookDto bb = null;
       while(it.hasNext())
       {
    	   bb = (BorrowBookDto)it.next();
    	   System.out.println("-----------"+bb.getBbid());
    	  // System.out.println("-------==="+bbid);
    	  if((bb.getBbid()).equals(bbid)&&(bb.getBcid()).equals(bcid))
    	   {
    		  System.out.println("wwwwwww 唯一");
       
    %>
    <tr>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" readOnly="true" name="bbid" value=<%=bb.getBbid()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" readOnly="true" name="bcid" value=<%=bb.getBcid()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" name="borrowtime" value=<%=bb.getBorrowtime()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" name="returntime" value=<%=bb.getBreturntime()%>></td>
        <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" name="duetime" value=<%=bb.getBduetime() %>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" name="mun" value=<%=bb.getBmun()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px" type="text" name="state" value=<%=bb.Breturnstate%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:100px;width:70px;width:70px" type="text" name="fine" value=<%=bb.getBfine()%>></td>
       <td align="center" valign="middle" class="borderright borderbottom"><input style="height:20px;width:72px;" type="submit" value="确定修改"></td> 
    </tr>
    <%
    	  }
    	  it.next();
       } 
    %>
    </table>
    </form>
</body>
</html>