/*
 * Samantha McCormick CSC240 Java Programming
 */

/*
 * For this assignment, you will write a program that accepts the unit weight of a bag of coffee, in
 * pounds, and the number of bags sold. The program will then display the current date, the number
 * of bags sold, the weight per bag, the price per pound, the tax rate used, the subtotal, the tax
 * charged and the total price of the sale.
 */

package assignment1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class CoffeeSalesTracker {

  public static void main(String[] args) {
    // initialize objects you'll need later
    Scanner input = new Scanner(System.in);
    Coffee coffee = new Coffee();

    welcome();

    System.out.print("Are you ready to begin? Enter Y/N: ");
    String start = input.next();

    while (start.toLowerCase().equals("y")) {
      // todo create and pass in coffee object
      getBagData(input, coffee);
      outputData(coffee);
      start = startAgain(input);
    }
    goodbye();
  }

  private static void welcome() {
    System.out.println("Welcome to the Coffee Sales Tracker");
    System.out
        .println("This program will calculate the amount due\nfor your coffee sales transactions");
  }

  private static void goodbye() {
    System.out.print("\nThank you and have a great day. Goodbye.");
  }

  private static void getBagData(Scanner input, Coffee coffee) {
    System.out.print("\nNumber of bags: ");
    coffee.setNumberOfBags(input.nextInt());

    System.out.print("Weight per bag: ");
    coffee.setBagWeight(input.nextInt());
  }

  // A method that handles output for the results
  private static void outputData(Coffee coffee) {
    // Print a table of the data
    // Formatting is 2 columns with 10 spaces between, then a line break
    // The minus means align left
    String format = "%-20s %-20s %n";

    System.out.print("\n");

    DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG);
    System.out.format(format, "Today's date: ", dateFormatter.format(new Date()));

    System.out.format(format, "Number of bags: ", coffee.getNumberOfBags());
    System.out.format(format, "Weight per bag: ", coffee.getBagWeight() + " pounds");
    System.out.format(format, "Price per pound: ",
        "$" + roundToTwoDecimalPlaces(coffee.getPrice()));
    System.out.format(format, "Sales tax: ",
        roundToTwoDecimalPlaces(coffee.getTaxRate() * 100) + "%");
    System.out.format(format, "Sales sub-total: ", "$" + roundToTwoDecimalPlaces(coffee.getSale()));
    System.out.format(format, "Total tax: ",
        "$" + roundToTwoDecimalPlaces(coffee.getSalesTax()) + "\n");

    System.out.format(format, "Total Sale: ",
        "$" + roundToTwoDecimalPlaces(coffee.getTotalPrice()) + "\n");

  }

  private static String startAgain(Scanner input) {
    System.out.print("Do you have another sale to ring up? Enter Y/N: ");
    return input.next();
  }

  private static BigDecimal roundToTwoDecimalPlaces(double number) {
    final int DECIMALPOINTS = 2;
    final RoundingMode ROUNDINGMODE = RoundingMode.HALF_UP;

    return new BigDecimal(number).setScale(DECIMALPOINTS, ROUNDINGMODE);
  }

}
