package clases.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona {
	
	private String codigoDeEmpleado;
	private int numeroDeHorasExtras;
	private String fechaDeIngreso;
	private String area;
	private String cargo;
	
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos= "Codigo De Empleado: " + codigoDeEmpleado + "\n";
		datos+="Numero De Horas Extra: " + numeroDeHorasExtras + "\n";
		datos+="Fecha De Ingreso: " + fechaDeIngreso + "\n";
		datos+="Area: " + area + "\n";
		datos+="Cargo: " +cargo + "\n";
		
		System.out.println(datos);
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		codigoDeEmpleado=JOptionPane.showInputDialog("Ingrese el codigo del empleado");
		numeroDeHorasExtras= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extra"));
		fechaDeIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aaaa)");
		area=JOptionPane.showInputDialog("Ingrese el area");
		cargo=JOptionPane.showInputDialog("Ingrese el cargo");
	}
	
	
	public String getCodigoDeEmpleado() {
		return codigoDeEmpleado;
	}
	public void setCodigoDeEmpleado(String codigoDeEmpleado) {
		this.codigoDeEmpleado = codigoDeEmpleado;
	}
	public int getNumeroDeHorasExtras() {
		return numeroDeHorasExtras;
	}
	public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
		this.numeroDeHorasExtras = numeroDeHorasExtras;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
