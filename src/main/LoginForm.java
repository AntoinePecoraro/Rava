import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginForm() {
        // Configuration de la fenêtre
        setTitle("Page de login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        // Gestionnaires d'événements
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Ici, ajoutez votre logique d'authentification
                JOptionPane.showMessageDialog(LoginForm.this,
                        "Tentative de connexion avec:\nUtilisateur: " + username);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}