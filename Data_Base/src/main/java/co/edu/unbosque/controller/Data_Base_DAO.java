package co.edu.unbosque.controller;

import co.edu.unbosque.model.Data_Base_DTO;
import co.edu.unbosque.model.Data_Base_Final;
import co.edu.unbosque.model.Data_Base_Novedad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Data_Base_DAO {

	public Data_Base_DAO() {

	}

	public static int edit(Data_Base_DTO dto) {
		int x = 0;
		try {
			Connection con = controller.getConnection();
			String data = "update empleado SET nombre_empleado = ?, fecha_ingreso = ?, sueldo = ?, id_dependencia = ?, id_cargo=?, id_eps = ?, id_pension = ?, id_arl = ?" + " where codigo = ?";

			// codigo, NombreEmpleado, Dependencia, cargo, FechaIngreso, Eps, Arl, Pension,
			// Sueldo
			PreparedStatement ps = con.prepareStatement(data);
			ps.setString(1, dto.getNombreEmpleado());
			ps.setString(2, dto.getFechaIngreso());
			ps.setString(3, dto.getSueldo());
			ps.setString(4, dto.getDependencia());
			ps.setString(5, dto.getCargo());
			ps.setString(6, dto.getEps());
			ps.setString(7, dto.getPension());
			ps.setString(8, dto.getArl());
			ps.setString(9, dto.getCodigo());
			

			x = ps.executeUpdate();
			System.out.println("Actualizado con exito");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo Actualizar adecuadamente");
			System.out.println(e.getMessage());
		}

		return x;

	}

	public static int delete(String codigo) {

		int x = 0;
		try {
			Connection con = controller.getConnection();
			String data = "delete from empleado where codigo = ?";
			PreparedStatement ps = con.prepareStatement(data);
			ps.setString(1, codigo);

			x = ps.executeUpdate();
			System.out.println("Borrado con exito");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo Borrar adecuadamente");
			System.out.println(e.getMessage());
		}

		return x;

	}

	public static List<Data_Base_DTO> show() {

		List<Data_Base_DTO> listado = new ArrayList<Data_Base_DTO>();
		execute();
		
		try {

			Connection con = controller.getConnection();
			String data = "select empleado.codigo, empleado.nombre_empleado, empleado.fecha_ingreso, empleado.sueldo, dependencia.nombre_dependencia,\r\n"
					+ "login.usuario,cargo.nombre_cargo, eps.nombre_eps, pension.nombre_pension, arl.nombre_arl \r\n"
					+ "FROM empleado \r\n"
					+ "inner join dependencia on empleado.id_dependencia = dependencia.id_dependencia\r\n"
					+ "inner join login on empleado.usuario = login.usuario\r\n"
					+ "inner join cargo on empleado.id_cargo = cargo.id_cargo\r\n"
					+ "inner join eps on empleado.id_eps = eps.id_eps \r\n"
					+ "inner join pension on empleado.id_pension = pension.id_pension\r\n"
					+ "inner join arl on empleado.id_arl = arl.id_arl";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_DTO dto = new Data_Base_DTO();

				dto.setCodigo(rs.getString("codigo"));
				dto.setNombreEmpleado(rs.getString("nombre_empleado"));
				dto.setFechaIngreso(rs.getString("fecha_ingreso"));
				dto.setSueldo(rs.getString("sueldo"));
				dto.setDependencia(rs.getString("nombre_dependencia"));
				dto.setUsuario(rs.getString("usuario"));
				dto.setCargo(rs.getString("nombre_cargo"));
				dto.setEps(rs.getString("nombre_eps"));
				dto.setPension(rs.getString("nombre_pension"));
				dto.setArl(rs.getString("nombre_arl"));

				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static int create(Data_Base_DTO dto) {
		int x = 0;
		int y = 0;
		try {
			Connection con = controller.getConnection();
			String dataA = "INSERT INTO login VALUES (?, ? + 544324234)";
			String data = "INSERT INTO empleado VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement psA = con.prepareStatement(dataA);
			PreparedStatement ps = con.prepareStatement(data);

			psA.setString(1, dto.getUsuario());
			psA.setString(2, dto.getUsuario());
			ps.setString(1, dto.getCodigo());
			ps.setString(2, dto.getNombreEmpleado());
			ps.setString(3, dto.getFechaIngreso());
			ps.setString(4, dto.getSueldo());
			ps.setString(5, dto.getDependencia());
			ps.setString(6, dto.getUsuario());
			ps.setString(7, dto.getCargo());
			ps.setString(8, dto.getEps());
			ps.setString(9, dto.getPension());
			ps.setString(10, dto.getArl());
			y = psA.executeUpdate();
			x = ps.executeUpdate();
			System.out.println("Registrado con exito");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo registrar adecuadamente");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return x;
	}

	public static List<Data_Base_Novedad> reportD1() {

		List<Data_Base_Novedad> listado = new ArrayList<Data_Base_Novedad>();

		try {

			Connection con = controller.getConnection();
			String data = "SELECT e.codigo, e.nombre_empleado FROM empleado e JOIN novedades_horario nh ON e.codigo = nh.codigo \r\n"
					+ "WHERE (nh.fecha_inicio_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_inicio_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_Novedad dto = new Data_Base_Novedad();

				dto.setCodigo(rs.getString("codigo"));
				dto.setNombreEmpleado(rs.getString("nombre_empleado"));
				dto.setNombreDependencia("nombre_dependencia");
				dto.setNombreCargo("nombre_cargo");
				dto.setCantidadIncapacidades("cantidad_incapacidades");
				dto.setFechaInicioIncapacidad("fecha_inicio_incapacidad");
				dto.setFechaTerminacionIncapacidad("fecha_terminacion_incapacidad");
				dto.setNumDiasTrabajosMes("num_dias_trabajados_mes");
				dto.setPeriodoVacaciones("perido_vacaciones");
				dto.setTotalBonificacion("total_bonificacion");
				dto.setTotalTransporte("total_transporte");
				dto.setSalarioTotal("salario_total");
				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Novedad> reportD2() {

		List<Data_Base_Novedad> listado = new ArrayList<Data_Base_Novedad>();

		try {

			Connection con = controller.getConnection();
			String data = "SELECT d.nombre_dependencia, c.nombre_cargo, COUNT(*) AS cantidad_empleados\r\n"
					+ "FROM empleado e\r\n" + "JOIN novedades_horario nh ON e.codigo = nh.codigo\r\n"
					+ "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
					+ "JOIN cargo c ON e.id_cargo = c.id_cargo\r\n"
					+ "WHERE (nh.fecha_inicio_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_inicio_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "GROUP BY d.nombre_dependencia, c.nombre_cargo;";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_Novedad dto = new Data_Base_Novedad();

				dto.setNombreDependencia(rs.getString("nombre_dependencia"));
				dto.setNombreCargo(rs.getString("nombre_cargo"));
				dto.setCatidadEmpleados(rs.getString("cantidad_empleados"));
				// Agrega aquí las asignaciones para las demás propiedades

				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Novedad> reportD3() {

		List<Data_Base_Novedad> listado = new ArrayList<Data_Base_Novedad>();

		try {

			Connection con = controller.getConnection();
			String data = "SELECT e.codigo, e.nombre_empleado, d.nombre_dependencia, c.nombre_cargo,\r\n"
					+ "       SUM(CASE WHEN nh.novedad_incapacidad = 'X' THEN 1 ELSE 0 END) AS cantidad_incapacidades,\r\n"
					+ "       MIN(nh.fecha_inicio_incapacidad) AS fecha_inicio_incapacidad,\r\n"
					+ "       MAX(nh.fecha_terminacion_incapacidad) AS fecha_terminacion_incapacidad,\r\n"
					+ "       nh.num_dias_trabajos_mes, \r\n"
					+ "       CONCAT(MIN(nh.fecha_inicio_vacaciones), ' - ', MAX(nh.fecha_terminacion_vacaciones)) AS periodo_vacaciones,\r\n"
					+ "       SUM(nh.bonificacion) AS total_bonificacion,\r\n"
					+ "       SUM(nh.transporte) AS total_transporte,\r\n"
					+ "       SUM(e.sueldo + nh.bonificacion + nh.transporte) AS salario_total\r\n"
					+ "FROM empleado e\r\n" + "JOIN novedades_horario nh ON e.codigo = nh.codigo\r\n"
					+ "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
					+ "JOIN cargo c ON e.id_cargo = c.id_cargo\r\n"
					+ "WHERE (nh.fecha_inicio_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_vacaciones BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_inicio_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "   OR (nh.fecha_terminacion_incapacidad BETWEEN '2022-03-01' AND '2022-05-31')\r\n"
					+ "GROUP BY e.codigo, e.nombre_empleado, d.nombre_dependencia, c.nombre_cargo, nh.num_dias_trabajos_mes;";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_Novedad dto = new Data_Base_Novedad();

				dto.setCodigo(rs.getString("codigo"));
				dto.setNombreEmpleado(rs.getString("nombre_empleado"));
				dto.setNombreDependencia(rs.getString("nombre_dependencia"));
				dto.setNombreCargo(rs.getString("nombre_cargo"));
				dto.setCantidadIncapacidades(rs.getString("cantidad_incapacidades"));
				dto.setFechaInicioIncapacidad(rs.getString("fecha_inicio_incapacidad"));
				dto.setFechaTerminacionIncapacidad(rs.getString("fecha_terminacion_incapacidad"));
				dto.setNumDiasTrabajosMes(rs.getString("num_dias_trabajos_mes"));
				dto.setPeriodoVacaciones(rs.getString("periodo_vacaciones"));
				dto.setTotalBonificacion(rs.getString("total_bonificacion"));
				dto.setTotalTransporte(rs.getString("total_transporte"));
				dto.setSalarioTotal(rs.getString("salario_total"));

				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Final> reportB(String value) {

		List<Data_Base_Final> listado = new ArrayList<Data_Base_Final>();

		try {

			Connection con = controller.getConnection();

			String data = "SELECT\r\n"
					+ "  e.nombre_empleado AS 'Nombre completo',\r\n"
					+ "  e.codigo AS 'Código Personal',\r\n"
					+ "  d.nombre_dependencia AS 'Dependencia',\r\n"
					+ "  c.nombre_cargo AS 'Cargo',\r\n"
					+ "  e.fecha_ingreso AS 'Fecha de ingreso',\r\n"
					+ "  eps.nombre_eps AS 'EPS',\r\n"
					+ "  p.nombre_pension AS 'Aporte Pensión',\r\n"
					+ "  e.sueldo AS 'Salario',\r\n"
					+ "  nh.novedad_incapacidad AS 'Incapacidad',\r\n"
					+ "  nh.novedad_vacaciones AS 'Vacaciones',\r\n"
					+ "  nh.num_dias_trabajos_mes AS 'Días trabajados en el mes',\r\n"
					+ "  nh.num_dias_incapacidad_mes AS 'Días de incapacidad en el mes',\r\n"
					+ "  nh.num_dias_vacaciones AS 'Días de vacaciones',\r\n"
					+ "  nh.fecha_inicio_vacaciones AS 'Fecha inicio vacaciones',\r\n"
					+ "  nh.fecha_terminacion_vacaciones AS 'Fecha terminación vacaciones',\r\n"
					+ "  nh.fecha_inicio_incapacidad AS 'Fecha inicio incapacidad',\r\n"
					+ "  nh.fecha_terminacion_incapacidad AS 'Fecha terminación incapacidad',\r\n"
					+ "  nh.bonificacion AS 'Bonificación',\r\n"
					+ "  nh.transporte AS 'Transporte'\r\n"
					+ "FROM empleado e\r\n"
					+ "INNER JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
					+ "INNER JOIN cargo c ON e.id_cargo = c.id_cargo\r\n"
					+ "INNER JOIN eps eps ON e.id_eps = eps.id_eps\r\n"
					+ "INNER JOIN pension p ON e.id_pension = p.id_pension\r\n"
					+ "LEFT JOIN novedades_horario nh ON e.codigo = nh.codigo\r\n"
					+ "WHERE e.codigo = "+value+";\r\n";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_Final dto = new Data_Base_Final();

				dto.setCodigo(rs.getString("código personal"));
				dto.setNombreEmpleado(rs.getString("Nombre completo"));
				dto.setNombreDependencia(rs.getString("Dependencia"));
				dto.setNombreCargo(rs.getString("Cargo"));
				dto.setFechaIngreso(rs.getString("Fecha de ingreso"));
				dto.setEps(rs.getString("EPS"));
				dto.setPension(rs.getString("Aporte Pensión"));
				dto.setSalarioTotal(rs.getString("Salario"));
				dto.setIncapacidad(rs.getString("Incapacidad"));
				dto.setPeriodoVacaciones(rs.getString("Vacaciones"));
				dto.setNumDiasTrabajosMes(rs.getString("Días trabajados en el mes"));
				dto.setFechaInicioVacaciones(rs.getString("Fecha inicio vacaciones"));
				dto.setFechaTerminacionVacaciones(rs.getString("Fecha terminación vacaciones"));
				dto.setFechaInicioIncapacidad(rs.getString("Fecha inicio incapacidad"));
				dto.setFechaTerminacionIncapacidad(rs.getString("Fecha terminación incapacidad"));
				dto.setTotalBonificacion(rs.getString("Bonificación"));
				dto.setTotalTransporte(rs.getString("Transporte"));
				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Final> reportC1A(String value) {

		List<Data_Base_Final> listado = new ArrayList<Data_Base_Final>();

		try {

			Connection con = controller.getConnection();

			String data = " SELECT COUNT(*)FROM EMPLEADO \r\n";
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data_Base_Final dto = new Data_Base_Final();

				dto.setCodigo(rs.getString("codigo"));
				dto.setNombreEmpleado(rs.getString("nombre_completo"));

				listado.add(dto);
			}
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Final> reportC1B(String value) {

		List<Data_Base_Final> listado = new ArrayList<Data_Base_Final>();

		try {

			Connection con = controller.getConnection();
			if (value.equals("ascendente")) {
				String data = "SELECT empleado.codigo, empleado.nombre_empleado FROM empleado ORDER BY nombre_empleado ASC\r\n"
						+ "";
				PreparedStatement ps = con.prepareStatement(data);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data_Base_Final dto = new Data_Base_Final();

					dto.setCodigo(rs.getString("codigo"));
					dto.setNombreEmpleado(rs.getString("nombre_empleado"));

					listado.add(dto);
				}
			}
				if (value.equals("descendente")) {
					String datab = " SELECT empleado.codigo, empleado.nombre_empleado FROM empleado ORDER BY nombre_empleado DESC \r\n";
					PreparedStatement ps2 = con.prepareStatement(datab);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						Data_Base_Final dto = new Data_Base_Final();

						dto.setCodigo(rs2.getString("codigo"));
						dto.setNombreEmpleado(rs2.getString("nombre_empleado"));

						listado.add(dto);
					}
				}
			
			System.out.println("Sus Datos en la pagina web... ");
			con.close();

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Final> reportC2(String value) {

		List<Data_Base_Final> listado = new ArrayList<Data_Base_Final>();

		try {

			Connection con = controller.getConnection();

			if (value.equals("ascendente")) {

				String data = "SELECT d.nombre_dependencia, e.nombre_empleado\r\n" + "FROM empleado e\r\n"
						+ "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
						+ "GROUP BY d.nombre_dependencia, e.nombre_empleado\r\n"
						+ "ORDER BY d.nombre_dependencia ASC, e.nombre_empleado ASC; ";
				PreparedStatement ps = con.prepareStatement(data);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data_Base_Final dto = new Data_Base_Final();
					dto.setNombreDependencia(rs.getString("nombre_dependencia"));
					dto.setNombreEmpleado(rs.getString("nombre_empleado"));
					

					listado.add(dto);
				}
				System.out.println("Sus Datos en la pagina web... ");
				con.close();
			}
			if (value.equals("descendente")) {

				String data = "SELECT d.nombre_dependencia, e.nombre_empleado\r\n" + "FROM empleado e\r\n"
						+ "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
						+ "GROUP BY d.nombre_dependencia, e.nombre_empleado\r\n"
						+ "ORDER BY d.nombre_dependencia ASC, e.nombre_empleado DESC; ";
				PreparedStatement ps = con.prepareStatement(data);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data_Base_Final dto = new Data_Base_Final();
					dto.setNombreDependencia(rs.getString("nombre_dependencia"));
					dto.setNombreEmpleado(rs.getString("nombre_empleado"));
					
					listado.add(dto);
				}
				System.out.println("Sus Datos en la pagina web... ");
				con.close();
			}

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}

	public static List<Data_Base_Final> reportC3(String value) {

		List<Data_Base_Final> listado = new ArrayList<Data_Base_Final>();

		try {

			Connection con = controller.getConnection();

			if (value.equals("ascendente")) {

				String data = "SELECT d.nombre_dependencia, c.nombre_cargo, e.nombre_empleado\r\n"
						+ "FROM empleado e\r\n" + "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
						+ "JOIN cargo c ON e.id_cargo = c.id_cargo\r\n"
						+ "GROUP BY d.nombre_dependencia, c.nombre_cargo, e.nombre_empleado\r\n"
						+ "ORDER BY d.nombre_dependencia ASC, c.nombre_cargo ASC, e.nombre_empleado ASC;  ";
				PreparedStatement ps = con.prepareStatement(data);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data_Base_Final dto = new Data_Base_Final();

					dto.setNombreCargo(rs.getString("nombre_cargo"));
					dto.setNombreDependencia(rs.getString("nombre_dependencia"));
					dto.setNombreEmpleado(rs.getString("nombre_empleado"));

					listado.add(dto);
				}
				System.out.println("Sus Datos en la pagina web... ");
				con.close();
			}
			if (value.equals("descendente")) {

				String data = "SELECT d.nombre_dependencia, c.nombre_cargo, e.nombre_empleado\r\n"
						+ "FROM empleado e\r\n" + "JOIN dependencia d ON e.id_dependencia = d.id_dependencia\r\n"
						+ "JOIN cargo c ON e.id_cargo = c.id_cargo\r\n"
						+ "GROUP BY d.nombre_dependencia, c.nombre_cargo, e.nombre_empleado\r\n"
						+ "ORDER BY d.nombre_dependencia ASC, c.nombre_cargo ASC, e.nombre_empleado DESC; ";
				PreparedStatement ps = con.prepareStatement(data);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data_Base_Final dto = new Data_Base_Final();

					dto.setNombreCargo(rs.getString("nombre_cargo"));
					dto.setNombreDependencia(rs.getString("nombre_dependencia"));
					dto.setNombreEmpleado(rs.getString("nombre_empleado"));

					listado.add(dto);
				}
				System.out.println("Sus Datos en la pagina web... ");
				con.close();
			}

		} catch (Exception e) {
			System.out.println("No se pudo hacer la busqueda de sus Datos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listado;

	}
	  public static void execute() {
		   String[] arrUser = new String[4998];
		     String[] arrPass = new String[4998];
		     int usuarioInicial = 5001;
		     int usuarioFinal = 9999;
		     
		     for (int i = 0; i < arrUser.length; i++) {
		         String user = String.valueOf(usuarioInicial + i);
		         String pass = String.valueOf(usuarioFinal + i + 234566);
		         arrUser[i] = user;
		         arrPass[i] = pass;
		     }
		     
		    
		        String rutaArchivo = "pass/usersAndPasswords.txt";
		        String fileName ="usersAndPasswords.txt";
		        System.out.println(System.getProperty("usersAndPasswords.txt"));

		     try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
		         for (int i = 0; i < arrUser.length; i++) {
		             writer.write("USUARIO: "+arrUser[i] + " CONTRASEÑA: " + arrPass[i]);
		             writer.newLine();
		         }
		         System.out.println("Archivo de texto creado exitosamente.");
		     } catch (IOException e) {
		         System.out.println("Error al escribir en el archivo.");
		         e.printStackTrace();
		     }
	   }
	
}
