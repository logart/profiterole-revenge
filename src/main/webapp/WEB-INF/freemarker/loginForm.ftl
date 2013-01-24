[#ftl]
[#assign content]
<div class="text-cener">
    <h2>Вход</h2>
</div>

<div class="row">
<div class="span3 offset3">



<form class="form-horizontal">
    <div class="text-cener">
    <div class="control-group">
     <label class="control-label" for="lo" >Логин</label>
        <div class="controls">
         <input type="text"  id="lo" placeholder="Введите логин"/>
        </div>
    </div>

    <div class="control-group">
     <label class="control-label" for="psw">Пароль</label>
        <div class="controls">
          <input type="password"  id="psw" placeholder="Введите пароль" />
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
