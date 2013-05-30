[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<div class="row">
    <div class="span12 text-cener padding">
        <div class="alert alert-success">
            <h4>Активация аккаунта прошла успешно </h4>
        </div>
        <div class="block-create-menu">
            Спасибо за регистрацию на нашем сайте, ${user}!
            <ul class="nav nav-pills nav-stacked">
                <li class=><a href="/index">Перейти на главную страницу</a></li>
            </ul>
        </div>
    </div>
</div>
[/#assign]
[#include "structure.ftl"/]