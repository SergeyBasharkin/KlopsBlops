<#macro mainTemplate title="" styles=[] scripts=[] >
<!DOCTYPE html>
<html lang="ru">
<head>
    <script src="../../../resources/js/vendor/modernizr.js"></script>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="shortcut icon" href="/resources/images/ico/favicon.ico" />
    <#list styles as css>
    <link rel="stylesheet" href="/resources/stylesheets/${css}" type="text/css" />
    </#list>
    <#list scripts as js>
    <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
<script src="../../../resources/js/vendor/jquery.js"></script>
<script src="../../../resources/js/vendor/fastclick.js"></script>
<script src="../../../resources/js/foundation.min.js"></script>

<!-- or individually -->

<script src="../../../resources/js/foundation/foundation.alert.js"></script>
<!-- ... -->
<script src="../../../resources/js/foundation/foundation.dropdown.js"></script>
<script src="../../../resources/js/foundation/foundation.tab.js"></script>
    <#include "header.ftl" />


<div id="container">

        <@m_body />
    </div>

    <#include "footer.ftl" />




<script>
    $(document).foundation();
</script>
</body>
</html>
</#macro>