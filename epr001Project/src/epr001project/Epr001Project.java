/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        frame.setSize(400, 310);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Main main = new Main();
        frame.add(main);
        frame.setVisible(true);
    }
    
}
