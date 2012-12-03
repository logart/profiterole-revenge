[#ftl]
[#assign content]



 <div class="row-fluid " style="height: 1500px">


  <div class="span6" id="menuDrop">
<div class="block-create-menu droppable" id="breakfast" style="height: 1400px">

  <div class ="for-adding-recipes">

 <h1>Создать рецепт</h1>

 <form name="Recipename" action="hello" method="post" style="width: 30px">
 Название* <input type="text" name="title"  /> <br/>
 Описание <textarea rows="10" cols="45" name="text" ></textarea>       <br/>
 Время приготовления <input type="text" name="time" />       <br/>
 </form>

 <p>Кухня*</p> <select class="combobox" style="height: 20px width: 30px">

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



<p>
 <p>Категория*</p> <select class="combobox" style="height: 20px width: 30px">

 <option value="Закуска">Закуска</option>
 <option value="Десерт">Десерт</option>
 <option value="Первое">Первое</option>
 <option value="Второе">Второе</option>
 <option value="Напиток">Напиток</option>
 </select>
</p>

<script>
$(document).ready(function(){


	var k = $('conress').size() + 1;

	$('#adding').click(function() {
		$('<div id=k><p><select class="combobox" style="height: 20px width: 30px"><option value="Морковь">Морковь</option><option value="Лук">Лук</option><option value="Свекла">Свекла</option><option value="Сахар">Сахар</option><option value="Соль">Соль</option></select><form name="Recipename" action="hello" method="post"><input type="text" name="title" style="width: 25px; height: 25px" /> <br/></form><select class="combobox" style="height: 20px width: 30px"><option value="гр">гр</option><option value="мл">мл</option></select></p> </div>').fadeIn('slow').appendTo('.conress');
		k++;
	});

	$('#deleting').click(function() {
	if(k > 0) {
		$("#k:last").remove()
		k--;
	}
	});
});

</script>

<p>Ингридиенты*</p>



   <div id="container">

               <div class="dynamic-form">

               <form>
               <div class="conress">
               <p>

                 <select class="combobox" style="height: 20px width: 30px">
                   <option value="Морковь">Морковь</option>
                   <option value="Лук">Лук</option>
                   <option value="Свекла">Свекла</option>
                   <option value="Сахар">Сахар</option>
                   <option value="Соль">Соль</option>
                 </select>

                 <form name="Recipename" action="hello" method="post">
                 <p><input type="text" name="title" style="width: 25px; height: 25px" /></p>
                 </form>

                 <select class="combobox" style="height: 20px width: 30px">
                   <option value="гр">гр</option>
                   <option value="мл">мл</option>
                   </select>
               </p>


                  </div></form>
               </div>
                </div>
                  <p><button  class="btn" value="#" id="dobavit">Добавить ингридиент</button>
                                    <button class="btn" value="#" id="ydalit">Удалить ингридиент</button></p>




  </div>

 </div>
 </div>


   <div class="span6 align2">
             <div class="block-create-menu" id="rec"  style="height: 1400px">

<script>
$(document).ready(function(){


	var i = $('inputs').size() + 1;

	$('#add').click(function() {
		$('<div id=i><p>Шаг ' + i + '</p><textarea rows="10" cols="15" name="text" ></textarea><FORM ENCTYPE="multipart/form-data" ACTION="http://my.ru/php/upload.php" METHOD=POST>  <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000"> <p><INPUT NAME="userfile" TYPE="file"></p> <p><INPUT TYPE="submit" VALUE="Отправить"></p> </div>').fadeIn('slow').appendTo('.inputs');
		i++;
	});

	$('#remove').click(function() {
	if(i > 0) {
		$("#i:last").remove()
		i--;
	}
	});
});

</script>

             <div id="container">

             <div class="dynamic-form">

             <form>
             <div class="inputs">
             <div>
             <p>Шаг 0*</p>
             <textarea rows="10" cols="15" name="text" ></textarea>
                 <FORM ENCTYPE="multipart/form-data" ACTION="http://my.ru/php/upload.php" METHOD=POST>
                     <INPUT TYPE="hidden" name="MAX_FILE_SIZE" value="10000">
                     <!-- макс. размер -->
                     <p>Имя файла:</p> <p><INPUT NAME="userfile" TYPE="file"></p>
                     <p><INPUT TYPE="submit" VALUE="Отправить"></p>
                     </FORM>
             </div>
             </div>
             </form>
             </div>

             <p><button class="btn" value="#" id="add">Добавить шаг</button>
             <button class="btn" value="#" id="remove">Удалить шаг</button></p>

    </div>

 </div>

 <footer>
        <div class="row-fluid">
            <div class="span12">
             <p><button class="btn btn-large no-outline" style="vertical-align:middle">Создать</button></p>
               </div>
        </div>
    </footer>





  [/#assign]
[#include "structure.ftl"/]