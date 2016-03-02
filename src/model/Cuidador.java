package model;

import java.util.ArrayList;

/**
 * Interfície anomenada Cuidador
 */

public interface Cuidador {
    
    /**
     * Es neteja a un animal
     * @param ID_encarregat
     * @param nom_encarregat
     * @param ID_animal
     * @param nom_animal 
     */
    public void netejar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal);
    
    
    /**
     * S'alimenta a un animal segons el tipus d'aliment
     * @param ID_encarregat
     * @param nom_encarregat
     * @param ID_animal
     * @param nom_animal
     * @param tipus_aliment 
     */
    public void alimentar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal, String tipus_aliment);
    
    
    public void reproduir(String tipus, Animal pare, Animal mare, ArrayList <Animal> llista, String nouNom);
    
}
