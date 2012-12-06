[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]

<script>
    $(document).ready(function () {
        var k = $('conress').size() + 1;
        $('#adding').click(function () {
            $('<div id=k><p><select class="combobox" style="height: 20px width: 30px">' +
                    ' [#list ingridients as c]'+
                    '<option value="${c}">${c.nameOfIngridient}</option>' +
                    '[/#list]'+
                    '</select><p>' +
                    '<input type="text" name="ingredientList" style="width: 25px; height: 25px" />' +
                    '</p><br/>' +
                    '<select class="combobox" style="height: 20px width: 30px">' +
                    '[#list ingridients as w]'+
                    '<option value="${w}">${w.unitOfMeasure}</option>' +
                     '[/#list]'+
                    '</select></p> </div>').fadeIn('slow').appendTo('.conress');
            k++;
            return false;
        });


        $('#deleting').click(function () {
            if (k > 0) {
                $("#k:last").remove()
                k--;
                return false;
            }
        });
    });


</script>


<script>
    $(document).ready(function () {


        var i = $('inputs').size() + 1;


        $('#add').click(function () {
            $('<div id=i><p>Шаг ' + i + '</p>' +
                    '<textarea rows="10" cols="15" name="text" ></textarea>' +
                    '<INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000"> <p>' +
                    '<INPUT NAME="userfile" TYPE="file"></p> <p><INPUT TYPE="submit" VALUE="Отправить"></p> ' +
                    '</div>').fadeIn('slow').appendTo('.inputs');
            i++;
            return false;
        });


        $('#remove').click(function () {
            if (i > 0) {
                $("#i:last").remove()
                i--;
                return false;
            }
        });
    });


</script>

<script type="text/javascript">
    function submitform() {
        document.(#OK).
        submit();
    }
</script>
    [@spring.bind "addRecipeData.*"/]
    [#if spring.status.error]
    <div class="error-div droppable" id="error">
        [@spring.showErrors '<br>', 'error'/]
    </div>

    [/#if]

 [#--${temp }--]
<div class="row-fluid " style="height: 1500px">
    <form id="#OK" action="" method="post" commandName="addRecipeData">
        <div class="span6" id="menuDrop">
            <div class="block-create-menu droppable" id="breakfast" style="height: 1400px">
                <div class="for-adding-recipes">

                    <h1>Создать рецепт</h1>

                    <p>Название*</p>

                    [@spring.bind "addRecipeData.title"/]
                    <input type="text" name="${spring.status.expression}"
                           value="${spring.status.value?default("")}"/> <br/>

                    <p>Описание</p>
                    [@spring.bind "addRecipeData.description"/]
                    <textarea rows="10" cols="45"
                              name="${spring.status.expression}">${spring.status.value?default("")}</textarea> <br/>

                    <p>Время приготовления</p>
                    [@spring.bind "addRecipeData.cookingTime"/]
                    <input type="text" name="${spring.status.expression}"
                           value="${spring.status.value?default("")}"/> <br/>

                    <p>Кухня*</p>
                    <select class="combobox" style="height: 30px; width: 217px">
                        [#list cuisinesList as a]
                            <option value="${a}">${a.cuisin}</option>
                        [/#list]
                     </select>


                    <p>Категория*</p> <select class="combobox" style="height: 30px; width: 217px">

                    [#list categories as b]
                        <option value="${b}">${b.categ}</option>
                    [/#list]

                </select>


                    <p>Ингридиенты*</p>

                    <div id="container">
                        <div class="dynamic-form">
                            <div class="conress">


                                <select class="combobox" style="height: 30px; width: 217px">
                                    [#list ingridients as c]
                                        <option value="${c}">${c.nameOfIngridient}</option>
                                    [/#list]
                                </select>
                                [@spring.bind "addRecipeData.ingredientList"/]
                                <p>
                                    <input type="text" name="${spring.status.expression}"
                                           value="${spring.status.value?default("")}" style="width: 25px; height: 25px"/></p>

                                <select class="combobox" style="height: 30px; width: 217px">
                                    [#list ingridients as d]
                                        <option value="${d}">${d.unitOfMeasure}</option>
                                    [/#list]
                                </select>


                            </div>
                        </div>
                        <p>
                            <button class="btn" value="#" id="adding">Добавить ингридиент</button>
                            <button class="btn" value="#" id="deleting">Удалить ингридиент</button>
                        </p>

                    </div>


                </div>
            </div>
        </div>

        <div class="span6 align2">
            <div class="block-create-menu" id="rec" style="height: 1400px">

                <div class="dynamic-form">
                    <div class="inputs">
                        <div>
                            <p>Шаг 0*</p>
                            <textarea rows="10" cols="15" name="text"></textarea>
                            <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000">
                            <!-- макс. размер -->
                            <p>Имя файла:</p>

                            <p><INPUT NAME="userfile" TYPE="file"></p>

                            <p><INPUT TYPE="submit" VALUE="Отправить"></p>
                        </div>
                    </div>
                    <p>
                        <button class="btn" value="#" id="add">Добавить шаг</button>
                        <button class="btn" value="#" id="remove">Удалить шаг</button>
                    </p>
                </div>

            </div>
        </div>
        <button class="btn btn-large no-outline" id="OK" style="vertical-align:middle" type="submit">Создать</button>
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