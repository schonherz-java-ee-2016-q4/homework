$(document).ready(function () {
    init();
    console.log(getParameter('id'));
    getPosts();
});

function init() {

}

function getPosts() {
    $.get("/PostReader?id="
        + getParameter('id'), function (res) {
        console.log(res);
        displayPostList(res);
    })
}

function getParameter(str) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == str) {
            return sParameterName[1];
        }
    }
}

function displayPostList(post) {
    $('#fullpost').html('');
    $.get('/resources/content/fullpost.html', function (template) {
        var t = template.replace('date', post.postPublishTime);
        t = t.replace('myTitle', post.postTitle);
        t = t.replace('myid', post.id);
        t = t.replace('postbody', post.postBody);
        $('#fullpost').append(t);

        console.log('displayed');
    });
}