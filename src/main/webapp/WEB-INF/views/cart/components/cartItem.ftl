<#macro cartItem goodId="">
<div class="large-4 small-6 columns margbutt">
    <div class="th">
        <img src="http://placehold.it/1000x1000&text=Thumbnail">

        <div class="panel">

            <div class="panelTexte ">
                <h5>${goodId}</h5>
                <button class="js_change" data-count="-1" data-id="${goodId}">-</button>
                (кол-во:<span id="count_${goodId}">${fCart[goodId]}</span>)
                <button class="js_change" data-count="1" data-id="${goodId}">+</button>

                <#--<h6 class="subheader">$${good.price?number}</h6>-->
            </div>

        </div>
    </div>
</div>
</#macro>