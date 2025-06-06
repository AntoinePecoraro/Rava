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
    private int age = 21;
    private int weight = 70;
    private char sexe = 'M';
    private BufferedImage photo = null;
    private int id = 0;

    //region Constructeurs
    public Personne() {

    }

    public Personne(String nom, String prenom, int age, int weight, char sexe, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.weight = weight;
        this.sexe = sexe;
        this.id = id;
        if (this.sexe != 'M' && this.sexe != 'F') {
            this.sexe = 'M';
        }
        if (this.age < 0) {
            this.age = 0;
        }
        if (this.weight < 0) {
            this.weight = 0;
        }
    }

    public Personne(String nom, String prenom, int age, int weight, char sexe, int id, BufferedImage photo) {
        this(nom, prenom, age, weight, sexe, id);
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

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public char getSexe() {
        return sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BufferedImage getPhoto() {
        return photo;
    }

    public void setPhoto(BufferedImage photo) {
        this.photo = photo;
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
                ", age= " + age +
                ", weight= " + weight +
                ", photo= " + (photo != null ? "présente" : "absente") +
                '}';
    }
}
