package controlador;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* For the getElementById() call to work, the Document 
* has to know the types of its nodes, and the target node
* must be of the XML ID type for the method to find it. 
* It knows about the types of its elements via an associated schema.
* If the schema or DTD is not set, or does not declare the id attribute to
* be of the XML ID type, getElementById() will never find it.
*/

public class Lectura_per_ID {
    
    public static void Lectura(String fitxer, int id) {
        
        String ID = String.valueOf(id);
        
        File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/dades/" + fitxer + ".xml");
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();
            
            try {
                Element mamifer = doc.getElementById(ID);
                String existeix = mamifer.getNodeValue();
                
                System.out.println("\nInformació node\n======================");
                String nomNode = mamifer.getTagName();
                String valAttr = mamifer.getAttribute("id");
                System.out.println("Tipus: " + nomNode + "\nid: " + valAttr);

                NodeList mamiferNodes = mamifer.getChildNodes();

                System.out.println("\nContingut node\n==============");

                for(int i = 0; i < mamiferNodes.getLength(); i++){
                    Node node = mamiferNodes.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        String camp = node.getNodeName();
                        String camp_valor = node.getFirstChild().getTextContent();
                        System.out.println(camp + ": " + camp_valor);
                    }
                }

                System.out.println("======================\n");
                
            }catch(NullPointerException e){
                System.err.println("\nNo existeix Mamifer amb ID = " + id + "\nlectura no posible ... tria altra ID!\n");
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Lectura_per_ID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}