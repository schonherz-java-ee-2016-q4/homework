/**
 * Created by Geri on 2017. 01. 09..
 */

function validate() {
    var fname = document.regForm.firstname.value;
    var lname = document.regForm.lastname.value;
    var dob = document.regForm.dob.value;
    var state = document.regForm.state.value;
    var street = document.regForm.street.value;
    var city = document.regForm.city.value;
    var postcode = document.regForm.postcode.value;
    var email = document.regForm.email.value;
    var username = document.regForm.username.value;
    var password1 = document.regForm.password1.value;
    var password2 = document.regForm.password2.value;
    var thumbnail = document.regForm.thumbnail.value;
    var largePicture = document.regForm.large.value;
    var mediumPicture = document.regForm.medium.value;

    var values = [fname, lname, dob, state, street, city, postcode, email, username, password1, password2,
    thumbnail, largePicture, mediumPicture];

    for (var idx = 0; idx < values.length; idx++) {
        if (values[idx] == "") {
            alert("All fields are required! Please fill them with valid data!");
            return false;
        }
    }
    return true;
}

// Validates that the input string is a valid date formatted as "mm/dd/yyyy"
function isValidDate(dateString)
{
    // First check for the pattern
    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
        return false;

    // Parse the date parts to integers
    var parts = dateString.split("/");
    var day = parseInt(parts[1], 10);
    var month = parseInt(parts[0], 10);
    var year = parseInt(parts[2], 10);

    // Check the ranges of month and year
    if(year < 1000 || year > 3000 || month == 0 || month > 12)
        return false;

    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    // Adjust for leap years
    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
        monthLength[1] = 29;

    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
};
