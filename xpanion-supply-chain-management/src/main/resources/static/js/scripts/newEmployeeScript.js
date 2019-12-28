/**
 * @author:ASWATHY RAJ.D
 * @date:06-04-2019
 */
$(document).ready(function() {
	var formData = new FormData();
	var fEmployeeId;
    var empId;
	var eIdInt;
	var employeeId;
	var id=0;
	var employeeFirstName;
	var employeeLastName;
	var dateOfBirth;
	//var employeeAge;
	var mobileNumber;
	var email;
	var employeeAddress;
	var genderTypeId;
	var genderType;
	var joiningDate;
	var designationTypeId;
	var designationType;
	var qualificationTypeId;
	var qualificationType;
	var qualificationId;
	var other_qualification;
	var experience;
	var qualificationDetId=0;
	var loginId;
	var userTypeId;
	var userType;
	var userName;
	var userPassword;
	var confirmPassword;
	//var age;//
	//var qualificationId;
	var flag = false;
	var nameFlag = false;
	var namesArray = [];
	var LastNamesArray=[];
	var idArray=[];
	var editFlag = 'false';
	
	var k;
	var v;
	var d;
	var userId
	var qualificationTypeArray=[]; 
	var qualificationArray=[];

    $('#minusButton').trigger('click');
    
//------------------------------------------------TODAY DATE-------------------------------------------------------------	
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    console.log("today " + today);
    var myday = dd+'-'+mm+'-'+yyyy;
    
    $("label[for='todaysDate']").text(myday);
    var i = 0;
//-------------------------------------------------------------------------------------------------------------------------------    

       
    	
    
//---------------------------------------------------VALIDATION---------------------------------------------------------------------
	/*
	 * Email validation
	 */
	
	function filterEmail(email) {
        var regex = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
        return regex.test(email);
    }
	$('#email').focus(function(){
		console.log('in');
	}).blur(function(){
		email = $('#email').val();
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
                    	$('#email').focus();
                    }
                });
			}
		}
	});
//-------------------------------------------------------------------------------------------------------------	
	/*
	 *  Mobile number validation
	 *
	 */
	function filterMobileNumber(mobileNumber) {
	    var regex = new RegExp(/^[0][1-9]\d{9}$|^[1-9]\d{9}$/g);
	    return regex.test(mobileNumber);
	}

	$("#mobileNumber").focus(function(){
		
	}).blur(function(){
		mobileNumber = $("#mobileNumber").val();
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
	                	$('#mobileNumber').focus();
	                }
	            });
			}
		}
	});

//------------------------------------------------------------------------------------------------------------------------------
	   /* function getEmployeePrimaryDetails(){
	    	$("#employeeId").val(employeeId);
	        $("label[for='employeeId']").text("Employee ID:"+employeeId);
	        $('#employeeId').prop('readonly', true);
	        	$('#userName').hide();
	        	$('#userPassword').hide();
	        	$('#confirmPassword').hide();
	        	$("label[for='userName']").hide();
	        	$("label[for='userPassword']").hide();
	        	$("label[for='confirmPassword']").hide();
	        	
	    	 var empId= $("#employeeId").text();
	    	 var eIdn = empId.replace("Employee ID:", '');
	    	console.log("empID"+eIdn);
	    	$.ajax({
	            async: false,
	            url: "getSingleEmpDet?employeeId="+eIdn,
	            success : function(json){
	                if(json.status == 'SUCCESS'){
	                    $.each( json.data, function( data ) {
	                           $("#firstName").val(this.employeeFirstName);
	                           $("#lastName").val(this.employeeLastName);
	                           $("#email").val(this.email);
	                           $("#mobileNumber").val(this.mobileNumber);
	                           $("label[for='age']").text(this.employeeAge).hide();
	                           console.log("empl age"+this.employeeAge);
	                           $("#BirthDate").val(this.dateOfBirth);
	                           $("#JoiningDate").val(this.joiningDate);
	                           if( c == this.genderTypeId ){
	                        	   $("#radio_3").prop("checked",true);  
	                           }else if(v == this.genderTypeId){
	                        	   $("#radio_4").prop("checked",true);
	                           }else if(d == this.genderTypeId){
	                        	   $("#radio_5").prop("checked",true);  
	                           }
	                           console.log(this.designationType);
	                           $("#designation").val(this. designationTypeId).trigger('change');
	                           $("#emploeeAddress").val(this.employeeAddress);
	                           loginId=this.loginId;
	                           console.log("login id:"+loginId);
	                           $("#userName").val(this.userName);
	                   		   $("#userPassword").val(this.userPassword);
	                   	    	if(this.userType == 'user'){
		                    	  editFlag ='true'; 
		                    	 
		                        }else if(this.userType == 'admin'){
		                    	  editFlag ='false';
		                    	 
		                        }
		                        
	                         }); 
	                      getEmployeeDetails(); 
	                      
	                }
	            }
	        });
	    }
//--------------------------------------------------------------------------------------------------------------------
	
	    function getEmployeeDetails(){
	    	
	    	empId = $("#employeeId").text();
	    	var eIdn = empId.replace("Employee ID:", '');
	    	console.log("employeeID"+empId);
	        console.log("getEmployeeDetails() "+eIdn);
	        
	        if (eIdn == null || eIdn == undefined){
	            console.log("no empId")
	        }else{
	        
	         $.ajax({
	             async: false,
	             url: "getSingleEmpQualDet?employeeId="+eIdn ,
	               success: function(json){
	                   if(json.status == 'SUCCESS' && json.message == 'found'){
	                	  
	                   $.each( json.data, function( data ) {
	                	    qualificationId=this.qualificationId;
	                	    console.log("qual id"+qualificationId);
	                	 //$('#Qualification').find('option:selected').text(this.qualificationType);
	                
	                    	console.log("qualification type"+this.qualificationTypeId);
	                    	var qualification=this. qualificationTypeId;
	                    	$("#Qualification").val(this. qualificationTypeId).trigger('change');
                         	$("#otherQualification").val(this.otherQualification);
	          			    $("#experience").val(this.experience);
	          			    
	                   });
	                   }
	                   
	                },
	                error: function(){
	                    alert("error occured");
	                }
	              });
	        }
	
	    }*/
