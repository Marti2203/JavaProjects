/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import javax.xml.bind.annotation.XmlAttribute;

import jaxb.FoodRecipe;

/**
 *
 * @author marti
 */
public class Animal
{
	public static enum AnimalClass
	{
		mammal, reptile, bird, fish, amphibian, invertebrate
	}

	@XmlAttribute
	public AnimalClass animalClass;
	public String name, species, habitat, food, temperament;
	public Double weight;
	public FoodRecipe foodRecipe;

	public Animal()
	{

	}

	public Animal(AnimalClass mammal, String name, String species, String habitat, String food, String temperament,
			double weight, FoodRecipe recipe)
	{
		this.animalClass = mammal;
		this.name = name;
		this.species = species;
		this.habitat = habitat;
		this.food = food;
		this.temperament = temperament;
		this.weight = weight;
		this.foodRecipe = recipe;
	}

	@Override
	public String toString()
	{
		return name + "(" + animalClass + "," + species + ")";
	}
}
