package gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PageOpener {
	public static void main(String[] args) {
		System.out.println(Desktop.isDesktopSupported());
		RedirectButton frame=new RedirectButton();
		frame.setTitle("Page Opener");
	}
}
