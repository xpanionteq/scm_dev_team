/**
 * @author: ASHLIN ABRAHAM
 * @date : 18.07.2019
 * 
 */
//------------------------------------------DECLARE VARIABLE------------------------------------------------------

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

//--------------------------------------------------------HIDE EMPTY MESSAGES--------------------------------------

$('#checkBoxDiv').hide();
$('#itemNameEmptyMsg').hide();


$('#mrpEmptyMsg').hide();
$('#descriptionEmptyMsg').hide();
$('#categoryFormEmptyMsg').hide();
$('#subCatFormEmptyMsg').hide();
$('#unitIdEmptyMsg').hide();
$('#manufacturerIdEmptyMsg').hide();
$('#gstPercentageEmptyMsg').hide();
$('#openingStockEmptyMsg').hide();
$('#hsnCodeEmptyMsg').hide();
$('#stockThresholdEmptyMsg').hide();

//-----------------------------------------------------------------------------------------------------------------
$('#newAttrNameEmptyMsg').hide();
$('#newAttrValueEmptyMsg').hide();
$('#newAttrNameAlready').hide();
//-------------------------------------------------------OPTIONS------------------------------------------------
var catArrayFlag = false;
var catStatus = getCategories();
if(catStatus){
	
}else{
	catStatus = getCategories();
}
getUnits();
getManufactures();

//------------------------------------------NEW ATTRIBUTE POP UP-----------------------------------------------
//------------------------------------------------------------------------------------------------------------
function form_submit() {
	  	var newAttributeName = $("#newAttribute").val();
		var newAttributeValue = $("#attributeValue").val();
		if(newAttributeName == ''){
			$('#newAttrNameEmptyMsg').show();
			
			
		}
		if(newAttributeValue == ''){
			$('#newAttrValueEmptyMsg').show();
			
		}
		var content = "<div class='col-md-3'><div class='form-group'><label for='man'>"+newAttributeName+"</label>"
      +"<input type='text' class='form-control' id='"+newAttributeName+"Id' value='"+newAttributeValue+"'></div></div>";
		var i;
		var flag = true;
		var newAttributeNames = newAttributeName.toUpperCase();
	
		for (i = 0; i < currentAttributeArray.length; ++i) {
			if(newAttributeNames == currentAttributeArray [i] ){
				$('#newAttrNameAlready').show();
				flag = false;
			}
		}
		if(flag == true){
			$("#addAttributeDiv").append(content);
			additionalAttribute = additionalAttribute + newAttributeName+'~'+newAttributeValue+'?';
			currentAttributeArray.push(newAttributeNames);
			 $('.close').trigger('click');
	  		//alert("additionalAttribute"+additionalAttribute);
		}
		
}  
//--------------------------------------------------ADD MORE ATTRIBUTES---------------------------------------------


$("#newAttribute").keyup(function(){
	 if ( $("#newAttribute").val().length > 0) {
		 $('#newAttrNameEmptyMsg').hide();
		 $('#newAttrNameAlready').hide();

		 
	 }
});
$("#attributeValue").keyup(function(){
	 if ( $("#attributeValue").val().length > 0) {
		 $('#newAttrValueEmptyMsg').hide();
		 
	 }
	 
});
//--------------------------------------------------------------------------------------------------------------
//-------------------------------------------------APPEND OPTIONS---METHOD 1-------------------------------------------
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
//--------------------------------------------GET AND SET DATA TO DROPDOWNS-----METHOD 2---------------------------------------


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
//----------------------------FUNCTION TO GET UNITS INTO SELECT------------------------------------------------

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

//--------------------------------------END OF FUNCTION---------------------------------------------------------
//-------------------------FUNCTION TO GET MANUFACTURERS DETAILS-------------------------------------------------

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

//--------------------------------------------END OF MAN FUNCTION---------------------------------------
//----------------------FUNCTION TO GET SUB CATEGORIES OF A CATEGORY---------------------------------------------


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
	subCatId =	$.trim(parseInt(subCatId));
	catId =	$.trim(parseInt(catId));
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
//-----------------------END OF FUNCTION TO GET CATEGORY-SUBCATEGORY DETAILS  ID---------------------------------------

