package vista;

public interface Acciones {


	String INICIAR_SECION = "iniciarSecion";
	
//ACCIONES RESERVA
	String RESERVA = "reserva";
	String FILTRAR_BARRA = "filtrarBarra";
	String FILTRAR_AIRE = "filtrarAire";
	String FILTRAR_TELEVISION = "filtrarTelevision";
	String FILTRAR_JACUZZI = "filtrarJacuzzi";

//ACCIONES REGISTRO
	String REGISTRAR = "registrar";
	String CANCELAR_REGISTRO = "cancelarRegistro";

//ACCIONES INICIO SECION
	String SECION_PERSONA = "sesionPersona";
	String SECION_RECEPCIONISTA = "sesionRecepcionista";
	String SECION_ADMIN = "sesionAdmin";
	String CERRAR_CESION = "cerrarSecion";

//CRUD PRODUCTO
	String CREAR_PRODUCTO = "crearProducto";
	String MODIFICAR_PRODUCTO = "modificarProducto";
	String ELIMINAR_PRODUCTO = "eliminarProducto";
	String VER_PRODUCTO = "verProducto";
	String MENU_PRODUCTO = "menuProducto";
	String AGREGAR_PRODUCTO = "agregarProducto";
	String EDITAR_PRODUCTO = "editarProducto";
	String BORRAR_PRODUCTO = "borrarProducto";
	String SALIR_CREAR_PRODUCTO = "salirCrearProducto";
	String SALIR_MODIFICAR_PRODUCTO = "salirModificarProducto";
	String SALIR_ELIMINAR_PRODUCTO = "salirEliminarProducto";
	String SALIR_VER_PRODUCTO = "salirVerProducto";
	String SALIR_CRUD_PRODUCTO = "salirCrudProducto";

//	CRUD RECEPCIONISTA
	String CREAR_RECEPCIONISTA = "crearRecepcionista";
	String MODIFICAR_RECEPCIONISTA = "modificarRecepcionista";
	String ELIMINAR_RECEPCIONISTA = "eliminarRecepcionista";
	String VER_RECEPCIONISTA = "verRecepcionista";
	String MENU_RECEPCIONISTA = "menuRecepcionista";
	String AGREGAR_RECEPCIONISTA = "agregarRecepcionista";
	String EDITAR_RECEPCIONISTA = "editarRecepcionista";
	String BORRAR_RECEPCIONISTA = "borrarRecepcionista";
	String SALIR_CREAR_RECEPCIONISTA = "salirCrearRecepcionista";
	String SALIR_MODIFICAR_RECEPCIONISTA = "salirModificarRecepcionista";
	String SALIR_ELIMINAR_RECEPCIONISTA = "salirEliminarRecepcionista";
	String SALIR_VER_RECEPCIONISTA = "salirVerRecepcionista";

//CRUD CLIENTE
	String REGISTRAR_CLIENTE = "registrarCliente";
	String MODIFICAR_CLIENTE = "modificarCliente";
	String ELIMINAR_CLIENTE = "eliminarCliente";
	String VER_CLIENTE = "verCliente";
	String EDITAR_CLIENTE = "editarCliente";
	String BORRAR_CLIENTE = "borrarCliente";
	String SALIR_CRUD_CLIENTE = "salirCrudCliente";
	String SALIR_CONFIRMAR_CLIENTE = "salirConfirmarCliente";
	String ASIGNAR_HABITACION = "asignarHabitacion";
	String SALIR_RESERVA = "salirReserva";
	String MOSTRAR = "mostrar";
	String REESTABLECER = "reestablecer";
	String CONFIRMAR = "confirmar";

//CRUD HABITACION
	String CREAR_HABITACION = "crearHabitacion";
	String MODIFICAR_HABITACION = "modificarHabitacion";
	String ELIMINAR_HABITACION = "eliminarHabitacion";
	String VER_HABITACION = "verHabitacion";
	String MENU_HABITACION = "menuHabitacion";
	String AGREGAR_HABITACION = "agregarHabitacion";
	String EDITAR_HABITACION = "editarHabitacion";
	String BORRAR_HABITACION = "borrarHabitacion";
	String SALIR_CREAR_HABITACION = "salirCrearHabitacion";
	String SALIR_CRUD_HABITACION = "salirCrudHabitacion";

//COMPRA PRODUCTOS
	String COMPRAR = "comprar";
	String MAS = "mas";
	String MENOS = "menos";
	String MOVERSE = "moverse";
	String MOSTRAR_PRODUCTO = "mostrarProducto";
	String VER_HISTORIAL = "verHistorial";
	String SALIR_VER_HISTORIAL = "salirVerHistorial";



 
	
//METODOS------------------------------------------------------
	public void iniciar(String seccion);
	public void salir(String seccion);
	public void escribir(String[][]datos, String seccion);
	public String[] leer(String seccion);
	public void dibujar(String[] datos, String seccion);
	public void borrar(String seccion);
}
