
$(document).ready(function(){
	console.log("doc ready");
	var contactName;
	var contactId;
	var companyName;
	var mobileNumber;
	var email;
	var building;
	var locality;
	var city;
	var state;
	var gstIdentificationNumber;
	var landNumber;
	var contactAddressId;
	var shipmentRouteId;
	var landMark;
	var zipCode;
	var contactNumber;
	var cntactType;
	var x;
	var y;
	var phoneId;
	
	
	
	
	console.log("inside");
	
	
	   var tableContact = $('#phones')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "getphonedetails",
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
	                         'data' : "phoneId",
	                         "defaultContent" : "",
	                         
	                       },
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 1,
	                         'data' : "contactName",
	                         "defaultContent" : "",
	                         
	                       },
	                          {
		  	                         'searchable' : false,
		  	                         'orderable' : false,
		  	                         'targets' : 2,
		  	                         'data' : "mobileNumber",
		  	                         "defaultContent" : "",
		  	                         
		  	                       },
		  	                     {
			  	                         'searchable' : false,
			  	                         'orderable' : false,
			  	                         'targets' : 3,
			  	                         'data' : "email",
			  	                         "defaultContent" : "",
			  	                         
			  	                       },
		  	                     {

		  								'targets' : 4,
		  								 "width": "20%",
		  								"defaultContent" : "",
		  								className : "",
		  								orderable: false,
		  								"render" : function(data,type,full,row) {
		  										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square phoneEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-trash phonedelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButtonId"></i>'
		  										return data;
		  								}
		  							}

	                      ]
	                     });
	
	//------------------------------------------------------------------------------------------------------//
	   
	  
	//-----------------------------------------------------------------------------------------------------------------------------------//
	   
	   
	   //-----------------------------------------------------------------------------------------------//
	   
	
	  $('#phones').on('click','.phoneEdit',function(){
			$('#newcontact').show();
			 
			var data = tableContact.row($(this).parents('tr')).data();
	 	     console.log("ID to edit =  "+data.phoneId);
	 		phoneId=data.phoneId;
	 	
	   $.ajax({
	   async: false,
	   url:"getphoneedit?phoneId="+phoneId,
	   success : function(json){
	   $.each(json.data, function( data ){

	   $("#name").val(this.contactName);
	   console.log(this.contactName);

	   $("#mobileNumber").val(this.mobileNumber);
	   console.log(this.mobileNumber);

	   $("#email").val(this.email);
	   console.log(this.email);
	   });
		}

		});
		});
	   //----------------------------------------------------------//
	   
	   
	   //-----------------------------------------------------------------------------------------------------//
	   function displayMessage(){
	        
	        alert("please fill mandatory fields");
	        }
	   function checkMandatoryField(){
		   contactName=$('#name').val();
		   mobileNumber=$('#mobileNumber').val();
		   email=$('#email').val();
	   }

	   
	
	//----------------------------------------------------------------------------------------------//
	   $('#save').click(function(){
		   checkMandatoryField();
		   if(phoneId>0){
				phoneId=phoneId;
				}else{
				phoneId=0;
				}
		   $.ajax({
		       async: false,
		       type : "Post", 
	     url:"homeOperations?phoneId="+phoneId+"&contactName="+contactName+"&mobileNumber="+mobileNumber+"&activeStatus=Y&email="+email,
		       success : function(json){
		    	   if(json.status == 'SUCCESS'){
		                	  $.alert({
		                		    icon: 'fa fa-check-circle-o',
		                		    title: 'Success!',
		                		    content: ' new contact added',
		                		    onClose: function(){
		                		    	window.location.href="/phone";
		                		    }
		                		});
		                	  
		                  }
		       
		       
		                else{
		                	  $.alert({
		                		    icon: 'fa fa-times-circle-o',
		                		    title: 'Error!',
		                		    content: 'Try again later',
		                		    onClose: function(){
		                		    	window.location.href="/phone";
		                		    }
		                		});
		       }
		              },
		             /* error: function(){
		            	  $.alert({
	              		    icon: 'fa fa-times-circle-o',
	              		    title: 'Error!',
	              		    content: 'Try again later',
	              		    onClose: function(){
	              		    	window.location.href="/newContact";
	              		    }
	              		});
		              }*/
		   });  
		   	       
		
	                     
	

	   });
	   
	   //---------------------------------------------------------------------------------------------------------------//
	   $('#phones').on('click', '.phonedelete', function() {
			var data = tableContact.row($(this).parents('tr')).data();
			console.log("ID to delete =  "+data.phoneId);
			phoneId = data.phoneId;
			contactName = data.contactName;
			mobileNumber = data.mobileNumber;
			email = data.email;
	
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
							 url: "homeOperations?phoneId="+phoneId+"&activeStatus="+activeStatus, 
						       success: function(json){
									if(json.status == 'SUCCESS'){
									    $.alert({
									    	escapeKey: true, // close the modal when escape is pressed.
						                	backgroundDismiss: true,
									        icon : 'fa fa-smile-o',
									    	title: 'Success!',
									        content: 'phone deleted!',
									        boxWidth: '30%',
										    useBootstrap: false,
										    onClose: function () {
										    	 window.location.href="/phone";
										    }
									    });
									   
										
									}	
						       }
		
	});
			        }
			    }
			});
	    });
	  
		
		
		
		
		
		
		
		
	   
	   //-----------------------------------------------------------------------------------------------//
});