//----------------------------------------------------------END------------------------------------------------------------------------------
//----------------------------------------------LOAD AND PUT GENDER TYPES TO RADIO BUTTON----------------------------------------
	
	$.ajax({
	    async: false,
	    url : "getGenderType",
	    success:function(json) {
	        $.each( json.data, function( data ) {
	        	if(this.genderType == 'Male'){
		            $("#radio_6").val(this.genderTypeId);
		             k = this.genderTypeId;
		             }
	            else if(this.genderType == 'Female'){
	                 $("#radio_4").val(this.genderTypeId);
	                 v = this.genderTypeId;
	                }
	             else if(this.genderType=='Other'){
	            	$("#radio_5").val(this.genderTypeId); 
	        	     d=this.genderTypeId;
	             }
	        	 
	        });
	    },
	    error: function(){
	    	console.log('unable to load data');
	    }
	    });
	
	
//-------------------------------------------------END OF RADIO BUTTON------------------------------------------------------------
//----------------------------------------------------Start Designation Type--------------------------------------------------	  
	
	$.ajax({
		async:false,
		url  :"getDesignationType",
		success:function(json){
		   
		               $.each(json.data, function(data) {  
		              console.log("in designation"+this.designationTypeId);
		                $('#designation').append($("<option></option>").attr("value",this.designationTypeId).text(this.designationType));
		               });
		}
		    });
	
//--------------------------------------------------End Designation type-----------------------------------------	
//------------------------------------------------Qualification type--------------------------------------------
	$.ajax({
		async:false,
		url  :"getQualificationType",
		success:function(json){
		   
		$.each(json.data, function(data) {  
		console.log("in qualification"+this.qualificationId);
		$('#Qualification').append($("<option></option>").attr("value",this.qualificationId).text(this.qualificationType));
		              });
		}
		   }); 


	
    
//--------------------------------------------------End----------------------------------------------------------------
//----------------------------------------------EMPLOYEE FIRST NAMES--------------------------------------------------------------
   /* $.ajax({
        async: false,
        url : "getEmployeeFirstNames",
        success:function(json) {
            $.each( json.data, function( data ) {
                namesArray.push(this.employeeFirstName);  
                //console.log("First Names"+this.employeeFirstName);
            });
            if(namesArray != null){
                
                $('#firstName').autocomplete({ 
                       lookupLimit: 5,  
                       source : namesArray,
                       onSelect: function (suggestion) {
                           $('#firstName').val(suggestion.data);
                       }
                   });
       
                console.log("ID array "+JSON.stringify(idArray));
               
            }
            else{
                alert("unable to load data");
               }
        }
   
   }); 
//--------------------------------------------------------------------------------------------------------------------
  //----------------------------------------------EMPLOYEE FIRST NAMES--------------------------------------------------------------
    $.ajax({
        async: false,
        url : "getEmployeeLastNames",
        success:function(json) {
            $.each( json.data, function( data ) {
                namesArray.push(this.employeeLastName);  
               // console.log("lastName "+this.employeeLastName);
            });
            if(namesArray != null){
                
                $('#lastName').autocomplete({ 
                       lookupLimit: 5,  
                       source : namesArray,
                       onSelect: function (suggestion) {
                           $('#lastName').val(suggestion.data);
                       }
                   });
       
                console.log("ID array "+JSON.stringify(idArray));
               
            }
            else{
                alert("unable to load data");
               }
        }
   
   }); 
//----------------------------------------------------------------------------------------------------------------
    
//------------------------------------------Find Age From Date of Birth----------------------------------------------- 
    $('#BirthDate').click(function(){
    		console.log("in");
    	}).blur(function(){
    	 var DOB=$('#BirthDate').val();
    	
    	 console.log("dob"+DOB)
    	function getAge(DOB) {
    	    var today = new Date();
    	    var birthDate = new Date(DOB);
    	    var age = today.getFullYear() - birthDate.getFullYear();
    	    var m = today.getMonth() - birthDate.getMonth();
    	    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
    	        age = age - 1;
    	    }
    	  return age; 
    	 }

    	 employeeAge=getAge(DOB);
    	 console.log("age is"+employeeAge);
    	 $("label[for='age']").text(employeeAge).hide();
    	});
//---------------------------------------------End--------------------------------------------------------------------------
    $('#userName').change(function(){
    	    var uname = $('#userName').val();
   		    $(this).val($(this).val().toLowerCase());
    });*/
