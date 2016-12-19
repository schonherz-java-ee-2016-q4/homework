$(document).ready(function() {
	
	$('#nav_home').addClass('active');
	$.get(getContextPath() + '/content/blog_table_line.html', function(temp_res) {
		$.get(getContextPath() + "/ListPosts", function(res) {
			i = 0;
			$.each(res, function(index, value) {
				i++;
				var out = temp_res.replace("value_title", value.title);
				out = out.replace("value_link", getContextPath() + "/secured/post.jsp?id=" + value.id);
				out = out.replace("value_posted", value.posted);
				out = out.replace("value_username", value.author.login.username);
				out = out.replace("number_i", i);
				out = out.replace("number_i", i);
				out = out.replace("value_tags", value.tags.join(', '));
				
				$('#res_table').append(out);
				
			});
		});
	});
	
});
function pop(i) {
	$('#popover_' + i).popover('toggle');
}