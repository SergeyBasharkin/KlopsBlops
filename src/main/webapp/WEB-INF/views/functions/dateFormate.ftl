<#function day number>
    <#if !number?is_number || number < 0><#return "" /></#if>
    <#if number%10==1 && number%100!=11>
        <#return number + " день" />
    <#elseif (number%10>1) && (number%10<5) && !(number%100>10 && number%100<15)>
        <#return number + " дня" />
    <#else>
        <#return number + " дней" />
    </#if>
</#function>