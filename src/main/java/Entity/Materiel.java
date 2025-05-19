package Entity;

import java.io.Serializable;
import java.util.Objects;

public class Materiel implements Identifiable, Serializable {
    private String marque = null;
    private String modele = null;
    private int id = 0;

    public Materiel() {
    }

    public Materiel(String marque, String modele, int id) {
        this.marque = marque;
        this.modele = modele;
        this.id = id;
    }

    //region Setter et Getter
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Materiel materiel = (Materiel) o;
        return Objects.equals(getId(), materiel.getId());
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "marque= " + marque +
                ", modele= " + modele +
                '}';
    }
}
