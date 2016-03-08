<html class=" -webkit-"><head>
    <meta charset="UTF-8">
    <meta name="google" value="notranslate">


    <title>CodePen - Shopping Cart</title>
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://weloveiconfonts.com/api/?family=entypo">

    <link rel="stylesheet" href="//codepen.io/assets/reset/normalize.css">

    <link rel="stylesheet prefetch" href="http://static.bveneman.nl/utf-latest.min.css">

    <style>
        [class*="entypo-"]:before { font-family: 'entypo', sans-serif; }
        body {
            background-color: #ecf0f1;
            font: 300 1.25em/1.4 "Lato", sans-serif;
            color: #686868;
        }
        h1, h2, h3, h4, h5, h6 { font-weight: 400; }
        h1, .sub-heading {
            text-align: center;
            margin: .5rem 0 1rem;
        }
        .sub-heading {
            font-size: .75em;
            font-weight: 300;
        }

        /**
         * @section: utilities;
         * @see: Justify Grid [http://justifygrid.com/]
         */
        ._grid {
            text-align: justify !important;
            text-justify: distribute-all-lines;
            font-size: 0 !important;
            text-rendering: optimizespeed;
        }
        ._grid:after {
            content: "";
            display: inline-block;
            width: 100%;
        }
        ._column {
            display: inline-block;
            vertical-align: top;
            font-size: medium;
            text-align: left;
            text-rendering: optimizeLegibility;
        }
        ._btn {
            display: inline-block;
            background-color: #bdc3c7;
            border: none;
            padding: .5em .75em;
            text-align: center;
            font-weight: 300;
        }
        ._btn:hover,
        .cart-totals:hover ._btn {
            background-color: #3498db;
            color: #ecf0f1;
        }

        /**
         * @section: shopping-cart;
         */
        .shopping-cart {
            width: 80%;
            max-width: 60rem;
            margin: 0 auto;
        }
        /**
         * @extends: _grid;
         */
        .shopping-cart--list-item {
            border: 1px solid #bdc3c7;
            margin-bottom: 3rem;
            height: 10rem;
            overflow: hidden;
        }
        .shopping-cart--list-item:hover,
        .shopping-cart--list-item:hover * {
            border-color: #3498db;
        }
        .shopping-cart--list-item > ._column {
            height: 100%; /* make vertical lines match */
        }

        /**
         * @section: product-image;
         * @extends: _column;
         */
        .product-image {
            width: 16.663198%;
            background: url("data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7") no-repeat center / cover transparent;
        }

        /**
         * @section: product-info;
         * @extends: _column;
         */
        .product-info {
            width: 70.832119%;
            padding: .5rem;
        }
        .product-name {
            font: 300 2.4em/1 "Lato", sans-serif;
            letter-spacing: -.025em;
            margin: 0 0 .125em;
        }
        .price {
            line-height: 1;
            text-align: right;
        }
        .product-single-price {
            margin-top: -1rem;
            font-size: 2.4em;
        }

        /**
         * @section: product-modifiers;
         * @extends: _column;
         */
        .product-modifiers {
            width: 12.496358%;
            text-align: right;
            border-left: 1px solid #bdc3c7;
        }
        .product-subtract,
        .product-plus,
        .product-qty {
            width: 33.330557%;
            background-color: transparent;
            color: #686868;
            text-align: center;
        }
        .product-qty {
            padding: .35em .75em;
        }
        .product-remove {
            font-size: .875em;
            margin-top: 3.35rem;
            background-color: #e74c3c;
            color: #ecf0f1;
            width: 100%;
            visibility: hidden;
        }
        .product-modifiers:hover .product-remove {
            visibility: visible;
        }
        .product-remove:before {
            margin-right: .5em;
        }
        .product-remove:hover {
            background-color: #c0392b;
        }
        .product-total-price {
            border-top: 1px solid #bdc3c7;
            color: #95a5a6;
            font-size: 1.25em;
            padding: .5rem;
        }
        .shopping-cart--list-item:hover .product-total-price {
            background-color: #3498db;
            color: #ecf0f1;
        }

        /**
         * @section: cart-totals;
         * @extends: _grid;
         */
        .cart-totals {
            border-top: 1px solid #bdc3c7;
            margin-bottom: 3rem;
        }
        .cart-totals ._column {
            width: 19.984013%;
            padding: .5rem;
            line-height: 1.2;
        }
        .cart-totals ._column:not(:last-of-type) {
            border-right: 1px solid #bdc3c7;
        }
        .cart-totals ._column:first-of-type {
            padding-left: 0;
        }
        .cart-totals-key {
            font-size: 1.125em;
            color: #bdc3c7;
        }
        .cart-totals ._column:hover .cart-totals-value,
        .cart-totals ._column:hover .cart-totals-key {
            color: #333;
        }
        .cart-totals-value {
            font-size: 2em;
        }
        ._column.checkout {
            text-align: right;
            padding: 0;
            margin-top: 1.5em;
            vertical-align: middle;
        }
        .checkout-btn:before {
            margin-right: .5em;
        }
        ._btn.checkout-btn:hover {
            background-color: #2980b9;
        }

        /**
         * Animations
         */
        .product-remove,
        .cart-totals * {
            transition: all .2s ease;
        }
        .closing {
            transition: all .5s ease;
            transform: translate3d(0, -100%, 0);
            opacity: 0;
        }

    </style>

    <script>
        window.console = window.console || function(t) {};
    </script><style type="text/css"></style>

    <script src="//assets.codepen.io/assets/libs/prefixfree.min-d258f6cb24f3a877e4fb83b348ec8a3f.js"></script>


