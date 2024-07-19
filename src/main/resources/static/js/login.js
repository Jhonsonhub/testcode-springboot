document.addEventListener('DOMContentLoaded', function() {
	console.log("Script is loaded and running"); // Add this line to verify the script is loaded
	document.getElementById('loginForm').addEventListener('submit', function(event) {
		let isValid = true;

		const USERNAME_PATTERN = /^[a-zA-Z0-9��-��@-����-ꞁX�[]+$/;
		const PASSWORD_PATTERN = /^[a-zA-Z0-9]{6,10}$/;

		const username = document.getElementById('username').value;
		const password = document.getElementById('password').value;

		// Validate Username
		if (!USERNAME_PATTERN.test(username)) {
			isValid = false;
			document.getElementById('usernameErrorMessage').textContent = "���[�U�[���͋L���ȊO�n�j�i���{��Ɖp��n�j�A�L�������͂m�f�j";
		} else {
			document.getElementById('usernameErrorMessage').textContent = "";
		}

		// Validate Password
		if (!PASSWORD_PATTERN.test(password)) {
			isValid = false;
			document.getElementById('passwordErrorMessage').textContent = "�p�X���[�h�͂U�����ȏ�P�O�����ȉ��A�S�p�͂m�f�A���p�͉p���Ɛ����n�j�A�L���͂m�f";
		} else {
			document.getElementById('passwordErrorMessage').textContent = "";
		}

		if (!isValid) {
			event.preventDefault(); // Prevent form submission if validation fails
		}
	});
});