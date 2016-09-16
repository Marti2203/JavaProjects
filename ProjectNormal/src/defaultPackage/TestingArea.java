package defaultPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestingArea {

	public static void main(String[] args) {
		Success frame=new Success();
		frame.setTitle("Conway's Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class Success extends JFrame implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton button;
	Line2D line2d;
    public Success(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(1000,1000);
        line2d=new Line2D.Float(100,100,250,260);
        this.button =new JButton("press");
        panel.add(button);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(line2d);
    }
    public void paintComponents(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(line2d);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			changeLine();
		}
	}
	
	private void changeLine()
	{
		line2d.setLine(line2d.getX1()*2, line2d.getY1()/2, line2d.getX2()+10, line2d.getY2()+20);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.changeLine();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}