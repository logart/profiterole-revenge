[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]

<script type="text/javascript">
    $(document).ready(function () {
        var ingredient = {
            ingrCount: $(".ingr").length + 1,
            addIngr: function (ingrCount) {
                var temp = '<div id="ingr_' + ingrCount + '" class="ingr"><button data-ingrid="' + ingrCount + '" \
                title="Удалить ингредиент" class="delete_ingr ui-icon ui-icon-closethick">Удалить ингредиент</button>\
                [@spring.bind "addRecipeData.ingredientsNameList"/]\
                <select class="combobox ingrName" id = "ingredientsNameList[' + (ingrCount - 1) + ']" name="ingredientsNameList[' + (ingrCount - 1) + ']">\
                    <option value="0"></option>\
                    [#list ingredients as c]<option value="${c.id}">\
                        ${c.name}</option>\
                    [/#list]\
                </select>\
                [@spring.bind "addRecipeData.ingredientsCountList"/]\
                <input type="text" class = "combobox ingrCount" id = "ingredientsCountList[' + (ingrCount - 1) + ']" ' +
                        'name="ingredientsCountList[' + (ingrCount - 1) + ']"  >\
                [@spring.bind "addRecipeData.ingredientsTypeList"/]\
                <select class="combobox ingrType" id = "ingredientsTypeList[' + (ingrCount - 1) + ']" name="ingredientsTypeList[' + (ingrCount - 1) + ']">\
                </select>\
                </div>';

                $(temp).appendTo('.conress').fadeIn('slow');
            },

            deleteIngr: function (id) {
                var self = this;
                self.ingrCount = 1;
                $('#ingr_' + id).remove();
                $('.ingr').each(function () {
                    $(this).attr('id', 'ingr_' + self.ingrCount);
                    $(this).find(':button').attr('data-ingrid', self.ingrCount);
                    $(this).find('.ingrName').attr("name", "ingredientsNameList[" + (self.ingrCount - 1) + "]").attr
                            ("id", "ingredientsNameList[" + (self.ingrCount - 1) + "]");
                    $(this).find('.ingrCount').attr("name", "ingredientsCountList[" + (self.ingrCount - 1) + "]")
                            .attr("id", "ingredientsCountList[" + (self.ingrCount - 1) + "]");
                    $(this).find('.ingrType').attr("name", "ingredientsTypeList[" + (self.ingrCount - 1) + "]").attr
                            ("id", "ingredientsTypeList[" + (self.ingrCount - 1) + "]");
                    self.ingrCount++;
                });
            },
            init: function () {
                var self = this;
                $('#adding').click(function (e) {
                    e.preventDefault();
                    self.addIngr(self.ingrCount);
                    self.ingrCount++;
                });
                $(function () {
                    var keyStop = {
                        13: "input:text",
                        end: null
                    };
                    $(document).bind("keydown", function (event) {
                        var selector = keyStop[event.which];

                        if (selector !== undefined && $(event.target).is(selector)) {
                            event.preventDefault();
                        }
                        return true;
                    });
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
        var stepFileCount=2
        var step = {
            stepCount: $(".step").length + 1,
            addStep: function (stepCount) {
                var template = '<div id="step_' + stepCount + '" class="step"><p>Шаг <span class="step_counter">' + stepCount + '</span></p>\
                <button data-stepid="' + stepCount + '" title="Удалить шаг" class="delete_step ui-icon \
                ui-icon-closethick">\
                Удалить шаг</button>\
                <textarea class = "stepTextarea forinputs" rows="10" cols="15" name="stepsList[' + (stepCount - 1) + ']" maxlength="3000"></textarea> \
                <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000000000000"> \
                <p>Имя файла:</p>\
                <p>\
                <div class="fileform">\
                        <div class="fileformlabel" id="fileformlabel' + stepFileCount + '"></div> \
                        <div class="selectbutton">Обзор</div>\
                        <INPUT NAME="files[' + (stepCount - 1) + ']" TYPE="file" id="upload" ' +
                        'onchange="getName(this.value, \'fileformlabel' + stepFileCount + '\');"/>\
                </div>\
                </p>\
                </div>';
                stepFileCount++;
                $(template).appendTo('.inputs').fadeIn('slow');
            },
            deleteStep: function (id) {
                var self = this;
                self.stepCount = 1;
                $('#step_' + id).remove();
                $('.step').each(function () {
                    $(this).attr('id', 'step_' + self.stepCount);
                    $(this).find('.step_counter').empty().append(self.stepCount);
                    $(this).find('.stepTextarea').attr("name", "stepsList[" + (self.stepCount - 1) + "]");
                    $(this).find(':button').attr('data-stepid', self.stepCount);
                    $(this).find(':INPUT').attr('name', "files[" + (self.stepCount - 1) + "]");
                    self.stepCount++;
                });
            },
            init: function () {
                var self = this;
                $('#add').click(function (e) {
                    e.preventDefault();
                    self.addStep(self.stepCount);
                    self.stepCount++;
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
        $('[id^="ingredientsNameList"]').live("change", function () {
            debugger;
            var ingredientId = $(this).val();
            var selectedIngredient = parseInt($(this).attr('id').replace(/^\D+/g, ''));
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
                url: url,
                data: ({ingredientId: ingredientId}),
                success: function (data) {
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

<h1>Создать рецепт</h1>
<div class="white-block">

<form id="#OK" action="" method="post" commandName="addRecipeData" enctype="multipart/form-data">
<div class="span6" id="menuDrop">
    <p><b>Название</b></p>

    [@spring.bind "addRecipeData.title"/]
    <input type="text" name="title"
           value="${spring.status.value?default("")?html}" class="add-recipe-title" maxlength="250"/> <br>
    [#if spring.status.error]
        <p>

        <div class="error-div" id="titleError">[@spring.showErrors '<br>', 'error'/]</div>
        </p>
    [/#if]

    <p><b>Описание</b></p>
    [@spring.bind "addRecipeData.description"/]
    <textarea class="forinputs" rows="10" cols="60"
              name="description" maxlength="3000">${spring.status.value?default("")}</textarea>
    <br/>
    [#if spring.status.error]
        <p>

        <div class="error-div" id="descriptionError">[@spring.showErrors '<br>', 'error'/]</div>
        </p>
    [/#if]

    <b>Время приготовления</b>

    [@spring.bind "addRecipeData.cookingTimeHours"/]
    <input type="text" name="cookingTimeHours"
           value="${spring.status.value?default("")}" class="cooking-time"/> ч

    [@spring.bind "addRecipeData.cookingTimeMinutes"/]
    <input type="text" name="cookingTimeMinutes"
           value="${spring.status.value?default("")}" class="cooking-time"/> мин
    [#if spring.status.error]
        <p>

        <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
        </p>
    [/#if]

    <p></p>
    <b>Кухня</b>
    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    [@spring.bind "addRecipeData.cuisineId"/]
    <select class="combobox1" name="cuisineId">
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
    <select class="combobox1" name="categoryId">
        <option value=""></option>
        [#list categories as value]
            [#if "${value.id}" == "${spring.status.value?default(\"\")}"]
                <option selected value="${value.id}">${value.name}</option>
            [#else]
                <option value="${value.id}">${value.name}</option>
            [/#if]
        [/#list]
    </select>
    [#if spring.status.error]
        <p>

        <div class="error-div" id="categoryError">[@spring.showErrors '<br>', 'error'/]</div>
        </p>
    [/#if]
    <p></p>



    <b class="markersTitle">Маркер блюда</b>
    <div class="markersCheckbox">
     [#assign markersListSize = markersNames?size]
     [#list 1..markersListSize as  current_index]
        [@spring.bind "addRecipeData.markersNames[${current_index-1}]"/]
           <input type="checkbox" name="${spring.status.expression}" value="${markersNames[current_index-1]}" >${markersNames[current_index-1]} <br>
      [/#list]
    </div>


    <b>Ингредиенты</b>

    <p></p>

        <div class="dynamic-form">
            <div class="conress">
                [#assign ingrListSize = addRecipeData.ingredientsCountList?size]
                [#if ingrListSize = 0]
                    [#assign ingrListSize = 1]
                [/#if]
                [#list 1..ingrListSize as current_index]
                    <div id="ingr_${current_index}" class="ingr">
                        <button data-ingrid="${current_index}" title="Удалить ингредиент" class="delete_ingr ui-icon
                        ui-icon-closethick">
                        Удалить ингредиент
                        </button>
                        [@spring.bind "addRecipeData.ingredientsNameList[${current_index - 1}]"/]
                        <select class="combobox ingrName" id="${spring.status.expression}"
                                name="${spring.status.expression}">
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
                        <input type="text" class="combobox ingrCount" id="${spring.status.expression}"
                               name="${spring.status.expression}"
                               value="${addRecipeData.ingredientsCountList[current_index - 1]}"/>

                        [@spring.bind "addRecipeData.ingredientsTypeList[${current_index - 1}]"/]
                        <select class="combobox ingrType" id="${spring.status.expression}"
                                name="${spring.status.expression}">
                        </select>

                        [#if spring.status.error]
                            <p>

                            <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                            </p>
                        [/#if]

                    </div>
                [/#list]
            </div>
        <p>
            <button class="btn" value="#" id="adding">Добавить ингрeдиент</button>

        </p>
    </div>

</div>

<div class="span6 align2">
    <p><b>Фотография готового блюда</b></p>


    [@spring.bind "addRecipeData.images"/]
    <p>

    <div class="fileform">
        <div class="fileformlabel" id="fileformlabel"></div>
        <div class="selectbutton">Обзор</div>
        <input type="file" name="images" id="upload" onchange="getName(this.value, 'fileformlabel');"/>
    </div>
    </p><br>


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
                    <button data-stepid="${index}" title="Удалить шаг" class="delete_step ui-icon
                    ui-icon-closethick">Удалить шаг
                    </button>
                    [@spring.bind "addRecipeData.stepsList[${index-1}]"/]
                    <textarea class="stepTextarea forinputs" rows="10" cols="45"
                              name="${spring.status.expression}"
                              maxlength="3000">${spring.status.value?default("")}</textarea>
                    [#if spring.status.error]
                        <p>

                        <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
                        </p>
                    [/#if]
                    <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="1000000000000">
                    <!-- макс. размер -->
                    <p>Имя файла:</p>
                    [@spring.bind "addRecipeData.files"/]
                    <p>

                    <div class="fileform">
                        <div class="fileformlabel" id="fileformlabel1"></div>
                        <div class="selectbutton">Обзор</div>
                        <INPUT NAME="files[${index-1}]" TYPE="file" id="upload" onchange="getName(this.value,
                               'fileformlabel1');"/>
                    </div>
                    </p>
                </div>
            [/#list]

        </div>
        <p>
            <button class="btn" value="#" id="add">
            Добавить шаг
            </button>
        </p>

    </div>
    <button class="btn btn-large create" id="OK">Создать</button>

</div>

</form>

</div>


[/#assign]
[#include "structure.ftl"/]

<script type="text/javascript">

    function getName(str, idform) {
        if (str.lastIndexOf('\\')) {
            var i = str.lastIndexOf('\\') + 1;
        }
        else {
            var i = str.lastIndexOf('/') + 1;
        }
        var filename = str.slice(i);
        var uploaded = document.getElementById(idform);
        uploaded.innerHTML = filename;
    }

</script>
