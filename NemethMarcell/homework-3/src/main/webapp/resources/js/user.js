var list;

$(document).ready(function() {
	$('#get_user').click(function() {
		
		var size = new Number($('#number').val());
		
		 $.get('https://randomuser.me/api/?results=' + size, function(res) {
			 $('#result').html('');
	            console.log(res);
	         $.each(res.results, function(index,value) {
				
			$.get('/WebApp/content/content.html',function(template){
				var t = template.replace('user_name',value.name.first+' '+value.name.last);
				t = t.replace('gender',value.gender);
				t = t.replace('img_url',value.picture.large);
				t = t.replace('phone', value.phone);
				t = t.replace('email',value.email);
				t = t.replace('address', value.location.street);
				t = t.replace('password' ,value.login.password);
				
				$('#result').append(t);
				
			 
				  $('.caption').css('color','#FAFAFA');
				
				
				 
				
			});
			 
			});
		  }).done(function() {
		  }).fail(function() {
		  }).always(function() {
		  });
		
		
		
		
});
	
	
});