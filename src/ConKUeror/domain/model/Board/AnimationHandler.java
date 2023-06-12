
package ConKUeror.domain.model.Board;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ConKUeror.UI.Buttons.TerritoryButton;
import ConKUeror.UI.Frames.MapView;

public class AnimationHandler {
    private Map<TerritoryButton, Timer> animationTimers = new HashMap<>();
    private Map<Integer, JLabel> animationLabels = new HashMap<>();
    private MapView mapView;

    public AnimationHandler(MapView mapView) {
        this.mapView = mapView;
    }

    public void startPlusThreeAnimation(TerritoryButton button, int animVal) {
        int x = button.getX() + button.getWidth() / 2;
        int y = button.getY() - 20;
        String toStrVal = Integer.toString(animVal);
        JLabel label = createAnimationLabel(toStrVal, x, y);
        animationLabels.put(button.getID(), label);
        mapView.getMapPanel().add(label);
        mapView.getMapPanel().revalidate();
        mapView.getMapPanel().repaint();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                removeAnimation(button);
                refreshUI();
            }
        };
        animationTimers.put(button, timer);
        timer.schedule(task, 2000);
    }

    private JLabel createAnimationLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setSize(label.getPreferredSize());
        label.setLocation(x - label.getWidth() / 2, y);
        return label;
    }

    private void removeAnimation(TerritoryButton button) {
        Timer timer = animationTimers.remove(button);
        JLabel label = animationLabels.remove(button.getID());
        if (timer != null) {
            timer.cancel();
        }
        if (label != null) {
            mapView.getMapPanel().remove(label);
            mapView.getMapPanel().revalidate();
            mapView.getMapPanel().repaint();
        }
    }

    public void refreshUI() {
        mapView.getMapPanel().revalidate();
        mapView.getMapPanel().repaint();
    }
}