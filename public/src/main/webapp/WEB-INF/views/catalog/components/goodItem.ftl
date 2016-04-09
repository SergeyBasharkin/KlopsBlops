<#macro goodItem good itemClass="">
 <li  class="margbutt ${itemClass} ">
        <div class="th">
            <div class="item-wrapper cd-item">
                <div class="img-wrapper ${good.id}" data-id="${good.id}" >
                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                        <a href="/cart" class="button expand add-to-cart" style="background: rgb(280, 124, 83)" data-id="${good.id}" data-price="${good.price?number}">
                            Go in Cart
                        </a>
                    <#else>
                        <a href="/cart" class="button expand add-to-cart js_addToCart" data-id="${good.id}" data-price="${good.price?number}">
                        Add to Cart
                    </a>
                    </#if>
                    <a class="cd-trigger"><img class="watch " src="${good.imageUrl}"></a>
                </div>
                <h3 class="titleView">${good.name}</h3>
                <h5 class="priceView">$${good.price?number}</h5>
                <p class="hi">${good.description}</p>
            </div>
        </div>
    </li>

</#macro>