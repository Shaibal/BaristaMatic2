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

	/*
	 * Static variable for all different ingredients, changing price of an
	 * ingredient or adding new ingredient should be coded here
	 */
	IngredientFactory ingredientFactory = new IngredientFactory();
	
	Ingredient iCoffee = ingredientFactory.createIngredient("Coffee");
	Ingredient iDecafCoffee = ingredientFactory.createIngredient("Decaf Coffee");
	Ingredient iSugar = ingredientFactory.createIngredient("Sugar");
	Ingredient iCream = ingredientFactory.createIngredient("Cream");
	Ingredient iSteamedMilk = ingredientFactory.createIngredient("Steamed Milk");
	Ingredient iFoamedMilk = ingredientFactory.createIngredient("Foamed Milk");
	Ingredient iEspresso = ingredientFactory.createIngredient("Espresso");
	Ingredient iCocoa = ingredientFactory.createIngredient("Cocoa");
	Ingredient iWhippedCream = ingredientFactory.createIngredient("Whipped Cream");

	// Array of all ingredients, new added ingredient must be added here as an
	// array element

	private Ingredient[] ingredients = { iCoffee, iDecafCoffee,
			iSteamedMilk, iSugar, iCream, iFoamedMilk, iEspresso, iCocoa,
			iWhippedCream };

	public Ingredient[] getIngredients() {
		ingredients = sortIngredientListByName();
		return ingredients;
	}

	/*
	 * Static variable for all different menu items new item should be added
	 * here
	 */
	private static Item coffee = new Item("Coffee");
	private static Item decafCoffee = new Item("Decaf Coffee");
	private static Item caffeLatte = new Item("Caffe Latte");
	private static Item caffeAmericano = new Item("Caffe Americano");
	private static Item caffeMocha = new Item("Caffe Mocha");
	private static Item cappuchino = new Item("Cappuchino");

	// Array of all items, new added item must be added here as an
	// array element
	 private Item[] itemArray = { coffee, decafCoffee, caffeLatte,
			caffeAmericano, caffeMocha, cappuchino };

	public void initializeMenu() {

		// Initializing the menu items

		// setting item coffee with its ingredients
		coffee.addIngredient(iCoffee, 3);
		coffee.addIngredient(iSugar, 1);
		coffee.addIngredient(iCream, 1);

		// setting item decaf coffee with its ingredients
		decafCoffee.addIngredient(iDecafCoffee, 3);
		decafCoffee.addIngredient(iSugar, 1);
		decafCoffee.addIngredient(iCream, 1);

		// setting item caffe latte with its ingredients
		caffeLatte.addIngredient(iEspresso, 2);
		caffeLatte.addIngredient(iSteamedMilk, 1);

		// setting item caffe americano with its ingredients
		caffeAmericano.addIngredient(iEspresso, 3);

		// setting item caffe mocha with its ingredients
		caffeMocha.addIngredient(iEspresso, 1);
		caffeMocha.addIngredient(iCocoa, 1);
		caffeMocha.addIngredient(iSteamedMilk, 1);
		caffeMocha.addIngredient(iWhippedCream, 1);

		// setting item cappuchino with its ingredients
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
	 * 
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
