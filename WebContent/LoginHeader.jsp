<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
<%
	String username = Utility.getUsername(session);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
</head>
<body>
	<div class="username">
		<form name="loginForm"  action="ProcessLogin" method="post">
			Log In: <input type="text" name="username" placeholder=Username onkeypress="checkEnter(event)"/>
			<input type="password" name="password" placeholder="password"/>
			<input class="regular" type="submit" value="Login" name="Log In"/>
			
			<a href="Register.jsp">register</a>
		</form>
	</div>
</body>
</html>