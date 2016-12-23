var list;

$(document).ready(function () {

    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }

    function getMotto() {

        return $.get('/WebApp/resources/json/mottos.json', function () {
        });

    }


    $('#get_user').click(function () {
        $('#get_user').html('Please wait...').prop('disabled', true);
        var size = new Number($('#number').val());
        $.get('https://randomuser.me/api/?results=' + size, function (res) {
            $('#result').html('');
            console.log(res);
            $.each(res.results, function (index, value) {

                $.get('/WebApp/content/content.html', function (template) {                 
                    var t = template.replace('user_name', capitalizeFirstLetter(value.name.first)
                            + ' ' + capitalizeFirstLetter(value.name.last));
                    t = t.replace('img_url', value.picture.large);
                    t = t.replace('gender', value.gender);
                    t = t.replace('email_text', value.email);
                    t = t.replace('phone_number', value.phone);
                    t = t.replace('nationality', value.nat);
                    t = t.replace('registration_date', value.registered);
                    t = t.replace('date_of_birth', value.dob.substr(0, 10));

                    var age = new Date(Date.parse(value.dob.substr(0, 10)));
                    var ageYear = age.getFullYear();
                    var now = new Date(Date.now());
                    var nowYear = now.getFullYear();
                    var ageYear = nowYear - ageYear;
                    t = t.replace('age', 'age: ' + ageYear.toString());


                    $.when(getMotto()).done(function (motto_return) {
                        $('.dateOfBirthPopOver').popover();
                        var index = Math.floor((Math.random() * motto_return.mottos.length));
                        var motto = motto_return.mottos[index].text;
                        if (motto.length > 45) {
                            t = t.replace('motto_popover_text', motto);
                            $('.mottoPopOver').popover();
                            motto = motto.substr(0, 45) + "...";
                        }
                        
                        t = t.replace('motto_text', motto);
                        $('#result').append(t);
                    });
                });
            });

        }).done(function () {
            $('#get_user').html('Submit').prop('disabled', false);
        }).fail(function () {
        }).always(function () {
        });

    });
});
