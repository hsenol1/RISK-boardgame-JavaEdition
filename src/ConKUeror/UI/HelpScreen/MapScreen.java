package ConKUeror.UI.HelpScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MapScreen extends JFrame {
    public MapScreen() {
        setTitle("Game Map");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1250, 600);

        JTextArea textArea = new JTextArea(
            "Game Map\n"+
            "The initial game map comprises of 42 territories divided among 6 continents, with each continent colored differently and consisting of 4 to \n"+
            "12 territories. Players follow the rules to allocate their armies across theses territories.  \n"+
            "However, during the building mode, it is feasible to activate or deactivate certain continents and territories.\n\n"
        );

        textArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
        
            dispose();
            
            new HelpScreen().setVisible(true);
        });
        returnButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font
        returnButton.setMargin(new Insets(5, 5, 5, 5)); // Compact margins
        returnButton.setPreferredSize(new Dimension(40, 30)); // Preferred size
        add(returnButton, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
        textArea.setBackground(new Color(44, 62, 80, 123)); // semi-transparent color
        textArea.setForeground(Color.WHITE);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

      
        try {
            BufferedImage myPicture = ImageIO.read(getClass().getClassLoader().getResource("ConKUeror/UI/HelpScreen/HelpScreenImages/gameMap.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            picLabel.setLayout(new BorderLayout());

            picLabel.add(scrollPane, BorderLayout.CENTER);

            add(picLabel);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }
}
