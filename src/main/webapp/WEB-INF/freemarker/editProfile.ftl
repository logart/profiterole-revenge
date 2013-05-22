[#ftl]
[#import "spring.ftl" as spring/]
[#assign content]
<h1>Редактирование профиля</h1>

<br>
<form method="post" commandName="editProfileData" class="form-horizontal">
    <div class="white-block">
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
            <label class="control-label-left" for="changePassword">Пароль</label>

            <div class="controls">
                [@spring.bind "editProfileData.changePassword"/]
                <input type="password" name="${spring.status.expression}" id="changePassword"/><strong>*</strong>
            </div>
            [#if spring.status.error]
                <p>
                <div class="error-div" id="changePasswordError">[@spring.showErrors '<br>', 'error'/]</div>
                </p>
            [/#if]
        </div>

        <div class="controls no-display">
            [@spring.bind "editProfileData.password"/]
            <input type="password" name="${spring.status.expression}" id="password" value="${spring.status.value?default("")}"/><strong>*</strong>
        </div>





        <div class="control-group">
            <label class="control-label-left" for="email">Ваш e-mail</label>

            <div class="controls">
                [@spring.bind "editProfileData.email"/]
                <input type="text" name="${spring.status.expression}" id="email"
                       value="${spring.status.value?default("")}"/><strong>*</strong>
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
                [@spring.bind "editProfileData.dateOfBirth"/]
                <p><input class="span2" type="text" name="${spring.status.expression}" id="datepicker"
                          value="${spring.status.value?default("")}"/></p>
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
                <div class="radio_gender">
                    [#assign gender={"Male":"М","Female":"Ж"}]
             [@spring.formRadioButtons  "editProfileData.maleOrFemale" gender ' ' '' /]
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
            [@spring.formSingleSelect  "editProfileData.country" cont  "class=\"span2\"" /]
            </div>
        </div>


        <div style="text-align: center">
            <button type="submit" class="btn">Сохранить</button>
        </div>
    </div>
</form>
[/#assign]
[#include "structure.ftl"/]