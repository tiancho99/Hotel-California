package crudRecepcionista;

import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import vista.Acciones;

public class CrearRecepcionista extends JPanel {
	
	private JLabel lblEspacio;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblCedula;
	private JTextField txtCedula;
	private JLabel lblFechaNacimiento;
	private JDateChooser fecha;
	private JLabel lblCcontraseña;
	private JPasswordField txtContraseña;
	private JLabel lblNumeroCelular;
	private JTextField txtNumeroCelular;
	private JLabel lblCiudad;
	private JTextField txtCiudad;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnSalir;
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public CrearRecepcionista() {

		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();

	}
//	, ciudad, , , 
	private void inicializar() {
		lblEspacio = new JLabel("");
		lblNombre = new JLabel("NOMBRE");
		txtNombre = new JTextField();
		lblApellido = new JLabel("APELLIDO");
		txtApellido = new JTextField();
		lblCedula = new JLabel("CEDULA");
		txtCedula = new JTextField();
		lblFechaNacimiento = new JLabel("NACIMIENTO");
		fecha = new JDateChooser();
		
		lblCcontraseña = new JLabel("CONTRASEÑA");
		txtContraseña = new JPasswordField();
		lblNumeroCelular = new JLabel("CELULAR");
		txtNumeroCelular = new JTextField();
		lblCiudad = new JLabel("CIUDAD");
		txtCiudad = new JTextField();
		lblDireccion = new JLabel("DIRECCION");
		txtDireccion = new JTextField();
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CREAR_RECEPCIONISTA);
		btnCrear = new JButton("crear");
		btnCrear.setActionCommand(Acciones.AGREGAR_RECEPCIONISTA);
		btnModificar = new JButton("modificar");
		btnModificar.setActionCommand(Acciones.EDITAR_RECEPCIONISTA);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_RECEPCIONISTA);

	}

	private void caracteristicas() {
		lblNombre.setBounds(5, 10, 80, 25);
		lblApellido.setBounds(5, 55, 80, 25);
		lblCedula.setBounds(5, 100, 80, 25);
		lblNumeroCelular.setBounds(5, 145, 80, 25);
		lblFechaNacimiento.setBounds(310, 10, 150, 25);
		lblCiudad.setBounds(310, 55, 100, 25);
		lblCcontraseña.setBounds(5, 190, 100, 25);
		lblDireccion.setBounds(310, 100, 100, 25);
		txtNombre.setBounds(90, 10, 200, 25);
		txtApellido.setBounds(90, 55, 200, 25);
		txtCedula.setBounds(90, 100, 200, 25);
		txtNumeroCelular.setBounds(90, 145, 200,25);
		txtCiudad.setBounds(410, 55, 200, 25);
		txtContraseña.setBounds(90, 190, 200, 25);
		fecha.setBounds(410, 10, 200, 25);
		txtDireccion.setBounds(410, 100, 200, 25);
		btnCrear.setBounds(20, 250, 80, 25);
		btnModificar.setBounds(100, 250, 80, 25);
		btnEliminar.setBounds(180, 250, 80, 25);
		btnSalir.setBounds(510, 150, 80, 25);
	}

	private void agregar() {
		add(lblNombre);
		add(txtNombre);
		add(lblApellido);
		add(txtApellido);
		add(lblCedula);
		add(lblCiudad);
		add(txtCiudad);
		add(txtCedula);
		add(lblNumeroCelular);
		add(txtNumeroCelular);
		add(lblFechaNacimiento);
		add(fecha);
		add(lblCcontraseña);
		add(txtContraseña);
		add(lblDireccion);
		add(txtDireccion);
		add(btnCrear);
		add(btnModificar);
		add(btnEliminar);
		add(btnSalir);

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
	public JDateChooser getFecha() {
		return fecha;
	}
	public JPasswordField getTxtContraseña() {
		return txtContraseña;
	}
	public JTextField getTxtNumeroCelular() {
		return txtNumeroCelular;
	}
	public JTextField getTxtCiudad() {
		return txtCiudad;
	}
	public JButton getBtnCrear() {
		return btnCrear;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JTextField getTxtDireccion() {
		return txtDireccion;
	}
	

}
