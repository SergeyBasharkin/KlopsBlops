<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Регистрация" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />
<#macro m_body>
<div class="account-in row column">
    <div class="container">
        <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
            <div class="register-top-grid">
                <h2>PERSONAL INFORMATION</h2>
                <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div>
                    <span>First Name<label>*</label></span>
                    <@form.input path="firstName" />
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Last Name<label>*</label></span>
                    <@form.input path="lastName" />
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Email Address<label>*</label></span>
                    <@form.input path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Phone<label>*</label></span>
                    <@form.input path="phone" />
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>
                <div class="clearfix"> </div>
                <i class="news-letter">
                    <label class="">
                        <@form.checkbox path="signIn" />
                        <i> </i>Sign Up for Newsletter
                        <@form.errors path="signIn" cssStyle="color: red;" />
                    </label>
                </i>
            </div>
            <div class="register-bottom-grid">
                <h2>LOGIN INFORMATION</h2>
                <div>
                    <span>Password<label>*</label></span>
                    <@form.password path="password" />
                    <@form.errors path="password" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Confirm Password<label>*</label></span>
                    <@form.password path="confirmPassword" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                </div>
                <div class="clearfix"> </div>
            </div>
        <div class="clearfix"> </div>
        <div class="register-but">
            <input type="submit" value="submit" class="btn btn-default">
            <div class="clearfix"> </div>
        </div>
        </@form.form>
    </div>
</div>
</#macro>