jQuery(document).ready(function($){
	//final width --> this is the quick view image slider width
	//maxQuickWidth --> this is the max-width of the quick-view panel
	var sliderFinalWidth = 400,
		maxQuickWidth = 900;

	//open the quick view panel
	$('body').on('click','.cd-trigger', function(event){
		var selectedImage = $(this).parent('.img-wrapper').parent('.cd-item').children($(this).data('id')),
			slectedImageUrl = selectedImage.attr('src');

		$('body').addClass('overlay-layer');
		animateQuickView(selectedImage, sliderFinalWidth, maxQuickWidth, 'open',$(this).data('id'));

		//update the visible slider image in the quick view panel
		//you don't need to implement/use the updateQuickView if retrieving the quick view data with ajax
		updateQuickView(slectedImageUrl);
	});
    //
	//function good_details(i){
	//	$this=$(i);
	//	var selectedImage = $(this).parent('.img-wrapper').parent('.cd-item').children($(this).data('id')),
	//		slectedImageUrl = selectedImage.attr('src');
    //
	//	$('body').addClass('overlay-layer');
	//	animateQuickView(selectedImage, sliderFinalWidth, maxQuickWidth, 'open',$(this).data('id'));
    //
	//	//update the visible slider image in the quick view panel
	//	//you don't need to implement/use the updateQuickView if retrieving the quick view data with ajax
	//	updateQuickView(slectedImageUrl);
	//}
	//close the quick view panel
	$('body').on('click', function(event){
		if( $(event.target).is('.cd-close') || $(event.target).is('body.overlay-layer')) {
			closeQuickView( sliderFinalWidth, maxQuickWidth);
		}
	});
	$(document).keyup(function(event){
		//check if user has pressed 'Esc'
    	if(event.which=='27'){
			closeQuickView( sliderFinalWidth, maxQuickWidth);
		}
	});

	//quick view slider implementation
	$('.cd-quick-view').on('click', '.cd-slider-navigation a', function(){
		updateSlider($(this));
	});

	//center quick-view on window resize
	$(window).on('resize', function(){
		if($('.cd-quick-view').hasClass('is-visible')){
			window.requestAnimationFrame(resizeQuickView);
		}
	});

	function updateSlider(navigation) {
		var sliderConatiner = navigation.parents('.cd-slider-wrapper').find('.cd-slider'),
			activeSlider = sliderConatiner.children('.selected').removeClass('selected');
		if ( navigation.hasClass('cd-next') ) {
			( !activeSlider.is(':last-child') ) ? activeSlider.next().addClass('selected') : sliderConatiner.children('li').eq(0).addClass('selected');
		} else {
			( !activeSlider.is(':first-child') ) ? activeSlider.prev().addClass('selected') : sliderConatiner.children('li').last().addClass('selected');
		}
	}

	function updateQuickView(url) {
		$('.cd-quick-view').find('img[src="'+ url +'"]');
	}

	function resizeQuickView() {
		var quickViewLeft = ($(window).width() - $('.cd-quick-view').width())/2,
			quickViewTop = ($(window).height() - $('.cd-quick-view').height())/2;
		$('.cd-quick-view').css({
		    "top": quickViewTop,
		    "left": quickViewLeft,
		});
	}

	function closeQuickView(finalWidth, maxQuickWidth) {
		var close = $('.cd-close'),
			selectedImage = $('.empty-box');
        $('.cd-quick-view');
		//update the image in the gallery
		if( !$('.cd-quick-view').hasClass('velocity-animating') && $('.cd-quick-view').hasClass('add-content')) {
			animateQuickView(selectedImage, finalWidth, maxQuickWidth, 'close');
		} else {
			closeNoAnimation(selectedImage, finalWidth, maxQuickWidth);
		}
	}

	function animateQuickView(image, finalWidth, maxQuickWidth, animationType,id) {
		//store some image data (width, top position, ...)
		//store window data to calculate quick view panel position
		var parentListItem = image,
			topSelected = image.offset().top - $(window).scrollTop(),
			leftSelected = image.offset().left,
			widthSelected = image.width(),
			heightSelected = image.height(),
			windowWidth = $(window).width(),
			windowHeight = $(window).height(),
			finalLeft = (windowWidth - finalWidth)/2,
			finalHeight = finalWidth * heightSelected/widthSelected,
			finalTop = (windowHeight - finalHeight)/2,
			quickViewWidth = ( windowWidth * .8 < maxQuickWidth ) ? windowWidth * .8 : maxQuickWidth ,
			quickViewLeft = (windowWidth - quickViewWidth+200)/2;

		if( animationType == 'open') {
			$cdQuickView=$('.cd-quick-view');
			//hide the image in the gallery
			parentListItem.addClass('empty-box');
            app=parentListItem.children('.add-to-cart');
			$cdQuickView.children('img').attr('src',parentListItem.children('.cd-trigger').children('img').attr('src'));
			$cdQuickView.children('.cd-item-info').children('.titleView').text(parentListItem.parent('.cd-item').children('.titleView').text());
			$cdQuickView.children('.cd-item-info').children('.priceView').text(parentListItem.parent('.cd-item').children('.priceView').text());
			$cdQuickView.children('.cd-item-info').children('.hi').text(parentListItem.parent('.cd-item').children('.hi').text());
			(app).clone().appendTo($cdQuickView.children('.cd-item-info').children('.cd-item-action').children('li'));
			//place the quick view over the image gallery and give it the dimension of the gallery image
			$cdQuickView.css({
			    "top": topSelected,
			    "left": leftSelected,
			    "width": widthSelected,
			}).velocity({
				//animate the quick view: animate its width and center it in the viewport
				//during this animation, only the slider image is visible
			    'top': finalTop+ 'px',
			    'left': finalLeft+'px',
			    'width': finalWidth+'px',
			}, 400, [ 400, 20 ], function(){
				//animate the quick view: animate its width to the final value
				$cdQuickView.addClass('animate-width').velocity({
					'left': quickViewLeft+'px',
			    	'width': quickViewWidth+'px',
				}, 300, 'ease' ,function(){
					//show quick view content
					$cdQuickView.addClass('add-content');
				});
			}).addClass('is-visible');

		} else {
			//close the quick view reverting the animation
            $cdQuickView.children('.cd-item-info').children('.cd-item-action').children('li').children('.add-to-cart').remove();
			$cdQuickView.removeClass('add-content').velocity({
			    'top': finalTop+ 'px',
			    'left': finalLeft+'px',
			    'width': finalWidth+'px',
			}, 300, 'ease', function(){
				$('body').removeClass('overlay-layer');
				$cdQuickView.removeClass('animate-width').velocity({
					"top": topSelected,
				    "left": leftSelected,
				    "width": widthSelected,
				}, 500, 'ease', function(){
					$cdQuickView.removeClass('is-visible');
					parentListItem.removeClass('empty-box');
				});
			});
		}
	}
	function closeNoAnimation(image, finalWidth, maxQuickWidth) {
		var parentListItem = image.parent('.cd-item'),
			topSelected = image.offset().top - $(window).scrollTop(),
			leftSelected = image.offset().left,
			widthSelected = image.width();

		//close the quick view reverting the animation
		$('body').removeClass('overlay-layer');
		parentListItem.removeClass('empty-box');
		$('.cd-quick-view').velocity("stop").removeClass('add-content animate-width is-visible').css({
			"top": topSelected,
		    "left": leftSelected,
		    "width": widthSelected,
		});
	}
});