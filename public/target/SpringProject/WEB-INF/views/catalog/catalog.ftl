<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"]/>

<#macro m_body>
    <#include "components/filters.ftl">
    <#include "components/sort.ftl">
<div class="rowb catalog">
    <div id="goods">
    <ul id="goodList" class="medium-block-grid-3">
        <#include "components/goodItem.ftl">
        <#list goods as good>
            <#if good_index<limit>
                <@goodItem good=good itemClass=((good_index+1)%3==0)?string("last", "") />
            </#if>
        </#list>

    </ul>
    </div>
    <#include "../good/quickView.ftl"/>
    <#if limit < goodsCount>
        <div id="showMore" class="show-more-button" data-id="<#if id?? >${id}<#else >0</#if>" data-page="${page+1}"
             data-limit="${limit}">
            Показать еще (<i id="limit"><#if limit<goodsCount-limit >${limit}<#else >${goodsCount-limit}</#if></i>) из <i id="goodsCount">${goodsCount-limit}</i>
        </div>
    </#if>
</div>
</#macro>