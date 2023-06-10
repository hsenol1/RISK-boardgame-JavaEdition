package ConKUeror.UI.PauseScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Data.PlayerData;
import ConKUeror.domain.model.Data.TerritoryData;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerInventory;

import ConKUeror.domain.controller.IUIRefreshListener;
import ConKUeror.domain.controller.SaveLoadHandler;
public class PauseScreen extends JDialog {

    private GameHandler gameHandler;
    private GameState gameState;
    private SaveLoadHandler saveLoadHandler = new SaveLoadHandler();
    private List<Player> playerList;
    private IUIRefreshListener uiRefreshListener;
    private List<PlayerData> playerDataList;
    private List<TerritoryData> territoryDataList;
    private Map<Integer, Territory> territoryMap;

    public PauseScreen(IUIRefreshListener uiRefreshListener,Frame pauseButtonHandler, List<Player> playerList, Map<Integer, Territory> territoryMap,GameHandler gameHandler) {
        super(pauseButtonHandler, "Game is Paused", true);
        this.territoryMap = territoryMap;
        this.gameHandler = gameHandler;
        this.playerList = playerList;
        this.playerDataList = new ArrayList<>();
        this.territoryDataList = new ArrayList<>();
        this.uiRefreshListener = uiRefreshListener;
        JLabel label = new JLabel("Game is Paused", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(300, 100));

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(


        e -> dispose());
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Enter file name to save:");
            if (fileName != null) {
                try {
                    for(Player p: playerList){
                        System.out.println(p.getName());
                    }
                    generatePlayerDatas(this.playerList);
                    generateTerritoryDatas(this.territoryMap);
                    HandlerFactory controller = HandlerFactory.getInstance();
                    GameLogic game =  controller.getGameLogic();

                    gameState = new GameState(playerDataList,territoryDataList,Board.getContinents(),         game.getGameMode()         ,   game.getGamePhaseAsIndex()
                    );
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

    public void generateTerritoryDatas(Map<Integer, Territory> map) {
        for (Map.Entry<Integer, Territory> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Territory t1 = entry.getValue();
            System.out.println("noluyo");

            System.out.println(t1.getId());
            System.out.println(map);
            territoryDataList.add(new TerritoryData(t1));

        }
    }


}
