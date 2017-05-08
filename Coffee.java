/*
 * Samantha McCormick CSC240 Java Programming
 */

package assignment1;

public class Coffee {
  private final static double PRICEPERPOUND = 5.99;
  private final static double TAXRATE = .0725;

  private int numberOfBags;
  private int bagWeight;
  
  public Coffee() {
    numberOfBags = 1;
    bagWeight = 1;
  }

  // A constructor that accepts arguments from the first class for number of bags and the weight of
  // each bag
  public Coffee(int numberOfBags, int bagWeight) {
    this.numberOfBags = numberOfBags;
    this.bagWeight = bagWeight;
  }
  
  public int getNumberOfBags() {
    return this.numberOfBags;
  }
  
  public void setNumberOfBags(int numberOfBags) {
    this.numberOfBags = numberOfBags;
  }
  
  public int getBagWeight() {
    return this.bagWeight;
  }
  
  public void setBagWeight(int bagWeight) {
    this.bagWeight = bagWeight;
  }

  // the price before tax
  public double getSale() {
    return this.numberOfBags * this.bagWeight * PRICEPERPOUND;
  }

  // sale price * tax rate
  public double getSalesTax() {
    return getSale() * TAXRATE;
  }

  // the price + sales tax
  public double getTotalPrice() {
    return getSale() + getSalesTax();
  }

  public static double getPrice() {
    return PRICEPERPOUND;
  }

  public static double getTaxRate() {
    return TAXRATE;
  }

}
