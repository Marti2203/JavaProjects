package dialer;

public class DialEvent extends java.util.EventObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int value;

	DialEvent(Dial source, int value)
	{
		super(source);
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
}