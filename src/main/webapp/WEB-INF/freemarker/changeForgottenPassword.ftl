[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]


    <div class="text-cener">
        <h2>Изменение забытого пароля</h2>
    </div>
    <div class="row">
        <div class="span3 offset3">

         <form method="post" commandName="changeForgottenPassword" class="form-horizontal">
         <div class="text-center">
             <div class="control-group">
                 <label class="control-label" for="password">Новый пароль</label>

                 <div class="controls">
                     [@spring.bind "changeForgottenPasswordData.password"/]
                     <input type="password" name="${spring.status.expression}" id="password" value="${spring.status.value?default("")}"/>
                 </div>
                 [#if spring.status.error]
                     <p>
                     <div class="error-div" id="passwordError">[@spring.showErrors '<br>', 'error'/]</div>
                     </p>
                 [/#if]
             </div>
             <div class="control-group">
                 <label class="control-label" for="password">Подтвердите новый пароль</label>

                 <div class="controls">
                     [@spring.bind "changeForgottenPasswordData.passwordConfirm"/]
                     <input type="password" name="${spring.status.expression}" id="passwordConfirm" value="${spring.status.value?default("")}"/>
                 </div>
                 [#if spring.status.error]
                     <p>
                     <div class="error-div" id="passwordConfirmError">[@spring.showErrors '<br>', 'error'/]</div>
                     </p>
                 [/#if]
             </div>

            <div class="control-group">
                <div class="controls">
                        <button type="submit" class="btn">Сменить пароль</button>
                </div>
            </div>
        </div>
        </form>


[/#assign]
[#include "structure.ftl"/]