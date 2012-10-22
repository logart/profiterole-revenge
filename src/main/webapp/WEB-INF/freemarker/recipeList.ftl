[#ftl]
[#assign content]

   <div class="row-fluid">
    <div class="span6">
               <div class="block-create-menu">
                   <div id="recipesdrop"></div>
               </div>
           </div>
           <div class="span6 align2">
               <div class="block-create-menu">

                   <!-- DIMA`S TABS AND CARROUSEL -->
                   <div class="tabbable">
                       <ul class="nav nav-tabs btn-mini">
                           <li class="active"><a href="#tab1" data-toggle="tab">Закуски</a></li>
                           <li><a href="#tab2" data-toggle="tab">Первое</a></li>
                           <li><a href="#tab3" data-toggle="tab">Второе</a></li>
                           <li><a href="#tab4" data-toggle="tab">Десерты</a></li>
                           <li><a href="#tab5" data-toggle="tab">Напитки</a></li>
                       </ul>

                       <div class="tab-content">

                           <div class="tab-pane active" id="tab1">
                               <p>Тут рецепты закусок.</p>
                           </div>
                           <div class="tab-pane" id="tab2">
                               <p>Тут рецепты первых блюд.</p>
                           </div>
                           <div class="tab-pane" id="tab3">
                               <p>Тут рецепты вторых блюд.</p>
                           </div>
                           <div class="tab-pane" id="tab4">
                               <p>Тут рецепты десертов.</p>
                           </div>
                           <div class="tab-pane" id="tab5">
                               <p>Тут рецепты напитков.</p>
                           </div>
                           <div id="mycarousel5" class="jcarousel-skin-ie7">
                               <ul></ul>
                           </div>
                       </div>
                   </div>
                   <!-- DIMA`S TABS AND CARROUSEL END -->
                   <!-- _______________________________________ -->

                   <button class="btn btn-large" onclick="location.href='menu'">Назад к кухням</button>

                </div>
            </div>
      </div>


<script type="text/javascript">
    var mycarousel_itemList = [
        {url: "http://static.flickr.com/66/199481236_dc98b5abb3_s.jpg", title: "Flower1"},
        {url: "http://static.flickr.com/75/199481072_b4a0d09597_s.jpg", title: "Flower2"},
        {url: "http://static.flickr.com/57/199481087_33ae73a8de_s.jpg", title: "Flower3"},
        {url: "http://static.flickr.com/77/199481108_4359e6b971_s.jpg", title: "Flower4"},
        {url: "http://static.flickr.com/58/199481143_3c148d9dd3_s.jpg", title: "Flower5"},
        {url: "http://static.flickr.com/72/199481203_ad4cdcf109_s.jpg", title: "Flower6"},
        {url: "http://static.flickr.com/58/199481218_264ce20da0_s.jpg", title: "Flower7"},
        {url: "http://static.flickr.com/69/199481255_fdfe885f87_s.jpg", title: "Flower8"},
        {url: "http://static.flickr.com/60/199480111_87d4cb3e38_s.jpg", title: "Flower9"},
        {url: "http://static.flickr.com/70/229228324_08223b70fa_s.jpg", title: "Flower10"}
    ];

    function mycarousel_itemLoadCallback(carousel, state)
    {
        for (var i = carousel.first; i <= carousel.last; i++) {
            if (carousel.has(i)) {
                continue;
            }

            if (i > mycarousel_itemList.length) {
                break;
            }

            carousel.add(i, mycarousel_getItemHTML(mycarousel_itemList[i-1]));
        }
    };

    /**
     * Item html creation helper.
     */
    function mycarousel_getItemHTML(item)
    {
        return '<img src="' + item.url + '" width="75" height="75" alt="' + item.url + '" />';
    };

    jQuery(document).ready(function() {
        jQuery('#mycarousel1').jcarousel({
            size: mycarousel_itemList.length,
            itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
        });
        jQuery('#mycarousel2').jcarousel({
            size: mycarousel_itemList.length,
            itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
        });
        jQuery('#mycarousel3').jcarousel({
            size: mycarousel_itemList.length,
            itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
        });
        jQuery('#mycarousel4').jcarousel({
            size: mycarousel_itemList.length,
            itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
        });
        jQuery('#mycarousel5').jcarousel({
            size: mycarousel_itemList.length,
            itemLoadCallback: {onBeforeAnimation: mycarousel_itemLoadCallback}
        });
    });

</script>
[/#assign]
[#include "structure.ftl"/]