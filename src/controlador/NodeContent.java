package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import model.Animal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodeContent {
    
    public static void Modifica(String fitxer, List <Animal> llista, int id, String TagName, String newContent) {
        
        String ID = String.valueOf(id);
        
        llista.get(id).setNom(newContent);
            
        try {
            
            String filepath = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/dades/" + fitxer + ".xml";
        
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            docFactory.setValidating(true);
            
            try {
                Element Animal = doc.getElementById(String.valueOf(ID));
                String existeix = Animal.getNodeValue();
                
//                    if(id.equals(TagName)){
//                        Animal.removeAttribute(id);
//                        Animal.setAttribute("id", id);
//                        System.out.println("ATTRIBUTE_NODE ");
//                    }
                
                NodeList AnimalNodes = Animal.getChildNodes();

                for(int i = 0; i < AnimalNodes.getLength(); i++){
                    Node node = AnimalNodes.item(i);
                    
                    if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(TagName)){
                        
                        String camp = node.getNodeName();
                        String camp_valor = node.getFirstChild().getTextContent();
                        System.out.println("old " + camp + ": " + camp_valor + " ==> new " + camp + ": " + newContent);
                        node.getFirstChild().setTextContent(newContent);
                        System.out.println("ELEMENT_NODE ");
                        
                    }
                }

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                /* Afegim el DTD extern per usar les ID:
                 * Mirem de quin tipus animal es el fitxer XML i afegim el DTD de la seva especie
                 * Documentacio: http://stackoverflow.com/questions/6637076/parsing-xml-with-dom-doctype-gets-erased
                */

                switch (fitxer) {
                    case "Mamifers":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Mamifers.dtd");
                            break;
                    case "Reptils":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Reptils.dtd");
                            break;
                    case "Peixos":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Peixos.dtd");
                            break;
                    case "Amfibis":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Amfibis.dtd");
                            break;
                    case "Aus":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Aus.dtd");
                            break;
                    case "Artropodes":
                            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Artropodes.dtd");
                            break;
                }

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filepath));
                transformer.transform(source, result);

                System.out.println("Dada modificada ....... [OK]");
                
                }catch(NullPointerException e){
                    System.err.println("No existeix Animal amb ID = " + id + "\nmodificació no posibe ... tria altra ID!\n");
                }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(NodeContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(NodeContent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(NodeContent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
