package screen;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public final class Colors
	{
		public static ArrayList<Field> colors;

		static
			{
				colors=CreateColors();
			}

		private Colors()
			{

			}

		private static ArrayList<Field> CreateColors()
			{
				String[] nonColorFields = { "FACTOR", "serialVersionUID" };
				Field[] declaredFields = Color.class.getDeclaredFields();

				ArrayList<Field> staticFields = new ArrayList<Field>();
				for (Field field : declaredFields)
					{
						if (Modifier.isStatic(field.getModifiers()) && !ListExtender.StringSearcher
								.Contains(Arrays.asList(nonColorFields), field.getName()))
							{
								staticFields.add(field);
							}
					}
				return staticFields;
			}
	}
