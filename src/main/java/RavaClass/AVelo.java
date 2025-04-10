package RavaClass;

import java.time.LocalDate;

public final class AVelo extends Activite {
    private int watt = 0;

    public AVelo() {
        super();
    }

    public AVelo(String nom, int duree, int distance, int watt, int id, LocalDate date) {
        super(nom, duree, distance, id, date);
        this.watt = watt;
    }

    //region Setter et Getter
    public int getWatt() {
        return watt;
    }
    //endregion

    @Override
    public String toString() {
        return "AVelo{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", date=" + date +
                ", distance=" + distance +
                ", watt=" + watt +
                '}';
    }
}