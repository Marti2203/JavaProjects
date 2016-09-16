package StringManipulation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTest
	{
		private static final Scanner SCANNER = new Scanner(System.in);

		public static void main(String[] args)
			{
				StringTokenizer stringTokenizer=new StringTokenizer(SCANNER.nextLine());
				String[] elements=new String[stringTokenizer.countTokens()];
				int elementCount=0;
				while(stringTokenizer.hasMoreTokens())
					{
						elements[elementCount++]=stringTokenizer.nextToken();
					}
				System.out.println(elementCount);
				for (String string : elements)
					{
						System.out.println(string);
					}
			}
	}