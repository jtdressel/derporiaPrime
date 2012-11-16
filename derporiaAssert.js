/*James Dressel and James Robertson*/
function isEmpty(field){
	if(field==null || field==""){
		return true;
	} else {
		return false;
	}
}

function validateForm(){
	/*Check that fields are not empty, and have been changed*/
	var claim = !isEmpty(document.forms["assertionForm"]["claim"].value)&&(document.forms["assertionForm"]["claim"].value!="Enter your claim");
	var assertion = !isEmpty(document.forms["assertionForm"]["assertions"].value)&&(document.forms["assertionForm"]["assertions"].value!="Enter your assertions");
	if(claim&&assertion){
		document.forms["assertionForm"]["Submit"].disabled=true;
		return true;
	} else {
		if(claim){
		//Claim present, no assertion
			alert("An assertion must be entered.");
		} else if (assertion) {
		//Assertion present, no claim
			alert("A claim must be entered.");
		} else {
			alert("Both a claim and an assertion must be entered.");
		}
	return false;
	}
}

function resetForm(){
	document.forms["assertionForm"]["claim"].value="Enter your claim";
	document.forms["assertionForm"]["assertions"].value="Enter your assertions";
	document.forms["assertionForm"]["Submit"].disabled=false;
}

function clearOnClick(field, defaultText){
	if(field.value === defaultText){
		field.value="";
	}
}

function defaultOnBlur(field, defaultText){
	if(field.value == ""){
		field.value = defaultText;
	}
}
