package sample;

/**
 ======================================================================
 CLASS NAME  : CashRegister.java
 DESCRIPTION : Setters and Getters for the cash register
 AUTHOR      : Jhury Kevin Lastre, Cyrus Noel Carano-o, Arthur Elly Lim
 COPYRIGHT   : 2021
 REVISION HISTORY
 Date:               By:           Description:
 ======================================================================
 */
public class CashRegister {

    private int cashOnHand;
    /**
     ======================================================================
     METHOD        : CashRegister
     DESCRIPTION   : With and Without parameters sets the cash on hand
     PRE-CONDITION : The method is called with or without parameters
     POST-CONDITION  : The values will be set
     ======================================================================
     */
    public CashRegister(){
        this(500);
    }

    public CashRegister(int cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    /**
     ======================================================================
     METHOD        : getCashOnHand
     DESCRIPTION   : returns the cash on hand
     PRE-CONDITION : The method is called
     POST-CONDITION  : Returns the cash on hand
     ======================================================================
     */
    public int getCashOnHand() {
        return cashOnHand;
    }

    /**
     ======================================================================
     METHOD        : setCashOnHand
     DESCRIPTION   : sets the cash on hand value
     PRE-CONDITION : The method is called with the new cash on hand
     POST-CONDITION  : Sets the cash on hand with the parameter
     ======================================================================
     */
    public void setCashOnHand(int cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    /**
     ======================================================================
     METHOD        : calculateChange
     DESCRIPTION   : subtracts cash from the total cost
     PRE-CONDITION : The method is called with the total cost and total cash
     POST-CONDITION  : subtracts cash from the total cost and returns it
     ======================================================================
     */
    public int calculateChange(int cash, int totalCost){
        int change = cash - totalCost;
        return change;
    }
    /**
     ======================================================================
     METHOD        : acceptAmount
     DESCRIPTION   : increases cash on hand based on amount payed
     PRE-CONDITION : Method is called with the new amount
     POST-CONDITION  : cashOnHand gets increased
     ======================================================================
     */
    public void acceptAmount (int n){
        cashOnHand += n;
        return;
    }
}
