package Entity;

import java.time.LocalDate;

public final class APied extends Activite {
    private int nbPas = 0;

    public APied() {
        super();
    }

    public APied(String nom, int duree, int distance, int nbPas, int id, LocalDate date, int idPersonne, String materiel) {
        super(nom, duree, distance, id, date, idPersonne, materiel);
        this.nbPas = nbPas;
    }

    //region Setter et Getter
    public int getNbPas() {
        return nbPas;
    }
    //endregion


    @Override
    public String toString() {
        return "APied{" +
                "id= " + id +
                ", nom= " + nom +
                ", duree= " + duree +
                ", date= " + date +
                ", distance= " + distance +
                ", nbPas= " + nbPas +
                '}';
    }
}
