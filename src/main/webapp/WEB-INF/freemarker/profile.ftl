[#ftl]
[#assign content]


<div class="text-cener">
    <h2>Профиль пользователя</h2> </div>

      <div class="control-group">
            <label class="control-label-left" for="login">Логин</label>

            <div class="controls">
               <input type="text" name="" id="login"
                      value="${account.login?default("")}"readonly /><strong>*</strong>
            </div>
         </div>

      <div class="control-group">
            <label class="control-label-left" for="password">Пароль</label>

            <div class="controls">
               <input type="password" name="" id="password"
                      value="${account.password?default("")}"readonly/><strong>*</strong>
               </div>
            </div>

      <div class="control-group">
            <label class="control-label-left" for="email">Ваш e-mail</label>

            <div class="controls">
                <input type="text" name="" id="email"
                        value="${account.email?default("")}"readonly/><strong>*</strong>
            </div>
         </div>

      <div class="control-group">
              <label class="control-label-left" for="dateOfBirth">Дата рождения:</label>

             <div class="controls">
             [#if account.dateOfBirth?has_content]
                 <input class="span2" type="text/javascript" name="" id="dateOfBirth"
                  value="${account.dateOfBirth.time?string("dd.MM.yyyy")}"readonly/>
             [/#if]
              </div>
            </div>



    <div class="control-group">
        <div class="control-label-left" style="padding-top: 5px;">Пол:</div>
        <div class="controls">

             [#if account.maleOrFemale?if_exists == "Male"]
             <label class="radio inline">
                 М
            </label>
             [/#if]

             [#if account.maleOrFemale?if_exists == "Female"]
             <label class="radio inline">
                 Ж
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
        <button type="submit" class="btn" onclick="location.href='editProfile';" >Изменить</button>
    </div>
</form>



[/#assign]
[#include "structure.ftl"/]