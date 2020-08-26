package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "GestionProducto")
public class GestionProducto {
	ArrayList<Producto> productos;

	public GestionProducto() {
		
		productos = new ArrayList<Producto>();
		
	
	}
	
	public void crearProducto(String[] datos) {
		try {
		String nombre = datos[0];
		int stock = Integer.parseInt(datos[1]);
		double precio = Double.parseDouble(datos[2]);
		String codigo = datos[3];
		Producto producto = new Producto(nombre, stock, precio, codigo);
		productos.add(producto);
		JOptionPane.showMessageDialog(null, "proucto creado");
	}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "valor invalido");
	}
	}  
 
	public String[][] mostrarDatos() {
		String[][] datos = new String[productos.size()][4];
//		String nombre, int stock, double precio, String codigo
		for(int i = 0; i < productos.size(); i++) {
			datos[i][0] = productos.get(i).getNombre();
			datos[i][1] = String.valueOf(productos.get(i).getStock());
			datos[i][2] = String.valueOf(productos.get(i).getPrecio());
			datos[i][3] = productos.get(i).getCodigo();
			;
		}
		return datos;
	}

	public void borrarProducto(String[] datos) {
	int posicion = Integer.parseInt(datos[0]);
				productos.remove(posicion);
	}
 
	public void actualizarDatos(String[] datos) {
		try {
		int posicion = Integer.parseInt(datos[0]);
		String nombre = datos[1];
		String codigo = datos[4]; 
		int stock = 0;
		double precio  = 0;
		if (datos[2].equals("")) {

		}else {
			
			 stock = Integer.parseInt(datos[2]);
		}
		if (datos[3].equals("")) {
			
		}else {
			precio = Double.parseDouble(datos[3]);
		}
		
		


			if (nombre.equals("")) {
				
			}else {
				
				productos.get(posicion).setNombre(nombre);
			}
			if (stock==0) {
			}else {
				productos.get(posicion).setStock(stock);

			}
			if (precio==0) {
			}else {
				productos.get(posicion).setPrecio(precio);

			}
			if (codigo.equals("")) {
			}else {
				productos.get(posicion).setCodigo(codigo);

			}
			
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "valor invalido");
		}catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "seleccione el producto que desea modificar");
		}
		
		}

	@XmlElementWrapper(name = "productos")
	@XmlElement(name = "Producto")
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	


	

	


}
