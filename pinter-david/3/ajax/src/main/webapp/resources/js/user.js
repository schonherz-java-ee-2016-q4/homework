var list;

$(document).ready(function () {

    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }
    $('#get_user').click(function () {
        var size = new Number($('#number').val());
        $.get('https://randomuser.me/api/?results=' + size, function (res) {
            $('#result').html('');
            console.log(res);
            $.each(res.results, function (index, value) {

                $.get('/WebApp/content/content.html', function (template) {
//                   
                    var t = template.replace('user_name', capitalizeFirstLetter(value.name.first)
                        + ' ' + capitalizeFirstLetter(value.name.last));
                    t = t.replace('img_url', value.picture.large);
                    t = t.replace('gender', value.gender);
                    t = t.replace('email', value.email);
                    t = t.replace('phone_number', value.phone);
                    t = t.replace('nationality', value.nat);
                    t = t.replace('registration_date', value.registered);
                    t = t.replace('date_of_birth', value.dob);
                    
                    
                    
                    $('#result').append(t);
                    
//                    var gender = template.replace('gender',value.gender);
//                   
                });


            });

        }).done(function () {
        }).fail(function () {
        }).always(function () {
        });

    });
});
