package ConKUeror.UI.PauseScreen;

import javax.swing.*;

import java.awt.*;

public class PauseScreen extends JDialog {

    public PauseScreen(Frame pauseButtonHandler) {
        super(pauseButtonHandler, "Game is Paused", true);

        JLabel label = new JLabel("Game is Paused", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(300, 100));

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resumeButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(pauseButtonHandler);
        setResizable(false);
        setModal(true);
    }
}
