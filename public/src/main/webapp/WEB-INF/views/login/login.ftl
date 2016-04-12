<#-- @ftlvariable name="topGoods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#--<#include "../template/mainTemplate.ftl">-->
<#--<@mainTemplate title="Авторизация" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />-->
<#--<#macro m_body>-->
<#if RequestParameters["auth"]??&&RequestParameters["auth"]=="true">
<div data-alert class="alert-box success">
    <strong>Success!</strong>
    <a href="#" class="close myClose">&times;</a>
</div>
</#if>
<div class="row centered log fixed " style="<#if RequestParameters["auth"]??&&RequestParameters["auth"]=="false"><#else > display: none</#if>">
    <div class="medium-6 large-4 small-centered columns">
            <#if RequestParameters["auth"]??&&RequestParameters["auth"]=="false">
                <div data-alert class="alert-box alert">
                    <strong style="margin-left: 20px"></strong> check email and password
                    <a href="#" class="close">&times;</a>
                </div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div class="row column log-in-form">
                <h4 class="text-center">Log in with you email account</h4>
                <label>Email
                    <input type="text" name="j_username" id="jem" placeholder="somebody@example.com">
                </label>
                    <label>Password
                        <input type="password" id="jpas" name="j_password" placeholder="Password">
                    </label>
                <input id="show-password" name="_spring_security_remember_me" type="checkbox">
                <p><input type="submit" value="Login" class="button expanded login"></p>
                <p class="text-center"><a href="#">Forgot your password?</a></p>
                <a href="/reg" style="margin-left: 15px;">Create an account</a>
                </div>
            </form>
        </div>
</div>
<#--</#macro>-->