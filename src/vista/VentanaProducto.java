package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaProducto extends JPanel {
	
		private JLabel lblNombre;
		private JLabel lblPrecio;
		private JTextField txtCompra;
		private JButton btnMas;
		private JButton btnMenos;
		private JLabel lblespacio;
	
		public VentanaProducto() {
			
			
			inicializar();
			caracteristicas();
			agregar();
		
		}

		private void inicializar() {

			lblNombre = new JLabel("galleta");
			lblNombre.setSize(200,25);
			lblPrecio = new JLabel("2000");
			txtCompra = new JTextField("1");
			lblespacio = new JLabel("");
			btnMas = new JButton("+");
			btnMenos = new JButton("-");
			
		}

		private void caracteristicas() {
			lblNombre.setBounds(0, 0, 50,25);
			lblPrecio.setBounds(60, 0, 50,25);
			txtCompra.setBounds(0, 40, 10, 25);
			btnMenos.setBounds(0, 65, 10, 10);
			btnMenos.setBounds(10, 65, 10, 10);
		}

		private void agregar() {
			add(lblNombre);
			add(lblPrecio);
			add(txtCompra);
			add(lblespacio);
			add(btnMenos);
			add(btnMas);
		}

		public JLabel getLblNombre() {
			return lblNombre;
		}

		public JLabel getLblPrecio() {
			return lblPrecio;
		}

		public JTextField getLblCompra() {
			return txtCompra;
		}

		public JButton getBtnMas() {
			return btnMas;
		}

		public JButton getBtnMenos() {
			return btnMenos;
		}
		
		
}
