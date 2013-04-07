[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<div class="row">
    <div class="span12 text-cener padding">
        <div class="alert alert-success">
            <h4>Пароль успешно изменен </h4>
        </div>
        Теперь вы можете зайти в свой аккаунт, используя новый пароль.
        <ul class="nav nav-pills nav-stacked">
            <li class=><a href="/login">Перейти на страницу входа</a></li>
        </ul>
    </div>
</div>
[/#assign]
[#include "structure.ftl"/]