<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<div class="fixed">

<nav id="myHeader" class="top-bar" data-topbar role="navigation">


    <ul class="title-area">
        <li class="name">
            <h1><a href="/">Klops Blops</a></h1>
        </li>

        <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
        <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
    </ul>
    <section class="top-bar-section">
        <!-- Right Nav Section -->

        <ul class="right">
        <#-- Если пользователь еще не авторизован, предлагаем ему авторизоваться, либо зарегистрироваться на сайте -->
        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
           <li> <a class="login success button small" href="#">Login</a></li>
            <li><a class="login button small" href="/reg">Registration</a></li>
        </@sec.authorize>
        <#-- Если уже авторизован, то ссылки в личный кабинет и на выход -->
        <@sec.authorize access="isAuthenticated()">
            <li><a class="login" href="/cart">
            <#-- principal - это фактически экземпляр объекта MyUserDetail -->
                        <@sec.authentication property="principal.username" />
                        <#--<@sec.authentication property="principal.userInfo.fio" />-->
            </a></li>
            <li><a class="login" href="/logout">
                Logout
            </a></li>

        </@sec.authorize>
        </ul>

        <!-- Left Nav Section -->

    </section>

</nav>
</div>

