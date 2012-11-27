<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

<!-- A project by James Dressel and James Robertson -->
<link rel="stylesheet" type="text/css" href="derporiaStyle.css"><!--http://mason.gmu.edu/~jrobertq/derporia/derporiaStyle.css-->

<script src="derporiaAssert.js"> </script><!--http://mason.gmu.edu/~jrobertq/derporia/derporiaAssert.js-->
</head>

	<body>
	<h1>Derporia: the never-ending land of <del>baseless</del> claims</h1> 
	
	<div class="username">
	Log In: <input type="text" name="username" placeholder="Username" onkeypress="checkEnter(event)">
	<br />
	<button type="button" class="login" name="loginButton" align="right">Log In</button>
	</div>
	
	<hr>

	<br>
	<p class="normal">
		Make a claim and make assertions to support your claim. 
	</p>
	
	<table class="center" border="1">
		<tbody>
			<tr>
				<td>
					<form name="assertionForm"  onsubmit="return validateForm()" action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.DerporiaPremium.Results" method="post">

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
</body>
</html>

