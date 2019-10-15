package graphics;

import javax.swing.*;
import java.awt.*;

public class Fenster{

    public Fenster(){

        JFrame fenster = new JFrame("Neues Fenster");
        fenster.setPreferredSize(new Dimension(800,600));

        Container contentPane = fenster.getContentPane();

        contentPane.setLayout(new BorderLayout());

        contentPane.add(new Canvas(), BorderLayout.CENTER);
        fenster.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fenster(); // Let the constructor do the job
            }
        });
    }
}
