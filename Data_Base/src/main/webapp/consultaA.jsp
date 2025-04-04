<%@page import="co.edu.unbosque.model.Data_Base_Novedad"%>
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
</head>
<body>
<script>
			function vuelveInicio() {
				window.location.href = "Main.jsp";
			}
		</script>
<button onclick="vuelveInicio()" style="color: rgb(255, 255, 255)" >REGRESAR</button>
	<br>
	<table
		style="width: 65%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 12px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">CODIGO</th>
				<th style="color: rgb(255, 255, 255)">NOMBRE</th>

			</tr>
		</thead>
		<tbody>
			<%
			List<Data_Base_Novedad> listado = Data_Base_DAO.reportD1();

			for (Data_Base_Novedad dto : listado) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
				</td>
			<tr>
				<%
				}
				%>
			
		</tbody>

	</table>
	<br>
	<br>
	<br>
	<table
		style="width: 75%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 12px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255)">CARGO</th>
				<th style="color: rgb(255, 255, 255)">CANT. EMPLEADOS</th>

			</tr>
		</thead>
		<tbody>
			<%
			List<Data_Base_Novedad> listadoB = Data_Base_DAO.reportD2();
			for (Data_Base_Novedad dtoB : listadoB) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dtoB.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoB.getNombreCargo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoB.getCatidadEmpleados()%></td>
				</td>
			<tr>
				<%
				}
				%>
			
		</tbody>
	</table>

	<br>
	<br>
	<br>
	<table
		style="width: 95%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 12px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">CODIGO</th>
				<th style="color: rgb(255, 255, 255)">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255)">CARGO</th>
				<th style="color: rgb(255, 255, 255)">INCAPACIDADES</th>
				<th style="color: rgb(255, 255, 255)">INICIO</th>
				<th style="color: rgb(255, 255, 255)">FINAL</th>
				<th style="color: rgb(255, 255, 255)">TRABAJADO</th>
				<th style="color: rgb(255, 255, 255)">VACACIONES</th>
				<th style="color: rgb(255, 255, 255)">BONIFICACION</th>
				<th style="color: rgb(255, 255, 255)">TRANSPORTE</th>
				<th style="color: rgb(255, 255, 255)">SALARIO</th>

			</tr>
		</thead>
		<tbody>
			<%
			List<Data_Base_Novedad> listadoC = Data_Base_DAO.reportD3();
			for (Data_Base_Novedad dtoC : listadoC) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getNombreCargo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getCantidadIncapacidades()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getFechaInicioIncapacidad()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getFechaTerminacionIncapacidad()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getNumDiasTrabajosMes()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getPeriodoVacaciones()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getTotalBonificacion()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getTotalTransporte()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dtoC.getSalarioTotal()%></td>
				</td>
			<tr>
				<%
				}
				%>
			
		</tbody>
	</table>

</body>

</html>