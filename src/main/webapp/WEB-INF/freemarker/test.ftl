[#ftl]
[#assign content]

    [#list model as a]
    <li><img src="${a.smallImg}"/>${a.title}; ${a.cuisine.cuisin}</li>
    [/#list]

[/#assign]
[#include "structure.ftl"/]