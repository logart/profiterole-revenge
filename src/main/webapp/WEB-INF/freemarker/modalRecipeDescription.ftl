[#ftl]
<div id="header" class="modal-header" style="display: none;">
    <button id="close" type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel" style="word-wrap: break-word;">${recipe.title}</h3>
</div>
<div id="body" class="modal-body" style="display: none;">
    <img src="${recipe.bigImg}" class="img-rounded" id="image"/>

    <span class="text-justify">
    <br/>
    <p><strong>Время приготовления:</strong> ${recipe.time} минут </p>
    <br/>
    <p><strong>Ингридиенты: </strong></p>
    <table class="table table-striped table-bordered table-condensed">
    [#list ingridient as a]
        <tr>
            <td>${a.nameOfIngridient}</td>
            <td>${a.countOfIngridient}</td>
            <td>${a.unitOfMeasure}</td>
        </tr>
    [/#list]
    </table>
    <br/>
    [#list step as a]
        <p><strong>Шаг ${a.stepNumber}</strong></p>

    <p style="word-wrap: break-word;">${a.stepDescription}</p>
    [/#list]
        </span>
</div>
<div class="modal-footer">
    <button class="btn btn-primary">Печать</button>
</div>

<script type="text/javascript">
    $("#close").click(function () {
        $("#image").hide();
    })
</script>