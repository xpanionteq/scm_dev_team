/**
 * @author:ASWATHY RAJ.D
 * @purpose:purchase order
 * @date:2019-07-24
 * 
 */
$(document).ready(function(){

   console.log("in");
   var purchaseId;
   var purchId;
   var ProductVal;
   var contactId
   var OrderNumber;
   var deliveryDate;
   var productId;
   var Quantity;
   var PurchaseorderproductsId;
   var WarehouseId;
   var StatusId;
   var  vendorSelect;
   var date_string ;
   var namesArray=[];
   var items=[];
   var itemId;
   var PurchaseProductlist=[];
   var data;
   var purchId=0;
   var flag = 0;
  //-----------------------------------------------------------------------------------------------------------
 
  
   $('#newVendor').click(function(){
	   
	   window.location.href="/contacts";
   });
   
 //--------------------------------------------------------------------------------------------------------------
   $('#deliveryDate').datepicker();
   $("#orderDate").datepicker().datepicker("setDate", new Date());
   $('#deliveryDate').change(function(){
   deliveryDate = $('#deliveryDate').val();
   date_string = moment(deliveryDate, "MM.DD.YYYY").format("YYYY-MM-DD");
  // alert (date_string); 
   });
 //-------------------------------------------Get contact Names--------------------------------------------- 
   $.ajax({
       async: false,
       url: "getContactNames",
         success: function(json){
              $.each(json.data, function(data) {
              console.log("id"+this.contactId);
              $('#vendorSelect').append($("<option></option>").attr("value",this.contactId).text(this.contactNames));
              });
         }
   });
   
 //--------------------------------------------------------------------------------------------------------   
   $('#vendorSelect').change(function(){
   contactId=$('#vendorSelect option:selected').val();
   console.log(contactId);
   
   if(contactId== 'select'){
	   console.log("out");
   }else{
	   console.log(contactId);
   $.ajax({
       async: false,
       url: "getPrimaryContactDetails?contactId="+contactId ,
         success: function(json){
             if(json.status == 'SUCCESS'){
          	 
             $.each(json.data, function( data ) {
           	  
           	  var address = '<strong>'+this.companyName+'</strong><br>'+this.building+'<br>'+this.locality+'<br>' +this.city+','+this.zipcode+'<br>'+this.state+'<br>Phone: '+this.mobileNumber+'<br>Email ID: '+this.email;
                 $("#vendorAddress").html(address);
           	  
          	   
             });
             }
         }
        });    
   
   }
	});

//-------------------------------------------Get product names--------------------------------------------- 
   var jsonURL="getProductNames"
   $.getJSON(jsonURL, function(json) {
              $.each(json.data, function(data) {   
              $('#productId').append($("<option></option>").attr("value",this.productId).text(this.productName));
              });
   });
 
    var t=$('#makeEditable').DataTable({
	   paging:   false,
       bFilter: false, 
       bInfo: false
      	
   });
 //------------------------------------------------------------------------------------------------------------------  
  //---------------------------------------------------EDIT LIST FROM PENDING PURCHASE TALBLE------------------------------------------------------------------------
    purchId = location.search.split('purchaseId=')[1];
    console.log("purchase Id"+purchId);

    if(purchId >0 && purchId != null){
    	 $('#vendorSelect').prop('disabled', true);
    	 $("#productId").prop("disabled",true);
    	 $('#newVendor').hide();
    	 getPurchaseOrderDetails();
    	 reloadPurchaseProductTable();
    }

    function getPurchaseOrderDetails(){
    $.ajax({
        async: false,
        url: "getPurchaseProductDetails?purchaseId="+purchId,
      success : function(json){
    	  $.each(json.data, function(data) {
    		  PurchaseorderproductsId = this.purchaseProductDetId; 
    		  console.log("PurchaseProductDetId"+this.purchaseProductDetId);
              var d=this.orderDate;
              var date_string=d.split(' ')[0];
              console.log("split date"+date_string);
              $('#orderDate').val(date_string);
        	  $('#deliveryDate').val(this.expectedDeliveryDate);
           	  $("#vendorSelect").val(this.contactId).trigger('change');
        	  console.log("vendor"+this.contactNames);
        	  console.log("date"+this.expectedDeliveryDate);  
        	  
        	  PurchaseProductlist.push({
	    		   purchaseorderproductsId:this.purchaseProductDetId,
	    	       orderedQuantity:this.orderedQuantity,
	    	       productId:this.productId
	    	   });
        	  console.log ("Purchase List Array "+JSON.stringify(PurchaseProductlist));
    	  });
      }
    });

    }

    function reloadPurchaseProductTable(){
    	 t = $('#makeEditable')
    	  .DataTable(
    	          {
    	         	"destroy": true,
    	         	"ajax" : "getPurchaseProductDetails?purchaseId="+purchId,
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
    	                      'searchable' : true,
    	                      'orderable' : false,
    	                      'targets' : 0,
    	                      'data' : "productId",
    	                      "defaultContent" : "",
    	                      
    	                    },
    	                    {
    	                     	
    	                              'targets' : 1,
    	                              'data' : "productName",
    	                              "defaultContent" : "",
    	                   },
    	                   {
    	                    	  
    	                             'targets' : 2,
    	                             'data' : "orderedQuantity",
    	                             "defaultContent" : "",
    	                  },
    	                  {
	                    	  
	                             'targets' : 3,
	                             'data' : "purchaseProductDetId",
	                             "defaultContent" : "",
	                             'visible':false,
	                  },
    	                  {	'targets' : 4,
    	  					"defaultContent" : "",
    	  					 className : "",
    	  					 orderable: false,
    	  					"render" : function(data,
    	  							type, full, row) {
    	  							data = '&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-minus-circle purchaseremoveBtn" id="removeButton" style="font-size:15px;color:red;cursor:pointer;"></i>&nbsp;&nbsp;<i class="fa fa-pencil purchaseEditButtton" style="cursor:pointer;color:red;font-size:16px" id="purchaseEditButttonId"></i>'
    	  							return data;
    	  					}
    	                    
    	                      },
    	                          
    	                 ]
    	          });
    }
 
