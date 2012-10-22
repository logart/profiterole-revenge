[#ftl]
[#assign content]

[#list model as a]
<li>${a.title}</li>

[/#list]

[/#assign]
[#include "structure.ftl"/]