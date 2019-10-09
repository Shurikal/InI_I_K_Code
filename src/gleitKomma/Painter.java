package gleitKomma;

import javax.swing.*;
import java.awt.*;

public class Painter extends JFrame {
    // Define constants
    public static final int CANVAS_WIDTH  = 640;
    public static final int CANVAS_HEIGHT = 480;

    // Declare an instance of the drawing canvas,
    // which is an inner class called DrawCanvas extending javax.swing.JPanel.
    private DrawCanvas canvas;

    // Constructor to set up the GUI components and event handlers
    public Painter() {
        canvas = new DrawCanvas();    // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Set the Drawing JPanel as the JFrame's content-pane
        Container cp = getContentPane();
        cp.add(canvas);
        // or "setContentPane(canvas);"

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        pack();              // Either pack() the components; or setSize()
        setTitle("......");  // "super" JFrame sets the title
        setVisible(true);    // "super" JFrame show
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    private class DrawCanvas extends JPanel {
        // Override paintComponent to perform your own painting
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            Plotter p = new Plotter();
            p.setXmin(-2);
            p.setXmax(2);
            p.calc(this.getWidth());

            Converter c = new Converter();
            c.setsWidth(this.getWidth());
            c.setsHeight(this.getHeight());
            c.setXmin(p.getXmin());
            c.setXmax(p.getXmax());

            double[][] data = p.getData();

            c.setYmin(p.getYmin());
            c.setYmax(p.getYmax());

            int cachex = c.calcX(data[0][0]);
            int cachey = c.calcY(data[0][1]);
            int cachex1,cachey1;
            for(int i =0; i <data.length-1; i++){
                cachex1 = c.calcX(data[i][0]);
                cachey1 = c.calcY(data[i][1]);
                g.drawLine(cachex,cachey,cachex1,cachey1);
                System.out.println("x " + cachex + " y "+ cachey);
                cachex = cachex1;
                cachey = cachey1;

            }
        }
    }

    // The entry main method
    public static void main(String[] args) {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Painter(); // Let the constructor do the job
            }
        });
    }
}