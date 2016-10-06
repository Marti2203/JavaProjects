package main;

import java.util.StringTokenizer;

import javax.swing.table.AbstractTableModel;

public class SpreadsheetModel extends AbstractTableModel
{
	Expression[][] data;

	public SpreadsheetModel(int rows, int cols)
	{
		data = new Expression[rows][cols];
	}

	public void setValueAt(Object value, int row, int col)
	{
		data[row][col] = new Expression((String) value);
		fireTableDataChanged();
	}

	public Object getValueAt(int row, int col)
	{
		if (data[row][col] != null) try
		{
			return Float.toString(data[row][col].eval());
		}
		catch (BadExpression e)
		{
			return "Error";
		}
		return "";
	}

	public int getRowCount()
	{
		return data.length;
	}

	public int getColumnCount()
	{
		return data[0].length;
	}

	public boolean isCellEditable(int row, int col)
	{
		return true;
	}

	class Expression
	{
		String text;
		StringTokenizer tokens;
		String token;

		Expression(String text)
		{
			this.text = text.trim();
		}

		float eval() throws BadExpression
		{
			tokens = new StringTokenizer(text, " */+-()", true);
			try
			{
				return sum();
			}
			catch (Exception e)
			{
				throw new BadExpression();
			}
		}

		private float sum()
		{
			float value = term();
			while (hasMore() && match("+-"))
				if (match("+"))
				{
					consumeOperator();
					value = value + term();
				}
				else
				{
					consumeOperator();
					value = value - term();
				}
			return value;
		}

		private float term()
		{
			float value = getElement();
			while (hasMore() && match("*/"))
				if (match("*"))
				{
					consumeOperator();
					value = value * getElement();
				}
				else
				{
					consumeOperator();
					value = value / getElement();
				}
			return value;
		}

		private float getElement()
		{
			float value;
			if (match("("))
			{
				consumeOperator();
				value = sum();
			}
			else
			{
				String svalue;
				if (Character.isLetter(token().charAt(0)))
				{
					int col = findColumn(token().charAt(0) + "");
					int row = Character.digit(token().charAt(1), 10);
					svalue = (String) getValueAt(row, col);
				}
				else svalue = token();
				value = Float.parseFloat(svalue);
			}
			consumeOperator(); // ")" or value token
			return value;
		}

		private String token()
		{
			if (token == null) while ((token = tokens.nextToken()).equals(" "));
			return token;
		}

		private void consumeOperator()
		{
			token = null;
		}

		private boolean match(String s)
		{
			return s.indexOf(token()) != -1;
		}

		private boolean hasMore()
		{
			return tokens.hasMoreTokens();
		}
	}

	class BadExpression extends Exception
	{
	}
}
