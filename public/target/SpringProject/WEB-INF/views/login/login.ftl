<#-- @ftlvariable name="topGoods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Авторизация" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />
<#macro m_body>
<div class="">
    <div class="medium-6 medium-centered large-4 columns">
    <div class="container">
        <div class="col-md-7 account-top">
            <#if error??>
                <div data-alert class="alert-box alert">
                    <strong style="margin-left: 20px">Error</strong> check email and password
                    <a href="#" class="close">&times;</a>
                </div>
            <#else >
                <div data-alert class="alert-box success">
                    <strong>Yay!</strong> - You accomplished a simple task!
                    <a href="#" class="close">&times;</a>
                </div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <h4 class="text-center">Log in with you email account</h4>
                <label>Email
                    <input type="text" name="j_username" placeholder="somebody@example.com">
                </label>
                    <label>Password
                        <input type="password" name="j_password" placeholder="Password">
                    </label>
                <input id="show-password" name="_spring_security_remember_me" type="checkbox">
                <p><input type="submit" value="Login" class="button expanded"></p>
                <p class="text-center"><a href="#">Forgot your password?</a></p>
                <a href="/reg" style="margin-left: 15px;">Create an account</a>
            </form>
        </div>
        <div class="col-md-5 left-account "></div>
        <div class="clearfix"> </div>
    </div>
</div>
</div>
</#macro>