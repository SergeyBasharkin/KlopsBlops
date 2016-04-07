<div class="small-2 columns sticky left_side ">
    <article id="sidebar" class="events-press-cta panel left_menu">
    <#include "../cart/components/simpleCart.ftl"/>
        <p class="lead">Category</p>
        <ul class="category">
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
        <form  method="get" action="/catalog/filters">
            <p class="lead">Colors</p>
            <input title="red" class="color" type="checkbox" name="color" value="Red" >Red<br>
            <input title="green" class="color" type="checkbox" name="color" value="Green">Green<br>
            <input title="blue" class="color" type="checkbox" name="color" value="Blue">Blue<br>
            <input title="white" class="color" type="checkbox" name="color" value="White">White<br>
            <p class="lead">Type</p>
            <input title="mechanical" class="type" type="radio" name="type" value="mechanical">Mechanical
            <input title="battery" class="type" type="radio" name="type" value="battery">Battery
            <p class="lead">Price</p>
            <input title="minPrice" id="minPrice" type="text" size="20" value="100" name="minPrice">
            <input title="maxPrice" id="maxPrice" type="text" size="20" value="10000" name="maxPrice">
            <input class="tiny button" type="submit" value="Find">
        </form>
        <a class="tiny button" id="find">Find</a>

    </article>

</div>