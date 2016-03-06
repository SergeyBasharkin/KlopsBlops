<#macro goodItem good itemClass="">
<div class="large-4 small-6 columns margbutt ${itemClass}">
    <div class="th">
    <img src="http://placehold.it/1000x1000&text=Thumbnail">

        <div class="panel">

            <div class="panelTexte ">
                <h5>${good.name}</h5>
                <h6 class="subheader">$${good.price?number}</h6>
            </div>

            <a href="/cart" class="small button success js_addToCart" data-id="${good.id}">
                <i class="fi-shopping-cart middle"></i>
                Buy
            </a>

        </div>
    </div>
</div>
</#macro>