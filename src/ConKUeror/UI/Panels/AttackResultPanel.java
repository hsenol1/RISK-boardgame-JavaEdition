package ConKUeror.UI.Panels;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AttackResultPanel extends JPanel {
    private int minInfantryValue = 1;
    private int minCavalryValue = 0;
    private int minArtilleryValue = 0;

    private int maxInfantryValue;
    private int maxCavalryValue;
    private int maxArtilleryValue;

    private String title;

    private int infantryValue;
    private int cavalryValue;
    private int artilleryValue;

    private JLabel infantryLabel;
    private JLabel cavalryLabel;
    private JLabel artilleryLabel;

    public AttackResultPanel (String title)
    {
        super();
        this.title = title;
        JLabel titleLabel = new JLabel(title);
        this.add(titleLabel);
        infantryLabel = new JLabel("Infantry: " + minInfantryValue);
        cavalryLabel = new JLabel("Cavalry: " + minCavalryValue);
        artilleryLabel = new JLabel("Artillery: " + minArtilleryValue);  
        this.add(infantryLabel);
        this.add(cavalryLabel);
        this.add(artilleryLabel);
    }

    public void createSlider()
    {

        //create infantry slider only if infantries exist
        if (maxInfantryValue > 0)
        {
            JSlider infantrySlider = new JSlider(minInfantryValue, maxInfantryValue, minInfantryValue);
            infantrySlider.setPaintLabels(true);
            infantrySlider.setMajorTickSpacing(maxInfantryValue - minInfantryValue);
            infantrySlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    JSlider eventSource = (JSlider) e.getSource();
                    infantryValue = eventSource.getValue();
                    infantryLabel.setText("Infantry: " + infantryValue);
                }
            });
            this.add(infantrySlider);
        }

        //create cavalry slider only if cavalries exist
        if (maxCavalryValue > 0)
        {
            JSlider cavalrySlider = new JSlider(minCavalryValue, maxCavalryValue, minCavalryValue);
            cavalrySlider.setPaintLabels(true);
            cavalrySlider.setMajorTickSpacing(maxCavalryValue - minCavalryValue);
            cavalrySlider.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    JSlider eventSource = (JSlider) e.getSource();
                    cavalryValue = eventSource.getValue();
                    cavalryLabel.setText("Cavalry: " + cavalryValue);
                }
            });
            this.add(cavalrySlider);
        }
        
        //create artillery slider only if artilleries exist
        if (maxArtilleryValue > 0)
        {
            JSlider artillerySlider = new JSlider(minArtilleryValue, maxArtilleryValue, minArtilleryValue);
            artillerySlider.setPaintLabels(true);
            artillerySlider.setMajorTickSpacing(maxArtilleryValue - minArtilleryValue);
            artillerySlider.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    JSlider eventSource = (JSlider) e.getSource();
                    artilleryValue = eventSource.getValue();
                    artilleryLabel.setText("Artillery: " + artilleryValue);
                }
            });
            this.add(artillerySlider);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setMaxInfantryValue(int maxInfantryValue)
    {
        this.maxInfantryValue = maxInfantryValue;
    }

    public void setMaxCavalryValue(int maxCavalryValue)
    {
        this.maxCavalryValue = maxCavalryValue;
    }

    public void setMaxArtilleryValue(int maxArtilleryValue)
    {
        this.maxArtilleryValue = maxArtilleryValue;
    }

    public int getInfantryValue()
    {
        return this.infantryValue;
    }

    public int getCavalryValue()
    {
        return this.cavalryValue;
    }

    public int getArtilleryValue()
    {
        return this.artilleryValue;
    }
}
