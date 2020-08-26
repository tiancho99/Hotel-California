package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "GestionRecepcionista")
public class GestionRecepcionista implements Comparator<Recepcionista>{
	
	ArrayList<Recepcionista> recepcionistas;
	static int indice; 
	public GestionRecepcionista() {
	
		recepcionistas = new ArrayList<Recepcionista>();
		Date fecha = new Date();
		
	}
	
	public boolean validarSecion(String[] datos) {

		for (int i = 0; i < recepcionistas.size(); i++) {
			
			if(datos[0].equals(recepcionistas.get(i).getDocumento()) && datos[1].equals(recepcionistas.get(i).getContraseña())) {
				indice=i;
				return true;  
				 
			}
			
		}
		return false;

	}
	
	public String[] verPerfil() {
		String[] datos = new String[3];
		datos[0] = recepcionistas.get(indice).getNombre();
		datos[1] = recepcionistas.get(indice).getApellido();
		datos[2] = recepcionistas.get(indice).getDocumento();
		return datos;
	}
	public int buscarRecepcionista(String documento) {
		for (int i = 0; i < recepcionistas.size(); i++) {
			if (recepcionistas.get(indice).getDocumento().equals(documento)) {
				return i;
			}
		}
		return -1;
	}
	public void crearRecepcionista(String[] datos) throws NullPointerException, ParseException {
		SimpleDateFormat parseador = new SimpleDateFormat("d/MM/yyyy");
		// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  direccion
		try {
		String documento = datos[0];
		String nombre = datos[1];
		String apellido = datos[2];
		String ciudad = datos[3];
		Date nacimiento = parseador.parse(datos[4]);
		String celular = datos[5];
		String contraseña = datos[6];
		String direccion = datos[7];
		
//		SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
//		Date date = formato.format(nacimiento);;
		
		Recepcionista recepcionista = new Recepcionista(documento, nombre, apellido, ciudad, nacimiento, celular, contraseña, 0);
		recepcionistas.add(recepcionista);
		Collections.sort(recepcionistas);
		
		JOptionPane.showMessageDialog(null, "Recepcionista creado");
		
		}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "valor invalido");
	}
	}

	public String[][] mostrarDatos() {
		ArrayList<Recepcionista> recepcionistas2 = recepcionistas;
		String[][] datos = new String[recepcionistas2.size()][8];
// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  direccion
		SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
		
		for(int i = 0; i < recepcionistas2.size(); i++) {
			datos[i][0] = recepcionistas2.get(i).getDocumento();
			datos[i][1] = recepcionistas2.get(i).getNombre();
			datos[i][2] = recepcionistas2.get(i).getApellido();
			datos[i][3] = recepcionistas2.get(i).getCiudad();
			datos[i][4] = formato.format(recepcionistas2.get(i).getNacimiento());
			datos[i][5] = recepcionistas2.get(i).getCelular();
			datos[i][6] = recepcionistas2.get(i).getContraseña();
			datos[i][7] = String.valueOf(recepcionistas2.get(i).getNumeroVentas());
		}
		return datos;
	}
	
	public void borrarRecepcionista(String[] datos) {
	int posicion = Integer.parseInt(datos[0]);
				recepcionistas.remove(posicion);
	}
	
	public void actualizarDatos(String[] datos) throws ParseException, NullPointerException {
//		documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  direccion
		SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
		try {
			
			int posicion = Integer.parseInt(datos[0]);
			String documento = datos[1];
			String nombre = datos[2];
			String apellido = datos[3];
			String ciudad = datos[4];
			String nacimiento = datos[5];
			String celular = datos[6];
			String contraseña = datos[7];
			String direccion = datos[8];
			
			if (!documento.equals("")) {
				recepcionistas.get(posicion).setDocumento(documento);
			}
			if (!nombre.equals("")) {
				recepcionistas.get(posicion).setNombre(nombre);
			}
			if (!apellido.equals("")) {
				recepcionistas.get(posicion).setApellido(apellido);
			}
			if (!ciudad.equals("")) {
				recepcionistas.get(posicion).setCiudad(ciudad);
			}
			if (!nacimiento.equals("")) {
				Date date = formato.parse(nacimiento);
				recepcionistas.get(posicion).setNacimiento(date);
			}
			if (!celular.equals("")) {
				recepcionistas.get(posicion).setCelular(celular);
			}
			if (!contraseña.equals("")) {
				recepcionistas.get(posicion).setContraseña(contraseña);
			}
			if (!direccion.equals("")) {
				int venta = Integer.parseInt(datos[8]);
				recepcionistas.get(posicion).setNumeroVentas(venta);
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "valor invalido");
		}catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "seleccione el Recepcionista que desea modificar");
		}
		
		}
	@Override
	public int compare(Recepcionista e1, Recepcionista e2) {
		if(e1.getNumeroVentas()>e2.getNumeroVentas()){
            return -1;
        }else if(e1.getNumeroVentas()>e2.getNumeroVentas()){
            return 0;
        }else{
            return 1;
        }
	}
	
	@XmlElementWrapper(name = "recepcionistas")
	@XmlElement(name = "Recepcionista")
	public ArrayList<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}
public void setRecepcionistas(ArrayList<Recepcionista> recepcionistas) {
	this.recepcionistas = recepcionistas;
}
	

	


	

	

}
