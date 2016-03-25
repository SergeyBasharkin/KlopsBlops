<#macro mainTemplate title="" styles=[] scripts=[] >
<!DOCTYPE html>
<html lang="ru">
<head>

    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="shortcut icon" href="/resources/images/ico/favicon.ico"/>
    <#list styles as css>
        <link rel="stylesheet" href="/resources/stylesheets/${css}" type="text/css"/>
    </#list>
    <script src="../../../resources/js/vendor/modernizr.js"></script>
    <#list scripts as js>
        <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
    <#include "header.ftl" />
<div class="main-content">
        <div class="small-2 columns left_side ">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <article id="sidebar" class="events-press-cta panel sticky left_menu">
            <#include "../cart/components/simpleCart.ftl"/>
            <p class="lead">What are you going to do with it?</p>
            <p class="lead">Can't we just let it go? It's not harming anyone.</p>
            How we can help:
            <ul>
            <#list catList as category>
                <li>
                 ${category.name}
                </li>
            </#list>
            </ul>
            <a class="tiny button" href="#">Contact us</a>
        </article>

    </div>
    <a href="#" class="left_swap menu-icon"></a>



    <@m_body />

</div>

    <#include "footer.ftl" />


<script src="../../../resources/js/vendor/jquery.js"></script>
<script src="../../../resources/js/vendor/fastclick.js"></script>
<script src="../../../resources/js/foundation/foundation.js"></script>

<!-- or individually -->

<script src="../../../resources/js/foundation/foundation.alert.js"></script>
<!-- ... -->

<script src="../../../resources/js/foundation/foundation.tab.js"></script>
<script src="../../../resources/js/foundation/foundation.dropdown.js"></script>
<script src="../../../resources/js/foundation/foundation.topbar.js"></script>
<script src="../../../resources/js/catalog/sticky.js"></script>

<script>
    $(document).foundation();
</script>
</body>
</html>
</#macro>