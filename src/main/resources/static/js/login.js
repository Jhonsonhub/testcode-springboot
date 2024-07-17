if (window.jQuery) {
    console.log("jQuery is loaded");
} else {
    console.log("jQuery is not loaded");
}

$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        let isValid = true;

        const USERNAME_PATTERN = /^[a-zA-Z0-9ぁ-んァ-ヶ一-龠々ー]+$/;
        const PASSWORD_PATTERN = /^[a-zA-Z0-9]{6,10}$/;

        const username = $('#username').val();
        const password = $('#password').val();

        // Validate Username
        if (!USERNAME_PATTERN.test(username)) {
            isValid = false;
            $('#usernameErrorMessage').text("ユーザー名は記号以外ＯＫ（日本語と英語ＯＫ、記号だけはＮＧ）");
        } else {
            $('#usernameErrorMessage').text("");
        }

        // Validate Password
        if (!PASSWORD_PATTERN.test(password)) {
            isValid = false;
            $('#passwordErrorMessage').text("パスワードは６文字以上１０文字以下、全角はＮＧ、半角は英字と数字ＯＫ、記号はＮＧ");
        } else {
            $('#passwordErrorMessage').text("");
        }

        if (!isValid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });
});