$(document).ready(function() {
	$.get("/homework5_web/Posts", function(res) {
		console.log(res);
		$.each(res, function(index, value) {
			$.get('./resources/content/postcontent.html', function(template) {
				console.log(value.tags)
			var t=template.replace('Header',value.header);
			t=t.replace('username', value.username);
			t=t.replace('post_url', "Posts?post_id="+value.id);
			t=t.replace('date',  value.date);
			t=t.replace('tags',  value.tags);
			$('#result').append(t);
			});		
		
		});
	});
});