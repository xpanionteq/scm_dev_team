 /**
 * @author : ASWATHY RAJ.D
 * @purpose:script for contacts
 *  
 */




//------------------------------------------------------------------------

$(document).ready(function() {
	var contactName;
	var email;
	var workPhone;
	var mobileNumber;
	var workPhoneInt;
	var mobileNumberInt;
	var contactId;
	var contactType;
	var contactTypeId;
	var adrsMobileNumber;
	var floorBuilding;
	var locality;
	var landMark;
	var cityDistrict;
	var zipCode;
	var state;
	var route;
	var routeId;
	var gstIdentificationNumber;
	var customerName;
	var flag = false;
	var x;
	var y;
	var addressArray = [];
	var companyList = [];
	var contactIdInt;
	var contactType;
	var contactTypeId;
	$('#contactDetailsForm').hide();
	getVendorList();
	//get customerList();
	var companyName;
	var city;
	var shipmentRouteId;
	var building;
	var landNumber;
	var contactNumber;
	
	//----------------------------------------------------------------------------------------------
	
	
	getRoutes();
	
		function getRoutes(){
		var jsonURL="getRoutes";
			$.getJSON(jsonURL, function(json) {
			$.each(json.data, function(data) {   
			    $('#routeNew').append($("<option></option>").attr("value",this.routeId).text(this.route));
			    $('#route').append($("<option></option>").attr("value",this.routeId).text(this.route));
			});
			});
	}
		
	//-------------------------------------------------------------------------------------
	
		getcontactTypes();

		function getcontactTypes(){
			var jsonURL="contactTypes";
		    $.getJSON(jsonURL, function(json) {
		               $.each(json.data, function(data) {   
		               $('#selectContactType').append($("<option></option>").attr("value",this.contactTypeId).text(this.contactType));
		               });
		    });
		   }

	
	
	
//---------------------------------------------------------------------------------------------------------------------------------	
	$('#contactDetailsForm').hide();
	$('#newContact').on('click',function(){
		
		$('#newContactForm').show();
	});
	
 
	
//----------------------------------------------------------------------------------------------------------------------------------	
	$('#selectContactType').on('change', function() {
		contactTypeId=$('#selectContactType').val();
		console.log("contactType ID"+contactTypeId);
		getCustomerList();
		});
	
//----------------------------------------------------------------------------------------------------------------------

	function getVendorList(){
	     tableContact = $('#contactTable')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "viewvendor",
	                 "width" : "100%",

	                 "bAutoWidth" : false,
	                 "scrollCollapse" : true,
	                 "bScrollCollapse" : true,
	                 "iDisplayLength" : 10,
	                 "fixedHeader" : {
	                     "header" : true
	                 },
	                 "paging" : true ,
	                 "sPaginationType" : "simple",
	                 select : {
	                     style : 'single'

	                 },
	                 dom : 'Bfrtip',
	                 //"processing" : true,

	                 'columnDefs' : [
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 0,
	                         'data' : "contactId",
	                         "defaultContent" : "",
	                         
	                       },
	                          {
		  	                         'searchable' : false,
		  	                         'orderable' : false,
		  	                         'targets' : 1,
		  	                         'data' : "companyName",
		  	                         "defaultContent" : "",
		  	                         
		  	                       },
		  	                     {

		  								'targets' : 2,
		  								 "width": "20%",
		  								"defaultContent" : "",
		  								className : "",
		  								orderable: false,
		  								"render" : function(data,
		  										type, full, row) {
		  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square contactEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>'
		  										return data;
		  								}
		  							}

	                      ]
	                     });
	                     
	}
	function getCustomerList(){
		tableContact = $('#contactTable')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "getSingleCustomerDetails?contactTypeId="+contactTypeId,
	                 "width" : "100%",

	                 "bAutoWidth" : false,
	                 "scrollCollapse" : true,
	                 "bScrollCollapse" : true,
	                 "iDisplayLength" : 10,
	                 "fixedHeader" : {
	                     "header" : true
	                 },
	                 "paging" : true ,
	                 "sPaginationType" : "simple",
	                 dom : 'Bfrtip',
	                // "processing" : true,

	                 'columnDefs' : [
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 0,
	                         'data' : "contactId",
	                         "defaultContent" : "",
	                         
	                       },
	                       	 {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 1,
	  	                         'data' : "companyName",
	  	                         "defaultContent" : "",
	  	                        
	  	                         
	  	                       },
	  	                     {

	  								'targets' : 2,
	  								 "width": "20%",
	  								"defaultContent" : "",
	  								className : "",
	  								orderable: false,
	  								"render" : function(data,
	  										type, full, row) {
	  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square contactEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>'
	  										return data;
	  								}
	  							}

	  	                       
	                      ]
	                     });

	    
	}
