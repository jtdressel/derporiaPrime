<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
<%
	String username = Utility.getUsername(session);
%>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 

	<div class="username">
		<form name="loginForm"  action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.DerporiaPrime.ProcessLogin" method="post">
			Log In: <input type="text" name="username" placeholder=Username onkeypress="checkEnter(event)"/>
			<input type="password" name="password" placeholder="password"/>
			<input class="regular" type="submit" value="Login" name="Log In"/>
			
			<a href="Register.jsp">register</a>
		</form>
	</div>
