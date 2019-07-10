<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告发布</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>
<div id="container">
<div id="findstu">

	<table class="providerTable" cellpadding="0" cellspacing="0">       
       		<c:if test="${!empty Announcement }">
			<c:forEach items="${Announcement}" var="Announcement" varStatus="loop">
       				
				
       			<tr class="firstTr">                                     
                    <th style="text-align:left;">公告：${Announcement.text }</th>                  
                </tr>  
       			<tr class="firstTr">                                     
                    <th style="text-align:left;">发布人:${Announcement.user_name }|发布时间: ${Announcement.announcement_time }</th>
                     <th><a href="tstudent_management?action=deleteAnnouncement&announcement_id=${Announcement.announcement_id }&user_name=${Announcement.user_name }" class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a> </th>                 
                </tr> 
                          
			</c:forEach>
 			</c:if>	 
            </table>
          

</div>
</div>



</body>
</html>