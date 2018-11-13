package rozrostziarna;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PicturePanel extends JPanel implements ActionListener {
    final int WIDTH = 10;
    final int HEIGHT = 10;
    
    Timer timer = new Timer(10, this);
    CustomMouse customMouse = new CustomMouse();
    LinkedList<ColoredPoint> points = new LinkedList<>();
    Random rnd = new Random();
    PicturePanel self = this;
    Color[][] cArray = new Color[WIDTH][HEIGHT];

    public PicturePanel() {
        for (Color[] array1 : cArray) {
            for (Color c : array1) {
                c = Color.blue;
            }
        }
        initComponents();
        repaint();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        for (int i = 0; i < cArray.length; i++) {
            for (int j = 0; j < cArray[0].length; j++) {
                g.setColor(cArray[i][j]);
                //g.fillRect(i*5, j*5, i*5+5, j*5+5);
                g.fillRect(i*1, j*1, i*1+1, j*1+1);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            repaint();
        }
    }

    private void initComponents() {
        this.addMouseListener(customMouse);
    }

    void drawArray(Color[][] array) {
        cArray = array;
        repaint();
    }

    private class CustomMouse extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            cArray[e.getPoint().x][e.getPoint().y] = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
            repaint();
        }

    }

}
