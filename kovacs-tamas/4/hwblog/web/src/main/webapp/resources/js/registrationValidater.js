function isPasswordValid() {
    var psw = $('#password').val().trim();
    var rePsw = $('#confirmPassword').val().trim();
    return psw.length > 0 && rePsw.length > 0 && psw === rePsw;
}

function validateRegForm() {
    var isValid = true;
    if (!isPasswordValid()) {
        $('#password').val('');
        $('#confirmPassword').val('');
        isValid = false;
    }
    if ($('#datepicker').val().trim().length == 0) {
        isValid = false;
    }

    if (!isValid) {
        $('#errorMessage').removeClass('hidden');
    } else {
        $('#errorMessage').addClass('hidden');
    }

    return isValid;
}
