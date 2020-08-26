package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBException;

import logica.GestionAdmin;
import logica.GestionHabitacion;
import logica.GestionProducto;
import logica.GestionRecepcionista;
import logica.GestionReserva;
import persistencia.Persistencia;
import persistencia.persistenciaAdmin;
import persistencia.persistenciaHabitacion;
import persistencia.persistenciaHistorial;
import persistencia.persistenciaProducto;
import persistencia.persistenciaRecepcionista;
import vista.Acciones;

public class Control implements ActionListener {
	Acciones acciones;
	GestionReserva gestionReserva;  
	Persistencia persistencia;
	persistenciaAdmin pAdmin;
	persistenciaHabitacion pHabitacion;
	persistenciaHistorial pHistorial;
	persistenciaProducto pProducto;
	persistenciaRecepcionista pRecepcionista;
	
	
	public Control(Acciones acciones) {
		this.acciones = acciones; 
		gestionReserva = new GestionReserva();
		persistencia = new Persistencia();
		pAdmin = new persistenciaAdmin();
		pHabitacion = new persistenciaHabitacion();
		pHistorial = new persistenciaHistorial(); 
		pProducto = new persistenciaProducto();
		pRecepcionista = new persistenciaRecepcionista();
		cargarDatos();
	} 
 
	private void cargarDatos() {
		try {
			gestionReserva = persistencia.leerArchivo();
			gestionReserva.setGestionRecepcionista(pRecepcionista.leerArchivo());
			gestionReserva.setGestionAdmin(pAdmin.leerArchivo());
			gestionReserva.setGestionHabitacion(pHabitacion.leerArchivo());
			gestionReserva.setGestionHistorial(pHistorial.leerArchivo());
			gestionReserva.setGestionProducto(pProducto.leerArchivo());
		
		} catch (FileNotFoundException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {

		case Acciones.INICIAR_SECION: 
			String[] datosInicio = acciones.leer(Acciones.INICIAR_SECION);

			if(gestionReserva.validarSecion(datosInicio)) {
				acciones.salir(Acciones.INICIAR_SECION);
				acciones.iniciar(Acciones.SECION_PERSONA);
				acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MOSTRAR_PRODUCTO);
				acciones.dibujar(gestionReserva.mostrarcliente(datosInicio[0]), Acciones.SECION_PERSONA);
				
			}else
				if(gestionReserva.getGestionRecepcionista().validarSecion(datosInicio)) {
					acciones.salir(Acciones.INICIAR_SECION);
					acciones.iniciar(Acciones.SECION_RECEPCIONISTA);
					acciones.dibujar(gestionReserva.getGestionRecepcionista().verPerfil(), Acciones.SECION_RECEPCIONISTA);
					acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null),	Acciones.RESERVA);

				}else if (gestionReserva.getGestionAdmin().validarSecion(datosInicio)) {
					acciones.salir(Acciones.INICIAR_SECION);
					acciones.iniciar(Acciones.SECION_ADMIN); 
					acciones.dibujar(gestionReserva.getGestionAdmin().verPerfil(), Acciones.SECION_ADMIN);
 
				} 
				else {
					JOptionPane.showMessageDialog(null, "usuario o contraseña erronea");
				}

			break;
		
		case Acciones.CERRAR_CESION:
			acciones.salir(Acciones.CERRAR_CESION);
			acciones.iniciar(Acciones.INICIAR_SECION);
			try {
				
				persistencia.crearArchivo(gestionReserva);
				pAdmin.crearArchivo(gestionReserva.getGestionAdmin());
				pRecepcionista.crearArchivo(gestionReserva.getGestionRecepcionista());
				pHabitacion.crearArchivo(gestionReserva.getGestionHabitacion());
				pHistorial.crearArchivo(gestionReserva.getGestionHistorial());
				pProducto.crearArchivo(gestionReserva.getGestionProducto());
				
			} catch (JAXBException | IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
//			persistenciaSerializable.crearArchivo(gestionReserva.getReservas());
			break;
			
		case Acciones.CREAR_PRODUCTO:
			acciones.salir(Acciones.MENU_PRODUCTO);
			acciones.iniciar(Acciones.CREAR_PRODUCTO);
			acciones.iniciar(Acciones.MODIFICAR_PRODUCTO);
			acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MODIFICAR_PRODUCTO);
			break;
			
		case Acciones.CREAR_RECEPCIONISTA:
			acciones.escribir(gestionReserva.getGestionRecepcionista().mostrarDatos(), Acciones.MODIFICAR_RECEPCIONISTA);
			acciones.salir(Acciones.MENU_RECEPCIONISTA);
			acciones.iniciar(Acciones.CREAR_RECEPCIONISTA);
			
			break;
			
		
		case Acciones.SALIR_CREAR_PRODUCTO:
			acciones.salir(Acciones.SALIR_CREAR_PRODUCTO);
			acciones.iniciar(Acciones.MENU_PRODUCTO);
		
