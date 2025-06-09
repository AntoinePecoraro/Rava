package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddActivity extends JFrame {

    // Composants pour l'onglet activité vélo
    private JTextField nomActiviteVeloField;
    private JTextField distanceVeloField;
    private JTextField dureeVeloField;
    private JTextField puissanceMoyenneField;
    private JComboBox<String> veloComboBox;
    private JButton ajouterVeloButton;

    // Composants pour l'onglet activité pieds
    private JTextField nomActivitePiedsField;
    private JTextField distancePiedsField;
    private JTextField dureePiedsField;
    private JTextField nbPasField;
    private JComboBox<String> chaussuresComboBox;
    private JButton ajouterPiedsButton;

    // Bouton commun
    private JButton cancelButton;

    // Interface pour notifier la fermeture
    public interface WindowCloseListener {
        void onWindowClosed();
    }

    private WindowCloseListener closeListener;

    public AddActivity() {
        // Configuration de la fenêtre
        setTitle("Ajout d'une activité - Application");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Ajout du WindowListener pour détecter la fermeture
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

        // Header avec style similaire
        JPanel headerPanel = createHeaderPanel();

        // Création du JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Onglet activité vélo
        JPanel veloPanel = createVeloPanel();
        tabbedPane.addTab("Activité à vélo", veloPanel);

        // Onglet activité pieds
        JPanel piedsPanel = createPiedsPanel();
        tabbedPane.addTab("Activité à pieds", piedsPanel);

        // Footer avec bouton annuler
        JPanel footerPanel = createFooterPanel();

        // Ajout des composants au panneau principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Ajout du conteneur principal à la fenêtre
        add(mainPanel);
    }

    public void setWindowCloseListener(WindowCloseListener listener) {
        this.closeListener = listener;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(30, 144, 255)); // DodgerBlue
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Ajout d'une activité");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);

        headerPanel.add(titleLabel);
        return headerPanel;
    }

    private JPanel createVeloPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ScrollPane pour le contenu
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);

        // Titre de la section
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("Ajout d'une activité à vélo");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        contentPanel.add(titleLabel, gbc);

        // Reset gridwidth
        gbc.gridwidth = 1;

        // Nom de l'activité
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Nom de l'activité :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        nomActiviteVeloField = new JTextField(15);
        nomActiviteVeloField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(nomActiviteVeloField, gbc);

        // Distance parcourue
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Distance parcourue :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        distanceVeloField = new JTextField(15);
        distanceVeloField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(distanceVeloField, gbc);

        // Durée de l'activité
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Durée de l'activité :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        dureeVeloField = new JTextField(15);
        dureeVeloField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(dureeVeloField, gbc);

        // Puissance moyenne
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Puissance moyenne :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        puissanceMoyenneField = new JTextField(15);
        puissanceMoyenneField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(puissanceMoyenneField, gbc);

        // Vélo utilisé
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Vélo utilisé :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        String[] velos = {
                "Orbea Orca M30",
                "Trek Madone SL7",
                "Colnago V5RS",
                "Specialized Tarmac SL7",
                "Cannondale SuperSix EVO",
                "Bianchi Oltre XR4",
                "Pinarello Dogma F12"
        };
        veloComboBox = new JComboBox<>(velos);
        veloComboBox.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(veloComboBox, gbc);

        // Bouton ajouter
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 5, 8, 5);
        ajouterVeloButton = new JButton("Ajouter l'activité à vélo");
        ajouterVeloButton.setBackground(new Color(0, 128, 0)); // Green
        ajouterVeloButton.setForeground(Color.WHITE);
        ajouterVeloButton.setPreferredSize(new Dimension(150, 35));
        ajouterVeloButton.setFocusPainted(false);
        ajouterVeloButton.setBorderPainted(false);
        contentPanel.add(ajouterVeloButton, gbc);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createPiedsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ScrollPane pour le contenu
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);

        // Titre de la section
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("Ajout d'une activité à pieds");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        contentPanel.add(titleLabel, gbc);

        // Reset gridwidth
        gbc.gridwidth = 1;

        // Nom de l'activité
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Nom de l'activité :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        nomActivitePiedsField = new JTextField(15);
        nomActivitePiedsField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(nomActivitePiedsField, gbc);

        // Distance parcourue
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Distance parcourue :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        distancePiedsField = new JTextField(15);
        distancePiedsField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(distancePiedsField, gbc);

        // Durée de l'activité
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Durée de l'activité :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        dureePiedsField = new JTextField(15);
        dureePiedsField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(dureePiedsField, gbc);

        // Nombre de pas
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Nombre de pas effectués :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        nbPasField = new JTextField(15);
        nbPasField.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(nbPasField, gbc);

        // Chaussures utilisées
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Chaussures utilisées :"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        String[] chaussures = {
                "Nike Air Zoom Pegasus 38",
                "Adidas Ultraboost 21",
                "Asics Gel-Kayano 28",
                "Saucony Endorphin Speed",
                "Hoka One One Clifton 8"
        };
        chaussuresComboBox = new JComboBox<>(chaussures);
        chaussuresComboBox.setPreferredSize(new Dimension(200, 25));
        contentPanel.add(chaussuresComboBox, gbc);

        // Bouton ajouter
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 5, 8, 5);
        ajouterPiedsButton = new JButton("Ajouter l'activité à pieds");
        ajouterPiedsButton.setBackground(new Color(0, 128, 0)); // Green
        ajouterPiedsButton.setForeground(Color.WHITE);
        ajouterPiedsButton.setPreferredSize(new Dimension(150, 35));
        ajouterPiedsButton.setFocusPainted(false);
        ajouterPiedsButton.setBorderPainted(false);
        contentPanel.add(ajouterPiedsButton, gbc);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(211, 211, 211)); // LightGray
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cancelButton = new JButton("Annuler");
        cancelButton.setBackground(Color.GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(100, 30));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);

        footerPanel.add(cancelButton);
        return footerPanel;
    }

    // Méthode pour ajouter les listeners aux boutons
    public void addActionListeners(ActionListener listener) {
        cancelButton.addActionListener(listener);
        ajouterVeloButton.addActionListener(listener);
        ajouterPiedsButton.addActionListener(listener);
    }

    // Getters pour les valeurs des champs vélo
    public String getNomActiviteVelo() {
        return nomActiviteVeloField.getText();
    }

    public String getDistanceVelo() {
        return distanceVeloField.getText();
    }

    public String getDureeVelo() {
        return dureeVeloField.getText();
    }

    public String getPuissanceMoyenne() {
        return puissanceMoyenneField.getText();
    }

    public String getVeloSelectionne() {
        return (String) veloComboBox.getSelectedItem();
    }

    // Getters pour les valeurs des champs pieds
    public String getNomActivitePieds() {
        return nomActivitePiedsField.getText();
    }

    public String getDistancePieds() {
        return distancePiedsField.getText();
    }

    public String getDureePieds() {
        return dureePiedsField.getText();
    }

    public String getNbPas() {
        return nbPasField.getText();
    }

    public String getChaussuresSelectionnees() {
        return (String) chaussuresComboBox.getSelectedItem();
    }

    // Getters pour les boutons
    public JButton getAjouterVeloButton() {
        return ajouterVeloButton;
    }

    public JButton getAjouterPiedsButton() {
        return ajouterPiedsButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    // Méthodes utilitaires pour vider les champs
    public void clearVeloFields() {
        nomActiviteVeloField.setText("");
        distanceVeloField.setText("");
        dureeVeloField.setText("");
        puissanceMoyenneField.setText("");
        veloComboBox.setSelectedIndex(0);
    }

    public void clearPiedsFields() {
        nomActivitePiedsField.setText("");
        distancePiedsField.setText("");
        dureePiedsField.setText("");
        nbPasField.setText("");
        chaussuresComboBox.setSelectedIndex(0);
    }
}