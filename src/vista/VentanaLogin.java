package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.Control;

public class VentanaLogin extends JPanel {
	private JLabel titulo;
	private JLabel usuario;
	private JTextField txtUsuario;
	private JLabel contrase�a;
	private JPasswordField txtContrase�a;
	private JButton btnLogIn;
	private JCheckBox recordarContrase�a;
	
	
	public VentanaLogin() {
		
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
	}
	
	private void inicializar() {
		titulo = new JLabel("INICIAR SECION");
		usuario = new JLabel("USUARIO:");
		txtUsuario = new JTextField();
		contrase�a = new JLabel("CONTRASE�A:");
		txtContrase�a = new JPasswordField();
		btnLogIn = new JButton("log in");
		btnLogIn.setActionCommand(Acciones.INICIAR_SECION);
		recordarContrase�a = new JCheckBox("Recordar contrase�a");
	}
	
	private void caracteristicas() {
		titulo.setBounds(190, 20, 150, 25);
		usuario.setBounds(100, 50, 100, 25);
		txtUsuario.setBounds(250, 50, 150, 25);
		contrase�a.setBounds(100, 120, 100, 25);
		txtContrase�a.setBounds(250, 120, 150, 25);
		recordarContrase�a.setBounds(170, 165, 150, 20);
		btnLogIn.setBounds(170, 200, 100, 25);
	}
	
	private void agregar() {
		add(titulo);
		add(usuario);
		add(txtUsuario);
		add(contrase�a);
		add(txtContrase�a);
		add(recordarContrase�a);
		add(btnLogIn);
		
	}
	public void asignarControl(Control control) {
		
	}
	public void iniciar(String seccion) {
		
	}
	public void salir(String seccion) {
		
	}
	public void escribir(String[][] entradas, String seccion) {
		
	}
	public String[] leer(String seccion) {
		return null;
		
	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JTextField getTxtContrase�a() {
		return txtContrase�a;
	}
	
	

	
	
}
