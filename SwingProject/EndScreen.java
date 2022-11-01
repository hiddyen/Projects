package Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class EndScreen extends JFrame implements ActionListener, KeyListener {
    JLayeredPane backgroundJLP;
    JLabel NameFieldJL;
    JButton Submit;
    JTextField Nick;
    boolean ctrl = false;

    boolean Q = false;
    boolean shift = false;
    public EndScreen(){
       this.setLayout(null);
       this.setResizable(false);
       this.setSize(1200,750);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setLocationRelativeTo(null);
       this.addKeyListener(this);
       backgroundJLP = new JLayeredPane();
       backgroundJLP.setSize(1200, 750);
       this.add(backgroundJLP);
       backgroundJLP.setVisible(true);

       JLabel backgroundJL = new JLabel(new ImageIcon("Project2/background1.jpg"));
       backgroundJL.setSize(1200, 750);
       backgroundJL.setLayout(null);
       backgroundJL.setBounds(0, 0, 1200, 750);
       backgroundJLP.add(backgroundJL, JLayeredPane.DEFAULT_LAYER);
       backgroundJL.setVisible(true);

       Submit = new JButton();
       Submit.setBounds(500,400,150,50);
       Submit.setText("Submit");
       Submit.setFocusable(false);
       Submit.addActionListener(this);

       Submit.setVisible(true);
       backgroundJLP.add(Submit, Integer.valueOf(5));

       JLabel nickJL = new JLabel("Nick");
       nickJL.setBounds(525, 250, 400, 45);
       backgroundJLP.add(nickJL,Integer.valueOf(5));
       nickJL.setFont(new Font("Verdana", Font.BOLD, 40));


       Nick = new JTextField();
       Nick.getText();
       Nick.setPreferredSize(new Dimension(100, 20));
       Nick.setBounds(500,300,150,50);
       Nick.setFocusable(true);
       Nick.setVisible(true);
       backgroundJLP.add(Nick, Integer.valueOf(1));

       JLabel ScoreJL = new JLabel("Score:" + GameF.Score);
       ScoreJL.setBounds(500, 150, 400, 45);
       ScoreJL.setFont(new Font("Verdana", Font.BOLD, 40));
       backgroundJLP.add(ScoreJL, Integer.valueOf(1));


    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(ctrl && Q && shift){
            new Framework();
            this.dispose();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit){
            this.dispose();
            System.exit(0);
        }
    }
    public static void writeToFile(int Score) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("scores.txt"));
        objectOutputStream.writeObject(Score);
    }
    public static void readFromFile(int Score) throws IOException{
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("scores.txt"));
    }

}
