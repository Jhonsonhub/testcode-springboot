function goBack() {
    window.history.back();
}

function checkRole() {
    fetch('/api/userRole')
        .then(response => response.text())
        .then(role => {
            if (role === 'admin') {
                window.location.href = '/manage';
            } else {
                alert('Warning: You do not have access to the manage page!!!');
            }
        })
        .catch(error => console.error('Error fetching user role:', error));
}

// Add event listeners to buttons if needed
document.querySelector('.button').addEventListener('click', goBack);
document.querySelector('.button:nth-child(2)').addEventListener('click', checkRole);

