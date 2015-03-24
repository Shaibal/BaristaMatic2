/**
 * Shaibal Saha
 * Barista-Matic Problem Solution for Trustwave interview round 3
 * 3/21/2015
 */


public class StartMachine {

	public static void main(String[] args) {

		BaristaMatic baristaMatic = BaristaMatic.getInstance();

		baristaMatic.initializeMenu();
		
		baristaMatic.handleCustomer();
	}



}
