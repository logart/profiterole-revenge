[#ftl]

<script type="text/javascript">

    $(document).ready(function () {

        $('div.btn').click(function () {
            var myCuisine = $(this).attr("href");

            $.get("/recipeListFromAjax", {cuisineId:myCuisine},
                    function (response) {
                        $('#cuisine').html(response);
                    });


        });

    });
</script>
[#list model as a]
<div class="btn" href="${a.cuisineId}">
    <img src="${a.imglink}" height="100" width="100" alt="${a.cuisin}"/><label>${a.cuisin}</label>
</div>
[/#list]
<div style="clear: both;"></div>
