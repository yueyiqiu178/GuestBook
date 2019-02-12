<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<form action="MessageServlet" method="post">
<input type="hidden" name="method" value="save"/>
<table>
<tr>
<td colspan="2">
<font class="title2">我要留言</font>
</td>
</tr>
<tr>
<td align="right">
標題
</td>
<td>
<input type="text" size="30" name="title"/>
</td>
</tr>
<tr>
<td align="right">
內容
</td>
<td>
<textarea rows="8" cols="50" name="content"></textarea>
</td>
</tr>
<tr>
<td colspan="2" align="center" height="50">
<input type="submit" value="留言"/>
</td>
</tr>
</table>
</form>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>