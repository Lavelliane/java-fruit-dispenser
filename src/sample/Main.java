package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 ======================================================================
 CLASS NAME  : Main.java
 DESCRIPTION : Launches the main GUI
 AUTHOR      : Jhury Kevin Lastre, Cyrus Noel Carano-o, Arthur Elly Lim
 COPYRIGHT   : 2021
 REVISION HISTORY
 Date:               By:           Description:
 ======================================================================
 */
public class Main extends Application {

    /**
     ======================================================================
     METHOD        : start
     DESCRIPTION   : Sets up the primary GUI
     PRE-CONDITION : No pre-condition
     POST-CONDITION  : The main GUI is set up
     ======================================================================
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Fruit Juice Dispenser");
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     ======================================================================
     METHOD        : main
     DESCRIPTION   : Launches the GUI
     PRE-CONDITION : No pre-condition
     POST-CONDITION  : The GUI is launched
     ======================================================================
     */
    public static void main(String[] args) {
        launch(args);
    }
}
