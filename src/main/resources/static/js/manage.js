document.addEventListener('DOMContentLoaded', function() {
    
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

function submitForm(action) {
    if (action === '/register') {
        const registerForm = document.getElementById('registerForm');
        if (registerForm.checkValidity()) {
            registerForm.submit();
        } else {
            registerForm.reportValidity();
        }
    } else if (action === '/delete') {
        const deleteForm = document.getElementById('deleteForm');
        if (deleteForm.checkValidity()) {
            deleteForm.submit();
        } else {
            deleteForm.reportValidity();
        }
    }
}
