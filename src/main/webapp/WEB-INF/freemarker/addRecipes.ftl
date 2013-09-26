[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]

<script type="text/javascript">
    $(document).ready(function () {
        var ingredient = {
            ingrCount: $(".ingr").length + 1,
            addIngr: function (ingrCount) {
                var temp = '<div id="ingr_' + ingrCount + ' class="ingr"><button data-ingrid=' + ingrCount + '" \
                title="Удалить ингредиент" class="delete_ingr ui-icon ui-icon-closethick">Удалить ингредиент</button>\
                [@spring.bind "addRecipeData.ingredientsNameList"/]\
                <input class="combobox ingrName" id="ingredientsNameList[' + (ingrCount - 1) + ']" name="ingredientsNameList[' + (ingrCount - 1) + ']" >\
                [@spring.bind "addRecipeData.ingredientsIdList"/]\
                <input class="combobox ingrId no-display" id="ingredientsIdList[' + (ingrCount - 1) + ']" name="ingredientsIdList[' + (ingrCount - 1) + ']" >\
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
                    $(this).find('.ingrId').attr("name", "ingredientsIdList[" + (self.ingrCount - 1) + "]").attr
                            ("id", "ingredientsIdList[" + (self.ingrCount - 1) + "]");
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
        var stepFileCount = 2
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
                    $(this).find('INPUT[type=file]').attr('name', "files[" + (self.stepCount - 1) + "]");
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

    var ingredientsMeasuresGramEquals = {};
    var id=0;

    $(document).ready(function () {

            $('[id^="ingredientsNameList"]').live("blur", function () {

            var selectedIngredient = parseInt($(this).attr('id').replace(/^\D+/g, ''));
            var ingrName = $(this).val();

            if(ingrName==""){
                $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', true);
                $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', true);

                return (false);
            }
            $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', true);
            $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', true);
            $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').html('<option>...</option>');

            var url1 = '/addRecipes/getIngredientId';
              $.ajax({
                    url: url1,
                    data: ({ingredientName: ingrName}),
                    type: 'POST',
                    success:function(data){
                      $('#ingredientsIdList\\[' + selectedIngredient + '\\]').attr('value', data);
                     id=data;
                        $.ajax({
                            url: '/getMeasures',
                            data: ({ingredientId: id}),
                            success: function (data) {

                                $('#ingredientsCountList\\[' + selectedIngredient + '\\]').attr('disabled', false);
                                $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').attr('disabled', false);
                                $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').html('<option value = "0"></option>');
                                $.each(data, function (index, value) {
                                    if (ingredientsMeasuresGramEquals[id]==undefined)ingredientsMeasuresGramEquals[id]={};
                                    ingredientsMeasuresGramEquals[id][index]= value[1];
                                    $('#ingredientsTypeList\\[' + selectedIngredient + '\\]').append('<option value = "' + index + '">' + value[0] + '</option>');

                                });
                            }
                        });
                   }
                }) ;
        });
    });
</script>


<script type="text/javascript">

    $(document).ready(function(){
        $('[id^="ingredientsNameList"]').live("focus", function () {
            $(this).autocomplete({
                source: function( request, response ) {
                 	$.ajax({
                         url: "/addRecipes/ingredients",
                         dataType : "json",
                         type: 'POST',
                         data: ({'searchString': request.term}),
                         success: function(data){
                              response(($.map(data.searchMap , function(item){
                                       return {label: item}

                              })))
                           }
                      })
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

    <div id = "cookingTime">
        <b>Время приготовления</b>

        [@spring.bind "addRecipeData.cookingTimeHours"/]
        <input type="text" name="cookingTimeHours"
               value="${spring.status.value?default("")}" class="cooking-time"/> ч

        [@spring.bind "addRecipeData.cookingTimeMinutes"/]
        <input type="text" name="cookingTimeMinutes"
               value="${spring.status.value?default("")}" class="cooking-time"/> мин
    </div>
    [#if spring.status.error]
        <p>

        <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
        </p>
    [/#if]

    <br/>
    <div id = "quantityOfDish">
        <b>Вес готового блюда</b>
        [@spring.bind "addRecipeData.quantityOfDish"/]
        <input type="text" name="quantityOfDish"
               value="${spring.status.value?default("")}" class="cooking-time"/> грамм
    </div>
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
                    <input type="text" class="combobox ingrName" id="${spring.status.expression}"
                           name="${spring.status.expression}"
                           value="${addRecipeData.ingredientsNameList[current_index - 1]}" >

                    [@spring.bind "addRecipeData.ingredientsIdList[${current_index - 1}]"/]
                    <input class="combobox ingrId no-display" id="${spring.status.expression}"
                           name="${spring.status.expression}"
                           value="${addRecipeData.ingredientsIdList[current_index - 1]}" >


                    [@spring.bind "addRecipeData.ingredientsCountList[${current_index - 1}]"/]
                    <input type="text" class="combobox ingrCount" id="${spring.status.expression}"
                           name="${spring.status.expression}"
                           value="${addRecipeData.ingredientsCountList[current_index - 1]}"/>
                    <!-- ingredientsType = MeasuresBucket.id -->
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
    </p>
    <br>

    <div class="control-group">
        <div class="control-label-left"><b>Сложность приготовления</b></div>
        <div class="controls" id="complexity">
            [#assign cont={"":"","легкий":"легкий",
            "средний":"средний",
            "сложный":"сложный",
            "очень сложный":"очень сложный"}]
            [@spring.formSingleSelect "addRecipeData.complexity" cont "class=\"combobox1\"" /]
        </div>
        [#if spring.status.error]
            <p>

            <div class="error-div">[@spring.showErrors '<br>', 'error'/]</div>
            </p>
        [/#if]
    </div>

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
    <button class="btn btn-large create" id="OK" onclick="return validateForm();">Создать</button>

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

    function validateForm() {
        var MAX_TITLE_SIZE= 250;
        var MAX_DESCRIPTION_SIZE = 3000;
        var MAX_STEP_SIZE = 3000;
        var MIN_COOKING_TIME_SIZE = 6 ;
        var MAX_COOKING_MINUTES_SIZE = 59 ;
        var MIN_COOKING_HOURS_SIZE = 0;
        var MAX_COOKING_HOURS_SIZE = 9;
        var MIN_DISH_OUTPUT = 0.25;

        var isValidatedOk=true;

        function wrapToErrorSpan(text){
            return "<span class=\"error\">" + text + "</span><br>"
        }
        function wrapToErrorDiv(text){
            return "<div class=\"error-div\" id=\"titleError\">"+text.substr(0,text.length-4) + "</div>"
        }
        function singleValidationResulting(selector,errorText){
            if ($(selector).next().is("div.error-div")) $(selector).next().remove();
            if (errorText !=""){
                $(selector).after(wrapToErrorDiv(errorText));
                isValidatedOk=false;
            }
        }
        var  validateNotEmpty = function(value, message){
            if (value=="") return wrapToErrorSpan(message);
            return"";
        }
        var  validateByRegExp = function(value,regexp,message){
            var expr = new RegExp(regexp);
            if (!expr.test(value)) return wrapToErrorSpan(message);
            return"";
        }
        var  validateByLength = function(value,min,max,message){
           if(value.length<min ||value.length>max) return wrapToErrorSpan(message);
           return"";
        }

        //title
        var errorText="";
        var value = $("input[name=title]")[0].value;
        errorText+= validateNotEmpty(value,"Поле не должно быть пустым");
        errorText+= validateByRegExp(value,"^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\.\\,\\(\\)\\[\\]\\+\\-\\*\\/\\=\\\"\\“\\”\\'\\‘\\’]*$",
                "Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы ( , () [] + - * / = “ ” ‘ ’ ).") ;
        errorText+= validateByLength(value,1,MAX_TITLE_SIZE,"Длина названия рецепта должна быть от 1 до " + MAX_TITLE_SIZE +  " символов.") ;
        singleValidationResulting("input[name=title]",errorText);

        //description
        errorText="";
        value = $("textarea[name=description]")[0].value;
        errorText+= validateNotEmpty(value,"Поле не должно быть пустым");
        errorText+= validateByRegExp(value,"^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\.\\,\\(\\)\\+\\-\\=\\\"\\“\\”\\'\\‘\\’\\:\\;\\[\\]\\!\\?\\*\\%\\<\\>\\/]*$",
                "Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (. , () [] + - * / = “ ” ‘ ’ : ; ! ? % <>).") ;
        errorText+= validateByLength(value,1,MAX_DESCRIPTION_SIZE,"Длина описания рецепта должна быть от 1 до " + MAX_DESCRIPTION_SIZE +  " символов.") ;
        singleValidationResulting("textarea[name=description]",errorText);

        //complexity
        errorText="";
        value = $("select[name=complexity]")[0].value;
        errorText+= validateNotEmpty(value,"Сложность приготовления блюда должна быть указана.");
        singleValidationResulting("select[name=complexity]",errorText);

        //cuisineId
        errorText="";
        value = $("select[name=cuisineId]")[0].value;
        errorText+= validateNotEmpty(value,"Кухня должна быть выбрана.");
        singleValidationResulting("select[name=cuisineId]",errorText);

        //categoryId
        errorText="";
        value = $("select[name=categoryId]")[0].value;
        errorText+= validateNotEmpty(value,"Категория должна быть выбрана.");
        singleValidationResulting("select[name=categoryId]",errorText);

        //steps
        for (var i=0;i<$("textarea.stepTextarea").length ; i++){
            errorText="";
            value = $("textarea[name='stepsList["+ i +"]']")[0].value;
            errorText+= validateNotEmpty(value,"Поле не должно быть пустым");
            errorText+= validateByRegExp(value,"^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\.\\,\\(\\)\\+\\-\\=\\\"\\“\\”\\'\\‘\\’\\:\\;\\[\\]\\!\\?\\*\\%\\<\\>\\/]*$",
                    "Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (. , () [] + - * / = “ ” ‘ ’ : ; ! ? % <>).") ;
            errorText+= validateByLength(value,1,MAX_STEP_SIZE,"Длина описания шага должна быть от 1 до " + MAX_STEP_SIZE +  " символов.") ;
            singleValidationResulting("textarea[name='stepsList["+ i +"]']",errorText);
        }

        //ingredients
        var weightAllIngredients = 0;
        var selectedIngredientId;
        var countOfIngredient;
        var selectedMesureID;

        for (var i=0;i<$("input.ingrName").length ; i++){
            errorText="";

            selectedIngredientId = parseInt($("input[name='ingredientsIdList["+ i +"]']")[0].value);
            if (isNaN(selectedIngredientId)) errorText+= wrapToErrorSpan("Название ингредиента должно быть выбрано.");

            countOfIngredient = parseFloat($("input[name='ingredientsCountList["+ i +"]']")[0].value);
            if (isNaN(countOfIngredient)) errorText+= wrapToErrorSpan("Количество ингредиента должно быть указано.");

            selectedMesureID = parseInt($("select[name='ingredientsTypeList["+ i +"]']")[0].value);
            if (isNaN(selectedMesureID)||selectedMesureID==0) errorText+= wrapToErrorSpan("Единица измерения ингредиента должна быть выбрана.");

            singleValidationResulting("select[name='ingredientsTypeList["+ i +"]']",errorText);

            if (!isNaN(selectedIngredientId) && !isNaN(countOfIngredient) && !isNaN(selectedMesureID)) {
                weightAllIngredients += parseInt(countOfIngredient)*parseInt(ingredientsMeasuresGramEquals[selectedIngredientId][selectedMesureID]);
            }

        }

        //quantityOfDish
        errorText="";
        var quantityOfDish = parseInt($("input[name=quantityOfDish]")[0].value);
        if (isNaN(quantityOfDish)) {
            errorText+= wrapToErrorSpan("Вес готового блюда должнен быть указан (целое число), " +
                    "но не менее 25% и не более общего веса всех входящих в рецепт ингредиентов.");
        }else if(quantityOfDish > weightAllIngredients || quantityOfDish < weightAllIngredients * MIN_DISH_OUTPUT){
            errorText+= wrapToErrorSpan("Вес готового блюда не должен быть меньше 25% и не должен превышать вес всех " +
                    "входящих в рецепт ингредиентов. (" + weightAllIngredients + " гр.)");
        }
        singleValidationResulting("div[id=quantityOfDish]",errorText);

        //cookingTime
        errorText="";
        var cookingTimeHours = parseInt($("input[name=cookingTimeHours]")[0].value, 10);
        var cookingTimeMinutes = parseInt($("input[name=cookingTimeMinutes]")[0].value, 10);
        if (isNaN(cookingTimeHours)) cookingTimeHours=0;
        if (isNaN(cookingTimeMinutes)) cookingTimeMinutes=0;
        if (cookingTimeHours==0 && cookingTimeMinutes==0)
            errorText+= wrapToErrorSpan("Время приготовления должно быть указано.");
        if (cookingTimeHours > MAX_COOKING_HOURS_SIZE || cookingTimeHours < MIN_COOKING_HOURS_SIZE) {
            errorText+= wrapToErrorSpan("Корректное значение для часов приготовления лежит в диапазоне от " +
                    MIN_COOKING_HOURS_SIZE + " часов до " + MAX_COOKING_HOURS_SIZE + " часов (целые).");
        }
        if  (cookingTimeHours == 0 && (cookingTimeMinutes < MIN_COOKING_TIME_SIZE ||
                cookingTimeMinutes > MAX_COOKING_MINUTES_SIZE)) {
            errorText+= wrapToErrorSpan("Если не указаны часы времени приготовления, " +
                    "корректное значение для минут лежит в диапазоне от " + MIN_COOKING_TIME_SIZE + " минут до " +
                    MAX_COOKING_MINUTES_SIZE + " минут (целые)");
        }else if((cookingTimeHours > 0 && cookingTimeHours < MAX_COOKING_HOURS_SIZE) &&
                (cookingTimeMinutes < 0 || cookingTimeMinutes > MAX_COOKING_MINUTES_SIZE)){

            errorText+= wrapToErrorSpan("Значение для минут лежит в диапазоне от 0 минут до " + MAX_COOKING_MINUTES_SIZE +
                    " минут (целые).");
        }else if (cookingTimeHours == MAX_COOKING_HOURS_SIZE && cookingTimeMinutes > 0){
            errorText+= wrapToErrorSpan("Время приготовление не должно превышать " + MAX_COOKING_HOURS_SIZE + " часов.");
        }
        singleValidationResulting("div[id=cookingTime]",errorText);

        return isValidatedOk;
    }

</script>
