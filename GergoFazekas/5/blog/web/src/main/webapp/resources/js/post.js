var list;
var results;

$(document).ready(function() {

		$('#result').hide();
		$(".loader").show();
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/listposts", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {
				$.get('${pageContext.request.contextPath}/content/post.html', function(template) {
				var t =	template.replace('_title',value.title);
				t = t.replace('published', value.published);
				t = t.replace('author', value.authorID);
				t = t.replace('content', value.content)
				$('#result').append(t);
			});
			$(".loader").hide();
			$('#result').show();
		});	
		});
});