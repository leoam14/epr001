package epr001project;

import javax.swing.JFrame;

/**
 *
 * @author leoam14
 */
public class Epr001Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Main main = new Main();
        frame.setSize(main.getPreferredSize().width,main.getPreferredSize().height+15);
        frame.add(main);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
