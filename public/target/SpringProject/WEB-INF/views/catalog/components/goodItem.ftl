<#macro goodItem good itemClass="">
<#--<div class="large-4 small-6 columns margbutt ${itemClass}">-->
    <#--<div class="th " >-->
    <#--<img class="js_goodDetail" data-id="${good.id}" src="http://placehold.it/1000x1000&text=Thumbnail">-->

        <#--<div class="panel">-->

            <#--<div class="panelTexte ">-->
                <#--<h5>${good.name}</h5>-->
                <#--<h6 class="subheader">$${good.price?number}</h6>-->
            <#--</div>-->

            <#--<a href="/cart" class="small button success js_addToCart" data-id="${good.id}">-->
                <#--<i class="fi-shopping-cart middle"></i>-->
                <#--Buy-->
            <#--</a>-->

        <#--</div>-->
    <#--</div>-->
  <li  class="margbutt ${itemClass}">
        <div class="th">
            <div class="item-wrapper">
                <div class="img-wrapper">
                    <#if (Session.cart.goods)?? && Session.cart.containsGoodId(good.id)>
                        <a href="/cart" class="button expand add-to-cart" style="background: rgb(280, 124, 83)" data-id="${good.id}" data-price="${good.price?number}">
                            Go in Cart
                        </a>
                    <#else>
                        <a href="/cart" class="button expand add-to-cart js_addToCart" data-id="${good.id}" data-price="${good.price?number}">
                        Add to Cart
                    </a>
                    </#if>
                    <a href="#" class="js_goodDetail" data-id="${good.id}"><img src="http://i.imgur.com/Mcw06Yt.png"></a>
                </div>
                <h3>${good.name}</h3>
                <h5>$${good.price?number}</h5>
                <p class="hi">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin posuere sem enim, accumsan convallis risus semper.</p>
            </div>
        </div>
    </li>

<#--</div>-->
</#macro>