//-------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------LOAD AND PUT CONTACT TYPES TO RADIO BUTTON----------------------------------------
	
	$.ajax({
	    async: false,
	    url : "contactTypes",
	    success:function(json) {
	        $.each( json.data, function( data ) {
	        	console.log("in");
	        	console.log(this.contactTypeId);
	        	 if(this.contactType == 'customer'){
	                 $("#radio_5").val(this.contactTypeId);
	                 x = this.contactTypeId;
	                console.log("data put");
	             }
	             else if(this.contactType == 'vendor'){
	                 $("#radio_6").val(this.contactTypeId);
	                 y = this.contactTypeId;
	                console.log("data put");
	                }
	        	 
	        });
	    },
	   error: function(){
	  	console.log('unable to load data');
	   }
	    });
	
//-------------------------------------------------END OF RADIO BUTTON------------------------------------------------------------

	$('#contactTable ').on("click",".contactEdit",function(){
		 $('#newContactForm').show();
		 $('#contactDetailsForm').hide();
		var data = tableContact.row($(this).parents('tr')).data();
 		console.log("ID to edit =  "+data.contactId);
 		contactId=data.contactId;
	
 			$.ajax({
 		    async: false,
 		    url : "getContactDetails?contactId="+contactId,
 		    success:function(json) {
 		        $.each( json.data, function( data ) {
 		         $('#customerName').val(this.companyName);
 	 		     $('#gstNumber').val(this.gstIdentificationNumber);
 		   		 $('#contactName').val(this.contactName);
 		   		 $('#emailId').val(this.email);
 		   		 $('#workPhone').val(this.landNumber);
 		   		 $('#mobileNumber').val(this.mobileNumber);
 		   		 
 		   	 if(x == this.contactTypeId){
 				$("#radio_5").prop("checked",true);
 				}
 			    else if(y == this.contactTypeId ){
 				$("#radio_6").prop("checked",true);
 				}
 		 
 		 contactTypeId = $("input[name='group1']:checked"). val();
 		 routeId=$('#routeNew option:selected').val();
 		   		 $('#contactNumber').val(this.contactNumber);
 		   	     $('#floorBuilding').val(this.building);
 		   		 $('#locality').val(this.locality);
 		   		 $('#landMark').val(this.landmark);
 		   		 $('#cityDistrict').val(this.city);
 		   		 $('#state').val(this.state);
 		   		 $('#zipCode').val(this.zipcode);
 		   	    // $("#routeNew").val(this. shipmentRouteId).trigger('change');
 		   	   // $("#routeNew").val(this.shipmentRouteId);
 		   		//$('#routeNew').val(this.shipmentRouteId).attr("selected", "selected");
 		   		//$("#route").val(this.routeId).trigger('change');
              //  console.log("routeId"+this.routeId);
                $("#routeNew").val(this.shipmentRouteId).trigger('change');
 		   		 console.log("shipmentRouteId"+this.shipmentRouteId);
 		   		 
 		   		//$("input[type='radio']").click(function(){
 		   		//var contactTypeId = $("input[name='group1']:checked").val();
 		   		
 		   		
 		        });
 		         
 		    }
 		});
  });
	//-----------------------------------------------------new edit---------------------------------------------------------------------//
	
        custId = location.search.split('contactId=')[1];
		window.history.replaceState({}, document.title, "/" + "#");
		console.log("contact id="+custId);
		if(custId > 0 && custId !=null){
		IdInt = $.trim(parseInt(custId));
		$('label[for="contactId"]').css("display","inline-block");
		$("contactId").css("display","inline-block");
		$("contactId").val(IdInt);
		$("contactId").prop('readonly',true);
		getcust();
		   }
		function getcust(){
		var j= $("#contactId").val();
		$.ajax({
		async: false,
		url:"getContactDetails?contactId="+IdInt,
		success : function(json){
		$.each(json.data, function( data ){

		$("#contactName").val(this.contactName);
		console.log(this.contactName);
	    $("#customerName").val(this.companyName);
	    console.log(this.companyName);
		$("#emailId").val(this.email);
		 console.log(this.email);
		$("#locality").val(this.locality);
		 console.log(this.locality);
		$("#mobileNumber").val(this.mobileNumber);
		 console.log(this.mobileNumber);
		$("#cityDistrict").val(this.city);
		 console.log(this.city);
		$("#state").val(this.state);
		 console.log(this.state);
	    $("#contactNumber").val(this.contactNumber);
	    console.log(this.contactNumber);
		$("#zipCode").val(this.zipcode);
		 console.log(this.zipcode);
		$("#landMark").val(this.landmark);
		 console.log(this.landmark);
		$("#floorBuilding").val(this.building);
		 console.log(this.building);
        $("#workPhone").val(this.landNumber);
        console.log(this.landNumber);
		$("#gstNumber").val(this.gstIdentificationNumber);
		 console.log(this.gstIdentificationNumber);
		         if(x == this.contactTypeId){
				$("#radio_5").prop("checked",true);
				}
			    else if(y == this.contactTypeId ){
				$("#radio_6").prop("checked",true);
				}
		 
		 contactTypeId = $("input[name='group1']:checked"). val();
		 routeId=$('#routeNew option:selected').val();
			
		route=$('#routeNew option:selected').text();
		$("#routeNew").val(this.routeId).trigger('change');
		
		 console.log(this.shipmentRouteId);
		});
		}
		});
		}
		//--------------------------------------------new edit----------------------------------------------------------------//
		
	
			//---------------------------------------------------------------------------------------------------------//
			$('#customerTable').on('click','.customerEdit',function(){
				var data =tableCust.row($(this).parents('tr')).data();
				console.log("ID to edit = "+data.contactId);
				contactId=data.contactId;
				window.location.href ="/contacts?contactId="+contactId;
			});
			//------------------------------------------------------------------------------------------------//
			
			
			$('#adminTable').on('click','.vendorEdit',function(){
				var data =tablevend.row($(this).parents('tr')).data();
				console.log("ID to edit = "+data.contactId);
				contactId=data.contactId;
				window.location.href ="/contacts?contactId="+contactId;
			});
		
			
		//----------------------------------------get customer--------------------------------------------------------//
		
			 var tableCust = $('#customerTable')
		     .DataTable(
		             {
		            	 dom : 'Bfrtip',	 
		            	 "paging" : true ,
		             });
			 
			 tableCust = $('#customerTable') 
			  .DataTable(
		             {
		            	 "destroy": true,
		            	 "ajax" : "getcust",
		            	 "paging" : true ,
		            	   dom : 'Bfrtip',
		            	/* "width" : "100%",
                         "bAutoWidth" : false,
		                 "scrollCollapse" : true,
		                 "bScrollCollapse" : true,
		                 "iDisplayLength" : 10,
		                 "fixedHeader" : {
		                     "header" : true
		                 },
		                 "paging" : true ,
		                 "sPaginationType" : "simple",
		                  dom : 'Bfrtip',*/
		                 //"processing" : true,

		                 'columnDefs' : [
		                     
		                     {
		                         'searchable' : false,
		                         'orderable' : false,
		                         'targets' : 0,
		                         'data' : "contactId",
		                         "defaultContent" : "",
		                         
		                       },
		                          {
			  	                         'searchable' : false,
			  	                         'orderable' : false,
			  	                         'targets' : 1,
			  	                         'data' : "companyName",
			  	                         "defaultContent" : "",
			  	                         
			  	                       },
			  	                     {
				  	                         'searchable' : false,
				  	                         'orderable' : false,
				  	                         'targets' : 2,
				  	                         'data' : "contactName",
				  	                         "defaultContent" : "",
				  	                         
				  	                       },
				  	                     {
					  	                         'searchable' : false,
					  	                         'orderable' : false,
					  	                         'targets' : 3,
					  	                         'data' : "mobileNumber",
					  	                         "defaultContent" : "",
					  	                         
					  	                       },
					  	                     {
						  	                         'searchable' : false,
						  	                         'orderable' : false,
						  	                         'targets' : 4,
						  	                         'data' : "email",
						  	                         "defaultContent" : "",
						  	                         
						  	                       },
						  	                   {
							  	                         'searchable' : false,
							  	                         'orderable' : false,
							  	                         'targets' : 5,
							  	                         'data' : "Address",
							  	                         "defaultContent" : "",
							  	                         "render" : function(data, type,row,meta ){
							  	                        	 return row.building +'<br>'+row.locality +'<br>'+row.city+'<br>'+row.state;
							  	                         }
						  	                       
							  	                         
							  	                       },
			  	                     {

			  								'targets' : 6,
			  								 "width": "20%",
			  								"defaultContent" : "",
			  								className : "",
			  								orderable: false,
			  								"render" : function(data,type,full,row) {
			  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square customerEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-trash customerdelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButtonId"></i>'
			  										return data;
			  								}
			  							}

		                      ]
		                     });
	//----------------------------------------------get vendor---------------------------------------------------------//
			 var tablevend = $('#adminTable')
		     .DataTable(
		             {
		            	 "destroy": true,
		            	 "ajax" : "getvend",
		                 "width" : "100%",

		                 "bAutoWidth" : false,
		                 "scrollCollapse" : true,
		                 "bScrollCollapse" : true,
		                 "iDisplayLength" : 10,
		                 "fixedHeader" : {
		                     "header" : true
		                 },
		                 "paging" : true ,
		                 "sPaginationType" : "simple",
		                  dom : 'Bfrtip',
		                 //"processing" : true,

		                 'columnDefs' : [
		                     
		                     {
		                         'searchable' : false,
		                         'orderable' : false,
		                         'targets' : 0,
		                         'data' : "contactId",
		                         "defaultContent" : "",
		                         
		                       },
		                          {
			  	                         'searchable' : false,
			  	                         'orderable' : false,
			  	                         'targets' : 1,
			  	                         'data' : "companyName",
			  	                         "defaultContent" : "",
			  	                         
			  	                       },
			  	                     {
				  	                         'searchable' : false,
				  	                         'orderable' : false,
				  	                         'targets' : 2,
				  	                         'data' : "contactName",
				  	                         "defaultContent" : "",
				  	                         
				  	                       },
				  	                     {
					  	                         'searchable' : false,
					  	                         'orderable' : false,
					  	                         'targets' : 3,
					  	                         'data' : "mobileNumber",
					  	                         "defaultContent" : "",
					  	                         
					  	                       },
					  	                     {
						  	                         'searchable' : false,
						  	                         'orderable' : false,
						  	                         'targets' : 4,
						  	                         'data' : "email",
						  	                         "defaultContent" : "",
						  	                         
						  	                       },
						  	                     {
							  	                         'searchable' : false,
							  	                         'orderable' : false,
							  	                         'targets' : 5,
							  	                         'data' : "Address",
							  	                       "defaultContent" : "",
							  	                         
							  	                        	"render" : function(data,type,row,meta){
								  	                        	 return row.building +'<br>'+row.locality +'<br>'+row.city+'<br>'+row.state;
								  	                         }
							  	                        
							  	                       },
			  	                     {

			  								'targets' : 6,
			  								 "width": "20%",
			  								"defaultContent" : "",
			  								className : "",
			  								orderable: false,
			  								"render" : function(data,type,full,row) {
			  										//data = '&nbsp;&nbsp;<i class="fa fa-pencil-square vendorEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-trash vendordelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButtonId"></i>'
			  											data = '&nbsp;&nbsp;<i class="fa fa-pencil-square vendorEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-trash vendordelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButId"></i>'
			  											return data;
			  								}
			  							}

		                      ]
		                     });
		
  
	
