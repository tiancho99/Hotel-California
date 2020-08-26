package crudProducto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import control.Control;

public class CrudProducto extends JPanel {

	private MenuProducto menu;
	private JPanel panelizquierdo;
	private JPanel panelDerecho;
	private CrearProducto crearProducto;
	private ModificarProducto modificarProducto;
	private EliminarProducto eliminarProducto;
	private VerProducto verProducto;
	
	public CrudProducto() {
	
	setLayout(null);
	inicializar();
	caracteristicas();
	agregar();
	}

	private void inicializar() {
		menu = new MenuProducto();
		panelizquierdo = new JPanel();
		panelDerecho = new JPanel();
		crearProducto = new CrearProducto();
		modificarProducto = new ModificarProducto();
		eliminarProducto = new EliminarProducto();
		verProducto = new VerProducto();
	}

	private void caracteristicas() {
		panelizquierdo.setBounds(20,20,200,200);
		menu.setBounds(20,20,320,300);
		crearProducto.setBounds(20, 310, 620, 310);
		modificarProducto.setBounds(20, 0, 620, 310);
		eliminarProducto.setBounds(20, 20, 660, 360);
		verProducto.setBounds(20, 20, 660, 360);
		
	}

	private void agregar() {
		add(crearProducto);
		add(modificarProducto);
	}

	public void asignarControl(Control control) {
		menu.getBtnCrear().addActionListener(control);
		menu.getBtnModificar().addActionListener(control);
		menu.getBtnEliminar().addActionListener(control);
		menu.getBtnVer().addActionListener(control);
		
		crearProducto.getBtnCrear().addActionListener(control);
		crearProducto.getBtnSalir().addActionListener(control);
		crearProducto.getBtnModificar().addActionListener(control);
		crearProducto.getBtnEliminar().addActionListener(control);
			
		modificarProducto.getBtnEditar().addActionListener(control);
		modificarProducto.getBtnSalir().addActionListener(control);
		
		eliminarProducto.getBtnEliminar().addActionListener(control);
		eliminarProducto.getBtnSalir().addActionListener(control);

		verProducto.getBtnAtras().addActionListener(control);
		verProducto.getBtnSalir().addActionListener(control);
		
		
	}

	public void iniciar(String seccion) {
		
		if (seccion.equals("crearProducto")) {
			modificarProducto.getModeloTabla().setRowCount(0);
			modificarProducto.setVisible(true);
			crearProducto.setVisible(true);
			add(modificarProducto);
			add(crearProducto);
		}
		if (seccion.equals("modificarProducto")) {


		}
		if (seccion.equals("eliminarProducto")) {
			eliminarProducto.getModeloLista().clear();
			eliminarProducto.setVisible(true);
			add(eliminarProducto);
		}
		if (seccion.equals("verProducto")) {
			modificarProducto.getModeloTabla().setRowCount(0);
			verProducto.setVisible(true);
			add(verProducto);

		}
		if (seccion.equals("menuProducto")) {
			menu.setVisible(true);
			add(menu);
		}

	} 

	public void salir(String seccion) {
		
		if (seccion.equals("menuProducto")) {
			menu.setVisible(false);
			remove(menu);
		}
		if(seccion.equals("salirCrearProducto")) {
			crearProducto.setVisible(false);
			remove(crearProducto);
		}
		if(seccion.equals("salirModificarProducto")) {
			modificarProducto.setVisible(false);
			remove(modificarProducto);
		}
		if(seccion.equals("salirEliminarProducto")) {
			eliminarProducto.setVisible(false);
			remove(eliminarProducto);
		}
		if(seccion.equals("salirVerProducto")) {
			verProducto.setVisible(false);
			remove(verProducto);
		}
	}

	public void escribir(String[][] datos, String seccion) {			

		
		if (seccion.equals("modificarProducto")) {
			modificarProducto.getModeloTabla().setRowCount(0);
			for (int i = 0; i < datos.length; i++) {
				modificarProducto.getModeloTabla().addRow(datos[i]);

			}
		}
		if (seccion.equals("eliminarProducto")){
			eliminarProducto.getModeloLista().clear();
			for (int i = 0; i < datos.length; i++) {
				eliminarProducto.getModeloLista().addElement(datos[i][0]);
			}

		}
		if (seccion.equals("verProducto")) {
			for (int i = 0; i < datos.length; i++) {
				verProducto.getModeloTabla().addRow(datos[i]);
			}
		}

	}

	public String[] leer(String seccion) {
		String[] datos = null;
		if (seccion.equals("agregarProducto")) {
			//			String nombre, String stock, double precio, int codigo
			datos = new String[4];
			datos[0] = crearProducto.getTxtNombreProducto().getText();
			datos[1] = crearProducto.getTxtStockProdcto().getText();
			datos[2] = crearProducto.getTxtPrecioProducto().getText();
			datos[3] = crearProducto.getTxtCodigoProducto().getText();
			
		}
		if (seccion.equals("editarProducto")) {
			datos = new String[5];
			datos[0] = String.valueOf(modificarProducto.getJtbTablaProducto().getSelectedRow());
			datos[1] = crearProducto.getTxtNombreProducto().getText();
			datos[2] = crearProducto.getTxtStockProdcto().getText();
			datos[3] = crearProducto.getTxtPrecioProducto().getText();
			datos[4] = crearProducto.getTxtCodigoProducto().getText();
			
		}
		if (seccion.equals("borrarProducto")) {
			datos = new String[1];
			datos[0] = String.valueOf(modificarProducto.getJtbTablaProducto().getSelectedRow());
		}
		return datos;
	}
	
	public void borrar(String seccion) {
		if (seccion.equals("agregarProducto")) {
			crearProducto.getTxtNombreProducto().setText("");
			crearProducto.getTxtStockProdcto().setText("");
			crearProducto.getTxtPrecioProducto().setText("");
			crearProducto.getTxtCodigoProducto().setText("");
		}		
	}

	

	public MenuProducto getMenu() {
		return menu;
	}

	public CrearProducto getCrearProducto() {
		return crearProducto;
	}

	public ModificarProducto getModificarProducto() {
		return modificarProducto;
	}

	public EliminarProducto getEliminarProducto() {
		return eliminarProducto;
	}

	public VerProducto getVerProducto() {
		return verProducto;
	}

	


	

	
	
	
}
