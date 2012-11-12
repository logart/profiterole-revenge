[#ftl]

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">${model.title}</h3>
</div>
<div class="modal-body">
    <img src="${model.bigImg}" class="img-rounded"/>
    <h4>Время приготовления: </h4>

    <p>${model.time}</p>
    <h4>Ингридиенты: </h4>

    <p>${model.description}</p>
</div>
<div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Закрыть</button>
    <button class="btn btn-primary">Печать</button>
</div>



