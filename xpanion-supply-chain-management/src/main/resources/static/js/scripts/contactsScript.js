/**
 * @author : ASHLIN ABRAHAM
 * @date : 12.04.2019
 * 
 */
getRoutes();
getcontactTypes();
	function getRoutes(){
	var jsonURL="getRoutes";
		$.getJSON(jsonURL, function(json) {
		$.each(json.data, function(data) {   
		    $('#routeNew').append($("<option></option>").attr("value",this.routeId).text(this.route));
		    $('#route').append($("<option></option>").attr("value",this.routeId).text(this.route));
		});
		});
}
	
 //---------------------------------------------------------------------------------------------------------------
	
$ (document).ready(function(){
	
	$('#contactDetailsForm').hide();
	$('#addressForm').hide();
	var type;
	var tableId;
	var vendorList = [];
	var customerList = [];
	var contactTypeId;
	var flag = false;
	var vendors;
	var addressArray = [];
	var buildingNo;
	var landMark;
	var district;
	var state;
	var locality;
	var zipCode;
	var routeId;
	var contactNumber;
	var addressId;
	var contactId;
	var verifyFlag = false;
	var tableContact;
	var line;
	
//--------------------------------------------------------------------------------------------------------------------
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
		  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square contactEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-eye contactView" style="cursor:pointer;color:black;font-size:14px" title="View"></i>'
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
	  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square contactEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-eye contactView" style="cursor:pointer;color:black;font-size:14px" title="View"></i>'
	  										return data;
	  								}
	  							}

	  	                       
	                      ]
	                     });

	    
	}
//-------------------------------------------------------------------------------------------------------------------------------
	
	 $('#contactTable ').on("click",".contactEdit",function(){
		
		var data = tableContact.row($(this).parents('tr')).data();
 		console.log("ID to edit =  "+data.contactId);
 	    $('#newContactForm').show();
  });
//--------------------------------------------------------------------------------------------------------------------
	 $('#contactTable ').on("click","tr td:not(:last-child)",function(){
		 $( "#newAddressDiv" ).empty();
		 var data = tableContact.row($(this).parents('tr')).data();
		 type = data.contactType;
		 if(type == 'customer'){
			 newAddressIcon(); 
			 $('.deleteAddress').show();
			  
		 }else{
			 $('.deleteAddress').hide();
		 }
		 $('#contactTable td').css('background', '');
		 $(this).parent().children().css('background', '#CCCCCC');
		 contactId = $(this).parent("tr").find("td:first").text();
		 
         var adrs;
         //$("#addressTable tr").remove();
         reloadData();
    });
//--------------------------------------------------------------------------------------------------------------------
	 $('#newContact').click(function(){
		 $('#newContactForm').show();
         $('#contactDetailsForm').hide();
	 });
//--------------------------------------------------------------------------------------------------------------------
	function newAddressIcon(){
		 var content = "<div class='col-md-4' ><table border='1' id='newAddress' name='0' style='background-color:#EEEEEE' border-style: dashed width='250'>"
			 for(i=0; i<1; i++){
			     content += '<tr><td style="height:250px"><div class="text-center">' + '<i class="fa fa-plus addNewAddress" aria-hidden="true" style="cursor:pointer;font-size:30px" id="newAddressId"><br>Add Address</i>'+ '</div></td></tr>';
			 }
			 content += "</table></div>"

			 $('#newAddressDiv').append(content);
			 $('.addNewAddress').click(function(){
				 $('#route').find('option').remove();
				 $('#routeNew').find('option').remove();
				 getRoutes();
				 	 $('#addressForm input[type="text"]').val('');
					 addressId = 0;
					 $('#newAddressDiv').hide();
					 $('#addressForm').show();
				});
	}
	
//------------------------------------------------------------------------------------------------------------------------
		
//----------------------------------------------------------------------------------------------------------------------
		
		
//---------------------------------------------------------------------------------------------------------------------
	function editAddress(addressId){
		 $('#newAddressDiv').hide();
		 $('#addressForm').show();
		 //console.log("array to edit "+JSON.stringify(addressArray));
		 $.each(addressArray, function(key,value) {
             if(this.addressId == addressId){
            	 console.log("same");
            	 $('#editfloorBuilding').val(this.buildingNo);
         		 $('#editlocality').val(this.locality);
         		 $('#editlandMark').val(this.landmark);
         		 $('#editcityDistrict').val(this.district);
         		 $('#editstate').val(this.state);
         		 $('#editzipCode').val(this.zipCode);
         		 $('#editcontactNumber').val(this.contactNumber);
         		 $("#route").val(this.routeId).trigger('change');
         		
	 }
});
	}
	
