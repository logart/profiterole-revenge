[#ftl]
[#assign content]
<h1>Регистрация</h1>
<p>Для регистрации заполните, пожалуйста, следующие поля (<strong>*</strong> - обязательные поля к заполнению):
</p>
<br>
<form class="form-horizontal">
    <div class="control-group">
        <label class="control-label-left" for="login">Логин</label>

        <div class="controls">
            <input type="text" id="login"><strong>*</strong>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label-left" for="password">Пароль</label>

        <div class="controls">
            <input type="password" id="password"><strong>*</strong>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label-left" for="email">Ваш e-mail</label>

        <div class="controls">
            <input type="text" id="email""><strong>*</strong>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label-left">Дата рождения:</label>

        <script type="text/javascript">
            $(function () {
                $.datepicker.setDefaults($.extend($.datepicker.regional["ru"])
                );
                $("#datepicker").datepicker({
                    minDate: "-70y",
                    maxDate: "-1d",
                    yearRange: "1900:2025",
                    changeYear: true
                });

            });
        </script>

        <div class="controls">
            <p><input class="span2" type="text" id="datepicker" value=""/></p>
        </div>

    </div>

    <div class="control-group">
        <div class="control-label-left" style="padding-top: 5px;">Пол</div>
        <div class="controls">
            <label class="radio inline">
                <input type="radio" name="options" id="men" value="option1"/>М
            </label>
            <label class="radio inline">
                <input type="radio" name="options" id="women" value="option2"/>Ж
            </label>
        </div>
    </div>

    <div class="control-group">
        <div class="control-label-left">Страна</div>
        <div class="controls">
            <select class="span2">
                <option value="country"></option>
                <option value="country">Украина</option>
                <option value="country">Россия</option>
                <option value="country">Франция</option>
                <option value="country">Германия</option>
            </select>
        </div>
    </div>

    <div class="control-group">
        <label class="checkbox inline">
            <input type="checkbox" id="confirmRules" value="option1">
            Я ознакомился(лась) с
            <a href="/rules" style="text-decoration: underline; target=" _blank">Правилами и условиями работы на сайте</a>
            и принимаю их.
        </label>
    </div>

    <div style="text-align: center">
        <button type="submit" class="btn">Зарегистрироваться</button>
    </div>

</form>


[/#assign]
[#include "structure.ftl"/]
