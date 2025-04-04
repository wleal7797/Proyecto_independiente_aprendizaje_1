<%@page import="co.edu.unbosque.model.Data_Base_Final"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.unbosque.controller.Data_Base_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sus Datos...</title>
<link href="Style.css" rel="stylesheet" type="text/css">
<br>
</head>
<body>
	<script>
		function vuelveInicio() {
			window.location.href = "Main.jsp";
		}
	</script>
	<button onclick="vuelveInicio()" style="color: rgb(255, 255, 255)">REGRESAR</button>
	<form action="consultaC.jsp" method="get">


		<select id="orden" name="orden" onchange="sortList()">
			<option value="ascendente">Ascendente</option>
			<option value="descendente">Descendente</option>
		</select> <input type="submit" value="Confirmar" class="Button" />
	</form>
	<br>
	<br>
	<table
		style="width: 65%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 10px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">CODIGO</th>
				<th style="color: rgb(255, 255, 255)">NOMBRE</th>

			</tr>
		</thead>
		<tbody>

			<%
			String code = request.getParameter("orden");
			if (code != null && code.equals("ascendente")) {
				List<Data_Base_Final> listado = Data_Base_DAO.reportC1B(code);
				for (Data_Base_Final dto : listado) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				} else if (code != null && code.equals("descendente")) {
				List<Data_Base_Final> listadoB = Data_Base_DAO.reportC1B(code);

				for (Data_Base_Final dto : listadoB) {
				%>
			
			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				}
				%>
			
		</tbody>


	</table>
	<br>
	<br>
	<table
		style="width: 65%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 10px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255)">NOMBRE</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (code != null && code.equals("ascendente")) {
				List<Data_Base_Final> listado = Data_Base_DAO.reportC2(code);
				for (Data_Base_Final dto : listado) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">

				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				} else if (code != null && code.equals("descendente")) {
				List<Data_Base_Final> listadoB = Data_Base_DAO.reportC2(code);

				for (Data_Base_Final dto : listadoB) {
				%>
			
			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				}
				%>
			
		</tbody>


	</table>
	<br>
	<br>
	<table
		style="width: 65%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 10px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">

				<th style="color: rgb(255, 255, 255)">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255)">CARGO</th>
				<th style="color: rgb(255, 255, 255)">NOMBRE</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (code != null && code.equals("ascendente")) {
				List<Data_Base_Final> listado = Data_Base_DAO.reportC3(code);
				for (Data_Base_Final dto : listado) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreCargo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				} else if (code != null && code.equals("descendente")) {
				List<Data_Base_Final> listadoB = Data_Base_DAO.reportC3(code);

				for (Data_Base_Final dto : listadoB) {
				%>
			
			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreCargo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
			<tr>
				<%
				}
				}
				%>
			
		</tbody>


	</table>

</html>