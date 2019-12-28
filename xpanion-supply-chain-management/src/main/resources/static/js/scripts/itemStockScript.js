/**
 * @author : ASHLIN ABRAHAM
 * @date : 20.07.2019
 * 
 */

   
var gstId = 0;
var catSubCatId = 0;
var additionalAttribute = '';
var additionalAttributeFlag = false;
var appendFlag = false;
var checkFlag = false;
var unitArray = [];
var categoryArray = [];
var hsnArray = [];
var manArray = [];
var subCatArray = [];
var editFlag = false;
var viewFlag = false;
var subCategoryId = 0;
var categoryId = 0;
var modalContent;
var newProId = 0;
var currentAttributeArray = new Array("COLOR","SIZE","HEIGHT","LENGTH","VOLUME","SHAPE","WEIGHT");


	

var catArrayFlag = false;
var catStatus = getCategories();
if(catStatus){

}else{
catStatus = getCategories();
}
getUnits();
getManufactures();




$.ajax({
    url : "gstCodes",
    type:'GET',
    dataType: 'json',
    success: function(json) {
        $.each(json.data,function(data){
            $("#gstPercentage").append('<option value=' + this.gstId + '>' + this.gst + '</option>');
        });
     }
});

function getCategories(){
	categoryArray = [];
	var jsonURL="categoryNames";
	$('#categoryForm').find('option') .remove();
	$('#categoryForm').append($("<option></option>").attr("value",'0').text('Choose Category'));
	   
	   $.getJSON(jsonURL, function(json) {
	   $.each(json.data, function(data) {  
	    if(this.categoryId == null || this.categoryName== null ){
	    console.log("null in cats");
	    return false;
	    }
	    else{
	    categoryArray.push({
	    categoryId:this.categoryId,
	    categoryName:this.categoryName
	    });

	      $('#categoryForm').append($("<option></option>").attr("value",this.categoryId).text(this.categoryName));
	       }
	    });
	   });


	return true;
	}


function getUnits(){
	unitArray = [];
	var jsonURL="units";
	$('#unitId').find('option') .remove();
	$('#unitId').append($("<option></option>").attr("value",'0').text('Choose Unit'));
	   
	   $.getJSON(jsonURL, function(json) {
	   $.each(json.data, function(data) {  
	    if(this.unitId == null || this.unitType == null){
	    console.log("null in units");
	    }else{
	   
	        $('#unitId').append($("<option></option>").attr("value",this.unitId).text(this.unitType));
	    }
	    unitArray.push({
	    unitId:this.unitId,
	    unitType:this.unitType
	    });
	     });  
	   });
	 

	}



function getManufactures(){
	manArray = [];
	var jsonURL="manNames";
	$('#manufacturerId').find('option') .remove();
	$('#manufacturerId').append($("<option></option>").attr("value",'0').text('Choose Manufacturer'));

	   $.getJSON(jsonURL, function(json) {
	   $.each(json.data, function(data) {  
	    if(this.manufacturerId  == null|| this.manufacturerName== null ){
	    flag = false;
	   
	    }else{
	    $('#manufacturerId').append($("<option></option>").attr("value",this.manufacturerId).text(this.manufacturerName));
	       }
	    manArray.push({
	    manufacturerId:this.manufacturerId,
	    manufacturerName: this.manufacturerName
	    });
	    });
	 
	   });

	}



function getSubCategories(categoryId){
	subCatArray = [];
	var jsonURL="subCategoryNames?categoryId="+categoryId;
	   $('#subCatForm').find('option') .remove();
	   $('#subCatForm').append($("<option></option>").attr("value",'0').text('Choose Sub Category'));
	       
	   $.getJSON(jsonURL, function(json) {
	   $.each(json.data, function(data) {  
	        $('#subCatForm').append($("<option></option>").attr("value",this.subCatId).text(this.subCatName));
	        subCatArray.push({
	        subCategoryId : this.subCatId,
	        subCatName : this.subCatName
	        });
	        if(editFlag){
	console.log("inside flag");
	$('#subCatForm').val(subCategoryId).delay(5000).trigger('change');

	}
	         });
	   });
	   return true;
	}


