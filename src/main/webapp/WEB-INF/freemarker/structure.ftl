﻿<!DOCTYPE html>
<#import "spring.ftl" as spring />
<html>
<link href="<@spring.url '/img/favicon.ico'/>" rel="icon" type="image/x-icon"/>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>" media="screen"/>
${styles!}
${scripts!}
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css"/>
<#--<script src="http://code.jquery.com/jquery-1.8.2.js"></script>-->
    <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


    <title>Profiterole</title>

</head>

<body>
<div class="container">

    <a href="/"><img class="img-format" src="<@spring.url '/img/head33.png'/>" width="1000px"></a>

    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li><a href="menu"> Создать меню</a></li>

                    <li><a href="#">Меню на неделю</a></li>

                    <li><a href="#">Рецепты</a></li>

                    <li><a href="#">О нас</a></li>
                </ul>
                <form class="navbar-search pull-right">
                    <input type="text" class="search-query" placeholder="Поиск недоступен" disabled>
                </form>
            </div>
        </div>

    </div>


    <div class="row-fluid">
        <div class="span12">
            <div class="recipe">


                <div id="background">
                    <img src="<@spring.url '/img/background.jpg'/>"/>
                </div>


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
