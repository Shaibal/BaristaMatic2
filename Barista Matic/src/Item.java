import java.text.DecimalFormat;
import java.util.*;

public class Item {

	private String itemName;
	private Map<Ingredient, Integer> ingredientMap = new HashMap<Ingredient, Integer>();
	private double cost;
	private boolean available;

	public Item(String name) {
		itemName = name;
	}

	public void addIngredient(Ingredient ingredientName, int units) {
		ingredientMap.put(ingredientName, units);
		cost += ingredientName.getUnitCost() * units;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		itemName = name;
	}

	public double getCost() {
		return cost;
	}

	/**
	 * according to the recipe of the item, checks if all ingredients are
	 * available to make the item
	 * 
	 * @return true/false
	 */
	public boolean isAvailable() {
		available = true;
		for (Map.Entry<Ingredient, Integer> entry : ingredientMap.entrySet()) {
			Ingredient ingredient = entry.getKey();
			int units = entry.getValue();
			if (!ingredient.enoughIngredient(units)) {
				available = false;
			}
		}
		return available;
	}

	/**
	 * Uses ingredients of an Item one by one. 
	 */
	public void completeOrder() {
		for (Map.Entry<Ingredient, Integer> entry : ingredientMap.entrySet()) {
			Ingredient ingredient = entry.getKey();
			int units = entry.getValue();
			ingredient.useIngredient(units);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#.00");
		return itemName + ", $" + df.format(getCost()) + ", " + isAvailable();
	}

}
