[#ftl]
[#assign content]

<script type="text/javascript">

    $(document).ready(function () {

        $.get("/menuCuisinesAjax", function (response) {
            $('#cuisine').html(response);
        });


        $('.btn').click(function () {

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

[#--Slider java-script--]
<script type="text/javascript">
    $(function () {
        $("#slider-range").slider({
            range:true,
            min:0,
            max:540,
            values:[ 0, 300 ],
            slide:function (event, ui) {
                $("#amount").val(parseInt((ui.values[ 0 ]) / 60 % 24, 10) + " : " + parseInt((ui.values[ 0 ]) % 60, 10) +
                        " - " + parseInt((ui.values[ 1 ]) / 60 % 24, 10) + " : " + parseInt((ui.values[ 1 ]) % 60, 10));
                filterRecipies();
            }
        });
        $("#amount").val(parseInt($("#slider-range").slider("values", 0) / 60 % 24, 10) + " : " + parseInt($("#slider-range").slider("values", 0) % 60, 10) +
                " - " + parseInt($("#slider-range").slider("values", 1) / 60 % 24, 10) + " : " + parseInt($("#slider-range").slider("values", 1) % 60, 10));
    });


</script>

[#--Time filtering Java-script--]
<script type="text/javascript">
    function filterRecipies() {
        var slider_values = $("#slider-range").slider("option", "values");
        $(".btn.recepies_btn").filter(function (index) {

                    if (($(this).find(".time_value").text() >= slider_values[0]) && ($(this).find(".time_value").text() <= slider_values[1]) && ($(this).find(".cat_value").text() == $('#myTab .active a').attr('id') )) {
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

<div class="btn-group" data-toggle="buttons-radio">
    <button class="btn btn-large" value="#breakfast">Завтрак</button>

    <button class="btn btn-large" value="#dinner">Обед</button>
    <button class="btn btn-large" value="#supper">Ужин</button>
</div>
<div id="hiddens" style="display:none">

    <div class="row-fluid">
        <div class="span6" id="menuDrop">
            <div class="block-create-menu" id="breakfast">
                <h1>Завтрак</h1>
            </div>
            <div class="block-create-menu" id="dinner">
                <h1>Обед</h1>
            </div>
            <div class="block-create-menu" id="supper">
                <h1>Ужин</h1>
            </div>

        </div>
        <div class="span6 align2">
            <div class="block-create-menu" id="rec">
                <p>
                    <label for="amount"><h5>Time range:</h5></label>
                    <input type="text" id="amount" style="border: 0; color: #f6931f; font-weight: bold;"/>
                </p>

                <div id="slider-range"></div>

                <div id="cuisine"></div>


            </div>

        </div>
    </div>

</div>


[/#assign]
[#include "structure.ftl"/]