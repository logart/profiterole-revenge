[#ftl]

<script type="text/javascript">

    $(document).ready(function () {

        $('#cuisine > div.btn').click(function () {
            $(".span12 > button.btn.no-display").show();
            var myCuisine = $(this).attr("href");
            $.get("/recipeListFromAjax", {cuisineId:myCuisine},
//            $.get("/recipeListFromAjax", {id:myCuisine},
                    function (response) {
                        $('#cuisine').html(response);
                    });


        });

    });
</script>
[#list model as a]
<div class="btn" href="${a.id}">
    <img class="img-cuisine" src="${a.image}" alt="${a.name}"/>
    <label>${a.name}</label>
</div>
[/#list]
<div style="clear: both;"></div>
