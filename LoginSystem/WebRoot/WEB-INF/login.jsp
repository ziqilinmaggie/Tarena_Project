<%@page pageEncoding="utf-8" contentType = "text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		<form action="login.do" method="post">
			username:<input type="text" name="username">${name_error}<br/>
			password:<input type="password" name="password">${pwd_error}<br/>
			<input type="submit" name="submit">
		</form>
	</body>
</html>