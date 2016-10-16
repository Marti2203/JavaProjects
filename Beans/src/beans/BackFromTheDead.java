/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.Beans;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author marti
 */
public class BackFromTheDead extends JFrame {

    public BackFromTheDead(String name) {
        super("Revived Beans!");
        try {
            Object bean = Beans.instantiate(
                    getClass().getClassLoader(), name);
            if (Beans.isInstanceOf(bean, JComponent.class)) {
                JComponent comp = (JComponent) Beans.getInstanceOf(bean, JComponent.class);
                getContentPane().add("Center", comp);
            } else {
                System.out.println("Bean is not a JComponent...");
            }
        } catch (java.io.IOException e1) {
            System.out.println("Error loading the serialized object");
        } catch (ClassNotFoundException e2) {
            System.out.println(
                    "Can't find the class that goes with the object");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new BackFromTheDead("beans\\Dial_juggler1");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
