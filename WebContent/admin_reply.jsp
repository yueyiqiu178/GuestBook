<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty message}">
<c:set var="error" value="出錯了,訊息是空的" scope="request"></c:set>
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<div align="center">
<table>
<tr>
<td colspan="2">
回覆留言
</td>
</tr>
<tr>
<td>
標題:
</td>
<td>
&nbsp;${message.title}
</td>
</tr>
<tr>
<td>
內容:
</td>
<td>
&nbsp;${message.content}
</td>
</tr>
<tr>
<td>
網友:
</td>
<td>
&nbsp;${message.user.name}
</td>
</tr>
<tr>
<td>
回覆留言:
</td>
<td>
<form action="ManagerServlet" method="post">
<table>
<tr>
<td>
<input type="hidden" name="method" value="saveOrUpdateReply"/>
<input type="hidden" name="id" value="${message.id}"/>
<textarea rows="5" cols="50" name="content">
${message.reply.content}
</textarea>
</td>
<td>
<input type="submit" value="回覆"/>
</td>
</tr>
</table>
</form>
</td>
</tr>
</table>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>