$('#categoryForm').on('change', function() {
	var categoryId = $('#categoryForm').find(":selected").val();
	if(categoryId > 0){
	getSubCategories(categoryId);

	}
	});

	$('#subCatForm').on('change', function() {
	var subCatId = $('#subCatForm').find(":selected").val();
	var catId = $('#categoryForm').find(":selected").val();
	if(subCatId > 0 && catId > 0){
	getcatSubCatDetails(subCatId,catId);
	}
	});

	//-----------------------FUNCTION TO GET CATEGORY-SUBCATEGORY DETAILS  ID---------------------------------------
	
	
	function getcatSubCatDetails(subCatId,catId){
	subCatId = $.trim(parseInt(subCatId));
	catId = $.trim(parseInt(catId));
	if(subCatId > 0 && catId > 0){
	$.ajax({
	        async: false,
	        url : "catSubCatDetailsId?categoryId="+catId+"&subcategoryId="+subCatId,
	        success:function(json) {
	        $.each( json.data, function( data ) {
	       
	        catSubCatId = this.catSubCatDetailsId;
	        //alert("catSubCatId"+catSubCatId);
	   
	            });
	           
	        },
	        error : function(){
	        $.alert("Unable to connect with server");
	        }
	   
	   });
	}

	}
	
	
	
	
	
	
		var mrp;
		var productId =0 ;
		var productGstId = 0;
		var activeStatus = 'Y';
		var catSubCategoryId;
		var productGst;
		var itemName;
		var stockThreshold;
		var openingSock;
		var unitsId;
		var mansId;
		var itemDesc;
		var color;
		var size;
		var height;
		var length;
		var weight;
		var shape;
		var volume;
		var flag ;
		var table;
		var additionalData = [];
		var finalAttributeData = [];
		var hsnCodeId = 0;

	
	
