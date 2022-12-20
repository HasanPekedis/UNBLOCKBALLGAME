//Hasan Pekedis 150120068 - Hatice YAVUZSAN 150120009
//This class is Test class that we wrote to run createStartMenu method from startMenu class.

import javafx.application.Application;
import javafx.stage.Stage;



public class Test extends Application{
    public static void main(String[] args) {  //implemented from Application.
        launch(args);
    }

    public void start(Stage primaryStage) {
        startMenu.createStartMenu();// this line create start menu.

    }
}
