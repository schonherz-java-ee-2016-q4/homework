$(document).ready(function() {
	
	$.get("${pageContext.request.contextPath}/ReadPost?id=" + GetURLParameter('id'), function(res) {
		$('#post_title').html(res.title);
		$('#post_date').html(res.posted);
		$('#post_name').html(res.poster.login.username);
		
		$('#post_content').html(res.text);
		
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