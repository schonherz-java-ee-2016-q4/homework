var value;
$(document).ready(function() {
	
	$.get(getContextPath() + "/ReadPost/" + GetURLParameter('id'), function(res) {
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
	fillModal(value);
}