package ConKUeror.UI.PauseScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Data.PlayerData;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerInventory;


import ConKUeror.domain.controller.SaveLoadHandler;
public class PauseScreen extends JDialog {
   
    private GameHandler gameHandler;
    private GameState gameState;
    private SaveLoadHandler saveLoadHandler = new SaveLoadHandler();
    private List<Player> playerList;
   private GameLogic gameLogic;
   private HandlerFactory handlerFactory; 
    private List<PlayerData> playerDataList;
    JButton resumeButton;
    public PauseScreen(Frame pauseButtonHandler, List<Player> playerList, GameHandler gameHandler) {
        super(pauseButtonHandler, "Game is Paused", true);
       this.handlerFactory = HandlerFactory.getInstance();
       this.gameLogic = handlerFactory.getGameLogic();
        this.gameHandler = gameHandler;
        this.playerList = playerList;
       this.playerDataList = new ArrayList<>();

        JLabel label = new JLabel("Game is Paused", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(300, 100));

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> {
            dispose();   
            // setVisible(false);
            
        });
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Enter file name to save:");
            if (fileName != null) {
                try {
                    for(Player p: playerList){
                        System.out.println(p.getName());
                        
                    }
                    generatePlayerDatas(this.playerList);
                    

                    gameState = new GameState(playerDataList,gameLogic);
                    saveLoadHandler.saveGame(fileName,gameState);
                    JOptionPane.showMessageDialog(this, "Game saved successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error occurred while saving the game.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resumeButton);
        buttonPanel.add(saveButton);
              JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(pauseButtonHandler);
        setResizable(false);
        setModal(true);
    }

    public void generatePlayerDatas(List<Player> playerList){
        for(Player p : playerList){
            playerDataList.add(new PlayerData(p));
        }
    }
    
}
