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

	<%@ page import="jdressel.DerporiaPrime.Utility" %>
	<%@ page language="java" %>
	
	<%
	Object derp  = session.getAttribute("username")==null ? "" : session.getAttribute("username");

	session.setAttribute("loginRequester", "Derporia.jsp");
	%>
	<jsp:include page="UsernameHeader.jsp" />
	
	<hr>

	<br>
	
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

