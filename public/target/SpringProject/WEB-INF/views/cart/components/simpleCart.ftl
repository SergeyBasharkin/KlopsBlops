<div class="cart">
    <div class="popup">
        <div class="rowb header">
            <span>Items</span>
            <span>Amount</span>
        </div>
        <div class="rowb items">
            <span class="js_count"><#if Session.cart??>${Session.cart.count!0}<#else >0</#if></span>
           <span>$</span><span class="jsPrice"><#if Session.cart??>${Session.cart.total!0}<#else >0</#if></span>
        </div>
        <div class="rowb checkout">
            <span><a href="/cart">View Cart &gt;</a></span>
            <span class="checkout-button">Checkout</span>
        </div>
    </div>
</div>