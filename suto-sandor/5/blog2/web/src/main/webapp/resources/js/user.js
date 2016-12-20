var list;
var results;

$('#button_search').click(function() {

	actualYear = new Date().getFullYear();
	if ( $('#user_age1').val() == '') {
		age1 = 0;
	}
	else {
		age1 = $('#user_age1').val();
	}
	if ( $('#user_age2').val() == '') {
		age2 = 140;
	}
	else {
		age2 = $('#user_age2').val();
	}
		$('#result').hide();
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
					if ( ($('#gender_male').is(':checked') && value.gender != 'male')) {
						return;
					}
					if ( ($('#gender_female').is(':checked') && value.gender != 'female')) {
						return;
					}
					if ( $('#user_firstName').val() != '' &&
							value.name.first.toLowerCase()!== $('#user_firstName').val().toLowerCase()) {
						return;
					}	
					if ( $('#user_lastName').val() != '' &&
							value.name.last.toLowerCase()!== $('#user_lastName').val().toLowerCase()) {
						return;
					}
					if ( $('#user_email').val() != '' &&
							value.email.toLowerCase()!== $('#user_email').val().toLowerCase()) {
						return;
					}
					if ( $('#user_city').val() != '' &&
							value.location.city.toLowerCase()!== $('#user_city').val().toLowerCase()) {
						return;
					}
					year = value.dob.split("-")[0];
					age = actualYear-year;
					if (age<age1 || age>age2) {
						return;
					}
				var t=	template.replace('user_name',value.name.first +' '+value.name.last);
				t=t.replace('img_url',value.picture.medium);
				t = t.replace('gender', value.gender);
				t=t.replace('email',value.email);
				t = t.replace('telo', value.phone);
				t = t.replace('cell', value.cell);
				t = t.replace('date_of_birth', value.dob);
				t = t.replace('nationality', value.nat);
				t=t.replace('userlog', value.name.first);
				t = t.replace('state', value.location.state);
				t = t.replace('city', value.location.city);
				t = t.replace('postcode', value.location.postcode);
				t = t.replace('street', value.location.street);
				t=t.replace('reg_date', value.registered);
				t=t.replace('number', index);
				
				$('#result').append(t);
				});
			});

			$('#result').show();
		});
});

$('#button_clear').click(function() {
	
	$("#gender_all").prop("checked", true);
	$('#user_age1').val('');
	$('#user_age2').val('');
	$('#user_firstName').val('');
	$('#user_lastName').val('');
	$('#user_email').val('');
	$('#user_city').val('');
	
	
});

function handleClick(id) {
	$('#myModal').html('');
	$.get('${pageContext.request.contextPath}/content/modal.html', function(modal_res) {
		
		$.each(results, function(index, value) {
			if (index == id) {
				var t=	modal_res.replace('userlog',value.name.first);
				t=t.replace('username', value.login.username);
				t=t.replace('password', value.login.password);
				$('#myModal').append(t);
				return;
			}
			
		});
		
	});
}
