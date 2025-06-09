package Authentication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAuthenticator extends Authenticator {

    private final String filePath;
    private final Map<String, String> userData = new HashMap<>();

    public FileAuthenticator(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    @Override
    protected boolean isLoginExists(String username) {
        return userData.containsKey(username);
    }

    @Override
    protected String getPassword(String username) {
        return userData.get(username);
    }

    public void addUser(String username, String password) {
        userData.put(username, password);
        saveToFile();
    }

    public void removeUser(String username) {
        userData.remove(username);
        saveToFile();
    }

    private void loadFromFile() {
        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
                return;
            }

            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(filePath)) {
                properties.load(fis);
            }

            for (String key : properties.stringPropertyNames()) {
                userData.put(key, properties.getProperty(key));
            }

        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try {
            Properties properties = new Properties();

            // Copier les données de la HashMap vers Properties
            for (Map.Entry<String, String> entry : userData.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                properties.store(fos, "Données d'authentification");
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde du fichier: " + e.getMessage());
        }
    }

    public int getUserCount() {
        return userData.size();
    }

    public boolean isEmpty() {
        return userData.isEmpty();
    }
}