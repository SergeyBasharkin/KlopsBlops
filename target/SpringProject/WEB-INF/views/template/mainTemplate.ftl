<#macro mainTemplate title="" styles=[] scripts=[] >
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="shortcut icon" href="/resources/images/ico/favicon.ico" />
    <#list styles as css>
    <link rel="stylesheet" href="/resources/${css}" type="text/css" />
    </#list>
    <#list scripts as js>
    <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
    <#include "header.ftl" />
    <div id="container">
        <@m_body />
    </div>

    <#include "footer.ftl" />
</body>
</html>
</#macro>