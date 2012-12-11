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

<link rel="stylesheet" type="text/css" media="screen" href="votingStyle.css" />


<script src="votingStyle.js" /> </script>


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
	<h1><a href="Derporia.jsp">Derporia</a>: the never-ending land of <del>baseless</del> claims</h1> 
		<hr>

	<br>
	
	<%@ page import="java.util.*, jdressel.DerporiaPrime.Assertion, java.util.Collections, java.util.ArrayList" %>
	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%Utility.load(application);%> 
	<%@ page language="java"%>



	<%
	
	Object derp  = session.getAttribute("username")==null ? "" : session.getAttribute("username");
	session.setAttribute("loginRequester", "Voting.jsp");
	%>
	<jsp:include page="UsernameHeader.jsp" />
	
	


	<%
	Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
	Set<Assertion> emptyCheck = null;
	
	try{ 
		emptyCheck = (Set<Assertion>)d;
	} catch (Exception e){
		
	}
	//TODO redo this to ensure type safety
	if((d==null)||(emptyCheck.isEmpty())){
	%>
	<p>There are currently no claims :(</p>
	
	<% 	
	} else {
		%>
<table class="mega">
	<tr>
		<td class="mega">
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
							<p>Post by <%=assertion.getUN() %><% if(assertion.getUN().equals(Utility.getUsername(derp))){%> <a href="ProcessDeleteAssertion?id=<%= assertion.getId() %>">Delete Claim</a><% } %></p>
						</td>
					</tr>
					<tr>
						<td>
							<p class="center"><b>Claim: <br /><%= assertion.getName() %> </b></p>
							<p class="center"><i>Assertions: <br /><%= assertion.getBody() %></i></p>
							<p>Convinced: <%= assertion.getConvinced() %><br>
							Unsure:    <%= assertion.getUnsure() %><br>
							Disagree:  <%= assertion.getDisagree() %></p>
						</td>
					</tr>
				</tbody>
			</table>		
		<table class="center">
			<tbody>
				<tr>
					<td>
						<table width="100%">
							<tbody>
								<tr>
									<td align="left">
										<a class="red" href="ProcessVote?vote=disagree&id=<%= assertion.getId() %>">Vote Disagree</a>
									</td>
									<td align="center">
										<a class="yellow" href="ProcessVote?vote=unsure&id=<%= assertion.getId() %>">Vote Unsure</a>
									</td>
									<td align="right">
										<a class="green" href="ProcessVote?vote=convinced&id=<%= assertion.getId() %>">Vote Convinced</a>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<br />
		<%	
		}
		%>
		<%	
	}
	%> 
		</td>
	</tr>
</table>

<h4>By James Robertson and James Dressel Homework 11</h4>
</body>
</html>

