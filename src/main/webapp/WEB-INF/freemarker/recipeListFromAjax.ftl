[#ftl]

<script type="text/javascript">

    $(document).ready(function () {
        filterRecipies($("#slider-range").slider("option", "values"));
    });
</script>


<h1>Рецепты</h1>
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
    <label class="title">${a.title}</label>

    <div class="time_value no-display">${a.time}</div>
    <div class="cat_value no-display">${a.categories.categoriesId}</div>
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
    $('#cuisine > .btn').popover({
        trigger:'hover'
    })

    $('.block-create-menu.droppable > .btn').popover({
        trigger:'hover',
        placement:'left'
    })

</script>

[#--Dragg-able JavaScript--]
<script type="text/javascript">
    $(function () {
        $(".draggable").draggable({ cancel:"a.ui-icon", revert:"invalid", helper:"clone", cursor:"move" });
    });
</script>

[#--Dropp-able JavaScript--]
<script type="text/javascript">
    $(function () {
        $(".droppable").droppable({
            accept:".recepies_btn",
            drop:function (event, ui) {
                var trash_icon = "<a href='#' title='Delete this recipe' class='ui-icon ui-icon-trash' onclick='$(this).parent().remove(); return false;'>Delete recipe</a>";
                $(this).append((ui.draggable.clone(true, false)).prepend(trash_icon));

            }
        });
    });
</script>











