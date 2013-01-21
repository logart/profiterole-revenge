<!DOCTYPE html>
<#import "spring.ftl" as spring />
<html>
<head>
    <link href="<@spring.url '/img/favicon.ico'/>" rel="icon" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>" media="screen"/>
${styles!}
${scripts!}
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/HiddenDimensions.js"></script>
    <script type="text/javascript" src="/js/Ellipsis.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css"/>

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
                    <li><a href="menu"> Создать меню</a></li>

                    <li class="dropdown">
                        <a href="#" class="dropdown" data-toggle="dropdown">
                            Рецепты
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <a href="/allCuisines">Все рецепты</a>
                            <a href="/addRecipes">Создать рецепт</a>
                        </ul>
                    </li>
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
