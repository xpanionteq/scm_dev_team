/**
 *@author:Aswathy Raj.D
 * 
 */
 
 
$(document).ready(function(){

console.log("in");
var data;
var purchaseId;
//---------------------------------------------------------------------------------------------------------------------------

 var tablePending = $('#pendingPurchaseTable')
.DataTable(
        {
       	"destroy": true,
       	"ajax" : "getPendingPurchaseId",
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
                    'data' : "purchaseId",
                    "defaultContent" : "",
                    
                  },
                  {
                     	
                      'targets' : 1,
                      'data' : "contactNames",
                      "defaultContent" : "",
                 },
                  {
                	
                            'targets' : 2,
                            'data' : "orderDate",
                            "defaultContent" : "",
                 },
                 {
                  	  
                           'targets' : 3,
                           'data' : "expectedDeliveryDate",
                           "defaultContent" : "",
                },
                
                {	'targets' : 4,
					"defaultContent" : "",
					 className : "",
					 orderable: false,
					"render" : function(data,
							type, full, row) {
							data = '&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-minus-circle purchaseremoveBtn" id="removeButton" style="font-size:15px;color:red;cursor:pointer;"></i>&nbsp;&nbsp;<i class="fa fa-pencil purchaseEditButtton" style="cursor:pointer;color:red;font-size:15px" id="purchaseEditButttonId"></i>'
							return data;
					}
                  
                    },
                        
               ]
        });
//------------------------------------------------------------------------------------------------------------------------
$('#pendingPurchaseTable tbody').on('click', '.purchaseEditButtton', function() {
	data = tablePending.row($(this).parents('tr')).data();
	console.log("ID to edit =  "+data.purchaseId);
	purchaseId = data.purchaseId;
	
	
	 window.location.href = "/purchaseOrders?purchaseId="+purchaseId;
});
//-------------------------------------------------------------------------------------------------------------------------
});