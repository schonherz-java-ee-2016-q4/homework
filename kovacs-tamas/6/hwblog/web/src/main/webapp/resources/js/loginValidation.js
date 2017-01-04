function validateLogin() {
    var usr = $('#username').val().trim();
    var psw = $('#psw').val().trim();
    var isValid = usr.length > 0 && psw.length > 0;
    if (!isValid) {
        $('#empty-field-message').removeClass("hidden");
    } else {
        $('#empty-field-message').addClass("hidden");
    }
    $('#invalid-field-message').addClass("hidden");
    return isValid;
}
