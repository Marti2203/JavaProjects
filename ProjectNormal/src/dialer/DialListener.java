package dialer;

public interface DialListener extends java.util.EventListener
{
	void dialAdjusted(DialEvent e);
}