var list;

$(document).ready(function() {

	$('#get_user').click(function() {
		var size = new Number($('#number').val());
		$.get('https://randomuser.me/api/?results=' + size, function(res) {
			$('#result').html('');
			$('#home_div').html('');
			console.log(res);
			if (size==3) {console.log(size);}
			$.each(res.results, function(index, value) {

				$.get('/WebApp/content/content.html', function(template) {
				var t=	template.replace('user_name',value.name.first + ' ' + value.name.last);
				t=t.replace('gender', value.gender);
				t=t.replace('img_url',value.picture.large);
				t=t.replace('email', value.email);
				t=t.replace('telo', value.phone);
				t=t.replace('cell', value.cell);
				t=t.replace('userlog', value.name.first);
				t=t.replace('username', value.login.username);
				t=t.replace('date_of_birth', value.dob);
				t=t.replace('nationality', value.nat);
				t=t.replace('password', value.login.password);
				t=t.replace('md5num', value.login.md5);
				t=t.replace('salt', value.login.salt);
				t=t.replace('sha1', value.login.sha1);
				t=t.replace('sha256', value.login.sha256);
				t=t.replace('reg_date', value.registered);
				$('#result').append(t);
				
				});
				$.get('/WebApp/content/home.html', function(template) {
					var a=template.replace('city', value.location.city);
					a=a.replace('postcode', value.location.postcode);
					a=a.replace('state', value.location.state);
					a=a.replace('street', value.location.street);
					a=a.replace('userfirst', value.name.first);
					$('#home_div').append(a);
				});
			});

		}).done(function() {
		}).fail(function() {
		}).always(function() {
		});

	});


	
});
