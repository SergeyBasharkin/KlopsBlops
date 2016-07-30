<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css","css/test.css","/css/reset.css","/css/style.css"]/>
<#macro m_body>
<h1>Hello <strong>${name}</strong></h1>
<div>
    <a href="/admin/create_good" class="button">Create Good</a>
</div>
</#macro>