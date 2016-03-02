package model;

import java.util.ArrayList;

/**
 * Creació de la classe que fa una implementació de la interfície Cuidador
 */

public class CuidadorImpl implements Cuidador {

    /**
     * @see Cuidador 
     */
    @Override
    public void netejar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal) {
    }

    /**
     * @see Cuidador 
     */
    @Override
    public void alimentar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal, String tipus_aliment) {
    }
    
    @Override
    public void reproduir(String tipus, Animal pare, Animal mare, ArrayList <Animal> llista, String nouNom){
    }
    
}
