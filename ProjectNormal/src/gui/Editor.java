package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.MessageFormat;
import java.util.Scanner;

import javax.swing.*;

public class Editor extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane textPane = new JEditorPane();
	private File currentFile;

	public Editor()
	{
		super("Editor v1.0");
		Container content = getContentPane(); // unnecessary in 5.0+
		content.add(new JScrollPane(textPane), BorderLayout.CENTER);
		JMenu fileMenu = new JMenu("File");
		JMenu formatMenu = new JMenu("Format");
		JMenuBar menuBar = new JMenuBar();

		createFileMenu(fileMenu);
		createFormatMenu(formatMenu);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				if (textPane.getText().equals("")) return;
				int result = JOptionPane.showConfirmDialog(Editor.this, "Do you want to save the file");
				if (result == JOptionPane.YES_OPTION) saveFile();
				super.windowClosing(e);
			}
		});

		menuBar.add(fileMenu);
		menuBar.add(formatMenu);
		setJMenuBar(menuBar);
		setSize(300, 300);
		toFront();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createFormatMenu(JMenu formatMenu)
	{
		JMenuItem formatItem = new JMenuItem("Format");
		formatMenu.add(formatItem);

		JList<String> fontFamilies = new JList<>(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		fontFamilies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JCheckBox italicBox = new JCheckBox("Italic");
		JCheckBox boldBox = new JCheckBox("Bold");
		JFormattedTextField sizeField = new JFormattedTextField(new Integer(textPane.getFont().getSize()));

		formatItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				italicBox.setSelected(textPane.getFont().isItalic());
				boldBox.setSelected(textPane.getFont().isBold());
				int changeChoice = JOptionPane.showOptionDialog(Editor.this, new Object[]
				{ new JScrollPane(fontFamilies), sizeField, italicBox, boldBox }, "Font",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (changeChoice != JOptionPane.OK_OPTION) return;
				textPane.setFont(new Font(fontFamilies.getSelectedValue(),
						(boldBox.isSelected() ? Font.BOLD : 0) | (italicBox.isSelected() ? Font.ITALIC : 0),
						(Integer) sizeField.getValue()));
			}
		});

	}

	private void createFileMenu(JMenu menu)
	{
		JMenuItem newItem = createMenuItem("New", KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK, menu);

		JMenuItem openItem = createMenuItem("Open", KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK, menu);

		JMenuItem saveItem = createMenuItem("Save", KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK, menu);

		JMenuItem saveAsItem = createMenuItem("Save As", KeyEvent.VK_S,
				KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK, menu);

		JMenuItem quitItem = createMenuItem("Quit", KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK, menu);
	}

	private JMenuItem createMenuItem(String name, int mnemonic, int modifiers, JMenu menu)
	{
		JMenuItem element = new JMenuItem(name);
		element.addActionListener(this);
		element.setMnemonic(mnemonic);
		element.setAccelerator(KeyStroke.getKeyStroke(mnemonic, modifiers));
		menu.add(element);
		return element;
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
			getConfigurations();
		}
		catch (Exception e)
		{
			textPane.setText("Could not load file: " + e);
			e.printStackTrace();
		}
	}

	private void getConfigurations()
	{
		File configuration = new File(MessageFormat.format("EditorConfigurations/{0}", currentFile.getName()));
		if (!configuration.exists()) return;

		try (Scanner scanner = new Scanner(configuration))
		{
			char[] info = scanner.nextLine().toCharArray();
			int style = info[0];
			int size = info[1];
			String name = new String(info, 2, info.length - 2);
			textPane.setFont(new Font(name, style, size));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setConfigurations()
	{
		File configuration = new File(MessageFormat.format("EditorConfigurations/{0}", currentFile.getName()));
		try (Writer writer = new PrintWriter(configuration))
		{
			Font currentFont = textPane.getFont();
			writer.write(currentFont.getStyle());
			writer.write(currentFont.getSize());
			writer.write(currentFont.getName());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		if (!currentFile.getName().contains(".")) currentFile = new File(currentFile.getAbsolutePath().concat(".txt"));
		Write();

	}

	private void Write()
	{
		setConfigurations();
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

	public static void main(String[] s)
	{
		new Editor().setVisible(true);
	}
}