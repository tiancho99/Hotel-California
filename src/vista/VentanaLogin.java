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
	private JLabel contraseña;
	private JPasswordField txtContraseña;
	private JButton btnLogIn;
	private JCheckBox recordarContraseña;
	
	
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
		contraseña = new JLabel("CONTRASEÑA:");
		txtContraseña = new JPasswordField();
		btnLogIn = new JButton("log in");
		btnLogIn.setActionCommand(Acciones.INICIAR_SECION);
		recordarContraseña = new JCheckBox("Recordar contraseña");
	}
	
	private void caracteristicas() {
		titulo.setBounds(190, 20, 150, 25);
		usuario.setBounds(100, 50, 100, 25);
		txtUsuario.setBounds(250, 50, 150, 25);
		contraseña.setBounds(100, 120, 100, 25);
		txtContraseña.setBounds(250, 120, 150, 25);
		recordarContraseña.setBounds(170, 165, 150, 20);
		btnLogIn.setBounds(170, 200, 100, 25);
	}
	
	private void agregar() {
		add(titulo);
		add(usuario);
		add(txtUsuario);
		add(contraseña);
		add(txtContraseña);
		add(recordarContraseña);
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

	public JTextField getTxtContraseña() {
		return txtContraseña;
	}
	
	

	
	
}
