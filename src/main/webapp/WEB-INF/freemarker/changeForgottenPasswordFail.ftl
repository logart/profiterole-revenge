[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<div class="row">
    <div class="span12 text-cener padding">
        <div class="alert alert-error">
            <h4>Произошла ошибка при изменении пароля.</h4>
        </div>
        <div class="block-create-menu">
            Повторите попытку или обратитесь к администратору сайта.
            <ul class="nav nav-pills nav-stacked">
                <li class=><a href="/login">Перейти на страницу входа</a></li>
            </ul>
        </div>
    </div>
</div>
[/#assign]
[#include "structure.ftl"/]