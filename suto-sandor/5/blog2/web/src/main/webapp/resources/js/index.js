$(document).ready(function() {
	
	$('#nav_home').addClass('active');
	$.get('${pageContext.request.contextPath}/content/blog_head.html', function(temp_res) {
		$.get("${pageContext.request.contextPath}/ListPosts", function(res) {
			$.each(res, function(index, value) {
				var out = temp_res.replace("posttitle", value.header);
				out = out.replace("link", "${pageContext.request.contextPath}/secured/post.jsp?id=" + value.id);
				out = out.replace("link", "${pageContext.request.contextPath}/secured/post.jsp?id=" + value.id);
				out = out.replace("created", value.created);
				out = out.replace("username", value.username);
				out = out.replace("tags", value.tags);
				
				$('#res_post_heads').append(out);
				
			});
		});
	});
	
});
