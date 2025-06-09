package Model;

import DAO.*;
import Authentication.*;

public class RavaModel {
    private static RavaModel instance = null;

    private PersonneDAO personneDAO;
    private MaterielDAO materielDAO;
    private ActiviteDAO activiteDAO;
    private FileAuthenticator fileAuthenticator;

    private RavaModel() {
        personneDAO = new PersonneDAO();
        materielDAO = new MaterielDAO();
        activiteDAO = new ActiviteDAO();
        fileAuthenticator = new FileAuthenticator("./src/ressources/saveFiles/authenticator.properties");
    }

    public static RavaModel getInstance() {
        if (instance == null) {
            instance = new RavaModel();
        }
        return instance;
    }

    public PersonneDAO getPersonneDAO() {
        return personneDAO;
    }

    public MaterielDAO getMaterielDAO() {
        return materielDAO;
    }

    public ActiviteDAO getActiviteDAO() {
        return activiteDAO;
    }

    public FileAuthenticator getFileAuthenticator() {
        return fileAuthenticator;
    }
}
