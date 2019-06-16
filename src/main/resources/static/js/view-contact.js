$(document).ready(function() {
	 $('#tab-all-contacts').DataTable();
	 $("body").on("click", "#delete-contact", function() {
		 var contactId = $(this).attr("contactId");
		 deleteContact(contactId);
		});
	 
	 
});

function deleteContact(contactId){
	$.ajax({
		method : "POST",
		url : "deleteContact",
		data : {
			id : contactId
		},
		dataType : "json"
	}).done(function(response) {
		if(response){
			alert("Contact deleted");
			document.location.reload();
		} else {
			alert("Something happened wrong. Please try after sometime.");
		}
	});
}