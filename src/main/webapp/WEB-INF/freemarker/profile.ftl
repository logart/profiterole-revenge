[#ftl]
[#assign content]


<h2>Профиль пользователя</h2>
<div class="white-block">
    <div class="control-group">
        <label class="control-label-left" for="login">Логин</label>

        <div class="controls">
            <input type="text" name="" id="login"
                   value="${account.login?default("")}" readonly/><strong>*</strong>
        </div>
    </div>



    <div class="control-group">
        <label class="control-label-left" for="email">Ваш e-mail</label>

        <div class="controls">
            <input type="text" name="" id="email"
                   value="${account.email?default("")}" readonly/><strong>*</strong>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label-left" for="dateOfBirth">Дата рождения:</label>

        <div class="controls">
            [#if account.dateOfBirth?has_content]
                <input class="span2" type="text/javascript" name="" id="dateOfBirth"
                       value="${account.dateOfBirth.time?string("dd.MM.yyyy")}" readonly/>
            [/#if]
        </div>
    </div>


    <div class="control-group">
        <div class="control-label-left" style="padding-top: 5px;">Пол:</div>
        <div class="controls">

            [#if account.maleOrFemale?if_exists == "Male"]
                <label class="radio inline">
                    Мужской
                </label>
            [/#if]

            [#if account.maleOrFemale?if_exists == "Female"]
                <label class="radio inline">
                    Женский
                </label>
            [/#if]
        </div>
    </div>


    <div class="control-group">
        <div class="control-label-left">Страна</div>
        <div class="controls">
            [#if account.country?has_content]
                <input class="span2" type="text" name="" id="country"
                       value="${account.country?default("")}" readonly/>
            [/#if]

        </div>
    </div>

    <div style="text-align: center">
        <button type="submit" class="btn" onclick="location.href='editProfile';">Редактировать</button>
    </div>
</div>



[/#assign]
[#include "structure.ftl"/]