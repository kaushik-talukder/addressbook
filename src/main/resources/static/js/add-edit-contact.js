$(document).ready(function() {
	$("body").on("click", "#save-contact", function() {
		addEditContact();
	});
});

function addEditContact() {
	var firstName = $("#first-name").val();
	var lastName = $("#last-name").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var address = $("#address").val();
	var contactId = $("#contact-id").val()
	$.ajax({
		method : "POST",
		url : "addEditContact",
		data : JSON.stringify({
			id: contactId > 0 ? contactId : null,
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
		resetForm();
	});

	// console.log(firstName+":"+lastName+":"+mobile+":"+email+":"+address);
	
	function resetForm(){
		$("#first-name").val("");
		$("#last-name").val("");
		$("#mobile").val("");
		$("#email").val("");
		$("#address").val("");
		$("#contact-id").val(0);
	}
}