//--------------------------------------------------------------------------------------------------------------------
	 $('#contactTable ').on("click","tr td:not(:last-child)",function(){
		 $('#newContactForm').hide();
		 $('#contactDetailsForm').show();
	});
	 
	 //--------------------------------------------------------------------------------------//
	
	
//---------------------------------------------------VALIDATION---------------------------------------------------------------------
	/*
	 * Email validation
	 */
	
	function filterEmail(email) {
        var regex = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
        return regex.test(email);
    }
	$('#emailId').focus(function(){
		console.log('in');
	}).blur(function(){
		email = $('#emailId').val();
		if($.trim(email).length == 0){
			console.log("no email");
		}else{
			
			if(filterEmail(email)){
				console.log("ok");
			}else{
				 $.dialog({
                     icon : 'fa fa-exclamation-circle',
                     title: 'Warning!',
                    content: 'Enter valid Email ID',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#emailId').focus();
                    }
                });
			}
		}
	});
//-------------------------------------------------------------------------------------------------------------------------------
	/*
	 * work phone and mobile number validation
	 *
	 */
	function filterMobileNumber(mobileNumber) {
        var regex = new RegExp(/^[0][1-9]\d{9}$|^[1-9]\d{9}$/g);
        return regex.test(mobileNumber);
    }
	function filterWorkPhone(workPhone) {
        var regex = new RegExp(/^\d{11}$/g);
        return regex.test(workPhone);
    }
	$("#mobileNumber").focus(function(){
		
	}).blur(function(){
		mobileNumber = $("#mobileNumber").val();
		if($.trim(mobileNumber) == 0){
			console.log("empty");
		}else{
			if(filterMobileNumber(mobileNumber)){
				console.log("ok");
			}else{
				 $.dialog({
                     icon : 'fa fa-exclamation-circle',
                     title: 'Warning!',
                    content: 'Enter valid Mobile Number',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#mobileNumber').focus();
                    }
                });
			}
		}
	});
