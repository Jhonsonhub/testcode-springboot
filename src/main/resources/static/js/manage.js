function submitForm(action) {
	const form = document.getElementById('userForm');
	form.action = action;

	if (action === '/delete') {
		document.getElementById('username').setAttribute('required', 'required');
		document.getElementById('password').removeAttribute('required');
		document.getElementById('role').removeAttribute('required');
	} else {
		document.getElementById('username').setAttribute('required', 'required');
		document.getElementById('password').setAttribute('required', 'required');
		document.getElementById('role').setAttribute('required', 'required');
	}

	if (form.checkValidity()) {
		form.submit();
	} else {
		form.reportValidity();
	}
}
