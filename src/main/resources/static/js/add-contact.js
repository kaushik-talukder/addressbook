$(document).ready(function() {
	$("body").on("click", "#save-contact", function() {
		addContact();
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