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
public class Animal {

    public static enum AnimalClass {
        mammal, reptile, bird, fish, amphibian,
        invertebrate
    }
    public AnimalClass animalClass;
    public String name, species, habitat, food, temperament;
    public Double weight;
    public FoodRecipe foodRecipe;

    @Override
    public String toString() {
        return name + "(" + animalClass + "," + species + ")";
    }
}
