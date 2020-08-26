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

import logica.GestionHistorial;

public class persistenciaHistorial {
	public void crearArchivo(GestionHistorial gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionHistorial.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\historial.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionHistorial leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionHistorial.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionHistorial inmobiliaria = (GestionHistorial) unmarshaller.unmarshal(new FileReader("src\\archivos\\historial.xml"));
		return inmobiliaria;
	}
}