		break;
		
		case Acciones.SALIR_CRUD_PRODUCTO:
			acciones.salir(Acciones.SALIR_CREAR_PRODUCTO);
			acciones.salir(Acciones.SALIR_MODIFICAR_PRODUCTO);
			acciones.iniciar(Acciones.MENU_PRODUCTO);
			break;
			
		case Acciones.SALIR_CREAR_RECEPCIONISTA:
			acciones.salir(Acciones.CREAR_RECEPCIONISTA);
			acciones.salir(Acciones.MODIFICAR_RECEPCIONISTA);
			acciones.iniciar(Acciones.MENU_PRODUCTO);
		break;
		
		case Acciones.CREAR_HABITACION:
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null), Acciones.MODIFICAR_HABITACION);
			acciones.salir(Acciones.MENU_PRODUCTO);
			acciones.iniciar(Acciones.CREAR_HABITACION);
			break; 
			
		case Acciones.SALIR_CREAR_HABITACION:
			acciones.salir(Acciones.CREAR_HABITACION);
			acciones.salir(Acciones.MODIFICAR_HABITACION);
			acciones.iniciar(Acciones.MENU_PRODUCTO);
			break;
		
		case Acciones.ASIGNAR_HABITACION:
			
		try {
			String[] continuar = acciones.leer(Acciones.ASIGNAR_HABITACION);
			acciones.salir(Acciones.RESERVA);
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.ASIGNAR_HABITACION, continuar), Acciones.ASIGNAR_HABITACION);
			}catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "seleccione una habitacion");
			}
			break;
		
		case Acciones.REGISTRAR_CLIENTE:
			acciones.salir(Acciones.CONFIRMAR);
			
			break;
			
		case Acciones.CANCELAR_REGISTRO: 
			acciones.salir(Acciones.RESERVA);
			
			break;
			
		case Acciones.SALIR_CONFIRMAR_CLIENTE:
			acciones.salir(Acciones.SALIR_CONFIRMAR_CLIENTE);
			
			break;
			
		case Acciones.MODIFICAR_CLIENTE:
		String[] datosClientes = acciones.leer(Acciones.MODIFICAR_CLIENTE);
		acciones.salir(Acciones.MODIFICAR_CLIENTE);
		try {
		acciones.escribir(gestionReserva.mostrarDatos(datosClientes), Acciones.MODIFICAR_CLIENTE);
		}catch (ArrayIndexOutOfBoundsException e2) {
			String[][] datos = {};
			acciones.escribir(datos, Acciones.MODIFICAR_CLIENTE);
		}
		
		break;
		
		case Acciones.SALIR_CRUD_CLIENTE:
			acciones.salir(Acciones.SALIR_CRUD_CLIENTE);
			break;
		
		
//FILTROS DE BUSQUEDA---------------------------------------------------------------------------------------------
		case Acciones.FILTRAR_BARRA:
			
			String[] continuar = acciones.leer(Acciones.RESERVA);
//			System.out.println(continuar[0]);
//			System.out.println(continuar[1]);
//			System.out.println(continuar[2]);
//			System.out.println(continuar[3]);
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.FILTRAR_BARRA, continuar), Acciones.RESERVA);
			
			break; 
		case Acciones.REESTABLECER:
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null),	Acciones.RESERVA);
			break;
