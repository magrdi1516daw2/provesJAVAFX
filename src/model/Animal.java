package model;

import java.util.ArrayList;

/**
 * Creació de la classe diferida Animal
 */
public abstract class Animal {
    
    protected int id;
    protected String nom;
    protected String raça;
    protected int edat;
    protected String femeni;
    protected int pes;
    protected int esp_vida;
    protected String vertebrat;
    protected String alimentacio;
    protected String reproduccio;
    protected String ecosistema;
    protected String vacuna_id;
    protected int seccio;
    
    public abstract void reproduir(Animal pare, Animal mare, ArrayList <Animal> llista);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRaça() {
        return raça;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getFemeni() {
        return femeni;
    }

    public void setFemeni(String femeni) {
        this.femeni = femeni;
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public int getEsp_vida() {
        return esp_vida;
    }

    public void setEsp_vida(int esp_vida) {
        this.esp_vida = esp_vida;
    }

    public String getVertebrat() {
        return vertebrat;
    }

    public void setVertebrat(String vertebrat) {
        this.vertebrat = vertebrat;
    }

    public String getAlimentacio() {
        return alimentacio;
    }

    public void setAlimentacio(String alimentacio) {
        this.alimentacio = alimentacio;
    }

    public String getReproduccio() {
        return reproduccio;
    }

    public void setReproduccio(String reproduccio) {
        this.reproduccio = reproduccio;
    }

    public String getEcosistema() {
        return ecosistema;
    }

    public void setEcosistema(String ecosistema) {
        this.ecosistema = ecosistema;
    }

    public String getVacuna_id() {
        return vacuna_id;
    }

    public void getVacuna_id(String vacuna_id) {
        this.vacuna_id = vacuna_id;
    }

    public int getSeccio() {
        return seccio;
    }

    public void setSeccio(int seccio) {
        this.seccio = seccio;
    }
    
    

}
