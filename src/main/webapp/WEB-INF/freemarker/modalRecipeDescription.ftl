[#ftl]
<div id="header" class="modal-header" style="display: none;">
    <button id="close" type="button" class="close noprint" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel" class="modal-label">${recipe.title}</h3>
</div>
<div id="body" class="modal-body" style="display: none;">
    <div class="row-fluid">
        <div class="span6" id="modal-recipe-img">
            <a href="${recipe.bigImage}" target="_blank"> <img src="${recipe.bigImage}"
                                                               class="img-rounded img-recipe-modal" id="image"/>
            </a>
        </div>

        <div class="span6 align2 text-left">
        <br/>
    [#list markers?keys as key]
        <p><img src="${markers[key]}" title="${key}" id="markers"/> - ${key}</p>
    [/#list]
        <p><strong>Время приготовления:</strong> ${recipe.timeOfCooking} минут </p>
        </div>

    </div>
    <span class="text-justify">

    <br/>
    <p><strong>Описание:</strong> ${recipe.description}</p>
    <br/>

    <p><strong>Ингридиенты: </strong></p>
    <table class="table table-striped table-bordered table-condensed">
    [#list recipe.ingredients as a]
        <tr>
            <td>${a.ingredient.name}</td>
            <td>${a.countOfIngredient}</td>
            <td>${a.measuresBucket.measure.title}</td>
        </tr>
    [/#list]
    </table>
    [#list recipe.steps as a]
        <p><strong>Шаг ${a.number}</strong></p>

    <a href="${a.image}" target="_blank"> <img src="${a.image}" class="img-rounded img-recipe-modal-step"
                                               id="image"/></a>

    <p style="word-wrap: break-word;">${a.description}</p>
    [/#list]
    </span>
</div>
<div class="modal-footer noprint">
    <button class="btn btn-primary pull-left " onclick="printBlock('#myModal')">Печать</button>

    <button class="btn btn-success" style="display: none;" data-dismiss="modal" onclick="addButtonClick(${recipe.id})">
        Добавить
    </button>
</div>

<script type="text/javascript">
    $("div .rec_id").filter(function (index) {
        if ($(this).text() == "${recipe.id}") {
            $("div.modal-footer > button.btn-success").css('display', 'inline-block');
            return true;
        }
        return false;
    });
    function addButtonClick(id) {
        var elem = $("div .rec_id").filter(function (index) {
            return ($(this).text() == "${recipe.id}") && ($(this).parent().find(".rec_count").length == 0);
        }).parent();
        addToMenuByCloning(elem, $(".droppable:visible"));
    }

</script>

<script type="text/javascript">
    $("#close").click(function () {
        $("#image").hide();
    })
</script>
