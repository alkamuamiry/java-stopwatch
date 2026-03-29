import java.awt.GridBagConstraints;

import  javax.swing.*;
public class frame extends JFrame {
    GridBagConstraints abc;
    frame(String name){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,500);
        setTitle(name);
        
    }
    void build(){}

    
}
