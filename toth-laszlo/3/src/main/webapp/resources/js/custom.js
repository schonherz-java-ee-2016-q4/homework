$(document).ready(function() {

   $("#get_btn").click(function() {
	   document.getElementById("result").innerHTML = "<tr></tr>";
	   var size = new Number($('#number').val());
		var i=0;
		var w = Math.round($(window).width()/100)
		var column=Math.round(w/3.5);
	   
	   $.get('https://randomuser.me/api/?results=' + size, function(res) {
			console.log(res);
			
			$.each(res.results, function(index, value) {

				$.get('./content/content.html', function(template) {
				var t=template.replace('user_name',"Name: "+value.name.first +' '+value.name.last);
				t=t.replace('img_url',value.picture.large);
				t=t.replace('gender', "gender: "+ value.gender);
				t=t.replace('dob', "Date of birth: "+  value.dob);
				t=t.replace('cell', "Cell: "+  value.cell);
				t=t.replace('email', "Email: "+ value.email);
				$('#result').append(t);
				i++;
				if(i%column==0) {
					$('#result').append("</tr> <tr>")
				}
				});		
			});
	   });
   }); 
 
	
});