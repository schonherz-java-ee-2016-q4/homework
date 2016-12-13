function isFieldFilled(field) {
    return field.val().trim().length > 0;
}

function isPasswordValid() {
    var psw = $('#password').val().trim();
    var rePsw = $('#rePassword').val().trim();
    return psw.length > 0 && rePsw.length > 0 && psw === rePsw;
}

// Method from stack overflow
function isValidEmail(email) {
    var re = '/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/';
    return re.test(email);
}

function validateRegForm() {
    console.log('itt van');
    if (!isPasswordValid()) {
        $('#password').val('');
        $('#rePassword').val('');
        $('#errorMessage').removeClass('hidden');
        return false;
    }
    if (!isValidEmail($('#email'))) {
        $('#email').val('');
        $('#errorMessage').removeClass('hidden');
        return false;
    }

    var isValid = isFieldFilled($('#firstName')) && isFieldFilled($('#lastName'))
            && isFieldFilled($('#title')) && isFieldFilled($('#state')) && isFieldFilled($('#postCode'))
            && isFieldFilled($('#city')) && isFieldFilled($('#street')) && isFieldFilled($('#phone'))
            && isFieldFilled($('#cell')) && isFieldFilled($('#username'));
    if (!isValid) {
        $('#errorMessage').removeClass('hidden');
    } else {
        $('#errorMessage').addClass('hidden');
    }
    return isValid;
}
