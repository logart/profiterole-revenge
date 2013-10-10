[#ftl]
[#assign content]

<script type="text/javascript">

    var animateSlidebarOnFirstshow = (function() {
        var firstshow = true;
        return function() {
            if (firstshow){
                firstshow=false;
                $("#slider-range").slider("values", 1, 500);
                $("#slider-range").slider("values", 0, 6);
                $("#amount").val("от " + parseInt($("#slider-range").slider("values", 0) / 60 % 24,
                        10) + "ч. " + parseInt($("#slider-range").slider("values", 0) % 60, 10) + "мин." +
                        " до " + parseInt($("#slider-range").slider("values", 1) / 60 % 24,
                        10) + "ч. " + parseInt($("#slider-range").slider("values", 1) % 60, 10) + "мин.");
            }
        };
    })();

    $(document).ready(function () {

        $.get("/menuCuisinesAjax", function (response) {
            $('#cuisine').html(response);
        });


        $(".span12 > button.btn.no-display").click(function (e) {
            var id_rec = [];
            $("#menuDrop").find(".rec_id").filter(function (index) {
                var count = $(this).parent().find(".rec_count").val();
                for(var i=0;i<count;i++)id_rec.push($(this).text());
                return true;
            });
            var map ={};
            for (var i = 0; i<id_rec.length; i++){
                if(map[id_rec[i]] == null){
                    map[id_rec[i]] = 0;
                }
                map[id_rec[i]] = ++map[id_rec[i]];
            }
            var params = '';
            for(param in map){
                params += param + '=' + map[param] + '&';
            }
            lv_url = "/summarizingListForWeek?" + params;
            $("#modalForSummarizingList").load(lv_url);
        });

        $('.btn.btn-large.no-outline').click(function () {

            $('#hiddens').show(500, animateSlidebarOnFirstshow);

            var myMeal = $(this).attr("value");
            $('#menuDrop').children().hide();
            $(myMeal).show();


            var heightArray = $(".block-create-menu").map(
                    function () {
                        return $(this).height();
                    }).get();
            var maxHeight = Math.max.apply(Math, heightArray);
            $(".block-create-menu").height(maxHeight);
        });

        $('.dayOfWeekButton').click(function () {
            $('#mealNameButtons').show(500);

            var clickedDayValue = $(this).attr("value");

            $('#mealNameButtons').children()[0].setAttribute ("value","#" + clickedDayValue + "_breakfast");
            $('#mealNameButtons').children()[1].setAttribute ("value","#" + clickedDayValue + "_dinner");
            $('#mealNameButtons').children()[2].setAttribute ("value","#" + clickedDayValue + "_supper");
            $('#mealNameButtons').children()[0].click();
        });

    });
</script>

[#--Slider JavaScript--]
<script type="text/javascript">
    $(document).ready(function () {
        $("#slider-range").slider({
            range:true,
            min:6,
            max:540,
            values:[ 240, 250 ],
            animate: true,
            slide:function (event, ui) {
                $("#amount").val("от " + parseInt((ui.values[ 0 ]) / 60 % 24, 10) + "ч. " + parseInt((ui.values[ 0 ]) % 60,
                        10) + "мин." + " до " + parseInt((ui.values[ 1 ]) / 60 % 24,
                        10) + "ч. " + parseInt((ui.values[ 1 ]) % 60, 10) + "мин.");
                filterRecipies(ui.values);
            }
        });
    });
</script>

[#--Time filtering JavaScript--]
<script type="text/javascript">
    function filterRecipies(values) {
        $("#cuisine").find(".btn.recepies_btn").filter(function (index) {
                    if (($(this).find(".time_value").text() >= values[0]) && ($(this).find(".time_value").text() <= values[1]) && ($(this).find(".cat_value").text() == $('#myTab .active a').attr('id') )) {
                        $(this).show();
                    }
                    else {
                        $(this).hide();
                    }
                    return true;
                }
        );
    }

</script>


<div class="btn-group no-outline" data-toggle="buttons-radio">
    [#assign dayNames = [["Пн","Mo","понедельник"], ["Вт","Tu","вторник"], ["Ср","We","среду"], ["Чт","Th","четверг"],
                    ["Пт","Fr","пятницу"], ["Сб","Sa","субботу"], ["Вс","Su","воскресенье"]]]
    [#list dayNames as i]
        <button class="btn btn-large dayOfWeekButton" value="${i[1]}" >
            <div class="breakfastMarker"></div>
            <div class="dinnerMarker"></div>
            <div class="supperMarker"></div>
            <div style="position: absolute; top:0 ; left:0; width: 100%; height: 100%; text-align: center; height: 3em;line-height: 3em;">${i[0]}</div>
        </button>
    [/#list]
</div>

[#--Marking buttons of week in compliance of mealName--]
<script type="text/javascript">
    function markButtonDayOfWeek(targetButtonValue, mealName) {
        $(".dayOfWeekButton[value='" + targetButtonValue + "']").children("." + mealName + "Marker").addClass("marked");
    }
    function unmarkButtonDayOfWeek(targetButtonValue, mealName) {
        $(".dayOfWeekButton[value='" + targetButtonValue + "']").children("." + mealName + "Marker").removeClass("marked");
    }
</script>

<div class="btn-group no-outline hide" id="mealNameButtons" data-toggle="buttons-radio">
    <button class="btn btn-large no-outline" value="#breakfast">Завтрак</button>
    <button class="btn btn-large no-outline" value="#dinner">Обед</button>
    <button class="btn btn-large no-outline" value="#supper">Ужин</button>
</div>
<div id="hiddens" style="display:none">

    <div class="row-fluid">
        <div class="span6" id="menuDrop">

            [#assign mealNames = [["завтрак","breakfast"], ["обед", "dinner"], ["ужин", "supper"]]]
            [#list dayNames as dayName]
                [#list mealNames as mealName]
                    <div class="block-create-menu droppable" id="${dayName[1]}_${mealName[1]}">
                        <h1>Ваш ${mealName[0]} на ${dayName[2]}</h1>

                        <div class="span12">
                            <button class="btn no-display no-outline" data-toggle="modal"
                                    data-target="#modalForSummarizingList">Готово
                            </button>
                        </div>
                    </div>
                [/#list]
            [/#list]
            <div class="modal fade" id="modalForSummarizingList"></div>
        </div>

        <div class="span6 align2">
            <div class="block-create-menu" id="rec">
                <div id="menu-header"><h1>Рецепты</h1></div>
                <p>
                <h5><label for="amount">Время приготовления</label></h5>
                <input readonly="readonly" type="input-small" id="amount" class="slider-input"/>
                </p>
                <div class="sliderCont">
                <div id="slider-range" class="no-outline"></div>
                </div>
                <div class="content" id="cuisine"></div>

            </div>

        </div>
    </div>

</div>


[/#assign]
[#include "structure.ftl"/]