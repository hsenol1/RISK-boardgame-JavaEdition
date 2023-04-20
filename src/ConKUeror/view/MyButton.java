package src.ConKUeror.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
// will be used to increase the graphics level. now it is not necessary



public class MyButton extends JButton {

    public MyButton(String text) {
        super(text);
        setOpaque(false); // make button transparent
        setContentAreaFilled(false); // remove default fill
        setBorderPainted(false); // remove default border
        setFocusPainted(false); // remove focus indication

        // Set preferred size to create a circular shape
        Dimension size = getPreferredSize();
        size.width = Math.max(size.width, size.height);
        size.height = size.width;
        setPreferredSize(size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray); // color when button is pressed
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1); // draw circle
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1); // draw border
    }

    @Override
    public boolean contains(int x, int y) {
        // Check if the click is within the circular shape
        Shape shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);
    }
}
