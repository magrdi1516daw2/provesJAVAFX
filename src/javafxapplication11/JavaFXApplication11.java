/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;


import model.Animal;
import controlador.XML_a_ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author marta
 */
public class JavaFXApplication11 extends Application {
      //Variables de panell de pestanyes, pestanyes,graella.
    TabPane mSuperior, mLateral;
    Tab sup1,sup2,lat1,lat2;
    GridPane dadesEditar,dadesVeure;
    SplitPane pDividit;
    
    //variables de botons etc. de la graella
    Button guardar,esborrar;
    RadioButton masculi,femeni,vertebrat, invertebrat;
    TextField ID,nom,raça,edat,pes,esp_vida,seccio;
    ChoiceBox<String> ecosistema,alimentacio,reproduccio;
    ToggleGroup genere,tipusVertebrat;
    CheckBox rabia, colera, sifilis, parkinson;
    
    public static final ObservableList animals = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        

        //BorderPane borderPane = new BorderPane();
        mSuperior = new TabPane();
        mLateral = new TabPane();
        dadesEditar = new GridPane();
        final ListView llista = new ListView(animals);
        
        Group pSuperior = new Group();
        //Group pLateral = new Group();
        
        ////////Crea l'escena, l'escena és tota la finestra menys la barra d títol
        Scene escena = new Scene(mSuperior,650,700);
        
        primaryStage.setTitle("Aplicació");
        primaryStage.setScene(escena); //associa el stage amb l'escena.
        primaryStage.setResizable(false); //no permet canviar el tamany de la finestra
        primaryStage.show();
            
            sup1 = new Tab();
            sup1.setText("Tab 1");

            
            dadesEditar.setPadding(new Insets(10,10,10,10));
            dadesEditar.setVgap(8); //Vertial spacing
            dadesEditar.setHgap(10); //Horizontal spacing
       
            //////////// crea els camps de Texts
            ID = new TextField("ID");
            ID.setAlignment(Pos.CENTER_RIGHT);
            Label etiquetaID = new Label("ID");
            ID.setEditable(true);
            GridPane.setConstraints(etiquetaID, 0, 0);
            GridPane.setConstraints(ID, 1, 0);
            dadesEditar.getChildren().addAll(etiquetaID, ID);
            
                nom = new TextField();
                nom.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaNom = new Label("Nom");
                nom.setEditable(true);
                GridPane.setConstraints(etiquetaNom, 0, 1);
                GridPane.setConstraints(nom, 1, 1);
                dadesEditar.getChildren().addAll(etiquetaNom, nom);


                raça = new TextField();
                raça.setAlignment(Pos.CENTER_RIGHT); //alinea el text a la dreta dins del TextField
                Label etiquetaRaça = new Label("Raça");
                raça.setEditable(true);
                GridPane.setConstraints(etiquetaRaça, 0, 2);
                GridPane.setConstraints(raça, 1, 2);
                dadesEditar.getChildren().addAll(etiquetaRaça, raça);

                edat = new TextField();
                edat.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaEdat = new Label("Edat");
                edat.setEditable(true);
                GridPane.setConstraints(etiquetaEdat, 0, 3);
                GridPane.setConstraints(edat, 1, 3);
                dadesEditar.getChildren().addAll(etiquetaEdat, edat);

                pes = new TextField();
                pes.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaPes = new Label("Pes");
                pes.setEditable(true);
                GridPane.setConstraints(etiquetaPes, 0, 4);
                GridPane.setConstraints(pes, 1, 4);
                dadesEditar.getChildren().addAll(etiquetaPes, pes);

                //////////// radiobutton sexe
                tipusVertebrat = new ToggleGroup();
                Label etiquetaVertebrat = new Label("Es vertebrat?");

                vertebrat = new RadioButton("Vertebrat");
                vertebrat.setToggleGroup(tipusVertebrat);
                vertebrat.setUserData("vertebrat");

                invertebrat = new RadioButton("Invertebrat");
                invertebrat.setToggleGroup(tipusVertebrat);
                invertebrat.setUserData("invertebrat");


                GridPane.setConstraints(etiquetaVertebrat, 0, 5);
                GridPane.setConstraints(vertebrat, 1, 5);
                GridPane.setConstraints(invertebrat, 2, 5);        
                dadesEditar.getChildren().addAll(etiquetaVertebrat,vertebrat,invertebrat);

