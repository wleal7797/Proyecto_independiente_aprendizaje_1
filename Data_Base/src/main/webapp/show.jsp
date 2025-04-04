<%@page import="co.edu.unbosque.model.Data_Base_DTO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.unbosque.controller.Data_Base_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<button onclick="vuelveInicio()" style="color: black;">REGRESAR</button>
	<table style="width: 85%; border: 1px solid white; border-color: white; background-color: #c0c0c0; font-size: 10px; margin: 0 auto;">
		<thead>
			<tr style="background-color: rgb(150, 148, 148)">
				<th style="color: rgb(255, 255, 255) ">CODIGO</th>
				<th style="color: rgb(255, 255, 255) ">NOMBRE</th>
				<th style="color: rgb(255, 255, 255) ">DEPENDENCIA</th>
				<th style="color: rgb(255, 255, 255) ">CARGO</th>
				<th style="color: rgb(255, 255, 255) ">INGRESO</th>
				<th style="color: rgb(255, 255, 255) ">EPS</th>
				<th style="color: rgb(255, 255, 255) ">ARL</th>
				<th style="color: rgb(255, 255, 255) ">PENSIÓN</th>
				<th style="color: rgb(255, 255, 255) ">SUELDO</th>
		
		
			</tr>
		</thead>
		<tbody>
			<%
			List<Data_Base_DTO> listado = Data_Base_DAO.show();

			for (Data_Base_DTO dto : listado) {
			%>
			
			<tr style="background-color: rgb(150, 148, 148) ">
				<td style="color: rgb(255, 255, 255) "><%=dto.getCodigo()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getNombreEmpleado()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getDependencia()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getCargo()%>
				<td style="color: rgb(255, 255, 255) "><%=dto.getFechaIngreso()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getEps()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getArl()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getPension()%></td>
				<td style="color: rgb(255, 255, 255) "><%=dto.getSueldo()%>		
</td>
			<tr>
				<%
				}
				%>
			
		</tbody>
	</table>
</body>
</html>