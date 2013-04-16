[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<h1>Регистрация</h1>
<p>Для регистрации заполните, пожалуйста, следующие поля (<strong>*</strong> - обязательные поля к заполнению):
</p>
<br>
<form method="post" commandName="registrationData" class="form-horizontal">

    <div class="control-group">
       <label class="control-label-left" for="login">Логин</label>

       <div class="controls">
          [@spring.bind "registrationData.login"/]
          <input type="text" name="${spring.status.expression}" id="login"
                 value="${spring.status.value?default("")}" /><strong>*</strong>
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
            [@spring.bind "registrationData.password"/]
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
            [@spring.bind "registrationData.email"/]
            <input type="text" name="${spring.status.expression}" id="email" value="${spring.status.value?default("")}"/><strong>*</strong>
        </div>
        [#if spring.status.error]
            <p>
            <div class="error-div" id="emailError">[@spring.showErrors '<br>', 'error'/]</div>
            </p>
        [/#if]
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
            [@spring.bind "registrationData.dateOfBirth"/]
            <p><input class="span2" type="text" name="${spring.status.expression}" id="datepicker" value="${spring.status.value?default("")}"/></p>
        </div>
        [#if spring.status.error]
            <p>
            <div class="error-div" id="dateOfBirthError">[@spring.showErrors '<br>', 'error'/]</div>
            </p>
        [/#if]
   </div>


    <div class="control-group">
        <div class="control-label-left" style="padding-top: 5px;">Пол</div>
        <div class="controls">
          <div class="radio_gender" >
             [#assign gender={"Male":"М","Female":"Ж"}]
             [@spring.formRadioButtons  "registrationData.maleOrFemale" gender ' ' '' /]
           </div>
        </div>
    </div>


    <div class="control-group">
        <div class="control-label-left">Страна</div>
        <div class="controls">
            [#assign cont={"":"","Украина":"Украина",
            "Россия":"Россия",
            "Франция":"Франция",
            "Германия":"Германия",
            "Испания":"Испания",
            "Португалия":"Португалия",
            "Италия":"Италия",
            "Англия":"Англия ",
            "Ирландия":"Ирландия",
            "Норвегия":"Норвегия",
            "Швеция":"Швеция",
            "Финляндия":"Финляндия",
            "Эстония":"Эстония",
            "Латвия":"Латвия",
            "Литва":"Литва",
            "Бельгия":"Бельгия",
            "Нидерланды":"Нидерланды ",
            "Швейцария":"Швейцария",
            "Австрия":"Австрия",
            "Чешская Республика":"Чешская Республика",
            "Румыния":"Румыния",
            "Болгария":"Болгария",
            "Греция":"Греция",
            "Турция":"Турция",
            "Грузия":"Грузия",
            "Армения":"Армения",
            "Казахстан":"Казахстан",
            "Израиль":"Израиль",
            "ОАЭ":"ОАЭ",
            "Япония":"Япония",
            "Индия":"Индия",
            "Китай":"Китай",
            "США":"США" ,
            "Канада":"Канада",
            "Мексика":"Мексика",
            "Аргентина":"Аргентина"}]
            [@spring.formSingleSelect  "registrationData.country" cont  "class=\"span2\"" /]
        </div>
    </div>


       <div class="control-group">
        <label class="checkbox ">
            [@spring.formCheckbox  "registrationData.iAmAgree"/]
            Я ознакомился(лась) с
            <a href="/rules" style="text-decoration:underline" target="_blank">Правилами и условиями работы на сайте</a>
            и принимаю их.
            [#if spring.status.error]
                <p>
                <div class="error-div" id="iAmAgreeError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]
         </label>
    </div>

    <div style="text-align: center">
        <button type="submit" class="btn">Зарегистрироваться</button>
    </div>
</form>
[/#assign]
[#include "structure.ftl"/]