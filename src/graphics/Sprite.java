package graphics;

import javax.swing.*;
import java.awt.*;

public class Sprite extends JPanel {

    public Sprite(){
        setPreferredSize(new Dimension(100,100));
        setBackground(Color.BLACK);

    }

    public void set(){
        setLocation(50,50);
    }


}
