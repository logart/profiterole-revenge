[#ftl]

<script type="text/javascript">

    $(document).ready(function () {

        $('#cuisine > div.btn').click(function () {

            var myCuisine = $(this).attr("href");

            $.get("/recipes", {cuisineId:myCuisine},
                    function (response) {
                        $('#cuisine').html(response);
                    });


        });

    });
</script>
[#list modl as a]
<div class="btn" href="${a.id}">
    <img class="img-cuisine" src="${a.image}" alt="${a.name}"/>
    <label>${a.name}</label>
</div>
[/#list]
<div style="clear: both;"></div>
