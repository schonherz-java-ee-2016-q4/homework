function validatePasswords(form) {
    var x = form.password.value;
    var y = form.confirmpassword.value;
    if (x != y) {
        alert("Passwords must match.");
        return false;
    }
}