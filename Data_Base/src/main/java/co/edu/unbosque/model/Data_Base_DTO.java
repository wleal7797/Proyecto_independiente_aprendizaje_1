package co.edu.unbosque.model;

public class Data_Base_DTO {

	private String codigo, NombreEmpleado, Dependencia, cargo, FechaIngreso, Eps, Arl, Pension, Sueldo, usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreEmpleado() {
		return NombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}

	public String getDependencia() {
		return Dependencia;
	}

	public void setDependencia(String dependencia) {
		this.Dependencia = dependencia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public String getEps() {
		return Eps;
	}

	public void setEps(String eps) {
		Eps = eps;
	}

	public String getArl() {
		return Arl;
	}

	public void setArl(String arl) {
		Arl = arl;
	}

	public String getPension() {
		return Pension;
	}

	public void setPension(String pension) {
		Pension = pension;
	}

	public String getSueldo() {
		return Sueldo;
	}

	public void setSueldo(String sueldo) {
		Sueldo = sueldo;
	}

}
