/**
 * @author : ASHLIN ABRAHAM
 * @date : 17.07.2019
 * @purpose : Register company details.
 */
//---------------------------------------------HIDE HELP BLOCKS--------------------------------------------------
$('#emailErrorMsg').hide();
$('#orgNameEmptyMsg').hide();
$('#adrsEmptyMsg').hide();
$('#contactEmptyMsg').hide();
$('#emailEmptyMsg').hide();
$('#orgIdEmptyMsg').hide();
$('#gstEmptyMsg').hide();
$('#industryEmptyMsg').hide();
//---------------------------------------------------------------------------------------------------------------
function getIndustryTypes(){
	 var jsonURL="industryTypes";
	    var industryTypes = [];
	    $.getJSON(jsonURL, function(json) {
	    $.each(json.data, function(data) {   
	         $('#industryType').append($("<option></option>").attr("value",this.industryId).text(this.industryType));
	    });
	    });
	
}

$ (document).ready(function(){
	var contactNumber;
	var emailId;
	var organizationName;
	var organizationId;
	var address;
	var gstin;
	var industryId;
	var companyId = 0;
	var formData = new FormData();
	
//---------------------------------------HIDE AND SEEK HELP BLOCKS---------------------------------------------
	 $("#contactNumber").keyup(function(){
		 if ( $("#contactNumber").val().length > 0) {
			 $('#contactEmptyMsg').hide();
			 
		 }
	 });
	 $("#emailId").keyup(function(){
		 if ( $("#emailId").val().length > 0) {
			 $('#emailEmptyMsg').hide();
			 
		 }
	 });
	 $("#organizationName").keyup(function(){
		 if ( $("#organizationName").val().length > 0) {
			 $('#orgNameEmptyMsg').hide();
			 }
	 });
	 $("#organizationId").keyup(function(){
		 if ( $("#organizationId").val().length > 0) {
			 $('#orgIdEmptyMsg').hide();
			 
		 }
	 });
	 $("#address").keyup(function(){
		 if ( $("#address").val().length > 0) {
			 $('#adrsEmptyMsg').hide();
			 
		 }
	 });
	 $("#gstin").keyup(function(){
		 if ( $("#gstin").val().length > 0) {
			 $('#gstEmptyMsg').hide();
			 
		 }
	 });
	 
	 $('.select2').on('change', function() {
		 $('#industryEmptyMsg').hide();
		});
	
//-------------------------------------------------------------------------------------------------------------	
	var length = $('#industryType').children('option').length;
	if(length == 1){
		getIndustryTypes();
	}
	$("#contactNumber").numeric();
	$("#emailId").focus(function(){
		
	}).blur(function(){
		emailId = $("#emailId").val();
		if($.trim(emailId).length == 0){
			console.log("no email");
		}else{
			if(filterEmail(emailId)){
				$('#emailErrorMsg').hide();
			}else{
				$('#emailErrorMsg').show();
				if($("#emailErrorMsg").is(":visible")){
					$('#emailId').trigger( "focus" );
                } 
			}
		}
	});

	
	
//---------------------------------------------------------------------------------------------------------------
	function filterEmail(email) {
        var regex = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
        return regex.test(email);
    }
//------------------------------------------------START SUBMISSION-----------------------------------------------
	$("#registerBtn").click(
	        function(e) {
	
	
	 contactNumber = $("#contactNumber").val();
	 emailId = $("#emailId").val();
	 organizationName = $("#organizationName").val();
	 organizationId = $("#organizationId").val();
	 address = $("#address").val();
	 gstin = $("#gstin").val();
	 industryId = $('#industryId').find(":selected").val();
	 var file = $('#companyLogo').get(0).files[0];
	 
	 if(contactNumber == ''){
		 $('#contactEmptyMsg').show();
		
		 
	 }
	 if(emailId == ''){
		 $('#emailEmptyMsg').show();
		 
		 
	 }
	 if(organizationName == ''){
		 $('#orgNameEmptyMsg').show();
		 
		 
	 }
	 if(organizationId == ''){
		 $('#orgIdEmptyMsg').show();
		 
	 }
	 if(address == ''){
		 $('#adrsEmptyMsg').show();
		
		 
	 }
	 if(gstin == ''){
		 $('#gstEmptyMsg').show();
		 
	 }
	 if(industryId == undefined || industryId == 0){
		 $('#industryEmptyMsg').show();
	 }
	 
	 
	 
	 formData.append('file', file);
	 formData.append('comapanyId', comapanyId);
	 formData.append('organizationName', organizationName);
	 formData.append('organizationId', organizationId);
	 formData.append('emailId', emailId);
	 formData.append('contactNumber', contactNumber);
	 formData.append('address', address);
	 formData.append('gstin', gstin);
	 formData.append('industryId', industryId);
	 
	 
 });
//-----------------------------------------END OF SUBMISSION-------------------------------------------------------
});