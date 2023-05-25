package ConKUeror.UI.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ArmySelectionPanel extends JPanel{

   private int min = 1;
   private int maxValue;
   private String name;


   private JLabel valueLabel;
   private int army;


   public ArmySelectionPanel(String title) {
    super();
    this.name = title;
    JLabel titleLabel = new JLabel(title);
    this.add(titleLabel);
    valueLabel = new JLabel(": " + min);
    this.add(valueLabel);
}

public void createSlider() {
    JSlider slider = new JSlider(min, maxValue, min);
    slider.setPaintLabels(true);
    slider.setMajorTickSpacing(maxValue - min);
    slider.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            army =source.getValue();

            valueLabel.setText(": " + source.getValue());
        }
    });
    this.add(slider);
}

public void setMaxValue(int max) {
    this.maxValue=max;

}

public int getValue() {
    return this.army;
}



}
