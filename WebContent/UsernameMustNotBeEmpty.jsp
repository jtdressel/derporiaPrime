<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Error: Username cannot be empty</title>

<!-- A project by James Dressel and James Robertson -->
<link rel="stylesheet" type="text/css" href="derporiaStyle.css"/>

<script src="derporiaAssert.js"></script>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
</head>

	<body>
	<h1><a href="Derporia.jsp">Derporia</a> Please register with a valid username.</h1> 

					<form name="loginForm"  onsubmit="return validateForm()" action="ProcessRegistration" method="post">

						<input type="text" class="login" name="username" autofocus="autofocus" placeholder="Username:" onkeypress="checkSubmit(event);return noEnter(event)">
						<input type="password" class="login" name="password"  placeholder="Password" onkeypress="checkSubmit(event);return noEnter(event)">

			<input class="regular" type="submit" value="Register" name="Register"/>
		</form>
			
<h4>By James Robertson and James Dressel HW 11</h4>
</body>
</html>

