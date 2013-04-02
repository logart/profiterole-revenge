[#ftl]
[#assign content]

<script type="text/javascript">

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
            lv_url = "/summarizingList?recipesId=" + id_rec;
            $("#modalForSummarizingList").load(lv_url);
        });

        $('.btn.btn-large.no-outline').click(function () {

            $('#hiddens').show(500);

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

    });
</script>

[#--Slider JavaScript--]
<script type="text/javascript">
    $(document).ready(function () {
        $("#slider-range").slider({
            range:true,
            min:6,
            max:540,
            values:[ 6, 60 ],
            slide:function (event, ui) {
                $("#amount").val(parseInt((ui.values[ 0 ]) / 60 % 24, 10) + ":" + parseInt((ui.values[ 0 ]) % 60, 10) +
                        " - " + parseInt((ui.values[ 1 ]) / 60 % 24, 10) + ":" + parseInt((ui.values[ 1 ]) % 60, 10));
                filterRecipies(ui.values);
            }
        });
        $("#amount").val(parseInt($("#slider-range").slider("values", 0) / 60 % 24, 10) + ":" + parseInt($("#slider-range").slider("values", 0) % 60, 10) +
                "-" + parseInt($("#slider-range").slider("values", 1) / 60 % 24, 10) + ":" + parseInt($("#slider-range").slider("values", 1) % 60, 10));
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
    <button class="btn btn-large no-outline" value="#breakfast">Завтрак</button>

    <button class="btn btn-large no-outline" value="#dinner">Обед</button>
    <button class="btn btn-large no-outline" value="#supper">Ужин</button>
</div>
<div id="hiddens" style="display:none">

    <div class="row-fluid">
        <div class="span6" id="menuDrop">
            <div class="block-create-menu droppable" id="breakfast">
                <h1>Ваш завтрак</h1>

                <div class="span12">
                    <button class="btn no-display no-outline" data-toggle="modal"
                            data-target="#modalForSummarizingList">Готово
                    </button>
                </div>
            </div>
            <div class="block-create-menu droppable" id="dinner">
                <h1>Ваш обед</h1>

                <div class="span12">
                    <button class="btn no-display no-outline" data-toggle="modal"
                            data-target="#modalForSummarizingList">Готово
                    </button>
                </div>
            </div>
            <div class="block-create-menu droppable" id="supper">
                <h1>Ваш ужин</h1>

                <div class="span12">
                    <button class="btn no-display no-outline" data-toggle="modal"
                            data-target="#modalForSummarizingList">Готово
                    </button>
                </div>
            </div>
            <div class="modal fade" id="modalForSummarizingList"></div>
        </div>

        <div class="span6 align2">
            <div class="block-create-menu" id="rec">
                <div id="menu-header"><h1>Рецепты</h1></div>
                <p>
                <h5><label for="amount">Время приготовления</label></h5>
                <input readonly="readonly" type="input-small" id="amount" class="slider-input"/>
                </p>
                <div id="slider-range" class="no-outline"></div>

                <div class="content" id="cuisine"></div>

            </div>

        </div>
    </div>

</div>


[/#assign]
[#include "structure.ftl"/]