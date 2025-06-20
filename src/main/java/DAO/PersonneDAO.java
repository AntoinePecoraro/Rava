package DAO;

import Entity.Personne;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class PersonneDAO extends DAO<Personne> {


    @Override
    protected String getFilename() {
        return "./src/ressources/saveFiles/personnes.dat";
    }

    public boolean existByUsername(String username) {
        return elements.values()
                .stream()
                .anyMatch(personne -> personne.getUsername().equals(username));
    }

    public Personne findByUsername(String username) {
        return elements.values()
                .stream()
                .filter(personne -> personne.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean setPhotoFromPath(int personneId, String cheminPhoto) {
        Personne personne = read(personneId);
        if (personne == null) {
            return false;
        }

        try {
            BufferedImage image = null;
            if (cheminPhoto != null && !cheminPhoto.isEmpty()) {
                image = ImageIO.read(new File(cheminPhoto));
            }
            personne.setPhoto(image);
            return update(personne);
        } catch (IOException e) {
            System.err.println("Impossible de charger la photo: " + e.getMessage());
            return false;
        }
    }
}
