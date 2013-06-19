[#ftl]
<div class="modal-header noprint">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h4 id="myModalLabel">Итого</h4>
</div>

<ul class="nav nav-tabs" id="summarizingTab">
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
        $(".summarizingContentTab#tab"+$(this).attr('id')).show();
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
    </div>
    <div class="modal-footer noprint">
        <button class="btn btn-primary pull-left" onclick="printBlock('#modalForSummarizingList')">Печать</button>
    </div>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        var br_cal = 0;
        var dn_cal = 0;
        var sp_cal = 0;

        $("#breakfast").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            $("#br_sum").append("<tr><td>" + name + "</td><td><nobr>x " + count + "</nobr></td></tr>");
            br_cal += cal * count;
            return true;
        });

        $("#dinner").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            $("#dn_sum").append("<tr><td>" + name + "</td><td><nobr>x " + count + "</nobr></td></tr>");
            dn_cal += cal * count;
            return true;
        });

        $("#supper").find("label.title").filter(function (index) {
            var name = $(this).text();
            var count = $(this).parent().parent().find("input.rec_count").val();
            var cal = parseInt($(this).parent().parent().find("div.rec_cal").text().replace(/\s+/g, ''), 10);
            $("#sp_sum").append("<tr><td>" + name + "</td><td><nobr>x " + count + "</nobr></td></tr>");
            sp_cal += cal * count;
            return true;
        });

        $("#br_kkal").text(br_cal);
        $("#dn_kkal").text(dn_cal);
        $("#sp_kkal").text(sp_cal);

        $("#itogo_kkal").text(br_cal + dn_cal + sp_cal);

    });
</script>