//ACCIONES CRUDS--------------------------------------------------------------------------------------------------

		case Acciones.AGREGAR_PRODUCTO:
			gestionReserva.getGestionProducto().crearProducto(acciones.leer(Acciones.AGREGAR_PRODUCTO));
			acciones.borrar(Acciones.AGREGAR_PRODUCTO);
			acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MODIFICAR_PRODUCTO);
			
			break;
			
		case Acciones.EDITAR_PRODUCTO:
			gestionReserva.getGestionProducto().actualizarDatos(acciones.leer(Acciones.EDITAR_PRODUCTO));
			acciones.borrar(Acciones.AGREGAR_PRODUCTO);
			acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MODIFICAR_PRODUCTO);
			break;
			
		case Acciones.BORRAR_PRODUCTO:
			gestionReserva.getGestionProducto().borrarProducto(acciones.leer(Acciones.BORRAR_PRODUCTO));
			acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MODIFICAR_PRODUCTO);
			break;
			
		case Acciones.AGREGAR_HABITACION:
			gestionReserva.getGestionHabitacion().crearHabitacion(acciones.leer(Acciones.AGREGAR_HABITACION));
			acciones.borrar(Acciones.AGREGAR_HABITACION);
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null), Acciones.MODIFICAR_HABITACION);
			break;

		case Acciones.EDITAR_HABITACION:
			gestionReserva.getGestionHabitacion().actualizarDatos(acciones.leer(Acciones.EDITAR_HABITACION));
			acciones.borrar(Acciones.AGREGAR_HABITACION);
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null), Acciones.MODIFICAR_HABITACION);
			break;

		case Acciones.BORRAR_HABITACION:
			gestionReserva.getGestionHabitacion().borrarProducto(acciones.leer(Acciones.BORRAR_HABITACION));
			acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null), Acciones.MODIFICAR_HABITACION);
			break;
			
		case Acciones.AGREGAR_RECEPCIONISTA:
			try {
				gestionReserva.getGestionRecepcionista().crearRecepcionista(acciones.leer(Acciones.AGREGAR_RECEPCIONISTA));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "fecha invalida");
			}catch(NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "fecha invalida");
			}
			acciones.borrar(Acciones.AGREGAR_RECEPCIONISTA);
			acciones.escribir(gestionReserva.getGestionRecepcionista().mostrarDatos(), Acciones.MODIFICAR_RECEPCIONISTA);
			break; 

		case Acciones.EDITAR_RECEPCIONISTA:
			try {
				gestionReserva.getGestionRecepcionista().actualizarDatos(acciones.leer(Acciones.EDITAR_RECEPCIONISTA));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "no ingreso la fecha");
				e1.printStackTrace();
			}catch(NullPointerException e2) {
				
			}
			acciones.borrar(Acciones.AGREGAR_RECEPCIONISTA);
			acciones.escribir(gestionReserva.getGestionRecepcionista().mostrarDatos(), Acciones.MODIFICAR_RECEPCIONISTA);
			break;

		case Acciones.BORRAR_RECEPCIONISTA:
			gestionReserva.getGestionRecepcionista().borrarRecepcionista(acciones.leer(Acciones.BORRAR_RECEPCIONISTA));
			acciones.escribir(gestionReserva.getGestionRecepcionista().mostrarDatos(), Acciones.MODIFICAR_RECEPCIONISTA);
			break;
			
		case Acciones.REGISTRAR:
			try {
				gestionReserva.crearReserva(acciones.leer(Acciones.REGISTRAR_CLIENTE));
				acciones.borrar(Acciones.REGISTRAR);
				acciones.escribir(gestionReserva.getGestionHabitacion().mostrarDatos(Acciones.MOSTRAR, null),	Acciones.RESERVA);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "no ingreso la fecha");
				JOptionPane.showMessageDialog(null, "datos invalidos");
			}
			break;

		case Acciones.EDITAR_CLIENTE:
//			try {
			gestionReserva.modificarCliente(acciones.leer(Acciones.REGISTRAR_CLIENTE));
			acciones.borrar(Acciones.REGISTRAR);
			datosClientes = acciones.leer(Acciones.MODIFICAR_CLIENTE);
			acciones.escribir(gestionReserva.mostrarDatos(datosClientes), Acciones.MODIFICAR_CLIENTE);
			
//			}catch (NullPointerException e2) {
//				JOptionPane.showMessageDialog(null, "seleccione el cliente que desea modificar");
//			}
			break;

		case Acciones.BORRAR_CLIENTE:
			
			String[] datosBorrar = acciones.leer(Acciones.MODIFICAR_CLIENTE);
			gestionReserva.checkOut(datosBorrar);
			datosClientes = acciones.leer(Acciones.MODIFICAR_CLIENTE);
			try {
				acciones.escribir(gestionReserva.mostrarDatos(datosClientes), Acciones.MODIFICAR_CLIENTE);
				}catch (ArrayIndexOutOfBoundsException e2) {
					String[][] datos = {};
					acciones.escribir(datos, Acciones.MODIFICAR_CLIENTE);
				}
//			acciones.escribir(gestionReserva.mostrarDatos(datosClientes), Acciones.MODIFICAR_CLIENTE);
			break;
//COMPRA DE PRODUCTOS-------------------------------------------------------------------------------------
		case Acciones.MAS:
			acciones.iniciar(Acciones.MAS);
			break;
		case Acciones.MENOS:
			acciones.iniciar(Acciones.MENOS);
			break;
		case Acciones.MOVERSE:
			acciones.escribir(gestionReserva.getGestionProducto().mostrarDatos(), Acciones.MOSTRAR_PRODUCTO);
			break;
		case Acciones.COMPRAR:
			gestionReserva.AsignarProducto(acciones.leer(Acciones.COMPRAR), acciones.leer(Acciones.SECION_PERSONA));
			String[] datosI = acciones.leer(Acciones.SECION_PERSONA);
			acciones.dibujar(gestionReserva.mostrarcliente(datosI[0]), Acciones.SECION_PERSONA);
			break;
			
		case Acciones.VER_HISTORIAL:
			
			acciones.iniciar(Acciones.VER_HISTORIAL);
			String[][] datosHistorial = gestionReserva.getGestionHistorial().mostrarDatos();
			acciones.escribir(datosHistorial, Acciones.VER_HISTORIAL);
			break;
			
		case Acciones.SALIR_VER_HISTORIAL:
			acciones.iniciar(Acciones.MENU_PRODUCTO);;
			break;
			
			
		default:
			
			break;
		}
	}

}
