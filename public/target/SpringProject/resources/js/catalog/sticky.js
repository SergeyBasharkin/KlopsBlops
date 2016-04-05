/**
 * Created by Admin on 19.03.2016.
 */
var stickySidebar = $('.sticky');

if (stickySidebar.length > 0) {
    var stickyHeight = stickySidebar.height(),
        sidebarTop = stickySidebar.offset().top;
}

// on scroll move the sidebar
$(window).scroll(function () {
    if (stickySidebar.length > 0) {
        var scrollTop = $(window).scrollTop();

        if (sidebarTop < scrollTop+$("#myHeader").height()) {
            stickySidebar.css('top', scrollTop - sidebarTop);

            // stop the sticky sidebar at the footer to avoid overlapping

        }
        else {
            stickySidebar.css('top', '0');
        }
    }
});
jQuery(function($) {
    $(".left_swap").click(function (){
        $(".left_side").toggle(200);
        return false;
    });
})
$(window).resize(function () {
    if (stickySidebar.length > 0) {
        stickyHeight = stickySidebar.height();
    }
});