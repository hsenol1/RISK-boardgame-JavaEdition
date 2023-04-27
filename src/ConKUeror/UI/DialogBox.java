package src.ConKUeror.UI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DialogBox extends JOptionPane{

    Image image;
    public DialogBox(String msg,String title) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/images/icon.png"));
       } catch (IOException e) {
           // TODO Auto-generated catch block

    }

        image=image.getScaledInstance(100, 100, ABORT);
       this.setIcon(new ImageIcon(image));
   

        Object[] message = {

            String.format(msg) 
        };

        JOptionPane.showMessageDialog(null, message,title , JOptionPane.OK_CANCEL_OPTION, icon);
        

        
    }

    
}
