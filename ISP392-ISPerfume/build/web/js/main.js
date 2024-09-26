/*price range*/

 $('#sl2').slider();

	var RGBChange = function() {
	  $('#RGB').css('background', 'rgb('+r.getValue()+','+g.getValue()+','+b.getValue()+')')
	};	
		
/*scroll to top*/

$(document).ready(function(){
	$(function () {
		$.scrollUp({
	        scrollName: 'scrollUp', // Element ID
	        scrollDistance: 300, // Distance from top/bottom before showing element (px)
	        scrollFrom: 'top', // 'top' or 'bottom'
	        scrollSpeed: 300, // Speed back to top (ms)
	        easingType: 'linear', // Scroll to top easing (see http://easings.net/)
	        animation: 'fade', // Fade, slide, none
	        animationSpeed: 200, // Animation in speed (ms)
	        scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
					//scrollTarget: false, // Set a custom target element for scrolling to the top
	        scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
	        scrollTitle: false, // Set a custom <a> title if required.
	        scrollImg: false, // Set true to use image
	        activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	        zIndex: 2147483647 // Z-Index for the overlay
		});
	});
});
// cart JS

function changeQuantity(id, delta) {
	let quantityInput = document.getElementById('quantity-' + id);
	let currentValue = parseInt(quantityInput.value);
	let newValue = currentValue + delta;

	if (newValue >= parseInt(quantityInput.min) && newValue <= parseInt(quantityInput.max)) {
		quantityInput.value = newValue;
	}
	let price = parseInt(document.getElementById("cart_price-"+id).innerText);
	let totalElement = document.getElementById("total_price-"+id);
	let newTotal = quantityInput.value *  price;
	totalElement.textContent = newTotal

	let product_price = document.getElementsByClassName("product_price")
	let subTotal = 0;
	for (let index = 0; index < product_price.length; index++) {
		subTotal = subTotal + parseInt( product_price[index].innerText);
		
	}
	let cart_subtotal = document.getElementById("cart-subtotal");
	cart_subtotal.textContent = subTotal;
	document.getElementById("cart-total").innerText = subTotal + 2
}