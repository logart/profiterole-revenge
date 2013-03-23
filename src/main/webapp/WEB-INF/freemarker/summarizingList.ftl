[#ftl]
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h4 id="myModalLabel">Итого</h4>
</div>
<div class="modal-body">
    <div class="row-fluid text-cener">
        <div class="span4">
            <h4>Завтрак</h4>
            <table class="table table-bordered table-condensed font-12" id="br_sum">
            </table>
        </div>
        <div class="span4">
            <h4>Обед</h4>
            <table class="table table-bordered table-condensed font-12" id="dn_sum">
            </table>
        </div>
        <div class="span4">
            <h4>Ужин</h4>
            <table class="table table-bordered table-condensed font-12" id="sp_sum">
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
<div class="modal-footer">
    <button class="btn btn-primary">Печать</button>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        var br_mas = [];
        var dn_mas = [];
        var sp_mas = [];

        var br_cal = 0;
        var dn_cal = 0;
        var sp_cal = 0;

        $("#breakfast").find("label.title").filter(function (index) {
            br_mas.push($(this).text());
            return true;
        });
        $.each(br_mas, function (index, value) {
            $("#br_sum").append("<tr><td>" + this + "</td></tr>");
        });

        $("#dinner").find("label.title").filter(function (index) {
            dn_mas.push($(this).text());
            return true;
        });
        $.each(dn_mas, function (index, value) {
            $("#dn_sum").append("<tr><td>" + this + "</td></tr>");
        });

        $("#supper").find("label.title").filter(function (index) {
            sp_mas.push($(this).text());
            return true;
        });
        $.each(sp_mas, function (index, value) {
            $("#sp_sum").append("<tr><td>" + this + "</td></tr>");
        });

        $("#breakfast").find("div.rec_cal").filter(function (index) {
            br_cal += parseInt($(this).text().replace(/\s+/g, ''), 10);
            return true;
        });
        $("#br_kkal").text(br_cal);

        $("#dinner").find("div.rec_cal").filter(function (index) {
            dn_cal += parseInt($(this).text(), 10);
            return true;
        });
        $("#dn_kkal").text(dn_cal);

        $("#supper").find("div.rec_cal").filter(function (index) {
            sp_cal += parseInt($(this).text(), 10);
            return true;
        });
        $("#sp_kkal").text(sp_cal);

        $("#itogo_kkal").text(br_cal + dn_cal + sp_cal);

    });
</script>