package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HelpScreen extends JFrame {

    public HelpScreen() {

        setTitle("ConKUeror - Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1250, 600); // Set the size of the frame

        // Create the text area with scroll pane
        JTextArea textArea = new JTextArea();

        textArea.setText("Welcome to the game!\n\n" +
                "ConKUeror is a strategy game that is easy to play yet challenging, taking inspiration from the well-known game RISK [1].\n" +
                "It provides a mixture of entertainment and competition, with players battling to conquer the world. To emerge victorious, \n" +
                "players must undertake daring attacks, defend their territories on all sides, and sweep across vast continents with courage\n" +
                "and cunning. However, it is important to note that both the risks and rewards are high, as opponents can strike at any moment\n" +
                "and claim everything that was once within reach."+
                " \n\n" +
                "The game takes place on a political map of the world, divided into territories and continents. Players take turns controlling armies of \n" +
                "playing pieces, attempting to capture territories from their opponents, with outcomes determined by dice rolls. Players are able to form and\n " +
                "break alliances as the game progresses. The ultimate goal is to occupy every territory on the board, thereby eliminating all other players.\n" +
                "Unforeseen circumstances may arise while attacking or defending territories, much like in real life. For example, soldiers may become sick \n"+
                "and perish, or they may receive assistance in defeating enemies. These unexpected events may also occur for opponents. The game can be  \n"+
                "played by two to six players, with at least one computer player and the others being real people. During the first phase, computer players  \n"+
                "take random actions, but their behavior may change in the second phase to take more logical actions. The game concludes when one player  \n"+
                "conquers the entire world by defeating all of their adversaries. In this final phase, all players will play the game on the same computer. \n"+
                " \n");
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(new Color(44, 62, 80, 123)); // semi-transparent color
        textArea.setEditable(false);

        // Apply 3D text effect
        textArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(52, 73, 94), 3),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton gameMapButton = new JButton("Game Map");
        JButton armiesButton = new JButton("Armies");
        JButton cardsButton = new JButton("Cards");

        gameMapButton.setFont(new Font("Arial", Font.BOLD, 14));
        armiesButton.setFont(new Font("Arial", Font.BOLD, 14));
        cardsButton.setFont(new Font("Arial", Font.BOLD, 14));

        gameMapButton.setBackground(new Color(41, 128, 185));
        armiesButton.setBackground(new Color(39, 174, 96));
        cardsButton.setBackground(new Color(142, 68, 173));

        gameMapButton.setForeground(Color.WHITE);
        armiesButton.setForeground(Color.WHITE);
        cardsButton.setForeground(Color.WHITE);

        buttonPanel.add(gameMapButton);
        buttonPanel.add(armiesButton);
        buttonPanel.add(cardsButton);

        // Button actions
        gameMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MapScreen();
                dispose();
            }
        });

        armiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ArmiesScreen();
                dispose();
            }
        });

        cardsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CardsScreen();
                dispose();
            }
        });

        try {
            BufferedImage myPicture = ImageIO.read(getClass().getClassLoader().getResource("ConKUeror/UI/HelpScreen/HelpScreenImages/conquer.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            picLabel.setLayout(new BorderLayout());

            picLabel.add(scrollPane, BorderLayout.CENTER);
            picLabel.add(buttonPanel, BorderLayout.SOUTH);

            add(picLabel);
            setVisible(true);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
