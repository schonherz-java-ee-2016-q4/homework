var list;
var results;

String.prototype.capitalize = function() {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

$(document).ready(function() {
		
		$('#result').hide();
		$(".loader").show();
		
		$("#flip").click(function(){
	        $("#panel").slideDown("slow");
	    });
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/users", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.firstName.capitalize() + ' ' + value.lastName.capitalize());
				t = t.replace('img_url', value.mediumPicture);
				t = t.replace('user_name', value.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', value.id);
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
				var t=	modal_res.replace('user_name',value.firstName +' '+value.lastName);
				t = t.replace('email', value.email);
				t = t.replace('username', value.username);
				t = t.replace('password', value.password);
				t = t.replace('phone', value.phone);
				t = t.replace('dob', value.dob);
				t = t.replace('gender', value.gender);
				t = t.replace('registered', value.registered);
				t = t.replace('location', value.postcode + ' '
						+ value.city + ', '
						+ value.street);
				t = t.replace('img_url', value.largePicture);
				
				$('#myModal').append(t);
				return;
			}
			
		});
		
	});
}

$('#searchbygender').click( function() {
	var size = new Number($('#number').val());
	$.get("${pageContext.request.contextPath}/users", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.firstName.capitalize() + ' ' + value.lastName.capitalize());
				t = t.replace('img_url', value.mediumPicture);
				t = t.replace('user_name', value.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', value.id);
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
	$.get("${pageContext.request.contextPath}/users", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.firstName.capitalize() + ' ' + value.lastName.capitalize());
				t = t.replace('img_url', value.mediumPicture);
				t = t.replace('user_name', value.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', value.id);
				t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#name').val().toLowerCase();
			var fullname = value.firstName + ' ' + value.lastName;
			
			if (inputValue == value.firstName || inputValue == value.lastName
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
	$.get("${pageContext.request.contextPath}/users", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.firstName.capitalize() + ' ' + value.lastName.capitalize());
				t = t.replace('img_url', value.mediumPicture);
				t = t.replace('user_name', value.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', value.id);
				t = t.replace('p_hone', value.phone);
			
			var inputValue = $('#city').val().toLowerCase();
			
			if (inputValue == value.city) {
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
	$.get("${pageContext.request.contextPath}/users", function(res) {
		$('#result').html('');
		results = res.results;
		$.each(res.results, function(index, value) {

			$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t =	template.replace('full_name',value.firstName.capitalize() + ' ' + value.lastName.capitalize());
				t = t.replace('img_url', value.mediumPicture);
				t = t.replace('user_name', value.username);
				t = t.replace('gender', value.gender)
				t = t.replace('e_mail', value.email);
				t = t.replace('number', value.id);
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


