[#ftl]
[#assign content]
<script type="text/javascript">

    $(document).ready(function () {
        $(".btn.recepies_btn").click(function (e) {
            lv_target = $(this).attr('data-target');
            lv_url = $(this).attr('href');
            $(lv_target).load(lv_url, function () {
                $("#header").show();
                $("#body").show();
            });

        });
    });

</script>
<h2>Результат поиска:</h2>

<div class="block-search-results">
    <div class="content padding">
        <table class="table table-bordered table-striped">
            <tbody class="span12">
                [#list model as a]
                <tr>
                    <td rowspan="2">
                        <div class="btn recepies_btn" data-content="${a.description}"
                             href="/modalRecipeDescription?recipeId=${a.id}"
                             data-toggle="modal" data-target="#myModal">
                            <div class="imgContainer"><span class="pagination-centered"><img src="${a.smallImage}"
                                                                                             class="img-rounded"/></span>
                            </div>
                        </div>
                    </td>
                    <td><p class="title-search">${a.title}</p></td>
                    <td><p class="time-search">${a.timeOfCooking} мин</p></td>
                </tr>
                <tr>
                    <td colspan="2"><p class="title-search">${a.description}</p></td>
                </tr>
                [/#list]
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="myModal">

[/#assign]
[#include "structure.ftl"/]