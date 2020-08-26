package ejecucion;

import control.Control;
import vista.VentanaPrincipal;

public class RunHotel {
	public static void main(String[] args) {
		VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
		ventanaprincipal.setVisible(true);
		
Control control = new Control(ventanaprincipal);
		
		ventanaprincipal.setVisible(true);
		ventanaprincipal.asignarControl(control);
		
	}
}
