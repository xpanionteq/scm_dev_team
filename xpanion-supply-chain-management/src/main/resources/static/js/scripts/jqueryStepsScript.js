/**
 * @author : ASHLIN ABRAHAM
 * @date : 20.05.2019
 * 
 */
var customerId = 0;
    $("#example-basic").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        autoFocus: true,
        onFinished: function (event, currentIndex)
        {
            alert("Submitted!");
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
        	return true;
           /* if(currentIndex == 0 && customerId == 0){
            	$.dialog("Choose Customer");
            }
            else{
            	return true;
            }*/
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            //resizeJquerySteps();
        	 if(currentIndex == 2){
                 var $input = $(' <button type="button" id="test" class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-bookmark"></i> Save to Later </button>');
                 $input.appendTo($('ul[aria-label=Pagination]'));
               }
               else {
                  $('ul[aria-label=Pagination] button[id="test"]').remove();
               }
        	 if(currentIndex == 3){
                 var $inp = $('<button type="button" id="genPDF" class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-download"></i> Generate PDF</button>');
                	       
                 $inp.appendTo($('ul[aria-label=Pagination]'));
                 var $in = $('<button type="button" id="print" class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-print"></i> Print</button>');
                 $in.appendTo($('ul[aria-label=Pagination]'));
        	 }
               else {
                  $('ul[aria-label=Pagination] button[id="genPDF"]').remove();
                  $('ul[aria-label=Pagination] button[id="print"]').remove();
               }
        }
 
    });
    
 
   /* 
    function resizeJquerySteps() {
        $('.wizard .content').animate({ height: $('.body.current').outerHeight() }, "fast");
}
    
$(window).load($.debounce(250, resizeJquerySteps));



*/
   