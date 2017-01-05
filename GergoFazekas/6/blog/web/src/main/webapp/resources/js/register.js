
$(document).ready(function() {
	
	$(function() {
	     $("#dob").datepicker();
	   });

	$('#alertbasic').hide();
	$('#alertlocation').hide();
	$('#alertlogin').hide();
	$('#alertpicture').hide();
	
	$('#registration').submit(function(event){
		$('#alertbasic').hide();
		$('#alertlocation').hide();
		$('#alertlogin').hide();
		$('#alertpicture').hide();
		
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var numberReg = /^[0-9]+$/;
		var urlReg = /(http|ftp|https):\/\/[\w-]+(\.[\w-]+)+([\w.,@?^=%&amp;:\/~+#-]*[\w@?^=%&amp;\/~+#-])?/;
		
		var pw1 = $('#password1').val();
		var pw2 = $('#password2').val();
		var dob = $('#dob').val();
		var email = $('#email').val();
		var postcode = $('#postcode').val();
		var large = $('#large').val();
		var medium = $('#medium').val();
		var thumbnail = $('#thumbnail').val();
		
		if (!validDate(dob)) {
			$('#alertbasic').show();
			$('#alertbasic').html("Please type valid date! Hint: Use the datepicker! :)");
			return false;
		}
		
		if (!numberReg.test(postcode)) {
			$('#alertlocation').show();
			$('#alertlocation').html("Please type valid postcode (Contains only numbers)!");
			return false;
		}
		
		if(pw1 != pw2) {
			$('#alertlogin').show();
			$('#alertlogin').html("Please type the same password!");
			return false;
		}
		
		if (!emailReg.test(email)) {
			$('#alertlogin').show();
			$('#alertlogin').html("Please type valid email address! e.g user@example.com");
			return false;
		}
		
		if(!urlReg.test(large) || !url.test(medium) || !url.test(thumbnail)) {
			$('#alertpicture').show();
			$('#alertpicture').html("Please type valid URL!");
			return false;
		}
		
		return true;
		
		
	});

});

function validDate(text) {

    var date = Date.parse(text);

    if (isNaN(date)) {
        return false;
    }

    var comp = text.split('/');

    if (comp.length !== 3) {
        return false;
    }

    var m = parseInt(comp[0], 10);
    var d = parseInt(comp[1], 10);
    var y = parseInt(comp[2], 10);
    var date = new Date(y, m - 1, d);
    return (date.getFullYear() == y && date.getMonth() + 1 == m && date.getDate() == d);
    
}