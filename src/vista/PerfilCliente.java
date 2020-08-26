package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfilCliente extends JPanel {
	private JPanel panelIzquierdo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDocumeto;
	private JLabel lblGasto;
	private JPanel panelDerecho;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel documento;
	private JLabel gasto;
	private JButton btnCerrarCesion;
	
	public PerfilCliente() {
		setLayout(new BorderLayout());
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		panelIzquierdo = new JPanel();
		lblNombre = new JLabel("NOMBRE:");
		lblApellido = new JLabel("APELLIDO:");
		lblDocumeto = new JLabel("NUMERO DE IDENTIFICACION");
		lblGasto = new JLabel("GASTO");
		
		panelDerecho = new JPanel();
		nombre = new JLabel("");
		apellido = new JLabel("");
		documento = new JLabel("");
		gasto = new JLabel("");
		
		btnCerrarCesion = new JButton("cerrar secion");
		btnCerrarCesion.setActionCommand(Acciones.CERRAR_CESION);

	}

	private void caracteristicas() {
		panelIzquierdo.setLayout(new GridLayout(6,1,30,20));
		panelDerecho.setLayout(new GridLayout(6,1,30,20));
		
	}


	private void agregar() {
		add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.add(lblNombre);
		panelIzquierdo.add(lblApellido);
		panelIzquierdo.add(lblDocumeto);
		panelIzquierdo.add(lblGasto);
		add(btnCerrarCesion, BorderLayout.SOUTH);
		add(panelDerecho, BorderLayout.EAST);
		panelDerecho.add(nombre);
		panelDerecho.add(apellido);
		panelDerecho.add(documento);
		panelDerecho.add(gasto);
	}

	public JLabel getNombre() {
		return nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public JLabel getDocumento() {
		return documento;
	}

	public JLabel getGasto() {
		return gasto;
	}

	public JButton getBtnCerrarCesion() {
		return btnCerrarCesion;
	}
	
}
