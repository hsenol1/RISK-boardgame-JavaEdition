package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardsScreen extends JFrame {
    public CardsScreen() {
        setTitle("Cards Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1250, 600);

        JTextArea textArea = new JTextArea(
            "Cards\n" +
            "The game will feature three types of cards: territory cards, chance cards, and army cards. At the start of each turn, you will select a \n" +
            "chance card, and by the end of any turn where you have conquered at least one territory, you will receive a randomly selected territory or \n" +
            "army card.\n"
        );
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        textArea.setBackground(new Color(44, 62, 80, 123)); // semi-transparent color
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JButton returnButton = new JButton("Return");
        returnButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font
        returnButton.setMargin(new Insets(5, 5, 5, 5)); // Compact margins
        returnButton.setPreferredSize(new Dimension(40, 30)); // Preferred size
        returnButton.addActionListener(e -> {
            dispose();
            new HelpScreen().setVisible(true);
        });

        try {
            BufferedImage myPicture = ImageIO.read(getClass().getClassLoader().getResource("ConKUeror/UI/HelpScreen/HelpScreenImages/card.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            picLabel.setLayout(new BorderLayout());

            picLabel.add(scrollPane, BorderLayout.CENTER);
            picLabel.add(returnButton, BorderLayout.NORTH);

            add(picLabel);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }
}