</head>

<body>

<div class="main">
    <h1>Shopping cart</h1>
    <h2 class="sub-heading">Free shipping from $100!</h2>

    <section class="shopping-cart">
        <ol class="ui-list shopping-cart--list" id="shopping-cart--list">
            <li class="_grid shopping-cart--list-item">
                <div class="_column product-image" style="background-image: url(&quot;http://fillmurray.com/g/159/159&quot;);">

                </div>
                <div class="_column product-info">
                    <h4 class="product-name">Meet and greet with Bill Murray</h4>
                    <p class="product-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                    <div class="price product-single-price">$19.95</div>
                </div>
                <div class="_column product-modifiers" data-product-price="19.95">
                    <div class="_grid">
                        <button class="_btn _column product-subtract">−</button>
                        <div class="_column product-qty">0</div>
                        <button class="_btn _column product-plus">+</button>
                    </div>
                    <button class="_btn entypo-trash product-remove">Remove</button>
                    <div class="price product-total-price">$0.00</div>
                </div>
            </li>

            <li class="_grid shopping-cart--list-item">
                <div class="_column product-image" style="background-image: url(&quot;http://shechive.files.wordpress.com/2011/08/odd-products-28.jpg?w=159&amp;h=159&quot;);">

                </div>
                <div class="_column product-info">
                    <h4 class="product-name">Tap Water</h4>
                    <p class="product-desc">You decide</p>
                    <div class="price product-single-price">$0.99</div>
                </div>
                <div class="_column product-modifiers" data-product-price="0.99">
                    <div class="_grid">
                        <button class="_btn _column product-subtract">−</button>
                        <div class="_column product-qty">0</div>
                        <button class="_btn _column product-plus">+</button>
                    </div>
                    <button class="_btn entypo-trash product-remove">Remove</button>
                    <div class="price product-total-price">$0.00</div>
                </div>
            </li>

            <li class="_grid shopping-cart--list-item">
                <div class="_column product-image" style="background-image: url(&quot;http://media-cache-ec2.pinimg.com/550x/c7/02/8f/c7028f260ae030ba66494ee75407192f.jpg&quot;);">

                </div>
                <div class="_column product-info">
                    <h4 class="product-name">Social Shower Curtain</h4>
                    <p class="product-desc">Always stay up-to-date with this very useless shower curtain!</p>
                    <div class="price product-single-price">$40.00</div>
                </div>
                <div class="_column product-modifiers" data-product-price="40.00">
                    <div class="_grid">
                        <button class="_btn _column product-subtract">−</button>
                        <div class="_column product-qty">0</div>
                        <button class="_btn _column product-plus">+</button>
                    </div>
                    <button class="_btn entypo-trash product-remove">Remove</button>
                    <div class="price product-total-price">$0.00</div>
                </div>
            </li>

            <li class="_grid shopping-cart--list-item">
                <div class="_column product-image" style="background-image: url(&quot;http://i.dailymail.co.uk/i/pix/2012/09/16/article-2204256-15053801000005DC-304_634x524.jpg&quot;);">

                </div>
                <div class="_column product-info">
                    <h4 class="product-name">Self stirring mug</h4>
                    <p class="product-desc">Don't get tired!</p>
                    <div class="price product-single-price">$12.35</div>
                </div>
                <div class="_column product-modifiers" data-product-price="12.35">
                    <div class="_grid">
                        <button class="_btn _column product-subtract">−</button>
                        <div class="_column product-qty">0</div>
                        <button class="_btn _column product-plus">+</button>
                    </div>
                    <button class="_btn entypo-trash product-remove">Remove</button>
                    <div class="price product-total-price">$0.00</div>
                </div>
            </li>
        </ol>

        <footer class="_grid cart-totals">
            <div class="_column subtotal" id="subtotalCtr">
                <div class="cart-totals-key">Subtotal</div>
                <div class="cart-totals-value">$0.00</div>
            </div>
            <div class="_column shipping" id="shippingCtr">
                <div class="cart-totals-key">Shipping</div>
                <div class="cart-totals-value">$0.00</div>
            </div>
            <div class="_column taxes" id="taxesCtr">
                <div class="cart-totals-key">Taxes (6%)</div>
                <div class="cart-totals-value">$0.00</div>
            </div>
            <div class="_column total" id="totalCtr">
                <div class="cart-totals-key">Total</div>
                <div class="cart-totals-value">$0.00</div>
            </div>
            <div class="_column checkout">
                <button class="_btn checkout-btn entypo-forward">Checkout</button>
            </div>
        </footer>

    </section>