//-------------------------------------------------------------------------------------------------------------------------------
  
       vendorSelect=$('#vendorSelect').find(":selected").text();
	   console.log("ved"+vendorSelect);
	   
   
    $('#but_add').on('click',function(){
    	   
   	   var prodName=$('#productId').find(":selected").text();
	   var Quant=$('#Quantity').val();
	   ProductVal=$('#productId option:selected').val();
	   console.log("array is "+items);
	  
     
	     if( ProductVal == '' || ProductVal == null ||ProductVal == undefined ||Quant== undefined || Quant == '' ||Quant ==null || prodName == '--select--'){
	    
	    	 $.alert({
	            icon : 'fa fa-frown-o',
	            title: 'Warning!',
	            content: 'Please fill all mandatory fields',
	            boxWidth: '30%',
	            useBootstrap: false,
	       });	
	    }else if (jQuery.inArray(ProductVal, items)!='-1') {
	             // alert(ItemVal + ' is in the array!');
	         	 $.alert({
	   	            icon : 'fa fa-frown-o',
	   	            title: 'Warning!',
	   	            content:' You are already selected this item ',
	   	            boxWidth: '30%',
	   	            useBootstrap: false,
	   	       });	
                 
            	
	          } else {
	
   var rowNode = t
   .row.add( [$('#productId option:selected').val(),$('#productId option:selected').text(),$('#Quantity').val(),'&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-minus-circle purchaseremoveBtn" id="removeButton" style="font-size:15px;color:red;cursor:pointer;"></i>' ] )
   .draw()
   .node();
  
   Quantity=$('#Quantity').val();
   ProductVal=$('#productId option:selected').val();
   items.push(ProductVal);
   console.log(items);
   console.log("id in array"+PurchaseorderproductsId);
   if(PurchaseorderproductsId == null || PurchaseorderproductsId == undefined){
	   PurchaseorderproductsId=0;
   }
	  
   PurchaseProductlist.push({
	   purchaseorderproductsId:PurchaseorderproductsId,
       orderedQuantity:Quantity,
       productId:ProductVal
   });
   console.log ("Product Array "+JSON.stringify(PurchaseProductlist));
	}
	
});
//-------------------------------------------------------------------------------------------------------------------------    
    $('#makeEditable tbody').on('click', '.purchaseremoveBtn', function() {
 	    alert("clicked");
 	   t.row($(this).closest("tr")) .remove().draw();
 	   
 	   itemId=$(this).find('td').eq(0).text();
 	   console.log("productId"+itemId);
 	   
 	   PurchaseProductlist = jQuery.grep(PurchaseProductlist, function(value) {
 		   return value.productId !=itemId ;
 		 });
 	   items.splice($.inArray(itemId,items),1);
 	   console.log("Item ID"+items);
 	   console.log (JSON.stringify(PurchaseProductlist));
 	  
 });


