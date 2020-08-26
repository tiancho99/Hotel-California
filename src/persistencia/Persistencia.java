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
import logica.GestionReserva;

public class Persistencia {

	public void crearArchivo(GestionReserva gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionReserva.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\hotel.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionReserva leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionReserva.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionReserva inmobiliaria = (GestionReserva) unmarshaller.unmarshal(new FileReader("src\\archivos\\hotel.xml"));
		return inmobiliaria;
	}

}
