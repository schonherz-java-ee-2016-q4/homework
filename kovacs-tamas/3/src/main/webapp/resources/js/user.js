$(document).ready(function () {

    $('#get_user').click(function () {
        var size = new Number($('#number').val());
        $.get('https://randomuser.me/api/?results=' + size, function (res) {
            $('#result').html('');
            console.log(res);

            $.each(res.results, function (index, value) {
                $.get('/WebApp/content/content.html', function (template) {
                    var t = template.replace('img_url', value.picture.medium);
                    t = t.replace('user_name', capitalize(value.name.first) + ' ' + capitalize(value.name.last));
                    t = t.replace('gender', value.gender);
                    t = t.replace('dob', value.dob);
                    t = t.replace('nationality', value.nat);
                    t = t.replace('phone_number', value.phone);
                    t = t.replace('email', value.email);
                    $('#result').append(t);
                });


            });

        }).done(function () {
        }).fail(function () {
        }).always(function () {
        });

    });
});

function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
