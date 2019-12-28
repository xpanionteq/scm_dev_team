/**
 * @author : ASHLIN ABRAHAM
 * @date : 09.05.2019
 * 
 */



var rateArray = [];
var itemRate;
var attributeId;
var mrp;
var itemName;
var productId;
var attributeName;
var qnty;
var disc;
var totalamount;
var productDataArray = [];
var total = 0;
var subtotal;
$('#productsForm').hide();
$('#cartTableBox').hide();
$('#buttons').hide();
$('#billForm').hide();
$ (document).ready(function(){
	
//---------------------------------------initially hide products table--------------------------------------------------
	var doc = new jsPDF();
	var specialElementHandlers = {
	    '#editor': function (element, renderer) {
	        return true;
	    }
	};

	$('#cmd').click(function () {
	    doc.addHTML($('#content'), 15, 15,function() {
	    	 doc.save('sample-file.pdf');
	    });
	   
	});
	/*let doc = new jsPDF('p','pt','a4');
	$('#cmd').click(function () {
	doc.addHTML($('#content'), 25, 25,function() {
	    doc.save('test.pdf');
	});
	});*/

//-----------------------------------------------------------------------------------------------/
/*	$('#checkoutTable').DataTable( {
        "scrollY":        "150px",
        "scrollCollapse": true,
        "stateSave":      false,
        "scroller": {
            "loadingIndicator": true,
            "displayBuffer": 10
        },*/
        
    
//--------------------items table------------------------------------------------//	

	var productsTable = $('#itemsTable').DataTable( {
		 dom : 'Bfrtip',
       "paging":  true,
       
   } );
	

		 productsTable = $('#itemsTable')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "items",
	                "paging":true,
	                 
	                 dom : 'Bfrtip',
	                 'columnDefs' : [
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 0,
	                         'data' : "productId",
	                         "defaultContent" : "",
	                         
	                       },
	                          {
	                             'targets' : 1,
	                             'data' : "itemName",
	  	                         "defaultContent" : "",
	                             
	                           },
	                           {
		  	                         
		  	                         'targets' : 2,
		  	                         'data' : "mrp",
		                             "defaultContent" : "",
		                             
		  	                         
		  	                       },
	                          
	                      ]
	                     });

	    
	

	

	//---------------------------------contact table-----------------------------------------------------------//
		 
					 
	$('#checkoutTable').DataTable( {
        "scrollY":        "150px",
     
        "scrollCollapse": true,
        "stateSave":      false,
        "scroller": {
            "loadingIndicator": true,
            "displayBuffer": 10
        },
        "paging":         true
    } );
		
	function getCustomerList(){
		 tableContact = $('#contactTable')
	     .DataTable(
	             {
	            	 "destroy": true,
	            	 "ajax" : "order",
	                "paging":true,
	                 
	                 dom : 'Bfrtip',
	                 'columnDefs' : [
	                     
	                     {
	                         'searchable' : false,
	                         'orderable' : false,
	                         'targets' : 0,
	                         'data' : "contactId",
	                         "defaultContent" : "",
	                         
	                       },
	                          {
	                             'targets' : 1,
	                             'data' : "companyName",
	  	                         "defaultContent" : "",
	                             
	                           },
	                           {
		  	                         
		  	                         'targets' : 2,
		  	                         'data' : "contactName",
		                             "defaultContent" : "",
		                             
		  	                         
		  	                       },
	                           {
	  	                         
	  	                         'targets' : 3,
	  	                         'data' : "mobileNumber",
	  	                         "defaultContent" : "",
	  	                         
	  	                       },
	  	                     {
		  	                         
		  	                         'targets' : 4,
		  	                         'data' : "landNumber",
		  	                         "defaultContent" : "",
		  	                         
		  	                       },
	                      ]
	                     });

	    
	}
			
		 

	
//--------------------------------------------------------------------------------------------------//
	
 
	getRoutes();
	function getRoutes(){
	var jsonURL="getRoutes";
		$.getJSON(jsonURL, function(json) {
		$.each(json.data, function(data) {   
		    $('#routeNew').append($("<option></option>").attr("value",this.routeId).text(this.route));
		   });
		});
}//-----------------------------------FILTER CUSTOMERS BASED ON ROUTE------------------------------//
	
	$('#routeNew').on('change', function() {
		//alert('customerId '+customerId);
		var routeId = $('#routeNew').find(":selected").val();
		if(routeId == 0){
			getCustomerList();
		}else if(routeId > 0){
			 tableContact = $('#contactTable')
		     .DataTable(
		             {
		            	 "destroy": true,
		            	 "ajax" : "filterCustomer?routeId="+routeId,
		                 "width" : "100%",
		                 
		                 "bAutoWidth" : false,
		                 "scrollCollapse" : true,
		                 "bScrollCollapse" : true,
		                 "iDisplayLength" : 10,
		                 "fixedHeader" : {
		                     "header" : true
		                 },
		                 
		                 "pagination" : true,
		                 dom : 'Bfrtip',
		                'columnDefs' : [
		                     
		                     {
		                         'searchable' : false,
		                         'orderable' : false,
		                         'targets' : 0,
		                         'data' : "contactId",
		                         "defaultContent" : "",
		                         
		                       },
		                          {
		                             'targets' : 1,
		                             'data' : "companyName",
		  	                         "defaultContent" : "",
		  	                         
		                             
		                           },
		                           {
			  	                         
			  	                         'targets' : 2,
			  	                       'data' : "firstName",
			                             "defaultContent" : "",
			                             "render": function (data, type, full, meta ) {
			                                 return full.firstName +' '+full.lastName;
			                             }
			  	                         
			  	                       },
		                           {
		  	                         
		  	                         'targets' : 3,
		  	                         'data' : "mobileNumber",
		  	                         "defaultContent" : "",
		  	                         
		  	                       },
		  	                     {
			  	                         
			  	                         'targets' : 4,
			  	                         'data' : "landNumber",
			  	                         "defaultContent" : "",
			  	                         
			  	                       },
		                      ]
		                     });
		}
		


	});
	
	
	
	
	
