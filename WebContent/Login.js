function checkSubmit(e){
	if (e.keyCode == 13) 
	 	if(validateForm())
			document.forms["loginForm"].submit();
}
//disable addding a new line character to text fields
function noEnter(e)
{
    if (window.event.keyCode == 13 ) 
		return false;
}

function validateForm(){
	/*Check that fields are not empty, and have been changed*/
	var username = !isEmpty(document.forms["loginForm"]["claim"].value!="");
	if(username){
		document.forms["loginForm"]["Submit"].disabled=true;
		return true;
	}
	return false;
}
