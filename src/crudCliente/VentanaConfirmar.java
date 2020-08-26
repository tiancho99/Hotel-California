package crudCliente;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.Acciones;

public class VentanaConfirmar extends JPanel {
	private JPanel panelIzquierdo;
	private JLabel lblNumeroHabitacion;
	private JLabel lblAire;
	private JLabel lblTelevision;
	private JLabel lblBarra;
	private JLabel lblJacuzzi;
	private JLabel lblNumeroPersonas;
	
	private JPanel panelDerecho;
	private JLabel numeroHabitacion;
	private JLabel aire;
	private JLabel barra;
	private JLabel television;
	private JLabel jacuzzi;
	private JLabel numeroPersonas;
	
	private JButton btnRegistrar;
	private JButton btnEliminarCliente;
	private JButton btnModificarCliente;
	private JButton btnVerCliente;
	private JButton btnSalir;
	
	public VentanaConfirmar() {
		setLayout(new BorderLayout());
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		panelIzquierdo = new JPanel();
		lblNumeroHabitacion = new JLabel("numero habitacion");
		lblAire = new JLabel("aire acondicionado");
		lblBarra = new JLabel("barra de productos");
		lblTelevision = new JLabel("television por cable");
		lblJacuzzi = new JLabel("jacuzzi");
		lblNumeroPersonas = new JLabel("numero de huespedes");
		
		panelDerecho = new JPanel();
		numeroHabitacion = new JLabel("");
		aire = new JLabel("");
		barra = new JLabel("");
		television = new JLabel("");
		jacuzzi = new JLabel("");
		numeroPersonas = new JLabel("");
		
		btnRegistrar = new JButton("Crear Reserva");
		btnRegistrar.setActionCommand(Acciones.REGISTRAR_CLIENTE);
		btnModificarCliente = new JButton("editar reserva");
		btnModificarCliente.setActionCommand(Acciones.MODIFICAR_CLIENTE);
		btnEliminarCliente = new JButton("eliminar cliente");
		btnEliminarCliente.setActionCommand(Acciones.ELIMINAR_CLIENTE);
		btnVerCliente = new JButton("ver cliente");
		btnVerCliente.setActionCommand(Acciones.VER_CLIENTE);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CONFIRMAR_CLIENTE);
		

	}

	private void caracteristicas() {
		panelIzquierdo.setLayout(new GridLayout(8,2,30,20));
		panelDerecho.setLayout(new GridLayout(8,2,30,20));
		
	}


	private void agregar() {
		add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.add(lblNumeroHabitacion);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(lblNumeroPersonas);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(lblBarra);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(lblAire);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(lblTelevision);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(lblJacuzzi);
		panelIzquierdo.add(new JLabel(""));
		panelIzquierdo.add(btnRegistrar);
		panelIzquierdo.add(btnModificarCliente);
		
		
		add(btnSalir, BorderLayout.SOUTH);
		add(panelDerecho, BorderLayout.EAST);
		panelDerecho.add(numeroHabitacion);
		panelDerecho.add(new JLabel(""));
		panelDerecho.add(numeroPersonas);
		panelDerecho.add(new JLabel(""));
		panelDerecho.add(barra);
		panelDerecho.add(new JLabel(""));
		panelDerecho.add(aire);
		panelDerecho.add(new JLabel(""));
		panelDerecho.add(television);		
		panelDerecho.add(new JLabel(""));
		panelDerecho.add(jacuzzi);

	}

	public JPanel getPanelIzquierdo() {
		return panelIzquierdo;
	}

	public JLabel getLblTelevision() {
		return lblTelevision;
	}

	public JPanel getPanelDerecho() {
		return panelDerecho;
	}

	public JLabel getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public JLabel getAire() {
		return aire;
	}

	public JLabel getBarra() {
		return barra;
	}

	public JLabel getTelevision() {
		return television;
	}

	public JLabel getJacuzzi() {
		return jacuzzi;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarCliente;
	}

	public JButton getBtnModificarCliente() {
		return btnModificarCliente;
	}

	public JButton getBtnVerCliente() {
		return btnVerCliente;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JLabel getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setPanelIzquierdo(JPanel panelIzquierdo) {
		this.panelIzquierdo = panelIzquierdo;
	}

	public void setPanelDerecho(JPanel panelDerecho) {
		this.panelDerecho = panelDerecho;
	}

	public void setNumeroHabitacion(JLabel numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public void setAire(JLabel aire) {
		this.aire = aire;
	}

	public void setBarra(JLabel barra) {
		this.barra = barra;
	}

	public void setTelevision(JLabel television) {
		this.television = television;
	}

	public void setJacuzzi(JLabel jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public void setNumeroPersonas(JLabel numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	

}
