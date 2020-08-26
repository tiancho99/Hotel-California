package vista;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import control.Control;

public class VentanaCliente extends JPanel {
	JTabbedPane jtpPestañasCliente;
	VentanaCompra ventanaCompra;
	PerfilCliente perfilCliente;
	int cont = 0;
	public VentanaCliente() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();

	}

	
	private void inicializar() {
		jtpPestañasCliente = new JTabbedPane();
		ventanaCompra = new VentanaCompra();
		perfilCliente = new PerfilCliente();
	}


	private void caracteristicas() {
		jtpPestañasCliente.setBounds(20, 0, 440, 440);
		jtpPestañasCliente.add("perfil", perfilCliente);
		jtpPestañasCliente.add("tienda", ventanaCompra);

	}

	private void agregar() {
		add(jtpPestañasCliente);

	}

	
	public void asignarControl(Control control) {
		ventanaCompra.getBtnComprar().addActionListener(control);
		ventanaCompra.getBtnMas().addActionListener(control);
		ventanaCompra.getBtnMenos().addActionListener(control);
		ventanaCompra.getBtnMoverse().addActionListener(control);
		
		perfilCliente.getBtnCerrarCesion().addActionListener(control);
	}

	public void iniciar(String seccion) {
		if (seccion.equals("mas")) {
			int num = Integer.parseInt(ventanaCompra.getTxtCantidad().getText());
			ventanaCompra.getTxtCantidad().setText(String.valueOf(num+1));
		}
		if (seccion.equals("menos")) {
			int num = Integer.parseInt(ventanaCompra.getTxtCantidad().getText());
			if(num > 0) {
			ventanaCompra.getTxtCantidad().setText(String.valueOf(num-1));
			}
		}
	
	}

	public void salir(String seccion) {
		
	}
	public void escribir(String[][] datos, String seccion) {
		if(seccion.equals("mostrarProducto")) {
			
			if (cont<datos.length) {
				ventanaCompra.getLblNombreProducto().setText(datos[cont][0]);
				ventanaCompra.getPrecioProducto().setText(datos[cont][2]);
				cont++;
			}else {
				cont=0;
				escribir(datos, seccion);
				
			}
		}
	}

	public String[] leer(String seccion) {
		String[] datos = null;
		if (seccion.equals("secionPersona")) {
			datos = new String[1];
			datos[0] = perfilCliente.getDocumento().getText();
		}
		if (seccion.equals("comprar")) {
			datos = new String[3];
			datos[0] = ventanaCompra.getLblNombreProducto().getText();
			datos[1] = ventanaCompra.getPrecioProducto().getText();
			datos[2] = ventanaCompra.getTxtCantidad().getText();
		}
		return datos;
	}

	public void dibujar(String[] datos, String seccion) {
		if (seccion.equals("secionPersona")) {
			perfilCliente.getNombre().setText(datos[1]);
			perfilCliente.getApellido().setText(datos[2]);
			perfilCliente.getDocumento().setText(datos[0]);
			perfilCliente.getGasto().setText(datos[7]);
		}
	}
	public void borrar(String seccion) {
		
	}

}
