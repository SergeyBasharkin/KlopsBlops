<#macro cartItem goodId="">
<#--<div class="large-4 small-6 columns margbutt">-->
    <#--<div class="th">-->
        <#--<img src="http://placehold.it/1000x1000&text=Thumbnail">-->

        <#--<div class="panel">-->

            <#--<div class="panelTexte ">-->
                <#--<h5>${goodId}</h5>-->
                <#--<button class="js_change" data-count="-1" data-id="${goodId}">-</button>-->
                <#--(кол-во:<span id="count_${goodId}">${fCart[goodId]}</span>)-->
                <#--<button class="js_change" data-count="1" data-id="${goodId}">+</button>-->

                <#--&lt;#&ndash;<h6 class="subheader">$${good.price?number}</h6>&ndash;&gt;-->
            <#--</div>-->

        <#--</div>-->
    <#--</div>-->
<#--</div>-->
<div div class="large-4 small-6 columns margbutt">
    <div class="th ${goodId}">
        <div class="item-wrapper">
            <div class="img-wrapper">
                <img src="http://i.imgur.com/Mcw06Yt.png">
            </div>
            <h3>${goodId}</h3>
             <a class="js_change fi-minus minus" data-count="-1" data-id="${goodId}"></a>
            (кол-во:<span id="count_${goodId}">${fCart[goodId]}</span>)
           <a class="js_change fi-plus plus" data-count="1" data-id="${goodId}"></a>

        </div>
    </div>
</div>
</#macro>