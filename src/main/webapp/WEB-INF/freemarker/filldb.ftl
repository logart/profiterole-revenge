[#ftl]
[#assign content]

    [#list model as a]
    <li><img src="${a.image}"/>${a.name}</li>
    [/#list]

[/#assign]
[#include "structure.ftl"/]