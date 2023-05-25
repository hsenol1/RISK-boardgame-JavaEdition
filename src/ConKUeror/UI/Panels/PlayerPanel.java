package ConKUeror.UI.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.xml.sax.HandlerBase;

import ConKUeror.domain.controller.ButtonHandler;
import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.controller.PlayerExpertListener;
import ConKUeror.domain.model.Modes.StartMode;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerFactory;


public class PlayerPanel extends JPanel implements PlayerExpertListener{

    private ButtonHandler buttonHandler;

    private int playerCount;
    private List<Player> orderedPlayers;
    private List<JPanel> playerInfoPanels;
    private List<JLabel> armyCountLabels;

    Border blackBorder;
    Border padding;
    int panelWidth;
    int panelHeight;


    public PlayerPanel(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        playerInfoPanels = new ArrayList<>();
        armyCountLabels = new ArrayList<>();

        playerCount = StartMode.getOrderedPlayerList().size();
        setLayout(new GridLayout(1, playerCount));
        orderedPlayers=StartMode.getOrderedPlayerList();

        setUI();
        setPlayerInfos();
        addPlayerPanelAsListener();
   }

   public void addPlayerPanelAsListener() {

    GameHandler gameHandler = HandlerFactory.getInstance().giveGameHandler();
    gameHandler.registerPlayerPanelAsListener(this);

   }

   public void setUI() {

     blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
     padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        int screenWidth = 1115;
        int availableWidth = screenWidth - 450;
        panelWidth = availableWidth / playerCount;
        panelHeight = 30;

        int startX = 460;
        int startY = 5;

        setBounds(startX, startY, panelWidth * playerCount, panelHeight);
        setPreferredSize(new Dimension(panelWidth * playerCount, panelHeight));

   }


   public void setPlayerInfos() {
        for (Player p : orderedPlayers){
            JPanel playerInfoPanel = new JPanel();

        playerInfoPanel.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));
        playerInfoPanel.setBackground(Color.WHITE);
        JLabel playerNameLabel = new JLabel(p.getName());

        //String army = Integer.toString(p.getInventory().getTotalArmy());
        //JLabel armyCountLabel = new JLabel(army);
        JLabel armyCountLabel = new JLabel();
        armyCountLabels.add(armyCountLabel);

        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        playerNameLabel.setFont(labelFont);
        armyCountLabel.setFont(labelFont);


        playerInfoPanel.add(playerNameLabel);
        playerInfoPanel.add(armyCountLabel);


        playerInfoPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));

        add(playerInfoPanel);
        playerInfoPanels.add(playerInfoPanel);


    }
}


    public void updatePanelCounts(int index, int army){

        JPanel playerInfoPanel = playerInfoPanels.get(index);
        JLabel armyLabel= armyCountLabels.get(index);
        armyLabel.setText(": " + army);
        playerInfoPanel.add(armyLabel);


    }

    public void changePlayerPanelColor(int oldIndex,int nexIndex, Color color) {

        System.out.println("Observer metodum çalışıyor");
        JPanel playerPanelOld = playerInfoPanels.get(oldIndex);
        playerPanelOld.setBackground(Color.WHITE);

        JPanel playerPanelNew = playerInfoPanels.get(nexIndex);
        playerPanelNew.setBackground(color);

    }

    public void clearPlayerInfos() {
          // Remove old player info panels from UI
          // Remove old player info panels from UI

        for (JPanel playerInfoPanel : playerInfoPanels) {
            remove(playerInfoPanel);
        }

        playerInfoPanels.clear();

        setOrderedPlayers();
        System.out.println("Before for loop, after setOrderedPlayers()");
        for (Player p : orderedPlayers) {
            System.out.println("The name is: " + p.getName());
        }
        System.out.println("After for loop.");
        setPlayerInfos();

        revalidate();
        repaint();
    }

    public void setOrderedPlayers() {
        this.orderedPlayers = StartMode.getOrderedPlayerList();
    }






}
