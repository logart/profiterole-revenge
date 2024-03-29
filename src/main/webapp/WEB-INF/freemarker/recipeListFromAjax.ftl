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
[#--[#list model?keys as a]--]
<div class="btn draggable recepies_btn" data-content="
Время приготовления:
[#if a.recipe.timeOfCooking &lt; 60]
     ${a.recipe.timeOfCooking % 60 }мин.<br />
[#else]
     ${a.recipe.timeOfCooking / 60 % 24}ч. ${a.recipe.timeOfCooking % 60 }мин.<br />
[/#if]
Сложность: ${a.recipe.complexity}; <br />
[#list  a.markers?keys as marker]
    - ${marker}; <br />
[/#list]
[#if a.recipe.description?length &lt; 250]
${a.recipe.description}
[#else]
${a.recipe.description?substring(0,250)} ...
[/#if]
"
     href="/modalRecipeDescription?recipeId=${a.recipe.id}"
     data-toggle="modal" data-target="#myModal">

    <div class="imgMarkersContainer">
        [#list  a.markers?keys as b]
            <img src="${a.markers[b]}" />
        [/#list]
    </div>

    <div class="imgContainer"><span class="pagination-centered"><img src="${a.recipe.smallImage}" class="img-rounded"/></span>
    </div>
    <div class="recipe_title"><label class="title">${a.recipe.title}  </label></div>



    <div class="time_value no-display">${a.recipe.timeOfCooking}</div>
    <div class="complexity_value no-display">${a.recipe.complexity}</div>
    <div class="cat_value no-display">${a.recipe.category.id}</div>
    <div class="rec_id no-display">${a.recipe.id}</div>
    <div class="rec_cal no-display">${a.recipe.calories}</div>
    <div class="rec_dish_quantity no-display">${a.recipe.quantityOfDish}</div>
    <div class="rec_portion no-display">${a.recipe.valueOfPortion}</div>
</div>
[/#list]

<div class="modal fade" id="myModal">

</div>

<div style="clear: both;"></div>
<button class="btn" id="back">Назад к кухням</button>


<script type="text/javascript">
    $(function () {
        $('#myTab a:first').tab('show');
    })
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
        filterRecipies($("#slider-range").slider("option", "values"));
    })

    $('#back').click(function () {
        $.get("/menuCuisinesAjax", function (response) {
            $('#cuisine').html(response);
            $("#menu-header h1").text("Рецепты");

        });
    });

    $("#cuisine > .btn[data-toggle=modal]").click(function (e) {
        lv_target = $(this).attr('data-target');
        lv_url = $(this).attr('href');
        $(lv_target).load(lv_url, function () {
            $("#header").show();
            $("#body").show();
        });

    })

    $('#cuisine').find('.btn').popover({
        trigger: 'hover',
        placement: 'left',
        delay: { show: 500, hide: 100 }
    })

    [#--Dragg-able JavaScript--]
    $(function () {
        $(".draggable").draggable({ cancel: "a.ui-icon", revert: "invalid", helper: "clone", cursor: "move", containment: "window" });
    });

    [#--Dropp-able JavaScript--]
    $(function () {
        $(".droppable").droppable({
            accept: ".recepies_btn",
            drop: function (event, ui) {
                addToMenuByCloning(ui.draggable, $(this));
                if($(".dayOfWeekButton").length>0) markButtonDayOfWeek($(this)[0].id.split("_")[0],$(this)[0].id.split("_")[1]);
            }
        });
    });

    $(".imgContainer img").each(function () {
        var image = $(this);
        if (image.getHiddenDimensions().outerWidth < image.getHiddenDimensions().outerHeight) {
            image.height(100);
        }
    });
    $(".recipe_title label").each(function () {
        $(this).ellipsis();
    });
    function deleteRecipe(target){
        target.parent().popover('destroy').remove();
        var container = $("#menuDrop").find("div:visible")[0];
       if ($(container).find(".rec_id").length==0){
           if($(".dayOfWeekButton").length>0) unmarkButtonDayOfWeek(container.id.split("_")[0],container.id.split("_")[1]);
       };
    }
    function addToMenuByCloning(clonableElement, droppedTo){
            var trash_icon = "<a href='#' title='Удалить рецепт' class='ui-icon ui-icon-trash' onclick=\"" +
                    "deleteRecipe($(this)); return false;\">Удалить рецепт</a>";
            var counter = "<input type='test' class='rec_count' value=1>";
            var minus_btn = "<input type='button' class='minus_count' value='-' onclick='" +
                    "var $input = $(this).parent().find(\".rec_count\");" +
                    "var val=parseInt($input.val());" +
                    "$input.val((val>1)? val - 1:val);return false;'>";
            var plus_btn = "<input type='button' class='plus_count' value='+' onclick='" +
                    "var $input = $(this).parent().find(\".rec_count\");" +
                    "$input.val(parseInt($input.val()) + 1);return false;'>";

            var elem = clonableElement.clone();

            var already_exist_marker = false;
            $("#menuDrop").find("div:visible").find(".rec_id").filter(function (index) {
                if ($(this).text() == elem.find(".rec_id").text()) {
                    var val = $(this).parent().find(".rec_count").val();
                    $(this).parent().find(".rec_count").val(++val);
                    already_exist_marker = true;
                }
                ;
                return true;
            });

            if (!already_exist_marker) {

                elem.append(minus_btn);
                elem.append(counter);
                elem.append(plus_btn);

                elem.find("input").click(function (event) {
                    event.stopPropagation();
                });

                (elem.prepend(trash_icon)).insertAfter(droppedTo.find("h1"));
                elem.popover({
                    trigger: 'hover',
                    placement: 'right'
                });
                elem.click(function (e) {
                    var lv_target = $(this).attr('data-target');
                    var lv_url = $(this).attr('href');
                    $(lv_target).load(lv_url, function () {
                        $("#header").show();
                        $("#body").show();
                    });
                });
            }
    }
</script>