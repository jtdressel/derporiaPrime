<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia Please Login</title>

<!-- A project by James Dressel and James Robertson -->
<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/loginStyle.css"/>

<script src="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/login.js"></script>
</head>

<%
String refText = request.getHeader("referer");
session.setAttribute("loginRequester", refText);
%>



	<body>
	<h1><a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp">Derporia</a>: Please Login</h1> 
	
	<table class="center" border="1">
		<tbody>
			<tr>
				<td>
					<form name="loginForm"  onsubmit="return validateForm()" action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessLogin" method="post">

						<input type="text" class="login" name="username" autofocus="autofocus" placeholder="Username:" onkeypress="checkSubmit(event);return noEnter(event)">
						
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
			<input class="regular" type="submit" value="Login" name="Log In"/>
		</td>
		</tr>
		</tbody></table>
		</form>
		<p id="error"></p>
		
<h4>By James Robertson and James Dressel Homework 10</h4>
</body>
</html>