//---------------------------------------------FILL ALL FIELDS--------------------------------------------------------------------
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
		employeeFirstName = $('#firstName').val();
		console.log(employeeFirstName);
		employeeLastName = $('#lastName').val();
		console.log(employeeLastName);
		email = $('#email').val();
		console.log("email is"+email);
		mobileNumber=$('#mobileNumber').val();
		console.log("mobile"+mobileNumber);
		joiningDate=$('#JoiningDate').val();
		console.log("joiningDate"+joiningDate);
		dateOfBirth = $('#BirthDate').val();
		console.log(dateOfBirth);
		genderTypeId = $("input[name='group1']:checked").val();
		console.log("gender is"+genderTypeId);
		employeeAddress=$('#emploeeAddress').val();
		console.log("address"+employeeAddress);
		designationTypeId=$('#designation option:selected').val();
		console.log("designationTypeId is"+designationTypeId);
		designationType=$('#designation option:selected').val();
		console.log("designationType is"+designationType);
		userName=$('#userName').val();
		console.log("username is",+userName);
		userPassword=$('#userPassword').val();
		qualificationTypeId=$('#Qualification option:selected').val();
		console.log("qualificationTypeId is" +qualificationTypeId);
		qualificationType=$('#Qualification option:selected').val();
		console.log("qualificationType is" +qualificationType);
		other_qualification=$('#otherQualification').val();
		console.log(other_qualification);
		//qualificationId=$('#Qualification option:selected').val();
		//console.log("qualificationId"+qualificationId);
		
		experience=$('#experience').val();
		console.log("experience"+experience);
		
		
		if(firstName == ''){
				document.body.scrollTop = 0;
			  	document.documentElement.scrollTop = 0;
			  	$('#firstName').focus();
			  	displayMessage();
			
		}else if(lastName == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#lastName').focus();
		  	displayMessage();
			
		}else if(dateOfBirth == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#BirthDate').focus();
		  	displayMessage();
			
		}else if(email == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#email').focus();
		  	displayMessage();
		}else if(mobileNumber == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	$('#mobileNumber').focus();
		  	displayMessage();
		}else if(genderTypeId == ''){
			document.body.scrollTop = 0;
		  	document.documentElement.scrollTop = 0;
		  	/*$.dialog({
		  		icon : 'fa fa-exclamation-circle',
		  		title: 'Warning!',
		  		content: 'Please select gender type',
		  		boxWidth: '30%',
		  		useBootstrap: false,
		  	});*/
		  	
		}else if(JoiningDate == ''){
			$('#JoiningDate').focus();
			displayMessage();
		}else if(designationTypeId == ''){
			
			$('#designation').focus();
			displayMessage();
		}else if(emploeeAddress == ''){
			$('#emploeeAddress').focus();
			displayMessage();
		}else if(other_qualification == ''){
			 $("#otherQualification").val('Nil');
			 other_qualification = 'Nil';
            
		}else if(qualificationTypeId == ''){
			$('#Qualification').focus();
			displayMessage();
		
		}else if(qualificationType == ''){
			$('#Qualification').focus();
			displayMessage();
		}else if(userName == '' && fEmployeeId == 0 ){
			$('#userName').focus();
			displayMessage();
		}else if(userPassword == '' && fEmployeeId == 0){
			$('#userPassword').focus();
			displayMessage();
		}
		else if(experience == ''){
			$('#experience').val('Nil');
			experience='Nil';
			//console.log(experience);
		 }
		//console.log("qualification id"+QualificationTypeId);
		//if(qualificationId==null){
			//qualificationId=0;
			//qualificationArray.push({
			   //qualificationId : id,
			   // qualificationTypeId : QualificationTypeId,
			   // otherQualification : other_qualification,
			    //experience : experience,
				//});
			//console.log('data okey');
			//flag = true;
			//console.log("array  "+JSON.stringify(qualificationArray));
		 
		//}
		//else{
				//qualificationId=0;
		qualificationArray.push({
			    qualificationDetId : qualificationDetId,
			    //qualificationTypeId : qualificationTypeId,
			    qualificationType : qualificationType,
			    otherQualification : other_qualification,
			    experience : experience,
				});
			console.log('data ok');
			flag = true;
			console.log("array elements "+JSON.stringify(qualificationArray));
		 
		
   // }
	}
		
	
	
	
	
