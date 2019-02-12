<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>使用者登入</title>

<script type="text/javascript">

	function logincheck(form){

			



		
		}

</script>

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<c:choose>
	<c:when test="${empty user}">
	<form action="UserServlet" method="post">
	<input type="hidden" name="method" value="userLogin"/>
		<table align="center">
			<tr>
				<td colspan="2"><font class="title2">使用者登入</font></td>
			</tr>
			<tr>
				<td height="20" colspan="2"></td>
				
			</tr>
			<tr>
				<td align="right">用戶名:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td align="right">密碼:</td>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="reset" value="清除"/>
				<input type="submit" value="送出"/>
				</td>
				
			</tr>
		
		</table>
		</form>
	
	</c:when>
	
	<c:otherwise>
		
		<form action="MessageServlet" method="post">
		<input type="hidden" name="method" value="save"/>
			<table border="0" width="750" align="center" cellpadding="1" cellspacing="1">
				<tr>
				<td colspan="2" align="center" height="32"><font class="title2">我要留言</font></td>
				</tr>
				<tr>
				<td height="10" colspan="2"></td>
				</tr>
				<tr>
				<td align="right">標題</td>
				<td><input type="text" name="title" size="30"/></td>
				</tr>
				<tr>
				<td align="right">內容</td>
				<td><textarea rows="8" cols="50" name="content"></textarea></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="留言"/></td>
				
				</tr>
			
			</table>
		</form>
	
	
	</c:otherwise>


</c:choose>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>