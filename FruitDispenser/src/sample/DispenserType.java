package sample;
/**
 ======================================================================
 CLASS NAME  : DispenserType.java
 DESCRIPTION : Setters and Getters of the items
 AUTHOR      : Jhury Kevin Lastre, Cyrus Noel Carano-o, Arthur Elly Lim
 COPYRIGHT   : 2021
 REVISION HISTORY
 Date:               By:           Description:
 ======================================================================
 */
public class DispenserType {

    private int numberOfApple;
    private int numberOfOrange;
    private int numberOfMango;
    private int numberOfPunch;
    private int costApple;
    private int costOrange;
    private int costMango;
    private int costPunch;
    private int priceApple;
    private int priceOrange;
    private int priceMango;
    private int pricePunch;

    /**
     ======================================================================
     METHOD        : DispenserType
     DESCRIPTION   : With and Without parameters sets up the price and amount
     PRE-CONDITION : The method is called with or without parameters
     POST-CONDITION  : The values will be set
     ======================================================================
     */
    public DispenserType(){
        this(50,50,50,50,12,15,12,20);
    }

    public DispenserType(int numberOfApple, int numberOfOrange, int numberOfMango, int numberOfPunch, int priceApple, int priceOrange, int priceMango, int pricePunch) {
        this.numberOfApple = numberOfApple;
        this.numberOfOrange = numberOfOrange;
        this.numberOfMango = numberOfMango;
        this.numberOfPunch = numberOfPunch;
        this.priceApple = priceApple;
        this.priceOrange = priceOrange;
        this.priceMango = priceMango;
        this.pricePunch = pricePunch;
    }

    /**
     ======================================================================
     METHOD        : getCost
     DESCRIPTION   : Getters that multiplies price and quantity then returns the value
     PRE-CONDITION : The method is called with the quantity
     POST-CONDITION  : The values will be set
     ======================================================================
     */
    public int getCostApple(int quantity){
        this.costApple = priceApple * quantity;
        return costApple;
    }
    public int getCostOrange(int quantity) {
        this.costOrange = priceOrange * quantity;
        return costOrange;
    }
    public int getCostMango(int quantity) {
        this.costMango = priceMango * quantity;
        return costMango;
    }
    public int getCostPunch(int quantity) {
        this.costPunch = pricePunch * quantity;
        return costPunch;
    }
    public void makeSale(int q_apple, int q_mango, int q_orange, int q_punch){
        this.numberOfApple -= q_apple;
        this.numberOfMango -= q_mango;
        this.numberOfOrange -= q_orange;
        this.numberOfPunch -= q_punch;
    }

    /**
     ======================================================================
     METHOD        : getNumber
     DESCRIPTION   : Getters that returns the quantity values
     PRE-CONDITION : The method is called
     POST-CONDITION  : Returns the quantity
     ======================================================================
     */

    public int getNumberOfApple() {
        return numberOfApple;
    }

    public int getNumberOfOrange() {
        return numberOfOrange;
    }

    public int getNumberOfMango() {
        return numberOfMango;
    }

    public int getNumberOfPunch() {
        return numberOfPunch;
    }

    /**
     ======================================================================
     METHOD        : setNumber
     DESCRIPTION   : Setters that sets the quantities
     PRE-CONDITION : The method is called with the quantity parameter
     POST-CONDITION  : The quantities will be set
     ======================================================================
     */
    public void setNumberOfApple(int numberOfApple) {
        this.numberOfApple = numberOfApple;
    }

    public void setNumberOfOrange(int numberOfOrange) {
        this.numberOfOrange = numberOfOrange;
    }

    public void setNumberOfMango(int numberOfMango) {this.numberOfMango = numberOfMango;}

    public void setNumberOfPunch(int numberOfPunch) {
        this.numberOfPunch = numberOfPunch;
    }

    /**
     ======================================================================
     METHOD        : getPrice
     DESCRIPTION   : Getters that returns the price values
     PRE-CONDITION : The method is called
     POST-CONDITION  : Returns the price
     ======================================================================
     */
    public int getPriceApple() {
        return priceApple;
    }

    public int getPriceOrange() {
        return priceOrange;
    }

    public int getPriceMango() {
        return priceMango;
    }

    public int getPricePunch() {
        return pricePunch;
    }

    /**
     ======================================================================
     METHOD        : setPrice
     DESCRIPTION   : Setters that sets the prices
     PRE-CONDITION : The method is called with the price parameter
     POST-CONDITION  : The prices will be set
     ======================================================================
     */
    public void setPriceApple(int priceApple) {
        this.priceApple = priceApple;
    }

    public void setPriceOrange(int priceOrange) {
        this.priceOrange = priceOrange;
    }

    public void setPriceMango(int priceMango) {
        this.priceMango = priceMango;
    }

    public void setPricePunch(int pricePunch) {
        this.pricePunch = pricePunch;
    }
}
