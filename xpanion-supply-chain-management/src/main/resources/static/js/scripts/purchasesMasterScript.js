/**
 * @author : ASHLIN ABRAHAM
 * @date : 05.07.2019
 * 
 */
$(document).ready(function(){
	$('#newPurchaseOrder').click(function(){
		window.location.replace("/purchaseOrders");
	});
	$('#pendingPurchaseOrder').click(function(){
		window.location.replace("/pendingPurchase");
	});
});