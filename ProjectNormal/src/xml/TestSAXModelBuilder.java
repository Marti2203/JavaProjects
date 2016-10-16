/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author marti
 */
import org.xml.sax.*;
import javax.xml.parsers.*;

public class TestSAXModelBuilder {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory
                .newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader parser = saxParser.getXMLReader();
        SAXModelBuilder mb = new SAXModelBuilder();
        parser.setContentHandler(mb);
        parser.parse(new InputSource("src\\xml\\zooinventory.xml"));
        Inventory inventory = (Inventory) mb.getModel();
        System.out.println("Animals = " + inventory.animal);
        Animal cocoa = (Animal) (inventory.animal.get(1));
        FoodRecipe recipe = cocoa.foodRecipe;
        System.out.println("Recipe = " + recipe);
    }
}
