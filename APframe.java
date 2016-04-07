package smallworld;

import java.awt.Container;
import java.awt.Panel;
import javax.swing.JFrame;


public class APframe  extends JFrame{
    public APframe(Graph G)
    {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tableau 10.0 Beta");
        
        Container pane = this.getContentPane();
        APpanel panel = new APpanel(G);
        pane.add(panel);
        this.setVisible(true);
    }
}