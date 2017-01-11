var list;
var results;

$(document).ready(function() {
		
		$('#result').hide();
		$(".loader").show();
		
		var size = new Number($('#number').val());
		$.get(getContextPath() + "/listUsers", function(res) {
			$('#result').html('');
			results = res.results;
			$.each(res.results, function(index, value) {
				addPersonToList(index, value);
			});
			
			$(".loader").hide();
			$('#result').show();
		});


		$('#button_search').click(function() {
			if (typeof results === "undefined") {
				return;
			}
			
			$('#result').hide();
			$('#result').html('');
			$(".loader").show();
			
			$.each(results, function(index, value) {
				i = 0;
				
				if ( ($('#gender_male').is(':checked') && value.gender == 'male') ||
				 ($('#gender_female').is(':checked') && value.gender == 'female') ||
				 $('#gender_all').is(':checked') ) {
					i++;
				}
				
				if ( $('#user_firstName').val() == '' ||
					value.name.first.toLowerCase().search( $('#user_firstName').val().toLowerCase() ) >= 0 ) {
					i++;
				}
				
				if ( $('#user_lastName').val() == '' ||
						value.name.last.toLowerCase().search( $('#user_lastName').val().toLowerCase() ) >= 0 ) {
					i++;
				}
				
				if ( $('#user_email').val() == '' ||
						value.email.toLowerCase().search( $('#user_email').val().toLowerCase() ) >= 0 ) {
					i++;
				}
				
				if ( $('#user_city').val() == '' ||
						value.location.city.toLowerCase().search( $('#user_city').val().toLowerCase() ) >= 0 ) {
					i++;
				}
				
				dob = value.dob.split(" ")[0].split("-");		
				if ( $('#user_age').val() == '' ||
						calculateAge(dob[0], dob[1], dob[2]) == $('#user_age').val() ) {
					i++;
				}
				
				if (i == 6) {
					addPersonToList(index, value);
				}
				
			});
			
			$(".loader").hide();
			$('#result').show();
			
		});
		
		$('#button_reset').click(function() {

			if (typeof results !== "undefined") {
				$('#result').hide();
				$('#result').html('');
				$(".loader").show();
				
				$.each(results, function(index, value) {
					addPersonToList(index, value);
					
				});
				
				$(".loader").hide();
				$('#result').show();
			}
			
			$("#gender_all").prop("checked", true);
			$('#user_age').val('');
			$('#user_firstName').val('');
			$('#user_lastName').val('');
			$('#user_email').val('');
			$('#user_city').val('');
			
		});
	
	
});

function calculateAge(birthYear, birthMonth, birthDay)
{
	todayDate = new Date();
	todayYear = todayDate.getFullYear();
	todayMonth = todayDate.getMonth();
	todayDay = todayDate.getDate();
	age = todayYear - birthYear;

	if (todayMonth < birthMonth - 1 || (birthMonth - 1 == todayMonth && todayDay < birthDay)) {
		age--;
	}

	return age;
}


function showModal(id) {
	$.each(results, function(index, value) {
		if (index == id) {
			fillModal(value);
			return;
		}
	});
}

function addPersonToList(index, value) {
	$.get(getContextPath() + '/content/content.html', function(template) {
		nev = value.name.first +' '+value.name.last;
		var t;
		if (nev.length > 15) {
			t =	template.replace('user_name', nev.substr(0, 15) + '...');
		} else {
			t = template.replace('user_name', nev);
		}
		t=t.replace('img_url',value.picture.large);
		t=t.replace('role',value.role);
		t=t.replace('city', value.location.postcode + ' ' + value.location.city);
		t=t.replace('mail_addr',value.email);
		t=t.replace('number', index);
		
		$('#result').append(t);
	});
}