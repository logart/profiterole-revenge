[#ftl]

<script type="text/javascript">

    $(document).ready(function(){

    $('div.item').click( function() {
    var myCuisine=$(this).attr("title");
    var cuisineId='cuisineId='+myCuisine;
    $.ajax({
    url: '/recipeListFromAjax',
    type: 'GET',
    data: cuisineId,
    success: function(response){
    $('#cuisine').html(response);
    }
    });
    });

    });
</script>

[#list model as a]
<div class="item" title="${a.cuisineId}">
   <img src="${a.imglink}" height="100" width="100"/><label class="title">${a.cuisin}</label>
</div>
[/#list]
<div style="clear: both;"></div>
