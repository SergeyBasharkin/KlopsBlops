<#-- @ftlvariable name="param1" type="java.lang.String" -->
<#-- @ftlvariable name="list" type="java.util.List<java.lang.String>" -->
<#-- @ftlvariable name="testMap" type="java.util.Map<java.lang.String,java.lang.Long>" -->
<#-- @ftlvariable name="goodObject" type="com.springapp.mvc.common.GoodInfo" -->

<h3>Ссылка на официальную документацию <a href="http://freemarker.incubator.apache.org/docs/index.html">FreeMarker</a></h3><br>

${param1} - отображение значения переменной<br><br>

${param2!} - отображение значения переменной только если оно существует<br><br>

${param2!"default"} - отображение значения переменной или значения по умолчанию<br><br>

Условный оператор:
<#if param1=="12">
    12
<#elseif param1=="str">
    str
<#else>
    another
</#if>
<br><br>

Проход по списку:<br>
<#list list as el>
    ${el_index}) ${el}<#if el_has_next>;<br><#else>.</#if>
</#list>
<br>
$ {el_index} - индекс элемента в списке, начинается с 0<br>
$ {el} - значение самого элемента<br>
$ {el_has_next} - есть ли следующий элемент в списке<br><br>

Обход мапы: key - value<br>
<#list testMap?keys as key>
    ${key} - ${testMap[key]}<br>
</#list>
!!! ВАЖНО - FreeMarker умеет работать только с мапами вида Map < String, ? > , т.е. ключом обязательно должна быть строка. Значение любого типа.
<br><br>

Работа с объектами. Пример Товар:<br>
id : ${goodObject.id}<br>
name : ${goodObject.name}<br>
categoryId : ${goodObject.categoryId}<br>
price : ${goodObject.price?number}<br>
!!! ВАЖНО - FreeMarker обращается не к самим полям, а к их getter методам, поэтому они обязательно должны быть определены.<br>
Как следствие мы можем обращаться к несуществующим полям, через get методы. Например good.decoratedName = ${goodObject.decoratedName}<br><br>

Более сложные условия:<br>
<#if param1??>переменная param1 существует</#if><br>
<#if param2!false>переменная param2 существует и == true<#else>переменная param2 == false или не существует</#if><br><br>

У FreeMarker есть проблемы с приоритетом оператора ! - значение по умолчанию, поэтому при составлении сложных условий, таких как:<br>
< # if a==b || c!false && m==n> важно расставлять скобки ( ), т.е. верно оно будет таким<br>
< # if a==b || (c!false) && m==n><br><br>

<#assign paramName = "paramValue" />
Создание новых переменных: paramName = ${paramName}<br><br>

Так же во FreeMarker полно методов для преобразования типов, изменения отображения и других удобных штучек,<br>
но это все остается на самостоятельное изучение. Сложностей там возникать не должно.<br><br>

Так же можете:<br>
Почитать про <a href="http://freemarker.incubator.apache.org/docs/ref_directive_function.html">function</a>.<br>
Почитать про <a href="http://freemarker.incubator.apache.org/docs/ref_directive_macro.html">macros</a>.<br>
Почитать про <a href="http://freemarker.incubator.apache.org/docs/ref_directive_include.html">include</a>.<br><br>

Пример работы функции:<br>
<#include "../functions/dateFormate.ftl">
<#list 0..31 as i>
${i} = ${day(i)}<br>
</#list>
