[#ftl]
[#assign content]

<script type="text/javascript">

    $(document).ready(function () {


        $('.btn.btn-large-admin').click(function () {
            $('#choice').show(500);

            var clickedEntityValue = $(this).attr("value");

            $('#choice').children()[0].setAttribute ("value","#" + clickedEntityValue + "_delete");
            $('#choice').children()[1].setAttribute ("value","#" + clickedEntityValue + "_add");
            $('#choice').children()[2].setAttribute ("value","#" + clickedEntityValue + "_change");
            $('#choice').children()[0].click();
        });



    });
</script>


    <div class="btn-group no-outline" id="choiceFrom" data-toggle="buttons-radio">
        [#assign entityNames = [["Рецепт","Recipe","rec"], ["Ингредиент","Ingredient","ingr"], ["Тип ингредиентов","Type","typ"], ["Мера измерения","Measures","meas"]]]
        [#list entityNames as i]
            <button class = " btn btn-large-admin" value "${i[2]}">${i[1]}</button>
        [/#list]
    </div>

    <div class="btn-group no-outline hide" id="choice" data-toggle="buttons-radio">

        [#assign choiceButtons = [["Удалить","delete"], ["Добавить", "add"], ["Изменить", "change"]]]
        [#list choiceButtons as i]
             <button class = " btn btn-large no-outline" value "${i[1]}">${i[0]}</button>
        [/#list]

    </div>



[/#assign]
[#include "structure.ftl"/]