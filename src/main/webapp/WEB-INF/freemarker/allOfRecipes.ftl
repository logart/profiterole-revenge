[#ftl]
[#assign content]
<script type="text/javascript">

    $(document).ready(function () {

        $.get("/cuisinesAjax", function (response) {
            $('#cuisine').html(response);
        });

    });
</script>
    <h2>Рецепты</h2>
    <div class="white-block">
            <div id="menu-header"><h4>Выберите кухню</h4></div>
            <div class="content paddingBig" id="cuisine"></div>

    </div>
[/#assign]
[#include "structure.ftl"/]