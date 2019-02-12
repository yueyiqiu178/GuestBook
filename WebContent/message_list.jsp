<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="head.jsp"></jsp:include>

<div id="div">

<c:choose>

<c:when test="${empty pagemodel.list}">


<div>沒有留言內容</div>


</c:when>
<c:otherwise>

<table>

<c:forEach items="${pagemodel.list}" var="item">


<tr>
<td>
<font class="title1">[${item.title}]</font>
</td>
<td>
<c:if test="${!empty admin}">
<c:if test="${empty item.reply}">
<a href="ManagerServlet?method=reply&id=${item.id}">回覆</a>
</c:if>
<a href="ManagerServlet?method=delete&id=${item.id}">刪除</a>
</c:if>
</td>
</tr>
<tr>
<td colspan="2">
<div class="td1">${item.content}</div>
</td>
</tr>
<tr>
<td colspan="2">
網友:${item.user.name}&nbsp;|&nbsp;時間:
<fmt:formatDate value="${item.createtime}" pattern="yyyy-dd-MM HH:mm:ss"/>
&nbsp;|&nbsp;聯絡方式:<a href="mailto:${item.user.email}">${item.user.email}</a>
</td>
</tr>

<c:if test="${!empty item.reply.content}">
<tr>
<td colspan="2">
<div>
<table>
<tr>
<td>
<img alt="" src="images/admin.jpg">
<font class="hf-title">管理員回復</font>
</td>
<td>
<c:if test="${!empty admin}">
<a href="ManagerServlet?method=reply&id=${item.id}">修改</a>
</c:if>
</td>
</tr>
<tr>
<td colspan="2">
${item.reply.content}
</td>
</tr>
<tr>
<td>
回覆時間:<fmt:formatDate value="${item.reply.replytime}" pattern="yyyy-dd-MM HH:mm:ss"/>
</td>
</tr>
</table>
</div>
</td>
</tr>
</c:if>

<tr>
<td>
<hr>
</td>
</tr>
</c:forEach>

<tr>
<td colspan="2">
<div>
總記錄數:${pagemodel.totalRows}
當前頁${pagemodel.currentpage}/${pagemodel.totalPage}
<a href="MessageServlet?method=view&currentpage=${pagemodel.previousPage}">上一頁</a>
<a href="MessageServlet?method=view&currentpage=${pagemodel.nextPage}">下一頁</a>
<select>
<c:forEach begin="1" end="${pagemodel.totalPage}" varStatus="ptr">
<c:choose>
<c:when test="${pagemodel.currentpage ne ptr.count}">
<option value="${ptr.count}">第${ptr.count}頁</option>
</c:when>
<c:otherwise>
<option value="${ptr.count}">第${ptr.count}頁</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</div>
</td>
</tr>

</table>
</c:otherwise>
</c:choose>


</div>


<jsp:include page="bottom.jsp"></jsp:include>

</body>
</html>