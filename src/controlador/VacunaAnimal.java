package controlador;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class VacunaAnimal {
    
    public static void Vacunar(String fitxer, String NodeVacuna, String vacuna_id, String nom) {
 
	  try {
 
                String filepath = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/projecte_programacio_ii_uf5/" + fitxer + ".xml";
                
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);

                docFactory.setValidating(true);

                Element docRoot = doc.getDocumentElement();
                
                
                //COMPROVEM MAMIFER AM MATEIX ID NO EXISTEIX ABANS CREARLO
                
//            try {
//                Element vacuna = doc.getElementById(vacuna_id);
////                String existeix = vacuna.getNodeValue();
////                System.err.println("\nJa existeix Vacuna amb ID = " + vacuna_id + "\ncreació cancelada ... tria altra ID!\n");
//
//                }catch(NullPointerException e){
                    
                    System.out.println("Efectuant creació vacuna ...\n");
                    
                    Element Vacuna = doc.createElement(NodeVacuna);
                    docRoot.appendChild(Vacuna);
                    Vacuna.setAttribute("id", vacuna_id);

                    Element nomTag = doc.createElement("nom");
                    Vacuna.appendChild(nomTag);
                    nomTag.appendChild(doc.createTextNode(nom));
                    
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar cal = Calendar.getInstance();
                    String data = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22

                    Element dataTag = doc.createElement("data");
                    Vacuna.appendChild(dataTag);
                    dataTag.appendChild(doc.createTextNode(data));
                    
                    
//                }
                
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            /* Afegim el DTD extern per usar les ID:
             * Mirem de quin tipus animal es el fitxer XML i afegim el DTD de la seva especie
             * Documentacio: http://stackoverflow.com/questions/6637076/parsing-xml-with-dom-doctype-gets-erased
            */
            
      
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Vacunes.dtd");
            
            
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            
            System.out.println("Nova vacuna["+vacuna_id+"] creada ....... [OK]");
 
	  } catch (ParserConfigurationException | TransformerException pce) {
	  } catch (SAXException | IOException ex) {
            Logger.getLogger(CrearAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
}
