[#ftl]
[#assign content]

<script type="text/javascript">

    $(document).ready(function(){
    var myQuote = $('#hiddens');
    myQuote.hide();
    $('.btn').click(function(){

    var myMeal=$(this).attr("value");
    var meal='meal='+myMeal;
    $.ajax({
    url:	 '/menuChoice',
    type:	 'GET',
    data:    meal,
    success: function(response) {
                            var my_div = $(response);
                            my_div.appendTo("#cart_items")
                            ;
                        }
                    });
    $.ajax({
    url:	 '/menuCuisinesAjax',
    type:	 'GET',
    success: function(response){
    $('#cuisine').html(response);
    }
    });

    myQuote.show(500);
    });



    });
</script>

<div class="btn-group" data-toggle="buttons-radio">
    <button class="btn btn-large"  value="breakfast">Завтрак</button>

    <button class="btn btn-large"  value="dinner">Обед</button>
    <button class="btn btn-large"  value="supper">Ужин</button>
</div>
<div id="hiddens" style="display:none">

    <div class="row-fluid">
        <div class="span6">
            <div class="block-create-menu">
                <div id="recipesdrop">
                    <div id="cart_items" class="back"></div>
                </div>
            </div>
        </div>
        <div class="span6 align2">
            <div class="block-create-menu">
                <h1>Рецепты</h1>

                 <div>Время приготовления(в часах):<div class="mar" id="time">2</div>   </div>
                <div class="slider btn-group"></div>


             <div id="cuisine">
             </div>

        </div>
    </div>

</div>

    <script type="text/javascript">
    $(".slider").slider({
                animate: true,
                range: "min",
                value: 2,
                min: 0,
                max: 5,
                step: 1,

                //Получаем значение и выводим его на странице
                slide: function(event, ui) {
                    $("#time").html(ui.value);
                },

                //Обновляем скрытое поле формы, так что можно передать данные с помощью формы
                change: function(event, ui) {
                    $('#hidden').attr('value', ui.value);
                },

                 stop: function(event, ui) {}

            });
</script>

[/#assign]
[#include "structure.ftl"/]