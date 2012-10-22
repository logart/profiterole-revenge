﻿<!DOCTYPE html>
<#import "spring.ftl" as spring />
<html>
<link href="<@spring.url '/img/favicon.ico'/>" rel="icon" type="image/x-icon"/>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>" media="screen"/>
    ${styles!}
    ${scripts!}
    <!-- bin/jquery.slider.min.css -->
    <#--<link rel="stylesheet" href="css/jslider.css" type="text/css">-->
    <#--<link rel="stylesheet" href="css/jslider.blue.css" type="text/css">-->
    <#--<link rel="stylesheet" href="css/jslider.plastic.css" type="text/css">-->
    <#--<link rel="stylesheet" href="css/jslider.round.css" type="text/css">-->
    <#--<link rel="stylesheet" href="css/jslider.round.plastic.css" type="text/css">-->
     <link rel="stylesheet" href="css/slider.css" type="text/css">
    <!-- end -->
     <link rel="stylesheet" href="css/dpop.css" type="text/css">
    <link rel="stylesheet" href="css/skin.css" type="text/css">


    <#--<script type="text/javascript" src="js/jquery-1.8.1.js"></script>-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <!-- bin/jquery.slider.min.js -->
    <script type="text/javascript" src="js/jshashtable-2.1_src.js"></script>
    <script type="text/javascript" src="js/jquery.numberformatter-1.2.3.js"></script>
    <script type="text/javascript" src="js/tmpl.js"></script>
    <script type="text/javascript" src="js/jquery.dependClass-0.1.js"></script>
    <script type="text/javascript" src="js/draggable-0.1.js"></script>
    <#--<script type="text/javascript" src="js/jquery.slider.js"></script>-->
         <script type="text/javascript" src="js/bootstrap.js"></script>
    <!-- end -->
    <script type="text/javascript" src="js/jquery.jcarousel.js"></script>
    <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
    <script type="text/javascript" src="js/jquery.carouFredSel-5.6.4.js"></script>


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
