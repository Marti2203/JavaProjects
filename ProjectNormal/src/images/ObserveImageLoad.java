package images;

import static java.lang.System.out;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class ObserveImageLoad
{
	public static void main(String[] args)
	{
		ImageObserver myObserver = new ImageObserver()
		{
			public boolean imageUpdate(Image image, int flags, int x, int y, int width, int height)
			{
				if ((flags & HEIGHT) != 0) out.println("Image height = " + height);
				if ((flags & WIDTH) != 0) out.println("Image width = " + width);
				if ((flags & FRAMEBITS) != 0) out.println("Another frame finished.");
				if ((flags & SOMEBITS) != 0) out.println("Image section :" + new Rectangle(x, y, width, height));
				if ((flags & ALLBITS) != 0) out.println("Image finished!");
				if ((flags & ABORT) != 0) out.println("Image load aborted...");
				return true;
			}
		};
		String image="Images/rhino.gif";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage(image);
		toolkit.prepareImage(img, -1, -1, myObserver);
	}
}
