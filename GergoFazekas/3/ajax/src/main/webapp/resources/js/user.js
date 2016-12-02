var list;

String.prototype.capitalize = function() {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

$(document).ready(function() {
	$('#infoalert').show("slow");
	$('#dangeralert').hide();
	$('#get_user').click(function() {
		$('#dangeralert').hide();
		$('#infoalert').hide();
		var size = new Number($('#number').val());
		if (size < 1 || size > 100) {
			$('#dangeralert').show("slow");
		} else {
		$.get('https://randomuser.me/api/?results=' + size, function(res) {
			$('#result').html('');
			console.log(res);
			$.each(res.results, function(index, value) {

				$.get('/WebApp/content/content.html', function(template) {
				var t =	template.replace(/full_name/g,value.name.first.capitalize() +' '+value.name.last.capitalize());
				t = t.replace(/gender/g, value.gender);
				t = t.replace(/user_name/g, value.login.username);
				t = t.replace(/p_hone/g, value.phone);
				t = t.replace(/e_mail/g, value.email);
				t=t.replace('img_url',value.picture.medium);
				t=t.replace('img_url_large',value.picture.large);
				$('#result').append(t);
				});
				
				
			});
		
		});
		
		}
		
	});
});
