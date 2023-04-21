package src.ConKUeror.view;

import javax.swing.JOptionPane;

public class DialogBox extends JOptionPane{

    public DialogBox(String msg,String title) {

        Object[] message = {

            String.format(msg) 
        };
        int option = JOptionPane.showConfirmDialog(null, message,title , JOptionPane.OK_CANCEL_OPTION);
        

    }


    
}
