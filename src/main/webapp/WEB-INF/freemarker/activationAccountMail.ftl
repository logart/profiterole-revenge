<!DOCTYPE HTML>

<html>

<body style="background-color:#FFE0CC;">
	<div style="margin:0 auto; width:650px; background-color:#FFE0CC; box-shadow:0 0 15px black;-moz-box-shadow:0 0 15px black; padding:10px; margin-top:20px; margin-bottom:20px;">
		<div style=" margin:0 30px; padding-top:40px; padding-bottom:40px;">
			<span style="font-family:Arial, Helvetica, sans-serif; font-size:14px; color:dimgray;">
				<span style="font-weight:bold;">Здравствуйте, ${login}</span><br><br>


				Вы зарегистрировались на сайте <span style="color:black;">PROFITEROLE</span>.<br>
				Для активации вашего аккаунта, пожалуйста, перейдите по ссылке <a style="font-family:Arial, Helvetica, sans-serif; font-size:14px; color:#0077c0;" href="${responseURL}">activation page</a>.<br>


				Ждем вас на нашем сайте <a style="font-family:Arial, Helvetica, sans-serif; font-size:14px; color:#0077c0;" href="${commonURL}" alt="${commonURL}" class="external" target="_blank">Profiterole</a>.
			</span>
		</div>
		<div style="clear:both;text-align:right;">
			<a style="font-family:Arial, Helvetica, sans-serif; font-size:12px; color:silver;" href="${commonURL}" class="external" target="_blank">${commonURL}</a>
		</div>
	</div>
</body>
</html>