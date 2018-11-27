<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
</head>
<script type="text/javascript" src="/resources/js/jqueryEasyUI/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jqueryEasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/resources/css/themes/default/easyui.css"></script>
<script type="text/javascript" src="/resources/css/themes/icon.css"></script>
<body>
	<form action="/login/login" method="get" onsubmit="return checkForm()">
		<input type="text" id="userName" name="userName"><br/>
		<input type="password" id="input_password" name=""><br/>
		<input type="hidden" id="md5_password" name="password" ><br/>
		<!-- <input type="text" id="id" name="id"><br/> -->
		<input type="submit" id="submit" value="提交">
	</form>
</body>
<script type="text/javascript" src="/resources/js/index.js"></script>
<script type="text/javascript">
var rootpath = getRootpath() || null;
if(rootpath == null){
	alert("出错");
}
$(function(){
	    
})
function checkForm(){
	var input_password = document.getElementById("input_password");
	var md5_password = document.getElementById("md5_password");
	//这里可以进行加密
	/* md5_password.value = input_password.value;
	return true; */
	$.ajax({
		url:rootpath + '/login/login?id=1',
		contentType:'application/json',
		type:'get'
	})
}

</script>
</html>