$("#contactNumber").focus(function(){
		
	}).blur(function(){
		adrsMobileNumber = $("#contactNumber").val();
		if($.trim(adrsMobileNumber) == 0){
			console.log("empty");
		}else{
			if(filterMobileNumber(adrsMobileNumber)){
				console.log("ok");
			}else{
				 $.dialog({
                     icon : 'fa fa-exclamation-circle',
                     title: 'Warning!',
                    content: 'Enter valid Mobile Number',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#contactNumber').focus();
                    }
                });
			}
		}
	});
	$("#workPhone").focus(function(){
		
	}).blur(function(){
		workPhone = $("#workPhone").val();
		if($.trim(workPhone) == 0){
			console.log("empty");
		}else{
			if(filterWorkPhone(workPhone)){
				console.log("ok");
			}else{
				 $.dialog({
                     icon : 'fa fa-exclamation-circle',
                     title: 'Warning!',
                    content: 'Enter valid Work Phone',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#workPhone').focus();
                    }
                });
			}
		}
		
	});
//---------------------------------------------------------------------------------------------------------------------------------
	/*
	 * validate zip code
	 */
	function filterZipCode(zipCode) {
        var regex = new RegExp(/^\d{6}$/g);
        return regex.test(zipCode);
    }
	$("#zipCode").focus(function(){
		
	}).blur(function(){
		var zipCode = $("#zipCode").val();
		if($.trim(zipCode) == 0){
			console.log("empty");
		}else{
			if(filterZipCode(zipCode)){
				console.log("ok");
			}else{
				 $.dialog({
                    icon : 'fa fa-exclamation-circle',
                    title: 'Warning!',
                    content: 'Enter valid Zip Code',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#zipCode').focus();
                    }
                });
			}
		}
	});
