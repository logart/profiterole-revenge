[#ftl]

<script type="text/javascript">

    $(document).ready(function () {
    filterRecipies();
    });
</script>

<h1>Рецепты</h1>
<ul class="nav nav-tabs" id="myTab">
    <li class="active"><a href="#1" id="1">Закуски</a></li>
    <li><a href="#2" id="2">Первое</a></li>
    <li><a href="#3" id="3">Второе</a></li>
    <li><a href="#4" id="4">Десерты</a></li>
    <li><a href="#5" id="5">Напитки</a></li>
</ul>


[#list model as a]
<div class="btn recepies_btn" data-content="${a.description}" href="/modalRecipeDescription?recipeId=${a.recipeId}"
     data-toggle="modal" data-target="#myModal">
    <div class="imgContainer"><img src="${a.smallImg}" class="img-rounded"/></div>
    <label class="title">${a.title}</label>
    <div class="time_value" style="display: none">${a.time}</div>
    <div class="cat_value" style="display: none">${a.categories.categoriesId}</div>
</div>
[/#list]


<div class="modal fade" id="myModal">

</div>

<div style="clear: both;"></div>
<button class="btn" id="back">Назад к кухням</button>

<script>
    $(function () {
        $('#myTab a:first').tab('show');
    })
</script>

<script>
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
        filterRecipies();
    <!--alert($(this).attr('id'));-->
        <!--var cat=$(this).attr('id');-->
    <!--$(".btn.recepies_btn").filterR(function (index) {-->

    <!--if (($(this).find(".cat_value").text()==cat ) {-->
    <!--$(this).show();-->
    <!--}-->
    <!--else {-->
    <!--$(this).hide();-->
    <!--}-->
    <!--return true;-->
    <!--}-->
    <!--);-->

    })
</script>

<script type="text/javascript">
    $('#back').click(function () {
        $.get("/menuCuisinesAjax", function (response) {
            $('#cuisine').html(response);
        });
    });
</script>

<script type="text/javascript">
    $(".btn[data-toggle=modal]").click(function (e) {
        lv_target = $(this).attr('data-target')
        lv_url = $(this).attr('href')
        $(lv_target).load(lv_url)
    })
</script>

<script>
    $('.btn').popover({
        trigger:'hover'
    })

</script>














