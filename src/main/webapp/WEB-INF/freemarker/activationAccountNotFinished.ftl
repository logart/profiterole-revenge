[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<div class="row">
    <div class="span12 text-cener padding">
        <div class="alert alert-error">
            <h4>Активация аккаунта не закончена! </h4>
            <h4>Для использования всех возможностей сайта,активируйте свой аккаунт! </h4>
            <h4>На Ваш Email, ранее было  отправлено сообщение со ссылкой для активации аккаунта. </h4>
            <h4> Пожалуйста, проверьте Вашу почту! </h4>
        </div>
        <div class="block-create-menu">
            <ul class="nav nav-pills nav-stacked">
                <li class=><a href="/">${user}, выслать подтверждение повторно?</a></li>
            </ul>
        </div>
    </div>
</div>
[/#assign]
[#include "structure.ftl"/]