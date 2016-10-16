/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author marti
 */
public class ShowApplet extends JApplet {

    JTextArea text = new JTextArea();
    int startCount;

    public void init() {
        JButton button = new JButton("Press Me");
        button.addActionListener((ActionEvent e) -> {
            text.append("Button Pressed!\n");
        });
        getContentPane().add("Center", new JScrollPane(text));
        JPanel panel = new JPanel();
        panel.add(button);
        getContentPane().add("South", panel);
        text.append("Java Version: "
                + System.getProperty("java.version") + "\n");
        text.append("Applet init()\n");
    }

    public void start() {
        text.append("Applet started: " + startCount++ + "\n");
    }

    public void stop() {
        text.append("Applet stopped.\n");
    }
}
