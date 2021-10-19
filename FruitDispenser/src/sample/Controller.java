package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 ======================================================================
 CLASS NAME  : Controller.java
 DESCRIPTION : Acts as the controller of the main GUI
 AUTHOR      : Jhury Kevin Lastre, Cyrus Noel Carano-o, Arthur Elly Lim
 COPYRIGHT   : 2021
 REVISION HISTORY
 Date:               By:           Description:
 ======================================================================
 */
public class Controller implements Initializable {
    //quantity of products
    @FXML
    private Label quantityAppleLabel;
    @FXML
    private Label quantityOrangeLabel;
    @FXML
    private Label quantityMangoLabel;
    @FXML
    private Label quantityPunchLabel;

    //Spinners and total cost
    @FXML
    private Spinner<Integer> appleSpinner;
    @FXML
    private Spinner<Integer> orangeSpinner;
    @FXML
    private Spinner<Integer> mangoSpinner;
    @FXML
    private Spinner<Integer> punchSpinner;
    @FXML
    private Label totalCost;

    //cash input
    @FXML
    private Label cashErrorLabel;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField cashTextField;

    //CHANGE COMPONENT

    @FXML
    private Label changeLabel;
    @FXML
    private Button claimChangeButton;
    @FXML
    private Label changeSuccessLabel;
    @FXML
    private Button cashRegisterButton;

    //PRICES
    @FXML
    private Label applePrice;
    @FXML
    private Label orangePrice;
    @FXML
    private Label mangoPrice;
    @FXML
    private Label punchPrice;
    //FOR EXIT
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane scenePane;

    private int appleCurrentValue;
    private int orangeCurrentValue;
    private int mangoCurrentValue;
    private int punchCurrentValue;
    private int toPay;
    private int trial = 0;

    protected DispenserType dispenserType = new DispenserType();
    protected CashRegister cashRegister = new CashRegister();

