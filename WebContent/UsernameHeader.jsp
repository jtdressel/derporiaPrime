<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
</head>
<body>

<%
if (Utility.isLoggedIn(session)) {
%>
<jsp:include page="LoggedInHeader.jsp" />
<%
} else {
%>

<jsp:include page="LoginHeader.jsp" />
<%
}
%>

</body>
</html>