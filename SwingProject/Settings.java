package Project2;

import javax.swing.*;

public class Settings extends JFrame {
    JLayeredPane backgroundJLP;
    public Settings(){

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);



        JButton Hard = new JButton();
        Hard.setVisible(true);
        Hard.setText("Hard");
        Hard.setBounds(400,125,300,100);
        Hard.setFocusable(false);
        this.add(Hard);
        Hard.addActionListener(e -> {
            this.dispose();
            GameF game = new GameF();
            game.difficulty=3;
        });
        JButton Medium = new JButton();
        Medium.setVisible(true);
        Medium.setText("Medium");
        Medium.setBounds(400,275,300,100);
        Medium.setFocusable(false);
        this.add(Medium);
        Medium.addActionListener(e -> {
            this.dispose();
            GameF game = new GameF();
            game.difficulty=2;
        });
        JButton Easy = new JButton();
        Easy.setVisible(true);
        Easy.setText("Easy");
        Easy.setBounds(400,425,300,100);
        Easy.setFocusable(false);
        this.add(Easy);
        Easy.addActionListener(e -> {
            this.dispose();
            GameF game = new GameF();
            game.difficulty=1;
        });
    }

}
