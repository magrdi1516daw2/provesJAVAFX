package model;

public class Vacuna {
    
    protected String nom;
    protected String data;
    protected String cuantitat;
    

    public Vacuna(String nom, String data, String cuantitat) {
        this.nom = nom;
        this.data = data;
        this.cuantitat = cuantitat;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public String getCuantitat() {
        return cuantitat;
    }

    public void setCuantitat(String cuantitat) {
        this.cuantitat = cuantitat;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "nom=" + nom + ", data=" + data + ", cuantitat=" + cuantitat + '}';
    }

}
