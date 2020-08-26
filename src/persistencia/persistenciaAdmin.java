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

import logica.GestionAdmin;

public class persistenciaAdmin {
	public void crearArchivo(GestionAdmin gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionAdmin.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\admin.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionAdmin leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionAdmin.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionAdmin inmobiliaria = (GestionAdmin) unmarshaller.unmarshal(new FileReader("src\\archivos\\admin.xml"));
		return inmobiliaria;
	}
}
