package vista;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import control.Control;
import crudHabitacion.CrudHabitacion;
import crudProducto.CrudProducto;
import crudRecepcionista.CrudRecepcionista;



public class VentanaAdmin extends JPanel {
	private JTabbedPane jtpPestañasAdmin;
	private VentanaPerfil perfilAdmin;
	private CrudProducto crudProducto;
	private CrudRecepcionista crudRecepcionista;
	private CrudHabitacion crudHabitacion;
	private MenuCrudsAdmin menuCrudsAdmin;
	private VerHistorial verHistorial;
	public VentanaAdmin() {
		
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		jtpPestañasAdmin = new JTabbedPane();
		perfilAdmin = new VentanaPerfil();
		crudProducto = new CrudProducto();
		crudRecepcionista = new CrudRecepcionista();
		crudHabitacion = new CrudHabitacion();
		menuCrudsAdmin = new MenuCrudsAdmin();
		verHistorial = new VerHistorial();
	}

	private void caracteristicas() {
		jtpPestañasAdmin.setBounds(20, 0, 660, 360);
		jtpPestañasAdmin.add("perfil", perfilAdmin);
		jtpPestañasAdmin.add("cruds", menuCrudsAdmin);	
	}

	private void agregar() {
		add(jtpPestañasAdmin);

	}
	
	public void asignarControl(Control control) {
		
		perfilAdmin.getBtnCerrarCesion().addActionListener(control);
		crudProducto.asignarControl(control);
		crudRecepcionista.asignarControl(control);
		crudHabitacion.agregarControl(control);
		menuCrudsAdmin.getBtnCrudHabitacion().addActionListener(control);
		menuCrudsAdmin.getBtnCrudProducto().addActionListener(control);
		menuCrudsAdmin.getBtnCrudRecepcionista().addActionListener(control);
		menuCrudsAdmin.getBtnHistorial().addActionListener(control);
		verHistorial.getBtnSalir().addActionListener(control);
	}

	public void iniciar(String seccion) {
		if(seccion.equals("crearProducto")) {
			jtpPestañasAdmin.setBounds(20, 0, 660, 660);
			jtpPestañasAdmin.setComponentAt(1, crudProducto);
		}
		if (seccion.equals("crearRecepcionista")) {
			jtpPestañasAdmin.setBounds(20, 0, 660, 660);
			jtpPestañasAdmin.setComponentAt(1, crudRecepcionista);
		}
		if (seccion.equals("crearHabitacion")) {
			jtpPestañasAdmin.setBounds(20, 0, 660, 660);
			jtpPestañasAdmin.setComponentAt(1, crudHabitacion);
		}
		if (seccion.equals("menuProducto")) {
			jtpPestañasAdmin.setBounds(20, 0, 660, 360);
			jtpPestañasAdmin.setComponentAt(1, menuCrudsAdmin);
		}
		if (seccion.equals("verHistorial")) {
			jtpPestañasAdmin.setComponentAt(1, verHistorial);
		}
	}

	public void salir(String seccion) {
		if (seccion.equals("menuProducto")) {
			jtpPestañasAdmin.setComponentAt(1, null);;
			menuCrudsAdmin.setVisible(false);
			remove(menuCrudsAdmin); 
		}
		if(seccion.equals("salirCrearProducto")) {
			jtpPestañasAdmin.setComponentAt(1, null);
		}
		if (seccion.equals("salirVerHistorial")) {
			
		}
		
	} 
 
	public void dibujar(String[] datos, String seccion) {

		perfilAdmin.getNombre().setText(datos[0]);
		perfilAdmin.getApellido().setText(datos[1]);
	}

	public void escribir(String[][] datos, String seccion) {

		if (seccion.equals("modificarProducto") || seccion.equals("eliminarProducto") || seccion.equals("verProducto")) {
			crudProducto.escribir(datos, seccion);
			
		}
		if (seccion.equals("modificarHabitacion")) {
			crudHabitacion.escribir(datos, seccion);
		}
		if (seccion.equals("modificarRecepcionista")) {
			crudRecepcionista.escribir(datos, seccion);
		}
		if (seccion.equals("verHistorial")) {
			
			verHistorial.getModeloTabla().setRowCount(0);
			for (int i = 0; i < datos.length; i++) {
				verHistorial.getModeloTabla().addRow(datos[i]);
				
			}
		}
	}
	public String[] leer(String seccion) {
		String[] datos = null;
		if (seccion.equals("agregarProducto") || seccion.equals("editarProducto") || seccion.equals("borrarProducto")) {
			datos = crudProducto.leer(seccion);
		}
		if (seccion.equals("agregarHabitacion") || seccion.equals("borrarHabitacion") || seccion.equals("editarHabitacion")) {
			datos = crudHabitacion.leer(seccion);
		}
		if (seccion.equals("agregarRecepcionista") || seccion.equals("borrarRecepcionista") || seccion.equals("editarRecepcionista")) {
			datos = crudRecepcionista.leer(seccion);
		}
		return datos;
		// TODO Auto-generated method stub
		
	}

	public void borrar(String seccion) {

		if (seccion.equals("agregarProducto")) {
			crudProducto.borrar(seccion);
		}
		if (seccion.equals("agregarHabitacion")) {
			crudHabitacion.borrar(seccion);
		}
		if (seccion.equals("agregarRecepcionista")) {
			crudRecepcionista.borrar(seccion);
		}
	}

	

	
}
