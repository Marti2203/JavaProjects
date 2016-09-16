package defaultPackage;

import javax.swing.*;

public class HelloSecond
{
	public static void main(String[] args){
		StartFrame(new String[] {"Hello. It's me","JOHN CENA","DOOT DOOT BOY","Click me!"});
	}
  public static void StartFrame( String[] input ) {
    JFrame frame = new JFrame( input[0] );
    JButtonSpecial button=new JButtonSpecial(input[3],new JTextBox(input[1],input[2]));
    frame.add(button);
    frame.add(button.textBox);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 500 );
    frame.setVisible( true );
  }
}
