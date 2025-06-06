package Controller;

import Entity.APied;
import Entity.AVelo;
import Entity.Activite;
import Entity.Personne;
import Model.RavaModel;
import View.ApplicationInterface;
import View.LoginInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class RavaController implements ActionListener {
    private RavaModel model;
    private ApplicationInterface view;
    private LoginInterface loginView;

    public RavaController(ApplicationInterface view) {
        this.model = RavaModel.getInstance();
        this.view = view;
        this.view.addActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        System.out.println(commande);
        switch (commande) {
            case "Recherche":
                break;
            case "Login":
                loginView = new LoginInterface();
                loginView.setVisible(true);
                loginView.addActionListeners(this);
                break;
            case "Quitter":
                System.exit(0);
                break;
            case "Se connecter":
                break;
            case "Annuler":
                System.out.println("so sigma");
                loginView.setVisible(false);
                loginView = null;
                break;
            default:
        }
    }

    public void afficherActivites() {
        List<Activite> activites = model.getActiviteDAO().readAll();
        List<Object[]> lignes = new ArrayList<>();

        for (Activite activite: activites) {
            Personne sportif = model.getPersonneDAO().read(activite.getIdPersonne());

            Object[] ligne;

            if (activite instanceof AVelo){
                ligne = new Object[]{activite.getId(), activite.getNom(), sportif.getNom() + " " + sportif.getPrenom() + "\t" + sportif.getSexe(), activite.getDistance() + " km", "\\", activite.getDate(), ((AVelo) activite).getWatt() + " W"};
            } else{
                ligne = new Object[]{activite.getId(), activite.getNom(), sportif.getNom() + " " + sportif.getPrenom() + "\t" + sportif.getSexe(), activite.getDistance() + " km", activite.getDate(), ((APied) activite).getNbPas(), "\\"};
            }

            lignes.add(ligne);
        }

        view.afficheActivite(lignes);
    }

}
