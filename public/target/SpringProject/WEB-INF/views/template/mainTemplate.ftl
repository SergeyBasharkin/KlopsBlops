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

    <a href="#" class="left_swap menu-icon"></a>


    <@m_body />

</div>
    <#include "footer.ftl" />



<script src="../../../resources/js/vendor/jquery.js"></script>
<script src="../../../resources/js/vendor/fastclick.js"></script>
<script src="../../../resources/js/foundation/foundation.js"></script>

<!-- or individually -->
<script src="../../../resources/js/catalog/velocity.min.js"></script>
<script src="../../../resources/js/catalog/jquery.jrumble.1.3.js"></script>
<script src="../../../resources/js/foundation/foundation.alert.js"></script>
<!-- ... -->

<script src="../../../resources/js/foundation/foundation.tab.js"></script>
<script src="../../../resources/js/foundation/foundation.dropdown.js"></script>
<script src="../../../resources/js/foundation/foundation.topbar.js"></script>
<script src="../../../resources/js/foundation/foundation.orbit.js"></script>
<script src="../../../resources/js/catalog/sticky.js"></script>
<script src="../../../resources/js/catalog/main.js"></script>

<script>
    $(document).foundation();
</script>
</body>
</html>
</#macro>