import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {
	ModeloDatos miModeloDatos;

	public Procesos() {
		miModeloDatos = new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {

		String menu = "MENU HOSPITAL\n\n";
		menu += "1. Registrar Paciente\n";
		menu += "2. Registrar Empleado\n";
		menu += "3. Registrar Cita Medica\n";
		menu += "4. Imprimir Informacion\n";
		menu += "5. Buscar Personas\n";
		menu += "6. Salir\n\n";
		menu += "Ingrese una opcion\n";

		int opcion = 0;
		try {

			do {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				switch (opcion) {
				case 1:
					registrarPaciente();
					break;
				case 2:
					registrarEmpleado();
					break;
				case 3:
					registrarCitaMedica();
					break;
				case 4:
					imprimirInformacion();
					break;
				case 5:
					buscarPersonas();
					break;
				case 6:
					System.out.println("El sistema ha terminado");
				default:
					System.out.println("No existe el codigo, verifique nuevamente");
					break;
				}

			} while (opcion != 6);
		} catch (Exception e) {
			System.out.println("Ingresaste algo incorrecto");
		}

	}

	private void buscarPersonas() {
		String menuImprimir = "BUSCAR PERSONAS\n";
		menuImprimir += "1. Buscar Pacientes\n";
		menuImprimir += "2. Buscar Empleados Eventuales\n";
		menuImprimir += "3. Buscar Empleados Por Planilla\n";
		menuImprimir += "4. Buscar Medicos\n";
		menuImprimir += " Ingrese una opcion\n";

		System.out.println("***************************************");

		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		try {
			switch (opcion) {
			case 1:
				miModeloDatos.buscarPaciente();
				break;

			default:
				System.out.println("No existe la opcion");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ingresaste algo incorrecto");
		}
		
	}



	private void registrarPaciente() {
		Paciente miPaciente = new Paciente();
		miPaciente.registrarDatos();

		miModeloDatos.registrarPersona(miPaciente);
	}

	private void imprimirInformacion() {

		String menuImprimir = "MENU IMPRESIONES\n";
		menuImprimir += "1. Listar Pacientes\n";
		menuImprimir += "2. Listar Empleados Eventuales\n";
		menuImprimir += "3. Listar Empleados Por Planilla\n";
		menuImprimir += "4. Listar Medicos\n";
		menuImprimir += "5. Listar Citas Programadas\n";
		menuImprimir += " Ingrese una opcion\n";

		System.out.println("***************************************");

		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		try {
			switch (opcion) {
			case 1:
				if (validarPaciente(miModeloDatos.pacientesMap)) {
					miModeloDatos.imprimirPacientes();
				}
				break;
			case 2:
				if (validarEmpleadosEventual(miModeloDatos.empleadosEventualMap)) {
					miModeloDatos.imprimirEmpleadosEventuales();
				}
				break;
			case 3:
				if (validarEmpleadosPlanilla(miModeloDatos.empleadosPlanillaMap)) {
					miModeloDatos.imprimirEmpleadosPorPlanilla();
				}
				break;
			case 4:
				if (validarMedico(miModeloDatos.medicosMap)) {
					miModeloDatos.imprimirMedicos();
				}
				break;
			case 5:
				if (validarCitas(miModeloDatos.citasList)) {
					miModeloDatos.imprimirCitasMedicasProgramadas();
				}
				break;

			default:
				System.out.println("No existe la opcion");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ingresaste algo incorrecto");
		}
	}

	public boolean validarPaciente(HashMap<String, Paciente> pacientes) {
		if (!pacientes.isEmpty()) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
		return false;
	}

	public boolean validarEmpleadosPlanilla(HashMap<String, EmpleadoPlanilla> empleadoPlanilla) {
		if (!empleadoPlanilla.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
	}

	public boolean validarEmpleadosEventual(HashMap<String, EmpleadoEventual> empleadoEventual) {
		if (!empleadoEventual.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
	}

	public boolean validarMedico(HashMap<String, Medico> medico) {
		if (!medico.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
	}

	public boolean validarCitas(ArrayList<CitaMedica> cita) {
		if (!cita.isEmpty()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
	}

	private void registrarEmpleado() {
		String menuTipoEmpleado = "Registro de Empleado\n";
		menuTipoEmpleado += "1. Empleado eventual\n";
		menuTipoEmpleado += "2. Empleado por Planilla\n";
		menuTipoEmpleado += "Seleccione el tipo de empleado a registrar\n";

		int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		try {

			switch (tipoEmpleado) {
			case 1:
				EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
				miEmpleadoEventual.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoEventual);
				break;
			case 2:
				String resp = JOptionPane
						.showInputDialog("Ingrese si, si es un medico, de lo contrario es otro tipo de empleado");
				if (resp.equalsIgnoreCase("si")) {
					Medico miMedico = new Medico();
					miMedico.registrarDatos();
					miModeloDatos.registrarPersona(miMedico);
				} else {
					EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
					miEmpleadoPlanilla.registrarDatos();
					miModeloDatos.registrarPersona(miEmpleadoPlanilla);
				}

				break;

			default:
				System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ingresaste algo incorrecto");
		}
	}

	private void registrarCitaMedica() {
		String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");

		Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

		if (pacienteEncontrado != null) {
			String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico medicoEncotrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

			if (medicoEncotrado != null) {
				String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
				String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");

				String lugar = "La cita sera en el consultorio " + medicoEncotrado.getNumeroDeConsultorio();
				CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncotrado, servicio, fechaConsulta,
						horaConsulta, lugar);
				miModeloDatos.registrarCitaMedica(miCita);
			} else {
				System.out.println("El medico no se encuentra registrado en el sistema");
			}

		} else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}

	}

}