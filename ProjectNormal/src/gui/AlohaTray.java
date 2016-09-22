package gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AlohaTray
{
	public static void main(String[] args) throws AWTException
	{
		MenuItem greetItem = new MenuItem("Greet me");
		// Listen for a menu selection and display a greeting dialog
		greetItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Aloha!");
				System.exit(0);
			}
		});
		// Create the TrayIcon's PopupMenu and add the MenuItem
		PopupMenu popup = new PopupMenu();
		popup.add(greetItem);
		// Create the TrayIcon and add it to the SystemTray
		TrayIcon trayIcon = new TrayIcon(getIconImage(), "A friendly greeting", popup);
		SystemTray.getSystemTray().add(trayIcon);
	}

	// Grabbing a default Swing icon for the SystemTray
	private static Image getIconImage()
	{
		Icon icon = UIManager.getIcon("OptionPane.informationIcon");
		BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		icon.paintIcon(null, image.getGraphics(), 0, 0);
		return image;
	}
}