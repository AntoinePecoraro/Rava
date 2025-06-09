package Controller;

import DAO.PersonneDAO;
import Entity.APied;
import Entity.AVelo;
import Entity.Activite;
import Entity.Personne;
import Model.RavaModel;
import View.AddActivity;
import View.ApplicationInterface;
import View.LoginInterface;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RavaController implements ActionListener {
    private RavaModel model;
    private ApplicationInterface view;
    private LoginInterface loginView;
    private AddActivity addView;
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
                if(loginView == null)
                {
                    loginView = new LoginInterface();
                    loginView.setVisible(true);
                    loginView.addActionListeners(this);

                    loginView.setWindowCloseListener(new AddActivity.WindowCloseListener() {
                        @Override
                        public void onWindowClosed() {
                            loginView = null;
                        }
                    });
                }
                break;
            case "Ajouter":
                if(addView == null)
                {
                    if (isConnected)
                    {
                        addView = new AddActivity();
                        addView.setVisible(true);
                        addView.addActionListeners(this);

                        addView.setWindowCloseListener(new AddActivity.WindowCloseListener() {
                            @Override
                            public void onWindowClosed() {
                                addView = null;
                            }
                        });
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(view, "Vous devez être connecté pour ajouter une activité");
                    }
                }
                break;
            case "Ajouter l'activité à vélo":
                if(validateAVeloInput())
                {
                    model.getActiviteDAO().create(new AVelo(addView.getNomActiviteVelo(), Integer.parseInt(addView.getDureeVelo()), Integer.parseInt(addView.getDistanceVelo()), Integer.parseInt(addView.getPuissanceMoyenne()), 0, LocalDate.now(), connectedId, addView.getVeloSelectionne()));
                    addView.dispose();
                    addView = null;
                    recherche();
                }
                break;
            case "Ajouter l'activité à pieds":
                if(validateAPiedInput())
                {
                    model.getActiviteDAO().create(new APied(addView.getNomActivitePieds(), Integer.parseInt(addView.getDureePieds()), Integer.parseInt(addView.getDistancePieds()), Integer.parseInt(addView.getNbPas()), 0, LocalDate.now(), connectedId, addView.getChaussuresSelectionnees()));
                    addView.dispose();
                    addView = null;
                    recherche();
                }
                break;
            case "Se connecter":
                if(model.getFileAuthenticator().authenticate(loginView.getUsername(), loginView.getPassword()))
                {
                    isConnected = true;
                    connectedId = model.getPersonneDAO().findByUsername(loginView.getUsername()).getId();
                    loginView.dispose();
                    loginView = null;
                    JOptionPane.showMessageDialog(view, "Bienvenue !");
                }
                else
                {
                    JOptionPane.showMessageDialog(loginView, "L'utilisateur ou le mot de passe est incorrecte");
                }
                break;
            case "Créer le compte":
                if(validateRegisterInput())
                {
                    char sexe;
                    if(loginView.getSelectedGender().equals("Homme"))
                    {
                        sexe = 'M';
                    }
                    else if(loginView.getSelectedGender().equals("Femme"))
                    {
                        sexe = 'F';
                    }
                    else
                    {
                        sexe = 'N';
                    }
                    if(!model.getPersonneDAO().existByUsername(loginView.getNewUsername()))
                    {
                        model.getPersonneDAO().create(new Personne(loginView.getLastName(), loginView.getFirstName(), loginView.getNewUsername(), sexe, 0));
                        model.getFileAuthenticator().addUser(loginView.getNewUsername(), loginView.getNewPassword());
                        loginView.dispose();
                        loginView = null;
                        JOptionPane.showMessageDialog(view, "Bienvenue ! veuillez vous connecter");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(view, "Cet utilisateur existe déjà");
                    }
                }
                break;
            case "Annuler":
                if(loginView != null) {
                    loginView.setVisible(false);
                    loginView = null;
                }
                if(addView != null) {
                    addView.setVisible(false);
                    addView = null;
                }
                break;
            default:
                break;
        }
    }

    public void recherche() {
        List<Activite> activites = model.getActiviteDAO().readAll();

        if (!view.getGlobal() && isConnected) {
            activites = activites.stream()
                    .filter(a -> a.getIdPersonne() == connectedId)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (!view.getSexe().equals("Tous les sexes")) {
            char sexeRecherche = view.getSexe().equals("Masculin") ? 'M' : 'F';
            activites = activites.stream()
                    .filter(a -> model.getPersonneDAO().read(a.getIdPersonne()).getSexe() == sexeRecherche)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (!view.getSport().equals("Tous les sports")) {
            if (view.getSport().equals("Cyclisme")) {
                activites = activites.stream()
                        .filter(a -> a instanceof AVelo)
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                activites = activites.stream()
                        .filter(a -> a instanceof APied)
                        .collect(Collectors.toCollection(ArrayList::new));
            }
        }

        switch (view.getFilter()) {
            case "Par nom" -> activites.sort(Comparator.comparing(Activite::getNom));
            case "Par Distance" -> activites.sort(Comparator.comparing(Activite::getDistance));
            default -> activites.sort(Comparator.comparing(Activite::getDate));
        }

        List<Object[]> lignes = new ArrayList<>();

        for (Activite activite : activites) {
            Personne sportif = model.getPersonneDAO().read(activite.getIdPersonne());
            Object[] ligne;

            if (activite instanceof AVelo velo) {
                ligne = new Object[]{
                        activite.getId(), activite.getNom(),
                        sportif.getNom() + " " + sportif.getPrenom() + "\t" + sportif.getSexe(),
                        activite.getDistance() + " km",
                        activite.getDate(), "\\", velo.getWatt() + " W"
                };
            } else {
                APied aPied = (APied) activite;
                ligne = new Object[]{
                        activite.getId(), activite.getNom(),
                        sportif.getNom() + " " + sportif.getPrenom() + "\t" + sportif.getSexe(),
                        activite.getDistance() + " km",
                        activite.getDate(), aPied.getNbPas(), "\\"
                };
            }

            lignes.add(ligne);
        }

        view.afficheActivite(lignes);
    }

    private boolean validateRegisterInput()
    {
        if(loginView.getFirstName().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un prénom");
            return false;
        }
        if(loginView.getLastName().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un nom");
            return false;
        }
        if(loginView.getNewUsername().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un nom d'utilisateur");
        }
        if(loginView.getNewPassword().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un mot de passe");
            return false;
        }
        if(!loginView.getConfirmPassword().equals(loginView.getNewPassword()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez répétez le bon mot de passe");
            return false;
        }
        return true;
    }

    private boolean validateAVeloInput()
    {
        if(addView.getNomActiviteVelo().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un nom d'activité");
            return false;
        }
        if(!isNum(addView.getDureeVelo()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez une durée");
            return false;
        }
        if(!isNum(addView.getDistanceVelo()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez une distance");
            return false;
        }
        if(!isNum(addView.getPuissanceMoyenne()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez une puissance");
            return false;
        }
        return true;
    }

    private boolean validateAPiedInput()
    {
        if(addView.getNomActivitePieds().isEmpty())
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un nom d'activité");
            return false;
        }
        if(!isNum(addView.getDureePieds()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez une durée");
            return false;
        }
        if(!isNum(addView.getDistancePieds()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez une distance");
            return false;
        }
        if(!isNum(addView.getNbPas()))
        {
            JOptionPane.showMessageDialog(loginView, "Veuillez insérez un nombre de pas");
            return false;
        }
        return true;
    }

    public boolean isNum(String string) {
        return string != null && string.matches("\\d+") && !string.isEmpty();
    }
}
