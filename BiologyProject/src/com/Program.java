package com;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import classes.Screen;
import classes.Sun;

public class Program
{
	public static final String TITLE="Bio Project";
	public static void main(String[] args) throws MalformedURLException
	{
		JFrame frame=new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.add(new Sky());
		
	}
	
	public static void Test(String[] args) throws MalformedURLException
	{

		Screen frame = new Screen();
		frame.setTitle(TITLE);

		JPanel panel = new JPanel(new GridLayout(0, 12));
		for (int i = 0; i < 12; i++)
		{
			panel.add(new JLabel(Integer.toString(i + 1)));
		}

		Sun sun = new Sun();
		sun.drawX = frame.getWidth() / 2;
		sun.drawY = frame.getHeight() / 2;

		frame.add(panel, BorderLayout.NORTH);
		frame.add(sun, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}

	class Sky extends JPanel
	{
		public Sky()
		{
			super(null);
		}
		@Override
		public void paint(Graphics g)
		{
			g.drawArc(0, getHeight(), getWidth(), getHeight(), 180, 180);
			super.paint(g);
		}
	}