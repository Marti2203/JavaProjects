package dialer;

public class SpinnerInfo
{
	int minValue, nvalue, maxValue, radius;

	public int getValue()
	{
		return nvalue + minValue;
	}

	public void setMinimum(int minValue)
	{
		this.minValue = minValue;
	}

	public int getMinimum()
	{
		return minValue;
	}

	public void setMaximum(int maxValue)
	{
		this.maxValue = maxValue;
	}

	public int getMaximum()
	{
		return maxValue;
	}
}
