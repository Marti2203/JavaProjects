package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontList
{
	public static void main(String[] args)
	{
		new FontList().getFonts();
	}

	public void getFonts()
	{
		JFrame frame = new JFrame("Font chooser");
		frame.setLayout(new FlowLayout());
		JLabel label = new JLabel("TEST");
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		JList<String> fontFamilies = new JList<>(e.getAvailableFontFamilyNames());
		JCheckBox italicBox = new JCheckBox("Italic");
		JCheckBox boldBox = new JCheckBox("Bold");

		ActionListener listener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				Font currentFont = label.getFont();
				label.setFont(new Font(currentFont.getName(),
						(boldBox.isSelected() ? Font.BOLD : 0) | (italicBox.isSelected() ? Font.ITALIC : 0),
						currentFont.getSize()));
			}
		};
		boldBox.addActionListener(listener);
		italicBox.addActionListener(listener);

		fontFamilies.setVisibleRowCount(4);
		fontFamilies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontFamilies.addListSelectionListener(new ListSelectionListener()
		{

			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				Font currentFont=label.getFont();
				label.setFont(new Font(fontFamilies.getSelectedValue(), currentFont.getStyle(), 20));
			}
		});

		frame.setSize(200, 200);
		frame.add(new JScrollPane(fontFamilies));
		frame.add(label);
		frame.add(italicBox);
		frame.add(boldBox);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
