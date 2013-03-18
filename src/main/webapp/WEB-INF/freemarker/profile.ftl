[#ftl]
[#assign content]


<div class="text-cener">
    <h2>Профиль пользователя</h2> </div>

      <div class="control-group">
            <label class="control-label-left" for="login">Логин</label>

            <div class="controls">
               <input type="text" name="" id="login"
                      value="${account.login?default("")}" /><strong>*</strong>
            </div>
         </div>

      <div class="control-group">
            <label class="control-label-left" for="password">Пароль</label>

            <div class="controls">
               <input type="password" name="" id="password"
                      value="${account.password?default("")}"/><strong>*</strong>
               </div>
            </div>

      <div class="control-group">
            <label class="control-label-left" for="email">Ваш e-mail</label>

            <div class="controls">
                <input type="text" name="" id="email"
                        value="${account.email?default("")}"/><strong>*</strong>
            </div>
         </div>

      <div class="control-group">
              <label class="control-label-left" for="dateOfBirth">Дата рождения:</label>

             <div class="controls">
                 <input class="span2" type="text/javascript" name="" id="dateOfBirth"
                  value="${account.dateOfBirth.time?string("dd.MM.yyyy")}"/>
              </div>
            </div>



    <div class="control-group">
        <div class="control-label-left" style="padding-top: 5px;">Пол</div>
        <div class="controls">

             [#if account.maleOrFemale == "Male"]
             <label class="radio inline">
                 <input type="radio" id="male" name="gender" checked/>М
            </label>
             <label class="radio inline">
                 <input type="radio" id="female" name="gender"/>Ж
            </label>
             [/#if]

             [#if account.maleOrFemale == "Female"]
             <label class="radio inline">
                 <input type="radio" id="female" name="gender"  checked/>Ж
             </label>
             <label class="radio inline">
                 <input type="radio" id="male"  name="gender"/>М
            </label>
             [/#if]
        </div>
    </div>


    <div class="control-group">
            <div class="control-label-left">Страна</div>
            <div class="controls">
                     <input class="span2" type="text" name="" id="country"
                                            value="${account.country?default("")}"/>

            </div>
        </div>

    <div style="text-align: center">
        <button type="submit" class="btn">Изменить</button>
    </div>
</form>



[/#assign]
[#include "structure.ftl"/]