var table;
$ (document).ready(function(){
	console.log("script");
	getProductDetails();
	
	function getProductDetails(){
		 table = $('#itemTable')
		.DataTable(
				{
					"destroy" : true,
					"ajax" : "getProducts?productId=0",
					"language" : {
						"emptyTable" : "currently no data available...",
						"sLengthMenu" : "View_MENU_",

					},
					"width" : "100%",

					"bAutoWidth" : false,
					"scrollCollapse" : true,
					"bScrollCollapse" : true,
					"iDisplayLength" : 10,
					"fixedHeader" : {
						"header" : true
					},

					"order" : [ [ 1, "asc" ] ],
					"paging" : true,
					"sPaginationType" : "simple",
					select : {
						style : 'single'

					},
					dom : 'Bfrtip',
					'columnDefs' : [
							{
								'targets' : 0,
								'data' : "productId",
								"defaultContent" : "",
								className : "",
							},
							{

								'targets' : 1,
								'data' : "productDetailsId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false
							},
							{

								'targets' : 2,
								'data' : "unitId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 3,
								'data' : "manufacturerId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 4,
								'data' : "categoryId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 5,
								'data' : "subCatId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							
							{

								'targets' : 6,
								'data' : "gst",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 7,
								'data' : "openingStock",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 8,
								'data' : "stockThreshold",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							
							{

								'targets' : 9,
								'data' : "itemName",
								"defaultContent" : "",
								className : "",
								

							},
							{

								'targets' : 10,
								'data' : "mrp",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 

							},{

								'targets' : 11,
								'data' : "itemDescription",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},{

								'targets' : 12,
								'data' : "gstId",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 13,
								'data' : "color",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 14,
								'data' : "size",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 15,
								'data' : "length",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 16,
								'data' : "shape",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 17,
								'data' : "height",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 18,
								'data' : "weight",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 19,
								'data' : "volume",
								"defaultContent" : "",
								className : "",
								orderable: false,
								 searchable: false,
								 visible: false

							},
							{

								'targets' : 20,
								'data' : "additionalAttribute",
								"defaultContent" : "",
								className : "",
								 orderable: false,
								 searchable: false,
								 visible: false

							},
							
					
							{

								'targets' : 21,
								"defaultContent" : "",
								className : "",
								orderable: false,
								"render" : function(data,
										type, full, row) {
										data = '&nbsp;&nbsp;<i class="fa fa-eye productView" style="cursor:pointer;color:red;font-size:16px" title="View"></i>'
										return data;
								}
							}
							]
				});

	}
	
	getProductDetails();
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------//
	
	$ (document).ready(function(){
		var subCatAllArray = [];
		$.ajax({
		    async: false,
		    url : "allSubCategories",
		    success:function(json) {
		    	subCatAllArray = [];
		        $.each( json.data, function( data ) {
		        subCatAllArray.push({
		       		 subCatId :this.subCatId,
		       		 subCatName : this.subCatName
		       	 });  
		        });
		    },
		    error : function(){
		   	 $.alert("Unable to connect with server");
		    }

		});
	
	

	//---------------------------------------------END OF VALIDATION---------------------------------------------------

	var productViewId = 0;
	var eflag = false;





//------------------------------------------------ VIEW TABLE CLICKS----------------------------------------------------
		
    $('#itemTable tbody').on('click','.productView', function() {
		 console.log("subcat  p view"+JSON.stringify(subCatAllArray));
		 console.log("id "+productId);   
	  $("#attrDivModal").empty();
				viewFlag = true;
				checkFlag = false;
				var data = table.row($(this).parents('tr')).data();	
		    	productViewId = data.productId;
		    	
		    	 $("#itemMod").text(data.itemName);	
		    	 $("#descMod").text(data.itemDescription);
		    	 $(".gstMod").text(data.gst);
		    	 $(".hsnMod").text(data.hsnCode);
		    	
		    	 if(data.activeStatus == 'Y'){
		    		  $('#checkToActiveStatus').iCheck('check');
		    		 checkFlag = true;
		    			 
		    	}
		    	 else if(data.activeStatus == 'N'){
		    		 $('#checkToActiveStatus').iCheck('uncheck');
		    		 checkFlag = true;
		    	 }
		    	 
		    	
		    	 categoryId = data.categoryId;
		    	  $.each(categoryArray, function(key,value) {
		             if(this.categoryId == categoryId){
		            	 $(".categoryMod").text(this.categoryName);	
		            }
		             
		           });
		    	 $.each(manArray, function(key,value) {
		    		 if(this.manufacturerId == data.manufacturerId){
		            	 $(".manMod").text(this.manufacturerName);	
		            }
		             
		           });
		    	 $.each(unitArray, function(key,value) {
		             if(this.unitId == data.unitId){
		            	 $(".unitMod").text(this.unitType);	
		            }
		             
		           }); 
		    	 $.each(subCatAllArray, function(key,value) {
		             if(this.subCatId == data.subCatId){
		            	 $(".subCatMod").text(this.subCatName);	
		            }
		             
		           });
		    	 
		    	
		    	 if(data.color == ''){
		    		 console.log("no color");
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Color</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.color+"'></div></div>";
					   $("#attrDivModal").append(modalContent); 
		    	 
		    	 }
		    	 
		    	 if(data.size == ''){
		    		
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Size</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.size+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 if(data.shape == ''){
		    		
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Shape</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.shape+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 if(data.length == ''){
		    		
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Length</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.length+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 if(data.weight == ''){
		    		 console.log("no color");
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Weight</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.weight+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 if(data.height == ''){
		    		 
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Height</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.height+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 if(data.volume == ''){
		    		 
		    	 }else{
		    		var modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>Volume</label>"
					    +"<input type='text' class='form-control' id='colorID' value='"+data.volume+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent); 
		    	 }
		    	 
		    	 if((data.additionalAttribute == null)||(data.additionalAttribute == undefined)||(data.additionalAttribute == '')){
		 		 	console.log("do nothing");
		 		 	editFlag = false;
		 		 	viewFlag = true;
		 		 	$('#productData').modal('show');
		 		 	}
		 		 	else{
		 		 	additionalAttribute = '';
		 		 	additionalAttribute = data.additionalAttribute;
		 		 	additionalAttributeFlag = true;
		 		 	editFlag = false;
		 		 	viewFlag = true;
		 		 	splitData();
		 		 	$('#productData').modal('show');
		 		 	}
		    	 
		    	 
		      });
  //------------------------------------END OF VIEW----------------------------------------------------------------------------//  
    
    
    
   
    
    
		
		
	});
	
	
});
