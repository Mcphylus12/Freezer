package softwareproject.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends JFrame{
    
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;
    
    public Window(String string) throws HeadlessException {
        super(string);
        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - WIDTH/2), 
                         (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - HEIGHT/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
    }
}