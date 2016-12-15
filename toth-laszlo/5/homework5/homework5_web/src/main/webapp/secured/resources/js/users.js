$(document).ready(function() {
	$.get("/homework5_web/Userservlet", function(res) {
		$.each(res, function(index, value) {
			$.get('./content/usercontent.html', function(template) {
			var t=template.replace('user_name',"Name: "+value.first_name+" "+value.last_name);
			t=t.replace('img_url',value.pic_large);
			t=t.replace('city', "city: "+ value.city);
			t=t.replace('dob', "Date of birth: "+  value.dob);
			t=t.replace('cell', "Cell: "+  value.cell);
			
			$('#result').append(t);
			});		
		
		});
	});
});