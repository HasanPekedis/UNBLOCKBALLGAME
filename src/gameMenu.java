//Hasan Pekedis 150120068 - Hatice YAVUZSAN 150120009
//This Class create game menu that actually game.

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Objects;

public class gameMenu  {


    public static void createGame(){ //Creates game.
        Stage primaryStage = new Stage();
        Pane generalPane = new Pane();
        GridPane grid_Pane= new GridPane(); // GridPane for 16 square.
        Image logo = new Image("image\\logo.jpg");
        primaryStage.getIcons().add(logo);
        generalPane.setPrefSize(1050, 800);
        gameMenu menu= new gameMenu();
        menu.addButtons(generalPane,grid_Pane,primaryStage);//Creates Level 1 and Back button for game menu.
        Scene scene = new Scene(generalPane, 1050, 800);
        primaryStage.setTitle("UNBLOCK BALL GAME");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public gameMenu() {} // no-Arg constructor.

    public gameMenu(GridPane grid_Pane,int x,int y,Pane menuPane,String str) { //Creates Level buttons.

        Button levelButton = new Button(""+ str); //Creates level button for each level.
        levelButton.setStyle("-fx-font-size:20;-fx-font-weight:bold;-fx-text-fill:#472331;");
        levelButton.setPrefSize(60,60);
        levelButton.setId(str);    //Level value.
        levelButton.setLayoutX(x);  //Each level has
        levelButton.setLayoutY(y);  //Different location.


        for(Node node:menuPane.getChildren()) {
            menuPane.getChildren().add(levelButton); break; //For loop for add all buttons game menu again.
        }




        levelButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                menuPane.getChildren().remove(grid_Pane);
                menuPane.getChildren().add(grid_Pane);

                Level lvl= new Level();                   //Removes old grid pane.
                //Adds new grid pane.

                try {lvl.addPane(grid_Pane, str);}
                catch (FileNotFoundException e) {e.printStackTrace();}
                lvl.startMove(menuPane,grid_Pane);

            }

        });
    }

    public gameMenu(String itemName,Pane menuPane,int x,int y, Stage primaryStage) { //Adds back button to game menu.

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-font-size:25;-fx-font-weight:bold;-fx-text-fill:#472331;");

        backButton.setTranslateX(x);
        backButton.setTranslateY(y);
        backButton.setPrefSize(100,50);

        menuPane.getChildren().add(backButton);
        Button muteButton = new Button("MUTE"); // We added additionally music to start menu also mute button for music.
        muteButton.setStyle("-fx-font-size:25;-fx-font-weight:bold;-fx-text-fill: #472331");
        muteButton.setLayoutX(880);
        muteButton.setLayoutY(640);
        menuPane.getChildren().add(muteButton);
        muteButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (startMenu.mediaPlayer.isMute()) {
                    muteButton.setText("MUTE");
                    startMenu.mediaPlayer.setMute(false);
                }
                else {
                    muteButton.setText("UNMUTE");
                    startMenu.mediaPlayer.setMute(true);
                }

            }

        });

        backButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                startMenu.createStartMenu();            //Creates start menu again.
                primaryStage.close();                   //Closes game stage.
                startMenu.mediaPlayer.pause();          //Pause music to don't start again.
            }

        });
    }

    public void addButtons(Pane menuPane,GridPane grid_Pane,Stage primaryStage) {


        Image image= new Image( "image\\gamebackground.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800);
        imageView.setFitWidth(1050);
        menuPane.getChildren().add(imageView);



        gameMenu level1Button = new gameMenu(grid_Pane, 840, 160,menuPane,"1"); //creates button for level 1.
        gameMenu backButton = new gameMenu("Back",menuPane,880,715,primaryStage); //create back button.


    }
}

