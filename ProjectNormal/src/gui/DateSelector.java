package gui;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateSelector
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("DateSelector v1.0");
		Calendar now = Calendar.getInstance();
		Calendar earliest = (Calendar) now.clone();
		earliest.add(Calendar.MONTH, -6);
		Calendar latest = (Calendar) now.clone();
		latest.add(Calendar.MONTH, 6);
		SpinnerModel model = new SpinnerDateModel(now.getTime(), earliest.getTime(), latest.getTime(),
				Calendar.MONTH);
		final JSpinner spinner = new JSpinner(model);
		// Disable the built-in date editor
		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		model.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				System.out.println(((SpinnerDateModel) e.getSource()).getDate());
			}
		});
		frame.getContentPane().add("North", new JLabel("Choose a week"));
		frame.getContentPane().add("Center", spinner);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}