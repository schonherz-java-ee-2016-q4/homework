$(document).ready(function() {
	$.get("/homework5_web/Posts", function(res) {
		$.each(res, function(index, value) {
			$.get('./resources/content/postcontent.html', function(template) {
			var t=template.replace('Header',value.header);
			t=t.replace('username', "Posted by "+value.username);
			t=t.replace('post_url', "Posts?post_id="+value.id);
			t=t.replace('date',  value.date);
			t=t.replace('tags',  value.tags);
			$('#result').append(t);
			});		
		
		});
	});
});