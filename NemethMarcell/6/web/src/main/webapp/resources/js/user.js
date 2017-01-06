var list;
var results;

$(document).ready(function() {


		
		$('#result').hide();
		$(".loader").show();
		
		var size = new Number($('#number').val());
		$.get(getOtherContextPath()+"/UserServlet/new", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get(getOtherContextPath()+'/content/content.html', function(template) {
				var t=	template.replace('user_name',value.firstName +' '+value.LastName);
				t=t.replace('img_url',value.img);
				t=t.replace('username',value.username);
	
				t=t.replace('mail_addr',value.email);
				t=t.replace('number', index);
				
				$('#result').append(t);
				});
			});
			
			$(".loader").hide();
			$('#result').show();
		});


	
	
	
});

function handleClick(id) {
	//alert(id);
	$('#myModal').html('');
	$.get('${pageContext.request.contextPath}/content/modal.html', function(modal_res) {
		
		$.each(results, function(index, value) {
			if (index == id) {
				var t=	modal_res.replace('user_name',value.firstName +' '+value.LastName);
				t = t.replace('email', value.email);
				t = t.replace('username', value.username);
				t = t.replace('password', value.password);
				t = t.replace('phone', value.phone);
				t = t.replace('dob', value.date_of_birth);
				t = t.replace('gender', value.gender);
				t = t.replace('location', value.location);
				t = t.replace('img_url', value.img);
				
				$('#myModal').append(t);
				return;
			}
			
		});
		
	});
}
