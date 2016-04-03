<div class="small-2 columns left_side ">
    <article id="sidebar" class="events-press-cta panel sticky left_menu">
    <#include "../cart/components/simpleCart.ftl"/>
        <p class="lead">Category</p>
        <ul>
        <#list parentCat as category>
            <li>
            ${category.name}
                <ul>
                    <#list category.children as child>
                        <#if child.id!=category.id>
                            <li>${child.name}</li>
                        </#if>
                    </#list>
                </ul>
            </li>
        </#list>
        </ul>
        <a class="tiny button" href="#">Contact us</a>
    </article>

</div>