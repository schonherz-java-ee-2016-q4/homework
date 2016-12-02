var list;
var size;
function slider(clicked_id) {
	console.log("clicked");
	console.log(list[clicked_id[clicked_id.length-1]]);
	$("#picture").html('');
	$.get('content/content_pop_up.html', function(template) {
				var t=template.replace('user_name',list[clicked_id[clicked_id.length-1]].name.first +' '+list[clicked_id[clicked_id.length-1]].name.last);
				t=t.replace('img_url',list[clicked_id[clicked_id.length-1]].picture.large);
				t=t.replace('email_',list[clicked_id[clicked_id.length-1]].email);
				t=t.replace('phone_',list[clicked_id[clicked_id.length-1]].phone);
				t=t.replace('registered_',list[clicked_id[clicked_id.length-1]].registered);
				$('#picture').append(t);
});
	$("#picture").modal('show');	
	}
function hider(){
	$("#picture").modal('hide');	
}

$('document').ready(function() {
	$('#get_user').click(function() {
		list=[];
		$('#myPleaseWait').modal('show');
		size = new Number($('#number').val());
		var get_string = 'https://randomuser.me/api/?results=' + size;
		if($('#chk_male')[0].checked != $('#chk_female')[0].checked){
			get_string  += $('#chk_male')[0].checked  ? '&gender=male' : '&gender=female'; 	
		}
		console.log(get_string);
		$.get(get_string, function(res) {
			$('#result').html('');
			console.log(res);
			var a = 0;
			list = res.results;
			console.log(list);
			$.each(res.results, function(index, value) {
				$.get('content/content.html', function(template) {
				var t=	template.replace('name',value.name.first +' '+value.name.last);
				t=t.replace('img_url',value.picture.medium);
				t=t.replace('user_name',value.login.username);
				if(value.gender == "male"){
					t=t.replace('gender','&#9794');
				}
				else{
					t=t.replace('gender','&#9792');
					}
				
				t=t.replace('myid','content'+a);
				t=t.replace('custom_on_click','slider(this.id)');
				$('#result').append(t);
				a++;
				});

			
				
			});
		}).done(function() {
			$('#myPleaseWait').modal('hide');
		}).fail(function() {
			window.alert("There was a problem");
		}).always(function() {
			//window.alert("alwayws");
		});

	});
});

