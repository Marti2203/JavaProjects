package main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Program
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Excelsior!");
		JTable table = new JTable(new SpreadsheetModel(15, 5));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setCellSelectionEnabled(true);
		frame.getContentPane().add(new JScrollPane(table));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.show();
	}
}
