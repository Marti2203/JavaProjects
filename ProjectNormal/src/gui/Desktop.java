package gui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Desktop
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Desktop");
		JDesktopPane desktop = new JDesktopPane();
		for (int i = 0; i < 5; i++)
		{
			JInternalFrame internal = new JInternalFrame("Frame " + i, true, true, true, true);
			internal.setSize(180, 180);
			internal.setLocation(i * 20, i * 20);
			internal.setVisible(true);
			internal.addInternalFrameListener(new InternalFrameAdapter()
			{
				@Override
				public void internalFrameClosed(InternalFrameEvent e)
				{
					System.out.println(((JInternalFrame)e.getSource()).getTitle());
					super.internalFrameClosed(e);
				}
			});
			desktop.add(internal);
		}
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(desktop);
		frame.setVisible(true);
	}
}