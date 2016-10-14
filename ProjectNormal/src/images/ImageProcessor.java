package images;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageProcessor extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage source, destination;
	private JComboBox<String> options;

	public ImageProcessor(BufferedImage image)
	{
		source = destination = image;
		setBackground(Color.white);
		setLayout(new BorderLayout());
		// create a panel to hold the combo box
		JPanel controls = new JPanel();
		// create the combo box with the names of the area operators
		options = new JComboBox<>(new String[]
		{ "[source]", "brighten", "darken", "rotate", "scale" });
		// perform some processing when the selection changes
		options.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				// retrieve the selection option from the combo box
				String option = (String) options.getSelectedItem();
				// process the image according to the selected option
				BufferedImageOp op = null;
				if (option.equals("[source]"))
					destination = source;
				else if (option.equals("brighten"))
					op = new RescaleOp(1.5f, 0, null);
				else if (option.equals("darken"))
					op = new RescaleOp(.5f, 0, null);
				else if (option.equals("rotate"))
					op = new AffineTransformOp(AffineTransform.getRotateInstance(Math.PI / 3 ), null);
				else if (option.equals("scale"))
					op = new AffineTransformOp(AffineTransform.getScaleInstance(.5, .5), null);
				if (op != null) destination = op.filter(source, null);
				repaint();
			}
		});
		controls.add(options);
		add(controls, BorderLayout.SOUTH);
	}

	public void paintComponent(Graphics g)
	{
		int imageWidth = destination.getWidth();
		int imageHeight = destination.getHeight();
		int width = getSize().width;
		int height = getSize().height;
		g.drawImage(destination, (width - imageWidth) / 2, (height - imageHeight) / 2, null);
	}

	public static void main(String[] args) throws MalformedURLException
	{
		String filename = "https://i.imgur.com/agOMBj2.jpg";
		ImageIcon icon = new ImageIcon(new URL(filename));
		Image i = icon.getImage();
		// draw the Image into a BufferedImage
		int w = i.getWidth(null), h = i.getHeight(null);
		BufferedImage buffImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D imageGraphics = buffImage.createGraphics();
		imageGraphics.drawImage(i, 0, 0, null);
		JFrame frame = new JFrame("ImageProcessor");
		frame.add(new ImageProcessor(buffImage));
		frame.setSize(buffImage.getWidth(), buffImage.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}