//---------------------------------------------END FILL---------------------------------------------------------------------------
	$('#userPassword, #confirmPassword').on('keyup', function () {
		  if($('.Password').val() == '' || $('.conformPassword').val() == ''){
			  $('#message').html('');
		  }
		  else if ($('.Password').val() == $('.conformPassword').val()) {
		    $('#message').html('Matching').css('color', 'green');
		  } else 
		    $('#message').html('Not Matching').css('color', 'red');
		});
	
//-----------------------------------------------------------employee edit---------------------------------------------------------------------
	
	empId = location.search.split('employeeId=')[1];
	window.history.replaceState({}, document.title, "/" + "#");
	console.log("employee id="+empId);
	if(empId > 0 && empId !=null){
	IdInt = $.trim(parseInt(empId));
	$('label[for="employeeId"]').css("display","inline-block");
	$("employeeId").css("display","inline-block");
	$("employeeId").val(IdInt);
	$("employeeId").prop('readonly',true);
	getemployee();
	   }
	function getemployee(){
	var c = $("#employeeId").val();
	$.ajax({
	async: false,
	url:"geteditemployee?employeeId="+IdInt,
	success : function(json){
	$.each(json.data, function( data ){

	$("#firstName").val(this.employeeFirstName);
	console.log(this.employeeFirstName);
    $("#lastName").val(this.employeeLastName);
	console.log(this.employeeLastName);
	$("#email").val(this.email);
	console.log(this.email);
	$("#BirthDate").val(this.dateOfBirth);
	console.log(this.dateOfBirth);
	$("#mobileNumber").val(this.mobileNumber);
	console.log(this.mobileNumber);
	$("#emploeeAddress").val(this.employeeAddress);
	console.log(this.employeeAddress);
	$("#otherQualification").val(this.other_qualification);
	console.log(this.other_qualification);
	$("#userName").val(this.userName);
	console.log(this.userName);
	$("#userPassword").val(this.userPassword);
	console.log(this.userPassword);
	$("#experience").val(this.experience);
	console.log(this.experience);
	$("#JoiningDate").val(this.joiningDate);
	console.log(this.joiningDate);
	$("#confirmPassword").val(this.confirmPassword);
	console.log(this.confirmPassword);
	
	designationTypeId=$('#designation option:selected').val();
	console.log("designationTypeId is" +designationTypeId);
	designationType=$('#designation option:selected').text();
	console.log("designationType is"+designationType);
	$("#designation").val(this.designationTypeId).trigger('change');
	qualificationId=$('#Qualification option:selected').val();
	console.log("qualificationId is" +qualificationId);
	qualificationType=$('#Qualification option:selected').text();
	console.log("qualificationType is"+qualificationType);

	console.log(this.qualificationId);
	$("#Qualification").val(this.qualificationId).trigger('change');
	
	
	    if( k == this.genderTypeId ){
		$("#radio_6").prop("checked",true);
		}
	    else if(v == this.genderTypeId ){
		$("#radio_4").prop("checked",true);
		}
		else if( d == this.genderTypeId ){
		$("#radio_5").prop("checked",true);
		}
		console.log("genderTypeId"+ this.genderTypeId);
		genderTypeId = $("input[name='group1']:checked"). val();
		console.log("genderType is"+this.genderTypeId);

		//genderType = $("input[name='group1']:checked"). val();
		//console.log("gender is"+genderType);  
	});
	}

	});
	   }

//---------------------------------------------------START---------------------------------------------------------------------------------	
	 $('#employeeTable').on('click', '.employeedelete', function() {
			var data = tableContact.row($(this).parents('tr')).data();
			console.log("ID to delete =  "+data.employeeId);
			employeeId = data.employeeId;
			employeeFirstName = data.employeeFirstName;
			employeeLastName = data.employeeLastName;
			email = data.email;
			dateOfBirth = data.dateOfBirth;
			mobileNumber = data.mobileNumber;
			employeeAddress = data.employeeAddress;
			other_qualification = data.other_qualification;
			userName = data.userName;
			userPassword = data.userPassword;
			experience = data.experience;
			joiningDate = data.joiningDate;
			confirmPassword = data.confirmPassword;
			designationTypeId = data.designationTypeId;
			designationType = data.designationType;
			qualificationId = data.qualificationId;
			qualificationType = data.qualificationType;
			genderTypeId = data.genderTypeId;
			
		
			$.confirm({
				icon: 'fa fa-question-circle',
			    title: 'Confirm!',
			    content: 'Are you sure?',
			    boxWidth: '30%',
			    useBootstrap: false,
			    buttons: {
			        confirm: function () {
			        	activeStatus = 'N';
						 $.ajax({
							 async: false,
							 type : "POST",
							 url: "employeeOperations?employeeId="+employeeId+"&activeStatus="+activeStatus, 
						       success: function(json){
									if(json.status == 'SUCCESS'){
									    $.alert({
									    	escapeKey: true, // close the modal when escape is pressed.
						                	backgroundDismiss: true,
									        icon : 'fa fa-smile-o',
									    	title: 'Success!',
									        content: 'Employee deleted!',
									        boxWidth: '30%',
										    useBootstrap: false,
										    onClose: function () {
										    	 window.location.href="/employeeList";
										    }
									    });
									   
										
									}	
						       }
		
	});
			        }
			    }
			});
	    });
	
	
	

