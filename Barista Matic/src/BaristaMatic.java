/**
 * Provides the menu and inventory.
 * Handles customer order
 * @author Shaibal Saha
 * 3/21/2015
 */
public class BaristaMatic {

	// Singleton Constructor
	private static BaristaMatic baristaMatic = null;

	private BaristaMatic() {

	}

	public static BaristaMatic getInstance() {
		if (baristaMatic == null) {
			baristaMatic = new BaristaMatic();
		}
		return baristaMatic;
	}

	// End of Constructor
	GetInput inputObject = new GetInput();
	
	private static Inventory coffeeInventory = Inventory.getInstance();

	private static Ingredient[] ingredients = coffeeInventory.getIngredients();

	private static Item[] itemArray = coffeeInventory.getMenuItems();

	public void initializeMenu() {
		coffeeInventory.initializeMenu();
		printInventoryAndMenu();
	}

	private static void printInventoryAndMenu() {
		printIngredientList();
		printMenu();
	}

	// Prints ingredient's list and units available
	private static void printIngredientList() {
		System.out.println("Inventory:\n");
		for (Ingredient ingredient : ingredients) {
			System.out.println(ingredient);
		}
	}

	// Prints all the Items in menu, with price
	private static void printMenu() {
		System.out.println("\nMenu:\n");
		int count = 1;
		for (Item item : itemArray) {
			System.out.println(count + ", " + item);
			count++;
		}
	}

	public void handleCustomer() {

		String userInput = inputObject.getUserInput();
		boolean takeInput = true;

		do {
			switch (userInput) {
			case "r":
				restockMachine();
				userInput = inputObject.getUserInput();
				break;
			case "R":
				restockMachine();
				userInput = inputObject.getUserInput();
				break;
			case "q":
				takeInput = false;
				break;
			case "Q":
				takeInput = false;
				break;
			case "1":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			case "2":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			case "3":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			case "4":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			case "5":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			case "6":
				handleOrder(itemArray[Integer.parseInt(userInput) - 1]);
				userInput = inputObject.getUserInput();
				break;
			default:
				System.out.println("\nInvalid selection: \"" + userInput + "\"\n");
				printInventoryAndMenu();
				userInput = inputObject.getUserInput();
				break;
			}
		} while (takeInput);

	}


	/**
	 * Restocks the ingredients of coffee machine to maximum default value
	 */
	private static void restockMachine() {
		for (Ingredient ingredient : ingredients) {
			ingredient.restock();
		}
		System.out.println("\nRestocked Inventory\n");
		printInventoryAndMenu();
	}

	/**
	 * When an item is seleted, this method goes to check if ingredients are
	 * available to make that item and responds accordingly. Finally prints the
	 * Ingredients and Item menu after action taken.
	 * 
	 * @param item
	 */
	private static void handleOrder(Item item) {
		if (item.isAvailable()) {
			item.completeOrder();
			System.out.println("\nDispensing: " + item.getItemName() + "\n");
		} else {
			System.out.println("\nOut of Stock: " + item.getItemName() + "\n");
		}
		printInventoryAndMenu();
	}
}
