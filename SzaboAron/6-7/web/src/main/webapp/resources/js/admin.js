var list;
var results = [];
var slided = 0;

$(document).ready(function () {
    init();
    get_user_list();

    $("#filter_form").on("submit", function (event) {
        event.preventDefault();
        var str = $(this).serialize();
        get_filtered_user_list(str);
        console.log(str);
    });

});

function init() {
    $('#result').hide();
}

function get_user_list() {
    $.get("/listusers", function (res) {
        results = res;
        display_user_list(res);
        $('#result').show();
    });

}

function display_user_list(user_list) {
    $('#result').html('');
    $.each(user_list, function (index, value) {
        $.get('/resources/content/admin_content.jsp',
            function (template) {
                var t = template.replace('username_param', value.username);
                t = t.replace('username', value.username);
                t = t.replace('email', value.email);
                t = t.replace('enabled', value.active);
                t = t.replace('_id', value.id);
                $('#result').append(t);
            });
    });
}

function switchUserStatus(username_param) {
    var form = {};
    form["username"] = username_param;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/switchUserStatus",
        data: JSON.stringify(form),
        dataType: 'json',
        timeout: 100000,
        success: function (response) {
            console.log('OK');
        },
        error: function () {
            alert("Something went wrong");
        }
    });
}