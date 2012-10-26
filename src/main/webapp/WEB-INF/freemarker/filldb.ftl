[#ftl]
[#assign content]

    [#list model as a]
    <li><img src="${a.imglink}"/>${a.cuisin}</li>
    [/#list]

[/#assign]
[#include "structure.ftl"/]