package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginInterface() {
        // Configuration de la fenêtre
        setTitle("Page de login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Création du panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panneau pour les champs de saisie
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        // Ajout des composants
        fieldsPanel.add(new JLabel("Nom d'utilisateur:"));
        usernameField = new JTextField(15);
        fieldsPanel.add(usernameField);

        fieldsPanel.add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField(15);
        fieldsPanel.add(passwordField);
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Panneau pour les boutons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");

        buttonsPanel.add(loginButton);
        buttonsPanel.add(cancelButton);

        // Ajout des panneaux au conteneur principal
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        

        // Ajout du conteneur principal à la fenêtre
        add(mainPanel);

    }

    public void addActionListeners(ActionListener listener) {
        cancelButton.addActionListener(listener);
        loginButton.addActionListener(listener);
    }
}