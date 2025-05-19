package Entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Activite implements Identifiable, Serializable {
    protected String nom = null;
    protected int duree = 0; // En minute
    protected int distance = 0; // En mètre
    protected int id = 0;
    protected LocalDate date = LocalDate.now();
    protected int idPersonne = 0;
    protected int idMateriel = 0;

    public Activite() {
    }

    public Activite(String nom, int duree, int distance, int id, LocalDate date, int idPersonne, int idMateriel) {
        this.nom = nom;
        this.duree = duree;
        this.distance = distance;
        this.id = id;
        this.date = date;
        this.idPersonne = idPersonne;
        this.idMateriel = idMateriel;
        if (this.duree < 0) {
            this.duree = 0;
        }
        if (this.distance < 0) {
            this.distance = 0;
        }
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

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
