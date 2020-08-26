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

import logica.GestionRecepcionista;

public class persistenciaRecepcionista {
	public void crearArchivo(GestionRecepcionista gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionRecepcionista.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\recepcionista.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionRecepcionista leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionRecepcionista.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionRecepcionista inmobiliaria = (GestionRecepcionista) unmarshaller.unmarshal(new FileReader("src\\archivos\\recepcionista.xml"));
		return inmobiliaria;
	}
}