//-----------------------------------------------------------------------------------------------------------------
	 $('#contactTable tbody').on('click','td', function() {
	    	var data = tableContact.row($(this).parents('tr')).data();	
	    	customerId = data.contactId;
	    	var customerName = data.contactName+','+data.companyName;
	    	$('#customerData').text(customerName);

	    	 $('#contactTable td').css('background', '');
			 $(this).parent().children().css('background', '#CCCCCC');
	    	console.log('ready to call  '+customerId);
	    	if(customerId > 0){
	    		$('#customersForm').hide();
	    		$('#productsForm').show();
	    
	    	}
	    	
	    });
	 
//----------------------------------------------------------------------------------------------------------------
	 var i = 1;
	 $('#itemsTable tbody').on('click','td', function() {
		  $('#cartInfoBox').hide();
		  $('#cartTableBox').show();
		  $('#buttons').show();
		 
	    	var data = productsTable.row($(this).parents('tr')).data();	
	    	 itemName =data.itemName;
	    	 itemRate = data.mrp;
	    	 subtotal=data.total;
	    	 console.log(itemRate);
	    	//alert("item "+itemName+" "+itemRate);
	    	$("#mainTable tbody").append("<tr><td id='col-" + i + "'>" + itemName + "</td><td>" + itemRate + " </td><td id='qty " + i + "' name='quantity' ><input type='text'  size='2'></td><td id= 'discount" + i +"'name='discount'><input type='text'  size='2'><td id= 'subtotal" + i +"'name= 'subtotal'><input type='text'  size='2'></td><td><i class='fa fa-minus-circle'></td></i></tr>");
	    	 i++; 
	    	 var rows = $("#mainTable tr:gt(0)");
	          rows.children("td:nth-child(6)").each(function() {
	    		  total += parseInt($(this).html());
	    		 //alert("#tot "+total+" "+parseInt($(this).html()));
	    		  $("#mrp").keyup(function(){
	    	            alert($(this).val());
	    		  });
	    		  
	    		  $("#qty").keyup(function(){
	    	            alert($(this).val());
	    		  });
	    		 /* $("#subtotal").keyup(function(){
	    			  
	    	           alert($(this).val());
	    		  });*/
	    		   
	    	/* $("#totalAmt").html(total);
	    	 totalamount = data.total;
	    	 console.log(totalamount);
	    	 total = 0;*/
	    		  $('#qty').on('change', function() {
	    				quantity=$('#qty').val();
	    				console.log("quantity"+quantity);
	    				subtotal=itemRate * quantity;
	    				console.log("subtotal"+subtoatal);
	    				});
	    		  
	    		  
	 });
	          
	      var table =$('#mainTable').DataTable({
	    	  keys:true
	      });
	      table
	      .on('key-focus',function(){
	    	  console.log('in');
	    	 	
	 });
	/*.on('key-blur',function(){
	    	 qnty = $('input[name="quantity"]').val();
	      $('#qty').html('qnty');
	 });
	 
	 on('key-blur',function(){
		    	disc = $('input[name="discount"]').val();
		      $('#qty').html('qnty');
		     subtotal=mrp * qty+discount;
		 });
	     */
	      
	      
	      
	      
	      
	      
	      
	      
	          
	  /*	$('#qty').focus(function(){
	    		console.log('in');
	    	}).blur(function(){
	     qnty = $('input[name="qty"]').val();  
	   
	    	 })
	    	 
	     $('#discount').focus(function(){
 		console.log('in');
 	    }).blur(function(){
 		 disc = $('input[name="discount"]').val();	    	
	       })*/
  
	       
    	   // var subtotal = itemRate * qnty - disc;
            // function calculate() {
   		       // $("#subtotal").html(subtotal);
   		    //}
	     // });

	/*$('#mainTable').on('click', 'tr', function(){
		    //alert("td");
		// $(this).prop('contenteditable', true)
		 var data = $(this).attr('id');
	     alert (data);
	     var PayingAmtValue = $(this).closest('td').find('input.quantity').val();
	     alert('PayingAmtValue'+PayingAmtValue);
		});
	*/ 
	$('#refreshCustomer').click(function(){
		getCustomerList();
	});
	 
	 
	 
	 
	 
	 
	 
	 $('#customerClick').click(function(){
		 
		 $('#productsForm').hide();
		 $('#billForm').hide();
		 $('#customersForm').show();
	 });
	 
	 $('#productClick').click(function(){
		
		 $('#customersForm').hide();
		 $('#billForm').hide();
		 $('#productsForm').show();
			 
		 });
	 $('#billClick').click(function(){
		 $('#productsForm').hide();
		 $('#customersForm').hide();
		 $('#billForm').show();
		 
			 
		 });
	 $('#emptyMsg').click(function(){
		  $('#productsForm').show();
		  $('#cartTableBox').show();
		  $('#customersForm').hide();
		  $('#buttons').show();
	 });
	 $('#proceedButton').click(function(){
		  $('#billForm').show();
		  $('#productsForm').hide();
		  $('#cartTableBox').show();
		  $('#customersForm').hide();
		  $('#buttons').hide();
	 });
	 $('#billCancelButton').click(function(){
		  $('#billForm').hide();
		  $('#productsForm').show();
		  $('#cartTableBox').show();
		  $('#customersForm').hide();
		  $('#buttons').show();
	 });
	 
	 
	 
	 
});
});