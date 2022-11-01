package Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Framework extends JFrame  {
    JLayeredPane backgroundJLP;
    public Framework(){
        SwingUtilities.invokeLater(()->{
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);




        JButton Start = new JButton();
        Start.setVisible(true);
        Start.setText("Start");
        Start.setBounds(400,125,300,100);
        Start.setFocusable(false);
        this.add(Start);
        Start.addActionListener(e -> {
            this.dispose();
            new Settings();
        });
        JButton High = new JButton();
        High.setVisible(true);
        High.setText("High Scores");
        High.setBounds(400,275,300,100);
        High.setFocusable(false);
        this.add(High);
        High.addActionListener(e -> {
            this.dispose();
            new HighScores();
        });
        JButton Exit = new JButton();
        Exit.setVisible(true);
        Exit.setText("Exit");
        Exit.setBounds(400,425,300,100);
        Exit.setFocusable(false);
        this.add(Exit);
        Exit.addActionListener(e -> {
            this.dispose();
            System.exit(0);
        });
    });




}
}