</div>
<script src="//assets.codepen.io/assets/common/stopExecutionOnTimeout-f961f59a28ef4fd551736b43f94620b5.js"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/zepto/1.0/zepto.min.js"></script>

<script>
(function () {
    function c(a) {
        this.t = a;
    }
    function l(a, b) {
        for (var e = b.split('.'); e.length;) {
            if (window.CP.shouldStopExecution(1)) {
                break;
            }
            if (!(e[0] in a))
                return !1;
            a = a[e.shift()];
        }
        return a;
        window.CP.exitedLoop(1);
    }
    function d(a, b) {
        return a.replace(h, function (e, a, i, f, c, h, k, m) {
            var f = l(b, f), j = '', g;
            if (!f)
                return '!' == i ? d(c, b) : k ? d(m, b) : '';
            if (!i)
                return d(h, b);
            if ('@' == i) {
                e = b._key;
                a = b._val;
                for (g in f) {
                    if (window.CP.shouldStopExecution(2)) {
                        break;
                    }
                    f.hasOwnProperty(g) && (b._key = g, b._val = f[g], j += d(c, b));
                }
                window.CP.exitedLoop(2);
                b._key = e;
                b._val = a;
                return j;
            }
        }).replace(k, function (a, c, d) {
            return (a = l(b, d)) || 0 === a ? '%' == c ? new Option(a).innerHTML.replace(/"/g, '&quot;') : a : '';
        });
    }
var h = /\{\{(([@!]?)(.+?))\}\}(([\s\S]+?)(\{\{:\1\}\}([\s\S]+?))?)\{\{\/\1\}\}/g, k = /\{\{([=%])(.+?)\}\}/g;
    c.prototype.render = function (a) {
        return d(this.t, a);
    };
    window.t = c;
}());
Number.prototype.to_$ = function () {
    return '$' + parseFloat(this).toFixed(2);
};
String.prototype.strip$ = function () {
    return this.split('$')[1];
};
var app = {
    shipping: 5,
    products: [
        {
            'name': 'Meet and greet with Bill Murray',
            'price': '19.95',
            'img': 'http://fillmurray.com/g/159/159',
            'desc': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.'
        },
        {
            'name': 'Tap Water',
            'price': '0.99',
            'img': 'http://shechive.files.wordpress.com/2011/08/odd-products-28.jpg?w=159&h=159',
            'desc': 'You decide'
        },
        {
            'name': 'Social Shower Curtain',
            'price': '40.00',
            'img': 'http://media-cache-ec2.pinimg.com/550x/c7/02/8f/c7028f260ae030ba66494ee75407192f.jpg',
            'desc': 'Always stay up-to-date with this very useless shower curtain!'
        },
        {
            'name': 'Self stirring mug',
            'img': 'http://i.dailymail.co.uk/i/pix/2012/09/16/article-2204256-15053801000005DC-304_634x524.jpg',
            'price': '12.35',
            'desc': 'Don\'t get tired!'
        }
    ],
    removeProduct: function () {
        'use strict';
        var item = $(this).closest('.shopping-cart--list-item');
        item.addClass('closing');
        window.setTimeout(function () {
            item.remove();
            app.updateTotals();
        }, 500);
    },
    addProduct: function () {
        'use strict';
        var qtyCtr = $(this).prev('.product-qty'), quantity = parseInt(qtyCtr.html(), 10) + 1;
        app.updateProductSubtotal(this, quantity);
    },
    subtractProduct: function () {
        'use strict';
        var qtyCtr = $(this).next('.product-qty'), num = parseInt(qtyCtr.html(), 10) - 1, quantity = num <= 0 ? 0 : num;
        app.updateProductSubtotal(this, quantity);
    },
    updateProductSubtotal: function (context, quantity) {
        'use strict';
        var ctr = $(context).closest('.product-modifiers'), productQtyCtr = ctr.find('.product-qty'), productPrice = parseFloat(ctr.data('product-price')), subtotalCtr = ctr.find('.product-total-price'), subtotalPrice = quantity * productPrice;
        productQtyCtr.html(quantity);
        subtotalCtr.html(subtotalPrice.to_$());
        app.updateTotals();
    },
    updateTotals: function () {
        'use strict';
        var products = $('.shopping-cart--list-item'), subtotal = 0, shipping;
        for (var i = 0; i < products.length; i += 1) {
            if (window.CP.shouldStopExecution(3)) {
                break;
            }
            subtotal += parseFloat($(products[i]).find('.product-total-price').html().strip$());
        }
        window.CP.exitedLoop(3);
        shipping = subtotal > 0 && subtotal < 100 / 1.06 ? app.shipping : 0;
        $('#subtotalCtr').find('.cart-totals-value').html(subtotal.to_$());
        $('#taxesCtr').find('.cart-totals-value').html((subtotal * 0.06).to_$());
        $('#totalCtr').find('.cart-totals-value').html((subtotal * 1.06 + shipping).to_$());
        $('#shippingCtr').find('.cart-totals-value').html(shipping.to_$());
    },
    attachEvents: function () {
        'use strict';
        $('.product-remove').on('click', app.removeProduct);
        $('.product-plus').on('click', app.addProduct);
        $('.product-subtract').on('click', app.subtractProduct);
    },
    setProductImages: function () {
        'use strict';
        var images = $('.product-image'), ctr, img;
        for (var i = 0; i < images.length; i += 1) {
            if (window.CP.shouldStopExecution(4)) {
                break;
            }
            ctr = $(images[i]), img = ctr.find('.product-image--img');
            ctr.css('background-image', 'url(' + img.attr('src') + ')');
            img.remove();
        }
        window.CP.exitedLoop(4);
    },
    renderTemplates: function () {
        'use strict';
        var products = app.products, content = [], template = new t($('#shopping-cart--list-item-template').html());
        for (var i = 0; i < products.length; i += 1) {
            if (window.CP.shouldStopExecution(5)) {
                break;
            }
            content[i] = template.render(products[i]);
        }
        window.CP.exitedLoop(5);
        $('#shopping-cart--list').html(content.join(''));
    }
};
app.renderTemplates();
app.setProductImages();
app.attachEvents();
//@ sourceURL=pen.js
</script>


<script>
    if (document.location.search.match(/type=embed/gi)) {
        window.parent.postMessage("resize", "*");
    }
</script>





</body>
</html>