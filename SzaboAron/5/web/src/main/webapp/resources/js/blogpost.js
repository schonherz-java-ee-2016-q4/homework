var slided = 0;

$(document).ready(function() {
		init();
		getPosts();
});

function init(){
	$('#new_post_form').hide();
}

function getPosts(){
	$.get("${pageContext.request.contextPath}/PostLister", function(res) {
		console.log(res);
		displayPostList(res);
	})
}

function displayPostList(list) {
	$('#posts').html('');
	$.each(list, function(index, value) {
		$.get('${pageContext.request.contextPath}/content/blogpost.html',
				function(template) {
					var t = template.replace('date', value.postPublishTime);
					t = t.replace('myTitle', value.postTitle);
					t = t.replace('username', value.owner.username);
					console.log(t);
					$('#posts').append(t);

					console.log('displayed');
				});
	});
}


function on_header_clocked() {
	if (slided == 0) {
		$('#new_post_form').slideDown('slow');
		slided = 1;
	} else {
		$('#new_post_form').slideUp('slow');
		slided = 0;
	}
}