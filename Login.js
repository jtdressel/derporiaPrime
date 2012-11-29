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