                esp_vida = new TextField();
                esp_vida.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaEsp_vida = new Label("Esperança de Vida");
                esp_vida.setEditable(true);
                GridPane.setConstraints(etiquetaEsp_vida, 0, 6);
                GridPane.setConstraints(esp_vida, 1, 6);
                dadesEditar.getChildren().addAll(etiquetaEsp_vida, esp_vida);

                seccio = new TextField();
                seccio.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaSeccio = new Label("Seccio");
                seccio.setEditable(true);
                GridPane.setConstraints(etiquetaSeccio, 0, 7);
                GridPane.setConstraints(seccio, 1, 7);
                dadesEditar.getChildren().addAll(etiquetaSeccio, seccio);

                //////////// radiobutton sexe
                genere = new ToggleGroup();
                Label etiquetaGenere = new Label("Genere");

                femeni = new RadioButton("Femení");
                femeni.setToggleGroup(genere);
                femeni.setUserData("Femeni");

                masculi = new RadioButton("Masculí");
                masculi.setToggleGroup(genere);
                masculi.setUserData("Masculí");


                GridPane.setConstraints(etiquetaGenere, 0, 8);
                GridPane.setConstraints(femeni, 1, 8);
                GridPane.setConstraints(masculi, 2, 8);        
                dadesEditar.getChildren().addAll(etiquetaGenere,femeni,masculi);


                //////////// crea desplegable i etiqueta
                alimentacio = new ChoiceBox<>();
                Label etiquetaAlimentacio = new Label("Alimentacio");

                //getItems returns the Observable object wich u can add items to
                alimentacio.getItems().add("Herbívor");
                alimentacio.getItems().add("Carnívor");
                alimentacio.getItems().add("Omnívor");

                //Set default value
                alimentacio.setValue("Omnívor");

                GridPane.setConstraints(etiquetaAlimentacio, 0, 9);
                GridPane.setConstraints(alimentacio, 1, 9);
                dadesEditar.getChildren().addAll(etiquetaAlimentacio,alimentacio);

                //////////// crea desplegable i etiqueta
                 ecosistema = new ChoiceBox<>();
                Label etiquetaEcosistema = new Label("Ecosistema");

                //getItems returns the Observable object wich u can add items to
                ecosistema.getItems().add("Terrestre");
                ecosistema.getItems().add("Aeri");
                ecosistema.getItems().add("Aquàtic");

                //Set default value
                ecosistema.setValue("Terrestre");

                GridPane.setConstraints(etiquetaEcosistema, 0, 10);
                GridPane.setConstraints(ecosistema, 1, 10);
                dadesEditar.getChildren().addAll(etiquetaEcosistema,ecosistema);

                //////////// crea desplegable i etiqueta
                reproduccio = new ChoiceBox<>();
                Label etiquetaReproduccio = new Label("Reproducció");

                //getItems returns the Observable object wich u can add items to
                reproduccio.getItems().add("Ovíper");
                reproduccio.getItems().add("Vivíper");

                //Set default value
                reproduccio.setValue("Vivíper");

                GridPane.setConstraints(etiquetaReproduccio, 0, 11);
                GridPane.setConstraints(reproduccio, 1, 11);
                dadesEditar.getChildren().addAll(etiquetaReproduccio,reproduccio);

                ////////////radiobutton vacuna
                //vacunacio = new Check<>();
                Label etiquetaVacunacio = new Label("Vacunes");

                rabia = new CheckBox("Rabia");
                colera = new CheckBox("Colera");
                colera.setSelected(true); //per defecte aquesta apareix marcada
                sifilis = new CheckBox("Sifilis");
                parkinson = new CheckBox("Parkinson");

                GridPane.setConstraints(etiquetaVacunacio, 0, 12);
                GridPane.setConstraints(rabia, 1, 12);
                GridPane.setConstraints(colera, 1, 13);
                GridPane.setConstraints(sifilis, 1, 14);
                GridPane.setConstraints(parkinson, 1, 15);
                dadesEditar.getChildren().addAll(etiquetaVacunacio,rabia,colera,sifilis,parkinson);


                //////////// Crea botons i els hi aplica el seu símbol
                guardar= new Button("Guardar");
                esborrar = new Button("Esborrar");


                GridPane.setConstraints(guardar, 1, 16);
                GridPane.setConstraints(esborrar, 2, 16);
                dadesEditar.getChildren().addAll(guardar,esborrar);
//final contingut tab1
                
