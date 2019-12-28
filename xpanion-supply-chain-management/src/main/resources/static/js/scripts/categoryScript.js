/**
 * @author : ASHLIN ABRAHAM
 * @date : 25.07.2019
 * 
 */

//-----------------------------------------------------------------------------------------------------------------
$('#catEmptyMsgModal').hide();
$('#subCatEmptyMsgModal').hide();
$('#hsnCodeEmptyMsgModal').hide();
$('#gstPerEmptyMsgModal').hide();
$('#alreadyExistsMsg').hide();

var catId = 0;
var subCatId = 0;
var categoryName;
var subCatName;
var hsnCode;
var gst;
//-----------------------------------------------------------------------------------------------------------------
$("#catAdd").keyup(function(){
	if ( $("#catAdd").val().length > 0) {
		 $('#catEmptyMsgModal').hide();
		 
	 }
		
});
$("#subCatAdd").keyup(function(){
	if ( $("#subCatAdd").val().length > 0) {
		 $('#subCatEmptyMsgModal').hide();
		 $('#alreadyExistsMsg').hide();
		 
	 }
		
});
$ (document).ready(function(){
	 var categoryArray = [];
	 var subCatArray = [];
//-----------------------------------------GET AND SET CATEGORIES/ SUB ON SUGGESTION--------------------------------------
	 $.ajax({
         async: false,
         url : "categoryNames",
         success:function(json) {
        	 categoryArray = [];
             $.each( json.data, function( data ) {
            	 categoryArray.push({
            		 label : this.categoryName,
            		 value : this.categoryName,
            		 id : this.categoryId 
            	 });  
             });
             if(categoryArray != null){
               $('#catAdd').autocomplete({
            	        source: categoryArray
            	    });
            $( "#catAdd" ).autocomplete( "option", "appendTo", "#categoryModal" ); 
                
             }
         },
         error : function(){
        	 $.alert("Unable to connect with server");
         }
    
    });
//-------------------------AJAX CALL TO GET ALL SUB CATEGORIES----------------------------------------- 
	 $.ajax({
         async: false,
         url : "allSubCategories",
         success:function(json) {
        	 subCatArray = [];
             $.each( json.data, function( data ) {
            	 subCatArray.push({
            		 label : this.subCatName,
            		 value : this.subCatName,
            		 id : this.subCatId
            	 });  
             });
             if(subCatArray != null){
               $('#subCatAdd').autocomplete({
            	        source: subCatArray
            	    });
            $( "#subCatAdd" ).autocomplete( "option", "appendTo", "#categoryModal" ); 
                
             }
         },
         error : function(){
        	 $.alert("Unable to connect with server");
         }
    
    });
//--------------------------------------------END OF AJAX CALL---------------------------------------------------
	 
	 $("#catAdd").focus(function() {
	        console.log('in');
	    }).blur(function() { 
	    	var catVal = $("#catAdd").val();
	    	 $.each(categoryArray, function(key,value) {
	        	 if(catVal == this.label){
	        		 catId = this.id;
	        	 }
	        	 });
	    	 if(catId > 0 && subCatId > 0){
		    	   checkCatData(catId,subCatId); 
		       }
	    	 
	    });
//--------------------------------------------------------------------------------------------------------------	 
	 $("#subCatAdd").focus(function() {
	        console.log('in');
	    }).blur(function() { 
	    	console.log('in-out');
	    	var subCatVal = $("#subCatAdd").val();
	    	 $.each(subCatArray, function(key,value) {
	        	 if(subCatVal == this.label){
	        		 subCatId = this.id;
	        		 
	        	 }
	    	 });
	       
	       if(catId > 0 && subCatId > 0){
	    	   checkCatData(catId,subCatId); 
	       }
	       else{
	    		 alert("sub cat blur "+catId+" "+subCatId);
	    	 }
	        	
	    });
    
//------------------------------------------GET DETAILS ID USING CAT ID AND SUB CAT ID--------------------------------------------------- 
	function checkCatData(catId,subCatId){

        $.ajax({
            async : false,
            type : "get",
            url : "checkCatDet?categoryId=" + catId
                    + "&subCategoryId="+subCatId,
            success : function(json) {
                event.preventDefault();
                if(json.status == 'SUCCESS'){
             	   var data = json.message;
             	   data = $.trim(parseInt(data));
             	   if(data > 0){
             		   $('#alreadyExistsMsg').show();
             		  // alert("already exists "+data); 
             	   }else{
             		   $('#alreadyExistsMsg').hide();
             	   }
             	   
               	
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
//----------------------------------------------------------------------------------------------------------------

	 

	 
});
//----------------------------------------SUBMIT FORM--------------------------------------------------------------

function validateModal(flag){
	 flag = true;
	 categoryName = $("#catAdd").val();
	 subCatName = $("#subCatAdd").val();
	 if(categoryName == ''){
		 $('#catEmptyMsgModal').show();
		 
		  
		 flag = false;
		 
	 }
	 if(subCatName == ''){
		 $('#subCatEmptyMsgModal').show();
		
		 flag = false;
		 
	 }
	 if($("#alreadyExistsMsg").is(":visible")){
		 flag = false;
		 alert("visible");
	 }
	 return flag;
}

//-----------------------------------------------------SAVE CATEGORY DETAILS----------------------------------------
function saveCategoryDetails(){
	 var flag = validateModal(flag);
	 var catSubCatDetailsId = 0;
	 if(flag){
		alert("catId "+catId+" sub cat id "+subCatId+" categoryName "+categoryName+" subCatName "+subCatName);
	 
		 
        $.ajax({
            
            async : false,
            type : "get",
            url : "saveUpdateCats?catSubCatDetailsId="+catSubCatDetailsId
            		+ "&categoryId=" + catId
                    + "&subCategoryId="+subCatId
                    + "&categoryName=" + categoryName
                    + "&subCategoryName=" + subCatName
                    + "&activeStatus=Y",
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
	 
}
//----------------------------------------------END OF FUNCTION-----------------------------------------------