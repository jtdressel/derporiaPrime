<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Derporia: Register</title>
<!-- A project by James Dressel and James Robertson -->
<script language="JavaScript">
<!--/* Doesnt Work
var N = navigator.appName;
var ua = navigator.userAgent; 
var tem;
 
var M = ua.match(/(opera|chrome|safari|firefox|msie)\/?\s*(\.?\d+(\.\d+)*)/i);

if(ua.match(/(chrome|safari|msie)\/?\s*(\.?\d+(\.\d+)*)/i)){
document.write("<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaStyle.css"/>");
}

else{
document.write("<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaStyle2.css"/>");
}
*/-->
</script>

<link rel="stylesheet" type="text/css" href="loginStyle.css"/>

<script src="derporia.js"></script>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
</head>

	<body>
	<h1><a href="Derporia.jsp">Derporia</a>: Please Register</h1> 
	
	<table class="center" border="1">
		<tbody>
			<tr>
				<td>
					<form name="loginForm"  onsubmit="return validateForm()" action="ProcessRegistration" method="post">

						<input type="text" class="login" name="username" autofocus="autofocus" placeholder="Username:" onkeypress="checkSubmit(event);return noEnter(event)">
						<input type="password" class="login" name="password"  placeholder="Password" onkeypress="checkSubmit(event);return noEnter(event)">
				</td>
			</tr>
		</tbody>
	</table>
		
		<table class="center">
		<tbody><tr>
		<td align="left">
			<button type="button" onclick="resetForm()">Clear</button> 
		</td>
		<td align="right">
			<input class="regular" type="submit" value="Register" name="Register"/>
		</td>
		</tr>
		</tbody></table>
		</form>
		<p id="error"></p>
		
<h4>By James Robertson and James Dressel Homework 11</h4>
</body>
</html>