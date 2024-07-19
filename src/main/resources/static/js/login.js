document.addEventListener('DOMContentLoaded', function() {
	console.log("Script is loaded and running"); // Add this line to verify the script is loaded
	document.getElementById('loginForm').addEventListener('submit', function(event) {
		let isValid = true;

		const USERNAME_PATTERN = /^[a-zA-Z0-9‚Ÿ-‚ñƒ@-ƒ–ˆê-êX[]+$/;
		const PASSWORD_PATTERN = /^[a-zA-Z0-9]{6,10}$/;

		const username = document.getElementById('username').value;
		const password = document.getElementById('password').value;

		// Validate Username
		if (!USERNAME_PATTERN.test(username)) {
			isValid = false;
			document.getElementById('usernameErrorMessage').textContent = "ƒ†[ƒU[–¼‚Í‹L†ˆÈŠO‚n‚ji“ú–{Œê‚Æ‰pŒê‚n‚jA‹L†‚¾‚¯‚Í‚m‚fj";
		} else {
			document.getElementById('usernameErrorMessage').textContent = "";
		}

		// Validate Password
		if (!PASSWORD_PATTERN.test(password)) {
			isValid = false;
			document.getElementById('passwordErrorMessage').textContent = "ƒpƒXƒ[ƒh‚Í‚U•¶šˆÈã‚P‚O•¶šˆÈ‰ºA‘SŠp‚Í‚m‚fA”¼Šp‚Í‰pš‚Æ”š‚n‚jA‹L†‚Í‚m‚f";
		} else {
			document.getElementById('passwordErrorMessage').textContent = "";
		}

		if (!isValid) {
			event.preventDefault(); // Prevent form submission if validation fails
		}
	});
});