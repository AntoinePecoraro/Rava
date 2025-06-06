package Controller;

import DAO.PersonneDAO;
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
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RavaController implements ActionListener {
    private RavaModel model;
    private ApplicationInterface view;
    private LoginInterface loginView;
    private boolean isConnected = false;
    private int connectedId = -1;

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
                recherche();
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

    public void recherche() {
        List<Activite> activites = model.getActiviteDAO().readAll();
        List<Object[]> lignes = new ArrayList<>();

        if(!view.getGlobal() && isConnected == true)
        {
            for(Activite activite : activites)
            {
                if (activite.getIdPersonne() != connectedId)
                {
                    activites.remove(activite);
                }
            }
        }

        if(!view.getSexe().equals("Tous les sexes"))
        {
            String sexe = view.getSexe();

            if(sexe.equals("Masculin"))
            {
                for(Activite activite : activites)
                {
                    if(model.getPersonneDAO().read(activite.getIdPersonne()).getSexe() == 'F')
                    {
                        activites.remove(activite);
                    }
                }
            }
            else
            {
                for(Activite activite : activites)
                {
                    if(model.getPersonneDAO().read(activite.getIdPersonne()).getSexe() == 'M')
                    {
                        activites.remove(activite);
                    }
                }
            }
        }

        if(!view.getSport().equals("Tous les sports"))
        {
            String sport = view.getSport();

            if(sport.equals("Cyclisme"))
            {
                for(Activite activite : activites)
                {
                    if(activite instanceof APied)
                    {
                        activites.remove(activite);
                    }
                }
            }
            else
            {
                for(Activite activite : activites)
                {
                    if(activite instanceof AVelo)
                    {
                        activites.remove(activite);
                    }
                }
            }
        }

        if(view.getFilter().equals("Par nom"))
        {
            activites.sort(Comparator.comparing(Activite::getNom));
        }
        else if (view.getFilter().equals("Par Distance"))
        {
            activites.sort(Comparator.comparing(Activite::getDistance));
        }
        else
        {
            activites.sort(Comparator.comparing(Activite::getDate));
        }

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
