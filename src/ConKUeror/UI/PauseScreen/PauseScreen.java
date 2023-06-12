package ConKUeror.UI.PauseScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
import ConKUeror.domain.controller.SaveLoadController;

public class PauseScreen extends JDialog implements Serializable{

    private GameHandler gameHandler;
    private GameState gameState;
 

    public PauseScreen(IUIRefreshListener uiRefreshListener,Frame pauseButtonHandler, List<Player> playerList, Map<Integer, Territory> territoryMap,GameHandler gameHandler) {
        super(pauseButtonHandler, "Game is Paused", true);
        ;

        JLabel label = new JLabel("Game is Paused", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setPreferredSize(new Dimension(300, 100));

        JButton resumeButton = new JButton("Resume");
        resumeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resumeButton.addActionListener(e -> dispose());

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 20));
        saveButton.addActionListener(e -> {
            dispose();
            SaveLoadController saveLoadController =  SaveLoadController.getInstance();
            new SaveWindow(pauseButtonHandler,saveLoadController);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resumeButton);
        buttonPanel.add(saveButton);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
        setSize(400, 200); // set dialog size
        setLocationRelativeTo(pauseButtonHandler);
        setResizable(false);
        setModal(true);
    }

   
}
