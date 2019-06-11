$(document).ready(function() {
	$("body").on("click", "#save-contact", function() {
		addContact();
	});
	
	$("body").on("click", "#show-all-contacts", function() {
		showAllContacts();
	});
});

function addContact() {
	var firstName = $("#first-name").val();
	var lastName = $("#last-name").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var address = $("#address").val();

	$.ajax({
		method : "POST",
		url : "addContact",
		data : JSON.stringify({
			firstName : firstName,
			lastName : lastName,
			mobile : mobile,
			email : email,
			address : address
		}),
		dataType : "json",
		contentType : "application/json"
	}).done(function(response) {
		alert(response.firstName +" Saved to db");
	});

	// console.log(firstName+":"+lastName+":"+mobile+":"+email+":"+address);
}

function showAllContacts(){
	$.ajax({
		method : "POST",
		url : "showAllContacts",
		dataType : "json"
	}).done(function(response) {
		console.log(response);
		//$('#tab-all-contacts').destroy();
		$('#tab-all-contacts').DataTable( {
	        data: response,
	        columns: [
	        	{ 
	            	title: "Id",
	            	data: "id"
	            },
	            { 
	            	title: "First Name",
	            	data: "firstName"
	            },
	            { 
	            	title: "Last Name",
	            	data: "lastName"
	            },
	            { 
	            	title: "Mobile",
	            	data: "mobile"
	            },
	            { 
	            	title: "Email",
	            	data: "email"
	            },
	            { 
	            	title: "Address",
	            	data: "address"
	            }
	        ]
	    } );
	});
}