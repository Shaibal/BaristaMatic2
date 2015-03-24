abstract public class Ingredient {
	private final int DEFAULT_UNITS = 10;
	String name;
	int units;
	double unitCost;

	/**
	 * Constructor takes two parameters, assigns default total unit
	 * 
	 * @param name
	 * @param unitCost
	 */
	public Ingredient() {
		units = DEFAULT_UNITS;
	}

	public void restock() {
		this.units = DEFAULT_UNITS;
	}

	/**
	 * Method to get ingredient name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}

	/**
	 * Checks availability of an ingredient
	 * 
	 * @param units
	 * @return true/false
	 */
	public boolean enoughIngredient(int units) {
		if (this.units - units >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * reduces the amount of ingredient used
	 * 
	 * @param units
	 */
	public void useIngredient(int units) {
		this.units -= units;
	}

	/**
	 * @return the unit_cost
	 */
	public double getUnitCost() {
		return unitCost;
	}
	
	@Override
	public String toString() {
		return name + ", " + getUnits();
	}

}
