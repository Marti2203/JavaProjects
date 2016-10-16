/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author marti
 */
public class DynamicHookup extends JFrame {

    JLabel label = new JLabel("Ready...", JLabel.CENTER);
    int count;

    public DynamicHookup() {
        JButton launchButton = new JButton("Launch!");
        getContentPane().add(launchButton, "South");
        getContentPane().add(label, "Center");
        launchButton.addActionListener(
                (ActionListener) EventHandler.create(
                        ActionListener.class, this, "launchTheMissiles"));
    }

    public void launchTheMissiles() {
        label.setText("Launched: " + count++);
    }

    public static void main(String[] args) {
        JFrame frame = new DynamicHookup();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(150, 150);
        frame.setVisible(true);
    }
}
