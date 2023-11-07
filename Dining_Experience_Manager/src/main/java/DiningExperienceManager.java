import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * The DiningExperienceManager class 
 *
 * @author Peter Rodriguez
 * @version 1.0
 * @since 2023-11-06
 */
@SuppressWarnings("PMD.UseUtilityClass")
public class DiningExperienceManager {
	/**
	 * The discount that applies.
	 */
    private static final double DISCOUNT_50 = 50.0;
	/**
	 * The discount that applies.
	 */
    private static final double DISCOUNT_100 = 100.0;
	/**
	 * The discount that applies.
	 */
    private static final double DISCOUNT_10 = 10.0;
	/**
	 * The discount that applies.
	 */
    private static final double DISCOUNT_5 = 5.0;
	/**
	 * Logger.
	 */
	private static final Logger logger = Logger.getLogger(DiningExperienceManager.class.getName());
    public static void main(String[] args) { //NOPMD
    	try (Scanner scanner = new Scanner(System.in)) {
	        double baseCost = 5.0;
	        double totalCost = baseCost;
	        String[] menu = {
	            "Burger", "10.0",
	            "Pizza", "12.0",
	            "Pasta", "8.0",
	            "Salad", "6.0"
	        };
	        int[] quantities = new int[menu.length / 2];
	        logger.info("Menu:");
	        for (int i = 0; i < menu.length; i += 2) {
	        	if (logger.isLoggable(Level.INFO))
	        		logger.info(menu[i] + " - $" + menu[i + 1]);
	        }
	        int quantityValidationIndex = 0;
	        while (quantityValidationIndex < menu.length / 2) {
	        	if(logger.isLoggable(Level.INFO))
	        		logger.info("Enter quantity for " + menu[quantityValidationIndex * 2] + ": ");
	            quantities[quantityValidationIndex] = scanner.nextInt();
	            if (quantities[quantityValidationIndex] < 1 || quantities[quantityValidationIndex] > 100) {
	                logger.info("Invalid quantity. Please enter a positive integer between 1 and 100.");
	            } else {
	                quantityValidationIndex++;
	            }
	        }
	        int totalQuantity = 0;
	        for (int i = 0; i < menu.length / 2; i++) {
	            totalQuantity += quantities[i];
	            totalCost += quantities[i] * Double.parseDouble(menu[i * 2 + 1]);
	        }
	        if (totalQuantity > DISCOUNT_5) {
	            totalCost *= 0.9; 
	        }
	
	        if (totalQuantity > DISCOUNT_10) {
	            totalCost *= 0.8;
	        }
	        if (totalCost > DISCOUNT_100) {
	            totalCost -= 25.0;
	        } else if (totalCost > DISCOUNT_50) {
	            totalCost -= 10.0; 
	        }
	        logger.info("Selected meals and quantities:");
	        for (int i = 0; i < menu.length / 2; i++) {
	            if (quantities[i] > 0 && logger.isLoggable(Level.INFO))
	            		logger.info(menu[i * 2] + " x" + quantities[i]);
	            
	        }
	        if (logger.isLoggable(Level.INFO)) {
	        	logger.info("Total cost: $" + totalCost);
	        }
	        logger.info("Confirm order (1 - Yes, 0 - Cancel): ");
	        int confirmation = scanner.nextInt();
	        if (confirmation == 1 && logger.isLoggable(Level.INFO))
	        		logger.info("Order confirmed. Total cost: $" + (int) totalCost);
	        else {
	        	logger.info("Order canceled.");
	        	totalCost = -1;
	        	logger.info("Error: " + totalCost);
	        } 
    	}
    }
}