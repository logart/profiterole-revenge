[#ftl]
[#assign content]
<script type="text/javascript">

    $(document).ready(function () {

        $.get("/cuisinesAjax", function (response) {
            $('#cuisine').html(response);
        });

    });
</script>
<div class="row-fluid">
    <h2>Рецепты</h2>
    <div class="span12 align2">
        <div id="rec">
            <div id="menu-header"><h4>Выберите кухню</h4></div>
            <div class="content paddingBig" id="cuisine"></div>

        </div>

    </div>
</div>
[/#assign]
[#include "structure.ftl"/]