package Project2;

import javax.swing.*;

public class Tree extends JButton {
    public Tree(){

       this.setFocusable(false);
       this.setBounds(350,100,301,421);
       ImageIcon Tree = new ImageIcon("Project2/Tree.png");
       this.setIcon(Tree);
       this.setVisible(true);
       this.setBorder(null);
       this.setOpaque(false);
       this.setContentAreaFilled(false);
       this.setFocusable(false);
    }
}
