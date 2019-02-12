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
<div align="center">
<div align="center">
<table>
<tr>
<td>
<font class="title2">出錯了</font>
</td>
</tr>
<tr>
<td>
<c:if test="${!empty error}">${error}</c:if>
</td>
</tr>
<tr>
<td>
<a href="javascript:history.go(-1)">返回</a>
</td>
</tr>
</table>
</div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>