//----------------------------------------------------------------------------------------------------------------------//
       //  userTypeId=2;
         
       /* if (eIdn === null || eIdn === undefined){
        	 fEmployeeId = 0;
         }else{
             eIdInt = $.trim(parseInt(eIdn));
             fEmployeeId = eIdInt;
         }
         if(isNaN(fEmployeeId)){
        	 fEmployeeId = 0;
         }
         else{
             console.log("fEmployeeId"+fEmployeeId);
         }
         if(loginId=== null || loginId == undefined){
        	 loginId=0
         }else{
        	 loginId=loginId; 
        	 console.log("Login id"+loginId);
         }
         if(isNaN(loginId)){
        	 loginId = 0;
         }else{
        	 console.log("login id"+loginId);
         }
         $.ajax({
  			async: false,
  			url: 'getUserType', 
  			success: function(json){
  			  $.each( json.data, function( data ) {
  			//var user=this.userType;
  			//alert(this.userType);
  			if((this.userType == 'user' && fEmployeeId==0 )||(fEmployeeId > 0 && editFlag =='true') ){
  				//console.log("userType");
  				userTypeId=2;
  				//alert(userTypeId);
  	  				
  			}
  			else  if(this.userType == 'admin' && (fEmployeeId > 0 && editFlag =='false')){
  				userTypeId=1; 
  				//alert(userTypeId);
  				}
  			  });
  			}
  		
  			});
         if(password != cofpass && fEmployeeId==0 ) {
        	 $.dialog({
                 icon : 'fa fa-exclamation-circle',
                 title: 'Warning!',
                 content: 'Password do not match with Confirm Password',
                 boxWidth: '30%',
                 useBootstrap: false,
            });
         }
         else{
        	  console.log("inn");
        	  console.log("fEmployeeId"+fEmployeeId);
        	  var uname = $('#userName').val();
     		  if(uname =='' && fEmployeeId == 0  || uname == undefined  && fEmployeeId == 0 || uname == null && fEmployeeId == 0){
        		  console.log("username is undefined");
        	  }else {
        	    
         		$.ajax({
         			async: false,
         			url: 'getuserNames?userName='+uname, 
         			success: function(json){
         				console.log(json.message+" is result ");
         				
         				if(json.message == 'found' && fEmployeeId == 0){
         					
         					 $.alert("Sorry...username already exists");
         			      }
         			    
         			      else if(json.message == 'not found' && fEmployeeId == 0 || fEmployeeId > 0){
         				  console.log("username not Exist");
         				 
         				  age=$("#age").text();
        	              console.log("age"+age);*/
	
	$('#EmployeeSubmitButton').on("click",function(){
		checkMandatoryFields();
		//if(flag){
			var qualificationList=encodeURIComponent(JSON.stringify(qualificationArray));
			/* var eIds = $("#employeeId").text();
	       	   var eIdn = eIds.replace("Employee ID:", '');
	           var password=$('#userPassword').val();
	           var cofpass=$('#confirmPassword').val();
			   var loginId=1;*/
			
			if(empId>0){
			employeeId=empId;
			}else{
			employeeId=0;
			}
        	              $.ajax({
        	              async: false,
        	              type : "POST",
        	              url: "employeeOperations?employeeId="+employeeId+"&employeeFirstName="+employeeFirstName+"&employeeLastName="+employeeLastName+"&dateOfBirth="+dateOfBirth+"&email="+email+"&mobileNumber="+mobileNumber+"&joiningDate="+joiningDate+"&designationTypeId="+designationTypeId+"&employeeAddress="+employeeAddress+"&genderTypeId="+genderTypeId+"&userName="+userName+"&userPassword="+userPassword+"&activeStatus=Y&qualificationList="+qualificationList,
        	              success : function(json){

        	                  if(json.status == 'SUCCESS'){
        	                	  $.alert({
        	                		    icon: 'fa fa-check-circle-o',
        	                		    title: 'Success!',
        	                		    content: 'New employee added',
        	                		    onClose: function(){
        	                		    	window.location.href="/NewEmployee";
        	                		    }
        	                		});	  
        	                  }
        	                 else{
        	                	 $.alert({
        	                		    icon: 'fa fa-times-circle-o',
        	                		    title: 'Error!',
        	                		   content: 'Try again later',
        	                		   onClose: function(){
        	                		    	window.location.href="/NewEmployee";
        	                		   }
        	                		});
        	                  }
        	              },
        	              //error: function(){
        	            	  //$.alert({
        	            	       // icon : 'fa fa-frown-o',
        	            	        //title: 'Error!',
        	            	       // content: 'Error occured. Try again!',
        	            	       // boxWidth: '30%',
        	            	       // useBootstrap: false,
        	            	       
        	            	  //  });
        	            	  // e.preventDefault();
        	              //  }
        	          //  }, 
        	            
        	            //'json');
         		   
                    
         	     
         		//}
         	//}			
         	//});
         	
         // }		
      // }
//	}else{
		//alert("error");
	//
        	              });
        	              
			//}
		
	});
	
	

