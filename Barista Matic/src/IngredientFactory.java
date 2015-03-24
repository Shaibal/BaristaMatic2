public class IngredientFactory {
	public Ingredient createIngredient(String name) {
		Ingredient ingredient = null;
		if (name.equals("Coffee")) {
			ingredient = new CoffeeIngredient();
		} else if (name.equals("Decaf Coffee")) {
			ingredient = new DecafCoffeeIngredient();
		} else if (name.equals("Sugar")) {
			ingredient = new SugarIngredient();			
		} else if (name.equals("Cream")) {
			ingredient = new CreamIngredient();						
		} else if (name.equals("Steamed Milk")) {
			ingredient = new SteamedMilkIngredient();						
		} else if (name.equals("Foamed Milk")) {
			ingredient = new FoamedMilkIngredient();						
		} else if (name.equals("Espresso")) {
			ingredient = new EspressoIngredient();						
		} else if (name.equals("Cocoa")) {
			ingredient = new CocoaIngredient();					
		} else if (name.equals("Whipped Cream")) {
			ingredient = new WhippedCreamIngredient();						
		}
		return ingredient;
	}
}
