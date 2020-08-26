package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;import java.security.cert.CertPathValidatorResult;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.Acciones;

public class VentanaPerfil extends JPanel {
	private JPanel panelIzquierdo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDocumeto;
	private JPanel panelDerecho;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel documento;
	private JButton btnCerrarCesion;
	
	public VentanaPerfil() {
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
		
		panelDerecho = new JPanel();
		nombre = new JLabel("");
		apellido = new JLabel("");
		documento = new JLabel("");
		
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
		add(btnCerrarCesion, BorderLayout.SOUTH);
		add(panelDerecho, BorderLayout.EAST);
		panelDerecho.add(nombre);
		panelDerecho.add(apellido);
		panelDerecho.add(documento);
	}

	public JLabel getNombre() {
		return nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public JButton getBtnCerrarCesion() {
		return btnCerrarCesion;
	}
public JLabel getDocumento() {
	return documento;
}
	

}
