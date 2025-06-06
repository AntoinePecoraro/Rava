package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame {

    // Composants pour l'onglet connexion
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Composants pour l'onglet création de compte
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JButton createAccountButton;

    // Bouton commun
    private JButton cancelButton;

    public LoginInterface() {
        // Configuration de la fenêtre
        setTitle("Connexion - Application");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Création du panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Création du JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Onglet connexion
        JPanel loginPanel = createLoginPanel();
        tabbedPane.addTab("Se connecter", loginPanel);

        // Onglet création de compte
        JPanel registerPanel = createRegisterPanel();
        tabbedPane.addTab("Créer un compte", registerPanel);

        // Panneau pour le bouton annuler (commun aux deux onglets)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cancelButton = new JButton("Annuler");
        bottomPanel.add(cancelButton);

        // Ajout des composants au panneau principal
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajout du conteneur principal à la fenêtre
        add(mainPanel);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panneau pour les champs de saisie avec GridBagLayout pour un meilleur contrôle
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        // Ajout des composants de connexion
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Nom d'utilisateur:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        usernameField = new JTextField(15);
        usernameField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        passwordField = new JPasswordField(15);
        passwordField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(passwordField, gbc);

        // Panneau pour le bouton de connexion
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Se connecter");
        buttonPanel.add(loginButton);

        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panneau pour les champs de saisie avec GridBagLayout
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);

        // Ajout des composants de création de compte
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Prénom:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        firstNameField = new JTextField(15);
        firstNameField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Nom:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        lastNameField = new JTextField(15);
        lastNameField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Nom d'utilisateur:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        newUsernameField = new JTextField(15);
        newUsernameField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(newUsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        newPasswordField = new JPasswordField(15);
        newPasswordField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Confirmer mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        confirmPasswordField = new JPasswordField(15);
        confirmPasswordField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(confirmPasswordField, gbc);

        // Panneau pour le bouton de création
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        createAccountButton = new JButton("Créer le compte");
        buttonPanel.add(createAccountButton);

        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Getters pour récupérer les valeurs des champs (connexion)
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Getters pour récupérer les valeurs des champs (création de compte)
    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getNewUsername() {
        return newUsernameField.getText();
    }

    public String getNewPassword() {
        return new String(newPasswordField.getPassword());
    }

    public String getConfirmPassword() {
        return new String(confirmPasswordField.getPassword());
    }

    // Getters pour les boutons (pour identifier quelle action a été effectuée)
    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    // Méthodes utilitaires pour vider les champs
    public void clearLoginFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public void clearRegisterFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        newUsernameField.setText("");
        newPasswordField.setText("");
        confirmPasswordField.setText("");
    }

    public void addActionListeners(ActionListener listener) {
        cancelButton.addActionListener(listener);
        loginButton.addActionListener(listener);
    }
}