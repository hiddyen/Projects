package Project2;

import javax.swing.*;
import java.awt.*;

public class Hp extends JPanel {
    public int UserLives=3;
    public Hp(){
        this.setBounds(700,700,300,100);
        this.setFocusable(false);
        this.setVisible(true);
        this.setBorder(null);
        JLabel h = new JLabel();
        h.setSize(150,50);
        h.setLayout(new GridLayout());
        h.setText(String.valueOf(this.UserLives));
        this.add(h);
        h.setVisible(true);
    }
}
