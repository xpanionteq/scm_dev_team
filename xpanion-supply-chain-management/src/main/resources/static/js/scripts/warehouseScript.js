
$ (document).ready(function(){

	
	var flag = false;
	var warehouseId;
	var warehousecode;
	var warehouseName;
	var warehouseAddress;
	var mobileNumber;
	var warehouseemail;
    var sectionId;
    var sectionName;
    var rackId;
    var rackName;
	var activeStatus;
	
	
	 var wareId;
	 var IdInt;
	 var c;
	var d;
	 
	 
	
	

	 	
	
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
		console.log("ID to edit =  "+warehouseId);
		
		warehousecode=$('#code').val();
		console.log(warehousecode);
		warehouseName=$('#firstName').val();
		console.log(warehouseName);
		warehouseAddress=$('#address').val();
		console.log(warehouseAddress);
		
		mobileNumber = $('#workPhone').val();
		console.log(mobileNumber);
		warehouseemail = $('#warehouseEmail').val();
		console.log(warehouseemail);
		
			flag = true;
		}
	
	
	
	//---------------------------------------------------------------------------------------------------------------//
	

	   wareId=location.search.split('warehouseId=')[1];
	  // window.history.replaceState({ },document.title,"/"+"#");
	   if(wareId>0 && wareId !=null){
	   IdInt=$.trim(parseInt(wareId));
	   
	   $("warehouseId").val(IdInt);
	   getsection();
	   }
        function getsection(){
        	
        var c =$("warehouseId").val();	
		console.log("ID warehouse =  "+IdInt);
	   	
        var d =$("sectionId").val();	
		console.log("ID section =  "+sectionId);
		
	    sectionName=$('#SectionName').val();
		console.log(sectionName);

	    rackName=$('#rackName').val();
	    console.log(rackName);
		
		flag = true;
		}
	
	

	
	//---------------------------------------------------VALIDATION---------------------------------------------------------------------
	/*
	 * Email validation
	 */
	
	function filterEmail(email) {
        var regex = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
        return regex.test(email);
    }
	$('#warehouseEmail').focus(function(){
		console.log('in');
	}).blur(function(){
		email = $('#warehouseEmail').val();
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
                    	$('#warehouesEmail').focus();
                    }
                });
			}
		}
	});
	
	
	
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
	$("#workPhone").focus(function(){
		
	}).blur(function(){
		mobileNumber = $("#workPhone").val();
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
                    	$('#workPhone').focus();
                    }
                });
			}
		}
	});

	//-------------------------------Warehouse detail table--------------------------------------------------------------------------------//
	
	
	
	var warehouseTable = $('#warehouseTable').DataTable({
		 dom : 'Bfrtip',
      "paging":  true,
      
  } );
	
          warehouseTable = $('#warehouseTable')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "warehouseitems",
	                "paging":true,
	                 
	                 dom : 'Bfrtip',
	                 'columnDefs' : [
	                	 
	                      {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 0,
	                         'data' : "warehouseId",
	                         "defaultContent" : "",
	                         visible:false
	                       },
	                	 
	                	 
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 1,
	                         'data' : "warehousecode",
	                         "defaultContent" : "",
	                         
	                       },
	                          {
	                             'targets' : 2,
	                             'data' : "warehouseName",
	  	                         "defaultContent" : "",
	                             
	                           },
	                           
	                           
		                   
	                           {

	                        	   'targets' : 3,
	                        	   "width": "20%",
	                        	   "defaultContent" : "",
	                        	   className : "",
	                        	   orderable: false,
	                        	   "render" : function(data,
	                        	   type, full, row) {
	                        	   data = '&nbsp;&nbsp;<i class="fa fa-pencil-square warehouseEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;'
	                        	   return data;
	                        	   }
	                        	   }
	                                  
	                      ]
	                     });
		 
                
          
	//--------------------------------------------section and rack table--------------------------------------------------------------------------------//
          

     	var sectionTable = $('#sectionTable').DataTable( {
      		 dom : 'Bfrtip',
            "paging":  true,
            
        } );
      	
                sectionTable = $('#sectionTable')
      	     .DataTable(
      	             {
      	            	 "destroy": true,
      	            	 "ajax" : "sections?warehouseId="+IdInt,
      	                "paging":true,
      	                 
      	                 dom : 'Bfrtip',
      	                 'columnDefs' : [
      	                	 
      	                      {
      	                        
      	                         'targets' : 0,
      	                         'data' : "warehouseId",
      	                         "defaultContent" : "",
      	                          visible:false
      	                       },
      	                     {
         	                        
        	                         'targets' : 1,
        	                         'data' : "warehouseName",
        	                         "defaultContent" : "",
        	                          visible:false
        	                       },
      	                	 
      	                     {
        	                         
        	                         'targets' : 2,
        	                         'data' : "sectionId",
        	                         "defaultContent" : "",
        	                      
        	                       },
      	                	
      	                          {
      	                             'targets' : 3,
      	                             'data' : "sectionName",
      	  	                         "defaultContent" : "",
      	                             
      	                           },
      	                        
        	                  
        	                           {

        	                        	   'targets' : 4,
        	                        	   "width": "20%",
        	                        	   "defaultContent" : "",
        	                        	   className : "",
        	                        	   orderable: false,
        	                        	   "render" : function(data,
        	                        	   type, full, row) {
        	                        	   data = '&nbsp;&nbsp;<i class="fa fa-eye sectionView" style="cursor:pointer;color:red;font-size:16px" title="View"></i>&nbsp;&nbsp;&nbsp;&nbsp;'
        	                        	   return data;
        	                        	   }
        	                        	   }
      	                           
                    
      	                      ]
      	                     });
      
                
                
                
                
                
                var rackViewId = 0;
            	var eflag = false;    
         
                

   //------------------------------------------------ VIEW TABLE CLICKS----------------------------------------------------
            	
              		
                  $('#sectionTable tbody').on('click','.sectionView', function() {
              		 console.log("id "+sectionId);   
              	     $("#attrDivModal").empty();
              				viewFlag = true;
              				checkFlag = false;
              				var data = sectionTable.row($(this).parents('tr')).data();	
              				var customerName = data.warehouseName;
              		    	$('#itemMod').text(customerName);
              		  	var secName = data.sectionName;
          		    	$('#descMod').text(secName);
              		    	rackViewId = data.sectionId;
              		      	
              		  	var rackTable = $('#rackTable').DataTable( {
              	      		 dom : 'Bfrtip',		
              	            "paging":  true,
              	            
              	        } );
              	      	     rackTable = $('#rackTable')
              	      	     .DataTable(
              	      	             {
              	      	            	 "destroy": true,
              	      	            	 "ajax" : "racks?sectionId="+rackViewId,
              	      	                "paging":true,
              	      	                 
              	      	                 dom : 'Bfrtip',
              	      	                 'columnDefs' : [
              	      	                	 
              	      	                     
              	      	                	 
              	      	                     {  
              	        	                         'targets' : 0,
              	        	                         'data' : "sectionId",
              	        	                         "defaultContent" : "",
              	        	                          visible:false
              	        	                         
              	        	                      
              	        	                       },
              	      	                	
              	      	                         
              	      	                         {
              	        	                             'targets' : 1,
              	        	                             'data' : "rackId",
              	        	  	                         "defaultContent" : "",
              	        	                             
              	        	                           },
              	      	                           
              	      	                         {
              	        	                             'targets' : 2,
              	        	                             'data' : "rackName",
              	        	  	                         "defaultContent" : "",
              	        	                             
              	        	                           },
              	        	                           
              	        	                           
              	        	  	                     {

              	 		  								'targets' : 3,
              	 		  								 "width": "20%",
              	 		  								"defaultContent" : "",
              	 		  								className : "",
              	 		  								orderable: false,
              	 		  								"render" : function(data,type,full,row) {
              	 		  										data = '&nbsp;&nbsp;<i class="fa fa-trash rackdelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButtonId"></i>'
              	 		  										return data;
              	 		  								}
              	 		  							}   
              	        	                           
              	        	                           
              	        	                     
              	      	                      ]
              	      	                     });
              	      
              	        	
       
              		    	 if((data.additionalAttribute == null)||(data.additionalAttribute == undefined)||(data.additionalAttribute == '')){
              		 		 	console.log("do nothing");
              		 		 	editFlag = false;
              		 		 	viewFlag = true;
              		 		 	$('#rackData').modal('show');
              		 		 	}
              		 		 else{
              		 		 	additionalAttribute = '';
              		 		 	additionalAttribute = data.additionalAttribute;
              		 		 	additionalAttributeFlag = true;
              		 		 	editFlag = false;
              		 		 	viewFlag = true;
              		 		 	splitData();
              		 		 	$('#rackData').modal('show');
              		 		 	}
              		    	 
              		    	 
              		      });
                  
                  
                  
                  
                  
                  
                  
   //------------------------------------END OF VIEW----------------------------------------------------------------------------//               
                
  //----------------------Section Add-----------------------------------------------------------------------------------------------------//              
                
               
           	 $('#addsectionBtn').click(function(){
           		 console.log(sectionId);
    			 getsection();
    			   if(sectionId>0){
    				   sectionId=sectionId;
    			   }else{
    				  sectionId=0;
    		        }
    			   
    			   $.ajax({
    			       async: false,
    			       type : "Post", 
    		           url:"/sectionOperations?sectionId="+sectionId+"&warehouseId="+IdInt+"&activeStatus=Y&sectionName="+sectionName,
    		           success : function(json){
    			    	   if(json.status == 'SUCCESS'){
    			                	  $.alert({
    			                		    icon: 'fa fa-check-circle-o',
    			                		    title: 'Success!',
    			                		    content: ' section added',
    			                		    onClose: function(){
    			                		    	window.location.href="/configureWH?warehouseId="+IdInt;
    			                		    }
    			                		});
    			                	  
    			                  }
    			       
    			       
    			                else{
    			                	  $.alert({
    			                		    icon: 'fa fa-times-circle-o',
    			                		    title: 'Error!',
    			                		    content: 'Try again later',
    			                		    onClose: function(){
    			                		    	window.location.href="/configureWH?warehouseId="+IdInt;
    			                		    }
    			                		});
    			                   }
    			              },
    			           
    			   });  
    			   	       
    			   
    		       });
                
             
                
      		 
     //------------------------Rack Add----------------------------------------------------------------------------------------------------//
   		    
           	 
           	 $('#addrackBtn').click(function(){
           		 console.log(rackId);
    			 getsection();
    			   if(rackId>0){
    				   rackId=rackId;
    			   }else{
    				  rackId=0;
    		        }
    			   
    			   $.ajax({
    			       async: false,
    			       type : "Post", 
    		           url:"/rackOperations?rackId="+rackId+"&warehouseId="+IdInt+"&sectionId="+sectionId+"&activeStatus=Y&rackName="+rackName,
    		           success : function(json){
    			    	   if(json.status == 'SUCCESS'){
    			                	  $.alert({
    			                		    icon: 'fa fa-check-circle-o',
    			                		    title: 'Success!',
    			                		    content: ' Rack added',
    			                		    onClose: function(){
    			                		    	window.location.href="/configureWH?warehouseId="+IdInt;
    			                		    }
    			                		});
    			                	  
    			                  }
    			       
    			       
    			                else{
    			                	  $.alert({
    			                		    icon: 'fa fa-times-circle-o',
    			                		    title: 'Error!',
    			                		    content: 'Try again later',
    			                		    onClose: function(){
    			                		    	window.location.href="/configureWH?warehouseId="+IdInt;
    			                		    }
    			                		});
    			                   }
    			              },
    			           
    			   });  
    			   	       
    			   
    		       });
                
                
     
          
		 
	//-------------------------------edit warehouse------------------------------------------------------------------------------------//
		 
		 
		  $('#warehouseTable tbody').on("click",".warehouseEdit",function(){
		    	 
		    	 $('#newWarehouseForm').show();
				
				  var data = warehouseTable.row($(this).parents('tr')).data();
			 		console.log("ID to edit =  "+data.warehouseId);
			 		warehouseId=data.warehouseId;
			 		 
			 		$.ajax({
			 		    async: false,
		 		        url : "getwarehouseedit?warehouseId="+warehouseId,
		 		        success:function(json) {
		 		        $.each( json.data, function( data ) {
		 		        
		 		         $('#code').val(this.warehousecode);
		 		   		 $('#firstName').val(this.warehouseName);
		 		   		 $('#address').val(this.warehouseAddress);
		 		   	      $('#workPhone').val(this.mobileNumber);
		 		   		 $('#warehouseEmail').val(this.warehouseemail);
		 		   		 
		 		   	    });
		 		         
		 		    }
		 		});
			 	
		     });

		 

	 //-----------------------warehouse detail table to section table---------------------------------------------------------------------------------------------//
		 
		  
		 $('#warehouseTable tbody').on("click","tr td:not(:last-child)",function() {

			  var data = warehouseTable.row($(this).parents('tr')).data();
			  var houseName = data.warehouseName;
			
		 		warehouseId=data.warehouseId;
		 		window.location.href="/configureWH?warehouseId="+warehouseId;
		 		
		 		$('#newWarehouseForm').show();
		 		  console.log("hi");
			 		console.log("ID to edit =  "+data.sectionId);
			 		console.log("ID to edit =  "+rackName);
			 		var houseName = data.RackName;
			 	

		 });
		 
