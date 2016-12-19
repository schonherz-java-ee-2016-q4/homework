var value;
$(document).ready(function() {
	
	$.get(getContextPath() + "/ReadPost?id=" + GetURLParameter('id'), function(res) {
		$('#post_title').html(res.title);
		document.title = res.title;
		$('#post_date').html(res.posted);
		$('#post_name').html(res.author.login.username);
		
		md = window.markdownit();
		$('#post_content').html(md.render(res.content));
		
		value = res.author;
		
		$('#post_tags').html(res.tags.join(', '));
	});
	
});

function GetURLParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}

function showModal() {
	$('#myModal').html('');
	$.get(getContextPath() + '/content/modal.html', function(modal_res) {
		var t=	modal_res.replace('user_name',value.name.title + ' ' + value.name.first + ' ' + value.name.last);
		t = t.replace('email', value.email);
		t = t.replace('username', value.login.username);
		t = t.replace('password', value.login.password);
		t = t.replace('phone', value.phone);
		t = t.replace('dob', value.dob);
		t = t.replace('gender', value.gender);
		t = t.replace('registered', value.registered);
		t = t.replace('cell', value.cell);
		t = t.replace('location', value.location.postcode + ' '
				+ value.location.city + ', '
				+ value.location.street);
		t = t.replace('img_url', value.picture.large);
		
		$('#myModal').append(t);
	});
}