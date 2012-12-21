[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]

<script>
    $(document).ready(function () {
        var k = $('conress').size() + 2;
        $('#adding').click(function () {
            $('<div id=k><p>' +
                    '<div>' +
                    "<a href='#' style='position: relative; background-position: -98px -130px;' title='Удалить ингредиент' class='ui-icon ui-icon-trash' onclick=\"$(this).parent().popover('destroy').remove(); return false;\">Удалить ингредиент</a>" +
                [@spring.bind "addRecipeData.ingredientsNameList"/]
                    '<select class="combobox" style="height: 20px width: 30px">' +
                    '<option value=""></option>' +
                    '[#list ingridients as c]'+
                        '<option value="${c}">${c.nameOfIngridient}</option>' +
                        '[/#list]' +
                    '</select><p>' +
                [@spring.bind "addRecipeData.ingredientsCountList"/]
                    '<input type="text" name="${spring.status.expression}" style="width: 25px; height: 25px" />' +
                    '</p><br/>' +
                [@spring.bind "addRecipeData.ingredientsTypeList"/]
                    '<select class="combobox" style="height: 20px width: 30px">' +
                    '<option value=""></option>' +
                    '<option value="measureOne">гр</option>' +
                    '<option value="measureTwo">кг</option>' +
                    '<option value="measureThree">мл</option>' +
                    '<option value="measureFour">л</option>' +
                    '<option value="measureFive">шт</option>' +
                    '<option value="measureSix">зуб</option>' +
                    '</select></p>' +
                    '</div>' +
                    ' </div>').fadeIn('slow').appendTo('.conress');
            k++;
            return false;
        });
    });


</script>


<script>
    $(document).ready(function () {


        var i = 2;


        $('#add').click(function () {
            $('<div id=i><p>Шаг ' + i + '</p>' +
                    "<a href='#' style='position: relative; background-position: -98px -130px;' title='Удалить шаг' class='ui-icon ui-icon-trash' onclick=\"var $id = $(this).parent().attr('id'); $(this).parent().remove(); while ($id < $('.inputs:last-child').attr('id')) { $id++; $('#'+$id).attr('id', ($id-1)).find('p:first-child').text('Шаг '+($id-1));} return false;\">Удалить шаг</a>" +
                [@spring.bind "addRecipeData.stepsList"/]
                    '<textarea rows="10" cols="15" name="${spring.status.expression}" ></textarea>' +
                    '<INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000"> <p>' +
                    ' <p><INPUT NAME="userfile" TYPE="file"></p>' +
                    '</div>').fadeIn('slow').appendTo('.inputs');
            i++;
            return false;
        });

    });


</script>

<script type="text/javascript">
    function submitform() {
        document.(#OK
    ).
        submit();
    }
</script>
<div class="row-fluid " style="min-height:1500px; ">
    <h1 style="vertical-align:middle; margin-top:5px">Создать рецепт</h1>

    <form id="#OK" action="" method="post" commandName="addRecipeData" style="height: 1500px">
        <div class="span6" id="menuDrop">


            <p>Название</p>

            [@spring.bind "addRecipeData.title"/]
            <input type="text" name="${spring.status.expression}"
                   value="${spring.status.value?default("")}"/> <br/>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="titleError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p>Описание</p>
            [@spring.bind "addRecipeData.description"/]
            <textarea rows="10" cols="45"
                      name="${spring.status.expression}">${spring.status.value?default("")}</textarea> <br/>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="descriptionError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p>Время приготовления(мин)</p>
            [@spring.bind "addRecipeData.cookingTime"/]
            <input type="text" name="${spring.status.expression}"
                   value="${spring.status.value?default("")}"/> <br/>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="cookingTimeError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]


            <p>Кухня</p>
            [@spring.bind "addRecipeData.cuisine"/]
            <select class="combobox" name="${spring.status.expression}" style="height: 30px; width: 217px">
                <option value=""></option>
                [#list cuisines as value]
                    <option value="${value.cuisineId}">${value.cuisin}</option>
                [/#list]
            </select>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="cuisineError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]


            <p>Категория</p>
            [@spring.bind "addRecipeData.category"/]
            <select class="combobox" name="${spring.status.expression}" style="height: 30px; width: 217px">
                <option value=""></option>
                [#list categories as value]
                    <option value="${value.categoriesId}">${value.categ}</option>
                [/#list]
            </select>
            </select>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="categoryError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p><b>Ингредиенты</b></p>

            <div id="container">
                <div class="dynamic-form">
                    <div class="conress">

                        [@spring.bind "addRecipeData.ingredientsNameList"/]
                        <select class="combobox" style="height: 30px; width: 217px">
                            <option value=""></option>
                            [#list ingridients as c]
                                <option value="${c.ingridientId}">${c.nameOfIngridient}</option>
                            [/#list]
                        </select>
                        [#if spring.status.error]
                            <p>

                            <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                            </p>
                        [/#if]
                        [@spring.bind "addRecipeData.ingredientsCountList"/]
                        <p>
                            <input type="text" name="${spring.status.expression}"
                                   value="${spring.status.value?default("")}" style="width: 25px; height: 25px"/>
                        </p>
                        [#if spring.status.error]
                            <p>

                            <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                            </p>
                        [/#if]
                        [@spring.bind "addRecipeData.ingredientsTypeList"/]
                        <select class="combobox" style="height: 30px; width: 217px">
                            <option value=""></option>
                            <option value="measureOne">гр</option>
                            <option value="measureTwo">кг</option>
                            <option value="measureThree">мл</option>
                            <option value="measureFour">л</option>
                            <option value="measureFive">шт</option>
                            <option value="measureSix">зуб</option>
                        </select>
                        [#if spring.status.error]
                            <p>

                            <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                            </p>
                        [/#if]
                    </div>
                </div>
                <p>
                    <button class="btn" value="#" id="adding">Добавить ингрeдиент</button>
                <div style="margin-top: 100px;">
                    <button class="btn btn-large" style="width: :100px;height: 100px;" id="OK">Создать</button>
                </div>
                </p>
            </div>

        </div>

        <div class="span6 align2">
            <p><b>Фотография готового блюда</b></p>

            <p></p>

            <p><b>Шаги приготовления</b></p>

            <div class="dynamic-form">
                <div class="inputs">
                    <div>
                        <p>Шаг 1</p>

                        [@spring.bind "addRecipeData.stepsList"/]
                        <textarea rows="10" cols="45"
                                  name="${spring.status.expression}">${spring.status.value?default("")}</textarea>
                        <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000">
                        <!-- макс. размер -->
                        <p>Имя файла:</p>

                        <p><INPUT NAME="userfile" TYPE="file"></p>


                        [#if spring.status.error]
                            <p>

                            <div class="error-block-big droppable" id="error">Должен быть минимум 1 шаг приготовления.
                            </div>
                            </p>
                        [/#if]
                    </div>
                </div>
                <p>
                    <button class="btn" value="#" id="add">Добавить шаг</button>
                </p>

            </div>


        </div>

    </form>

</div>


<footer>

    <div class="row-fluid">
        <div class="span12">

        </div>
    </div>
</footer>

[/#assign]
[#include "structure.ftl"/]