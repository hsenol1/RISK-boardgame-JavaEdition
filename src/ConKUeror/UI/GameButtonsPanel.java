package src.ConKUeror.UI;

import javax.swing.JPanel;

public class GameButtonsPanel extends JPanel{
   
   
    public void createFunctionalityButtons() {
       /* setLayout(new GridLayout(2, 2)); // 2x2 grid for the buttons
    
        // ... (create buttons)
    
        buttonPanel.add(pauseAndResumeButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(rollButton);
        buttonPanel.add(executeButton);
        buttonPanel.add(nextButton); */
    }
    
   
   
   
    public void updateButtonPanel() {
        removeAll();
    
        // Add code to create and add new buttons based on the current game phase
    
        revalidate();
        repaint();
    }
    
}
