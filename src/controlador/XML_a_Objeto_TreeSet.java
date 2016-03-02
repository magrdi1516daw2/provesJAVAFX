package controlador;

import model.Vacuna;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
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

public class XML_a_Objeto_TreeSet {
    
    public static void XML_a_Objeto_TreeSet(String vacuna, TreeSet <Vacuna> llista){

        String valAttr = null;
        
        String ruta = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/dades/" + vacuna + ".xml";
        
        try {
            
            File xml = new File(ruta);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder;
            
            //ParserConfigurationException
            dBuilder = dbFactory.newDocumentBuilder();
            
            //SAXException
            //IOException
            Document doc = dBuilder.parse(xml);
            
            doc.getDocumentElement().normalize();

            NodeList nodeVacunes = doc.getElementsByTagName("Vacuna");
            
                for(int i = 0; i < nodeVacunes.getLength(); i++){
                    
                ArrayList <String> valors = new ArrayList <>();
                    
                    Node animalNode = nodeVacunes.item(i);
                    
                    if(animalNode.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) animalNode;
                        String nomNode = element.getNodeName();
                        valAttr = element.getAttribute("id");
                    }
                    
                    NodeList animalContent = animalNode.getChildNodes();
                    
                    for(int j = 0; j < animalContent.getLength(); j++){
                        Node node = animalContent.item(j);
                        if(node.getNodeType() == Node.ELEMENT_NODE){
                            String camp = node.getNodeName();
                            String camp_valor = node.getFirstChild().getTextContent();
                            valors.add(camp_valor); //afegim el TextContent al array
                        }
                    }
                    llista.add( new Vacuna( valors.get(0), valors.get(1), valors.get(2) ) );
                }   


        } catch (ParserConfigurationException ex) {
            System.err.println("error ParserConfigurationException");
        } catch (SAXException ex) {
            System.err.println("EL FITXER XML CONTÉ ERRORS DE SINTAXIS");
        } catch (IOException ex) {
            System.err.println("\nL'ARXIU XML NO S'HA TROBAT A LA RUTA ESPECIFICADA: " + ruta +
                    "\n(Comprobar que la ruta es correcte o que l'arxiu no s'ha mogut de lloc o eliminat)");
        }
        
    
    }
}