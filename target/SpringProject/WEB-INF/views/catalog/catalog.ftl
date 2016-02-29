<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css"] scripts=["js/foundation/foundation.js"]/>

<#macro m_body>
Page = ${page}
Limit = ${limit!"null"}

    <#include "components/filters.ftl">
    <#include "components/sort.ftl">
<div class="large-8 columns small-centered">
    <div class="row">
        <br>
        <#list goods as good>
        <#if !limit?? || good_index < limit>
            <#include "components/item.ftl">
        </#if>
    </#list>
    </div>
</div>
</#macro>