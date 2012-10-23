[#ftl]

[#list model as a]
<div class="item1" data-content="${a.description}" href="/modalRecipeDescription?recipeId=${a.recipeId}"
     data-toggle="modal" data-target="#myModal">
    <div class="imgContainer"><img src="${a.smallImg}"/></div>
    <label class="title">${a.title}</label>
</div>
[/#list]


<div class="modal fade" id="myModal">

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-primary">Save changes</button>
    </div>
</div>


<button class="btn" id="back" onclick="display_alert()">Назад к кухням</button>

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

<script type="text/javascript">
    var total_items = 0;
    var total_price = 0;
    $(document).ready(function() {


    $(".item1").draggable({
    revert: true
    });
    $("#cart_items").draggable({
    axis: "x"
    });

    $("#cart_items").droppable({
    accept: ".item1",
    activeClass: "drop-active",
    hoverClass: "drop-hover",
    drop: function(event, ui) {
    var item = ui.draggable.html();
    var itemid = ui.draggable.attr("id");
    var html = '
    <div class="item1 icart">';
        html = html + '
        <div class="divrm">';
            html = html + '<a onclick="remove(this)" class="remove '+itemid+'">&times;</a>';
            html = html + '
            <div/>
            '+item+'
        </div>
        ';
        $("#cart_items").append(html);
        }
        });
        });
</script>












