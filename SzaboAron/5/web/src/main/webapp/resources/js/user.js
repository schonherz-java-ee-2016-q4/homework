var list;
var results;
var slided = 0;

$(document).ready(function() {
	init();
	get_user_list();

	$("#filter_form").on("submit", function(event) {
		event.preventDefault();
		var str = $(this).serialize();
		get_filtered_user_list(str);
		console.log(str);
	});

});

function init() {
	$('#filter_body').hide();
	$('#result').hide();
}

function get_user_list() {
	$(".loader").show();
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
		console.log(res);
		display_user_list(res);
		$(".loader").hide();
		$('#result').show();
	});

}

function get_filtered_user_list(str) {
	$.get("${pageContext.request.contextPath}/UserServlet?" + str,
			function(res) {
				console.log(res);
				display_user_list(res);
				$(".loader").hide();
				$('#result').show();
			});
}

function display_user_list(user_list) {
	$('#result').html('');
	$.each(user_list, function(index, value) {
		$.get('${pageContext.request.contextPath}/content/content.html',
				function(template) {
					var t = template.replace('user_name', value.firstName + ' '
							+ value.lastName);
					t = t.replace('img_url', value.largePic);
					t = t.replace('city', value.postcode + ' ' + value.city);
					t = t.replace('street', value.street);
					t = t.replace('mail_addr', value.email);
					t = t.replace('number', index);
					$('#result').append(t);
					console.log('displayed');
				});
	});
}

function on_header_clocked() {
	if (slided == 0) {
		$('#filter_body').slideDown('slow');
		slided = 1;
	} else {
		$('#filter_body').slideUp('slow');
		slided = 0;
	}
}

function handleClick(id) {
	// alert(id);
	$('#myModal').html('');
	$.get('${pageContext.request.contextPath}/content/modal.html', function(
			modal_res) {

		$.each(results, function(index, value) {
			if (index == id) {
				var t = modal_res.replace('user_name', value.name.first + ' '
						+ value.name.last);
				t = t.replace('email', value.email);
				t = t.replace('username', value.login.username);
				t = t.replace('password', value.login.password);
				t = t.replace('phone', value.phone);
				t = t.replace('dob', value.dob);
				t = t.replace('gender', value.gender);
				t = t.replace('registered', value.registered);
				t = t.replace('cell', value.cell);
				t = t.replace('location', value.location.postcode + ' '
						+ value.location.city + ', ' + value.location.street);
				t = t.replace('img_url', value.picture.large);

				$('#myModal').append(t);
				return;
			}

		});

	});
}
