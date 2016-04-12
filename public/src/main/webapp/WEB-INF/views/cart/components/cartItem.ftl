<#macro cartItem goodId="">
<div class="large-4 small-6 columns margbutt">
    <div class="th ${goodId}">
        <div class="item-wrapper">
            <div class="img-wrapper">
                <img class="watch" src="${cartGoods[goodId].imageUrl}">
            </div>
            <h3>${cartGoods[goodId].name}</h3>
             <a class="js_change fi-minus minus" data-count="-1" data-id="${goodId}" data-price="${cartGoods[goodId].price}"></a>
            (кол-во:<span id="count_${goodId}">${fCart[goodId]}</span>)
           <a class="js_change fi-plus plus" data-count="1" data-id="${goodId}" data-price="${cartGoods[goodId].price}"></a>

        </div>
    </div>
</div>
</#macro>