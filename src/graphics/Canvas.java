package graphics;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    public Canvas(){
        setLayout(null);
        Sprite sprite = new Sprite();

        this.add(sprite);

        sprite.set();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(10,10,this.getWidth()-20,this.getHeight()-20);



        g.drawString("Hallo",10,10);

        }
}
