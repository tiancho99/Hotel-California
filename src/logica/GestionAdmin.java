package logica;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "GestionAdmin")
public class GestionAdmin {
	
	ArrayList<Admin> admins;
	static int indice;
	public GestionAdmin() {
	
		admins = new ArrayList<Admin>();
		Admin admin1 = new Admin("juan","perez","3", "3");
		admins.add(admin1);
	
	}
	
	public boolean validarSecion(String[] datos) {

		for (int i = 0; i < admins.size(); i++) {
			
			if(datos[0].equals(admins.get(i).getDocumento()) && datos[1].equals(admins.get(i).getContraseña())) {
				indice=i;
				return true;
				 
			}
			
		}
		return false;

	}
	public String[] verPerfil() {
		String[] datos = new String[2];
		datos[0] = admins.get(indice).getNombre();
		datos[1] = admins.get(indice).getApellido();
		return datos;
	}

	
	
	@XmlElementWrapper(name = "admins")
	@XmlElement(name = "admin")
	public ArrayList<Admin> getAdmins() {
		return admins;
	}
public void setAdmins(ArrayList<Admin> admins) {
	this.admins = admins;
}
	public static int getIndice() {
		return indice;
	}
	
	
}
