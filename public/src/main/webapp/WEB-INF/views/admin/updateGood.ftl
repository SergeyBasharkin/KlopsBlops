<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Order" styles=["css/foundation.css","css/test.css","css/cart.css","/css/reset.css","/css/style.css"] scripts=["js/catalog/catalog.js"] />
<#macro m_body>
<div class="row large-centered small-9 columns " style="background-color: white" >
    <div class="container">
        <@form.form commandName="goodForm" action="/admin/update_good" acceptCharset="UTF-8" method="post">
            <div class="register-top-grid">
                <h2 align="center">GOOD INFORMATION</h2>
                <div>
                    <span>Name<label>*</label></span>
                    <@form.input path="name" />
                    <@form.errors path="name" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Description<label>*</label></span>
                    <@form.input path="description" />
                    <@form.errors path="description" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Price<label>*</label></span>
                    <@form.input path="price" />
                    <@form.errors path="price" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Image<label>*</label></span>
                    <@form.input path="image" />
                    <@form.errors path="image" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Category<label>*</label></span>
                    <@form.select path="category">
                        <@form.option value="8"/>
                        <@form.option value="7"/>
                        <@form.option value="3"/>
                    </@form.select>
                    <@form.errors path="image" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Type<label>*</label></span>
                    <@form.radiobutton path="type" value="mechanical" title="mech" />
                    <@form.radiobutton path="type" value="battery" title="batt"/>
                    <@form.errors path="type" cssStyle="color: red;" />
                </div>
                <@form.hidden path="goodId" />
                <div class="">
                    <input type="submit" value="submit" class="button">
                    <div class="alert "> </div>
                </div>
            </div>
        </@form.form>
    </div>
</div>
</#macro>