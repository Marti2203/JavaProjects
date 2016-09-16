package defaultPackage;

import javax.swing.JComponent;

class TextBoxFirst extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String writeText;
	
	public void paintComponent(java.awt.Graphics g) {
		g.drawString(writeText, 130, 95);
	}
	public TextBoxFirst(String writeText){
		this.writeText=writeText;
	}
}