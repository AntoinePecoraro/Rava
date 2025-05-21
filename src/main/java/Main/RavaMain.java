package Main;

import Model.RavaModel;
import View.ApplicationInterface;
import Controller.RavaController;

public class RavaMain {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationInterface view = new ApplicationInterface();
                RavaController controller = new RavaController(view);
                view.setVisible(true);
            }
        });
    }
}