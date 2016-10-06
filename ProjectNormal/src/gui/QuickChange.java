package gui;

import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class QuickChange extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuickChange()
	{
		super("QuickChange v1.0");
		createGUI();
	}

	protected void createGUI()
	{
		setSize(300, 200);
		JMenu file = new JMenu("File", true);
		JMenuItem quit = new JMenuItem("Quit");
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		file.add(quit);
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		// create the Look & Feel menu
		JMenu lnf = new JMenu("Look & Feel", true);
		ButtonGroup buttonGroup = new ButtonGroup();
		final UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < info.length; i++)
		{
			JRadioButtonMenuItem item = new JRadioButtonMenuItem(info[i].getName(), i == 0);
			final String className = info[i].getClassName();
			item.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					try
					{
						UIManager.setLookAndFeel(className);
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
					SwingUtilities.updateComponentTreeUI(QuickChange.this);
				}
			});
			buttonGroup.add(item);
			lnf.add(item);
		}
		// add the menu bar
		JMenuBar mb = new JMenuBar();
		mb.add(file);
		mb.add(lnf);
		setJMenuBar(mb);
		// add some components
		JPanel jp = new JPanel();
		jp.add(new JCheckBox("JCheckBox"));
		String[] names = new String[]
		{ "Tosca", "Cavaradossi", "Scarpia", "Angelotti", "Spoletta", "Sciarrone", "Carceriere", "Il sagrestano",
				"Un pastore" };
		jp.add(new JComboBox<String>(names));
		jp.add(new JButton("JButton"));
		jp.add(new JLabel("JLabel"));
		jp.add(new JTextField("JTextField"));
		JPanel main = new JPanel(new GridLayout(1, 2));
		main.add(jp);
		main.add(new JScrollPane(new JList<String>(names)));
		setContentPane(main);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new QuickChange().setVisible(true);
	}
}