/**
 * @author: ASHLIN ABRAHAM
 * @date : 01.07.2019
 * 
 */
$ (document).ready(function(){
	$(document).bind('keydown', 'shift+x', showPurchase);
	$(document).bind('keydown', 'shift+z', showSale);
	$(document).bind('keydown', 'shift+c', showContacts);
	$(document).bind('keydown', 'shift+s', showProducts);
	$(document).bind('keydown', 'shift+a', showReports);
	$(document).bind('keydown', 'return', f);
	function showPurchase(){
		window.location.replace("/purchaseOrders");
	}
	function showSale(){
		window.location.replace("/salesOrders");
	}
	function f(){
		alert("enter key pressed");
	}
	function showContacts(){
		window.location.replace("/contacts");
	}
	function showProducts(){
		window.location.replace("/products");
	}
	function showReports(){
		window.location.replace("/reports");
	}
});