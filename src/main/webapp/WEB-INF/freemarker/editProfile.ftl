[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<h1>Редактирование профиля</h1>

<br>
<form method="post" commandName="editProfileData" class="form-horizontal">

    <div class="control-group">
       <label class="control-label-left" for="login">Логин</label>

       <div class="controls">
          [@spring.bind "editProfileData.login"/]
          <input type="text" name="${spring.status.expression}" id="login"
                 value="${spring.status.value?default("")}" readonly/>
       </div>
       [#if spring.status.error]
             <p>
             <div class="error-div" id="loginError">[@spring.showErrors '<br>', 'error'/]</div>
             </p>
       [/#if]
    </div>


    <div class="control-group">
        <label class="control-label-left" for="password">Пароль</label>

        <div class="controls">
            [@spring.bind "editProfileData.password"/]
            <input type="password" name="${spring.status.expression}" id="password" value="${spring.status.value?default("")}"/><strong>*</strong>
        </div>
        [#if spring.status.error]
            <p>
            <div class="error-div" id="passwordError">[@spring.showErrors '<br>', 'error'/]</div>
            </p>
        [/#if]
    </div>


    <div class="control-group">
        <label class="control-label-left" for="email">Ваш e-mail</label>

        <div class="controls">
            [@spring.bind "editProfileData.email"/]
            <input type="text" name="${spring.status.expression}" id="email" value="${spring.status.value?default("")}"/><strong>*</strong>
        </div>
        [#if spring.status.error]
            <p>
            <div class="error-div" id="emailError">[@spring.showErrors '<br>', 'error'/]</div>
            </p>
        [/#if]
    </div>


    <div style="text-align: center">
        <button type="submit" class="btn">Сохранить</button>
    </div>
</form>
[/#assign]
[#include "structure.ftl"/]