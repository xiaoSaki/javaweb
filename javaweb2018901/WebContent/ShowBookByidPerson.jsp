<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* , en.edu.lingnan.Dto.BooksDto"%>
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
     <form action="showBookByidPersonServlet">
   <table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：图书查询</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	          
	         <span>用户：</span>
	         <input type="text" name="Bid"  id="bid" class="text-word" style="height:23px" >
	         <input name="submit" type="submit" value="查询" class="text-but" style="height:23px; width:55px">
            
         </td>
  		 
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="person_mian.html" target="mainFrame" onFocus="this.blur()" class="add">返回</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">

     <tr>
        <td></td>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">索书号</th>
        <th align="center" valign="middle" class="borderright">书名</th>
        <th align="center" valign="middle" class="borderright">作者</th>
        <th align="center" valign="middle" class="borderright">价格</th>
        <th align="center" valign="middle" class="borderright">状态</th>
        <th align="center" valign="middle" class="borderright">数量</th>
        <th align="center" valign="middle" class="borderright">操作</th>
      </tr>
    <%
    
    Vector<BooksDto> v = new Vector<BooksDto> ();
    HttpSession s = request.getSession();
    v = (Vector<BooksDto>)s.getAttribute("allbook");
    Iterator it =v.iterator(); 
    BooksDto b = null;
    while(it.hasNext())
    {
       
 	   b = (BooksDto)it.next();
    %>
     <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
     
       <td align="center" valign="middle" class="borderright borderbottom"><input type="checkbox" name="check" value="<%=b.getBookId() %>"></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBookId()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBreference_number() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBookName()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBookauthor()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%=b.getBprice()%></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getBookstate() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><%= b.getNum() %></td>
       <td align="center" valign="middle" class="borderright borderbottom"><a href="BorrowBookPerson.jsp?bid=<%=b.getBookId()%>">借书</a></td>
    </tr>
    <% 
       }
    %>
  
    </table>
    </td>
    </tr>
    </table>
    </form>
</body>
</html>