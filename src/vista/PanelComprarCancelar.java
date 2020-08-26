package vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelComprarCancelar extends JPanel{

	private JButton btnComprar;
	private JButton btnCancelar;
	
	public PanelComprarCancelar() {

		
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		btnComprar = new JButton("comprar");
		btnCancelar = new JButton("cancelar");		
	}

	private void caracteristicas() {
		
	}

	private void agregar() {

		add(btnComprar);
		add(btnCancelar);		
	}
}
