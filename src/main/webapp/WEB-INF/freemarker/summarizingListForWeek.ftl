[#ftl]
<div class="modal-header noprint">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h4 id="myModalLabel">Итого</h4>
</div>

<ul class="nav nav-tabs noprint" id="summarizingTab">
    <li class="active"><a href="#1" id="1">Меню</a></li>
    <li><a href="#2" id="2">Ингридиенты</a></li>
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
        <div class="row-fluid text-cener" id="tab10">

            <div class="span12 text-cener " data-name="dayOfWeek" style="display: none"><h4></h4></div>

            <div class="span4" style="display: none" id="tab11">
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

            <div style="display: none" id="tab12">
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
        <button class="btn btn-primary pull-left" onclick="menuPDF()">Меню в PDF</button>
    </div>
</div>

<div class="summarizingContentTab" id="tab2" style="display: none;">
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
        <button class="btn btn-primary pull-left" onclick="menuPDF()">Меню в PDF</button>
    </div>
</div>

<script type="text/javascript">

    var breakfastDishes = [];
    var dinnerDishes = [];
    var supperDishes = [];

    var mondayMenu = [];
    var tuesdayMenu = [];
    var wednesdayMenu = [];
    var thursdayMenu = [];
    var fridayMenu = [];
    var saturdayMenu = [];
    var sundayMenu = [];
    var weekMenu = [];

                    function menuPDF() {
                        $.ajax({
                        type: "post",
                        url: "http://localhost:8080/weekMenuPDF",
                        contentType: "application/json",
                        data: JSON.stringify({weekMenu:weekMenu}),
                        cache: false,
                        success: function(response) {
                            alert('PDF generated success!');
                    
                        },
                        error: function() {
                            alert('Error while request..');
                        }
                    });
                    }

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
        var PORTION_ROUNDING = 0.5;


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

            $("div[data-name='dayOfWeek']:first").clone().removeAttr("style").appendTo("#tab10").find("h4").text(dayNames[i][2]);

            for (var j = 0; j < mealNames.length; j++) {
                meal_cal[j] = 0;

                $("#tab11").clone().attr("id", dayNames[i][1] + "_" + mealNames[j][1] + "_sum").removeAttr("style").appendTo("#tab10").find("h5").text(mealNames[j][0]);

                $("#" + dayNames[i][1] + "_" + mealNames[j][1]).find("label.title").filter(function (index) {
                    var name = $(this).text();
                    var count = $(this).parent().parent().find("input.rec_count").val();
                    var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
                    var portion = parseInt($(this).parent().parent().find("div.rec_portion").text(), 10);
                    var quantityOfDish = parseInt($(this).parent().parent().find("div.rec_dish_quantity").text(), 10);

                    quantityOfDish *= count;
                    var tempPortion =  quantityOfDish % portion;
                    if ((tempPortion / portion) > PORTION_ROUNDING) {
                        tempPortion = quantityOfDish / portion;
                        tempPortion = tempPortion - (tempPortion % 1);
                        tempPortion++;
                    }  else {
                        tempPortion = quantityOfDish / portion;
                        tempPortion = tempPortion - (tempPortion % 1);
                    }

                    $("#" + dayNames[i][1] + "_" + mealNames[j][1] + "_sum  table").append("<tr><td class='summListRecipeName'>"
                            + name + "</td><td><nobr>" + tempPortion + "x" + portion + "</nobr></td><td><nobr>" +
                            quantityOfDish + "</nobr></td></tr>");

                    meal_cal[j] += cal * count;
                    if (j==0){
                     breakfastDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
                    }
                    if (j==1){
                     dinnerDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
                    }
                    if (j==2){                     
                     supperDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
                    }
                    return true;
                });

                day_cal += meal_cal[j];
            }
            ;

            week_cal += day_cal;
            $("#tab12").clone().attr("id", dayNames[i][1] + "_cal").removeAttr("style").appendTo("#tab10");
            $("#" + dayNames[i][1] + "_cal  span[data-name='br_kkal']").text(meal_cal[0]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='dn_kkal']").text(meal_cal[1]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='sp_kkal']").text(meal_cal[2]);
            $("#" + dayNames[i][1] + "_cal  span[data-name='itogo_kkal']").text(day_cal);

            
            if(i==0){
                mondayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==1){
                tuesdayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==2){
                wednesdayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==3){
                thursdayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==4){
                fridayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==5){
                saturdayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            if(i==6){
                sundayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
            }
            
        };
        weekMenu.push({mondayMenu:mondayMenu,tuesdayMenu:tuesdayMenu,wednesdayMenu:wednesdayMenu,thursdayMenu:thursdayMenu,fridayMenu:fridayMenu,saturdayMenu:saturdayMenu,sundayMenu:sundayMenu});    
        
        $("#week_kkal  span").text(week_cal);
        $("#week_kkal").appendTo("#tab10");

    });

</script>


