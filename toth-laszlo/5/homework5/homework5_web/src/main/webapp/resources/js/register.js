$(document).ready(function() {
	
});

function PasswordMatch() {
    var password1 = $("#password1").val();
    var password2 = $("#password2").val();

    if (password1 != password2){
    	$("#password_error").removeClass('hidden');
    	$("#submit").addClass('disabled');
    }
    else{
    	$("#password_error").addClass('hidden');
    	$("#submit").removeClass('disabled');
    }
}