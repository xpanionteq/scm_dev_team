/**
 * 
 *//*
$(document).ready(function (e) { 
		console.log("inside sms script");
         var sendRequest = { 
             user: "ashlin.thekkumparayil@gmail.com",    // Replace with your user 
             pass: "ashlin1996", // Replace with your password 
             source: "6282677594",        // Replace with your sender ID 
             destination: "9400660372", // Replace with the recipient number 
             sms: "Test Message 1",           // Replace with your message 
 
         }; 
 
         var url = "http://api.123-txt.com/Api123WCF.svc/rest/SendSms"; 
             url += "?" + $.param(sendRequest); 
             $.ajax({ 
             type: 'GET', 
             url: url, 
             dataType: 'json', 
             success: function (res) { 
                           console.log(res); //Handle Response 
                            } 
          }); 
});*/


var settings = {
  "async": true,
  "crossDomain": true,
  "url": "https://api.msg91.com/api/sendhttp.php?campaign=&response=&afterminutes=&schtime=&flash=&unicode=&mobiles=Mobile%20no.&authkey=%24authentication_key&route=4&sender=TESTIN&message=Hello!%20This%20is%20a%20test%20message&country=91",
  "method": "GET",
  "headers": {}
}

$.ajax(settings).done(function (response) {
  console.log(response);
});