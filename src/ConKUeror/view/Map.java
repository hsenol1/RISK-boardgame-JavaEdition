package src.ConKUeror.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.ConKUeror.controller.MapHandler;

public class Map extends JFrame{

    MapHandler mapHandler;
    public BufferedImage image;
    JPanel mapPanel;
    String armyNum =String.valueOf(0);
    Boolean disable = false;

    


public Map(MapHandler _mapHandler) throws IOException {

    this.mapHandler = _mapHandler;
    
    initGUI();
}

public void initGUI() throws IOException {

    image = ImageIO.read(getClass().getResourceAsStream("/src/images/worldMap.png"));
    setSize(image.getWidth(), image.getHeight());
    mapPanel = new JPanel() {
        BufferedImage backgroundImage = image;
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, null); // draw the image
        }
    };
    mapPanel.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    mapPanel.setLayout(null); // switch to null layout manager

    
    add(mapPanel);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null); // Center the frame on the screen

    setVisible(true);
    initButtons() ;

} 

public void initButtons() {

    JButton button1 = new JButton(armyNum);
button1.setBounds(69, 102, 40, 40); // set the button's location and size
button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button1.setVisible(false);
        }
    }
});

JButton button2 = new JButton(armyNum);
button2.setBounds(171, 102, 40, 40); // set the button's location and size
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button2.setVisible(false);
        }
    }
});

JButton button3 = new JButton(armyNum);
button3.setBounds(368, 60, 40, 40); // set the button's location and size
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button3.setVisible(false);
        }
    }
});

JButton button4 = new JButton(armyNum);
button4.setBounds(155, 164, 40, 40); // set the button's location and size
button4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button4.setVisible(false);
        }
    }
});

JButton button5 = new JButton(armyNum);
button5.setBounds(232, 182, 40, 40); // set the button's location and size
button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button6 = new JButton(armyNum);
button6.setBounds(303, 175, 40, 40); // set the button's location and size
button6.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button7 = new JButton(armyNum);
button7.setBounds(162, 236, 40, 40); // set the button's location and size
button7.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button8 = new JButton(armyNum);
button8.setBounds(249, 271, 40, 40); // set the button's location and size
button8.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button9 = new JButton(armyNum);
button9.setBounds(178, 342, 40, 40); // set the button's location and size
button9.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button10 = new JButton(armyNum);
button10.setBounds(246, 402, 40, 40); // set the button's location and size
button10.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button11 = new JButton(armyNum);
button11.setBounds(264, 505, 40, 40); // set the button's location
button11.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button12 = new JButton(armyNum);
button12.setBounds(343, 478, 40, 40); // set the button's location
button12.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});
JButton button13 = new JButton(armyNum);
button13.setBounds(266, 597, 40, 40); // set the button's location
button13.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button14 = new JButton(armyNum);
button14.setBounds(439, 228, 40, 40); // set the button's location
button14.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});
JButton button15 = new JButton(armyNum);
button15.setBounds(463, 141, 40, 40); // set the button's location
button15.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button16 = new JButton(armyNum);
button16.setBounds(532, 151, 40, 40); // set the button's location
button16.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});
JButton button17 = new JButton(armyNum);
button17.setBounds(643, 199, 40, 40); // set the button's location
button17.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button18 = new JButton(armyNum);
button18.setBounds(545, 236, 40, 40); // set the button's location
button18.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button19 = new JButton(armyNum);
button19.setBounds(455, 341, 40, 40); // set the button's location
button19.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button20 = new JButton(armyNum);
button20.setBounds(564, 304, 40, 40); // set the button's location
button20.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button21 = new JButton(armyNum);
button21.setBounds(501, 453, 40, 40); // set the button's location
button21.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button22 = new JButton(armyNum);
button22.setBounds(585, 416, 40, 40); // set the button's location
button22.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button23 = new JButton(armyNum);
button23.setBounds(643, 495, 40, 40); // set the button's location
button23.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button24 = new JButton(armyNum);
button24.setBounds(583, 542, 40, 40); // set the button's location

