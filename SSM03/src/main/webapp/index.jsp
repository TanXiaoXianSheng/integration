<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setAttribute("rootpath", request.getContextPath());
	String basePath = request.getServerName() + ":"
			+ request.getServerPort();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
</head>
<script type="text/javascript" src="${rootpath }/resources/js/jqueryEasyUI/jquery.min.js"></script>
<script type="text/javascript" src="${rootpath }/resources/js/jqueryEasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${rootpath }/resources/css/themes/default/easyui.css"></script>
<script type="text/javascript" src="${rootpath }/resources/css/themes/icon.css"></script>
<body>
	<form id="loginFrom">
		<input type="text" id="userName" name="userName"><br/>
		<input type="password" id="input_password" name=""><br/>
		<input type="hidden" id="md5_password" name="password" ><br/>
		<!-- <input type="text" id="id" name="id"><br/> -->
		<input type="submit" value="submit">
		<input type="button" value="提交" onclick="checkForm()">
	</form>
</body>
<script type="text/javascript" src="${rootpath }/resources/js/index.js"></script>
<script type="text/javascript">
//var rootpath = getRootpath() || null;
var rootpath = '${rootpath}';
if(rootpath == null){
	alert("出错");
}
$(function(){
	    
})
function checkForm(){
	/* var input_password = document.getElementById("input_password");
	var md5_password = document.getElementById("md5_password");
	var userName = $("#userName").val();
	var password = $("#input_password").val();
	//这里可以进行加密
	md5_password.value = input_password.value; */
	$.ajax({
		url:rootpath + '/login/login',
		type:"GET",
		contentType:'application/json;charset=UTF-8',//get时候加
		//contentType: "application/x-www-form-urlencoded; charset=UTF-8",//post时候加，http默认的这个
		dataType:"json",
		data:{
			userName:$("#userName").val(),
			password:$("#input_password").val()
		},
		success:function(data){
			//0：登录失败   
			//1:登录成功
			if(data.result == "1"){
				window.location.href = "${rootpath }/jsp/success.jsp";
			}else{
				window.location.href = "${rootpath }/jsp/error.jsp";
			}
		}
	})
}

</script>
</html>