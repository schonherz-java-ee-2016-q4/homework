var i;
var selected;
var passw;
var mai;

$(document)
		.on(
				'ready',
				function() {

					i = 0;
					selected = false;
					passw = false;
					mail = false;
					panelSwitched();
					$('#register_button').hide();

					$("#pictureSelectButton").fileinput({
						'showUpload' : false,
						'previewFileType' : 'any',
						'maxFileSize' : 10240
					});

					$('#pictureSelectButton').on('fileselect',
							function(event, numFiles, label) {
								selected = true;
								panelSwitched();
							});

					$('#pictureSelectButton').on('fileclear', function(event) {
						selected = false;
						panelSwitched();
					});

					$('.datepicker').pickadate({
						selectYears : true,
						selectMonths : true,
						max : true,
						selectYears : 100,
						firstDay : 1,
						format : 'yyyy-mm-dd'
					});

					$('#user_email')
							.on(
									'input',
									function() {
										if ($('#user_email')
												.val()
												.match(
														/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/)) {
											mail = true;
											$('#mail_alert').hide();
										} else {
											mail = false;
											$('#mail_alert').show();
										}
									});

					$('#user_passw1').on('input', function() {
						passwTest();
					});

					$('#user_passw2').on('input', function() {
						passwTest();
					});

					function passwTest() {
						if ($('#user_passw1').val().length < 6) {
							$('#passwd_alert').show();
							$('#passwd_alert_text')
									.html(
											'Password too short! Must be at least 6 characters long');
						} else if ($('#user_passw1').val() != $('#user_passw2')
								.val()) {
							$('#passwd_alert').show();
							$('#passwd_alert_text').html(
									'Passwords don\'t match!');
						} else {
							$('#passwd_alert').hide();
							passw = true;
							return;
						}

						passw = false;
					}

				});

function panelSwitched() {
	switch (i) {

	case 0:
		$('#loginPanel').show();
		$('#personalPanel').hide();
		$('#contactsPanel').hide();
		$('#uploadPanel').hide();
		$(panelName).html($('#loginPanel h4').html());
		break;
	case 1:
		$('#loginPanel').hide();
		$('#personalPanel').show();
		$('#contactsPanel').hide();
		$('#uploadPanel').hide();
		$(panelName).html($('#personalPanel h4').html());
		break;
	case 2:
		$('#loginPanel').hide();
		$('#personalPanel').hide();
		$('#contactsPanel').show();
		$('#uploadPanel').hide();
		$(panelName).html($('#contactsPanel h4').html());
		break;
	case 3:
		$('#loginPanel').hide();
		$('#personalPanel').hide();
		$('#contactsPanel').hide();
		$('#uploadPanel').show();
		$(panelName).html($('#uploadPanel h4').html());
		break;

	}
	if (i == 0)
		$('.previous').addClass('disabled');
	else
		$('.previous').removeClass('disabled');

	if (i != 3) {
		$('.next').show();
		$('#empty_alert').hide();
	} else {
		$('.next').hide();
		if (validateForm()) {
			$('#register_button').show();
			$('#register_button').prop('disabled', false);
		}
	}
}

function validateForm() {
	j = 0;
	if ($('#user_username').val() != ''
			&& $('#user_firstName').val() != ''
			&& $('#user_lastName').val() != ''
			&& $('#user_dob').val() != ''
			&& $('#user_state').val() != ''
			&& $('#user_postcode').val() != ''
			&& $('#user_city').val() != ''
			&& $('#user_street').val() != ''
			&& $('#user_phone').val() != ''
			&& $('#user_cell').val() != ''
			&& ($('#gender_male').is(':checked') || $('#gender_female').is(
					':checked'))) {
		j++;
	} else {
		$('#empty_alert').show();
	}

	if (selected && passw && mail) {
		j++;
	}
	return j == 2;
}

function onNext() {
	if (i < 3) {
		i = i + 1;
		panelSwitched();
	}

}

function onBack() {

	if (i > 0) {
		i = i - 1;
		panelSwitched();
	}

}