package Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Cloud extends JButton {
    int  randomY = (int) (1 + (Math.random() * 300));
    public Cloud(){



        this.setFocusable(false);
        this.setBounds(0,randomY,150,75);
        ImageIcon Cloud = new ImageIcon("Project2/Cloud.png");
        this.setIcon(Cloud);
        this.setVisible(true);
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        
        new Thread(()->{
            while (!Thread.interrupted()) {
                for (int i = 0 ; i <=1050; i++) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setLocation(i,randomY);
                }
                for (int i = 1050 ; i >=0; i--) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setLocation(i,randomY);
                }

            }
        }).start();
    }


}
