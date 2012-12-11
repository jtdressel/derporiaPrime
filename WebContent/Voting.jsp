<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

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

<link rel="stylesheet" type="text/css" href="derporiaStyle.css"/>

<script src="derporia.js"></script>

</head>

	<body>
	<h1><a href="Derporia.jsp">Derporia</a>: the never-ending land of <del>baseless</del> claims</h1> 
	<%@ page import="java.util.*, jdressel.DerporiaPrime.Assertion, java.util.Collections, java.util.ArrayList" %>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%@ page language="java"%>



	<%
	Object derp  = session.getAttribute("username")==null ? "" : session.getAttribute("username");

	session.setAttribute("loginRequester", "Voting.jsp");
	%>
	<jsp:include page="UsernameHeader.jsp" />
	




	<%
	Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
	if(d==null){
	%>
	<p>There are currently no claims :(</p>
	
	<% 	
	} else {
		%>
		
		<%	
		Set<Assertion> assertions = (Set<Assertion>)d;
		ArrayList<Assertion> sorted = new ArrayList<Assertion>(assertions);
		Collections.sort(sorted);
		
		for(Assertion assertion: sorted){
		%>

<table class="center">
	<tbody>
		<tr>
			<td>
				<p>Claim: <%= assertion.getName() %> <% if(assertion.getUN().equals(Utility.getUsername(derp))){%><a href="ProcessDeleteAssertion?id=<%= assertion.getId() %>">Delete Claim</a><% } %></p>
				<p>Support:<%= assertion.getBody() %></p>
				<p>By: <%=assertion.getUN() %></p>
			</td>
		</tr>
	</tbody>
</table>

<table class="center">
	<tbody>
   		<tr>
   			<td>
   				<table width = "100%">
					<tbody>
						<tr>
							<td align="left">
								<%= assertion.getDisagree() %> Disagree
								<br>
								<a class="red" href="ProcessVote?vote=disagree&id=<%= assertion.getId() %>">Vote Disagree</a>
							</td>
							<td align="center">
								<%= assertion.getUnsure() %> Unsure
								<br>
								<a class="yellow" href="ProcessVote?vote=unsure&id=<%= assertion.getId() %>">Vote Unsure</a>
							</td>
							<td align = "right">
							<%= assertion.getConvinced() %> Convinced
							<br>
							<a class="green" href="ProcessVote?vote=convinced&id=<%= assertion.getId() %>">Vote Convinced</a>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>
		
		
		
		<%	
		}
		%>
			
		
		
		
		<%	
	}
	
	%> 
	

	<hr>

	<br>
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
	
<h4>By James Robertson and James Dressel Homework 11</h4>
</body>
</html>

