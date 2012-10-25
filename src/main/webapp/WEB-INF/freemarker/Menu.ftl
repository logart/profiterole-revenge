[#ftl]
[#assign content]

<script type="text/javascript">

    $(document).ready(function(){
    $.get("/menuCuisinesAjax", function(response){
    $('#cuisine').html(response);
    });


    $('.btn').click(function(){

    $('#hiddens').show(500);

    var myMeal=$(this).attr("value");
    $('#menuDrop').children().hide();
    $(myMeal).show();


    var heightArray = $(".block-create-menu").map( function(){
    return $(this).height();
    }).get();
    var maxHeight = Math.max.apply( Math, heightArray);
    $(".block-create-menu").height(maxHeight);

    });
    });
</script>

<div class="btn-group" data-toggle="buttons-radio">
    <button class="btn btn-large" value="#breakfast">Завтрак</button>

    <button class="btn btn-large" value="#dinner">Обед</button>
    <button class="btn btn-large" value="#supper">Ужин</button>
</div>
<div id="hiddens" style="display:none">

    <div class="row-fluid">
        <div class="span6" id="menuDrop">
            <div class="block-create-menu" id="breakfast">
                <h1>Завтрак</h1>
            </div>
            <div class="block-create-menu" id="dinner">
                <h1>Обед</h1>
            </div>
            <div class="block-create-menu" id="supper">
                <h1>Ужин</h1>
            </div>

        </div>
        <div class="span6 align2">
            <div class="block-create-menu" id="rec">
                <div id="cuisine"></div>


            </div>

        </div>
    </div>

</div>


[/#assign]
[#include "structure.ftl"/]