package RavaClass;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Activite {
    protected String nom = null;
    protected int duree = 0; // En minute
    protected int distance = 0; // En mètre
    protected int id = 0;
    protected LocalDate date = LocalDate.now();

    public Activite() {
    }

    public Activite(String nom, int duree, int distance, int id, LocalDate date) {
        this.nom = nom;
        this.duree = duree;
        this.distance = distance;
        this.id = id;
        this.date = date;
    }

    //region Setter et Getter
    public String getNom() {
        return nom;
    }

    public int getDuree() {
        return duree;
    }

    public int getDistance() {
        return distance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Activite activite = (Activite) o;
        return getId() == activite.getId();
    }
}
