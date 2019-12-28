$(document).ready(function(){
	console.log("doc ready");
	var accountId;
	var bankName;
	var branchName;
	var accountNo;
	var accountHolderName;
	var accountType;
	var ifsc;
	var upiId;
	var createUserId;
	var activeStateIndicator;
	
	//---------------------------------------------------------------------------------------------------------------//
	
	function displayMessage(){
        
        alert("please fill mandatory fields");
        }
   function checkMandatoryField(){
	   bankName =$('#bankName').val();
	   console.log(bankName);
	   branchName=$('#branchName').val();
	   console.log( branchName);
	   accountNo=$('#acNumber').val();
	   console.log(accountNo);
	   accountHolderName=$('#acHolderName').val();
	   console.log(accountHolderName);
	   accountType=$('#actyoe').val();
	   console.log(accountType);
	   ifsc=$('#ifscNumber').val();
	   console.log(ifsc);
	   upiId=$('#upiId').val();
	   console.log(upiId);
	   
	   
	   
   }
   //-------------------------------edit--------------------------------------------------------------//
   
   $('#accountTable').on('click','.accountEdit',function()
			{
	   $('#newaccountForm').show();
			var data =tableaccounts.row($(this).parents('tr')).data();
			console.log("ID to edit = "+data.accountId);
			accountId=data.accountId;
			
		
	$.ajax({
	async: false,
	url:"geteditaccount?accountId="+accountId,
	success : function(json){
	$.each(json.data, function( data ){
	
	$("#bankName").val(this.bankName);
	console.log(this.bankName);
    $("#branchName").val(this.branchName);
	console.log(this.branchName);
	$("#acNumber").val(this.accountNo);
	console.log(this.accountNo);
	$("#acHolderName").val(this.accountHolderName);
	console.log(this.accountHolderName);
	$("#actyoe").val(this.accountType);
	console.log(this.accountType);
	$("#ifscNumber").val(this.ifsc);
	console.log(this.ifsc);
	$("#upiId").val(this.upiId);
	console.log(this.upiId);
	
	});
	}

	});
	});
   //-------------------------------------------------------------------------------------------------------//
   
   
   
   
   tableaccounts = $('#accountTable')
   .DataTable(
           {
          	 "destroy": true,
          	 "ajax" : "getaccountdetails",
               "width" : "100%",

               "bAutoWidth" : false,
               "scrollCollapse" : true,
               "bScrollCollapse" : true,
               "iDisplayLength" : 8,
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
	  	                         'data' : "accountId",
	  	                         "defaultContent" : "",
	  	                          'visible' : true,
	  	                         
	  	                  },
	  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 1,
	  	                         'data' : "bankName",
	  	                         "defaultContent" : "",
	  	                       'visible' : true,
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 2,
	  	                         'data' : "branchName",
	  	                         "defaultContent" : "",
	  	                       'visible' : false,
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 3,
	  	                         'data' : "accountNo",
	  	                         "defaultContent" : "",
	  	                       'visible' : true,
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 4,
	  	                         'data' : "accountHolderName",
	  	                         "defaultContent" : "",
	  	                       'visible' : true,
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 5,
	  	                         'data' : "accountType",
	  	                         "defaultContent" : "",
	  	                       'visible' : true, 
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 6,
	  	                         'data' : "ifsc",
	  	                         "defaultContent" : "",
	  	                       'visible' : false,
	  	                         
	  	                  },
		  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 7,
	  	                         'data' : "upiId",
	  	                         "defaultContent" : "",
	  	                       'visible' : false, 
	  	                         
	  	                  },
	  	                {

 							'targets' : 8,
 							"defaultContent" : "",
 							className : "",
 							orderable: false,
 							"render" : function(data,
 									type, full, row) {
 									data = '&nbsp;&nbsp;<i class="fa fa-pencil accountEdit" style="cursor:pointer;color:red;font-size:16px" id="EditButttonId"></i>&nbsp;&nbsp;<i class="fa fa-trash accountdelete" style="cursor:pointer;color:red;font-size:16px" id="deleteButttonId"></i>'
 									return data;
 							}
 						},
                    ]
                   });
	
	//---------------------------------------------------------------------------------------------------------------------------------//
	
	$('#bankSubmitButton').click(function(){
		checkMandatoryField();
		
		 if(accountId>0){
				accountId=accountId;
				}else{
				accountId=0;
				}
		$.ajax({
		       async: false,
		       type : "Post",    
		      url: "accountOperations?accountId="+accountId+"&bankName="+bankName+"&branchName="+branchName+"&accountNo="+accountNo+"&accountHolderName="+accountHolderName+"&accountType="+accountType+"&ifsc="+ifsc+"&activeStateIndicator=Y&upiId="+upiId,
		    	
		    success : function(json)
		    		{
		           if(json.status == 'SUCCESS')
		           {
		         	alert("SUCCESS");
		         	}
		           else{
		           	alert("FAILED");

		           }
		          
		       }
		});
		});
	
//---------------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------Delete---------------------------------------------------------------------//
	
	$('#accountTable').on('click', '.accountdelete', function() {//DeleteButtonId - accountdelete
		var data = tableaccounts.row($(this).parents('tr')).data();
		console.log("ID to delete =  "+data.accountId);
		
		accountId = data.accountId;
		bankName = data.bankName;//  bankName - from model name
		branchName = data.branchName;
		accountNo = data.accountNo;
		accountHolderName = data.accountHolderName;
		accountType = data.accountType;
		ifsc = data.ifsc;
		upiId = data.upiId;
		
		$.confirm({
			icon: 'fa fa-question-circle',
		    title: 'Confirm!',
		    content: 'Are you sure?',
		    boxWidth: '30%',
		    useBootstrap: false,
		    buttons: {
		        confirm: function () {
		        	activeStateIndicator = 'N';
					 $.ajax({
						 async: false,
						 type : "POST",
						 // accountOperations - account controller name, insert   code
						  url: "accountOperations?accountId="+accountId+"&activeStateIndicator="+activeStateIndicator, 
					       success: function(json){
								if(json.status == 'SUCCESS'){
								    $.alert({
										    	escapeKey: true, // close the modal when escape is pressed.
							                	backgroundDismiss: true,
										        icon : 'fa fa-smile-o',
										    	title: 'Success!',
										        content: 'Account deleted!',
										        boxWidth: '30%',
											    useBootstrap: false,
											    	onClose: function () {
									    				window.location.href="/accountMaster";//from webpage controller
									    						  }
								    });
								   
									
							  }	
					      }
					 
					 });
		        }
		    }
		});
	});

});

	   