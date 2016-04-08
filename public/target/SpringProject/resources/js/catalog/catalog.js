/**
 * Created by Admin on 05.03.2016.
 */
$(document).ready(function () {
    $(document).on('click', '.js_change', function () {
        var $this = $(this);
        var count = $this.data('count');
        var id = $this.data('id');
        var price=$this.data('price');
        var $js_count=$('.js_count');
        var $jsPrice=$('.jsPrice');
        var totalCount=$js_count.text();
        var total=$jsPrice.text();
        $.ajax({
            type: "POST",
            url: "/cart/change",
            data: {
                id: id,
                count: count
            }
        }).done(function (data) {
            if (data == '0') {
                    $('.' + $this.data("id")).fadeOut(1000);

                $js_count.text(Number(totalCount)+Number(count));
                $jsPrice.text(Number(total)+Number(price*count));
            }
            if (data != '') {
                $('#count_' + id).text(data);

                $js_count.text(Number(totalCount)+Number(count));
                $jsPrice.text(Number(total)+Number(price*count));
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
        })
    });
    $(document).on('click','.sort',function(){
        var $this=$(this);
        var sort=$this.data('sort');
        var id=$this.data('id');
        $.ajax({
            type: "POST",
            url: "/catalog/sort",
            data:{
                sort: sort,
                id: id
            },
            success: function(data){
                $('.catalog').remove();
                $('.main-content').append(data);
            },
            error: function(){
                alert('ошибка');
            }
    });});
    $(document).on('click', '#showMore', function () {
        var $this = $(this);
        var page = $this.data('page'),
            limit = $this.data('limit');
        $.ajax({
            type: "POST",
            url: "/catalog/showMore",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            //console.log(data);
            if (data != '') {
                $("#goodList").append(data);
                updateCounter();
            } else {
                $this.hide();
            }
        }).fail(function () {      // сюда приходит ответ если на сервере прооизошла ошибка
            $this.hide();
        });

        function updateCounter() {
            $this.data('page', page + 1);
            var $goodsCount = $('#goodsCount');
            var goodsCount = parseInt($goodsCount.text());
            if (goodsCount > limit) {
                $goodsCount.text(goodsCount - limit);
                $('#limit').text(Math.min(limit, goodsCount - limit))
            } else {
                $this.hide();
            }
        }
    });
    var element = $('.cart').jrumble({
        speed: 20,
        x:6,
        y:6,
        rotation: 6
    });
    var demoTimeout;
    function rumble(){
        $this = $('.cart');
        clearTimeout(demoTimeout);
        $this.trigger('startRumble');
        demoTimeout = setTimeout(function(){$this.trigger('stopRumble');}, 1500)
    };

    $(document).on('click', '#find',function(){
        var $this=$(this);
        var color='';
        var type=$('.type:checked').val();
        $('.color:checked').each(function() {
            console.log(this.value);
            color+=this.value +',';
        });
        
        color = color.substring(0, color.length-1);
        $.ajax({
            type: 'GET',
            url: '/catalog/filters',
            data: {
                color: color,
                type: type,
                minPrice: $('#minPrice').val(),
                maxPrice: $('#maxPrice').val()
            },
            success: function(data){
                $('.catalog').remove();
                $('.main-content').append(data);
            },
            error: function(){
                alert('ошибка');
            }
        })
    });
    $(document).on('click', '.js_addToCart', function () {
        event.preventDefault();
        var $this = $(this);
        var $price = $('.jsPrice');
        var price = Number($price.text());
        $.ajax({
            type: 'POST',
            url: '/cart/add',
            data: {goodId: $this.data('id')},
            success: function (data, status) {  // успешное завершение работы
                if (data == 'ok') {
                    $price.text(price+Number($this.data('price')));
                    $('.js_count').text(Number($('.js_count').text())+1)
                    $this.removeClass('js_addToCart').text('Go in cart').css('background', 'rgb(280, 124, 83)');
                    rumble();

                }
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });
    $(document).on('click', '.js_goodDetail', function () {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/good/details/' + $(this).data('id'),
            //dataType: 'json',
            success: function (data, status) {  // успешное завершение работы
                alert(JSON.stringify(data, "", 4));
            },
            error: function (error) {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка<br/>' + error);
            }
        });
    });

});