//---------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------FILL ALL FIELDS--------------------------------------------------------------------
	function displayMessage(){
		$.dialog({
            icon : 'fa fa-exclamation-circle',
            title: 'Warning!',
            content: 'Please fill all mandatory fields',
            boxWidth: '30%',
            useBootstrap: false,
       });
	}
	function checkMandatoryFields(){
		customerName=$('#customerName').val();
		console.log(customerName);
		gstIdentificationNumber=$('#gstNumber').val();
		console.log(gstIdentificationNumber);
		contactName = $('#contactName').val();
		console.log(contactName);
		email = $('#emailId').val();
		console.log(email);
		workPhone = $('#workPhone').val();
		mobileNumber = $('#mobileNumber').val();
		contactTypeId = $("input[name='group1']:checked").val();
		console.log('contactTypeId '+contactTypeId);
		adrsMobileNumber = $('#contactNumber').val();
		floorBuilding  = $('#floorBuilding').val();
		locality = $('#locality').val();
		landMark = $('#landMark').val();
		cityDistrict = $('#cityDistrict').val();
		state = $('#state').val();
		zipCode = $('#zipCode').val();
		routeId = $('#routeNew').find(":selected").val();
		if(customerName == ''){
				document.body.scrollTop = 0;
			  	document.documentElement.scrollTop = 0;
			  	$('#customerName').focus();
			  	displayMessage();
		}else if(contactName == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#contactName').focus();
		  	displayMessage();
				
		
		}else if(gstIdentificationNumber == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#gstNumber').focus();
		  	displayMessage();
			
		}else if(email == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#emailId').focus();
		  	displayMessage();
		}else if(mobileNumber == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#mobileNumber').focus();
		  	displayMessage();
		}else if(contactTypeId == '' || contactTypeId == undefined){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$.dialog({
		  		icon : 'fa fa-exclamation-circle',
		  		title: 'Warning!',
		  		content: 'Please select contact type',
		  		boxWidth: '30%',
		  		useBootstrap: false,
		  	});
		}else if(floorBuilding == ''){
			$('#floorBuilding').focus();
			displayMessage();
		}else if(locality == ''){
			$('#locality').focus();
			displayMessage();
		}else if(cityDistrict == ''){
			$('#cityDistrict').focus();
			displayMessage();
		}else if(zipCode == ''){
			$('#zipCode').focus();
			displayMessage();
		}else if(state == ''){
			$('#state').focus();
			displayMessage();
		}else if(routeId == '0'){
			$.dialog({
		  		icon : 'fa fa-exclamation-circle',
		  		title: 'Warning!',
		  		content: 'Please select route',
		  		boxWidth: '30%',
		  		useBootstrap: false,
		  	});
		}
		else if(adrsMobileNumber == ''){
			$('#contactNumber').focus();
			displayMessage();
		}
		else{
			if(landMark == ''){
				landMark == null;
			}
			if(workPhone == ''){
				workPhone == null;
			}
			addressArray.push({
				addressId : 0,
				buildingNo : floorBuilding,
				locality : locality,
				landmark : landMark,
				district : cityDistrict,
	            zipCode : zipCode,
	            state : state,
	            routeId : routeId,
	            contactNumber : adrsMobileNumber
	            });
			console.log('data ok'+landMark);
			
			console.log("adrs to store "+JSON.stringify(addressArray));
			flag = true;
		}
	}
		
