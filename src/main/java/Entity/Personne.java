package Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.awt.image.BufferedImage;

public class Personne implements Identifiable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nom = "Doe";
    private String prenom = "John";
    private String username = "JohnDoe";
    private char sexe = 'M';
    private BufferedImage photo = null;
    private int id = 0;

    //region Constructeurs
    public Personne() {

    }

    public Personne(String nom, String prenom, String username, char sexe, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;

        this.sexe = sexe;
        this.id = id;
        if (this.sexe != 'M' && this.sexe != 'F' && this.sexe != 'N') {
            this.sexe = 'M';
        }
    }

    public Personne(String nom, String prenom, String username, char sexe, int id, BufferedImage photo) {
        this(nom, prenom, username, sexe, id);
        this.photo = photo;
    }
    //endregion

    //region Setter et Getter
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public BufferedImage getPhoto() {
        return photo;
    }

    public void setPhoto(BufferedImage photo) {
        this.photo = photo;
    }

    public String getUsername()
    {
        return username;
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
        Personne personne = (Personne) o;
        return Objects.equals(getId(), personne.getId());
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom= " + nom +
                ", prenom= " + prenom +
                ", sexe= " + sexe +
                ", photo= " + (photo != null ? "présente" : "absente") +
                '}';
    }
}
