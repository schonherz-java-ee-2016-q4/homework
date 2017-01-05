function fillModal(value) {
	$('#myModal').html('');
	$.get(getContextPath() + '/content/modal.jsp', function(modal_res) {
		var t=	modal_res.replace('user_name',value.name.title + ' ' + value.name.first + ' ' + value.name.last);
		t = t.replace('role', value.role);
		t = t.replace('email', value.email);
		t = t.replace('username', '<snap id="username">' + value.login.username + '</snap>');
		t = t.replace('password', value.login.password);
		t = t.replace('phone', value.phone);
		t = t.replace('dob', value.dob);
		t = t.replace('gender', value.gender);
		t = t.replace('registered', value.registered);
		t = t.replace('cell', value.cell);
		t = t.replace('location', value.location.postcode + ' '
				+ value.location.city + ', '
				+ value.location.street);
		t = t.replace('img_url', value.picture.large);
		t = t.replace('active', '<snap id="active">' + value.active + '</snap> <button type="button" class="btn btn-default" onclick="switchUserStatus('
				+ ')">Switch</button>');
		
		$('#myModal').append(t);
	});
}

function switchUserStatus(_username) {
	$.ajax({
	  url: getContextPath() + "/admin/switchUserStatus",
	  data: { username: $('#username').html() },
	  success: function(response) {
		  $('#active').html(response);
	  },
	  error: function(response) {
		  alert(response);
	  }
	});
}