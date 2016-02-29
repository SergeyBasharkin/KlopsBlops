<div class="large-4 small-6 columns margbutt">
    <div class="th">
        <img src="http://placehold.it/1000x1000&text=Thumbnail">

        <div class="panel">
            <#if Session.ids?seq_contains(good.id)>
            <a href="/cart" class="small button success right">
                <i class="fi-plus middle"></i>
                ToCart
            </a>
            <#else >
                <a href="/cart/add/${good.id}" class="small button success right">
                    <i class="fi-shopping-cart middle"></i>
                    Buy
                </a>
            </#if>
            <h5>${good.name}</h5>
            <h6 class="subheader">$${good.price?number}</h6>


        </div>
    </div>
</div>