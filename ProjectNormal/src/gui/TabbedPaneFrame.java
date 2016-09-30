package gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TabbedPaneFrame
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("TabbedPaneFrame");
		JTabbedPane tabby = new JTabbedPane();
		// create the controls pane
		JPanel controls = new JPanel();
		controls.add(new JLabel("Service:"));
		JList<String> list = new JList<>(new String[]
		{ "Web server", "FTP server" });
		list.setBorder(BorderFactory.createRaisedBevelBorder());
		list.addListSelectionListener(new ListSelectionListener()
		{
			
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		controls.add(list);
		controls.add(new JButton("Start"));
		// create an image pane
		String filename = "Images/rhino.gif";
		JLabel image = new JLabel(new ImageIcon(filename));
		JComponent picture = new JScrollPane(image);
		tabby.addTab("Controls", controls);
		tabby.addTab("Picture", picture);
		frame.getContentPane().add(tabby);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
