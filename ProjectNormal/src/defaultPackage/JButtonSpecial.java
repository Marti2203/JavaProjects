package defaultPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class JButtonSpecial extends JButton implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextBox textBox;
	public JButtonSpecial(String message,JTextBox textBox){
		this.setText(message);
		this.setSize(100,50);
		this.textBox=textBox;
		addActionListener(this);
	}
	public void doClick(){
		changeText("FFS MAN");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this)
		{
			changeText("Fucker");
		}
	}
	private void changeText(String Message){
		this.textBox.theMessage=Message;
		this.textBox.repaint();
	}
}