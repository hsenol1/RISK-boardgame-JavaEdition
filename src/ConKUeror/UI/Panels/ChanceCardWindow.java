package ConKUeror.UI.Panels;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChanceCardWindow {

    private String description;
    JFrame frame;
    JLabel label;
  

    public ChanceCardWindow(String description) {

        this.description = description;
        
    }


    public void createChanceWindow() {
        frame = new JFrame("Chance Card Description!");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 


        JLabel label = new JLabel(description, JLabel.CENTER);
        frame.getContentPane().add(label);

        frame.setVisible(true);

    }
 
    
}
