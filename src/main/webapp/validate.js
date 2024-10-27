const form = document.getElementById('check');

form.addEventListener('submit', function(event){
    event.preventDefault();

    let isValid = true;

    const phone = document.getElementById('phno');
    const email = document.getElementById('email');
    const pin = document.getElementById('pin');
    const ep = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if((!/^\d{10}$/.test(phone.value))){
        isValid=false;
        alert('Please Enter valid Phone Number.');
        phone.focus();
    }
    else if(email!=null&&(!ep.test(email.value))){
        isValid=false;
        alert('Please Enter valid Email.');
        email.focus();
    }
    
    if(pin!=null){
		if((!/^\d{6}$/.test(pin.value))){
			isValid=false;
			alert("Please Enter valid Pincode");
			email.focus();
		}
	}

    if(isValid){
        form.submit();
    }
})