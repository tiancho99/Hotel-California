package logica;

public class Admin {
	private String nombre;
	private String apellido;
	private String documento;
	private String contraseña;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String nombre, String apellido, String documento, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
