package crudHabitacion;

import javax.swing.JPanel;

import control.Control;

public class CrudHabitacion extends JPanel{
	
	private MenuHabitacion menu;
	private CrearHabitacion crearHabitacion;
	private RudHabitacion rudHabitacion;
	
	
	public CrudHabitacion() {
	
	setLayout(null);
	inicializar();
	caracteristicas();
	agregar();
	}

	private void inicializar() {
		menu = new MenuHabitacion();
		crearHabitacion = new CrearHabitacion();
		rudHabitacion = new RudHabitacion();
		
	}

	private void caracteristicas() {
		
		menu.setBounds(20,20,320,300);
		crearHabitacion.setBounds(20, 310, 620, 310);
		rudHabitacion.setBounds(20, 0, 620, 310);
		
	}

	private void agregar() {
		add(crearHabitacion);
		add(rudHabitacion);
	}

	public void agregarControl(Control control) {

		menu.getBtnCrear().addActionListener(control);
		menu.getBtnModificar().addActionListener(control);
		menu.getBtnEliminar().addActionListener(control);
		menu.getBtnVer().addActionListener(control);
		
		crearHabitacion.getBtnCrear().addActionListener(control);
		crearHabitacion.getBtnSalir().addActionListener(control);
		crearHabitacion.getBtnModificar().addActionListener(control);
		crearHabitacion.getBtnEliminar().addActionListener(control);
		
	}
	
	public void iniciar(String seccion) {

		if (seccion.equals("crearHabitacion")) {
			crearHabitacion.setVisible(true);
			add(crearHabitacion);
			rudHabitacion.setVisible(true);
			add(rudHabitacion);
			
 
		}		
		if (seccion.equals("modificarHabitacion") || seccion.equals("eliminarHabitacion")
				|| seccion.equals("verHabitacion")) {
			
		}
		if (seccion.equals("menuHabitacion")) {
			menu.setVisible(true);
			add(menu);
		}

	}

	public void salir(String seccion) {

		if (seccion.equals("salirCrearHabitacion")) {
			crearHabitacion.setVisible(false);
			remove(crearHabitacion);
			System.out.println(seccion);

		}
		if (seccion.equals("salirCrudHabitacion")) {
			rudHabitacion.setVisible(false);
			remove(rudHabitacion);
		}
		if (seccion.equals("menuHabitacion")) {
			menu.setVisible(false);
			remove(menu);
		}
	}
	public void escribir(String[][] datos, String seccion) {
		rudHabitacion.getModeloTabla().setRowCount(0);
		for (int i = 0; i < datos.length; i++) {
			rudHabitacion.getModeloTabla().addRow(datos[i]);
		}
	}
	 
	public String[] leer(String seccion) {
		String[] datos = null;
		// numero,  maximoPersonas,  precioPersona,  barra,  aire,  television,  jacuzzi,  disponible
		if (seccion.equals("agregarHabitacion")) {
			datos = new String[7];
			datos[0] = crearHabitacion.getTxtNumero().getText();
			datos[1] = crearHabitacion.getTxtMaximoPersonas().getText();
			datos[2] = crearHabitacion.getTxtPrecioPersona().getText(); 
			datos[3] = String.valueOf(crearHabitacion.getJcbBarra().isSelected());
			datos[4] = String.valueOf(crearHabitacion.getJcbAire().isSelected());
			datos[5] = String.valueOf(crearHabitacion.getJcbTelevision().isSelected());
		    datos[6] = String.valueOf(crearHabitacion.getJcbJacuzzi().isSelected());
		    
		}
		if (seccion.equals("borrarHabitacion")) {
			datos = new String[1];
			datos[0] = String.valueOf(rudHabitacion.getListaClientes().getSelectedRow());
		}
		if (seccion.equals("editarHabitacion")) {
			datos = new String[8];
			datos[0] = String.valueOf(rudHabitacion.getListaClientes().getSelectedRow());
			datos[1] = crearHabitacion.getTxtNumero().getText();
			datos[2] = crearHabitacion.getTxtMaximoPersonas().getText();
			datos[3] = crearHabitacion.getTxtPrecioPersona().getText(); 
			datos[4] = String.valueOf(crearHabitacion.getJcbBarra().isSelected());
			datos[5] = String.valueOf(crearHabitacion.getJcbAire().isSelected());
			datos[6] = String.valueOf(crearHabitacion.getJcbTelevision().isSelected());
		    datos[7] = String.valueOf(crearHabitacion.getJcbJacuzzi().isSelected());
		}
		return datos;
	}
	
	public void borrar(String seccion) {
		crearHabitacion.getTxtNumero().setText("");;
		crearHabitacion.getTxtMaximoPersonas().setText("");
		crearHabitacion.getTxtPrecioPersona().setText(""); 
		crearHabitacion.getJcbBarra().setSelected(false);
		crearHabitacion.getJcbAire().setSelected(false);
		crearHabitacion.getJcbTelevision().setSelected(false);
		crearHabitacion.getJcbJacuzzi().setSelected(false);
	}
	
	
	public MenuHabitacion getMenu() {
		return menu;
	}

	public CrearHabitacion getCrearHabitacion() {
		return crearHabitacion;
	}

	public RudHabitacion getRudHabitacion() {
		return rudHabitacion;
	}

	

	
	
	

	

	

	

	
	

}
