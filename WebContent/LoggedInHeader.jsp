<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
<%
	String username = Utility.getUsername(session);
%>
<div class="username">
	You are logged in as <%= username %> <a href=ProcessLogout> Logout</a>
</div>
