package screen;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Screen extends JFrame
{
	/**
	* 
	*/
	private Pixel[][] pixels;
	private int rows;
	private int cols;
	private static final long serialVersionUID = 1L;

	public Screen(int rows, int cols)
	{
		super();
		this.rows=rows;
		this.cols=cols;
		pixels = new Pixel[rows][cols];
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(rows, cols, 1, 1));
		panel.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CreatePixles(rows, cols, panel);
		add(new JScrollPane(panel));

	}

	public Screen(int rows,int cols,boolean addColorPalette)
	{
		this(rows, cols);
		if(addColorPalette)
		{
			
		}
	}
	
	public Pixel[][] getPixels()
	{
		return pixels;
	}

	private void CreatePixles(int rows, int cols, Container container)
	{
		new Thread(() ->
		{
			for (int x = 0; x < rows; x++)
				for (int y = 0; y < cols; y++)
				{

					Pixel panel = new Pixel();
					pixels[x][y] = panel;
					panel.setBackground(Color.BLUE);
					panel.setToolTipText(Integer.toString(y, 16) + "," + Integer.toString(x, 16));
					container.add(panel);
				}
			setVisible(true);
			repaint();
		}).start();
	}
	public int getRows(){return rows;}
	public int getCols(){return cols;}
}