//});
	

//---------------------------------------------------END----------------------------------------------------------------------------

	//-----------------------------------------Delete--------------------------------------------------------------//
	
	
	
	
	
	//------------------------------------------------DATATABLES-------------------------------------------------------------------------

     
//----------------------------------CUSTOMER LIST---------------------------------------------------------------------------------------------------------------------     
   /*  var tableEmployee = $('#employeeTable')
    .DataTable(
            {
                
                 /*responsive: true,*/
              /*  "ajax" : "getEmployeeUserDetails",
                "language" : {
                    "emptyTable" : "currently no data available...",
                    "sLengthMenu" : "View_MENU_",
                   
                },
                "width" : "100%",

                "bAutoWidth" : false,
                "scrollCollapse" : true,
                "bScrollCollapse" : true,
                "iDisplayLength" : 5,
                "fixedHeader" : {
                    "header" : true
                },
                "paging" : true ,
                "sPaginationType" : "simple",
                select : {
                    style : 'single'

                },
                dom : 'Bfrtip',
                "processing" : true,

                'columnDefs' : [
                    
                    {
                        'searchable' : false,
                        'orderable' : false,
                        'targets' : 0,
                        'data' : "employeeId",
                        "defaultContent" : "",
                        
                      },
                         {
                            /*'searchable' : false,
                            'orderable' : false,
                            *//*'targets' : 1,
                           /* 'data' : "employeeFirstName",
                            "defaultContent" : "",
                            "render": function (data, type, full, meta ) {
                                return full.employeeFirstName +' '+full.employeeLastName;
                          }
                         },
                        {
                            'targets' : 2,
                            'data' : "designationType",
                            "defaultContent" : "",
                            className : "",
                        },
                        {
                            'targets' : 3,
                            'data' : "email",
                            "defaultContent" : "",
                            className : "",
                        },
                        {

							'targets' : 4,
							"defaultContent" : "",
							className : "",
							orderable: false,
							"render" : function(data,
									type, full, row) {
									data = '&nbsp;&nbsp;<i class="fa fa-trash employeeDeleteButton" style="cursor:pointer;color:red;font-size:16px" id="employeeDeleteButtonId"></i>&nbsp;&nbsp;<i class="fa fa-pencil employeeEditButtton" style="cursor:pointer;color:red;font-size:16px" id="employeeEditButttonId"></i>'
									return data;
							}
						},

                           ],
                    });
                      
          
//---------------------------------------END-----------------------------------------------------------------------------------------------------------------------------------    

//---------------------------------------ADMIN LIST--------------------------------------------------------------------------------------------------
         
         $("#adminListId").click(function(){
              
              var tableAdmin = $('#adminTable')
             .DataTable(
                     {
                         "destroy": true,
                          "ajax" : "getEmployeeAdminDetails",
                         "language" : {
                             "emptyTable" : "currently no data available...",
                             "sLengthMenu" : "View_MENU_",
                            
                         },
                         "width" : "100%",

                         "bAutoWidth" : false,
                         "scrollCollapse" : true,
                         "bScrollCollapse" : true,
                         "iDisplayLength" : 5,
                         "fixedHeader" : {
                             "header" : true
                         },
                         "paging" : true ,
                         "sPaginationType" : "simple",
                         select : {
                             style : 'single'

                         },
                         dom : 'Bfrtip',
                         "processing" : true,

                         'columnDefs' : [
                             
                             {
                                 'searchable' : false,
                                 'orderable' : false,
                                 'targets' : 0,
                                 'data' : "employeeId",
                                 "defaultContent" : "",
                                 
                               },
                                  {
                                     /*'searchable' : false,
                                     'orderable' : false,
                                     *///'targets' : 1,
                                     /*'data' : "employeeFirstName",
                                     "defaultContent" : "",
                                     "render": function (data, type, full, meta ) {
                                         return full.employeeFirstName +' '+full.employeeLastName;
                                   }
                                  },
                                 {
                                     'targets' : 2,
                                     'data' : "designationType",
                                     "defaultContent" : "",
                                     className : "",
                                 },
                                 {
                                     'targets' : 3,
                                     'data' : "email",
                                     "defaultContent" : "",
                                     className : "",
                                 },
                                 {

         							'targets' : 4,
         							"defaultContent" : "",
         							 className : "",
         							 orderable: false,
         							"render" : function(data,
         									type, full, row) {
         									data = '&nbsp;&nbsp;<i class="fa fa-trash adminDeleteButton" style="cursor:pointer;color:red;font-size:16px" id="adminDeleteButtonId"></i>&nbsp;&nbsp;<i class="fa fa-pencil adminEditButtton" style="cursor:pointer;color:red;font-size:16px" id="adminEditButttonId"></i>'
         									return data;
         							}
         						},

                                 ],
                                 
                         });
         });            
//------------------------------------------END--------------------------------------------------------------------------------               
//-------------------------------INDIVIDUAL USER EMPLOYEE DETAILS------------------------------------------------------------------------------------------------------------------
         
         $('#employeeTable ').on("click","tr td:not(:last-child)",function(){
             var empId = $(this).parent("tr").find("td:first").text();
            window.location.href = "employeeProfile?employeeId="+empId;
        });

//-------------------------------------------END-----------------------------------------------------------------------------------------------------------------------
//-------------------------------INDIVIDUAL ADMIN DETAILS------------------------------------------------------------------------------------------------------------------
         
         $('#adminTable').on("click","tr td:not(:last-child)",function(){
             var empId = $(this).parent("tr").find("td:first").text();
            window.location.href = "employeeProfile?employeeId="+empId;
        });

//-----------------------------------------------END-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------EDIT USER EMPLOYEE DETAILS--------------------------------------------------
     	$('#employeeTable tbody').on('click', '.employeeEditButtton', function() {
  
     		var data = tableEmployee.row($(this).parents('tr')).data();
     		console.log("ID to edit =  "+data.employeeId);
     		employeeId = data.employeeId;
     		/*window.location.href = "/NewEmployee?employeeId="+employeeId;*/
     		//$(window).scrollTop(0);
     		//getEmployeePrimaryDetails();
     		
     	
     	
     	
