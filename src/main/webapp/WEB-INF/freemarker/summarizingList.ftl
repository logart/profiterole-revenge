[#ftl]
<div class="modal-header noprint">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h4 id="myModalLabel">Итого</h4>
</div>
<div class="modal-body">
    <div class="row-fluid text-cener">
        <div class="span4">
            <h4>Завтрак</h4>
            <table class="table table-bordered table-condensed font-12 fixed-table" id="br_sum">
                <tr>
                    <td class="summListRecipeName1">Название</td>
                    <td>
                        <nobr>К/Порция</nobr>
                    </td>
                    <td>
                        <nobr>Выход</nobr>
                    </td>
                </tr>
            </table>
        </div>
        <div class="span4">
            <h4>Обед</h4>
            <table class="table table-bordered table-condensed font-12 fixed-table" id="dn_sum">
                <tr>
                    <td class="summListRecipeName2">Название</td>
                    <td>
                        <nobr>К/Порция</nobr>
                    </td>
                    <td>
                        <nobr>Выход</nobr>
                    </td>
                </tr>
            </table>
        </div>
        <div class="span4">
            <h4>Ужин</h4>
            <table class="table table-bordered table-condensed font-12 fixed-table" id="sp_sum">
                <tr>
                    <td class="summListRecipeName3">Название</td>
                    <td>
                        <nobr>К/Порция</nobr>
                    </td>
                    <td>
                        <nobr>Выход</nobr>
                    </td>
                </tr>
            </table>
        </div>
        <div class="span12">
            <div class="span4 text-right"><span id="br_kkal"></span> ккал.</div>
            <div class="span4 text-right"><span id="dn_kkal"></span> ккал.</div>
            <div class="span4 text-right"><span id="sp_kkal"></span> ккал.</div>
        </div>
        <div class="span12 text-right"><strong>Всего: <span id="itogo_kkal"></span> ккал.</strong></div>
    </div>
    <span class="text-justify">
    <p><h4>Ингридиенты: </h4></p>
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

<script type="text/javascript">
    var breakfastDishes = [];
    var dinnerDishes = [];
    var supperDishes = [];
    var dayMenu = [];
    var weekMenu = [];
    var ingridients = [];
   
    [#list model as a]
          ingridients.push({ingridientId:${a.ingredient.id}});
    [/#list]
    
    
    function menuPDF() {$.ajax({
                        type: "post",
                        url: "http://localhost:8080/menuPDF",
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
        var br_cal = 0;
        var dn_cal = 0;
        var sp_cal = 0;
        var PORTION_ROUNDING = 0.5;

        $("#breakfast").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            var portion = parseInt($(this).parent().parent().find("div.rec_portion").text(), 10);
            var quantityOfDish = parseInt($(this).parent().parent().find("div.rec_dish_quantity").text(), 10);
            quantityOfDish *= count;
            $("#br_sum").append("<tr><td class='summListRecipeName1'>" + name + "</td><td><nobr> " +
                    calcDish(portion, quantityOfDish) + "x" + portion + "</nobr></td><td><nobr>" + quantityOfDish +
                    "</nobr></td></tr>");
            br_cal += cal * count;
            breakfastDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
            return true;
        });

        $("#dinner").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            var portion = parseInt($(this).parent().parent().find("div.rec_portion").text(), 10);
            var quantityOfDish = parseInt($(this).parent().parent().find("div.rec_dish_quantity").text(), 10);
            quantityOfDish *= count;
            $("#dn_sum").append("<tr><td class='summListRecipeName2'>" + name + "</td><td><nobr> " +
                    calcDish(portion, quantityOfDish) + "x" + portion + "</nobr></td><td><nobr>" + quantityOfDish +
                    "</nobr></td></tr>");
            dn_cal += cal * count;
            dinnerDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
            return true;
        });

        $("#supper").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            var portion = parseInt($(this).parent().parent().find("div.rec_portion").text(), 10);
            var quantityOfDish = parseInt($(this).parent().parent().find("div.rec_dish_quantity").text(), 10);
            quantityOfDish *= count;
            $("#sp_sum").append("<tr><td class='summListRecipeName3'>" + name + "</td><td><nobr> " +
                    calcDish(portion, quantityOfDish) + "x" + portion + "</nobr></td><td><nobr>" + quantityOfDish +
                    "</nobr></td></tr>");
            sp_cal += cal * count;
            supperDishes.push({ name:name,count:count,cal:cal,portion:portion,quantityOfDish:quantityOfDish  });
            return true;
        });

 

        dayMenu.push({breakfast:breakfastDishes,dinner:dinnerDishes,supper:supperDishes});
        weekMenu.push({mondayMenu:dayMenu,ingridients:ingridients});

        $("#br_kkal").text(br_cal);
        $("#dn_kkal").text(dn_cal);
        $("#sp_kkal").text(sp_cal);

        $("#itogo_kkal").text(br_cal + dn_cal + sp_cal);

        function calcDish(portion, quantityOfDish) {
            var tempPortion = quantityOfDish % portion;
            if ((tempPortion / portion) > PORTION_ROUNDING) {
                tempPortion = quantityOfDish / portion;
                tempPortion = tempPortion - (tempPortion % 1);
                tempPortion++;
            } else {
                tempPortion = quantityOfDish / portion;
                tempPortion = tempPortion - (tempPortion % 1);
            }
            return   tempPortion;
        }

    });

</script>
