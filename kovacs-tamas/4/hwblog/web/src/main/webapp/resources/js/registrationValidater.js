function isPasswordValid() {
    var psw = $('#password').val().trim();
    var rePsw = $('#confirmPassword').val().trim();
    return psw.length > 0 && rePsw.length > 0 && psw === rePsw;
}

// Method from stack overflow
//function isValidEmail(email) {
//    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//    return re.test(email);
//}

function validateRegForm() {
    var isValid = true;
    if (!isPasswordValid()) {
        $('#password').val('');
        $('#confirmPassword').val('');
        isValid = false;
    }
//    if (!isValidEmail($('#email'))) {
//        $('#email').val('');
//        isValid = false;
//    }
    if ($('#datepicker').val().trim().length == 0) {
        isValid = false;
    }

    if (!isValid) {
        $('#errorMessage').removeClass('hidden');
    } else {
        $('#errorMessage').addClass('hidden');
    }

    console.log('dob: ' + $('#datepicker').val().trim());

    return isValid;
}
