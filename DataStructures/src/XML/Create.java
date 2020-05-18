package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;

public class Create {

	public static void main(String argv[]) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("class");
			doc.appendChild(rootElement);

			//element
			Element stude = doc.createElement("student");
			rootElement.appendChild(stude);

			// setting attribute to element
			Attr attr = doc.createAttribute("rollno");
			attr.setValue("393");
			stude.setAttributeNode(attr);

			//element
			Element ele1 = doc.createElement("firstname");
			ele1.appendChild(doc.createTextNode("dinkar"));
			stude.appendChild(ele1);

			ele1 = doc.createElement("lastname");
			ele1.appendChild(doc.createTextNode("kad"));
			stude.appendChild(ele1);

			ele1 = doc.createElement("course");	
			stude.appendChild(ele1);
			Element ele2 = doc.createElement("name");
			ele2.appendChild(doc.createTextNode("programming"));
			ele1.appendChild(ele2);			
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("input.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
