[#ftl]
<h1>Рецепты</h1>
[#list model as a]
<div class="item1" data-content="${a.description}" href="/modalRecipeDescription?recipeId=${a.recipeId}"
     data-toggle="modal" data-target="#myModal">
    <div class="imgContainer"><img src="${a.smallImg}"/></div>
    <label class="title">${a.title}</label>
</div>
[/#list]


<div class="modal fade" id="myModal">

</div>


<button class="btn" id="back">Назад к кухням</button>

<script type="text/javascript">
    $('#back').click(function(){
    $.get("/menuCuisinesAjax", function(response){
    $('#cuisine').html(response);
    });});
</script>

<script type="text/javascript">
    $(".item1[data-toggle=modal]").click(function (e) {
    lv_target = $(this).attr('data-target')
    lv_url = $(this).attr('href')
    $(lv_target).load(lv_url)})
</script>

<script>
    $('.item1').popover({
    trigger: 'hover',
    })

</script>











