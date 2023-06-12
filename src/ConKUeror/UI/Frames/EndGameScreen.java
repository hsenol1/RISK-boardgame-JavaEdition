package ConKUeror.UI.Frames;

import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ConKUeror.domain.controller.ButtonHandler;
import ConKUeror.domain.controller.EndOfTheGameListener;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.model.Player.Player;

public class EndGameScreen extends JFrame {

    private JPanel panel;
    private JLabel winnerName;
    private BufferedImage winnerImage;
    private JButton closeApplicationButton;
    private ButtonHandler buttonHandler;

    public EndGameScreen(Player player) throws IOException {
        HandlerFactory controller = HandlerFactory.getInstance();
        this.buttonHandler = controller.giveButtonHandler();
        initializeGUI(player);
    }

    public void initializeGUI(Player player) throws IOException {
        winnerImage = ImageIO.read(getClass().getResourceAsStream("/images/winner_image.jpeg"));
        winnerName = new JLabel(player.getName() + " wins!");
        closeApplicationButton = new JButton("Close Game");
        panel = new JPanel() {
            BufferedImage backgroundImage = winnerImage;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null); // draw the image
            }
        };
        panel.setOpaque(true);

        panel.setPreferredSize(new Dimension(winnerImage.getWidth(), winnerImage.getHeight()));
        panel.setLayout(null);

        closeApplicationButton.addActionListener(new CloseApplicationButtonListener());

        JPanel winnerPanel = new JPanel();
        winnerPanel.add(winnerName);
        winnerPanel.add(closeApplicationButton);
        // winnerPanel.setLayout(new BoxLayout(winnerPanel, BoxLayout.Y_AXIS));
        // this.add(winnerPanel);
    }

}

class CloseApplicationButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}