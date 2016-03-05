<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css"] scripts=["js/foundation/foundation.js","js/catalog/catalog.js"]/>

<#macro m_body>}

    <#include "components/filters.ftl">
    <#include "components/sort.ftl">
<div class="large-8 columns small-centered">
    <div class="row">
        <div id="goodList">
            <#include "components/goodItem.ftl">
                    <#list goods as good>
            <@goodItem good=good itemClass=((good_index+1)%3==0)?string("last", "") />
        </#list>
        </div>
    ${limit}
        ${goodsCount}
        ${page}
        <#if limit < goodsCount >
            <div id="showMore" class="show-more-button" data-id="${id}" data-page="${page+1}" data-limit="${limit}">
                Показать еще (<span id="limit">${limit}</span>) из <span id="goodsCount">${goodsCount-limit}</span>
            </div>
        </#if>
    </div>
</div>
</#macro>