package instructions;

import java.util.*;

public class Instruction
	{
		String instructionCode;
		public Instruction(String code,Object... arguments)
			{
				if(code.length()!=4)
					throw new IllegalArgumentException("Code must be 4 digits long.");
			}
		HashMap<String, Integer> requiredArguments=new HashMap<>();
		
	}
