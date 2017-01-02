var contryList;

$(document).ready(function() {

	init();
	
	$("#username").on('input', function() {
		if (validate_username()) {
			$('#danger_username').slideDown("slow");
		} else {
			$('#danger_username').slideUp("slow");
		}
	});
	
	$("#firstname").on('input', function() {
		if (validate_firstname()) {
			$('#danger_firstname').slideDown("slow");
		} else {
			$('#danger_firstname').slideUp("slow");
		}
	});

	$("#lastname").on('input', function() {
		if (validate_lastname()) {
			$('#danger_lastname').slideDown("slow");
		} else {
			$('#danger_lastname').slideUp("slow");
		}
	});

	$("#password").on('input', function() {
		if (!$.trim($("#password").val())) {
			$('#danger_password').slideDown("slow");
		} else {
			$('#danger_password').slideUp("slow");
		}
	});

	$("#email").on('input', function() {
		if (validate_email()) {
			$('#danger_email').slideUp("slow");
		} else {
			$('#danger_email').slideDown("slow");
		}
	});
	
	$("#confirm").on('input', function() {
		if (validate_confirm()) {
			$('#danger_confirm').slideUp("slow");
		} else {
			$('#danger_confirm').slideDown("slow");
		}
	});
	
	$("#date").on('input', function() {
		if (validate_birthdate()) {
			$('#danger_date').slideUp("slow");
		} else {
			$('#danger_date').slideDown("slow");
		}
	})
});

function init() {
	$('#danger_username').hide();
	$('#danger_lastname').hide();
	$('#danger_firstname').hide();
	$('#danger_password').hide();
	$('#danger_confirm').hide();
	$('#danger_email').hide();
	$('#danger_date').hide();
	$('#date').datepicker({ dateFormat: 'yy-mm-dd' });
	//$('#btn_register').prop('disabled', true);
	getCountries();
}

function getCountries() {
	$.get("https://restcountries.eu/rest/v1/all", function(res) {
		$('#state').html('');
		console.log(res);
		countryList = res.results;
		$.each(res, function(index, value) {
			$('#state').append('<option>' + value.name + '</option>');
		});

	});
}

function validation(){
	return validate_email() && validate_birthdate() && validate_confirm() && validate_firstname() && validate_lastname()
}

function validate_username() {
	return !$.trim($("#username").val());
}

function validate_firstname() {
	return !$.trim($("#firstname").val());
}

function validate_lastname() {
	return !$.trim($("#lastname").val());
}

function validate_email() {
	var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return regex.test($('#email').val());
}

function validate_birthdate() {
	var regex = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
	return regex.test($('#date').val());
}

function validate_confirm() {
	return ($('#password').val() === $('#confirm').val() && $.trim($("#confirm").val())) 
}
