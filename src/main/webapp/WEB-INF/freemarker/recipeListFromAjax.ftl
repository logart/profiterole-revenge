[#ftl]

[#list model as a]
<a href="#myModal" data-toggle="modal">
<div class="item1">
<div class="imgContainer"><img src="${a.smallImg}" /></div> <label class="title">${a.title}</label>
</div></a>
[/#list]

<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Рецепты</h3>
  </div>
  <div class="modal-body">
    <p>описание</p>
  </div>
  <div class="modal-footer">
    <button class="btn btn-primary">Пичаль</button>
  </div>
</div>


<button class="btn" id="back" onclick="display_alert()">Назад к кухням</button>

<script>
$(".item1").onclick(){

    }
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
           var html = '<div class="item1 icart">';
           html = html + '<div class="divrm">';
           html = html + '<a onclick="remove(this)" class="remove '+itemid+'">&times;</a>';
           html = html + '<div/>'+item+'</div>';
           $("#cart_items").append(html);
       }
   });
   });
</script>



[#--<script type="text/javascript">--]
    [#--$(document).ready(function () {--]

    [#--$("#foo1").carouFredSel();--]

    [#--$('.carousel').carousel({--]
        [#--interval: 2000--]
    [#--});--]
    [#--$('#back').click(function(){--]
    [#--$.ajax({--]
    [#--url:	 '/menuCuisinesAjax',--]
    [#--type:	 'GET',--]
    [#--success: function(response){--]
    [#--$('#cuisine').html(response);--]
    [#--}--]
    [#--});--]
    [#--});--]


    [#--}--]



    [#--});--]
[#--</script>--]












