package Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameF extends JFrame implements ActionListener, KeyListener {
    public int difficulty;
    public int UserLives=10;
    JLayeredPane backgroundJLP;
    public ArrayList<Duck> ducks = new ArrayList<Duck>();
    public ArrayList<DuckReversed> ducksR = new ArrayList<DuckReversed>();
    int gold=0;
    static int upgradeLvl=1;
    int seconds=0;
    int velocity=1;
    int minutes=0;
    int Cost=30;
    boolean ctrl = false;
    boolean Q = false;
    boolean shift = false;
    static int Score=0;
    int hours=0;
    public JLabel health;
    public JButton upgrade;
   public JLabel scoreJL;
   boolean interrupted = false;
    public JLabel goldJL;
    public JLabel time;
    boolean ended=false;
    boolean STOP=false;
    Thread timeThread =new Thread(() -> {
        time.setText("00:00");
        Score=0;
        int i=0;
        backgroundJLP.add(new Tree(), Integer.valueOf(5));
        while (!Thread.interrupted() && !STOP) {
                i++;
            health.setText("Hp:" + this.UserLives);
            goldJL.setText("Gold " + this.gold);
            upgrade.setText("Upgrade " + this.Cost);
            scoreJL.setText("Score " + this.Score);

            try {
                Thread.sleep(1000);
                seconds++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(seconds==60){
                seconds=0;
                minutes++;
                if(minutes==60){
                    minutes=0;
                    hours++;
                }
            }
            if(minutes<10 && seconds<10) time.setText("0"+minutes + ":0" + seconds);
            if(minutes<10 && seconds>10) time.setText("0"+minutes + ":" + seconds);
            if(minutes>10 && seconds>10) time.setText(minutes + ":" + seconds);
            if(minutes>10 && seconds<10) time.setText(minutes + ":0" + seconds);
            for(DuckReversed e : ducksR){
                if(e.dead && !e.sorted1){
                    gold= gold + e.value;
                    e.sorted1=true;
                    Score = Score + e.value;
                }
                if(e.flew && !e.sorted && !e.dead){
                    UserLives--;
                    e.sorted=true;
                }
            }
            for(Duck e : ducks){
                if(e.dead && !e.sorted1){
                    gold= gold + e.value;
                    e.sorted1=true;
                    Score = Score + e.value;
                }
                if(e.flew && !e.sorted && !e.dead){
                    UserLives--;
                    e.sorted=true;
                }
            }

            if(i%3==0) fly();
            if(i%5==0) velocity++;
            if(i%2==0) flyR();
            if(i==1 || i==5 || i==18 || i==23){
                backgroundJLP.add(new Cloud(), Integer.valueOf(4));
            }


            backgroundJLP.repaint();
            if(UserLives<=0 && !ended) {
                new EndScreen();
                this.dispose();
                interrupted=true;
                ended=true;
            }
        }

    });
    public GameF() {



        GameP game = new GameP();

        this.setLayout(null);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setSize(1200, 750);
        backgroundJLP = new JLayeredPane();
        backgroundJLP.setSize(1200, 750);
        this.add(backgroundJLP);
        backgroundJLP.setVisible(true);

        JLabel backgroundJL = new JLabel(new ImageIcon("Project2/background.png"));
        backgroundJL.setSize(1200, 750);
        backgroundJL.setLayout(null);
        backgroundJL.setBounds(0, 0, 1200, 750);
        backgroundJLP.add(backgroundJL, JLayeredPane.DEFAULT_LAYER);
        backgroundJL.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JPanel healthP =new JPanel();
        healthP.setBackground(Color.CYAN);
        healthP.setBounds(800,500,150,50);
        health = new JLabel();
        healthP.setBackground(new Color(34,177,76));
        health.setText("Hp:" + this.UserLives);
        health.setBounds(0,0,200,100);
        health.setFont(new Font("Verdana", Font.BOLD, 40));
        healthP.add(health);
        backgroundJLP.add(healthP, Integer.valueOf(3));



        JPanel timeP =new JPanel();
        timeP.setBackground(Color.CYAN);
        timeP.setBounds(600,500,150,50);
        time = new JLabel();
        timeP.setBackground(new Color(34,177,76));
        time.setBounds(0,0,200,100);
        time.setFont(new Font("Verdana", Font.BOLD, 40));
        timeP.add(time);
        backgroundJLP.add(timeP, Integer.valueOf(3));

        upgrade = new JButton();
        upgrade.setBounds(200,500,150,50);
        upgrade.setText("Upgrade " + Cost);
        upgrade.setFocusable(false);
        upgrade.addActionListener(this);
        upgrade.setVisible(true);
        backgroundJLP.add(upgrade, Integer.valueOf(5));

        JPanel GoldP =new JPanel();
        GoldP.setBounds(200,600,300,300);
        GoldP.setBackground(new Color(34,177,76));
        goldJL = new JLabel();
        goldJL.setText("Gold " + this.gold);
        goldJL.setBounds(0,0,300,300);
        goldJL.setFont(new Font("Verdana", Font.BOLD, 40));
        GoldP.add(goldJL);
        backgroundJLP.add(GoldP, Integer.valueOf(3));

        JPanel score =new JPanel();
        score.setBounds(200,800,300,300);
        score.setBackground(new Color(0,162,232));
        scoreJL = new JLabel();
        scoreJL.setText("Score " + this.Score);
        scoreJL.setBounds(0,0,300,300);
        scoreJL.setFont(new Font("Verdana", Font.BOLD, 40));
        GoldP.add(scoreJL);
        backgroundJLP.add(score, Integer.valueOf(1));
        timeThread.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(gold>=Cost && upgradeLvl<=3){
            gold = gold - Cost;
            Cost = Cost + 30;
            upgradeLvl++;
        }

    }

    public void fly(){
        Duck duck = new Duck();
        backgroundJLP.add(duck, Integer.valueOf(3));
        ducks.add(duck);
        duck.DuckVelocity = duck.DuckVelocity + velocity;
        if(this.difficulty==3){
            duck.lives= duck.lives * 4;
        }
        if(this.difficulty==2){
            duck.lives= duck.lives * 2;
        }

    }
    public void flyR(){
        DuckReversed duckR = new DuckReversed();
        backgroundJLP.add(duckR, Integer.valueOf(3));
        ducksR.add(duckR);
        duckR.DuckVelocity = duckR.DuckVelocity + velocity;
        if(this.difficulty==3){
            duckR.lives= duckR.lives * 4;
        }
        if(this.difficulty==2){
            duckR.lives= duckR.lives * 2;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(ctrl && Q && shift){
            this.dispose();
            Thread.currentThread().interrupt();
            STOP=true;
            new Framework();
            this.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==17) ctrl=true;
           else if (e.getKeyCode()==16)  shift=true;
              else if (e.getKeyCode()==81) Q=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ctrl=false;
        shift=false;
        Q=false;
    }
}
