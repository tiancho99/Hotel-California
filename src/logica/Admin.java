package logica;

public class Admin {
	private String nombre;
	private String apellido;
	private String documento;
	private String contrase�a;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String nombre, String apellido, String documento, String contrase�a) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
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
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
}
