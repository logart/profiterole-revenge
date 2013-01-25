[#ftl]


<div class="accordion" id="accordion2">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                Закуски
            </a>
        </div>
        <div id="collapseOne" class="accordion-body collapse">
            <div class="accordion-inner paddingBig">
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                Первое
            </a>
        </div>
        <div id="collapseTwo" class="accordion-body collapse">
            <div class="accordion-inner paddingBig">
            </div>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                Второе
            </a>
        </div>
        <div id="collapseThree" class="accordion-body collapse">
            <div class="accordion-inner paddingBig">
            </div>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                Десерты
            </a>
        </div>
        <div id="collapseFour" class="accordion-body collapse">
            <div class="accordion-inner paddingBig">
            </div>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
                Напитки
            </a>
        </div>
        <div id="collapseFive" class="accordion-body collapse">
            <div class="accordion-inner paddingBig">
            </div>
        </div>
    </div>
</div>

<div class="cuisine_value no-display">${cuisineTitle}</div>

<div class="no-display">
[#list model as a]

    <div class="recipe_on_page btn-link" data-cat_value="${a.categories.categoriesId}" data-content="${a.description}"
         href="/modalRecipeDescription?recipeId=${a.recipeId}" data-toggle="modal"
         data-target="#myModal">${a.title}</div>

[/#list]
</div>

<div class="modal fade text-cener" id="myModal">

</div>

<div style="clear: both;"></div>

<button class="btn" id="back">Назад к кухням</button>

<script type="text/javascript">

    $('#back').click(function () {
        $.get("/allCuisines", function (response) {
            $('#cuisine').html(response);

        });
    });

    $(".recipe_on_page[data-toggle=modal]").click(function (e) {
        lv_target = $(this).attr('data-target');
        lv_url = $(this).attr('href');
        $(lv_target).load(lv_url, function () {
            $("#header").show();
            $("#body").show();
        });

    })

</script>


<script type="text/javascript">

    $(document).ready(function () {
        var text = $(".cuisine_value").text() + " кухня";
        $("#menu-header h4").html(text);

        $(".recipe_on_page").filter(function (index) {
            var local = $(this).attr('data-cat_value');
            if (local == 1) {
                $("#collapseOne").find(".accordion-inner").append(this);
            }
            else if (local == 2) {
                $("#collapseTwo").find(".accordion-inner").append(this);
            }
            else if (local == 3) {
                $("#collapseThree").find(".accordion-inner").append(this);
            }
            else if (local == 4) {
                $("#collapseFour").find(".accordion-inner").append(this);
            }
            else {
                $("#collapseFive").find(".accordion-inner").append(this);
            }


        });
    });
</script>


<script type="text/javascript">

    $('#back').click(function () {
        $.get("/cuisinesAjax", function (response) {
            $('#cuisine').html(response);
            $("#menu-header h4").text("Выберите кухню");

        });
    });

</script>