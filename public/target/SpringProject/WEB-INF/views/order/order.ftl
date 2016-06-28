<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Order" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />
<#macro m_body>
<div class="row large-centered small-9 columns " style="background-color: white" >
    <div class="container">
        <@form.form commandName="ordForm" action="/ord" acceptCharset="UTF-8" method="post">
            <div class="register-top-grid">
                <h2 align="center">PERSONAL INFORMATION</h2>
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
                <div class="">
                    <input type="submit" value="submit" class="button">
                    <div class="alert "> </div>
                </div>
            </div>
        </@form.form>
    </div>
</div>
</#macro>