//---------------------------------------------END OF EDIT BUTTON------------------------------------------------------------
//--------------------------------------------EDIT ADMIN EMPLOYEE DETAILS--------------------------------------------------
     	/*$('#adminTable ').on('click', '.adminEditButtton', function() {
     		var tr = $(this).closest('tr');
     		var id = tr.children('td:eq(0)').text();
     		console.log("admin id to edit"+id);
     		employeeId=id;
     		$(window).scrollTop(0);
     		getEmployeePrimaryDetails();
     		
     	});
     
     
     	
//---------------------------------------------END OF EDIT BUTTON------------------------------------------------------------
    	$('#employeeTable tbody').on('click', '.employeeDeleteButton', function() {
    		
    		var data = tableEmployee.row($(this).parents('tr')).data();
    		console.log("ID to delete =  "+data.employeeId);
    		employeeId = data.employeeId;
    		$.ajax({
      			async: false,
      			url: 'getUserTypeId?employeeId='+employeeId, 
      			success: function(json){
      			  $.each( json.data, function( data ) {
      				 userId=this.userTypeId;
      				// alert(userId);
      			  });
      			}
    		});
    		
    		var employeeName = data.employeeFirstName + data.employeeLastName;
    		$.confirm({
    			icon: 'fa fa-question-circle',
    		    title: 'Confirm!',
    		    content: 'Are you sure?',
    		    boxWidth: '30%',
    		    useBootstrap: false,
    		    buttons: {
    		        confirm: function () {
    		        	activeStatus = 'N';
    		        	//alert(userId);"&userTypeId="+userId+
    		        	
    					 $.ajax({
    						 async: false,
    						 type : "POST",
    						 url: "employeeOperations?employeeId="+employeeId+"&activeStatus="+activeStatus, 
    					       success: function(json){
    								if(json.status == 'SUCCESS'){
    								    $.alert({
    								        icon : 'fa fa-smile-o',
    								    	title: 'Success!',
    								        content: 'Employee deleted!',
    								        boxWidth: '30%',
    									    useBootstrap: false,
    									    onClose: function () {
    									    	 window.location.href="/NewEmployee";
    									    }
    								    });
    								   
    									
    								}	
    								else{
    									$.alert({
    										icon : 'fa fa-frown-o',
    										title: 'Failed!',
    								        content: 'Error occured! Try again later.',
    								        boxWidth: '30%',
    									    useBootstrap: false,
    									    onClose: function () {
   									    	 window.location.href="/NewEmployee";
   									    }

    									});
    								}
    							},
    							error: function(){
    								$.alert({
    									icon : 'fa fa-frown-o',
    									title: 'Failed!',
    							        content: 'Error occured! Try again later.',
    							        boxWidth: '30%',
    								    useBootstrap: false,
    								    onClose: function () {
									    	 window.location.href="/NewEmployee";
									    }

    							    });
    							}
    						  });
    		        },
    		        cancel: function () {
    		        	window.location.href="/NewEmployee";
    		        }
    		    }
    		});
    		
    	});

//---------------------------------------------------END------------------------------------------------------------------------------
//----------------------------------------------------START----------------------------------------------------------------------------
	$('#adminTable').on('click', '.adminDeleteButton', function() {
    		
		var adminId = $(this).closest('tr');
 		var AdminId = adminId.children('td:eq(0)').text();
 		console.log("admin id to edit"+AdminId);
 		employeeId=AdminId;
 			$.ajax({
      			async: false,
      			url: 'getUserTypeId?employeeId='+employeeId, 
      			success: function(json){
      			  $.each( json.data, function( data ) {
      				 userId=this.userTypeId;
      				// alert(userId);
      			  });
      			}
    		});
    		$.confirm({
    			icon: 'fa fa-question-circle',
    		    title: 'Confirm!',
    		    content: 'Are you sure?',
    		    boxWidth: '30%',
    		    useBootstrap: false,
    		    buttons: {
    		        confirm: function () {
    		        	activeStatus = 'N';
    		        	//alert(userId);"&userTypeId="+userId+
    		        	
    					 $.ajax({
    						 async: false,
    						 type : "POST",
    						 url: "employeeOperations?employeeId="+employeeId+"&activeStatus="+activeStatus, 
    					       success: function(json){
    								if(json.status == 'SUCCESS'){
    								    $.alert({
    								        icon : 'fa fa-smile-o',
    								    	title: 'Success!',
    								        content: 'Employee deleted!',
    								        boxWidth: '30%',
    									    useBootstrap: false,
    									    onClose: function () {
    									    	 window.location.href="/NewEmployee";
    									    }
    								    });
    								   
    									
    								}	
    								else{
    									$.alert({
    										icon : 'fa fa-frown-o',
    										title: 'Failed!',
    								        content: 'Error occured! Try again later.',
    								        boxWidth: '30%',
    									    useBootstrap: false,
    									    onClose: function () {
   									    	 window.location.href="/NewEmployee";
   									    }

    									});
    								}
    							},
    							error: function(){
    								$.alert({
    									icon : 'fa fa-frown-o',
    									title: 'Failed!',
    							        content: 'Error occured! Try again later.',
    							        boxWidth: '30%',
    								    useBootstrap: false,
    								    onClose: function () {
									    	 window.location.href="/NewEmployee";
									    }

    							    });
    							}
    						  });
    		        },
    		        cancel: function () {
    		        	window.location.href="/NewEmployee";
    		        }
    		    }
    		});
    		
    	});*/
	
	//-----------------------------------------------------------------------------------------//
	
	
