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
                    <a href="#" class="cd-trigger"><img class="watch " src="${good.imageUrl}"></a>
                </div>
                <h3 class="titleView">${good.name}</h3>
                <h5 class="priceView">$${good.price?number}</h5>
                <p class="hi">${good.description}</p>
            </div>
        </div>
      <#include "../../good/quickView.ftl"/>
    </li>

<#--</div>-->
</#macro>