package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class Bottle
{
	public int x;
	public int y;
	HashMap<Bottle, Integer> neighbourDistances = new HashMap<>();

	public Bottle(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void ConnectWithBottle(Bottle bottle)
	{
		neighbourDistances.put(bottle, CalculateDifference(bottle));
	}

	public int CalculateDifference(Bottle bottle)
	{
		int difference = 0;
		difference += Math.abs(x - bottle.x);
		difference += Math.abs(y - bottle.y);
		return difference;
	}

}
