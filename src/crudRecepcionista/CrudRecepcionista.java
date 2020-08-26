package crudRecepcionista;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Control;
import logica.Recepcionista;

public class CrudRecepcionista extends JPanel implements Comparable<Recepcionista> {
	MenuRecepcionista menu;
	CrearRecepcionista crearRecepcionista;
	ModificarRecepcionista modificarRecepcionista;
	EliminarRcecpcionista eliminarRecepcionista;
	VerRecepcionista verRecepcionista;

	public CrudRecepcionista() {
	
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		menu = new MenuRecepcionista();
		crearRecepcionista = new CrearRecepcionista();
		modificarRecepcionista = new ModificarRecepcionista();
		eliminarRecepcionista = new EliminarRcecpcionista();
		verRecepcionista = new VerRecepcionista();
	}

	private void caracteristicas() {
		menu.setBounds(20,20,320,300);
		crearRecepcionista.setBounds(20, 310, 620, 310);
		modificarRecepcionista.setBounds(20, 0, 620, 310);
		eliminarRecepcionista.setBounds(20, 20, 660, 360);
		verRecepcionista.setBounds(20, 20, 660, 360);
		
	}

	private void agregar() {
		add(crearRecepcionista); 
		add(modificarRecepcionista);
	}

	public void asignarControl(Control control) {

		menu.getBtnCrear().addActionListener(control);
		menu.getBtnModificar().addActionListener(control);
		menu.getBtnEliminar().addActionListener(control);
		menu.getBtnVer().addActionListener(control);
		
		crearRecepcionista.getBtnCrear().addActionListener(control);
		crearRecepcionista.getBtnSalir().addActionListener(control);
		crearRecepcionista.getBtnModificar().addActionListener(control);
		crearRecepcionista.getBtnEliminar().addActionListener(control);
		
		
		
		
	}
	
	public void iniciar(String seccion) {
		if (seccion.equals("crearRecepcionista")) {
			crearRecepcionista.setVisible(true);
			add(crearRecepcionista);
			

		}
		if (seccion.equals("modificarRecepcionista")) {
			modificarRecepcionista.setVisible(true);
			add(modificarRecepcionista);
			
		}
		if (seccion.equals("eliminarRecepcionista")) {
			eliminarRecepcionista.setVisible(true);
			add(eliminarRecepcionista);
		}
		if (seccion.equals("verRecepcionista")) {
			verRecepcionista.setVisible(true);
			add(verRecepcionista);
		}
		if (seccion.equals("menuRecepcionista")) {
			menu.setVisible(true);
			add(menu);
		}
	}

	public void salir(String seccion) {
		if(seccion.equals("menuRecepcionista")) {
			menu.setVisible(false);
			remove(menu);
		}
		if(seccion.equals("salirCrearRecepcionista")) {
			
			crearRecepcionista.setVisible(false);
			remove(crearRecepcionista);
		}
		if(seccion.equals("salirModificarRecepcionista")) {
			modificarRecepcionista.setVisible(false);
			remove(modificarRecepcionista);
		}
		if(seccion.equals("salirEliminarRecepcionista")) {
			eliminarRecepcionista.setVisible(false);
			remove(eliminarRecepcionista);
		}
		if(seccion.equals("salirVerRecepcionista")) {
			verRecepcionista.setVisible(false);
			remove(verRecepcionista);
		}
		
	}
	

	public void escribir(String[][] datos, String seccion) {
		modificarRecepcionista.getModeloTabla().setRowCount(0);
		for (int i = 0; i < datos.length; i++) {
			modificarRecepcionista.getModeloTabla().addRow(datos[i]);
			
		}
		
		
	}
	
	public String[] leer(String seccion) {
		String[] datos = null;
		// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  direccion
		if (seccion.equals("agregarRecepcionista")) {
			datos = new String[8];
			datos[0] = crearRecepcionista.getTxtCedula().getText();
			datos[1] = crearRecepcionista.getTxtNombre().getText();
			datos[2] = crearRecepcionista.getTxtApellido().getText();
			datos[3] = crearRecepcionista.getTxtCiudad().getText();
//			datos[4] = String.valueOf(crearRecepcionista.getFecha().);
			datos[5] = crearRecepcionista.getTxtNumeroCelular().getText();
			datos[6] = crearRecepcionista.getTxtContraseña().getText();
			datos[7] = crearRecepcionista.getTxtDireccion().getText();
			try {
			SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
			Date date = crearRecepcionista.getFecha().getDate();
			String fechas = formato.format(date);
			datos[4] = fechas;
			}catch (NullPointerException e) {
				
			}
		}
		if (seccion.equals("borrarRecepcionista")) {
			datos = new String[1];
			datos[0] = String.valueOf(modificarRecepcionista.getJtbTablaRecepcionista().getSelectedRow());
		}
		if (seccion.equals("editarRecepcionista")) {
			datos = new String[9];
			datos[0] = String.valueOf(modificarRecepcionista.getJtbTablaRecepcionista().getSelectedRow());
			datos[1] = crearRecepcionista.getTxtCedula().getText();
			datos[2] = crearRecepcionista.getTxtNombre().getText();
			datos[3] = crearRecepcionista.getTxtApellido().getText();
			datos[4] = crearRecepcionista.getTxtCiudad().getText();
//			datos[5] = String.valueOf(crearRecepcionista.getFecha().);
			datos[6] = crearRecepcionista.getTxtNumeroCelular().getText();
			datos[7] = crearRecepcionista.getTxtContraseña().getText();
			datos[8] = crearRecepcionista.getTxtDireccion().getText();
			try {
			SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
			Date date = crearRecepcionista.getFecha().getDate();
			String fechas = formato.format(date);
			datos[5] = fechas;
			}catch (NullPointerException e) {
				
			}
		}
		return datos;
	}


	public void borrar(String seccion) {
		crearRecepcionista.getTxtCedula().setText("");;
		crearRecepcionista.getTxtNombre().setText("");
		crearRecepcionista.getTxtApellido().setText("");
		crearRecepcionista.getTxtCiudad().setText("");
		crearRecepcionista.getFecha().setCalendar(null);;
		crearRecepcionista.getTxtNumeroCelular().setText("");
		crearRecepcionista.getTxtContraseña().setText("");
		crearRecepcionista.getTxtDireccion().setText("");

	}

	@Override
	public int compareTo(Recepcionista o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
