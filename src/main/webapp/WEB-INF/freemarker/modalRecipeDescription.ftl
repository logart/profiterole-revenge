[#ftl]

[#list model as a]
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">${a.title}</h3>
</div>
<div class="modal-body">
    <img src="${a.bigImg}"/>
    <h4>Время приготовления: </h4>

    <p>${a.time}</p>
    <h4>Ингридиенты: </h4>

    <p>${a.description}</p>
</div>
<div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Закрыть</button>
    <button class="btn btn-primary">Печать</button>
</div>


[/#list]

