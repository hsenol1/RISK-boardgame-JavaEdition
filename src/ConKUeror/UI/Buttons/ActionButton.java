package src.ConKUeror.UI.Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import src.ConKUeror.domain.controller.ButtonHandler;
import src.ConKUeror.domain.controller.HandlerFactory;

public class ActionButton extends JButton implements ActionListener{

    private String _name;
    private int[] id;
    ButtonHandler buttonHandler;

    public ActionButton(String buttonName, Font labelFont, int[] id,Color color) {
        super(buttonName);
        this.id= id;
        setFont(labelFont);
        this._name = buttonName;
        this.setName(_name);
        HandlerFactory controller = HandlerFactory.getInstance();
        buttonHandler =controller.giveButtonHandler();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

//This phase is for build mode
        switch (id[0]) {
            case 0:
                switch (id[1]) {
                    case 0:
                    buttonHandler.addConnection();
                        break;
                    case 1:
                        buttonHandler.removeButton();

                        break;
                    case 2:
                        buttonHandler.nextPhase();
                        break;

                }
                break;




  //this phase is just for test to see connections
            case 1:
                switch (id[1]) {
                    case 0:
        //do nothing
                        break;
                    case 1:
                    //do nothing
                        break;
                    case 2:
                    buttonHandler.nextPhase();
                    break;
                    default:
                        // Code to execute if the first element is 1 and the second is neither 0 nor 1 nor 2
                        break;
                }
                break;

    // this phase is for start game
            case 2:
                switch (id[1]) {
                    case 0:
                    buttonHandler.rollButton();
                    break;
                    case 1:
                        // Code to execute if the first element is 2 and the second is 1
                        break;
                    case 2:
                    buttonHandler.nextPhase();
                        break;
                    default:
                        // Code to execute if the first element is 2 and the second is neither 0 nor 1 nor 2
                        break;
                }
                break;
            default:
                // Code to execute if the first element is neither 0 nor 1 nor 2
                break;
        }





    }


    }



