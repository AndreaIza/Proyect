<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Formulario-Menu</title>
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
</head>
<body>
	
	<p>-Menú Principal de Solicitud-</p><br><br>
	
	<div id="cInsertar">
	<form action="http://localhost:2222/ProyectoFormulario/contenidoJsp/Index.jsp" method="post">
	<input id="botonEstilo" type="submit" name="insertar" value="Agregar Solicitud" />
	</form>
	</div>
	
	<div id="cConsultar">
	<form action="../Consultar" method="post">
	<label>Correo a consultar:</label>
	<input type="text" name="correoConsultar"  placeholder="ejemplo@gmail.com"required/>
	<input id="botonEstilo" type="submit" name="consultar" value="Consultar" />
	</form>
	</div>
	
	<div id="cModificar">
	<form action="http://localhost:2222/ProyectoFormulario/contenidoJsp/Modificar.jsp" method="post">
	<label>Correo a modificar:</label>
	<input type="text" name="correoModificar"  placeholder="ejemplo@gmail.com"required/>
	<input id="botonEstilo" type="submit" name="modificarCorreo" value="Modificar" />
	</form>
	</div>
	
	<div id="cEliminar">
	<form action="../Eliminar" method="post">
	<label>Correo a Eliminar:</label>
	<input type="text" name="correoEliminar"  placeholder="ejemplo@gmail.com"required/>
	<input id="botonEstilo" type="submit" name="eliminar" value="Enliminar" />
	</form>
	</div>

</body>
</html>

