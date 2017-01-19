function validatePasswords(form) {

    if (form.email.value == "") {
        alert("Error: Email cannot be blank!");
        form.email.focus();
        return false;
    }

    if (form.username.value == "") {
        alert("Error: Username cannot be blank!");
        form.username.focus();
        return false;
    }

    if (form.password.value == "") {
        alert("Error: Password cannot be blank!");
        form.password.focus();
        return false;
    }

    var x = form.password.value;
    var y = form.confirmpassword.value;
    if (x != y) {
        alert("Error: Passwords must match.");
        form.password.focus();
        return false;
    }

    if (form.password.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.password.focus();
        return false;
    }

    if (form.phone.value == "") {
        alert("Error: Phone cannot be blank!");
        form.phone.focus();
        return false;
    }

    if (form.title.value == "") {
        alert("Error: Title cannot be blank!");
        form.title.focus();
        return false;
    }

    if (form.first.value == "") {
        alert("Error: First name cannot be blank!");
        form.first.focus();
        return false;
    }

    if (form.last.value == "") {
        alert("Error: Last name cannot be blank!");
        form.last.focus();
        return false;
    }

    if (form.street.value == "") {
        alert("Error: Street cannot be blank!");
        form.street.focus();
        return false;
    }

    if (form.city.value == "") {
        alert("Error: City cannot be blank!");
        form.city.focus();
        return false;
    }

    if (form.state.value == "") {
        alert("Error: State cannot be blank!");
        form.state.focus();
        return false;
    }

    if (form.postcode.value == "") {
        alert("Error: Postcode cannot be blank!");
        form.postcode.focus();
        return false;
    }

}