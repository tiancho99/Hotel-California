package crudCliente;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import control.Control;
import vista.Acciones;

public class CrudPersona extends JPanel{
CrudCliente crudCliente;
VentanaRegistro ventanaRegistro;

public CrudPersona() {
	setLayout(null);
	inicializar();
	caracteristicas();
	agregar();
	
	
}

private void inicializar() {
	crudCliente = new CrudCliente();
	ventanaRegistro = new VentanaRegistro();	
}

private void caracteristicas() {
	crudCliente.setBounds(0, 0, 760,360);
	ventanaRegistro.setBounds(20, 0, 760,360);
}

private void agregar() {


}
public void asignarControl(Control control) {

	ventanaRegistro.getBtnAgregar().addActionListener(control);
	ventanaRegistro.getBtnCancelar().addActionListener(control);
	
	crudCliente.getBtnModificar().addActionListener(control);
	crudCliente.getBtnEliminar().addActionListener(control);
	crudCliente.getBtnSalir().addActionListener(control);

}

public void iniciar(String seccion) {
	if (seccion.equals("confirmar")) {
		crudCliente.setVisible(false);
		remove(crudCliente);
		ventanaRegistro.setBounds(20, 0, 760,360);
		add(ventanaRegistro);
		repaint();

	}
	if (seccion.equals("modificarCliente")) {
		crudCliente.setVisible(true);
		ventanaRegistro.setBounds(40, 360, 660, 310);
		add(ventanaRegistro);
		add(crudCliente);
		repaint();
	}
}

public void salir(String seccion) {

}

public void escribir(String[][] datos, String seccion) {
	if(seccion.equals("modificarCliente")){
		crudCliente.getModeloTabla().setRowCount(0);
		for (int i = 0; i < datos.length; i++) {
			crudCliente.getModeloTabla().addRow(datos[i]);
		}
	}
}

public String[] leer(String seccion) {
	String[] datos = null;
	
	if (seccion.equals("registrarCliente")) {
		datos = new String[11];
//		String documento, String nombre, String apellido, String ciudad, Date nacimiento, String celular,String contraseña
		
		
		datos[0] = ventanaRegistro.getTxtCedula().getText();
		datos[1] = ventanaRegistro.getTxtNombre().getText();
		datos[2] = ventanaRegistro.getTxtApellido().getText();
		datos[3] = ventanaRegistro.getTxtCiudad().getText();
		datos[5] = ventanaRegistro.getTxtCelular().getText();
		datos[6] = ventanaRegistro.getTxtContraseña().getText();
		datos[10] = String.valueOf(crudCliente.getListaClientes().getSelectedRow());
		try {
			SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
			Date date = ventanaRegistro.getJdcFechaNacimiento().getDate();
			String fechas = formato.format(date);
			datos[4] = fechas;
			}catch (NullPointerException e) {
				datos[4] = "";
			}
				
	}
	

	return datos;
}

public void dibujar(String[] datos, String seccion) {

}
public void borrar(String seccion) {
	if (seccion.equals("registrar")) {
		ventanaRegistro.getTxtCedula().setText("");
		ventanaRegistro.getTxtApellido().setText("");
		ventanaRegistro.getTxtCelular().setText("");
		ventanaRegistro.getTxtCiudad().setText("");
		ventanaRegistro.getTxtContraseña().setText("");
		ventanaRegistro.getTxtNombre().setText("");
		ventanaRegistro.getJdcFechaNacimiento().setCalendar(null);
	}
}

}