//---------------------------------------------------END------------------------------------------------------------------------------
var tableContact = $('#employeeTable')
.DataTable(
        {
       	 "destroy": true,
       	 "ajax" : "getemployee",
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
             dom : 'Bfrtip',
            //"processing" : true,

            'columnDefs' : [
                
                {
                    'searchable' : false,
                    'orderable' : false,
                    'targets' : 0,
                    'data' : "employeeId",
                    "defaultContent" : "",
                    
                  },
                     {
 	                         'searchable' : false,
 	                         'orderable' : false,
 	                         'targets' : 1,
 	                         'data' : "Name",
 	                         "defaultContent" : "",
 	                        "render" : function(data, type,row,meta ){
 	                        	 return row.employeeFirstName +'<br>'+row.employeeLastName;
 	                         }
	                       
 	                         
 	                         
 	                       },
 	                     {
	  	                         'searchable' : false,
	  	                         'orderable' : false,
	  	                         'targets' : 2,
	  	                         'data' : "designationType",
	  	                         "defaultContent" : "",
	  	                         
	  	                       },
	  	                     {
		  	                         'searchable' : false,
		  	                         'orderable' : false,
		  	                         'targets' : 3,
		  	                         'data' : "email",
		  	                         "defaultContent" : "",
		  	                         
		  	                       },
 	                     {

 								'targets' : 4,
 								 "width": "20%",
 								"defaultContent" : "",
 								className : "",
 								orderable: false,
 								"render" : function(data,type,full,row) {
 										data = '&nbsp;&nbsp;<i class="fa fa-pencil-square contactEdit" style="cursor:pointer;color:black;font-size:14px" title="Edit"></i>&nbsp;&nbsp;<i class="fa fa-trash employeedelete" style="cursor:pointer;color:black;font-size:14px" id="DeleteButtonId"></i>'
 										return data;
 								}
 							}

                 ]
                });
//-------------------------------------------------------------------------------------------------------------------------------------------//

$('#employeeTable').on('click','.contactEdit',function()
	{
	var data =tableContact.row($(this).parents('tr')).data();
	console.log("ID to edit = "+data.employeeId);
	employeeId=data.employeeId;
	window.location.href ="/NewEmployee?employeeId="+employeeId;
});

 //-----------------------------------------------------------------------------------------------------//   	
});