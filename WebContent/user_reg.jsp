<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>用戶註冊</title>

<script type="text/javascript">

function reg(form){

		if(form.elements["username"].value==""){
			alert("使用者名稱不可以為空白");
			return false;
			}
		if(form.elements["userpwd"].value==""){
			alert("密碼不可以為空白");
			return false;
			}
		if(form.elements["userpwdconfirm"].value==""){
			alert("確認密碼不可以為空白");
			return false;
			}
		if(form.elements["userpwd"].value!=form.elements["userpwdconfirm"].value){
			alert("確認密碼與密碼不同");
			return false;
			}
		if(form.elements["useremail"].value==""){
			alert("E-Mail不可以為空白");
			return false;
			}
		
		return true;
	
}

</script>

</head>
<body>

<jsp:include page="head.jsp"></jsp:include>


<div class="div2" align="center">
<form action="UserServlet" method="post" onsubmit="return reg(this);">
<input type="hidden" name="method" value="userReg"/>
<table border="0" cellpadding="1" cellspacing="1">
<tr>
<td colspan="2">
	<font class="title2">用戶註冊</font>
</td>
</tr>
<tr>
<td>
使用者名稱
</td>
<td>
<input type="text" name="username" value="maxqiu" /><font color="red">*</font>不能有空格,可以是中文
</td>
</tr>
<tr>
<td>
密碼
</td>
<td><input type="password" name="userpwd" value="1234" /><font color="red">*</font>英文字母或數字
</td>
</tr>
<tr>
<td>
確認密碼
</td>
<td><input type="password" name="userpwdconfirm" value="1234"	/><font color="red">*</font>英文字母或數字
</td>
</tr>
<tr>
<td>電子郵件</td>
<td>
<input type="text" name="useremail" value="yueyiqiu100@gmail.com" /><font color="red">*</font><input type="checkbox"/>公開E-mail
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="送出"/>
<input type="reset" value="清除"/>
</td>

</tr>


</table>


</form>
</div>




<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>