package src.ConKUeror.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BuildModeScreen extends JFrame {
    
    private JPanel buildModePanel;
    private JLabel playerNumberLabel, botNumberLabel;
    private JButton confirmButton;
    private JButton helpButton;
    private JComboBox<Integer> playerNumberBox;
    private JComboBox<Integer> botNumberBox;

    private Integer[] numbers1 = {2, 3, 4, 5, 6};
    private Integer[] numbers2 = {1, 2, 3, 4, 5};

    public BuildModeScreen() {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Building Mode");

        playerNumberLabel = new JLabel("Number of total players:");
        botNumberLabel = new JLabel("Number of bots among the players:");

        playerNumberBox = new JComboBox<>(numbers1);
        botNumberBox = new JComboBox<>(numbers2);

        confirmButton = new JButton("Confirm");
        helpButton = new JButton("Help");

        buildModePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        Font font = new Font("Arial", Font.PLAIN, 14);
        playerNumberLabel.setFont(font);
        botNumberLabel.setFont(font);
        playerNumberBox.setFont(font);
        botNumberBox.setFont(font);

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
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getPlayerNumberComboboxValue() {

        String str = playerNumberBox.getSelectedItem().toString();

        return Integer.parseInt(str);


    }

    public int getBotNumberComboboxValue() {

        String str = botNumberBox.getSelectedItem().toString();

        return Integer.parseInt(str);


    }

    public String openPanelForPlayerDetail(int i) {
        System.out.println(i);
        JTextField textField = new JTextField();

        Object[] message = {

            String.format("Enter player %d name:", i), textField 
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Name Entry", JOptionPane.OK_CANCEL_OPTION);
      
        return textField.getText();

    }

   




    public void addConfirmButtonListener(ActionListener confirmButtonListener) {

        confirmButton.addActionListener(confirmButtonListener);
        
    }
    public void addHelpButtonListener(ActionListener helpButtonListener) {

        helpButton.addActionListener(helpButtonListener);
        
    }

  
}

