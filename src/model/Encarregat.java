package model;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
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
import controlador.CrearAnimal;
import static controlador.CrearAnimal.CrearAnimal;
import java.util.Comparator;
/**
 * Creció de la classe Encarregat que hereta de Empleat i implementa les interfícies Cuidador i Veterinari
 */

public class Encarregat extends Empleat implements Cuidador, Comparable <Encarregat> {

    public Encarregat(String nom, String ID, int seccio, double sou) {
        this.nom = nom;
        this.ID = ID;
        this.seccio = seccio;
        this.sou = sou;
    }
    
    public Encarregat() {
        nom = "desconegut";
        ID = "desconeguda";
        seccio = 0;
        sou = 648.99;
    }
    
    
    @Override
    public int compareTo(Encarregat e) {
        int compare = (int) (this.sou - e.getSou());
        if (compare > 0) {
            return 1;
        }
        else if (compare < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //son de la mateixa classe els 2 objectes ?
        if (getClass() != obj.getClass()) {
            return false;
        }
        //LOWCASTING
        final Encarregat other = (Encarregat) obj;
        //tenen el mateix nom ?
        if(ID == null ? other.ID == null : ID.equals(other.ID)) {
            return true;
        }else{
            return false;
        }
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSeccio() {
        return seccio;
    }

    public void setSeccio(int seccio) {
        this.seccio = seccio;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    public static void Vacunar(String fitxer, String NodeVacuna, String vacuna_id, String nom) {
 
	  try {
 
                String filepath = "/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/dades/" + fitxer + ".xml";
                
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);

                docFactory.setValidating(true);

                Element docRoot = doc.getDocumentElement();
                
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

    public void reproduir(String animal, Animal pare, Animal mare, ArrayList <Animal> llista, String nouNom){
        
         String Tag = animal;
         String Tipus = animal.concat("s");
         
         if ("Peixo".equals(animal)){
            Tipus = "Peixos";
            Tag = "Peix";
         }
        
        if(!pare.femeni.equals(mare.femeni)){
            System.out.println("\n\nReproduint " + pare.getNom() + " amb " + mare.getNom());
            System.out.println("Diferent sexe, podem avançar");
            int ID_fill = llista.size();
            String genere = null;
            Random rand = new Random();
            int randomGenere = rand.nextInt((1 - 0) + 1) + 0;
            if(randomGenere == 1){
                genere = "M";
            }else{
                genere = "F";
            }
            int randomPes = rand.nextInt((10 - 0) + 10) + 0;
            
            System.out.println("\nNova ID: " + ID_fill + "\nnom: "
                                + nouNom + "\ngenere: " + genere
                                + "\npes: " + randomPes
                            );
            
            
            /* 
            * Afegim nou animal creat a la colecció
            */
            switch (Tag) {
                case "Mamifer" : 
                   llista.add( new Mamifer( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
                case "Peix" : 
                   llista.add( new Peix( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
                case "Reptils" : 
                   llista.add( new Reptil( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
                case "Amfibis" : 
                   llista.add( new Amfibi( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
                case "Aus" : 
                   llista.add( new Au( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
                case "Artropodes" : 
                   llista.add( new Artropode( String.valueOf(ID_fill), nouNom, mare.getRaça(),
                                String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                                pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                                pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio()) ) 
                          );
                    break;
            }
            
                /* 
                * Afegim nou animal creat al fitxer XML
                */
                 CrearAnimal( Tipus, Tag, String.valueOf(ID_fill), nouNom, mare.getRaça(),
                        String.valueOf(0), genere, String.valueOf(randomPes), String.valueOf(pare.getEsp_vida()),
                        pare.getVertebrat(), pare.getAlimentacio(), pare.getReproduccio(),
                        pare.getEcosistema(), "M".concat(String.valueOf(ID_fill)), String.valueOf(mare.getSeccio())
                    );
            
        }else{
            System.out.println("Mateix sexe, no poden avançar");
        }
    }
    /**
     * @see Veterinari
     */
    
    public void tractar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal) {
        System.out.println("Encarregat "+ID_encarregat+" de nom "+nom_encarregat+" ha tractat a " + ID_animal+" de nom "+nom_animal);
    }

    /**
     * @see Veterinari
     */
    @Override
    public void netejar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal) {
                System.out.println("Encarregat "+ID_encarregat+" de nom "+nom_encarregat+" ha netejat a " + ID_animal+" de nom "+nom_animal);
    }

    /**
     * El objecte encarregat alimenta al objecte animal si el tipus de menjar esta permès
     * @param ID_encarregat
     * @param nom_encarregat
     * @param ID_animal
     * @param nom_animal
     * @param tipus_aliment 
     */
    @Override
    public void alimentar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal, String tipus_aliment) {
        System.out.print("Encarregat "+ID_encarregat+" de nom "+nom_encarregat+" ha alimentat a " + ID_animal+" de nom "+nom_animal);
        if(tipus_aliment == "hervívor"){
            System.out.println(" amb herba");
        }
        else if(tipus_aliment == "carnívor"){
            System.out.println(" amb carn");
        }
        else if(tipus_aliment == "omnívor"){
            System.out.println(" amb carn i herba");
        }
        else{
            System.out.println(" {tipus de menjar no permitit}");
        }
    }

    @Override
    public String toString() {
        return "Encarregat{" + "nom: " + nom + "ID: " + ID + " seccio: " + seccio + " sou: " + sou + "}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    

}
