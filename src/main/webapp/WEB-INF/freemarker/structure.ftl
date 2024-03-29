﻿<!DOCTYPE html>
<#import "spring.ftl" as spring />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<html>
<head>
    <link href="<@spring.url '/img/favicon.ico'/>" rel="icon" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/print.css'/>" media="print"/>
${styles!}
${scripts!}
    <script type="text/javascript" src="<@spring.url '/js/jquery-1.8.3.js'/>"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
    <script type="text/javascript" src="<@spring.url '/js/bootstrap.js'/>"></script>
    <script type="text/javascript" src="<@spring.url '/js/HiddenDimensions.js'/>"></script>
    <script type="text/javascript" src="<@spring.url '/js/Ellipsis.js'/>"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css"/>
    <script type="text/javascript" src="<@spring.url '/js/jquery.ui.datepicker.js'/>"></script>
    <script type="text/javascript" src="<@spring.url '/js/printBlock.js'/>"></script>
    
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

    <title>Profiterole</title>

</head>

<body>
<div class="container">

    <img class="img-head" src="<@spring.url '/img/head33.png'/>" alt="Логотип" usemap="#HeadMap"/>
    <map name="HeadMap">
        <area shape="poly" alt="Логотип" coords="0,336,14,257,63,188,139,130,237,84,340,58,455,48,562,46,679,72,774,105,856,157,915,235,943,280,950,336" href="/"/>
    </map>

    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="<@spring.url '/#'/>" class="dropdown" data-toggle="dropdown">
                            Создать меню
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<@spring.url '/menu'/>">Меню на день</a></li>
                            <li><a href="<@spring.url '/menuForWeek'/>">Меню на неделю</a> </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="<@spring.url '/#'/>" class="dropdown" data-toggle="dropdown">
                            Рецепты
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li> <a href="<@spring.url '/allOfRecipes'/>">Все рецепты</a></li>
                        <#--<@security.authorize  access="isAuthenticated()">-->
                            <li><a href="<@spring.url '/addRecipes'/>">Создать рецепт</a></li>
                        <#--</@security.authorize>-->
                        </ul>
                    </li>
                    <li><a href="<@spring.url '/about'/>">О нас</a></li>

                </ul>


      <!---- -->
                <form action="/searchResults" method="POST" class="navbar-search pull-right">
                    <input type="text" class="search-query" placeholder="Поиск" name="searchUnit"
                           value="">
                </form>


                <ul class="btn btn-link pull-right" style="text-decoration: underline">
                    <@security.authorize  access="!isAuthenticated()">
                    <li style="list-style-type: none;"> <a href="/registration">Регистрация</a>  </li>
                    </@security.authorize>
                    <@security.authorize  access="hasRole('ROLE_USER')">
                    <li style="list-style-type: none;"><a href="/profile">Профиль</a>  </li>
                    </@security.authorize>
                    <@security.authorize  access="hasRole('ROLE_ADMIN')">
                    <li style="list-style-type: none;"><a href="/admin">Администрирование сайта</a>  </li>
                    </@security.authorize>

                    </ul>

                <ul class="btn btn-link pull-right" style="text-decoration: underline">
                <@security.authorize  access="!isAuthenticated()">
                <li style="list-style-type: none;"> <a href="/login">Вход</a></li>
                </@security.authorize>
                <@security.authorize  access="isAuthenticated()">
                <li style="list-style-type: none;"><a href='/j_spring_security_logout'>Выход</a></li>
                </@security.authorize>
                </ul>

            </div>
        </div>

    </div>


    <div class="row-fluid">
        <div class="span12">
            <div class="recipe">
            ${content!}
            </div>

        </div>
    </div>
    <footer>
        <div class="row-fluid">
            <div class="span12">
                <p>Project "Profiterole"</p>
            </div>
        </div>
    </footer>

</div>

</body>

</html>
