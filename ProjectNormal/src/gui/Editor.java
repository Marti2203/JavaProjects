package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Editor extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane textPane = new JEditorPane();
	private File currentFile;
	private boolean saveAs = false;

	public Editor()
	{
		super("Editor v1.0");
		Container content = getContentPane(); // unnecessary in 5.0+
		content.add(new JScrollPane(textPane), BorderLayout.CENTER);
		JMenu menu = new JMenu("File");

		JMenuItem newItem = makeMenuItem("New");
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menu.add(newItem);

		JMenuItem openItem = makeMenuItem("Open");
		openItem.setMnemonic(KeyEvent.VK_O);
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		menu.add(openItem);

		JMenuItem saveItem = makeMenuItem("Save");
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menu.add(saveItem);

		JMenuItem saveAsItem = makeMenuItem("Save As");
		saveAsItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		menu.add(saveAsItem);

		JMenuItem quitItem = makeMenuItem("Quit");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		menu.add(quitItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		switch (command)
		{
			case "Quit":
				System.out.println("Exited");
				System.exit(0);
				break;
			case "Open":
				loadFile();
				break;
			case "Save":
				saveFile();
				break;
			case "New":
				newFile();
				break;
			case "Save As":
				saveNewFile();
				break;
			default:
				System.out.println("ERROR");
				break;
		}
	}

	private void newFile()
	{
		if (textPane.getText().equals("")) return;
		int resultOption = JOptionPane.showConfirmDialog(null, "Do you want to save the current file?");
		if (resultOption == JOptionPane.CANCEL_OPTION)
			return;
		else if (resultOption == JOptionPane.NO_OPTION)
			clearTextPane();
		else
		{
			saveFile();
			clearTextPane();
		}
	}

	private void clearTextPane()
	{
		textPane.setText("");
	}

	private void loadFile()
	{
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION) return;
		try
		{
			File file = chooser.getSelectedFile();
			currentFile = file;
			@SuppressWarnings("deprecation")
			java.net.URL url = file.toURL();
			textPane.setPage(url);
		}
		catch (Exception e)
		{
			textPane.setText("Could not load file: " + e);
		}
	}

	private void saveFile()
	{
		if (currentFile == null)
		{
			saveNewFile();
			return;
		}
		Write();

	}

	private void saveNewFile()
	{
		JFileChooser chooser = new JFileChooser();
		if (currentFile != null) chooser.setCurrentDirectory(currentFile);
		int resultChooser = chooser.showSaveDialog(this);
		if (resultChooser == JFileChooser.CANCEL_OPTION) return;
		File file = chooser.getSelectedFile();
		if (file.exists() || file.equals(currentFile))
		{
			int resultOption = JOptionPane.showConfirmDialog(null, "Do you want to overwrite the file?");
			if (resultOption != JOptionPane.OK_OPTION) { return; }
		}
		currentFile = file;
		Write();

	}

	private void Write()
	{
		Writer writer;
		try
		{
			writer = new PrintWriter(currentFile);
			writer.write(textPane.getText());
			writer.close();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private JMenuItem makeMenuItem(String name)
	{
		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}

	public static void main(String[] s)
	{
		new Editor().setVisible(true);
	}
}