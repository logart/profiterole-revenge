[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]

<script type="text/javascript">
    $(document).ready(function () {
        var ingredient = {
            k:$(".ingr").length + 1,
            addStep:function (k) {
                var temp = '<div id="ingr_' + k + '" class="ingr"><button data-ingrid="' + k + '" style="position: relative; background-position: -98px -130px" title="Удалить ингредиент" class="ui-icon ui-icon-trash delete_ingr"">Удалить ингредиент</button>\
                [@spring.bind "addRecipeData.ingredientsNameList"/]\
                <select class="combobox ingrName" id = "${spring.status.expression}[' + (k - 1) + ']" style="height: 30px; width: 217px; margin-right: 2px;" name="${spring.status.expression}[' + (k - 1) + ']">\
                    <option value="0"></option>\
                    [#list ingredients as c]<option value="${c.id}">\
                        ${c.name}</option>\
                    [/#list]\
                </select>\
                [@spring.bind "addRecipeData.ingredientsCountList"/]\
                <input class = "ingrCount" id = "${spring.status.expression}[' + (k - 1) + ']" type="text" name="${spring.status.expression}[' + (k - 1) + ']" style="width: 25px; height: 25px; font-size: 10px; margin-right: 1px;" />\
                [@spring.bind "addRecipeData.ingredientsTypeList"/]\
                <select class="combobox ingrType" id = "${spring.status.expression}[' + (k - 1) + ']" style="height: 30px; width: 59px;" name="${spring.status.expression}[' + (k - 1) + ']">\
                </select>\
                </div>';

                $(temp).appendTo('.conress').fadeIn('slow');
            },

            deleteIngr:function (id) {
                var self = this;
                self.k = 1;
                $('#ingr_' + id).remove();
                $('.ingr').each(function () {
                    $(this).attr('id', 'ingr_' + self.k);
                    $(this).find(':button').attr('data-ingrid', self.k);
                    $(this).find('.ingrName').attr("name", "ingredientsNameList[" + (self.k - 1) + "]");
                    $(this).find('.ingrCount').attr("name", "ingredientsCountList[" + (self.k - 1) + "]");
                    $(this).find('.ingrType').attr("name", "ingredientsTypeList[" + (self.k - 1) + "]");
                    self.k++;
                });
            },
            init:function () {
                var self = this;
                $('#adding').click(function (e) {
                    e.preventDefault();
                    self.addStep(self.k);
                    self.k++;
                });
                $('.delete_ingr').live('click', function (e) {
                    e.preventDefault();
                    var id = $(this).data('ingrid');
                    self.deleteIngr(id);
                });

            }
        }
        ingredient.init();
    });
</script>


<script type="text/javascript">
    $(document).ready(function () {
        var step = {
            i:$(".step").length + 1,
            addStep:function (i) {
                var template = '<div id="step_' + i + '" class="step"><p>Шаг <span class="step_counter">' + i + '</span></p>\
                <button data-stepid="' + i + '" style="position: relative; background-position: -98px -130px;" title="Удалить шаг" class="ui-icon ui-icon-trash delete_step">Удалить шаг</button>\
                <textarea class = "stepTextarea forinputs" rows="10" cols="15" name="stepsList[' + (i - 1) + ']" maxlength="3000"></textarea> \
                <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000000000000"> <p>\
                <p><INPUT NAME="files[' + (i - 1) + ']" TYPE="file"></p>\
                </div>';
                $(template).appendTo('.inputs').fadeIn('slow');
            },
            deleteStep:function (id) {
                var self = this;
                self.i = 1;
                $('#step_' + id).remove();
                $('.step').each(function () {
                    $(this).attr('id', 'step_' + self.i);
                    $(this).find('.step_counter').empty().append(self.i);
                    $(this).find('.stepTextarea').attr("name", "stepsList[" + (self.i - 1) + "]");
                    $(this).find(':button').attr('data-stepid', self.i);
                    self.i++;
                });
            },
            init:function () {
                var self = this;
                $('#add').click(function (e) {
                    e.preventDefault();
                    self.addStep(self.i);
                    self.i++;
                });
                $('.delete_step').live('click', function (e) {
                    e.preventDefault();
                    var id = $(this).data('stepid');
                    self.deleteStep(id);
                });

            }
        }

        step.init();
    });
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('[id^="ingredientsNameList"]').live("change", function ()  {
            debugger;
            var ingredientId = $(this).val();
            var selectedIngredient = parseInt($(this).attr('id').replace( /^\D+/g, ''));
            if (ingredientId == '0') {
                $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', true);
                $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', true);
                return(false);
            }
            $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', true);
            $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', true);
            $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').html('<option>...</option>');
            var url = '/getMeasures';
            $.ajax({
                url:url,
                data:({ingredientId:ingredientId}),
                success:function (data) {
                    $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', false);
                    $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', false);
                    $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').html('<option value = "0"></option>');
                    $.each(data, function (index, value) {
                        $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').append('<option value = "' + index + '">' + value + '</option>');

                    });

                }
            });
        });
    });
</script>

