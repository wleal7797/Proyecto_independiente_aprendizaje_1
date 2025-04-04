<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="Style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Saved Data</title>
</head>
<body>
	<h1>Tus datos se guardaron correctamente en la base de datos...</h1>
	<script>
		function vuelveInicio() {
			window.location.href = "Main.jsp";
		}
	</script>
	<button onclick="vuelveInicio()" style="color: rgb(255, 255, 255)">REGRESAR</button>
</body>
</html>