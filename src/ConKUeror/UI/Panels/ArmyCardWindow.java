package src.ConKUeror.UI.Panels;

import java.awt.event.ActionEvent;
import src.ConKUeror.domain.controller.ArmyCardListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

import src.ConKUeror.domain.model.Board.ArmyCard;

public class ArmyCardWindow extends JPanel {

    private ArmyCardListener armyListener;
    private String name;
    private int selectedButton;
    JFrame frame;
    JLabel label;
    JLabel label2;
 
        
    public ArmyCardWindow(String title, ArmyCardListener armyLis) {
        super();
        this.name = title;
        this.armyListener = armyLis;
        JLabel titleLabel = new JLabel(title);
        this.add(titleLabel);

    }

    public void createWindow() {
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        String[] buttonNames = {
            "3 I = 1 C",
            "2 I + 1 C = 2 C",
            "2 I + 1 A = 2 A",
            "1 I + 2 C = 1 C + 1 A",
            "1 A + 2 C = 3 A"
        };

        for (int i = 0; i < buttonNames.length; i++) {
            JButton button = new JButton(buttonNames[i]);
            final int buttonIndex = i + 1;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    selectedButton = buttonIndex;
                    frame.dispose(); // Close the frame after a button is clicked
                    armyListener.onCardSelected(selectedButton);
                }
            });
            panel.add(button);
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    


    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public void setTextLabel(boolean validation) {

        if (validation) {
            frame.remove(label2);
            JLabel label = new JLabel("You successfully converted your cards!");
            frame.add(label);
        }
        else {
            frame.remove(label);
            JLabel label2 = new JLabel("Not enough cards!");
            frame.add(label2);
        }
    }
    
}