//---------------------------------------------END FILL---------------------------------------------------------------------------
	$('#contactSubmitButton').click(function(){
		checkMandatoryFields();
		alert(contactTypeId);
		if(flag){
			var addressList=encodeURIComponent(JSON.stringify(addressArray));
			if(custId>0){
				contactId=custId;
				}else{
				contactId=0;
				}
			$.ajax({
	              async: false,
	              type : "POST",
	              url: "contactOperations?contactId="+contactId+"&contactTypeId="+contactTypeId+"&contactName="+contactName+"&companyName="+customerName+"&email="+email+"&gstIdentificationNumber="+gstIdentificationNumber+"&mobileNumber="+mobileNumber+"&landNumber="+workPhone+"&activeStatus=Y&addressDetails="+addressList,
	              success: function(json){
	                  if(json.status == 'SUCCESS'){
	                	  $.alert({
	                		    icon: 'fa fa-check-circle-o',
	                		    title: 'Success!',
	                		    content: 'New contact added',
	                		    onClose: function(){
	                		    	window.location.href="/contacts";
	                		    }
	                		});
	                	  
	                  }
	                  else{
	                	  $.alert({
	                		    icon: 'fa fa-times-circle-o',
	                		    title: 'Error!',
	                		    content: 'Try again later',
	                		    onClose: function(){
	                		    	window.location.href="/contacts";
	                		    }
	                		});
	                  }
	              },
	              error: function(){
	            	  $.alert({
              		    icon: 'fa fa-times-circle-o',
              		    title: 'Error!',
              		    content: 'Try again later',
              		    onClose: function(){
              		    	window.location.href="/newContact";
              		    }
              		});
	              }
	            });
		}else{
			console.log("Please fill all fields in else");
		}
	});
	//-----------------------------------------------------------------------------------------------------------------------//
	/*$('#adminTable').on('click', '.vendordelete', function() {
		var data = tablevend.row($(this).parents('tr')).data();
		console.log("ID to delete =  "+data.contactId); */
	
