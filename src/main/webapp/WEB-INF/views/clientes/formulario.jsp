<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/springtaller/clientes" method="post">
		<div>
<!-- 		Propiedad name identico al nombre del atributo de la clase -->
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" id="nombre">
		</div>
		<div>
			<label for="correo">Correo</label>
			<input type="email" name="correo" id="correo">
		</div>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form>
</body>
</html>