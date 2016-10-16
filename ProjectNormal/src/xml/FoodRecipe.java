/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 */
public class FoodRecipe {

    public String name;
    public List<String> ingredient = new ArrayList<String>();

    public String toString() {
        return name + ": " + ingredient.toString();
    }
}