//-------------------------------------------------------------------------------------------------------------------
$("#mrp").keyup(function(){
	 if ( $("#mrp").val().length > 0) {
		 $('#mrpEmptyMsg').hide();
		 
	 }
});
$("#itemName").keyup(function(){
	 if ( $("#itemName").val().length > 0) {
		 $('#itemNameEmptyMsg').hide();
		 
	 }
});
$("#description").keyup(function(){
	 if ( $("#description").val().length > 0) {
		 $('#descriptionEmptyMsg').hide();
		 
	 }
});
$("#gstPercentage").keyup(function(){
	 if ( $("#gstPercentage").val().length > 0) {
		 $('#gstPercentageEmptyMsg').hide();
		 
	 }
});
$("#openingStock").keyup(function(){
	 if ( $("#openingStock").val().length > 0) {
		 $('#openingStockEmptyMsg').hide();
		 
	 }
});
$("#stockThreshold").keyup(function(){
	 if ( $("#stockThreshold").val().length > 0) {
		 $('#stockThresholdEmptyMsg').hide();
		 
	 }
});
$("#hsnCode").keyup(function(){
	 if ( $("#hsnCode").val().length > 0) {
		 $('#hsnCodeEmptyMsg').hide();

		 
	 }
});

$('#subCatForm').on('change', function() {
	 $('#subCatFormEmptyMsg').hide();
	 
	 
	});
$('#unitId').on('change', function() {
	 $('#unitIdEmptyMsg').hide();
	});
$('#categoryForm').on('change', function() {
	 $('#categoryFormEmptyMsg').hide();
	});
$('#manufacturerId').on('change', function() {
	 $('#manufacturerIdEmptyMsg').hide();
	});
$('#gstPercentage').on('change', function() {
	 $('#gstPercentageEmptyMsg').hide();
	});
//------------------------------------------------------------------------------------------------------------------

var mrp;
var productId = 0 ;
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

//-------------------------------------------SET PRODUCT LIST ON THE TABLE----------------------------------------
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
							'data' : "unitType",
							"defaultContent" : "",
							className : "",
							orderable: false,
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 4,
							'data' : "manufacturerId",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 5,
							'data' : "manufacturerName",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 6,
							'data' : "categoryId",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 7,
							'data' : "categoryName",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 8,
							'data' : "subCatId",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 9,
							'data' : "subCatName",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 10,
							'data' : "gstId",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						
						
						{

							'targets' : 11,
							'data' : "gst",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 12,
							'data' : "catSubCatDetailsId",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 13,
							'data' : "hsnCode",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 14,
							'data' : "openingStock",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 15,
							'data' : "stockThreshold",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 16,
							'data' : "mrp",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 17,
							'data' : "itemName",
							"defaultContent" : "",
							className : "",
							

						},{

							'targets' : 18,
							'data' : "itemDescription",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 19,
							'data' : "color",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 20,
							'data' : "size",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 21,
							'data' : "length",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 22,
							'data' : "shape",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 23,
							'data' : "height",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 24,
							'data' : "weight",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 25,
							'data' : "volume",
							"defaultContent" : "",
							className : "",
							orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 26,
							'data' : "additionalAttribute",
							"defaultContent" : "",
							className : "",
							 orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 27,
							'data' : "activeStatus",
							"defaultContent" : "",
							className : "",
							 orderable: false,
							 searchable: false,
							 visible: false

						},
						{

							'targets' : 28,
							 "width": "20%",
							"defaultContent" : "",
							className : "",
							orderable: false,
							"render" : function(data,
									type, full, row) {
									data = '&nbsp;&nbsp;<i class="fa fa-pencil-square productEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-eye productView" style="cursor:pointer;color:black;font-size:14px" title="View"></i>'
									return data;
							}
						}
						]
			});

}
getProductDetails();
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
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
//----------------------------------------------COLLECT DATA TO EDIT-----------------------------------------------

	function splitData(){
		
		if(additionalAttributeFlag){
			var seperatedAttribute;
			var singleAttribute = additionalAttribute.split('?');
			additionalData = [];
			finalAttributeData = [];
			singleAttribute.forEach(function(obj){
				additionalData.push(obj);
			});
			console.log(additionalData);
			
			
			for (var i=0;i<additionalData.length;i++){
			  seperatedAttribute = '';
			  seperatedAttribute = 	additionalData[i];
			 if((seperatedAttribute == '')||(seperatedAttribute == null)){
				 console.log("leave it")
			 }else{
				 
				 finalAttributeArray = seperatedAttribute.split('~');
				 for (var j=0;j<1;j++){
					 finalAttributeData.push({
						attributeName : finalAttributeArray[0],
						attributeValue : finalAttributeArray[1]
					 });
				 }
				 appendFlag = true;
				 }
			 }
			
			}
		if(appendFlag){
			console.log("finalAttributeData inside append "+JSON.stringify(finalAttributeData));
			modalContent = '';
			 $.each(finalAttributeData, function(key,value) {
				 if(editFlag){
					 var content = "<div class='col-md-3'><div class='form-group'><label for='man'>"+this.attributeName+"</label>"
					    +"<input type='text' class='form-control' id='"+this.attributeName+"ID' value='"+this.attributeValue+"'></div></div>";
					 $("#addAttributeDiv").append(content);
					 var up = this.attributeName;
					 up = up.toUpperCase();
					 currentAttributeArray.push(up);
				 }
				
				 if(viewFlag){
					 modalContent = "<div class='col-md-3'><div class='form-group'><label for='man'>"+this.attributeName+"</label>"
					    +"<input type='text' class='form-control' id='"+this.attributeName+"ID' value='"+this.attributeValue+"'></div></div>";
					 
					 $("#attrDivModal").append(modalContent);
					  
			    	 
				 }
				 
				 
					
		       }); 
				
				
		}

		
	}
