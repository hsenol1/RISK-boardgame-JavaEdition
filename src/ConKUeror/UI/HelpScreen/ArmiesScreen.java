package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ArmiesScreen extends JFrame {
    public ArmiesScreen() {
        setTitle("Armies");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1250, 600);

        // Create JTextArea
        JTextArea textArea = new JTextArea(
            "Armies \n"+
            "The game comprises of 6 sets of armies, each set including 3 types of army pieces: Infantry, which holds a value of 1; Cavalry, worth 5 \n"+
            "Infantry; and Artillery, worth either 10 Infantry or 2 Cavalry. At the beginning of the game, Infantry pieces are placed. As the game \n"+
            "progresses, players can exchange 5 Infantry for 1 Cavalry, or trade in 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.\n\n"
        );

        textArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
            // Close current window
            dispose();
            // Open main help screen
            new HelpScreen().setVisible(true);
        });
        returnButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font
        returnButton.setMargin(new Insets(5, 10, 5, 10)); // Compact margins
        returnButton.setPreferredSize(new Dimension(80, 30)); // Preferred size

        add(returnButton, BorderLayout.NORTH);

        // Create JScrollPane for the JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set custom colors and fonts
        textArea.setBackground(new Color(44, 62, 80, 123)); // semi-transparent color
        textArea.setForeground(Color.WHITE);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Load the background image
        try {
            BufferedImage myPicture = ImageIO.read(getClass().getClassLoader().getResource("ConKUeror/UI/HelpScreen/HelpScreenImages/armies.jpg"));
            // Create a JLabel using the ImageIcon
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            // Set the layout of the JLabel to BorderLayout
            picLabel.setLayout(new BorderLayout());

            // Add the scroll pane to the JLabel
            picLabel.add(scrollPane, BorderLayout.CENTER);

            // Add the JLabel to the frame
            add(picLabel);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Set the frame visible
        setVisible(true);
    }
}
