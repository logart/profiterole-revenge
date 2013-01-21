[#ftl]
[#assign content]

<div class="row">
    <div class="span12 paddingBig">
            [#list model as a]
                <div class="btn" href="${a.cuisineId}">
                    <img class="img-cuisine" src="${a.imglink}" alt="${a.cuisin}"/>
                    <label>${a.cuisin}</label>
                </div>
            [/#list]
    </div>
</div>

<div style="clear: both;"></div>

[/#assign]
[#include "structure.ftl"/]