//------------------------------------FUNCTION SPLITDATA() ENDS-------------------------------------------------------------
	
	var Contain = "";
	var label = "";
    $("#gstPercentage").numeric();
    $("#hsnCode").numeric();
	$('#mrp').numeric();
	$('#openingStock').numeric();
	$('#stockThreshold').numeric();
//-----------------------------------USED TO SAVE SAME PRODUCT DETAILS AS NEW PRODUCT----------------------------
	 $('#saveAsNewCheck').on('ifChecked', function(event){
		 newProId = productId;
		 //alert(productId);
		  productId = 0;
		  
		});
	 $('#saveAsNewCheck').on('ifUnchecked', function(event){
		  productId = newProId;
		  //alert("productId "+productId);
		  
		});
//------------------------SUBMIT STARTS FROM SUBMIT BUTTON CLICK-------------------------------------------------
	$("#productSubmitButton").click(function(){
		Contain = "";
		label = "";
		 $("#addAttributeDiv :text").each(function(){
		        Contain += $(this).parent().find('label').text()+"~"+$(this).val() + "?";
		        additionalAttribute = Contain;
		    });
		
		var flag = validateProductForm();
		//alert(flag);
				 
			 
//---------------------------------------MAKE AJAX CALL TO SAVE DATA------------------------------------------------		 
		
		 if(flag){
			 
		 //alert("productId"+productId+" gst id "+gstId);
         $.ajax({
             
             async : false,
             type : "get",
             url : "saveProducts?productId=" + productId
                     + "&manufacturerId="+mansId
                     + "&unitId=" + unitsId
                     + "&itemName=" + itemName
                     + "&itemDescription=" + itemDesc
                     + "&productGstId=" + gstId
                     + "&catSubCatId=" + catSubCatId
                     + "&hsnCode=" +hsnCode
                     + "&mrp=" + mrp 
                     + "&stockThreshold="+ stockThreshold
                     + "&openingStock="+openingStock
                     + "&color="+color
                     + "&size="+size
                     + "&length=" +length
                     + "&volume="+volume
                     + "&weight="+weight
                     + "&height="+height
                     + "&shape="+shape
                     + "&additionalAttributes="+additionalAttribute
                     + "&activeStatus="+activeStatus,
             success : function(json) {
                 event.preventDefault();
                 if(json.status == 'SUCCESS'){
                	 $.alert({
                	    	escapeKey: true, // close the modal when escape is pressed.
                	    	backgroundDismiss: true,
                	        icon : 'fa fa-smile-o',
                	        title: 'Success!',
                	        content: 'Successfully completed',
                	        boxWidth: '30%',
                	        useBootstrap: false,
                	        onClose: function () {
                	             window.location.href="/products";
                	        }
                	    });
                 }
                 else{
                     event.preventDefault();
                     $.alert({
                     	escapeKey: true, // close the modal when escape is pressed.
                     	backgroundDismiss: true,
                         icon : 'fa fa-frown-o',
                         title: 'Error!',
                         content: 'Error occured. Try again!',
                         boxWidth: '30%',
                         useBootstrap: false,
                        
                     });
                 
                 }
             },
             error : function(json){
                 event.preventDefault();
                 $.alert({
                 	escapeKey: true, // close the modal when escape is pressed.
                 	backgroundDismiss: true,
                     icon : 'fa fa-frown-o',
                     title: 'Error!',
                     content: 'Error occured. Try again!',
                     boxWidth: '30%',
                     useBootstrap: false,
                    
                 });
             }
         });
		 }
		
	});