//--------------------------------------------------- vendor delete button---------------------------------//	
	$('#adminTable').on('click', '.vendordelete', function() {
		var data = tablevend.row($(this).parents('tr')).data();
		console.log("ID to delete =  "+data.contactId);
	
	    contactId = data.contactId;
		companyName = data.companyName;
		contactName = data.contactName;
		contactNumber = data.contactNumber;
		email = data.email;
		buildingNo = data.buildingNo;
		locality = data.locality;
		landmark = data.landmark;
		city = data.city;
		state = data.state;
		zipcode = data.zipcode;
		shipmentRouteId = data.shipmentRouteId ;
		mobileNumber = data.mobileNumber;
		
		$.confirm({
			icon: 'fa fa-question-circle',
		    title: 'Confirm!',
		    content: 'Are you sure?',
		    boxWidth: '30%',
		    useBootstrap: false,
		    buttons: {
		        confirm: function () {
		        	activeStatus = 'N';
					 $.ajax({
						 async: false,
						 type : "POST",
						 //url: "accountOperations?accountId="+accountId+"&activeStateIndicator=N", 
						  url: "contactOperations?contactId="+contactId+"&activeStatus="+activeStatus, 
					       success: function(json){
								if(json.status == 'SUCCESS'){
								    $.alert({
										    	escapeKey: true, // close the modal when escape is pressed.
							                	backgroundDismiss: true,
										        icon : 'fa fa-smile-o',
										    	title: 'Success!',
										        content: 'contact deleted!',
										        boxWidth: '30%',
											    useBootstrap: false,
											    	onClose: function () {
									    				window.location.href="/contactsList";
									    						  }
								    });
								   
									
							  }	
					      }
					 
					 });
		        }
		    }
		});
	});

 
	//------------------------------------------------------delete customer button-----------------------------------------//
	$('#customerTable').on('click', '.customerdelete', function() {
		var data = tableCust.row($(this).parents('tr')).data();
		console.log("ID to delete =  "+data.contactId);
	//------------------------------------------------------------------------------------//	
		contactId = data.contactId;
		
		companyName = data.companyName;
		contactName = data.contactName;
		contactNumber = data.contactNumber;
		email = data.email;
		buildingNo = data.buildingNo;
		locality = data.locality;
		landmark = data.landmark;
		city = data.city;
		state = data.state;
		zipcode = data.zipcode;
		shipmentRouteId = data.shipmentRouteId ;
		mobileNumber = data.mobileNumber;
		
		$.confirm({
			icon: 'fa fa-question-circle',
		    title: 'Confirm!',
		    content: 'Are you sure?',
		    boxWidth: '30%',
		    useBootstrap: false,
		    buttons: {
		        confirm: function () {
		        	activeStatus = 'N';
					 $.ajax({
						 async: false,
						 type : "POST",
						 //url: "accountOperations?accountId="+accountId+"&activeStateIndicator=N", 
						  url: "contactOperations?contactId="+contactId+"&activeStatus="+activeStatus, 
					       success: function(json){
								if(json.status == 'SUCCESS'){
								    $.alert({
										    	escapeKey: true, // close the modal when escape is pressed.
							                	backgroundDismiss: true,
										        icon : 'fa fa-smile-o',
										    	title: 'Success!',
										        content: 'contact deleted!',
										        boxWidth: '30%',
											    useBootstrap: false,
											    	onClose: function () {
									    				window.location.href="/contactsList";
									    						  }
								    });
								   
									
							  }	
					      }
					 
					 });
		        }
		    }
		});
	});
	//-----------------------------------------------------------------------------------------------------------------------//
	
	

	//--------------------------------------------------------vendor delete------------------------------------//
		
		
	
	});