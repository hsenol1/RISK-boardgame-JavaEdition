package ConKUeror.UI.PauseScreen;

import javax.swing.*;

import ConKUeror.domain.controller.SaveLoadController;

import java.awt.*;
import java.io.Serializable;

public class SaveWindow extends JDialog implements Serializable{
    JButton saveToTxtButton;
    JButton saveToMongoButton;
    private SaveLoadController saveLoadHandler;

    
    public SaveWindow(Frame owner,SaveLoadController saveLoadController) {
        super(owner, "Save Game", true);
        this.saveLoadHandler = saveLoadController;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        saveToTxtButton = new JButton("Save as Txt");
        saveToTxtButton.addActionListener(e -> {
        	saveLoadHandler.handleSave(0);
        });
        saveToTxtButton.setFont(new Font("Arial", Font.PLAIN, 20));

        saveToMongoButton = new JButton("Save as Mongo");
        saveToMongoButton.addActionListener(e -> {
        	saveLoadHandler.handleSave(1);
        	
        });
        saveToMongoButton.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(saveToTxtButton);
        buttonPanel.add(saveToMongoButton);

        setContentPane(buttonPanel);
        pack();
        setSize(300, 200); // set dialog size
        setLocationRelativeTo(owner);
        setResizable(false);
        setVisible(true);
    }
}
