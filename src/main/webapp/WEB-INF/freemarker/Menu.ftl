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
        <div class="block-create-menu" id="breakfast" style="display:block">
            <h1>Завтрак</h1>
            <div style="clear: both;"></div>
        </div>
        <div class="block-create-menu" id="lunch" style="display:none">
             обед
        </div>
        <div class="block-create-menu" id="dinner" style="display:none">
             ужин
        </div>

            </div>
        <div class="span6 align2">
            <div class="block-create-menu">
                <h1>Рецепты</h1>


             <div id="cuisine">
             </div>

        </div>
    </div>

</div>


[/#assign]
[#include "structure.ftl"/]