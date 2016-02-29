<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css"] scripts=["js/foundation/foundation.js"]/>

<#macro m_body>
<div class="large-8 columns small-centered">
    <div class="row">
        <#list Session.sessionCart as good>
        <#if !limit?? || good_index < limit>
            <#include "../catalog/components/item.ftl">
        </#if>
    </#list>
    </div>
</div>
</#macro>