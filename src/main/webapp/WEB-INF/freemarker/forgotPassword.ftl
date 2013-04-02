[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]


    <div class="text-cener">
        <h2>Восстановление пароля</h2>
    </div>
    <div class="row">
        <div class="span3 offset3">

         <form method="post" commandName="forgotPassword" class="form-horizontal">
         <div class="text-center">
            <div class="control-group">
                    <label class="control-label-left" for="email">Введите Ваш e-mail</label>

                <div class="controls">
                    [@spring.bind "email"/]
                    <input type="text" name="email" id="email" value="${spring.status.value?default("")}"/>
                </div>
                [#if spring.status.error]
                    <p>
                    <div class="error-div" id="emailError">[@spring.showErrors '<br>', 'error'/]</div>
                    </p>
                [/#if]
            </div>

            <div class="control-group">
                <div class="controls">
                        <button type="submit" class="btn">Далее</button>
                </div>
            </div>
        </div>
        </form>


[/#assign]
[#include "structure.ftl"/]