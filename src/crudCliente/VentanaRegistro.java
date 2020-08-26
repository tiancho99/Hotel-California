package crudCliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import vista.Acciones;



public class VentanaRegistro extends JPanel {
	
	private JLabel espacio;
	private JLabel nombre;
	private JTextField txtNombre;
	private JLabel apellido;
	private JTextField txtApellido;
	private JLabel cedula;
	private JTextField txtCedula;
	private JLabel ciudad;
	private JTextField txtCiudad;
	private JLabel fechaNacimiento;
	private JDateChooser jdcFechaNacimiento;
	private JLabel contraseña;
	private JPasswordField txtContraseña;
	private JLabel anotaciones;
	private JTextField txtCelular;
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	public VentanaRegistro() {
	
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		espacio = new JLabel("");
		nombre = new JLabel("NOMBRE");
		txtNombre = new JTextField();
		apellido = new JLabel("APELLIDO"); 
		txtApellido = new JTextField();
		cedula = new JLabel("CEDULA");
		txtCedula = new JTextField();
		ciudad = new JLabel("CIUDAD");
		txtCiudad = new JTextField();
		fechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		jdcFechaNacimiento = new JDateChooser();
		contraseña = new JLabel("CONTRASEÑA");
		txtContraseña = new JPasswordField();
		anotaciones = new JLabel("CELULAR");
		txtCelular = new JTextField();
		btnAgregar = new JButton("agregar");
		btnAgregar.setActionCommand(Acciones.REGISTRAR);
		btnCancelar = new JButton("salir");
		btnCancelar.setActionCommand(Acciones.CANCELAR_REGISTRO);
		
	}

	private void caracteristicas() {
		nombre.setBounds(40,50,80, 25);
		apellido.setBounds(40, 100, 80, 25);
		cedula.setBounds(40,150,80, 25);
		ciudad.setBounds(40, 200, 80,25);
		fechaNacimiento.setBounds(340, 150, 200, 25);
		contraseña.setBounds(340, 100, 80, 25);
		txtNombre.setBounds(120,50,200, 25);
		txtApellido.setBounds(120, 100, 200, 25);
		txtCedula.setBounds(120,150,200,25);
		txtCiudad.setBounds(120,200,200,25);
		jdcFechaNacimiento.setBounds(340, 175, 200,25);
		txtContraseña.setBounds(450,100,200, 25);
		anotaciones.setBounds(340,50, 80, 25);
		txtCelular.setBounds(450,50,200, 25);
		btnAgregar.setBounds(250, 300, 100, 25);
		btnCancelar.setBounds(350, 300, 100, 25);
		
	}

	private void agregar() {
		add(nombre);
		add(txtNombre);
		add(apellido);
		add(txtApellido);
		add(cedula);
		add(txtCedula);
		add(ciudad);
		add(txtCiudad);
		add(fechaNacimiento);
		add(jdcFechaNacimiento);
		add(contraseña);
		add(txtContraseña);
		add(anotaciones);
		add(txtCelular);
		add(anotaciones);
		add(btnAgregar);
		add(btnCancelar);
	
	}
	
	

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JTextField getTxtNombre() {
		return txtNombre; 
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public JTextField getTxtCiudad() {
		return txtCiudad;
	}

	public JPasswordField getTxtContraseña() {
		return txtContraseña;
	}

	public JTextField getTxtCelular() {
		return txtCelular;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JDateChooser getJdcFechaNacimiento() {
		return jdcFechaNacimiento;
	}
	

}
