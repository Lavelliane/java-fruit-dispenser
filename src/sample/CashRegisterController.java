package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 ======================================================================
 CLASS NAME  : cashRegisterController.java
 DESCRIPTION : Acts as the controller of the cash register GUI
 AUTHOR      : Jhury Kevin Lastre, Cyrus Noel Carano-o, Arthur Elly Lim
 COPYRIGHT   : 2021
 REVISION HISTORY
 Date:               By:           Description:
 ======================================================================
 */
public class CashRegisterController {

    @FXML
    private Label currentCash;
    @FXML
    private TextField newAppleQuantityLabel;
    @FXML
    private TextField newOrangeQuantityLabel;
    @FXML
    private TextField newMangoQuantityLabel;
    @FXML
    private TextField newPunchQuantityLabel;
    @FXML
    private TextField newApplePriceLabel;
    @FXML
    private TextField newOrangePriceLabel;
    @FXML
    private TextField newMangoPriceLabel;
    @FXML
    private TextField newPunchPriceLabel;
    @FXML
    private Label successSave;

    private int appleQuantity;
    private int orangeQuantity;
    private int mangoQuantity;
    private int punchQuantity;
    private int applePrice;
    private int orangePrice;
    private int mangoPrice;
    private int punchPrice;

    /**
     ======================================================================
     METHOD        : saveChanges
     DESCRIPTION   : Updates the quantity and/or price
     PRE-CONDITION : Save change button is pressed
     POST-CONDITION  : The inputted value will change the stored value
     ======================================================================
     */
    public void saveChanges(ActionEvent actionEvent){
        try{
            appleQuantity = newAppleQuantityLabel.getText().equals("") ? appleQuantity : appleQuantity + Integer.parseInt(newAppleQuantityLabel.getText());
            orangeQuantity = newOrangeQuantityLabel.getText().equals("") ? orangeQuantity : orangeQuantity + Integer.parseInt(newOrangeQuantityLabel.getText());
            mangoQuantity = newMangoQuantityLabel.getText().equals("") ? mangoQuantity : mangoQuantity + Integer.parseInt(newMangoQuantityLabel.getText());
            punchQuantity = newPunchQuantityLabel.getText().equals("") ? punchQuantity : punchQuantity + Integer.parseInt(newPunchQuantityLabel.getText());
            applePrice = newApplePriceLabel.getText().equals("") ? applePrice : Integer.parseInt(newApplePriceLabel.getText());
            orangePrice = newOrangePriceLabel.getText().equals("") ? orangePrice : Integer.parseInt(newOrangePriceLabel.getText());
            mangoPrice = newMangoPriceLabel.getText().equals("") ? mangoPrice : Integer.parseInt(newMangoPriceLabel.getText());
            punchPrice = newPunchPriceLabel.getText().equals("") ? punchPrice : Integer.parseInt(newPunchPriceLabel.getText());
            successSave.setText("Changes Successfully saved");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    /**
     ======================================================================
     METHOD        : setCurrentCash
     DESCRIPTION   : Sets the current cash
     PRE-CONDITION : The method is called
     POST-CONDITION  : The current cash will be changed
     ======================================================================
     */
    public void setCurrentCash(int newCurrentCash) {
        currentCash.setText(Integer.toString(newCurrentCash));
    }
    /**
     ======================================================================
     METHOD        : switchToMain
     DESCRIPTION   : Goes back to the main GUI
     PRE-CONDITION : The back button is pressed
     POST-CONDITION  : The main GUI will be loaded
     ======================================================================
     */
    public void switchToMainScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.dispenserType.setNumberOfApple(appleQuantity);
        controller.dispenserType.setNumberOfOrange(orangeQuantity);
        controller.dispenserType.setNumberOfMango(mangoQuantity);
        controller.dispenserType.setNumberOfPunch(punchQuantity);
        controller.dispenserType.setPriceApple(applePrice);
        controller.dispenserType.setPriceOrange(orangePrice);
        controller.dispenserType.setPriceMango(mangoPrice);
        controller.dispenserType.setPricePunch(punchPrice);
        controller.initialValues();
        controller.cashRegister.setCashOnHand(Integer.parseInt(currentCash.getText()));
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage primaryStage;
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     ======================================================================
     METHOD        : getQuantity
     DESCRIPTION   : Getters that returns the quantity values
     PRE-CONDITION : The method is called
     POST-CONDITION  : Returns the quantity
     ======================================================================
     */
    public int getAppleQuantity() {
        return appleQuantity;
    }

    public int getOrangeQuantity() {
        return orangeQuantity;
    }

    public int getMangoQuantity() {
        return mangoQuantity;
    }

    public int getPunchQuantity() {
        return punchQuantity;
    }

    /**
     ======================================================================
     METHOD        : setQuantity
     DESCRIPTION   : Setters that sets the quantities
     PRE-CONDITION : The method is called with the quantity parameter
     POST-CONDITION  : The quantities will be set
     ======================================================================
     */
    public void setAppleQuantity(int appleQuantity) {
        this.appleQuantity = appleQuantity;
    }

    public void setOrangeQuantity(int orangeQuantity) {
        this.orangeQuantity = orangeQuantity;
    }

    public void setMangoQuantity(int mangoQuantity) {
        this.mangoQuantity = mangoQuantity;
    }

    public void setPunchQuantity(int punchQuantity) {
        this.punchQuantity = punchQuantity;
    }

    /**
     ======================================================================
     METHOD        : getPrice
     DESCRIPTION   : Getters that returns the price values
     PRE-CONDITION : The method is called
     POST-CONDITION  : Returns the price
     ======================================================================
     */
    public int getApplePrice() {
        return applePrice;
    }

    public int getOrangePrice() {
        return orangePrice;
    }

    public int getMangoPrice() {
        return mangoPrice;
    }

    public int getPunchPrice() {
        return punchPrice;
    }

    /**
     ======================================================================
     METHOD        : setPrice
     DESCRIPTION   : Setters that sets the prices
     PRE-CONDITION : The method is called with the price parameter
     POST-CONDITION  : The prices will be set
     ======================================================================
     */
    public void setApplePrice(int applePrice) {
        this.applePrice = applePrice;
    }

    public void setOrangePrice(int orangePrice) {
        this.orangePrice = orangePrice;
    }

    public void setMangoPrice(int mangoPrice) {
        this.mangoPrice = mangoPrice;
    }

    public void setPunchPrice(int punchPrice) {
        this.punchPrice = punchPrice;
    }
}
