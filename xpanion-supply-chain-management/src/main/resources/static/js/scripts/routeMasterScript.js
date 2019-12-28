/**
 * @author : ASHLIN ABRAHAM
 * @date : 16.06.2019
 * @purpose : Register new routes.
 */
$ (document).ready(function(){
	
     console.log("doc ready");
		var routeId;
		var route;
		var startingRoute;
		var finalRoute;
		var via;
		var createUserId;
		var activeStatusIndicator;
	 console.log("inside");
		
    tableRoutes = $('#routeTable')
    .DataTable(
            {
           	 "destroy": true,
           	 "ajax" : "getRoutes",
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
                        "defaultContent" : "",
                        
                      },
                         
                         {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 1,
	  	                         'data' : "routeId",
	  	                         "defaultContent" : "",
	  	                          'visible' : false,
	  	                         
	  	                  },
	  	                {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 2,
	  	                         'data' : "route",
	  	                         "defaultContent" : "",
	  	                         
	  	                         
	  	                  },
	  	                {

  							'targets' : 3,
  							"defaultContent" : "",
  							className : "",
  							orderable: false,
  							"render" : function(data,
  									type, full, row) {
  									data = '&nbsp;&nbsp;<i class="fa fa-pencil EditButtton" style="cursor:pointer;color:red;font-size:16px" id="EditButttonId"></i>&nbsp;&nbsp;<i class="fa fa-trash deleteButtton" style="cursor:pointer;color:red;font-size:16px" id="deleteButttonId"></i>'
  									return data;
  							}
  						},
                     ]
                    });
    tableRoutes.on( 'order.dt search.dt', function () {
    	tableRoutes.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
    //-------------------------------------------------------------------------------------------------------------------------//
    
    function displayMessage(){
        
        alert("please fill mandatory fields");
        }
   function checkMandatoryField(){
	   route=$('#route').val();
	   startingRoute=$('#startroute').val();
	   finalRoute=$('#finalroute').val();
	   via=$('#via').val();
   }
  //-------------------------------------------edit--------------------------------------------------------------//
   
  /* rouId = location.search.split('routeId=')[1];
	window.history.replaceState({}, document.title, "/" + "#");
	console.log("route id="+rouId);
	if(rouId > 0 && rouId !=null){
	IdInt = $.trim(parseInt(rouId));
	$('label[for="routeId"]').css("display","inline-block");
	$("routeId").css("display","inline-block");
	$("routeId").val(IdInt);
	$("routeId").prop('readonly',true);
	getRoutes();
	   }
	function getRoutes(){
	var s = $("#routeId").val();*/
   $('#routeTable').on('click','.EditButtton',function()
			{
	   $('#newRouteForm').show();
			var data =tableRoutes.row($(this).parents('tr')).data();
			console.log("ID to edit = "+data.routeId);
			routeId=data.routeId;
			
		
	$.ajax({
	async: false,
	url:"getrouteedit?routeId="+routeId,
	success : function(json){
	$.each(json.data, function( data ){
	
	$("#route").val(this.route);
	console.log(this.route);
   $("#startroute").val(this.startingRoute);
	console.log(this.startingRoute);
	$("#finalroute").val(this.finalRoute);
	console.log(this.finalRoute);
	$("#via").val(this.via);
	console.log(this.via);
	
	});
	}

	});
	});
  //-------------------------------------------------------------------------------------------------------//
	
	
	//----------------------------------submit--------------------------------------------------------------------------//
    
    $('#save').click(function(){
		   checkMandatoryField();
		   if(routeId>0){
				routeId=routeId;
				}else{
				routeId=0;
				}
		   $.ajax({
		       async: false,
		       type : "Post", 
	     url:"routeOperations?routeId="+routeId+"&route="+route+"&startingRoute="+startingRoute+"&finalRoute="+finalRoute+"&activeStatusIndicator=Y&via="+via,
		       success : function(json){
		    	   if(json.status == 'SUCCESS'){
		                	  $.alert({
		                		    icon: 'fa fa-check-circle-o',
		                		    title: 'Success!',
		                		    content: ' new route added',
		                		    onClose: function(){
		                		    	window.location.href="/routeMaster";
		                		    }
		                		});
		                	  
		                  }
		       
		       
		                else{
		                	  $.alert({
		                		    icon: 'fa fa-times-circle-o',
		                		    title: 'Error!',
		                		    content: 'Try again later',
		                		    onClose: function(){
		                		    	window.location.href="/routeMaster";
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
//----------------------------------------------------delete-----------------------------------------------------//
    
    
    $('#routeTable').on('click', '.deleteButtton', function() {
		var data = tableRoutes.row($(this).parents('tr')).data();
		console.log("ID to delete =  "+data.routeId);
		routeId = data.routeId;
		route = data.route;
		startingRoute = data.startingRoute;
		finalRoute = data.finalRoute;
		via = data.via;
		$.confirm({
			icon: 'fa fa-question-circle',
		    title: 'Confirm!',
		    content: 'Are you sure?',
		    boxWidth: '30%',
		    useBootstrap: false,
		    buttons: {
		        confirm: function () {
		        	activeStatusIndicator = 'N';
					 $.ajax({
						 async: false,
						 type : "POST",
						 url: "routeOperations?routeId="+routeId+"&activeStatusIndicator="+activeStatusIndicator, 
					       success: function(json){
								if(json.status == 'SUCCESS'){
								    $.alert({
								    	escapeKey: true, // close the modal when escape is pressed.
					                	backgroundDismiss: true,
								        icon : 'fa fa-smile-o',
								    	title: 'Success!',
								        content: 'Route deleted!',
								        boxWidth: '30%',
									    useBootstrap: false,
									    onClose: function () {
									    	 window.location.href="/routeMaster";
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