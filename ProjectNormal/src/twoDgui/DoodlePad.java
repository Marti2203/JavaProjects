package twoDgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import org.omg.CORBA.ACTIVITY_COMPLETED;
import org.omg.CORBA.PRIVATE_MEMBER;

import utils.CharExtender;
import utils.ListExtender;

public class DoodlePad
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("DoodlePad");
		frame.setLayout(new BorderLayout());
		final DrawPad drawPad = new DrawPad();
		frame.add(drawPad, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawPad.clear();
			}
		});
		panel.add(clearButton);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setSize(280, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		ColorScreen screen=new ColorScreen(drawPad);
	}
} // end of class DoodlePad

class DrawPad extends JComponent
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Color color;
	Image image;
	Graphics2D graphics2D;
	int currentX, currentY, oldX, oldY;

	public DrawPad()
	{
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				currentX = e.getX();
				currentY = e.getY();
				if (graphics2D != null) {graphics2D.setColor(color);graphics2D.drawLine(oldX, oldY, currentX, currentY);}
				repaint();
				oldX = currentX;
				oldY = currentY;
			}
		});
	}

	public void paintComponent(Graphics g)
	{
		if (image == null)
		{
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D) image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		g.setColor(color);
		g.drawImage(image, 0, 0, null);
	}

	public void clear()
	{
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
}

class ColorScreen extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<Field> colors = CreateColors();
	DrawPad pad;
	ButtonGroup group=new ButtonGroup();
	private static ArrayList<Field> CreateColors()
	{
		String[] nonColorFields =
		{ "FACTOR", "serialVersionUID" };
		Field[] declaredFields = Color.class.getDeclaredFields();
		ArrayList<Field> staticFields = new ArrayList<Field>();
		for (Field field : declaredFields)
		{
			if (Modifier.isStatic(field.getModifiers())
					&& !ListExtender.Contains(Arrays.asList(nonColorFields), field.getName())
					&& CharExtender.isLowerCase(field.getName()))
			{
				staticFields.add(field);
			}
		}
		return staticFields;
	}
	
	public ColorScreen(DrawPad pad){
		super("Color Palette");
		this.pad=pad;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLocationRelativeTo(null);
		JPanel panel=new JPanel(new GridLayout(colors.size(),1));
		for(int i=0;i<colors.size();i++)
		{
			JRadioButton radioButton=new JRadioButton(colors.get(i).getName());
			radioButton.setActionCommand(Integer.toString(i));
			group.add(radioButton);
			panel.add(radioButton);
		}
		add(panel,BorderLayout.CENTER);
		JButton button=new JButton("Set color");
		button.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					pad.color=(Color) colors.get(Integer.parseInt(group.getSelection().getActionCommand())).get(null);
				}
				catch (IllegalArgumentException | IllegalAccessException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(button,BorderLayout.SOUTH);
		setVisible(true);
	}
}