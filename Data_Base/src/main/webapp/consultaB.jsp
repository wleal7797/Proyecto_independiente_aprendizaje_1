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
</head>
<body>
	<script>
		function vuelveInicio() {
			window.location.href = "Main.jsp";
		}
	</script>
	<button onclick="vuelveInicio()" style="color: rgb(255, 255, 255)">REGRESAR</button>
	<form action="consultaB.jsp" method="get">
		<br> <input name="code" id="code" type="text" class="Input"
			value="" size="20" /> <input type="submit" value="Confirmar"
			class="Button" />
	</form>
	<br>
	<br>
	<table
		style="width: 95%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 8px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255)">CODIGO</th>
				<th style="color: rgb(255, 255, 255)">NOMBRE</th>
				<th style="color: rgb(255, 255, 255)">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255)">CARGO</th>
				<th style="color: rgb(255, 255, 255)">INGRESO</th>
				<th style="color: rgb(255, 255, 255)">EPS</th>
				<th style="color: rgb(255, 255, 255)">PENSIÓN</th>
				<th style="color: rgb(255, 255, 255)">SALARIO</th>
				<th style="color: rgb(255, 255, 255)">INCAPACIDAD</th>
				<th style="color: rgb(255, 255, 255)">VACACIONES</th>
				<th style="color: rgb(255, 255, 255)">TRABAJO</th>
				<th style="color: rgb(255, 255, 255)">INICIO VACACIONES</th>
				<th style="color: rgb(255, 255, 255)">FIN VACACIONES</th>
				<th style="color: rgb(255, 255, 255)">INICIO INCAPACIDAD</th>
				<th style="color: rgb(255, 255, 255)">FIN INCAPACIDAD</th>
				<th style="color: rgb(255, 255, 255)">BONIFICACIÓN</th>
				<th style="color: rgb(255, 255, 255)">TRANSPORTE</th>

			</tr>
		</thead>
		<tbody>

			<%
			String code = request.getParameter("code");

			List<Data_Base_Final> listado = Data_Base_DAO.reportB(code);

			for (Data_Base_Final dto : listado) {
			%>

			<tr style="background-color: rgb(150, 148, 148)">
				<td style="color: rgb(255, 255, 255)"><%=dto.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreEmpleado()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreDependencia()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNombreCargo()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getFechaIngreso()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getEps()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getPension()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getSalarioTotal()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getIncapacidad()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getPeriodoVacaciones()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getNumDiasTrabajosMes()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getFechaInicioVacaciones()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getFechaTerminacionVacaciones()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getFechaInicioIncapacidad()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getFechaTerminacionIncapacidad()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getTotalBonificacion()%></td>
				<td style="color: rgb(255, 255, 255)"><%=dto.getTotalTransporte()%></td>

				</td>
			<tr>
				<%
				}
				%>
			
		</tbody>

	</table>

	
</html>