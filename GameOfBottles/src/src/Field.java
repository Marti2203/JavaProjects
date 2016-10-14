package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Field implements Iterable<Bottle>
{
	private static final Scanner SCANNER = new Scanner(System.in);
	ArrayList<Bottle> bottles = new ArrayList<>();

	public void AddBottle(int x, int y)
	{
		Bottle newBottle = new Bottle(x, y);
		bottles.forEach(bottle ->
		{
			bottle.ConnectWithBottle(newBottle);
			newBottle.ConnectWithBottle(bottle);
		});
		bottles.add(newBottle);
	}

	public static void main(String[] args)
	{
		Field field = new Field();
		System.out.println("Input number of bottles");
		int bottleCount = SCANNER.nextInt();
		if (bottleCount > 9)
		{
			System.out.println("Bottle count must be below 10");
			return;
		}
		for (int i = 0; i < bottleCount; i++)
		{
			System.out.println("Input x: ");
			int x = SCANNER.nextInt();
			System.out.println("Input y: ");
			int y = SCANNER.nextInt();
			field.AddBottle(x, y);
		}

	}

	@Override
	public Iterator<Bottle> iterator()
	{
		return bottles.iterator();
	}

	public void CalculateBruteForce(Field field)
	{
		ArrayList<Integer> results = new ArrayList<>();
		forEach(bottle -> results.add(StartFromBottle(bottle)));
		Collections.sort(results);
		results.forEach(element -> System.out.println(element));
	}

	private int StartFromBottle(Bottle bottle)
	{
		ArrayList<Bottle> checkedBottles=new ArrayList<>();
		checkedBottles.add(bottle);
		return 0;
	}
}
