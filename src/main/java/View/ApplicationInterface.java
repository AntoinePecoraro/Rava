package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ApplicationInterface extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private JButton ajouterBtn;
    private JButton supprimerBtn;
    private JButton loginBtn;
    private JButton rechercheBtn;
    private JComboBox<String> sportCombo;
    private JComboBox<String> sexeCombo;
    private JComboBox<String> filterCombo;
    private JCheckBox globalCheckBox;
    private JCheckBox personnelCheckBox;

    // Création d'un modèle de table vide avec des colonnes
    static String[] columnsAVelo = {"id", "Nom Activité", "Sportif", "Distance", "Date", "Puissance Moy"};
    static String[] columnsAPieds = {"id", "Nom Activité", "Sportif", "Distance", "Date", "Nb pas"};

    //region Initialisation
    public ApplicationInterface() {
        // Configuration de la fenêtre principale
        setTitle("RavaJ Main Page");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Création des composants de l'interface
        JPanel topContainer = new JPanel(new BorderLayout());

        JPanel toolBar = createTopToolbar();
        topContainer.add(toolBar, BorderLayout.NORTH);

        JPanel filterBar = createFilterBar();
        topContainer.add(filterBar, BorderLayout.SOUTH);

        add(topContainer, BorderLayout.NORTH);

        JPanel tablePanel = createDataTable();
        add(tablePanel, BorderLayout.CENTER);

        // Rendre visible
        setVisible(true);
    }


    private JPanel createTopToolbar() {
        JPanel topToolbar = new JPanel();
        topToolbar.setLayout(new BorderLayout());
        topToolbar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        // Partie gauche de la barre d'outils
        JPanel leftButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ajouterBtn = new JButton("Ajouter");
        ajouterBtn.setBackground(new Color(0, 0, 139)); // Bleu foncé

        supprimerBtn = new JButton("Supprimer");
        supprimerBtn.setBackground(new Color(0, 0, 139)); // Bleu foncé

        leftButtons.add(ajouterBtn);
        leftButtons.add(supprimerBtn);

        // Partie droite de la barre d'outils
        JPanel rightButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(255, 0, 0));

        rightButtons.add(loginBtn);

        // Ajouter les panneaux à la barre d'outils
        topToolbar.add(leftButtons, BorderLayout.WEST);
        topToolbar.add(rightButtons, BorderLayout.EAST);

        // Paneau global du haut
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(topToolbar, BorderLayout.NORTH);

        add(topPanel, BorderLayout.NORTH);

        return topToolbar;
    }

    private JPanel createFilterBar() {
        JPanel filterBar = new JPanel();
        filterBar.setLayout(new BorderLayout());
        filterBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Partie gauche avec les filtres
        JPanel researchMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        sportCombo = new JComboBox<>(new String[]{"Sport"});
        sportCombo.setPreferredSize(new Dimension(100, 20));

        sportCombo.addItem("Cyclisme");
        sportCombo.addItem("Footing");

        sexeCombo = new JComboBox<>(new String[]{"Sexe"});
        sexeCombo.setPreferredSize(new Dimension(100, 20));

        sexeCombo.addItem("Masculin");
        sexeCombo.addItem("Feminin");

        // 2 options à cocher (soit personnel soit global)
        globalCheckBox = new JCheckBox("Global");
        globalCheckBox.setSelected(true);

        personnelCheckBox = new JCheckBox("Personnel");
        personnelCheckBox.setSelected(false);

        // Mettre des events listeners pour éviter que les 2 soient cochés en mm temps
        globalCheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(personnelCheckBox.isSelected())
                {
                    personnelCheckBox.setSelected(false);
                }

                globalCheckBox.setSelected(true);

            }
        });

        personnelCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(globalCheckBox.isSelected())
                {
                    globalCheckBox.setSelected(false);
                }

                personnelCheckBox.setSelected(true);
            }
        });

        rechercheBtn = new JButton("Recherche");
        rechercheBtn.setBackground(new Color(0, 200, 50));

        researchMenu.add(sportCombo);
        researchMenu.add(sexeCombo);
        researchMenu.add(globalCheckBox);
        researchMenu.add(personnelCheckBox);
        researchMenu.add(rechercheBtn);

        filterBar.add(researchMenu);
        filterBar.add(Box.createVerticalGlue());

        // Partie droite avec menu déroulant  -> Menu déroulant qui demande quel type de tri on veut effectuer (nom, distance de l'activité, ...)
        JPanel filterMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterCombo = new JComboBox<>(new String[]{"Par nom"});
        filterCombo.setPreferredSize(new Dimension(100, 20));

        // autres options
        filterCombo.addItem("Par Distance");
        filterCombo.addItem("Par Date");

        filterMenu.add(filterCombo);

        filterBar.add(researchMenu, BorderLayout.WEST);
        filterBar.add(filterMenu, BorderLayout.EAST);

        add(filterBar, BorderLayout.CENTER);

        return filterBar;
    }

    private JPanel createDataTable() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        Object[][] data = new Object[100][6]; // Table vide avec 20 lignes

        tableModel = new DefaultTableModel(data, columnsAVelo);
        dataTable = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);

                // Alternance de couleurs pour les lignes
                if (row % 2 == 0) {
                    comp.setBackground(Color.WHITE);
                } else {
                    comp.setBackground(new Color(121, 248, 248, 70));
                }

                return comp;
            }
        };

        // Configuration de la table
        dataTable.setShowGrid(false);
        dataTable.setIntercellSpacing(new Dimension(0, 0)); // Désigne l'espace entre les != lignes & colonnes
        dataTable.setRowHeight(25);

        dataTable.setGridColor(new Color(60, 60, 60));
        dataTable.setShowVerticalLines(true);

        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.getTableHeader().setResizingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.SOUTH);

        return tablePanel;
    }
    //endregion

    public void afficheActivite(List<Object[]> lignes) {
        tableModel.setRowCount(0);

        for (Object[] ligne : lignes) {
            tableModel.addRow(ligne);
        }

        dataTable.repaint();
    }

    public void changerColonnesActivite(boolean type) {
        if (type) {
            tableModel.setColumnIdentifiers(columnsAVelo);
        } else {
            tableModel.setColumnIdentifiers(columnsAPieds);
        }
    }

    public void addActionListeners(ActionListener listener) {
        rechercheBtn.addActionListener(listener);
        ajouterBtn.addActionListener(listener);
        supprimerBtn.addActionListener(listener);
        loginBtn.addActionListener(listener);
    }

}