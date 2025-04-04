
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestor de Base de Datos</title>
<link href="Style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<script>
		function cerrarSesion() {
			window.location.href = "index.jsp";
		}
	</script>
	<button onclick="cerrarSesion()" style="color: rgb(255, 255, 255)">Cerrar sesión</button>
	<h1>GESTOR PERCOLXYZ</h1>

	<div class="container">
		<div class="containerRegistro">
			<form action="add" method="get">

				<b> ¿Qué desea hacer con sus datos? </b> <br> <select
					name="method">
					<option value="Agregar">Agregar</option>
					<option value="Mostrar">Mostrar</option>
					<option value="Editar">Editar</option>
					<option value="Borrar">Borrar</option>
					<option value="reportC1B">Nomina</option>
					<option value="reportB">Reporte ind.</option>
					<option value="reportD1">Novedades</option>

				</select> <br> <input type="submit" value="seleccionar"> <br>

				<b>codigo </b> <br> <input type="text" name="codigo"> <br>
				<b>nombreEmpleado </b> <br> <input type="text"
					name="nombreEmpleado"> <br> <b>fechaIngreso </b> <br>
				<input type="text" name="fechaIngreso"> <br> <b>sueldo
				</b> <br> <input type="text" name="sueldo"> <br> <b>dependencia
				</b> <br> <select name="dependencia">
					<option value="1">Tecnologia</option>
					<option value="2">Facturacion</option>
					<option value="3">Contabilidad</option>
					<option value="4">Comercial</option>
				</select> <br> <b>cargo </b> <br> <select name="cargo">
					<option value="1">Ingeniero de Desarrollo</option>
					<option value="2">Auxiliar especializado</option>
					<option value="3">Director de Impuestos</option>
					<option value="4">Gerente de ventas</option>
					<option value="5">Director de Facturación</option>
					<option value="6">Ingeniero de Soporte</option>
					<option value="7">DBA</option>
					<option value="8">Auditor interno</option>
					<option value="9">Director de presupuestos</option>
					<option value="10">Líder de infraestructura</option>
					<option value="11">Director de cartera</option>
					<option value="12">Líder de QA</option>
					<option value="13">Director de costos</option>
					<option value="14">Director de ventas</option>
				</select> <br> <b>eps </b> <br> <select name="eps">
					<option value="1">EPS-Sanitas</option>
					<option value="2">Aliansalud EPS</option>
					<option value="3">Nueva EPS</option>
					<option value="4">EPS-Sura</option>
				</select> <br> <b>pension </b> <br> <select name="pension">
					<option value="1">Colpensiones</option>
					<option value="2">Protección</option>
					<option value="3">Provenir</option>
					<option value="4">Skandia</option>
				</select>

			</form>
		</div>

	</div>

</body>

</html>

</html>
