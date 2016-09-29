package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class ClosableTabs extends JTabbedPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addTab(String title, Color color)
	{
		JPanel pane = new JPanel();
		pane.setBackground(color);
		int loc = getTabCount();
		insertTab(title, null, pane, null, loc);
		setTabComponentAt(loc, new Tab(title));
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new JFrame("Closable Tabs");
				ClosableTabs tabs = new ClosableTabs();
				tabs.addTab("Blue", Color.BLUE);
				tabs.addTab("Green", Color.GREEN);
				tabs.addTab("Red", Color.RED);
				frame.add(tabs);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(300, 150));
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private class Tab extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Tab(String title)
		{
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setOpaque(false);
			// The tab's title
			JLabel label = new JLabel(title);
			// Creating a space to the right of the close button
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
			add(label);
			// The tab's close button
			JButton button = new CloseButton();
			add(button);
			// This is necessary for vertical alignment of the
			// tab's content
			setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		}

		private class CloseButton extends JButton implements ActionListener
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public CloseButton()
			{
				setPreferredSize(new Dimension(20, 20));
				setOpaque(false);
				setContentAreaFilled(false);
				setBorderPainted(false);
				setRolloverEnabled(true);
				setFocusable(false);
				addActionListener(this);
			}

			public void actionPerformed(ActionEvent e)
			{
				int i = ClosableTabs.this.indexOfTabComponent(Tab.this);
				if (i != -1)
				{
					ClosableTabs.this.remove(i);
				}
			}

		protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		// Show red on roll-over
		g2.setColor(Color.BLACK);
		if (getModel().isRollover()) {
		g2.setColor(Color.RED);
		}
		// Paint the "X"
		int offset = 5;
		g2.drawLine(offset, offset, getWidth() -
		offset - 1, getHeight() - offset - 1);
		g2.drawLine(getWidth() - offset - 1, offset,
		offset, getHeight() - offset - 1);
		g2.dispose();
		}
		}
	}
}