            sup1.setContent(dadesEditar); // contingut de la tab1
            mSuperior.getTabs().add(sup1); //afegeix la tab1 al panell d tabs
//inici contingut tab2
                     
            sup2 = new Tab();
            sup2.setText("Tab 2");
            
            dadesVeure = new GridPane();
            
            // Se crea un panel dividido verticalmente
            pDividit = new SplitPane(llista,dadesVeure);
                    
            //Inic contingut esquerra llista
            
            //Creacio ArrayList buit
            ArrayList <Animal> llistaMamifers = new ArrayList <>();

            //Per vuere la llista de mamifers
            //Creacio coleccio objectes mamifers a partir de la lectura Mamifers.xml
            XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);

            //Iterador per poder recorrer l'ArrayList
            Iterator <Animal> mamifer_iterador = llistaMamifers.iterator();
            llista.setEditable(false);

            
            while(mamifer_iterador.hasNext()){
            animals.add("Mamifer"+mamifer_iterador.next().getId());
            
        }
            llista.setItems(animals);
//Final contingut esquerra llista

            dadesVeure.setPadding(new Insets(10,10,10,10));
            dadesVeure.setVgap(8); //Vertial spacing
            dadesVeure.setHgap(10); //Horizontal spacing
       
            //////////// crea els camps de Texts
            ID = new TextField("ID");
            ID.setAlignment(Pos.CENTER_RIGHT);
            etiquetaID = new Label("ID");
            ID.setEditable(true);
            GridPane.setConstraints(etiquetaID, 0, 0);
            GridPane.setConstraints(ID, 1, 0);
            dadesVeure.getChildren().addAll(etiquetaID, ID);
            
            nom = new TextField();
            nom.setAlignment(Pos.CENTER_RIGHT);
            etiquetaNom = new Label("Nom");
            nom.setEditable(false);
            GridPane.setConstraints(etiquetaNom, 0, 1);
            GridPane.setConstraints(nom, 1, 1);
                dadesVeure.getChildren().addAll(etiquetaNom, nom);


                raça = new TextField();
                raça.setAlignment(Pos.CENTER_RIGHT); //alinea el text a la dreta dins del TextField
                 etiquetaRaça = new Label("Raça");
                raça.setEditable(true);
                GridPane.setConstraints(etiquetaRaça, 0, 2);
                GridPane.setConstraints(raça, 1, 2);
                dadesVeure.getChildren().addAll(etiquetaRaça, raça);

                edat = new TextField();
                edat.setAlignment(Pos.CENTER_RIGHT);
                etiquetaEdat = new Label("Edat");
                edat.setEditable(true);
                GridPane.setConstraints(etiquetaEdat, 0, 3);
                GridPane.setConstraints(edat, 1, 3);
                dadesVeure.getChildren().addAll(etiquetaEdat, edat);

                pes = new TextField();
                pes.setAlignment(Pos.CENTER_RIGHT);
                etiquetaPes = new Label("Pes");
                pes.setEditable(true);
                GridPane.setConstraints(etiquetaPes, 0, 4);
                GridPane.setConstraints(pes, 1, 4);
                dadesVeure.getChildren().addAll(etiquetaPes, pes);

                //////////// radiobutton sexe
                tipusVertebrat = new ToggleGroup();
                etiquetaVertebrat = new Label("Es vertebrat?");

                vertebrat = new RadioButton("Vertebrat");
                vertebrat.setToggleGroup(tipusVertebrat);
                vertebrat.setUserData("vertebrat");

                invertebrat = new RadioButton("Invertebrat");
                invertebrat.setToggleGroup(tipusVertebrat);
                invertebrat.setUserData("invertebrat");


                GridPane.setConstraints(etiquetaVertebrat, 0, 5);
                GridPane.setConstraints(vertebrat, 1, 5);
                GridPane.setConstraints(invertebrat, 2, 5);        
                dadesVeure.getChildren().addAll(etiquetaVertebrat,vertebrat,invertebrat);

                esp_vida = new TextField();
                esp_vida.setAlignment(Pos.CENTER_RIGHT);
                etiquetaEsp_vida = new Label("Esperança de Vida");
                esp_vida.setEditable(true);
                GridPane.setConstraints(etiquetaEsp_vida, 0, 6);
                GridPane.setConstraints(esp_vida, 1, 6);
                dadesEditar.getChildren().addAll(etiquetaEsp_vida, esp_vida);

                seccio = new TextField();
                seccio.setAlignment(Pos.CENTER_RIGHT);
                etiquetaSeccio = new Label("Seccio");
                seccio.setEditable(true);
                GridPane.setConstraints(etiquetaSeccio, 0, 7);
                GridPane.setConstraints(seccio, 1, 7);
                dadesVeure.getChildren().addAll(etiquetaSeccio, seccio);

                //////////// radiobutton sexe
                genere = new ToggleGroup();
                etiquetaGenere = new Label("Genere");

                femeni = new RadioButton("Femení");
                femeni.setToggleGroup(genere);
                femeni.setUserData("Femeni");

                masculi = new RadioButton("Masculí");
                masculi.setToggleGroup(genere);
                masculi.setUserData("Masculí");


                GridPane.setConstraints(etiquetaGenere, 0, 8);
                GridPane.setConstraints(femeni, 1, 8);
                GridPane.setConstraints(masculi, 2, 8);        
                dadesVeure.getChildren().addAll(etiquetaGenere,femeni,masculi);


                //////////// crea desplegable i etiqueta
                alimentacio = new ChoiceBox<>();
                etiquetaAlimentacio = new Label("Alimentacio");

                //getItems returns the Observable object wich u can add items to
                alimentacio.getItems().add("Herbívor");
                alimentacio.getItems().add("Carnívor");
                alimentacio.getItems().add("Omnívor");

                //Set default value
                alimentacio.setValue("Omnívor");

                GridPane.setConstraints(etiquetaAlimentacio, 0, 9);
                GridPane.setConstraints(alimentacio, 1, 9);
                dadesVeure.getChildren().addAll(etiquetaAlimentacio,alimentacio);

                //////////// crea desplegable i etiqueta
                 ecosistema = new ChoiceBox<>();
                etiquetaEcosistema = new Label("Ecosistema");

                //getItems returns the Observable object wich u can add items to
                ecosistema.getItems().add("Terrestre");
                ecosistema.getItems().add("Aeri");
                ecosistema.getItems().add("Aquàtic");

                //Set default value
                ecosistema.setValue("Terrestre");

                GridPane.setConstraints(etiquetaEcosistema, 0, 10);
                GridPane.setConstraints(ecosistema, 1, 10);
                dadesVeure.getChildren().addAll(etiquetaEcosistema,ecosistema);

                //////////// crea desplegable i etiqueta
                reproduccio = new ChoiceBox<>();
                etiquetaReproduccio = new Label("Reproducció");

                //getItems returns the Observable object wich u can add items to
                reproduccio.getItems().add("Ovíper");
                reproduccio.getItems().add("Vivíper");

                //Set default value
                reproduccio.setValue("Vivíper");

                GridPane.setConstraints(etiquetaReproduccio, 0, 11);
                GridPane.setConstraints(reproduccio, 1, 11);
                dadesVeure.getChildren().addAll(etiquetaReproduccio,reproduccio);

                ////////////radiobutton vacuna
                //vacunacio = new Check<>();
                etiquetaVacunacio = new Label("Vacunes");

                rabia = new CheckBox("Rabia");
                colera = new CheckBox("Colera");
                colera.setSelected(true); //per defecte aquesta apareix marcada
                sifilis = new CheckBox("Sifilis");
                parkinson = new CheckBox("Parkinson");

                GridPane.setConstraints(etiquetaVacunacio, 0, 12);
                GridPane.setConstraints(rabia, 1, 12);
                GridPane.setConstraints(colera, 1, 13);
                GridPane.setConstraints(sifilis, 1, 14);
                GridPane.setConstraints(parkinson, 1, 15);
                dadesVeure.getChildren().addAll(etiquetaVacunacio,rabia,colera,sifilis,parkinson);


            
//Inic contingut dreta grid
            
          //Final contingut dreta grid   
//final contingut tab2
                /*llista*/
            sup2.setContent(pDividit); // contingut de la tab1
            mSuperior.getTabs().add(sup2); //afegeix la tab1 al panell d tabs
            
        // ocupa tot el espai disponible
        mSuperior.prefHeightProperty().bind(escena.heightProperty());
        mSuperior.prefWidthProperty().bind(escena.widthProperty());
        
        //borderPane.setCenter(tabPane);
        //borderPane.getChildren().add(borderPane);
        primaryStage.setScene(escena);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
