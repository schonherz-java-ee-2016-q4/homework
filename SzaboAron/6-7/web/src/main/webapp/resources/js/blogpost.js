var slided = 0;

$(document).ready(function () {
    init();
    getPosts();
});

function init() {
    $('#new_post_form').hide();
}

function getPosts() {
    $.get("/list", function (res) {
        displayPostList(res);
    })
}

function displayPostList(list) {
    $('#posts').html('');
    $.each(list, function (index, value) {
        console.log(value);
        $.get('/resources/content/blogpost.html',
            function (template) {
                var t = template.replace('spec_date', value.postPublishTime);
                t = t.replace('spec_title', value.postTitle);
                t = t.replace('spec_username', value.owner.username);
                t = t.replace('spec_id', value.id);
                $('#posts').append(t);

            }
        )
        ;
    });
}


function on_header_clocked() {
    if (slided == 0) {
        $('#new_post_form').slideDown('slow');
        slided = 1;
    } else {
        $('#new_post_form').slideUp('slow');
        slided = 0;
    }
}