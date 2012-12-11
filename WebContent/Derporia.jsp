<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

<!-- A project by James Dressel and James Robertson -->

<%@ page import="jdressel.DerporiaPrime.Utility" %>
<%Utility.load(application);%> 
<link rel="stylesheet" type="text/css" href="derporiaStyle.css"/>

<script src="derporia.js"></script>

</head>

	<body>
	<h1><a href="Derporia.jsp">Derporia</a>: the never-ending land of <del>baseless</del> claims</h1> 

	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%@ page language="java" %>
	
	<%
	Object derp  = session.getAttribute("username")==null ? "" : session.getAttribute("username");

	session.setAttribute("loginRequester", "Derporia.jsp");
	%>
	<jsp:include page="UsernameHeader.jsp" />
	
	<hr>

	<br>
	<table>
	<tbody>
		<tr>
			<td>
				<a class="regular" href="Voting.jsp">Vote On Assertions</a>
			</td>
		</tr>
	</tbody>
	</table>
	<table class="center" border="1">
		<tbody>
			<tr>
				<td>
					<form name="assertionForm"  onsubmit="return validateForm()" action="ProcessClaim" method="post">

						<textarea cols="30" rows="1" name="claim" autofocus="autofocus" placeholder="Make a Claim" onkeypress="checkSubmit(event);return noEnter(event)"></textarea>
					<br>
						<textarea cols="30" rows="5" name="assertions" size="20"  placeholder="Use Assertions to support your claim" onkeypress="checkSubmit(event);return noEnter(event)"></textarea>
					<br>
				</td>
			</tr>
		</tbody>
	</table>
		
		<table class="center">
		<tbody><tr>
		<td align="left">
			<button type="button" onclick="resetForm()">Reset</button> 
		</td>
		<td align="right">
			<input class="regular" type="submit" name="Submit"/>
		</td>
		</tr>
		</tbody></table>
		</form>
		<p id="error"></p>
		<a href="ProcessReset">Reset all asertions</a>
<p>We made modifications 1, 2, 3, 4. Diagram hard copy will be submitted in class.</p>
<h4>By James Robertson and James Dressel Homework 11</h4>
</body>
</html>

