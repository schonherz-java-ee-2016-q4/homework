var results;    // Will contain the data of the users, as some sort of collection

$(document).ready(function () {     // Only executes when the document is completely loaded
// While loading the data, hide the result container and show the loading indicator
    $('#result').hide();
    $(".loader").show();
    var size = new Number($('#number').val());
    // Get the user data from the UserServlet and apply this function to the returned data
    $.get("/web/user", function (res) {
        $('#result').html(''); // Some sort of clear, emptiing the result container
        console.log(res); // Print out the data returned by the get function, aka all the user data

        results = res.results; // Save the returned results to a variable that is accessible from the other method
        $.each(results, function (index, value) {
            addToUserList(index, value);
        });
        // Now that all the data has been processed, it's time to hide the loading indicator and show the results
        $(".loader").hide();
        $('#result').show();
    });
}); // document - ready

function addToUserList(index, value) {
    // Read the template html and replace default values with real user data
    $.get('/web/content/content.html', function (template) {
        var t = template.replace('user_name', value.name.firstName + ' ' + value.name.lastName);
        t = t.replace('img_url', value.picUrl);
        t = t.replace('city', value.location.postCode + ' ' + value.location.city);
        t = t.replace('street', value.location.street);
        t = t.replace('mail_addr', value.email);
        t = t.replace('number', index);
        /* After all the replacing, the variable 't' is a complete list item,
         * containing every data of a single user. Add this list item to the end of the container.
         */
        $('#result').append(t);
    }); // content.html get
}


function handleClick(id) {
    $('#myModal').html('');
    $.get('/web/content/modal.html', function (modal_res) {

        $.each(results, function (index, value) {
            if (index == id) {
                var t = modal_res.replace('user_name', value.name.firstName + ' ' + value.name.lastName);
                t = t.replace('email', value.email);
                t = t.replace('username', value.login.username);
                t = t.replace('password', value.login.password);
                t = t.replace('phone', value.phone);
                t = t.replace('dob', value.dates.birth);
                t = t.replace('gender', value.gender);
                t = t.replace('registered', value.dates.registration);
                t = t.replace('location', value.location.postCode + ' '
                        + value.location.city + ', '
                        + value.location.street);
                t = t.replace('img_url', value.picUrl);
                $('#myModal').append(t);
                return;
            }

        });
    });
}

function filter() {
    var username = $('#username-filter').val().trim();
    var age = $('#age-filer').val();
    var gender = $('#gender-filter').val();
    var email = $('#email-filter').val();
    var city = $('#city-filter').val();

    $('#result').html('');
    $.each(results, function (index, value) {
        var matchesFilters = true;
        if (username.length > 0) {
            if (value.login.username.indexOf(username) == -1) {
                matchesFilters = false;
            }
        }

        if (email.length > 0) {
            if (value.email.indexOf(email) == -1) {
                matchesFilters = false;
            }
        }

        if (city.length > 0) {
            if (value.location.city.indexOf(city) == -1) {
                matchesFilters = false;
            }
        }

        if (gender !== 'both') {
            if (value.gender !== gender) {
                matchesFilters = false;
            }
        }

        if (age.length > 0) {
            var ageNum = Number(age);
            if (ageNum !== value.dates.age) {
                matchesFilters = false;
            }
        }

        if (matchesFilters) {
            addToUserList(index, value);
        }

    });
}
