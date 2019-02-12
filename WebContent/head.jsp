<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="center">
<img alt="" src="images/top.jpg">
</div>

<table align="center">
  <tr>
  <td colspan="3">
  <div class="top">
  	
 	<c:choose>
 		<c:when test="${empty user}">
 		您尚未
 		<a href="user_login.jsp">登錄</a>
 		<a href="user_reg.jsp"><b>註冊</b></a>
 		</c:when>
 		<c:when test="${!empty admin}">
 		<a href="UserServlet?method=exit"><b>退出</b></a>
 		管理員:${admin.name}
 		</c:when>
 		
 		<c:otherwise>
 		用戶名:${user.name}<a href="UserServlet?method=exit"><b>退出</b></a>
 		</c:otherwise>
 	
 	</c:choose>	
  |幫助|社群
  </div>
  </td>
  </tr>
  
  <tr>
  <td width="10%">
  <img alt="" src="images/gg.jpg">
  
  </td>
  <td width="60%">
  <marquee><font class="gg">公告:可以在這裡發表訊息,寫下祝福,寫下與青春有關的美好回憶</font></marquee>
  
  </td>
  <td align="center" width="30%" class="t1" >
  <div class="title">
  		
  		<a href="index.jsp">首頁</a>
  		
  		<c:choose>
  			<c:when test="${empty user}">
  				<a href="user_reg.jsp">註冊</a>
  				<a href="user_login.jsp">登入</a>
  			</c:when>
  			
  			<c:when test="${!empty admin}">
  				<a href="UserServlet?method=exit">退出</a>
  				管理員:${user.name}
  			</c:when>
  			
  			<c:otherwise>
  				<a href="UserServlet?method=exit">退出</a>
  				會員:${user.name}
  				<a href="message_post.jsp">我要留言</a>
  			</c:otherwise>
  		
  		
  		</c:choose>
  
  
  </div>
  
  </td>
  
  </tr>
  
</table>
