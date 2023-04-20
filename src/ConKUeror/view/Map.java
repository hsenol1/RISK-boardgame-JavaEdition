package src.ConKUeror.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.ConKUeror.controller.ButtonHandler;
import src.ConKUeror.controller.MapHandler;

public class Map extends JFrame{

    MapHandler mapHandler;
    ButtonHandler buttonHandler;

    public BufferedImage image;
    JPanel mapPanel;
    String armyNum =String.valueOf(0);
    Boolean disable = false;
    int disable_Num = 0;

    


public Map(MapHandler _mapHandler, ButtonHandler _buttonHandler) throws IOException {

    this.mapHandler = _mapHandler;
    this.buttonHandler = _buttonHandler;
    
    initGUI();
}

public void occupyTerritory() {
    
}


public void initGUI() throws IOException {

    image = ImageIO.read(getClass().getResourceAsStream("/src/images/worldMap.png"));
    setSize(image.getWidth(), image.getHeight());
    mapPanel = new JPanel() {
        BufferedImage backgroundImage = image;
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, null); // draw the image
        }
    };
    mapPanel.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    mapPanel.setLayout(null); // switch to null layout manager

    
    add(mapPanel);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null); // Center the frame on the screen

    setVisible(true);
    createButtons();

} 


public void createButtons() {

    for(int i= 0 ; i<42 ; i++) {

        int x = buttonHandler.getXFromList(i);
        int y = buttonHandler.getYFromList(i);

        MyButton button = new MyButton(x,y,i);
        button.setBounds(x, y, 40, 40);
        button.setPreferredSize(new Dimension(40, 40)); 
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                buttonHandler.matchButton(button.getID());
            }
            
        });
        mapPanel.setLayout(null); // switch to null layout manager
        mapPanel.add(button);



    }

}







}
