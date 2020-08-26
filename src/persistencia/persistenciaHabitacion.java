package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import logica.GestionHabitacion;

public class persistenciaHabitacion {
	public void crearArchivo(GestionHabitacion gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionHabitacion.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\habitacion.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionHabitacion leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionHabitacion.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionHabitacion inmobiliaria = (GestionHabitacion) unmarshaller.unmarshal(new FileReader("src\\archivos\\habitacion.xml"));
		return inmobiliaria;
	}
}
