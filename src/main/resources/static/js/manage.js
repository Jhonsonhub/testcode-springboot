document.addEventListener('DOMContentLoaded', function() {
    // the registration form
    showForm('register');
});

function showForm(formType) {
    document.getElementById('registerForm').style.display = 'none';
    document.getElementById('deleteForm').style.display = 'none';

    if (formType === 'register') {
        document.getElementById('registerForm').style.display = 'block';
    } else if (formType === 'delete') {
        document.getElementById('deleteForm').style.display = 'block';
    }
}
