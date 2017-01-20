/**
 * Created by Áron on 2017. 01. 09..
 */

$(document).ready(function () {
    $('#create_post').submit(function (event) {
        createViaAjax();
        event.preventDefault();
    });

});

function createViaAjax() {

    var form = {};
    form["title"] = $('#title').val();
    form["body"] = $('#body').val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/create",
        data: JSON.stringify(form),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
        }
    });
}
