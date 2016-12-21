$(document).ready(function() {
	$.get(getContextPath() + '/content/blog_table_line.html', function(temp_res) {
		$.get(getContextPath() + "/ListPosts", function(res) {
			i = 0;
			$.each(res, function(index, value) {
				i++;
				var out = temp_res.replace("value_title", value.title);
				out = out.replace("value_link", getContextPath() + "/secured/post.jsp?id=" + value.id);
				out = out.replace("value_posted", value.posted);
				out = out.replace("value_username", value.author.login.username);
				out = out.replace("value_tags", value.tags.join(', '));
				
				yesterday = new Date();
				yesterday.setDate(yesterday.getDate() - 1);
				posted = stringToDate(value.posted);
				
				if (yesterday > posted) {
					out = out.replace("New", '');
				}
				
				$('#res_table').append(out);
				$('[data-toggle="tooltip"]').tooltip(); 
			});
		});
	});
	
});

function stringToDate(_date)
{
	var splittedDate = _date.split(' ');
	var date = splittedDate[0].split('.');
	var time = splittedDate[1].split(':');
	var formatedDate = new Date(date[0], date[1] - 1, date[2], time[0], time[1]);
	return formatedDate;
}
