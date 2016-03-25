<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css","css/test.css","css/cart.css"] scripts=["js/catalog/catalog.js"]/>

<#macro m_body>
    <#include "components/filters.ftl">
    <#include "components/sort.ftl">
<div class="rowb catalog">
        <ul id="goodList" class="medium-block-grid-3">

            <#include "components/goodItem.ftl">
                    <#list goods as good>
            <@goodItem good=good itemClass=((good_index+1)%3==0)?string("last", "") />
        </#list>

        </ul>
    ${limit}
        ${goodsCount}
        ${page}
        <#if limit < goodsCount >
            <div id="showMore" class="show-more-button" data-id="${id}" data-page="${page+1}" data-limit="${limit}">
                Показать еще (<span id="limit">${limit}</span>) из <span id="goodsCount">${goodsCount-limit}</span>
            </div>
        </#if>
    </div>
</#macro>