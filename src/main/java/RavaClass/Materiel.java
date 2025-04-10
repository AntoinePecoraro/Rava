package RavaClass;

import java.util.Objects;

public class Materiel {
    private String marque = null;
    private String modele = null;

    public Materiel() {
    }

    public Materiel(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
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
    //endregion

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Materiel materiel = (Materiel) o;
        return Objects.equals(getMarque(), materiel.getMarque()) && Objects.equals(getModele(), materiel.getModele());
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "marque= " + marque +
                ", modele= " + modele +
                '}';
    }
}
