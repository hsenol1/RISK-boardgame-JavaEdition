package src.ConKUeror.view;

import javax.swing.*;
import java.awt.*;

public class BuildModeScreen extends JFrame {
    
    private JPanel buildModePanel;
    private JLabel playerNumberLabel, botNumberLabel;
    private JButton confirmButton;
    private JButton helpButton;
    private JComboBox<Integer> playerNumberBox;
    private JComboBox<Integer> botNumberBox;

    private Integer[] numbers = {1, 2, 3, 4, 5, 6};

    public BuildModeScreen() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Building Mode");

        playerNumberLabel = new JLabel("Number of players:");
        botNumberLabel = new JLabel("Number of bots among the players:");

        playerNumberBox = new JComboBox<>(numbers);
        botNumberBox = new JComboBox<>(numbers);

        confirmButton = new JButton("Confirm");
        helpButton = new JButton("Help");

        buildModePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        buildModePanel.add(playerNumberLabel, gbc);

        gbc.gridx++;
        buildModePanel.add(playerNumberBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        buildModePanel.add(botNumberLabel, gbc);

        gbc.gridx++;
        buildModePanel.add(botNumberBox, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(confirmButton);
        buttonPanel.add(helpButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        buildModePanel.add(buttonPanel, gbc);

        add(buildModePanel);

        setSize(400, 200);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

  
}

