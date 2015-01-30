package exploration1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Graph extends JPanel{
    private static final int D_W = Environment.width * 10;
    private static final int D_H = Environment.height * 10;

    int x = 0;
    int y = 0;
    public Graph() {
        setBackground(Color.BLACK);
    }
    
    public void setCoordinates(Coordinate c){
    	x = c.getX()*10;
    	y = c.getY()*10;
    	repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 10, 10);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }
}