    /**
     ======================================================================
     METHOD        : Exit
     DESCRIPTION   : Exits the program
     PRE-CONDITION : Exit button is pressed
     POST-CONDITION  : The program will terminate
     ======================================================================
     */
    public void exit(ActionEvent actionEvent){
        Stage stage = (Stage)scenePane.getScene().getWindow();
        System.out.println("Logout Successful");
        stage.close();
    }
    /**
     ======================================================================
     METHOD        : openCashRegister
     DESCRIPTION   : Loads the cash register GUI
     PRE-CONDITION : Cash register button is pressed
     POST-CONDITION  : Loads the GUI of the cash register
     ======================================================================
     */
    public void openCashRegister (ActionEvent actionEvent) throws IOException {
        int cash = cashRegister.getCashOnHand();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cashRegisterScene.fxml"));
        Parent root = loader.load();
        CashRegisterController cashRegisterController = loader.getController();
        cashRegisterController.setCurrentCash(cash);
        cashRegisterController.setAppleQuantity(dispenserType.getNumberOfApple());
        cashRegisterController.setOrangeQuantity(dispenserType.getNumberOfOrange());
        cashRegisterController.setMangoQuantity(dispenserType.getNumberOfMango());
        cashRegisterController.setPunchQuantity(dispenserType.getNumberOfPunch());
        cashRegisterController.setApplePrice(dispenserType.getPriceApple());
        cashRegisterController.setOrangePrice(dispenserType.getPriceOrange());
        cashRegisterController.setMangoPrice(dispenserType.getPriceMango());
        cashRegisterController.setPunchPrice(dispenserType.getPricePunch());
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("cashRegister.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage primaryStage = new Stage();
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setTitle("Cash Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     ======================================================================
     METHOD        : confirm
     DESCRIPTION   : confirms purchase of the user
     PRE-CONDITION : Confirm button is pressed
     POST-CONDITION  : Reduces the quantity of the item, increases the cash on hand and clears the value
     in the spinner if input is acceptable
     ======================================================================
     */
    public void confirm(ActionEvent event){
        if(trial < 2){
            try{
                int fund = Integer.parseInt(cashTextField.getText());
                System.out.println(fund);
                System.out.println(toPay);
                if(fund < toPay){
                    cashErrorLabel.setText("Insufficient Funds OR Non-integer input");
                    trial++;
                }
                else {
                    if(fund > toPay){
                        changeLabel.setText(Integer.toString(cashRegister.calculateChange(fund,toPay)));
                    }
                    cashRegister.acceptAmount(fund);
                    System.out.println(cashRegister.getCashOnHand());
                    cashErrorLabel.setText("");
                    changeSuccessLabel.setText("");
                    dispenserType.makeSale(appleCurrentValue,mangoCurrentValue,orangeCurrentValue,punchCurrentValue);
                    changeQuantity();
                    initialValues();
                }
            }catch (Exception e){
                cashErrorLabel.setText("Insufficient Funds OR Non-integer input");
                trial++;
                System.out.println("Fund is not a number");
            }

        }else{
            cashErrorLabel.setText("Number of trials exceeded. Money returned.");
            trial = 0;
            initialValues();
        }
    }
    /**
     ======================================================================
     METHOD        : claimChange
     DESCRIPTION   : confirms purchase of the user
     PRE-CONDITION : Confirm button is pressed
     POST-CONDITION  : Reduces the quantity of the item, increases the cash on hand and clears the value
     in the spinner if input is acceptable
     ======================================================================
     */
    public void claimChange(ActionEvent event){
        try{
            int currentCash = cashRegister.getCashOnHand();
            currentCash -= Integer.parseInt(changeLabel.getText());
            cashRegister.setCashOnHand(currentCash);
            System.out.println(cashRegister.getCashOnHand());
            changeLabel.setText("0");
        }catch (Exception e){
            System.out.println("No change to be claimed");
        }

    }

    /**
     ======================================================================
     METHOD        : changeQuantity
     DESCRIPTION   : Changes the quantity display
     PRE-CONDITION : The method is called
     POST-CONDITION  : Displays the new label
     ======================================================================
     */
    public void changeQuantity() {
        quantityAppleLabel.setText(Integer.toString(dispenserType.getNumberOfApple()));
        quantityMangoLabel.setText(Integer.toString(dispenserType.getNumberOfMango()));
        quantityOrangeLabel.setText(Integer.toString(dispenserType.getNumberOfOrange()));
        quantityPunchLabel.setText(Integer.toString(dispenserType.getNumberOfPunch()));
    }
    /**
     ======================================================================
     METHOD        : changePrice
     DESCRIPTION   : Changes the price display
     PRE-CONDITION : The method is called
     POST-CONDITION  : Displays the new price
     ======================================================================
     */
    public void changePrice(){
        applePrice.setText(Integer.toString(dispenserType.getPriceApple()));
        orangePrice.setText(Integer.toString(dispenserType.getPriceOrange()));
        mangoPrice.setText(Integer.toString(dispenserType.getPriceMango()));
        punchPrice.setText(Integer.toString(dispenserType.getPricePunch()));
    }
    /**
     ======================================================================
     METHOD        : initialValues
     DESCRIPTION   : Sets up the spinner
     PRE-CONDITION : The method is called
     POST-CONDITION  : The spinner is initialized
     ======================================================================
     */
    public void initialValues(){
        changePrice();
        changeQuantity();
        SpinnerValueFactory<Integer> valueFactory_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,dispenserType.getNumberOfApple());
        SpinnerValueFactory<Integer> valueFactory_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,dispenserType.getNumberOfOrange());
        SpinnerValueFactory<Integer> valueFactory_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,dispenserType.getNumberOfMango());
        SpinnerValueFactory<Integer> valueFactory_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,dispenserType.getNumberOfPunch());
        valueFactory_1.setValue(0);
        valueFactory_2.setValue(0);
        valueFactory_3.setValue(0);
        valueFactory_4.setValue(0);
        appleSpinner.setValueFactory(valueFactory_1);
        orangeSpinner.setValueFactory(valueFactory_2);
        mangoSpinner.setValueFactory(valueFactory_3);
        punchSpinner.setValueFactory(valueFactory_4);
        cashTextField.setText("");
    }
    /**
     ======================================================================
     METHOD        : initialize
     DESCRIPTION   : Observer that updates the default elements
     PRE-CONDITION : The spinner gets incremented or decremented
     POST-CONDITION  : The total cost gets updated
     ======================================================================
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        appleSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                appleCurrentValue = appleSpinner.getValue();
                toPay = dispenserType.getCostApple(appleCurrentValue) + dispenserType.getCostOrange(orangeCurrentValue)
                        + dispenserType.getCostMango(mangoCurrentValue) + dispenserType.getCostPunch(punchCurrentValue);
                totalCost.setText(Integer.toString(toPay));
            }
        });
        orangeSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                orangeCurrentValue = orangeSpinner.getValue();
                toPay = dispenserType.getCostApple(appleCurrentValue) + dispenserType.getCostOrange(orangeCurrentValue)
                        + dispenserType.getCostMango(mangoCurrentValue) + dispenserType.getCostPunch(punchCurrentValue);
                totalCost.setText(Integer.toString(toPay));
            }
        });
        mangoSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                mangoCurrentValue = mangoSpinner.getValue();
                toPay = dispenserType.getCostApple(appleCurrentValue) + dispenserType.getCostOrange(orangeCurrentValue)
                        + dispenserType.getCostMango(mangoCurrentValue) + dispenserType.getCostPunch(punchCurrentValue);
                totalCost.setText(Integer.toString(toPay));
            }
        });
        punchSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                punchCurrentValue = punchSpinner.getValue();
                toPay = dispenserType.getCostApple(appleCurrentValue) + dispenserType.getCostOrange(orangeCurrentValue)
                        + dispenserType.getCostMango(mangoCurrentValue) + dispenserType.getCostPunch(punchCurrentValue);
                totalCost.setText(Integer.toString(toPay));
            }
        });

    }
}
