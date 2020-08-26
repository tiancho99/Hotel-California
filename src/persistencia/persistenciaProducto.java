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

import logica.GestionProducto;

public class persistenciaProducto {
	public void crearArchivo(GestionProducto gestionReserva) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(GestionProducto.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Writer writer = null;
		try {
			writer = new FileWriter("src\\archivos\\producto.xml");
			marshaller.marshal(gestionReserva, writer);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public GestionProducto leerArchivo() throws JAXBException, FileNotFoundException{
		JAXBContext context = JAXBContext.newInstance(GestionProducto.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GestionProducto inmobiliaria = (GestionProducto) unmarshaller.unmarshal(new FileReader("src\\archivos\\producto.xml"));
		return inmobiliaria;
	}
}
