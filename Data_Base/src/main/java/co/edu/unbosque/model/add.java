package co.edu.unbosque.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.controller.Data_Base_DAO;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public add() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo, nombreEmpleado, fechaIngreso, sueldo, idDependencia, usuario, cargo, idEps, idPension, idArl,
				method;
		codigo = request.getParameter("codigo");
		nombreEmpleado = request.getParameter("nombreEmpleado");
		fechaIngreso = request.getParameter("fechaIngreso");
		sueldo = request.getParameter("sueldo");
		idDependencia = request.getParameter("dependencia");
		usuario = request.getParameter("usuario");
		cargo = request.getParameter("cargo");
		idEps = request.getParameter("eps");
		idPension = request.getParameter("pension");
		idArl = request.getParameter("arl");
		method = request.getParameter("method");

		if (method.equals("Agregar")) {
			Data_Base_DTO dto = new Data_Base_DTO();
			dto.setCodigo(codigo);
			dto.setNombreEmpleado(nombreEmpleado);
			dto.setFechaIngreso(fechaIngreso);
			dto.setSueldo(sueldo);
			dto.setDependencia(idDependencia);
			dto.setUsuario(codigo);
			dto.setCargo(cargo);
			dto.setEps(idEps);
			dto.setPension(idPension);
			dto.setArl("1");
			System.out.println("precreated");
			int estatus = Data_Base_DAO.create(dto);
			System.out.println("created");
			System.out.println(idEps);
			System.out.println(idPension);

			if (estatus > 0) {
				response.sendRedirect("create.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}
		}

		if (method.equals("Mostrar")) {
			if (Data_Base_DAO.show() != null) {
				response.sendRedirect("show.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}

		}
		if (method.equals("Editar")) {
			Data_Base_DTO dto = new Data_Base_DTO();
			dto.setNombreEmpleado(nombreEmpleado);
			dto.setDependencia(idDependencia);
			dto.setCargo(cargo);
			dto.setUsuario(codigo);
			dto.setFechaIngreso(fechaIngreso);
			dto.setEps(idEps);
			dto.setArl("1");
			dto.setPension(idPension);
			dto.setSueldo(sueldo);
			dto.setCodigo(codigo);

			int estatus = Data_Base_DAO.edit(dto);

			if (estatus > 0) {
				response.sendRedirect("edit.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}
		}
		if (method.equals("Borrar")) {
			int estatus = Data_Base_DAO.delete(codigo);
			if (estatus > 0) {
				response.sendRedirect("delete.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}
		}
		if (method.equals("reportD1") || method.equals("reportD2") || method.equals("reportD3")) {
			if (Data_Base_DAO.reportD1() != null && Data_Base_DAO.reportD2() != null) {
				response.sendRedirect("consultaA.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}

		}
		if (method.equals("reportB")) {

			if (Data_Base_DAO.reportB(codigo) != null) {
				System.out.println(Data_Base_DAO.reportB("5004"));
				response.sendRedirect("consultaB.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}

		}
		if (method.equals("reportC1B")||method.equals("reportC2")||method.equals("reportC3")) {

			if (Data_Base_DAO.reportC1B("ascendente") != null) {
				response.sendRedirect("consultaC.jsp");
			} else {
				response.sendRedirect("fallas.jsp");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
