<#--Страница в работе!-->
<#--<br><br>-->
<#--<#if (Session.cart.goods)??>-->
<#--Товары в корзине:<br>-->
    <#--<#list Session.cart.goods?keys as goodId>-->
    <#--товар: ${goodId};<br>-->
    <#--</#list>-->
<#--<#else>-->
<#--Ваша корзина пуста!-->
<#--</#if>-->

<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог" styles=["css/foundation.css","css/cart.css","css/test.css"] scripts=["js/catalog/catalog.js","js/catalog/jquery.jrumble.1.3.js"]/>

<#macro m_body>
    <#include "../template/sideBar.ftl"/>
<div class="large-8 columns small-centered">
    <div class="rowb ">
        <div id="goodList">
            <#include "components/cartItem.ftl">
            <#if (fCart)??>
            <#list fCart?keys as goodId>
                <@cartItem goodId=goodId />

            </#list>

        </#if>
        </div>
    </div>
</div>
</#macro>