package Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckReversed extends JButton implements ActionListener {
    int  randomY = (int) (1 + (Math.random() * 300));
    int count=0;
    int dmg=2;
    boolean flew=false;
    boolean dead=false;
    boolean sorted=false;
    boolean sorted1=false;
    int DuckVelocity=0;
    int value;
    int lives;
    public DuckReversed(){
        int DuckRandomizer = (int) (Math.random()*10 +1);
        if(DuckRandomizer>5){
            lives=2;
            value=4;
            ImageIcon duck = new ImageIcon("Project2/duckGR.png");
            this.setFocusable(false);
            this.setBounds(0,randomY,100,50);
            this.setIcon(duck);
            this.setVisible(true);
            this.setBorder(null);
            this.setOpaque(false);
            this.addActionListener(this);
            this.setContentAreaFilled(false);
        }
        if(DuckRandomizer==5 || DuckRandomizer==4 || DuckRandomizer==3  ){
            lives=4;
            value=8;
            ImageIcon duck = new ImageIcon("Project2/duckRR.png");
            this.setFocusable(false);
            this.setBounds(0,randomY,100,50);
            this.setIcon(duck);
            this.setVisible(true);
            this.setBorder(null);
            this.addActionListener(this);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
        }
        if(DuckRandomizer==2 || DuckRandomizer==1){
            lives=6;
            value=16;
            ImageIcon duck = new ImageIcon("Project2/duckPR.png");
            this.setFocusable(false);
            this.setBounds(0,randomY,100,50);
            this.setIcon(duck);
            this.setVisible(true);
            this.setBorder(null);
            this.addActionListener(this);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
        }
        new Thread(()->{
            while (!Thread.interrupted()) {
                for (int i = 1200 ; i>=0; i=i-DuckVelocity) {
                    try {
                        Thread.sleep(13);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setLocation(i,randomY);
                    if(i<50){
                        flew=true;
                        this.setVisible(false);
                    }

                }
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            dmg=dmg* GameF.upgradeLvl;
            this.lives=this.lives-dmg;
            System.out.println("lives " + this.lives);
            System.out.println("dmg "+dmg);
            if(this.lives<=0){
                this.setVisible(false);
                this.dead=true;
            }
        }
    }
}