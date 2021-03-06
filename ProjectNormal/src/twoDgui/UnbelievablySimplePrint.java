package twoDgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class UnbelievablySimplePrint implements Printable
{
	private static Font sFont = new Font("Serif", Font.PLAIN, 64);

	public int print(Graphics g, PageFormat Pf, int pageIndex) throws PrinterException
	{
		if (pageIndex > 0) return NO_SUCH_PAGE;
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(sFont);
		g2.setPaint(Color.black);
		g2.drawString("Save a tree!", 96, 144);
		return PAGE_EXISTS;
	}

	public static void main(String[] args)
	{
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new UnbelievablySimplePrint());
		if (job.printDialog())
		{
			try
			{
				job.print();
			}
			catch (PrinterException e)
			{
			}
		}
		System.exit(0);
	}
}