//-------------------------------------------------------------------------------------------------------------------------
function displayMessage(){
		   $.dialog({
		              icon : 'fa fa-exclamation-circle',
		              title: 'Warning!',
		              content: 'Please fill all mandatory fields',
		              boxWidth: '30%',
		              useBootstrap: false,
		         });
		   }
function checkManadatoryFields(){
	  contId=$('#vendorSelect').val();
	  OrderNumber = $('#orderNumber').val();
	  deliveryDate=$('#deliveryDate').val();
	  productId=$('#productId').val();
	  Quantity=$('#Quantity').val();
	 
      
	  if(contId == ''){
		    document.body.scrollTop = 0;
		   	document.documentElement.scrollTop = 0;
		   	$('#vendorSelect').focus();
		   	displayMessage();

		  }else if (OrderNumber == ''){
			  document.body.scrollTop = 0;
			  document.documentElement.scrollTop = 0;
			  $('#orderNumber').focus();
			  displayMessage();
   
		  }else if(deliveryDate ='' ){
		      document.body.scrollTop = 0;
			  document.documentElement.scrollTop = 0;
			  $('#deliveryDate').focus();
			  displayMessage(); 
		  }else if(productId == ''){
			  document.body.scrollTop = 0;
			  document.documentElement.scrollTop = 0;
			  $('#productId').focus();
			  displayMessage();  
			  
		    
			  	
		  }
	  
}  

//------------------------------------------------------------------------------------------------------------------------
$('#submit_data').click(function(){
	
	
	console.log("delivery date"+date_string);
	checkManadatoryFields();
	submitPurchaseOrder();
});
function  submitPurchaseOrder(){ 
	WarehouseId=1;
	StatusId = 1;
	var ProductList=encodeURIComponent(JSON.stringify(PurchaseProductlist));
	if(contactId==0  ||contactId > 0 && vendorSelect=='--select--' ){
		$.dialog({
			escapeKey: true, // close the modal when escape is pressed.
       	backgroundDismiss: true,
		        icon : 'fa fa-smile-o',
		    	title: '',
		        content: 'Please Select Vendor!',
		        boxWidth: '30%',
			    useBootstrap: false
		});    

	}

	$.ajax({
        async: false,
        type : "POST",
        url: "puchaseOrderOperations?purchaseId="+purchId+"&contactId="+contactId+"&warehouseId="+WarehouseId+"&statusId="+StatusId+"&expectedDeliveryDate="+date_string+"&activeStatus=Y&PurchaseProductsmodel="+ProductList,
        success : function(json){

            if(json.status == 'SUCCESS'){
          	 $.alert({
          	   icon: 'fa fa-check-circle-o',
          	   title: 'Success!',
          	   content: 'New Purchase added',
          	   onClose: function(){
          	   	window.location.href="/purchaseOrders";
          	   }
          	});
          	 
            }
            else{
          	 $.alert({
          	   icon: 'fa fa-times-circle-o',
          	   title: 'Error!',
          	   content: 'Try again later',
          	   onClose: function(){
          	   	window.location.href="/purchaseOrders";
          	   }
          	});
            }
        },
         error: function(){
      	 $.alert({
      	       icon : 'fa fa-frown-o',
      	       title: 'Error!',
      	       content: 'Error occured. Try again!',
      	       boxWidth: '30%',
      	       useBootstrap: false,
      	      
      	   });
      	/*  e.preventDefault();*/
          }
      });

    }
	


});


   