<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 

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