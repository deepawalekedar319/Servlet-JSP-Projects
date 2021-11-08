function formValidation(form){
	let flag = true;
	
	// getting the values
	let name = form.name.value;
	let email = form.email.value;
	let phone = form.phone.value;
	let age = form.age.value;
	let gender = form.gender.value;
	let country = form.country.value;
	
	// Checking the validations
	if(name==""){
		alert("This Field is required");
		form.name.focus();
		flag = false;
	} // if	
	if(email==""){
		alert("This Field is required");
		form.email.focus();
		flag = false;
	} // if	
	if(age==""){
		alert("This Field is required");
		form.age.focus();
		flag = false;
	} // if	
	else if(isNan(age)){
		alert("This Field must be integer value");
		form.age.focus();
		flag = false;
	} // else if
	if(phone==""){
		alert("This Field is required");
		form.phone.focus();
		flag = false;
	} // if	
	else if(phone.length!=10){
		alert("Enter the correct number");
		form.phone.focus();
		flag = false;
	} // if	
	if(gender==0){
		alert("This Field is required");
		form.gender.focus();
		flag = false;
	} // if	
	if(country==0){
		alert("This Field is required");
		form.country.focus();
		flag = false;
	} // if	
	return flag;
} // function