<div class="row-fluid " style="min-height:1500px;">
    <h1 style="vertical-align:middle; margin-top:5px">Создать рецепт</h1>

    <form id="#OK" action="" method="post" commandName="addRecipeData" enctype="multipart/form-data" style="height: 1500px">
        <div class="span6" id="menuDrop">
            <p><b>Название</b></p>

            [@spring.bind "addRecipeData.title"/]
            <input type="text" name="${spring.status.expression}"
                   value="${spring.status.value?default("")?html}" style="width: 315px; font-size: 14px;" maxlength="250"/> <br>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="titleError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p><b>Описание</b></p>
            [@spring.bind "addRecipeData.description"/]
            <textarea class="forinputs" rows="10" cols="60"
                      name="${spring.status.expression}" maxlength="3000">${spring.status.value?default("")}</textarea> <br/>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="descriptionError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <b>Время приготовления</b>

            [@spring.bind "addRecipeData.cookingTime"/]
            <input type="text" name="${spring.status.expression}"
                   value="${spring.status.value?default("")}" style="width: 30px; font-size: 14px;"/> мин
            [#if spring.status.error]
                <p>

                <div class="error-div" id="cookingTimeError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p></p>
            <b>Кухня</b>
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            [@spring.bind "addRecipeData.cuisineId"/]
            <select class="combobox" name="${spring.status.expression}" style="height: 30px; width: 130px">
                <option value=""></option>
                [#list cuisines as value]
                    [#if "${value.id}" == "${spring.status.value?default(\"\")}"]
                        <option selected value="${value.id}">${value.name}</option>
                    [#else]
                        <option value="${value.id}">${value.name}</option>
                    [/#if]
                [/#list]
            </select>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="cuisineError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]

            <p></p>
            <b>Категория</b>
            [@spring.bind "addRecipeData.categoryId"/]
            <select class="combobox" name="${spring.status.expression}" style="height: 30px; width: 130px">
                <option value=""></option>
                [#list categories as value]
                    [#if "${value.id}" == "${spring.status.value?default(\"\")}"]
                        <option selected value="${value.id}">${value.name}</option>
                    [#else]
                        <option value="${value.id}">${value.name}</option>
                    [/#if]
                [/#list]
            </select>
            </select>
            [#if spring.status.error]
                <p>

                <div class="error-div" id="categoryError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]
            <p></p>

            <b>Ингредиенты</b>

            <p></p>

            <div id="container">
                <div class="dynamic-form">
                    <div class="conress">
                        [#assign ingrListSize = addRecipeData.ingredientsCountList?size]
                        [#if ingrListSize = 0]
                            [#assign ingrListSize = 1]
                        [/#if]
                        [#list 1..ingrListSize as current_index]
                            <div id="ingr_${current_index}" class="ingr">
                                <button data-ingrid="${current_index}" style="position: relative; background-position: -98px -130px" title="Удалить ингредиент"
                                        class="ui-icon ui-icon-trash delete_ingr"
                                ">
                                Удалить ингредиент
                                </button>
                                [@spring.bind "addRecipeData.ingredientsNameList[${current_index - 1}]"/]
                                <select class="combobox ingrName" id="${spring.status.expression}" style="height: 30px; width: 217px" name="${spring.status.expression}">
                                    <option value="0"></option>
                                    [#list ingredients as c]
                                        [#if ""+c.id = addRecipeData.ingredientsNameList[current_index - 1]]
                                            <option selected="" value="${c.id}">${c.name}</option>
                                        [#else]
                                            <option value="${c.id}">${c.name}</option>
                                        [/#if]
                                    [/#list]
                                </select>

                                [@spring.bind "addRecipeData.ingredientsCountList[${current_index - 1}]"/]
                                <input type="text" class="forinputs ingrCount" id="${spring.status.expression}" name="${spring.status.expression}"
                                       value="${addRecipeData.ingredientsCountList[current_index - 1]}" style="width: 25px; height: 25px; font-size: 14px;"/>

                                [@spring.bind "addRecipeData.ingredientsTypeList[${current_index - 1}]"/]
                                <select class="combobox ingrType" id="${spring.status.expression}" style="height: 30px; width: 61px" name="${spring.status.expression}">
                                </select>

                                [#if spring.status.error]
                                    <p>

                                    <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                                    </p>
                                [/#if]

                            </div>
                        [/#list]
                    </div>
                </div>
                <p>
                    <button class="btn" value="#" id="adding">Добавить ингрeдиент</button>

                </p>
            </div>

        </div>

        <div class="span6 align2">
            <p><b>Фотография готового блюда</b></p>


            [@spring.bind "addRecipeData.images"/]
            <p><input name="images" type="file"/></p><br>


            <p><b>Шаги приготовления</b></p>

            <div class="dynamic-form">
                [#assign stepsListSize = addRecipeData.stepsList?size]
                [#if stepsListSize = 0]
                    [#assign stepsListSize = 1]
                [/#if]
                <div class="inputs">
                    [#list 1..stepsListSize as index]
                        <div id="step_${index}" class="step">

                            <p>Шаг <span class="step_counter">${index}</span></p>
                            <button data-stepid="${index}" style="position: relative; background-position: -98px -130px;" title="Удалить шаг"
                                    class="ui-icon ui-icon-trash delete_step">Удалить шаг
                            </button>
                            [@spring.bind "addRecipeData.stepsList[${index-1}]"/]
                            <textarea class="stepTextarea forinputs" rows="10" cols="45"
                                      name="${spring.status.expression}" maxlength="3000">${spring.status.value?default("")}</textarea>
                            [#if spring.status.error]
                                <p>

                                <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                                </p>
                            [/#if]
                            <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="1000000000000">
                            <!-- макс. размер -->
                            <p>Имя файла:</p>
                            [@spring.bind "addRecipeData.files"/]
                            <p><INPUT NAME="files[${index-1}]" TYPE="file"></p>
                        </div>
                    [/#list]

                </div>
                <p>
                    <button class="btn" value="#" id="add" onclick="document.getElementById('#idForBtn').style.visibility=visible">Добавить шаг</button>
                </p>

            </div>
            <div style="margin-top: 40px;">
                <button class="btn btn-large" style="width: :100px;height: 60px;" id="OK">Создать</button>
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