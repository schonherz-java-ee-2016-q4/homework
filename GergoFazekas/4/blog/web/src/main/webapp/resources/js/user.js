var list;
var results;

String.prototype.capitalize = function() {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

$(document).ready(function() {


		
		$('#result').hide();
		$(".loader").show();
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.name.first.capitalize() + ' ' + value.name.last.capitalize());
				t = t.replace('img_url', value.picture.medium);
				t = t.replace('user_name', value.login.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', index);
				t = t.replace('p_hone', value.phone);
				
				$('#result').append(t);
				
//				$('#searchgender').click(function() {
//					if (value.gender == "male" && $('#selectgender').val() == "male") {
//						$('#result').append(t);
//					} else if (value.gender == "female" && $('#selectgender').val() == "female") {
//						$('#result').append(t);
//					} else if ($('#selectgender').val() == "both") {
//						$('#result').append(t);
//					}
//				});
				
			});
			
			$(".loader").hide();
			$('#result').show();
		});	
		});
	
	
});

function handleClick(id) {
	//alert(id);
	$('#myModal').html('');
	$.get('${pageContext.request.contextPath}/content/modal.html', function(modal_res) {
		
		$.each(results, function(index, value) {
			if (index == id) {
				var t=	modal_res.replace('user_name',value.name.first +' '+value.name.last);
				t = t.replace('email', value.email);
				t = t.replace('username', value.login.username);
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
				
				$('#myModal').append(t);
				return;
			}
			
		});
		
	});
}

$('#searchbygender').click( function() {
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
			var t =	template.replace('full_name',value.name.first.capitalize() + ' ' + value.name.last.capitalize());
			t = t.replace('img_url', value.picture.medium);
			t = t.replace('user_name', value.login.username);
			t = t.replace('gender', value.gender)
			t = t.replace('e_mail', value.email);
			t = t.replace('number', index);
			t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#gender').val().toLowerCase();
			
			if (inputValue == "male" && value.gender == "male") {
				$('#result').append(t);
			} else if (inputValue == "female" && value.gender == "female") {
				$('#result').append(t);
			}
			
			
			
		});
	
		
		$(".loader").hide();
		$('#result').show();
	});	
		
	});
});

$('#searchbyname').click( function() {
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
			var t =	template.replace('full_name',value.name.first.capitalize() + ' ' + value.name.last.capitalize());
			t = t.replace('img_url', value.picture.medium);
			t = t.replace('user_name', value.login.username);
			t = t.replace('gender', value.gender)
			t = t.replace('e_mail', value.email);
			t = t.replace('number', index);
			t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#name').val().toLowerCase();
			var fullname = value.name.first + ' ' + value.name.last;
			
			if (inputValue == value.name.first || inputValue == value.name.last 
					|| inputValue == fullname) {
				$('#result').append(t);
			} 

			});
	
		
		$(".loader").hide();
		$('#result').show();
	});	
		
	});
});

$('#searchbycity').click( function() {
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
			var t =	template.replace('full_name',value.name.first.capitalize() + ' ' + value.name.last.capitalize());
			t = t.replace('img_url', value.picture.medium);
			t = t.replace('user_name', value.login.username);
			t = t.replace('gender', value.gender)
			t = t.replace('e_mail', value.email);
			t = t.replace('number', index);
			t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#city').val().toLowerCase();
			
			if (inputValue == value.location.city) {
				$('#result').append(t);
			} 

			});
	
		
		$(".loader").hide();
		$('#result').show();
	});	
		
	});
});

$('#searchbyemail').click( function() {
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
			var t =	template.replace('full_name',value.name.first.capitalize() + ' ' + value.name.last.capitalize());
			t = t.replace('img_url', value.picture.medium);
			t = t.replace('user_name', value.login.username);
			t = t.replace('gender', value.gender)
			t = t.replace('e_mail', value.email);
			t = t.replace('number', index);
			t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#email').val().toLowerCase();
			
			if (inputValue == value.email) {
				$('#result').append(t);
			} 

			});
	
		
		$(".loader").hide();
		$('#result').show();
	});	
		
	});
});


