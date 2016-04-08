<div class="rowb catalog">
<#include "components/sort.ftl">
    <div id="goods">
        <ul id="goodList" class="medium-block-grid-3">
        <#include "components/goodItem.ftl">
        <#list goods as good>
            <@goodItem good=good itemClass=((good_index+1)%3==0)?string("last", "") />
        </#list>

        </ul>
    </div>
<#include "../good/quickView.ftl"/>
<#if limit < goodsCount >
    <div id="showMore" class="show-more-button" data-id="<#if id?? >${id}</#if>" data-page="${page+1}"
         data-limit="${limit}">
        Показать еще (<span id="limit">${limit}</span>) из <span id="goodsCount">${goodsCount-limit}</span>
    </div>
</#if>
</div>