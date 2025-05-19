import javax.swing.*;
import java.awt.*;

public class windowRavaJ extends JFrame
{
    private JPanel mainPanel;
    private JPanel menuBar;
    private JPanel fieldsPanel;

    private JButton addButton;
    private JButton delButton;
    private JButton loginButton;
    private JPanel panelTitle;
    private JPanel GridClassement;

    public windowRavaJ()
    {
        setTitle("RavaJ Main Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
    }


}
