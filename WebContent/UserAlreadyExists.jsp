<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Error: Username is already in use</title>

<!-- A project by James Dressel and James Robertson -->
<link rel="stylesheet" type="text/css" href="derporiaStyle.css"/>

<script src="derporiaAssert.js"></script>
</head>

	<body>
	<h1><a href="Derporia.jsp">Derporia</a> Username is already in use</h1> 
	Did you mean to <a href="Login.jsp">Login</a>? If so please <a href="Login.jsp">click here</a>.Otherwise please pick a different username and register below. 
 

					<form name="loginForm"  onsubmit="return validateForm()" action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.DerporiaPrime.ProcessRegistration" method="post">

						<input type="text" class="login" name="username" autofocus="autofocus" placeholder="Username:" onkeypress="checkSubmit(event);return noEnter(event)">
						<input type="password" class="login" name="password"  placeholder="Password" onkeypress="checkSubmit(event);return noEnter(event)">

			<input class="regular" type="submit" value="Register" name="Register"/>
		</form>
			
<h4>By James Robertson and James Dressel HW 11</h4>
</body>
</html>

