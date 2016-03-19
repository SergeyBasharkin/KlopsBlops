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

    <div class="small-3 medium-4 columns">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <article id="sidebar" class="events-press-cta panel sticky">
            <p class="lead">What are you going to do with it?</p>
            <p class="lead">Can't we just let it go? It's not harming anyone.</p>
            How we can help:
            <ul>
                <li>Feature it here!</li>
                <li>Help promote it.</li>
                <li>Review material for accuracy.</li>
                <li>Stickers!</li>
            </ul>

            <a class="tiny button" href="#">Contact us</a>
        </article>

    </div>


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