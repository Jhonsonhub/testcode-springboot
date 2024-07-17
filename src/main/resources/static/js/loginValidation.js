
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('loginForm').addEventListener('submit', function(event) {
        let isValid = true;

        const USERNAME_PATTERN = /^[a-zA-Z0-9ぁ-んァ-ヶ一-龠々ー]+$/;
        const PASSWORD_PATTERN = /^[a-zA-Z0-9]{6,10}$/;

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Validate Username
        if (!USERNAME_PATTERN.test(username)) {
            isValid = false;
            document.getElementById('usernameErrorMessage').textContent = "ユーザー名は記号以外ＯＫ（日本語と英語ＯＫ、記号だけはＮＧ）";
        } else {
            document.getElementById('usernameErrorMessage').textContent = "";
        }

        // Validate Password
        if (!PASSWORD_PATTERN.test(password)) {
            isValid = false;
            document.getElementById('passwordErrorMessage').textContent = "パスワードは６文字以上１０文字以下、全角はＮＧ、半角は英字と数字ＯＫ、記号はＮＧ";
        } else {
            document.getElementById('passwordErrorMessage').textContent = "";
        }

        if (!isValid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });
});