//--------------------------------------------------------------------------------------------------------------------
	function saveAddress(){
		buildingNo = $('#editfloorBuilding').val();
		landMark = $('#editlandMark').val();
		district = $('#editcityDistrict').val();
		state =  $('#editstate').val();
		locality =  $('#editlocality').val();
		zipCode = $('#editzipCode').val();
		routeId = $('#route').find(":selected").val();
		//alert("id"+routeId);
		contactNumber = $('#editcontactNumber').val();
		if(!buildingNo){
			$('#editfloorBuilding').focus();
		  	displayMessage();
		}else if(!district){
			$('#editcityDistrict').focus();
		  	displayMessage();
		}else if(!state){
			$('#editstate').focus();
		  	displayMessage();
		}else if(!locality){
			$('#editlocality').focus();
		  	displayMessage();
		}else if(!zipCode){
			$('#editzipCode').focus();
		  	displayMessage();
		}else if(!routeId){
			$.dialog({
		        icon : 'fa fa-exclamation-circle',
		        title: 'Warning!',
		        content: 'Please Choose any route',
		        boxWidth: '30%',
		        useBootstrap: false,
		   });
		}else if(!contactNumber){
			$('#editcontactNumber').focus();
		  	displayMessage();
		}else{
			console.log("data ready");
			if(landMark == ''){
				landMark = null;
			}
			verifyFlag = true;
			addressArray = [];
			if(addressId > 0){
				addressId = addressId;
			}else{
				addressId = 0;
			}
			addressArray.push({
				
				addressId : addressId,
				buildingNo : buildingNo,
				locality : locality,
				landmark : landMark,
				district : district,
	            zipCode : zipCode,
	            state : state,
	            routeId : routeId,
	            contactNumber : contactNumber
	            });
		}
		
	}
