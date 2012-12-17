[#ftl]

<script type="text/javascript">

    $(document).ready(function () {
        var text = $(".cuisine_value").text();
        $("#menu-header h1").html(text);
        filterRecipies($("#slider-range").slider("option", "values"));
    });
</script>

<div class="cuisine_value no-display">${cuisineTitle}</div>

<ul class="nav nav-tabs" id="myTab">
    <li class="active"><a href="#1" id="1">Закуски</a></li>
    <li><a href="#2" id="2">Первое</a></li>
    <li><a href="#3" id="3">Второе</a></li>
    <li><a href="#4" id="4">Десерты</a></li>
    <li><a href="#5" id="5">Напитки</a></li>
</ul>


[#list model as a]
<div class="btn draggable recepies_btn" data-content="${a.description}"
     href="/modalRecipeDescription?recipeId=${a.recipeId}"
     data-toggle="modal" data-target="#myModal">
    <div class="imgContainer"><span class="pagination-centered"><img src="${a.smallImg}" class="img-rounded"/></span>
    </div>
    <div class="break-word"><label class="title">${a.title}</label></div>

    <div class="time_value no-display">${a.time}</div>
    <div class="cat_value no-display">${a.categories.categoriesId}</div>
    <div class="rec_id no-display">${a.recipeId}</div>
    <div class="rec_cal no-display">${a.calories}</div>
</div>
[/#list]

<div class="modal fade" id="myModal">

</div>

<div style="clear: both;"></div>
<button class="btn" id="back">Назад к кухням</button>

<script>
    $(function () {
        $('#myTab a:first').tab('show');
    })
</script>

<script>
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
        filterRecipies($("#slider-range").slider("option", "values"));
    })
</script>

<script type="text/javascript">
    $('#back').click(function () {
        $.get("/menuCuisinesAjax", function (response) {
            $('#cuisine').html(response);
            $("#menu-header h1").text("Рецепты");

        });
    });
</script>

<script type="text/javascript">
    $("#cuisine > .btn[data-toggle=modal]").click(function (e) {
        lv_target = $(this).attr('data-target')
        lv_url = $(this).attr('href')
        $(lv_target).load(lv_url)
    })
</script>

<script>
    $('#cuisine').find('.btn').popover({
        trigger:'hover',
        placement:'left'
    })

</script>

[#--Dragg-able JavaScript--]
<script type="text/javascript">
    $(function () {
        $(".draggable").draggable({ cancel:"a.ui-icon", revert:"invalid", helper:"clone", cursor:"move", containment:"window" });
    });
</script>

[#--Dropp-able JavaScript--]
<script type="text/javascript">
    $(function () {
        $(".droppable").droppable({
            accept:".recepies_btn",
            drop:function (event, ui) {
                var trash_icon = "<a href='#' title='Удалить рецепт' class='ui-icon ui-icon-trash' onclick=\"$(this).parent().popover('destroy').remove(); return false;\">Удалить рецепт</a>";
                var elem = ui.draggable.clone();
                (elem.prepend(trash_icon)).insertAfter($(this).find("h1"));
                elem.popover({
                    trigger:'hover',
                    placement:'right'
                });
                elem.click(function (e) {
                    var lv_target = $(this).attr('data-target');
                    var lv_url = $(this).attr('href');
                    $(lv_target).load(lv_url);
                });


            }
        });
    });
</script>
