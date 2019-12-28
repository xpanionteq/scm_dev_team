$ (document).ready(function(){
	var itemId;
	var itemName;
	
	 window.history.pushState({}, document.title, "/" + "#");
	$.ajax({
		async:false,
		url  :"getitems",
		success:function(json){
		   
		$.each(json.data, function(data) {  
		console.log("in item"+this.itemId);
		$('#item').append($("<option></option>").attr("value",this.itemId).text(this.itemName));
		              });
		}
			   }); 
	//----------------------------------------------------------------------------------------------------------------------//
	
	$("#submit").click(function(e){
		
		console.log("report generation");
		var FromDate= $('#startDate').val();
		var ToDate = $('#endDate').val();
	
	//console.log("item type is"+itemId);
	
	  
	  if(FromDate == '' || ToDate == ''){
		  $.dialog({
			  escapeKey: true, // close the modal when escape is pressed.
        	backgroundDismiss: true,
		        icon : 'fa fa-frown-o',
		    	title: '',
		        content: 'From date and To date cannot be null!',
		        boxWidth: '30%',
			    useBootstrap: false
		});
	
	  }
	
	  if(itemName=='Nippon Paints'){
		     console.log("itemtype value"+itemId);
		      $.ajax({
				async: false,
				url: 'getitemtype?itemId='+itemId, 
				success: function(json){
					console.log(json.message+" is result ");
					if(json.message == 1){
													
					    window.location.href='api/item/downloads/items.xlsx?itemId='+itemId;
					  
					}
					else if(json.message == 0){
						  $.dialog({
							  escapeKey: true, // close the modal when escape is pressed.
			                	backgroundDismiss: true,
						        icon : 'fa fa-frown-o',
						    	title: '',
						        content: 'No Nippon Paints Entries!',
						        boxWidth: '30%',
							    useBootstrap: false
						});    
						 
					}
				}
				});
		      $('#item').val('select');
	   }
	  else if(itemName==='CALVIN washbasins'){
		     console.log("itemtype value"+itemId);
		      $.ajax({
				async: false,
				url: 'getitemtype?itemId='+itemId, 
				success: function(json){
					console.log(json.message+" is result ");
					if(json.message == 1){
													
					    window.location.href='api/item/downloads/items.xlsx?itemId='+itemId;
					  
					}
					else if(json.message == 0){
						  $.dialog({
							  escapeKey: true, // close the modal when escape is pressed.
			                	backgroundDismiss: true,
						        icon : 'fa fa-frown-o',
						    	title: '',
						        content: 'No CALVIN washbasins Entries!',
						        boxWidth: '30%',
							    useBootstrap: false
						});    
						 
					}
				}
				});
		      $('#item').val('select');
	   }
	   
	  else if(itemName==='RED CALVIN washbasins'){
		     console.log("itemtype value"+itemId);
		      $.ajax({
				async: false,
				url: 'getitemtype?itemId='+itemId, 
				success: function(json){
					console.log(json.message+" is result ");
					if(json.message == 1){
													
					    window.location.href='api/item/downloads/items.xlsx?itemId='+itemId
					    Name;
					  
					}
					else if(json.message == 0){
						  $.dialog({
							  escapeKey: true, // close the modal when escape is pressed.
			                	backgroundDismiss: true,
						        icon : 'fa fa-frown-o',
						    	title: '',
						        content: 'No RED CALVIN washbasins Entries!',
						        boxWidth: '30%',
							    useBootstrap: false
						});    
						 
					}
				}
				});
		      $('#item').val('select');
	   }
	  else if(itemName==='WHITE CALVIN washbasins'){
		     console.log("itemtype value"+itemId);
		      $.ajax({
				async: false,
				url: 'getitemtype?itemId='+itemId, 
				success: function(json){
					console.log(json.message+" is result ");
					if(json.message == 1){
													
					    window.location.href='api/item/downloads/items.xlsx?itemId='+itemId;
					  
					}
					else if(json.message == 0){
						  $.dialog({
							  escapeKey: true, // close the modal when escape is pressed.
			                	backgroundDismiss: true,
						        icon : 'fa fa-frown-o',
						    	title: '',
						        content: 'No WHITE CALVIN washbasins Entries!',
						        boxWidth: '30%',
							    useBootstrap: false
						});    
						 
					}
				}
				});
		      $('#item').val('select');
	   }
	  else if(itemName==='Berger'){
		     console.log("itemtype value"+itemId);
		      $.ajax({
				async: false,
				url: 'getitemtype?itemId='+itemId, 
				success: function(json){
					console.log(json.message+" is result ");
					if(json.message == 1){
													
					    window.location.href='api/item/downloads/items.xlsx?itemId='+itemId;
					  
					}
					else if(json.message == 0){
						  $.dialog({
							  escapeKey: true, // close the modal when escape is pressed.
			                	backgroundDismiss: true,
						        icon : 'fa fa-frown-o',
						    	title: '',
						        content: 'No Berger Entries!',
						        boxWidth: '30%',
							    useBootstrap: false
						});    
						 
					}
				}
				});
		      $('#item').val('select');
	   }
	
	
	
	});
	
	
	
});