button24.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button25 = new JButton(armyNum);
button25.setBounds(594, 638, 40, 40); // set the button's location
button25.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button26 = new JButton(armyNum);
button26.setBounds(692, 641, 40, 40); // set the button's location
button26.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button27 = new JButton(armyNum);
button27.setBounds(666, 372, 40, 40); // set the button's location
button27.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button28 = new JButton(armyNum);
button28.setBounds(733, 257, 40, 40); // set the button's location
button28.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button29 = new JButton(armyNum);
button29.setBounds(751, 170, 40, 40); // set the button's location
button29.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button30 = new JButton(armyNum);
button30.setBounds(813, 127, 40, 40); // set the button's location
button30.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button31 = new JButton(armyNum);
button31.setBounds(896, 85, 40, 40); // set the button's location
button31.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button32 = new JButton(armyNum);
button32.setBounds(978, 93, 40, 40); // set the button's location
button32.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button33 = new JButton(armyNum);
button33.setBounds(880, 178, 40, 40); // set the button's location
button33.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button34 = new JButton(armyNum);
button34.setBounds(893, 248, 40, 40); // set the button's location
button34.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button35 = new JButton(armyNum);
button35.setBounds(1000, 260, 40, 40); // set the button's location
button35.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button36 = new JButton(armyNum);
button36.setBounds(861, 321, 40, 40); // set the button's location
button36.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button37 = new JButton(armyNum);
button37.setBounds(791, 373, 40, 40); // set the button's location
button37.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button38 = new JButton(armyNum);
button38.setBounds(888, 415 , 40, 40); // set the button's location
button38.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button39 = new JButton(armyNum);
button39.setBounds(906, 545, 40, 40); // set the button's location
button39.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button40 = new JButton(armyNum);
button40.setBounds(999, 502, 40, 40); // set the button's location
button40.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button41 = new JButton("33");
button41.setBounds(948, 641, 40, 40); // set the button's location
button41.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button41.setVisible(false);
        }
    }
});

JButton button42 = new JButton("44");
button42.setBounds(1041, 616, 40, 40); // set the button's location
button42.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button42.setVisible(false);
        }
    }
});JButton button43 = new JButton("P");
button43.setBounds(19, 15, 40, 40); // set the button's location
button43.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        if (disable) {
            button43.setVisible(false);
        }
    }
});

JButton button44 = new JButton("H");
button44.setBounds(86, 15, 40, 40); // set the button's location
button44.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});JButton button45 = new JButton("Roll");
button45.setBounds(76, 530, 80, 80); // set the button's location
button45.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});

JButton button46 = new JButton("Next");
button46.setBounds(76, 644, 80, 80); // set the button's location
button46.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
    }
});



JButton button47 = new JButton("Execute");
button47.setBounds(76, 416, 80, 80); // set the button's location

button47.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       
        // handle button click event
    }
});

JButton button48 = new JButton("11");
button48.setBounds(354,332,80,40); // set the button's location and size
button48.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        disable = true;
    }
});

JButton button49 = new JButton("22");
button49.setBounds(838,592,80,40); // set the button's location and size
button49.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // handle button click event
        disable = false;
        button48.setVisible(false);
    }
});




// Add more buttons here as needed

mapPanel.setLayout(null); // switch to null layout manager
mapPanel.add(button1);
mapPanel.add(button2);
mapPanel.add(button3);
mapPanel.add(button4);
mapPanel.add(button5);
mapPanel.add(button6);
mapPanel.add(button7);
mapPanel.add(button8);
mapPanel.add(button9);
mapPanel.add(button10);
mapPanel.add(button11);
mapPanel.add(button12);
mapPanel.add(button13);
mapPanel.add(button14);
mapPanel.add(button15);
mapPanel.add(button16);
mapPanel.add(button17);
mapPanel.add(button18);
mapPanel.add(button19);
mapPanel.add(button20);
mapPanel.add(button21);
mapPanel.add(button22);
mapPanel.add(button23);
mapPanel.add(button24);
mapPanel.add(button25);
mapPanel.add(button26);
mapPanel.add(button27);
mapPanel.add(button28);
mapPanel.add(button29);
mapPanel.add(button30);
mapPanel.add(button31);
mapPanel.add(button32);
mapPanel.add(button33);
mapPanel.add(button34);
mapPanel.add(button35);
mapPanel.add(button36);
mapPanel.add(button37);
mapPanel.add(button38);
mapPanel.add(button39);
mapPanel.add(button40);
mapPanel.add(button41);
mapPanel.add(button42);
mapPanel.add(button43);
mapPanel.add(button44);
mapPanel.add(button45);
mapPanel.add(button46);
mapPanel.add(button47);
mapPanel.add(button48);
mapPanel.add(button49);






// Add more buttons here as needed

mapPanel.revalidate();
mapPanel.repaint();

}



}
