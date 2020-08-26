package crudProducto;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.Acciones;

public class CrearProducto extends JPanel {
	private JLabel lblNombreProducto;
	private JTextField txtNombreProducto;
	private JLabel lblPrecioProducto;
	private JTextField txtPrecioProducto;
	private JLabel lblStockProducto;
	private JTextField txtStockProdcto;
	private JLabel lblCodigoProducto;
	private JTextField txtCodigoProducto;
	private JButton btnSalir;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	
	public CrearProducto() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
	}
	private void inicializar() {
		
		lblNombreProducto = new JLabel("NOMBRE DEL PRODUCTO");
		txtNombreProducto = new JTextField();
		lblPrecioProducto = new JLabel("PRECIO DEL PRODUCTO");
		txtPrecioProducto = new JTextField();
		lblStockProducto = new JLabel("STOCK");
		txtStockProdcto = new JTextField();
		lblCodigoProducto = new JLabel("CODIGO PRODUCTO");
		txtCodigoProducto = new JTextField();
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CRUD_PRODUCTO);
		btnCrear = new JButton("crear");
		btnCrear.setActionCommand(Acciones.AGREGAR_PRODUCTO);
		btnModificar = new JButton("modificar");
		btnModificar.setActionCommand(Acciones.EDITAR_PRODUCTO);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_PRODUCTO);

		}	
		
	
	private void caracteristicas() {
		
		lblNombreProducto.setBounds(40, 50, 200, 25);
		txtNombreProducto.setBounds(240, 50, 200, 25);
		lblPrecioProducto.setBounds(40, 100, 200, 25);
		txtPrecioProducto.setBounds(240, 100, 200, 25);
		lblStockProducto.setBounds(40, 150, 200, 25);
		txtStockProdcto.setBounds(240, 150, 200, 25);	
		lblCodigoProducto.setBounds(40, 200, 200, 25);
		txtCodigoProducto.setBounds(240, 200, 200, 25);
		btnCrear.setBounds(200, 250, 80, 25);
		btnSalir.setBounds(460, 150, 80, 25);
		btnModificar.setBounds(280, 250, 80, 25);
		btnEliminar.setBounds(360, 250, 80,25);
		}
	

	private void agregar() {
		add(lblNombreProducto);
		add(txtNombreProducto);
		add(lblPrecioProducto);
		add(txtPrecioProducto);
		add(lblStockProducto);
		add(txtStockProdcto);
		add(lblCodigoProducto);
		add(txtCodigoProducto);
		add(btnCrear);
		add(btnModificar);
		add(btnEliminar);
		add(btnSalir);
		
	}
	public JTextField getTxtNombreProducto() {
		return txtNombreProducto;
	}
	public JTextField getTxtPrecioProducto() {
		return txtPrecioProducto;
	}
	public JTextField getTxtStockProdcto() {
		return txtStockProdcto;
	}
	public JTextField getTxtCodigoProducto() {
		return txtCodigoProducto;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JButton getBtnCrear() {
		return btnCrear;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	
	
}
