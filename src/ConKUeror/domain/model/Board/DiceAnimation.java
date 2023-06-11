package ConKUeror.domain.model.Board;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ConKUeror.UI.Frames.MapView;


public class DiceAnimation {
    private MapView mapView;
    private JLabel label1, label2;
    private Timer timer;
    private Random random = new Random();
    private int countdown = 40;  

    public DiceAnimation(MapView mapView) {
        this.mapView = mapView;
    }


    public void DiceRollAnimation(int leftNumber, int rightNumber) {
        label1 = new JLabel();
        label2 = new JLabel();
        label1.setFont(new Font("Arial", Font.BOLD, 100));
        label2.setFont(new Font("Arial", Font.BOLD, 100));
        mapView.getMapPanel().add(label1);
        mapView.getMapPanel().add(label2);


        label1.setBounds(1126/2 - 50, 770/2, 100, 100);
        label2.setBounds(1126/2 + 10, 770/2, 100, 100);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (countdown > 0) {
                    int number1 = random.nextInt(6) + 1;
                    int number2 = random.nextInt(6) + 1;

                    label1.setText(Integer.toString(number1));
                    label2.setText(Integer.toString(number2));

                    countdown--;
                } else if (countdown > -20) {
                    label1.setText(Integer.toString(leftNumber));
                    label2.setText(Integer.toString(rightNumber));

                    countdown--;
                } else {
                    label1.setVisible(false);
                    label2.setVisible(false);
                    timer.cancel();
                }

                mapView.getMapPanel().revalidate();
                mapView.getMapPanel().repaint();
            }
        }, 0, 50);











    }
}
