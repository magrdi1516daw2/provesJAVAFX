package controlador;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class CrearAnimal {
    
    //MIRAR DE LLEGIR TOTS ARGUMENTS PASSATS, GUARDARLOS EN ARRAY I AMB BUCLE CRAR ELS NODES
    
    public static void CrearAnimal(String fitxer, String NodeAnimal, String id, String nom, String raça, String edat,
            String sexe, String pes, String esp_vida, String vertebrat, String alimentacio, 
            String reproduccio, String ecosistema, String vacuna_id, String seccio) {
 
	  try {
 
                String filepath = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/dades/" + fitxer + ".xml";
                
                String dtd = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/dades/" + fitxer + ".dtd";
                
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);

                docFactory.setValidating(true);

                Element docRoot = doc.getDocumentElement();
                
                //COMPROVEM MAMIFER AM MATEIX ID NO EXISTEIX ABANS CREARLO
                
//                try {
//                    Element mamifer = doc.getElementById(id);
//                    String existeix = mamifer.getNodeValue();
//                    System.err.println("\nJa existeix Animal amb ID = " + id + "\ncreació cancelada ... tria altra ID!\n");
//                
//                }catch(NullPointerException e){
                    
//                    Element mamifer = doc.getElementById(id);
//                    String existeix = mamifer.getNodeValue();
                
                    System.out.println("Efectuant creació ....");
                    
                    Element Animal = doc.createElement(NodeAnimal);
                    docRoot.appendChild(Animal);
                    Animal.setAttribute("id", id);

                    Element nomTag = doc.createElement("nom");
                    Animal.appendChild(nomTag);
                    nomTag.appendChild(doc.createTextNode(nom));

                    Element raçaTag = doc.createElement("raça");
                    Animal.appendChild(raçaTag);
                    raçaTag.appendChild(doc.createTextNode(raça));

                    Element edatTag = doc.createElement("edat");
                    Animal.appendChild(edatTag);
                    edatTag.appendChild(doc.createTextNode(edat));

                    Element sexeTag = doc.createElement("sexe");
                    Animal.appendChild(sexeTag);
                    sexeTag.appendChild(doc.createTextNode(sexe));

                    Element pesTag = doc.createElement("pes");
                    Animal.appendChild(pesTag);
                    pesTag.appendChild(doc.createTextNode(pes));
                    
                    Element esp_vidaTag = doc.createElement("esp_vida");
                    Animal.appendChild(esp_vidaTag);
                    esp_vidaTag.appendChild(doc.createTextNode(esp_vida));
                    
                    Element vertebratTag = doc.createElement("vertebrat");
                    Animal.appendChild(vertebratTag);
                    vertebratTag.appendChild(doc.createTextNode(vertebrat));
                    
                    Element alimentacioTag = doc.createElement("alimentacio");
                    Animal.appendChild(alimentacioTag);
                    alimentacioTag.appendChild(doc.createTextNode(alimentacio));
                    
                    Element reproduccioTag = doc.createElement("reproduccio");
                    Animal.appendChild(reproduccioTag);
                    reproduccioTag.appendChild(doc.createTextNode(reproduccio));
                    
                    Element ecosistemaTag = doc.createElement("ecosistema");
                    Animal.appendChild(ecosistemaTag);
                    ecosistemaTag.appendChild(doc.createTextNode(ecosistema));
                    
                    Element vacunaTag = doc.createElement("vacuna_id");
                    Animal.appendChild(vacunaTag);
                    vacunaTag.appendChild(doc.createTextNode(vacuna_id));
                    
                    Element seccioTag = doc.createElement("seccio");
                    Animal.appendChild(seccioTag);
                    seccioTag.appendChild(doc.createTextNode(seccio));
                    
//                }
                
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
            
            System.out.println("Nou Mamifer["+id+"] creat ....... [OK]");
 
	  } catch (ParserConfigurationException | TransformerException pce) {
	  } catch (SAXException | IOException ex) {
            Logger.getLogger(CrearAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
}
