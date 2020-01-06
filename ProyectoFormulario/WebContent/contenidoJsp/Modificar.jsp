<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Formulario</title>
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
</head>
<body>

	<div id="container">
		<div id="columnaIzquierda">
		<h2>-Modificar datos-</h2>
		<form action="../Modificar" method="post" name="formDatosPersonales">
			<p>"Ingrese el mismo correo: "</p>
			<label id=email>Email*</label>	<br> 
			<input type="email" name="email"  placeholder="ejemplo@gmail.com" required /><br>

			<label for="nombre">Nombre *</label><br> 
			<input type="text"name="nombre" id="nombre" placeholder="Escribe tu nombre" required /><br>

			<label for="apellidos">Apellidos*</label><br> 
			<input type="text" name="apellidos" id="apellidos" placeholder="Apellidos"required /><br> 

			<label for="asunto">Asunto*</label><br> 
			<input type="text" name="asunto" id="asunto" placeholder="Motivo de la consulta"required /><br> 
			<label>Estado* </label><br> 
			<select	name="estadoList" required>
				<option value="Jalisco">Jalisco</option>
				<option value="Colima">Colima</option>
				<option value="Durango">Durango</option>
			</select> <br> 
			<label id="mensaje">Mensaje</label><br>
			<textarea rows="300" name="mensajeText"  placeholder="Describe el problema"required></textarea>
			<br> <br> 
			<input id="botonEstilo" type="submit" name="modificar" value="Modificar" />
		</form>
	</div>
	<div id="columnaDerecha">
		<p>Foto</p>
		<video id="live" width="320" height="240" autoplay></video>
	</div>
	</div>

</body>
<script type="text/javascript" src="JavaScript.js"></script>
</html>

