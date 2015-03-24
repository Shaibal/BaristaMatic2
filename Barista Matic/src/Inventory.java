/**
 * Provides the inventory of BaristaMatic by creating all the ingredient objects
 * and items.
 * @author Shaibal Saha 
 * 3/21/2015
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {

	static Inventory inventory = null;

	private Inventory() {
	}

	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	// ingredientFactory is responsible for creating all the ingredients
	private IngredientFactory ingredientFactory = new IngredientFactory();

	private Ingredient iCoffee = ingredientFactory.createIngredient("Coffee");
	private Ingredient iDecafCoffee = ingredientFactory
			.createIngredient("Decaf Coffee");
	private Ingredient iSugar = ingredientFactory.createIngredient("Sugar");
	private Ingredient iCream = ingredientFactory.createIngredient("Cream");
	private Ingredient iSteamedMilk = ingredientFactory
			.createIngredient("Steamed Milk");
	private Ingredient iFoamedMilk = ingredientFactory
			.createIngredient("Foamed Milk");
	private Ingredient iEspresso = ingredientFactory
			.createIngredient("Espresso");
	private Ingredient iCocoa = ingredientFactory.createIngredient("Cocoa");
	private Ingredient iWhippedCream = ingredientFactory
			.createIngredient("Whipped Cream");

	private Ingredient[] ingredients = { iCoffee, iDecafCoffee, iSteamedMilk,
			iSugar, iCream, iFoamedMilk, iEspresso, iCocoa, iWhippedCream };

	public Ingredient[] getIngredients() {
		ingredients = sortIngredientListByName();
		return ingredients;
	}

	/*
	 * variables for all different menu items, new items should be added here if
	 * required
	 */
	private Item coffee = new Item("Coffee");
	private Item decafCoffee = new Item("Decaf Coffee");
	private Item caffeLatte = new Item("Caffe Latte");
	private Item caffeAmericano = new Item("Caffe Americano");
	private Item caffeMocha = new Item("Caffe Mocha");
	private Item cappuchino = new Item("Cappuchino");

	// Array of all items, new added items must be added here as an
	// array element
	private Item[] itemArray = { coffee, decafCoffee, caffeLatte,
			caffeAmericano, caffeMocha, cappuchino };

	public void initializeMenu() {

		// Initializing the menu items with their ingredients, cost is
		// calculated while adding an ingredient

		// setting item coffee with its ingredients
		coffee.addIngredient(iCoffee, 3);
		coffee.addIngredient(iSugar, 1);
		coffee.addIngredient(iCream, 1);

		decafCoffee.addIngredient(iDecafCoffee, 3);
		decafCoffee.addIngredient(iSugar, 1);
		decafCoffee.addIngredient(iCream, 1);

		caffeLatte.addIngredient(iEspresso, 2);
		caffeLatte.addIngredient(iSteamedMilk, 1);

		caffeAmericano.addIngredient(iEspresso, 3);

		caffeMocha.addIngredient(iEspresso, 1);
		caffeMocha.addIngredient(iCocoa, 1);
		caffeMocha.addIngredient(iSteamedMilk, 1);
		caffeMocha.addIngredient(iWhippedCream, 1);

		cappuchino.addIngredient(iEspresso, 2);
		cappuchino.addIngredient(iSteamedMilk, 1);
		cappuchino.addIngredient(iFoamedMilk, 1);

	}

	public Item[] getMenuItems() {
		itemArray = sortItemListByName();
		return itemArray;
	}

	/**
	 * Returns the sorted Ingredient array with respect to name
	 * @return the sorted array of Ingredients
	 */

	private Ingredient[] sortIngredientListByName() {

		ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>(
				Arrays.asList(ingredients));

		Collections.sort(ingredientArrayList, new Comparator<Ingredient>() {
			public int compare(Ingredient ingredient1, Ingredient ingredient2) {

				return ingredient1.getName().compareTo(ingredient2.getName());
			}
		});

		return ingredientArrayList.toArray(new Ingredient[ingredientArrayList
				.size()]);
	}

	/**
	 * Returns the sorted Item array with respect to Item name
	 * 
	 * @return the sorted array of Items
	 */
	private Item[] sortItemListByName() {
		ArrayList<Item> itemArrayList = new ArrayList<Item>(
				Arrays.asList(itemArray));

		Collections.sort(itemArrayList, new Comparator<Item>() {
			public int compare(Item item1, Item item2) {

				return item1.getItemName().compareTo(item2.getItemName());
			}
		});

		return itemArrayList.toArray(new Item[itemArrayList.size()]);
	}
}
