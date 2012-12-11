<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
<%
	String username = Utility.getUsername(session);
%>
<div class="username">
	You are logged in as <%= username %> <a href=http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.DerporiaPrime.ProcessLogout> Logout</a>
</div>
