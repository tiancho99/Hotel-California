package vista;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Control;
import crudCliente.CrudCliente;
import crudCliente.VentanaRegistro;

public class VentanaCompra extends JPanel{
	JLabel lblNombreProducto;
	JLabel precioProducto;
	JTextField txtCantidad;
	JButton btnMoverse;
	JButton btnMenos;
	JButton btnMas;
	JButton btnComprar;
	public VentanaCompra() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
		
	}
	private void inicializar() {

		lblNombreProducto = new JLabel("PRODUCTO");
		txtCantidad = new JTextField("0");
		btnComprar = new JButton("comprar");
		btnMas = new JButton("+");
		btnMenos = new JButton("-");
		btnMoverse = new JButton("=>");
		precioProducto = new JLabel("$$$$$$$");
	}
	private void caracteristicas() {
		lblNombreProducto.setFont(new java.awt.Font("Tahoma", 30, 30));
		lblNombreProducto.setBounds(20, 40, 400, 50);
		precioProducto.setBounds(190, 150, 50, 25);
		txtCantidad.setBounds(190, 200, 50, 25);
		btnComprar.setBounds(130, 230, 170, 25);
		btnComprar.setActionCommand(Acciones.COMPRAR);
		btnMas.setBounds(250, 200, 50, 25);
		btnMas.setActionCommand(Acciones.MAS);
		btnMenos.setBounds(130, 200, 50, 25);
		btnMenos.setActionCommand(Acciones.MENOS);
		btnMoverse.setBounds(350, 200, 70, 30);
		btnMoverse.setActionCommand(Acciones.MOVERSE);
	}
	private void agregar() {
		add(btnComprar);
		add(txtCantidad);
		add(btnMas);
		add(btnMenos);
		add(btnMoverse);
		add(lblNombreProducto);
		add(precioProducto);
		add(btnMoverse);
	}
	public void setLblNombreProducto(JLabel lblNombreProducto) {
		this.lblNombreProducto = lblNombreProducto;
	}
	public JLabel getLblNombreProducto() {
		return lblNombreProducto;
	}
	public JLabel getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(JLabel precioProducto) {
		this.precioProducto = precioProducto;
	}
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}
	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}
	public JButton getBtnMoverse() {
		return btnMoverse;
	}
	public void setBtnMoverse(JButton btnMoverse) {
		this.btnMoverse = btnMoverse;
	}
	public JButton getBtnMenos() {
		return btnMenos;
	}
	public void setBtnMenos(JButton btnMenos) {
		this.btnMenos = btnMenos;
	}
	public JButton getBtnMas() {
		return btnMas;
	}
	public void setBtnMas(JButton btnMas) {
		this.btnMas = btnMas;
	}
	public JButton getBtnComprar() {
		return btnComprar;
	}
	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}
	
	
	
}
