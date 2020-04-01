import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/**
 * PlikXML
 */
public class PlikXML {

	public PlikXML() {
		
	}

	public void SaveXMLFile(String name) {
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("Root");
			doc.appendChild(root);

			Element personE = doc.createElement("Osoba");
			personE.setAttribute("nr", "1");
			root.appendChild(personE);

			Element nameE = doc.createElement("Imie");
			nameE.setTextContent("Jan");

			Element lastNameE = doc.createElement("Nazwisko");
			Text text = doc.createTextNode("Kowalski");
			lastNameE.appendChild(text);
			personE.appendChild(nameE);
			personE.appendChild(lastNameE);

			Element addressE = doc.createElement("Adres");
			personE.appendChild(addressE);

			Element streetE = doc.createElement("Ulica");
			streetE.setTextContent("Kwiatowa");
			streetE.setAttribute("nr", "12");
			streetE.setAttribute("lok", "6");

			Element cityE = doc.createElement("Miasto");
			cityE.setTextContent("Kraków");
			cityE.setAttribute("postal", "30-000");

			personE.appendChild(streetE);
			personE.appendChild(cityE);

			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			t.setOutputProperty(OutputKeys.METHOD, "XML");
			t.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter sw = new StringWriter();
			t.transform(new DOMSource(doc), new StreamResult(sw));
			t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(name)));
			System.out.println(sw.toString());
		}
		catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e){
			e.printStackTrace();
		}
		catch (TransformerException e){
			e.printStackTrace();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
