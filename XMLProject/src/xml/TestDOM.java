package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestDOM
{
	public static void main(String[] args) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse("src/xml/zooinventory.xml");
		Element inventory = document.getDocumentElement();
		NodeList animals = inventory.getElementsByTagName("animal");
		System.out.println("Animals = ");
		for (int i = 0; i < animals.getLength(); i++)
		{
			Element item = (Element) animals.item(i);
			String name = item.getElementsByTagName("name").item(0).getTextContent();
			String species = item.getElementsByTagName("species").item(0).getTextContent();
			String animalType = item.getAttribute("animalType");
			System.out.println(" " + name + " (" + animalType + ", " + species + ")");
		}
		Element cocoa = (Element) animals.item(1);
		Element recipe = (Element) cocoa.getElementsByTagName("foodRecipe").item(0);
		String recipeName = recipe.getElementsByTagName("name").item(0).getTextContent();
		System.out.println("Recipe = " + recipeName);
		NodeList ingredients = recipe.getElementsByTagName("ingredient");
		for (int i = 0; i < ingredients.getLength(); i++)
		{
			System.out.println(" " + ingredients.item(i).getTextContent());
			
		}
	}
}