//---------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------
	/*
	 * validate zip code
	 */
	function filterZipCode(zipCode) {
        var regex = new RegExp(/^\d{6}$/g);
        return regex.test(zipCode);
    }
	$("#editzipCode").focus(function(){
		
	}).blur(function(){
		var zipCode = $("#editzipCode").val();
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
                    	$('#editzipCode').focus();
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
$("#editcontactNumber").focus(function(){
		
	}).blur(function(){
		var mobileNumber = $("#editcontactNumber").val();
		if($.trim(mobileNumber) == 0){
			console.log("empty");
		}else{
			if(filterMobileNumber(mobileNumber)){
				console.log("ok");
			}else{
				 $.dialog({
                     icon : 'fa fa-exclamation-circle',
                     title: 'Warning!',
                    content: 'Enter valid Contact Number',
                    boxWidth: '30%',
                    useBootstrap: false,
                    onClose : function(){
                    	$('#editcontactNumber').focus();
                    }
                });
			}
		}
	});

//---------------------------------------------------------------------------------------------------------------------------------
function displayMessage(){
	$.dialog({
        icon : 'fa fa-exclamation-circle',
        title: 'Warning!',
        content: 'Please fill all mandatory fields',
        boxWidth: '30%',
        useBootstrap: false,
   });
}
//----------------------------------------------------------------------------------------------------------------------
$("#addressSubmitButton").click(function(){
	saveAddress();
	if(verifyFlag){
		var addressList=encodeURIComponent(JSON.stringify(addressArray));
		$.ajax({
            async: false,
            type : "POST",
            url: "contactOperations?contactId="+contactId+"&activeStatus=Y&addressDetails="+addressList,
            success: function(json){
                if(json.status == 'SUCCESS'){
              	  $.alert({
              		    icon: 'fa fa-check-circle-o',
              		    title: 'Success!',
              		    content: 'Address updated successfully',
              		    onClose: function(){
              		    	$( "#newAddressDiv" ).empty();
              		    	if(type == 'customer'){
              					 newAddressIcon(); 
              				 }
              		    	addressDetails();
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
        		    	window.location.href="/contacts";
        		    }
        		});
            }
          });
	}
});
//---------------------------------clear and refresh page on contact click----------------------------------------------
function reloadData(){
	 $('#newAddressDiv').show();
	 $('#addressForm').hide();
	 $('#addressForm input[type="text"]').val('');
	 $('.nav-tabs a[href="#activity"]').tab('show');
	// $('#route').find(":selected").text('---Choose Option---');
     $('#newContactForm').hide();
     $('#contactDetailsForm').show();
     addressDetails();
}

function addressDetails(){
	$('#newAddressDiv').show();
	 $('#addressForm').hide();
	 $.ajax({
         async: false,
         type : "GET",
         url: "getSingleCustomerAddressDetails?contactId="+contactId,
         	success: function(json){
         		addressArray = [];
         		
             	 $.each(json.data, function(data) { 
             		addressArray.push({
        				addressId : this.addressId,
        				buildingNo : this.buildingNo,
        				locality : this.locality,
        				landmark : this.landmark,
        				district : this.district,
        	            zipCode : this.zipCode,
        	            state : this.state,
        	            routeId : this.routeId,
        	            route : this.route,
        	            contactNumber :this.contactNumber
        	            });
             		
             	 adrs = "<div class='col-md-4' ><table border='1' id='addressTable' name='"+this.addressId+"'style='background-color:#EEEEEE' border-style= 'dashed' width='250'>"
            		 for(i=0; i<1; i++){
            			 adrs += '<tr><td style="height:250px"><div class="text-center"><font size="3"><label>'+this.buildingNo+'<br>'+this.locality+'<br>'+
            			 this.landmark+'<br>'+this.district+'&nbsp'+this.zipCode+'<br>'+this.state+'<br>Route : '+this.route+'<br>Phone Number : '+this.contactNumber+'</div></label></font></div>'
            			 +'<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-trash deleteAddress" aria-hidden="true" style="cursor:pointer;color:red;font-size:20px"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
            			 +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
            			 +'<i class="fa fa-pencil editAddress" aria-hidden="true" id="editAddressId" style="cursor:pointer;color:red;font-size:20px;margin:0px 70px;"></i></td></tr>';
            		 }
             	 		adrs += "</table></div>"
             	 			$('#newAddressDiv').append(adrs);
             	 		
             	 		if(type == 'customer'){ 
             				 $('.deleteAddress').show();
             				  
             			 }else{
             				 $('.deleteAddress').hide();
             			 }
             	 		
             	 });
             	console.log("address array "+JSON.stringify(addressArray));
             	$('#addressTable tr td').on('click', '.editAddress', function() {
     		    	addressId = $(this).closest('table').attr('name');
     		    	editAddress(addressId);
     		    });
             	$('#addressTable tr td').on('click', '.deleteAddress', function() {
     		    	addressId = $(this).closest('table').attr('name');
     		    	deleteAddress(addressId);
     		    });
              },
              error: function(){
            	  alert("error");
              }
              });

}
//---------------------------------------------------------------------------------------------------------------------
function deleteAddress(addressId){
	addressArray = [];
	addressArray.push({
		addressId : addressId,
		buildingNo : null,
		locality : null,
		landmark : null,
		district : null,
        zipCode : null,
        state : null,
        routeId : null,
        contactNumber : null
        });
	var addressList=encodeURIComponent(JSON.stringify(addressArray));
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
					 url: "contactOperations?contactId="+contactId+"&contactTypeId=0&activeStatus="+activeStatus+"&addressDetails="+addressList, 
				       success: function(json){
							if(json.status == 'SUCCESS'){
							    $.alert({
							        icon : 'fa fa-times-circle-o',
							    	title: 'Success!',
							        content: 'Address deleted!',
							        boxWidth: '30%',
								    useBootstrap: false,
								    onClose: function () {
								    	$( "#newAddressDiv" ).empty();
								    	if(type == 'customer'){
			              					 newAddressIcon(); 
			              				 }
								    	addressDetails();
								    }
							    });
							   
								
							}
							else{
								$.alert({
									icon : 'fa fa-times-circle-o',
									title: 'Failed!',
							        content: 'Error occured! Try again later.',
							        boxWidth: '30%',
								    useBootstrap: false,
								});
							}
						},
						error: function(){
							$.alert({
								icon : 'fa fa-times-circle-o',
								title: 'Failed!',
						        content: 'Error occured! Try again later.',
						        boxWidth: '30%',
							    useBootstrap: false,
						    });
						}
					  });
	        },
	        cancel: function () {
	        	console.log("cancel");
	        }

}
	});
}
});