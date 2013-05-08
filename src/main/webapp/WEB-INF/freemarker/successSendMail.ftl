[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<div class="row">
    <div class="span12 text-cener padding">
        <div class="alert alert-success">
            <h4>На Ваш Email отправлено сообщение со ссылкой для восстановления пароля. </h4>
            <h4> Пожалуйста, проверьте Вашу почту! </h4>
        </div>
        <div class="block-create-menu">
            Спасибо за регистрацию на нашем сайте!
            <ul class="nav nav-pills nav-stacked">
                <li class=><a href="/index">Перейти на главную страницу</a></li>
            </ul>
        </div>
    </div>
</div>
[/#assign]
[#include "structure.ftl"/]