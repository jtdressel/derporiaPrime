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
	var claim = !isEmpty(document.forms["assertionForm"]["claim"].value)&&(document.forms["assertionForm"]["claim"].value!="");
	var assertion = !isEmpty(document.forms["assertionForm"]["assertions"].value)&&(document.forms["assertionForm"]["assertions"].value!="");
	if(claim&&assertion){
		document.forms["assertionForm"]["Submit"].disabled=true;
		return true;
	} else {
		if(claim){
		//Claim present, no assertion
			document.getElementById("error").innerHTML="<i>*An assertion must be entered</i>";
		} else if (assertion) {
		//Assertion present, no claim
			document.getElementById("error").innerHTML="<i>*A claim must be entered</i>";
		} else {
			document.getElementById("error").innerHTML="<i>*A claim must be entered</i> <br> <i>*An assertion must be entered</i>";
		}
	return false;
	}
}

function resetForm(){
	document.forms["assertionForm"]["claim"].value="";
	document.forms["assertionForm"]["assertions"].value="";
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

function checkEnter(e){
	 if (e.keyCode == 13) {
        return true;
    }
	return false;
}

function checkSubmit(e){
	if (e.keyCode == 13) 
	 	if(validateForm())
			document.forms["assertionForm"].submit();
}
//disable addding a new line character to text fields
function noEnter(e)
{
    if (window.event.keyCode == 13 ) 
		return false;
}