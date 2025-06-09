package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    // Boutons radio pour le sexe
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    private ButtonGroup genderButtonGroup;

    // Bouton commun
    private JButton cancelButton;

    public interface WindowCloseListener {
        void onWindowClosed();
    }

    private AddActivity.WindowCloseListener closeListener;

    public LoginInterface() {
        // Configuration de la fenêtre
        setTitle("Connexion - Application");
        setSize(420, 600); // Augmentation de la hauteur pour accommoder les nouveaux champs
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (closeListener != null) {
                    closeListener.onWindowClosed();
                }
            }
        });

        // Création du panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Header page
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Création du JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Onglet connexion
        JPanel loginPanel = createLoginPanel();
        tabbedPane.addTab("Se connecter", loginPanel);

        // Onglet création de compte
        JPanel registerPanel = createRegisterPanel();
        tabbedPane.addTab("Créer un compte", registerPanel);

        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // Footer avec bouton intégré
        JPanel footerPanel = createFooterPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Ajout du conteneur principal à la fenêtre
        add(mainPanel);
    }

    public void setWindowCloseListener(AddActivity.WindowCloseListener listener) {
        this.closeListener = listener;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(30, 144, 255)); // DodgerBlue
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Connexion - Application");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        headerPanel.add(titleLabel);
        return headerPanel;
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

        // Ajout de la sélection du sexe
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Sexe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JPanel genderPanel = createGenderPanel();
        fieldsPanel.add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Nom d'utilisateur:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        newUsernameField = new JTextField(15);
        newUsernameField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(newUsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        fieldsPanel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        newPasswordField = new JPasswordField(15);
        newPasswordField.setPreferredSize(new Dimension(200, 25));
        fieldsPanel.add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
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

    private JPanel createGenderPanel() {
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Création des boutons radio
        maleRadioButton = new JRadioButton("Homme");
        maleRadioButton.setSelected(true);
        femaleRadioButton = new JRadioButton("Femme");
        otherRadioButton = new JRadioButton("Autre");

        // Création du groupe pour les boutons radio (un seul peut être sélectionné)
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        // Ajout des boutons au panneau
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(otherRadioButton);

        return genderPanel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(211, 211, 211)); // LightGray
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panneau pour le bouton à droite
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(211, 211, 211));

        cancelButton = new JButton("Annuler");
        cancelButton.setBackground(Color.GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(100, 30));
        cancelButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);

        buttonPanel.add(cancelButton);
        footerPanel.add(buttonPanel, BorderLayout.CENTER);

        return footerPanel;
    }

    public void addActionListeners(ActionListener listener) {
        cancelButton.addActionListener(listener);
        loginButton.addActionListener(listener);
        createAccountButton.addActionListener(listener);
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

    // Nouveau getter pour récupérer le sexe sélectionné
    public String getSelectedGender() {
        if (maleRadioButton.isSelected()) {
            return "Homme";
        } else if (femaleRadioButton.isSelected()) {
            return "Femme";
        } else if (otherRadioButton.isSelected()) {
            return "Autre";
        } else {
            return null; // Aucune sélection
        }
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
        // Désélectionner tous les boutons radio
        genderButtonGroup.clearSelection();
    }
}