//---------------------section to rack-------------------------------------------------------------------------------------------//
		 
		 
		 $('#sectionTable tbody').on("click","tr td:not(:last-child)",function() {
			$('#newSectionRackForm').show();
			 
			 var data = sectionTable.row($(this).parents('tr')).data();
			   console.log(" warehouse ID = "+data.warehouseId);
			   console.log("section id =  "+data.sectionId);
			   console.log("section name =  "+data.sectionName);
			     $('#SectionName').val(this.sectionName);
		 		sectionId=data.sectionId;
		 		
                      $.ajax({
			 		    async: false,
		 		        url : "editsection?sectionId="+sectionId,
		 		        success:function(json) {
		 		        $.each( json.data, function( data ) {
		 		        	
		 		            //var secName = data.sectionName;
		 			    	//$('#SectionName').text(secName);
		 		        
		 		       $('#SectionName').val(this.sectionName);
		 		   		
		 		   		 
		 		   	    });
		 		         
		 		    }
		 		});
			 	 		
			 		

		 });
		 
		 
		 
			
		
	//------------------------------Warehouse save---------------------------------------------------------------//
		 
		 
	
	  $('#warehouseSubmitButton').click(function(){
		   checkMandatoryFields();
		  if(warehouseId>0){
			   warehouseId=warehouseId;
		   }else{
			   warehouseId=0;
	        }
		   $.ajax({
		       async: false,
		       type : "Post", 
	     url:"warehouseOperations?warehouseId="+warehouseId+"&warehousecode="+warehousecode+"&warehouseName="+warehouseName+"&warehouseAddress="+warehouseAddress+"&mobileNumber="+mobileNumber+"&activeStatus=Y&warehouseemail="+warehouseemail,
	           success : function(json){
		    	   if(json.status == 'SUCCESS'){
		                	  $.alert({
		                		    icon: 'fa fa-check-circle-o',
		                		    title: 'Success!',
		                		    content: ' Warehouse added',
		                		    onClose: function(){
		                		    	window.location.href="/warehouse";
		                		    }
		                		});
		                	  
		                  }
		       
		       
		                else{
		                	  $.alert({
		                		    icon: 'fa fa-times-circle-o',
		                		    title: 'Error!',
		                		    content: 'Try again later',
		                		    onClose: function(){
		                		    	window.location.href="/warehouse";
		                		    }
		                		});
		                   }
		              },
		           
		   });  
		   	       
		
	       });
	
	
//------------------------------------------------------------------------------------------------------------------//	
	
	
	
	
	
	
	
});