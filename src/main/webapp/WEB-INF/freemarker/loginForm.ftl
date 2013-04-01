[#ftl]
[#assign content]
<div class="text-cener">
    <h2>Вход</h2>
</div>

<div class="row">
    <div class="span3 offset3">



        <form class="form-horizontal" action="/j_spring_security_check" method="post">
            <div class="text-center">
                <div class="control-group">
                    [#if error = true]
                        <div class="error-div error" id="passwordOrLoginError">Вы ввели неверный логин и/или пароль</div>
                    [/#if]
                    <label class="control-label" for="j_username">Логин</label>

                    <div class="controls">
                        <input type="text" id="j_username" name="j_username"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="j_password">Пароль</label>

                    <div class="controls">
                        <input type="password" id="j_password" name="j_password"/>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                         <ul class="btn btn-link pull-left" style="text-decoration: underline">
							<a href="/forgotPassword">Забыли&nbsp;пароль?</a>
						</ul>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn">Войти</button>
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>



[/#assign]
[#include "structure.ftl"/]
