[#ftl]
<div class="modal-header noprint">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h4 id="myModalLabel">Итого</h4>
</div>

<ul class="nav nav-tabs noprint" id="summarizingTab">
    <li class="active"><a href="#1" id="1">Ингридиенты</a></li>
    <li><a href="#2" id="2">Меню</a></li>
</ul>

<script type="text/javascript">
    $(function () {
        $('#summarizingTab a:first').tab('show');
    })
    $('#summarizingTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
        $(".summarizingContentTab").hide();
        $(".summarizingContentTab#tab" + $(this).attr('id')).show();
    })
</script>

<div class="summarizingContentTab" id="tab1">
    <div class="modal-body">
    <span class="text-justify">

        <table class="table table-striped table-bordered table-condensed font-12">
        [#list model as a]
            <tr>
                <td>${a.ingredient.name}</td>
                <td>${a.countOfIngredient}</td>
                <td>${a.measuresBucket.measure.title}</td>
            </tr>
        [/#list]
        </table>
        <br/>
    </span>
    </div>
    <div class="modal-footer noprint">
        <button class="btn btn-primary pull-left" onclick="printBlock('#modalForSummarizingList')">Печать</button>
    </div>
</div>

<div class="summarizingContentTab" id="tab2" style="display: none;">
    <div class="modal-body">
        <div class="row-fluid text-cener" id="tab20">

            <div class="span12 text-cener " data-name="dayOfWeek" style="display: none"><h4></h4></div>

            <div class="span4" style="display: none" id="tab21">
                <h5></h5>
                <table class="table table-bordered table-condensed font-12 fixed-table">
                    <tr>
                        <td class="summListRecipeName">Название</td>
                        <td>
                            <nobr>К/Порция</nobr>
                        </td>
                        <td>
                            <nobr>Выход</nobr>
                        </td>
                    </tr>
                </table>
            </div>

            <div style="display: none" id="tab22">
                <div class="span12">
                    <div class="span4 text-right"><span data-name="br_kkal"></span> ккал.</div>
                    <div class="span4 text-right"><span data-name="dn_kkal"></span> ккал.</div>
                    <div class="span4 text-right"><span data-name="sp_kkal"></span> ккал.</div>
                </div>
                <div class="span12 text-right"><strong>Всего: <span data-name="itogo_kkal"></span> ккал.</strong></div>
            </div>

            <div id="week_kkal" class="span12 text-right">
                <strong>Всего за неделю: <span></span> ккал.</strong>
            </div>

        </div>


    </div>
    <div class="modal-footer noprint">
        <button class="btn btn-primary pull-left" onclick="printBlock('#modalForSummarizingList')">Печать</button>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var dayNames = [
            ["Пн", "Mo", "Понедельник"],
            ["Вт", "Tu", "Вторник"],
            ["Ср", "We", "Среда"],
            ["Чт", "Th", "Четверг"],
            ["Пт", "Fr", "Пятница"],
            ["Сб", "Sa", "Суббота"],
            ["Вс", "Su", "Воскресенье"]
        ];
        var mealNames = [
            ["Завтрак", "breakfast"],
            ["Обед", "dinner"],
            ["Ужин", "supper"]
        ];

        var breakfast;
        var dinner;
        var supper;
        var meal_cal = [];
        var day_cal;
        var week_cal = 0;


        for (var i = 0; i < dayNames.length; i++) {
            day_cal = 0;

            breakfast = dayNames[i][1] + "_" + mealNames[0][1];
            dinner = dayNames[i][1] + "_" + mealNames[1][1];
            supper = dayNames[i][1] + "_" + mealNames[2][1];

            if (($("#" + breakfast).find("label.title").length == 0) && ($("#" + dinner).find("label.title").length == 0) &&
                    ($("#" + supper).find("label.title").length == 0)) {
                continue;
            }
            ;

            $("div[data-name='dayOfWeek']:first").clone().removeAttr("style").appendTo("#tab20").find("h4").text(dayNames[i][2]);

            for (var j = 0; j < mealNames.length; j++) {
                meal_cal[j] = 0;

                $("#tab21").clone().attr("id", dayNames[i][1] + "_" + mealNames[j][1] + "_sum").removeAttr("style").appendTo("#tab20").find("h5").text(mealNames[j][0]);

                $("#" + dayNames[i][1] + "_" + mealNames[j][1]).find("label.title").filter(function (index) {
                    var name = $(this).text();
                    var count = $(this).parent().parent().find("input.rec_count").val();
                    var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);

                    $("#" + dayNames[i][1] + "_" + mealNames[j][1] + "_sum  table").append("<tr><td class='summListRecipeName'>"
                            + name + "</td><td><nobr>" + count + "x</nobr></td><td><nobr></nobr></td></tr>");

                    meal_cal[j] += cal * count;
                    return true;
                });
                day_cal += meal_cal[j];
            }
            ;
            week_cal += day_cal;
            $("#tab22").clone().attr("id", dayNames[i][1] + "_cal").removeAttr("style").appendTo("#tab20");
            $("#" + dayNames[i][1] + "_cal  span[data-name='br_kkal']").text(meal_cal[0]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='dn_kkal']").text(meal_cal[1]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='sp_kkal']").text(meal_cal[2]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='itogo_kkal']").text(day_cal);
        }
        ;
        $("#week_kkal  span").text(week_cal);
        $("#week_kkal").appendTo("#tab20");

    });

</script>


