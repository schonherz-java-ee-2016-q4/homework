var list = [];
$('document').ready(function() {
	$('#get_user').click(function() {
		$('#myPleaseWait').modal('show');
		var size = new Number($('#number').val());
		var get_string = 'https://randomuser.me/api/?results=' + size;
		if($('#chk_male')[0].checked != $('#chk_female')[0].checked){
			get_string  += $('#chk_male')[0].checked  ? '&gender=male' : '&gender=female'; 	
		}
		console.log(get_string);
		$.get(get_string, function(res) {
			$('#result').html('');
			console.log(res);
			var a = 0;
			$.each(res.results, function(index, value) {
				$.get('content/content.html', function(template) {
				var t=	template.replace('user_name',value.name.first +' '+value.name.last);
				t=t.replace('img_url',value.picture.medium);
				t=t.replace('gender',value.gender);
				t=t.replace('myid','content'+a);
				$('#result').append(t);
				a++;
				});

			
				
			});
		var i;
		for(i = 0; i<size; i++){
				$('#content'+a).click(function(){
   					slider();
				});
				console.log("added " + "#content"+a);
		}
		}).done(function() {
			$('#pager').show();	
			$('#myPleaseWait').modal('hide');
		}).fail(function() {
			window.alert("There was a problem");
		}).always(function() {
			//window.alert("alwayws");
		});

	});
});

function slider() {
	"use strict";
	console.log("clicked");
}
