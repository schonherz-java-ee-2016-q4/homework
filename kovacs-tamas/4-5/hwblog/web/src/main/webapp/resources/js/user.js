var results;    // Will contain the data of the users, as some sort of collection

$(document).ready(function () {     // Only executes when the document is completely loaded
    // While loading the data, hide the result container and show the loading indicator
    $('#result').hide();
    $(".loader").show();

    var size = new Number($('#number').val());
    // Get the user data from the UserServlet and apply this function to the returned data
    $.get("/web/UserServlet", function (res) {
        $('#result').html('');      // Some sort of clear, emptiing the result container
        console.log(res);           // Print out the data returned by the get function, aka all the user data

        results = res.results;      // Save the returned results to a variable that is accessible from the other method
        $.each(results, function (index, value) {
            // Read the template html and replace default values with real user data
            $.get('/web/content/content.html', function (template) {
                var t = template.replace('user_name', value.name.first + ' ' + value.name.last);
                t = t.replace('img_url', value.picture.large);
                t = t.replace('city', value.location.postcode + ' ' + value.location.city);
                t = t.replace('street', value.location.street);
                t = t.replace('mail_addr', value.email);
                t = t.replace('number', index);

                /* After all the replacing, the variable 't' is a complete list item,
                 * containing every data of a single user. Add this list item to the end of the container.
                 */
                $('#result').append(t);
            }); // content.html get
        }); // end of forEach cycle

        // Now that all the data has been processed, it's time to hide the loading indicator and show the results
        $(".loader").hide();
        $('#result').show();
    }); // UserServlet get
}); // document - ready


function handleClick(id) {
    //alert(id);
    $('#myModal').html('');
    $.get('/web/content/modal.html', function (modal_res) {

        $.each(results, function (index, value) {
            if (index == id) {
                var t = modal_res.replace('user_name', value.name.first + ' ' + value.name.last);
                t = t.replace('email', value.email);
                t = t.replace('username', value.login.username);
                t = t.replace('password', value.login.password);
                t = t.replace('phone', value.phone);
                t = t.replace('dob', value.dob);
                t = t.replace('gender', value.gender);
                t = t.replace('registered', value.registered);
                t = t.replace('cell', value.cell);
                t = t.replace('location', value.location.postcode + ' '
                        + value.location.city + ', '
                        + value.location.street);
                t = t.replace('img_url', value.picture.large);

                $('#myModal').append(t);
                return;
            }

        });

    });
}