//-----------------------------------------END OF SUBMIT BUTTON------------------------------------------------------	
//--------------------------------FUNCTION TO VALIDATE PRODUCT FORM------------------------------------------------
	function validateProductForm(){
		flag = true;
		itemName = $("#itemName").val();
		mrp = $('#mrp').val();
		itemDesc  = $('#description').val();
		gstId = $('#gstPercentage').find(":selected").val(); 
		unitsId = $('#unitId').find(":selected").val(); 
		mansId = $('#manufacturerId').find(":selected").val(); 
		subCategoryId = $('#subCatForm').find(":selected").val(); 
		categoryId = $('#categoryForm').find(":selected").val(); 
		openingStock = $('#openingStock').val();
		stockThreshold = $('#stockThreshold').val();
		hsnCode = $('#hsnCode').val();
		if(hsnCode == ''){
			$('#hsnCodeEmptyMsg').show();
			flag = false;
		 }
		if(itemName == ''){
			$('#itemNameEmptyMsg').show();
			flag = false;
		 }
		if(mrp == ''){
			$('#mrpEmptyMsg').show();
			flag = false;
		 }
		if(itemDesc == ''){
			$('#descriptionEmptyMsg').show();
			flag = false;
		 }
		
		if(openingStock == ''){
			$('#openingStockEmptyMsg').show();
			flag = false;
		 }
		 if(stockThreshold == ''){
			 $('#stockThresholdEmptyMsg').show();
			 flag = false;

		 }
		 if(gstId == 0 || gstId == undefined ){
				$('#gstPercentageEmptyMsg').show();
				flag = false;
				 
			 }
		 if(mansId == undefined || mansId == 0){
			 
			 $('#manufacturerIdEmptyMsg').show();
			 flag = false;

		 }
		 if(unitsId == undefined || unitsId == 0){
			 $('#unitIdEmptyMsg').show();
			 flag = false;
		 }
		 if(categoryId == undefined || categoryId == 0){
			 
			 $('#categoryFormEmptyMsg').show();
			 flag = false;

		 }
		 if(subCategoryId == undefined || subCategoryId == 0){
			 $('#subCatFormEmptyMsg').show();
			 flag = false;
		 }
		
		
		
		 color = $("#color").val();
		 size = $("#size").val();
		 height = $("#height").val();
		 length = $("#length").val();
		 weight = $("#weight").val();
		 shape = $("#shape").val();
		 volume = $("#volume").val();
		 
		
		 
		
		 productId =  $.trim(parseInt(productId));
		 mansId =  $.trim(parseInt(mansId));
		 unitsId =  $.trim(parseInt(unitsId));
		 gstId =  $.trim(parseInt(gstId));
		 catSubCatId = $.trim(parseInt(catSubCatId));
		 hsnCode = $.trim(parseInt(hsnCode));
		 
		 return flag;

	}
//---------------------------------------------END OF VALIDATION---------------------------------------------------	
	
