package ConKUeror.UI.Buttons;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
// will be used to increase the graphics level. now it is not necessary

import ConKUeror.domain.controller.ButtonHandler;
import ConKUeror.domain.controller.HandlerFactory;



public class TerritoryButton extends JButton {

    private int x;
    private int y;
    private int id;
    private Color defaultColor;


    public TerritoryButton(int x, int y,int id ) {
        super();
           this.id = id;
           this.x= x;
           this.y = y;
           this.defaultColor = getBackground();


    }
    public TerritoryButton(Color color,int x, int y,int id ) {
        super();
           this.id = id;
           this.x= x;
           this.y = y;
           setBackground(color);


    }

    public void changeColor() {
        setBackground(Color.GREEN);
    }

    public void setColor(Color color) {

        setBackground(color);
        this.setVisible(true);
        repaint();
        revalidate();
    }

    public void resetColor() {

        ButtonHandler buttonHandler = HandlerFactory.getInstance().giveButtonHandler();
        Color color =  buttonHandler.getPlayerColor();
        setBackground(color);

    }

    public void setArmyValue(int number) {

      String text =  Integer.toString(number);
      setText(text);

    }

    public int getID() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;

    }




}
