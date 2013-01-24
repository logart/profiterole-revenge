[#ftl]
[#assign content]
<h1>Регистрация</h1>
<p>Для регистрации заполните, пожалуйста, следующие поля (* - обязательные поля к заполнению):
</p>
<br>
<form class="form-horizontal">
    <div class="control-group">
        <label class="control-label" for="login">Логин</label>

        <div class="controls">
            <input type="text" id="login" placeholder="Логин">*
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="password">Пароль</label>

        <div class="controls">
            <input type="password" id="password" placeholder="Пароль">*
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="email">Ваш e-mail</label>

        <div class="controls">
            <input type="text" id="email" placeholder="E-mail">*
        </div>
    </div>
</form>
Дата рождения:
<tr >
    <td>
        <select>
            <option value="data1">1</option>
            <option value="data2">2</option>
            <option value="data3">3</option>
            <option value="data4">4</option>
            <option value="data5">5</option>
        </select>
    </td>
    <td>
        <select>
            <option value="jan">Январь</option>
            <option value="feb">Февраль</option>
            <option value="mar">Март</option>
            <option value="apr">Апрель</option>
            <option value="may">Май</option>
        </select>
    </td>
    <td>
        <select>
            <option value="year">1991</option>
            <option value="year">1992</option>
            <option value="year">1993</option>
            <option value="year">1994</option>
            <option value="year">1995</option>
        </select>
    </td>

</tr>
<br>

<div class="control-group">
    <div class="controls">
        <label class="checkbox">
            Пол
            <label class="radio inline" style="vertical-align: middle">
                <input type="radio" name="options" id="men" value="option1" checked/>
                <span style="vertical-align: middle">М</span>
            </label>
            <label class="radio inline" style="vertical-align: middle">
                <input type="radio" name="options" id="women" value="option2"/>
                <span style="vertical-align: middle">Ж</span>
            </label>
    </div>
</div>

Страна
<select>
    <option value="country">Украина</option>
    <option value="country">Россия</option>
    <option value="country">Франция</option>
    <option value="country">Германия</option>
</select>
<br>
<p style="text-decoration: underline" class="btn btn-link">
    <a href="/rules">Правила и условия работы на сайте</a>
</p>
<br>
<div class="control-group">
    <div class="controls">
        Я ознакомился(лась) с правилами и условиями работы на сайте и принимаю их
        <label class="checkbox inline" style="vertical-align: middle">
            <input type="checkbox" id="confirmRules" value="option1">
        </label>
    </div>
</div>
<div style="text-align: center">
    <button type="submit" class="btn">Зарегистрироваться</button>
</div>


[/#assign]
[#include "structure.ftl"/]