var productViewId = 0;
var eflag = false;
//------------------------------------------------EDIT / VIEW TABLE CLICKS----------------------------------------------------
	$('#itemTable tbody').on('click','.productView', function() {

		 console.log("subcat  p view"+JSON.stringify(subCatAllArray));

			$("#attrDivModal").empty();
			viewFlag = true;
			checkFlag = false;
			var data = table.row($(this).parents('tr')).data();	
	    	productViewId = data.productId;
	    	 $("#itemMod").text(data.itemName);	
	    	 $("#descMod").text(data.itemDescription);
	    	 $(".gstMod").text(data.gst);
	    	 $(".hsnMod").text(data.hsnCode);
	    	// $('#checkToActiveStatus').iCheck('uncheck');
	    	 if(data.activeStatus == 'Y'){
	    		 
	    		 $('#checkToActiveStatus').iCheck('check');
	    		 checkFlag = true;
	    			 
	    		 
	    		
	    		 
	    	 }else if(data.activeStatus == 'N'){
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
//-------------------------------------------EDIT PRODUCT--------------------------------------------------------
	$('#itemTable tbody').on('click','.productEdit', function() {
		
		$('#checkBoxDiv').show();
		$("#addAttributeDiv").empty();
		
    	var data = table.row($(this).parents('tr')).data();	
    	productId = data.productId;
    	
    	gstId = data.gstId;
    	
    	$("#itemName").val(data.itemName);
		$('#mrp').val(data.mrp);
		$('#description').val(data.itemDescription);
		editFlag = true;
		subCategoryId = data.subCatId;
		$("#categoryForm").val(data.categoryId).trigger('change');
		$('#unitId').val(data.unitId).trigger('change');
		$("#manufacturerId").val(data.manufacturerId).trigger('change');
		$('#gstPercentage').val(data.gstId).trigger('change');
		var len = $('#subCatForm').length;
		console.log("before "+len);
		
		
		$('#hsnCode').val(data.hsnCode);
		$('#openingStock').val(data.openingStock);
		$('#stockThreshold').val(data.stockThreshold);
		$("#color").val(data.color);
		$("#size").val(data.size);
		 	$("#height").val(data.height);
		 	$("#length").val(data.length);
		 	$("#weight").val(data.weight);
		 	$("#shape").val(data.shape);
		 	$("#volume").val(data.volume);
		 	
		 	if((data.additionalAttribute == null)||(data.additionalAttribute == undefined)||(data.additionalAttribute == '')){
		 	console.log("do nothing");
		 	}
		 	else{
		 	additionalAttribute = data.additionalAttribute;
		 	additionalAttributeFlag = true;
		 	viewFlag = false;
		 	splitData();
		 	}
		 	
    	
    	
    });
 
//------------------------------------------------END OF TABLE CLICKS---------------------------------------------------------

//------------------------------------------------ACTIVE/INACTIVE PRODUCTS----------------------------------------
function inactivateProduct(productViewId){
	$.confirm({
	    title: 'Confirm!',
	    content: 'Are you sure to inactivate product?',
	    buttons: {
	        confirm: function () {
	        	 var status = 'N';
	             activeInactiveProduct(status,productViewId);
	        },
	        cancel: function () {
	        	
	        }
	    }
	});
}

function activateProduct(productViewId){
	$.confirm({
	    title: 'Confirm!',
	    content: 'Are you sure to activate product?',
	    buttons: {
	        confirm: function () {
	        	 var status = 'I';
	             activeInactiveProduct(status,productViewId);
	        },
	        cancel: function () {
	        	
	            
	        }
	    }
	});
}


function activeInactiveProduct(status,productViewId){
	 $.ajax({
         
         async : false,
         type : "get",
         url : "saveProducts?productId=" + productViewId
                     + "&manufacturerId=0"
                     + "&unitId=0"
                     + "&itemName=null"
                     + "&itemDescription=0"
                     + "&productGstId=0"
                     + "&catSubCatId=0"
                     + "&hsnCode=0"
                     + "&mrp=0"
                     + "&stockThreshold=0"
                     + "&openingStock=0"
                     + "&color=null"
                     + "&size=null"
                     + "&length=null"
                     + "&volume=null"
                     + "&weight=null"
                     + "&height=null"
                     + "&shape=null"
                     + "&additionalAttributes=null"
                     + "&activeStatus="+status,
         success : function(json) {
             event.preventDefault();
             if(json.status == 'SUCCESS'){
            	 $.alert({
            	    	escapeKey: true, // close the modal when escape is pressed.
            	    	backgroundDismiss: true,
            	        icon : 'fa fa-smile-o',
            	        title: 'Success!',
            	        content: 'Successfully completed',
            	        boxWidth: '30%',
            	        useBootstrap: false,
            	        onClose: function () {
            	        	getProductDetails();
            	        }
            	    });
             }
             else{
                 event.preventDefault();
                 $.alert({
                 	escapeKey: true, // close the modal when escape is pressed.
                 	backgroundDismiss: true,
                     icon : 'fa fa-frown-o',
                     title: 'Error!',
                     content: 'Error occured. Try again!',
                     boxWidth: '30%',
                     useBootstrap: false,
                    
                 });
             
             }
         },
         error : function(json){
             event.preventDefault();
             $.alert({
             	escapeKey: true, // close the modal when escape is pressed.
             	backgroundDismiss: true,
                 icon : 'fa fa-frown-o',
                 title: 'Error!',
                 content: 'Error occured. Try again!',
                 boxWidth: '30%',
                 useBootstrap: false,
                
             });
         }
     });
	
}


$('#checkToActiveStatus').on('ifUnchecked', function(event){
	if(checkFlag){
		inactivateProduct(productViewId);
	}
	  
	  
	});
$('#checkToActiveStatus').on('ifChecked', function(event){
	if(checkFlag){
	 activateProduct(productViewId);
	}
	});

//----------------------------------------------------------------------------------------------------------------

});


//----------------------------------------------------------------------------------------------------------------




