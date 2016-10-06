package gui;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.print.PrinterException;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.regex.PatternSyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SortFilterTable extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField filterField;

	public SortFilterTable()
	{
		super("Table Sorting & Filtering");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a simple table model
		TableModel model = new AbstractTableModel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String[] columns =
			{ "Name", "Pet", "Children" };
			private Object[][] people =
			{
					{ "Dan Leuck", "chameleon", 1 },
					{ "Pat Niemeyer", "sugar glider", 2 },
					{ "John Doe", "dog", 3 },
					{ "Jane Doe", "panda", 2 } };

			public int getColumnCount()
			{
				return columns.length;
			}
			@Override
			public String getColumnName(int column)
			{
				return columns[column];
			}
			public int getRowCount()
			{
				return people.length;
			}

			public Object getValueAt(int row, int col)
			{
				return people[row][col];
			}

			public Class<?> getColumnClass(int col)
			{
				return getValueAt(0, col).getClass();
			}
		};
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);// Create the filter area
		JPanel filterPanel = new JPanel(new BorderLayout());
		JLabel filterLabel = new JLabel("Filter ", SwingConstants.TRAILING);
		filterPanel.add(filterLabel, BorderLayout.WEST);
		filterField = new JTextField();
		filterLabel.setLabelFor(filterField);
		filterPanel.add(filterField);
		// Apply the filter when the filter text field changes
		filterField.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent e)
			{
				filter();
			}

			public void insertUpdate(DocumentEvent e)
			{
				filter();
			}

			public void removeUpdate(DocumentEvent e)
			{
				filter();
			}
		});
		filterPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		add(filterPanel, BorderLayout.NORTH);
		add(new JScrollPane(table));
		setReverseSorter();
	}

	// Filter on the first column
	private void filter()
	{
		RowFilter<TableModel, Object> filter = null;
		// Update if the filter expression is valid
		try
		{
			// Apply the regular expression to columns 0 and 1
			filter = RowFilter.regexFilter(filterField.getText(), 0, 1);
		}
		catch (PatternSyntaxException e)
		{
			return;
		}
		((TableRowSorter<TableModel>) table.getRowSorter()).setRowFilter(filter);
	}

	private void setReverseSorter()
	{
		TableRowSorter<TableModel> reverseSorter = new TableRowSorter<TableModel>(table.getModel());
		Comparator<String> comparerString=new Comparator<String>()
		{
			public int compare(String a, String b)
			{
				return -a.compareTo(b);
			}
		};		Comparator<Integer> comparerInteger=new Comparator<Integer>()
		{
			public int compare(Integer a, Integer b)
			{
				return -a.compareTo(b);
			}
		};
			reverseSorter.setComparator(0,comparerString);
			reverseSorter.setComparator(1,comparerString);
			reverseSorter.setComparator(2,comparerInteger);
		
		table.setRowSorter(reverseSorter);
	}

	public static void main(String[] args)
	{
		new SortFilterTable().setVisible(true);
	}
}