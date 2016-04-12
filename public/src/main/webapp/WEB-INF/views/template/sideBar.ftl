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
                            <li><a style="color: #028dba" href="/catalog/${child.id}"> ${child.name}</a></li>
                        </#if>
                    </#list>
                </ul>
            </li>
        </#list>
        </ul>

        <form id="myForm" method="get"  >
            <p class="lead">Colors</p>
            <select name="sort" title="sort" class="right sort" form="myForm">
                <option value="name">name</option>
                <option value="price">price</option>
                <option value="pricedesc">price(desc)</option>
            </select>
            <input title="red" class="color" type="checkbox" name="color" value="Red" >Red<br>
            <input title="green" class="color" type="checkbox" name="color" value="Green">Green<br>
            <input title="blue" class="color" type="checkbox" name="color" value="Blue">Blue<br>
            <input title="white" class="color" type="checkbox" name="color" value="White">White<br>
            <p class="lead">Type</p>
            <input title="mechanical" class="type" type="checkbox" name="type" value="mechanical">Mechanical<br>
            <input title="battery" class="type" type="checkbox" name="type" value="battery">Battery
            <p class="lead">Price</p>
            <input title="minPrice" pattern="^[ 0-9]+$" id="minPrice" type="text" size="20" value="100" name="minPrice">
            <input title="maxPrice" pattern="^[ 0-9]+$" id="maxPrice" type="text" size="20" value="10000" name="maxPrice">
            <#--<input class="tiny button" id="#find" type="submit" value="Find">-->
        </form>
        <a class="tiny button" id="find">Find</a>

    </article>

</div>