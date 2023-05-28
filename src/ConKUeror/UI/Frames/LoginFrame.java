package ConKUeror.UI.Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ConKUeror.domain.controller.BuildHandler;
import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.controller.SaveLoadHandler;
import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Data.PlayerData;
import ConKUeror.domain.model.Modes.BuildMode;

public class LoginFrame extends JFrame {
    private JButton newGameButton;
    private JButton loadGameButton;
    private GameState gameState;
    private SaveLoadHandler saveLoadHandler = new SaveLoadHandler();
    public LoginFrame() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));  // a light background color
        panel.setBorder(new EmptyBorder(50, 80, 50, 80));  // padding

        this.newGameButton = createButton("New Game");
        this.loadGameButton = createButton("Load Game");
        // Set button action listeners
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                startNewGame();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Load GameState from a saved file
                try {
                    gameState = loadGameState();
                } catch (ClassNotFoundException | IOException e1) {
                    
                    e1.printStackTrace();
                }

                // Start loaded game
                startLoadedGame(gameState.getPlayerData());
            }
        });

        panel.add(newGameButton);
        panel.add(loadGameButton);
        
        panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));  // padding
        this.add(panel);
        
        this.setSize(new Dimension(400, 300));  // increase frame size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
}

private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(200, 50));  // set button size
    button.setFont(new Font("Arial", Font.BOLD, 16));  // set font
    button.setForeground(Color.BLACK);  // set text color
    button.setBackground(new Color(59, 89, 182));  // set background color
    button.setFocusPainted(false);  // remove focus border
    button.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));  // set padding
   // set action listener
    return button;
}

private void startNewGame() {
    // Implementation for starting a new game
    HandlerFactory controller = HandlerFactory.getInstance();
    BuildHandler buildHandler = controller.giveBuildHandler();
    BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);
    this.dispose();
}


    public void startLoadedGame(List<PlayerData> loadedPlayerDataList) {
        HandlerFactory controller = HandlerFactory.getInstance();
        BuildHandler buildHandler = controller.giveBuildHandler();
        BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);
    
        int botCount = 0;
        // Initialize the players using the loaded player data
        for (PlayerData playerData : loadedPlayerDataList) {
            if (playerData.getPlayerType().equals("Computer Player")) {
                botCount++;
                buildHandler.initalizeBots(botCount); // Initialize bot player.
            } else {
            
            }
        }
        buildModeScreen.updatePlayerCount(loadedPlayerDataList.size());
        buildModeScreen.updateBotCount(botCount);
        buildModeScreen.setCanStart(true); // Can start if loaded game.
    
        buildModeScreen.setVisible(true);
        this.dispose(); // Close the login frame
    }
    

public static void main(String[] args) {
    SwingUtilities.invokeLater(LoginFrame::new);
}
public GameState loadGameState() throws ClassNotFoundException, IOException{
    return saveLoadHandler.loadGame("data.txt");
}
}