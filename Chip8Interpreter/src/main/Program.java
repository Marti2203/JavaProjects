package main;

import java.awt.Color;

import screen.Pixel;
import screen.View;

public class Program
	{

		public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
			{
				Pixel one = new Pixel(40, 40, 100, Color.BLUE)
						, two = new Pixel(10, 20, 100, Color.RED)
						,three=new Pixel(50, 50, 300, Color.GRAY);

				View screen = new View("Interpreter screen", 10, 10);

				screen.add(one);
				screen.add(two);
				screen.add(three);
			}

	}
