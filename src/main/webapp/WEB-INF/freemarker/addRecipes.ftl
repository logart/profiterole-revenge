[#ftl]
[#assign content]

<script>
    $(document).ready(function () {


        var k = $('conress').size() + 1;


        $('#adding').click(function () {
            $('<div id=k><p><select class="combobox" style="height: 20px width: 30px"><option value="Морковь">Морковь</option><option value="Лук">Лук</option><option value="Свекла">Свекла</option><option value="Сахар">Сахар</option><option value="Соль">Соль</option></select><p><input type="text" name="title" style="width: 25px; height: 25px" /></p><br/><select class="combobox" style="height: 20px width: 30px"><option value="гр">гр</option><option value="мл">мл</option></select></p> </div>').fadeIn('slow').appendTo('.conress');
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
            $('<div id=i><p>Шаг ' + i + '</p><textarea rows="10" cols="15" name="text" ></textarea><INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000"> <p><INPUT NAME="userfile" TYPE="file"></p> <p><INPUT TYPE="submit" VALUE="Отправить"></p> </div>').fadeIn('slow').appendTo('.inputs');
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
    function submitform()
    {
        document.(#OK).submit();
    }
</script>


<div class="row-fluid " style="height: 1500px">
    <form id="#OK" action="" method="post" commandName="addingData">
          <div class="span6" id="menuDrop">
            <div class="block-create-menu droppable" id="breakfast" style="height: 1400px">
                <div class="for-adding-recipes">

                    <h1>Создать рецепт</h1>

                    <p>Название*</p> <input type="text" name="title"/> <br/>
                    <p>Описание</p> <textarea rows="10" cols="45" name="text"></textarea> <br/>
                    <p>Время приготовления</p> <input type="text" name="time"/> <br/>

                    <p>Кухня*</p>
                    <select class="combobox" style="height: 30px; width: 217px">

                        <option value="Украинская">Украинская</option>
                        <option value="Русская">Русская</option>
                        <option value="Японская">Японская</option>
                        <option value="Китайская">Китайская</option>
                        <option value="Тайская">Тайская</option>
                        <option value="Итальянская">Итальянская</option>
                        <option value="Мексиканская">Мексиканская</option>
                        <option value="Французкая">Французкая</option>
                        <option value="Армянская">Армянская</option>
                        <option value="Индийская">Индийская</option>
                        <option value="Греческая">Греческая</option>
                        <option value="Грузинская">Грузинская</option>

                    </select>



                    <p>Категория*</p> <select class="combobox" style="height: 30px; width: 217px">

                    <option value="Закуска">Закуска</option>
                    <option value="Десерт">Десерт</option>
                    <option value="Первое">Первое</option>
                    <option value="Второе">Второе</option>
                    <option value="Напиток">Напиток</option>

                </select>


                    <p>Ингридиенты*</p>

                    <div id="container">
                        <div class="dynamic-form">
                            <div class="conress">


                                    <select class="combobox" style="height: 30px; width: 217px">
                                        <option value="Морковь">Морковь</option>
                                        <option value="Лук">Лук</option>
                                        <option value="Свекла">Свекла</option>
                                        <option value="Сахар">Сахар</option>
                                        <option value="Соль">Соль</option>
                                    </select>

                                <p><input type="text" name="title" style="width: 25px; height: 25px"/></p>

                                <select class="combobox" style="height: 30px; width: 217px">
                                    <option value="гр">гр</option>
                                    <option value="мл">мл</option>
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
    <button class="btn btn-large no-outline" id="OK" style="vertical-align:middle">Создать</button>
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