<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

<!-- A project by James Dressel and James Robertson -->
<script language="JavaScript">
<!--
version= parseInt(navigator.appVersion);
browser = navigator.appName;

if ( (browser == "Microsoft Internet Explorer" && (version >= 4))||(browser == "Chrome")||(browser == "Safari")||(browser == "Firefox")/*DOES NOT WORK WITH OPERA||(browser == "Opera")*/ ) {
document.write("<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaStyle.css"/>");
}

else{
document.write("<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaStyle2.css"/>");
}
-->
</script>
<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaStyle.css" title="3"/>
<link rel="stylesheet" type="text/css" href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/DerporiaStyle4.css" title="not3"/>

<script src="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/derporiaAssert.js"></script>
</head>

	<body>
	<h1>Derporia: the never-ending land of <del>baseless</del> claims</h1> 
	<%
Object derp  = session.getAttribute("username")==null ? "" : session.getAttribute("username");
out.println(derp);//TODO
session.setAttribute("loginRequester", "http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp");//TODO
%>

	<div class="username">
	<form name="loginForm"  action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessLogin" method="post">
	Log In: <input type="text" name="username" placeholder="Username" onkeypress="checkEnter(event)">
	<br />
	<input class="regular" type="submit" name="Submit"/>
	</form>
	</div>
	
	<hr>

	<br>
	
	<table class="center" border="1">
		<tbody>
			<tr>
				<td>
					<form name="assertionForm"  onsubmit="return validateForm()" action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Results" method="post">

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
		
<h4>By James Robertson and James Dressel</h4>
<a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp">TODO: Deleteme</a>
</body>
</html>

