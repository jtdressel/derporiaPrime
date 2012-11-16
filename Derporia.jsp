<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Derporia: the never-ending land of claims</title>

<!-- A project by James Dressel and James Robertson -->
<link rel="stylesheet" type="text/css" href="http://mason.gmu.edu/~jrobertq/derporia/derporiaStyle.css">

<script src="http://mason.gmu.edu/~jrobertq/derporia/derporiaAssert.js"> </script>
</head>

	<body>
	<h1>Derporia: the never-ending land of <del>baseless</del> claims</h1>
	<hr>
	<br>
	<h1>James Robertson and James Dressel</h1>
	<hr>
	<br>
	<p>
		Please enter make a claim and then assertions to support your claim. 
	</p>
	<table class="center" border="1">



	<tbody><tr>
		<td>
		<form name="assertionForm"  onsubmit="return validateForm()" action="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.DerporiaPremium.Results" method="post">

			<textarea cols="30" rows="1" name="claim" onclick="clearOnClick(this, 'Enter your claim')" onblur="defaultOnBlur(this, 'Enter your claim')" autofocus="autofocus">Enter your claim</textarea>
		<br>
			<textarea cols="30" rows="5" name="assertions" size="20" onclick="clearOnClick(this, 'Enter your assertions')" onblur="defaultOnBlur(this, 'Enter your assertions')">Enter your assertions</textarea>
		<br>
		</td>
		</tr></tbody></table><table align="center" width="14%">
		<tbody><tr>
		<td align="left">
			<button type="button" onclick="resetForm()">Reset</button> 
		</td>
		<td align="right">
			<input type="submit" name="Submit"/>
		</td>
		</tr>
		</tbody></table>
		</form>
	

</body>
</html>

