var list;
var results;

$(document).ready(function() {


		
		$('#result2').hide();
		
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/BlogServlet", function(res) {
			$('#result2').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get('${pageContext.request.contextPath}/content/blog.html', function(template) {
				var t=	template.replace('name',value.name);
				t=t.replace('title',value.title);
				t=t.replace('my_date', value.date)
				t=t.replace('textarea',value.textArea);
	
				
				t=t.replace('number', index);
				
				$('#result2').append(t);
				});
			});
			
			
			$('#result2').show();
		});
});
