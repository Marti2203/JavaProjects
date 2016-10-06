package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class CanisMinor extends JFrame
{
	protected JEditorPane mEditorPane;
	protected JTextField mURLField;

	public CanisMinor(String urlString)
	{
		super("CanisMinor v1.0");
		createGUI(urlString);
	}

	protected void createGUI(String urlString)
	{
		setLayout(new BorderLayout());
		JToolBar urlToolBar = new JToolBar();
		mURLField = new JTextField(urlString, 40);
		urlToolBar.add(new JLabel("Location "));
		urlToolBar.add(mURLField);
		add(urlToolBar, BorderLayout.NORTH);
		mEditorPane = new JEditorPane();
		mEditorPane.setEditable(false);
		add(new JScrollPane(mEditorPane), BorderLayout.CENTER);
		openURL(urlString);
		mURLField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				openURL(ae.getActionCommand());
			}
		});
		mEditorPane.addHyperlinkListener(new LinkActivator());
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void openURL(String urlString)
	{
		try
		{
			URL url = new URL(urlString);
			mEditorPane.setPage(url);
			mURLField.setText(url.toExternalForm());
		}
		catch (Exception e)
		{
			System.out.println("Couldn't open " + urlString + ":" + e);
		}
	}

	class LinkActivator implements HyperlinkListener
	{
		public void hyperlinkUpdate(HyperlinkEvent he)
		{
			HyperlinkEvent.EventType type = he.getEventType();
			if (type == HyperlinkEvent.EventType.ACTIVATED) openURL(he.getURL().toExternalForm());
		}
	}

	public static void main(String[] args)
	{
		String urlString = "http://en.wikinews.org/wiki/Special:Random";
		if (args.length > 0) urlString = args[0];
		new CanisMinor(urlString).setVisible(true);
	}
}