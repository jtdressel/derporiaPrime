<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

<!-- A project by James Dressel and James Robertson -->

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
<table>
	<tbody>
		<tr>
			<td>
				<input class="regular" type="submit" value="Make a Claim" name="Make a Claim" onclick="location.href='Derporia.jsp' "/>
			</td>
		</tr>
	</tbody>
</table>
<table class="mega">
	
		
		<%	
		Set<Assertion> assertions = (Set<Assertion>)d;
		ArrayList<Assertion> sorted = new ArrayList<Assertion>(assertions);
		Collections.sort(sorted);
		
		for(Assertion assertion: sorted){
		%>
	<tr>
		<td class="mega">
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
											<p><input class="regular" type="submit" value="Vote Disagree" name="Vote Disagree" onclick="location.href='ProcessVote?vote=disagree&id=<%= assertion.getId() %>' "/></p>
										</td>
										<td align="center">
											<p><input class="regular" type="submit" value="Vote Unsure" name="Vote Unsure" onclick="location.href='ProcessVote?vote=unsure&id=<%= assertion.getId() %>' "/></p>
										</td>
										<td align="right">
											<p><input class="regular" type="submit" value="Vote Convinced" name="Vote Convinced" onclick="location.href='ProcessVote?vote=convinced&id=<%= assertion.getId() %>' "/></p>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
			<br />
		</td>
	</tr>
		<%	
		}
		%>
		<%	
	}
	%> 
		
	
</table>

<h4>By James Robertson and James Dressel Homework 11</h4>
</body>
</html>

