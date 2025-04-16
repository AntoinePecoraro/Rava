package RavaClass;

import java.util.Objects;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Personne {
    private String nom = "Doe";
    private String prenom = "John";
    private int age = 21;
    private int weight = 70;
    private char sexe = 'M';
    private BufferedImage photo = null;

    public Personne() {

    }

    public Personne(String nom, String prenom, int age, int weight, char sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.weight = weight;
        this.sexe = sexe;
    }

    public Personne(String nom, String prenom, int age, int weight, char sexe, BufferedImage photo) {
        this(nom, prenom, age, weight, sexe);
        this.photo = photo;
    }

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

    public boolean setPhotoFromPath(String path) {
        if (path == null || path.isEmpty()) {
            this.photo = null;
            return true;
        }

        try {
            this.photo = ImageIO.read(new File(path));
            return true;
        } catch (IOException e) {
            System.err.println("Impossible de charger la photo : " + e.getMessage());
            return false;
        }
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(getNom(), personne.getNom()) && Objects.equals(getPrenom(), personne.getPrenom());
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
