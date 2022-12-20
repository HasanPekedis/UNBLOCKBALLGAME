//Hasan Pekedis 150120068 - Hatice YAVUZSAN 150120009
//This class creates start menu and it's buttons and background.

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class startMenu {
    static MediaPlayer mediaPlayer; // mediaPlayer object for music.

    public static void createStartMenu(){ //Creates start menu.
        Stage startStage = new Stage();
        Pane startPane = new Pane();
        VBox vbox = new VBox();    // We used Vbox to locate "start credit and exit" button correctly.

        Button startButton = new Button("START");
        vbox.setPrefSize(150,200);
        vbox.setLayoutX(175);
        vbox.setLayoutY(223);   // We got help from SceneBuilder to find correct layout values.


        startButton.setMinSize(150,67);
        startButton.setStyle("-fx-font-size:30;-fx-font-weight:bold;-fx-text-fill:#472331;"); //CSS styling for
        startButton.setOnMousePressed(new EventHandler<MouseEvent>() {                        //all button Texts.

            @Override
            public void handle(MouseEvent event) {
                gameMenu.createGame();
                startStage.close();
            }
        });

        Button creditButton = new Button("CREDITS"); //We added additionally credits window.
        creditButton.setMinSize(150,67);
        creditButton.setStyle("-fx-font-size:25;-fx-font-weight:bold;-fx-text-fill: #472331");
        creditButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                viewCredit();
            }
        });

        Button exitButton = new Button("EXIT");

        exitButton.setMinSize(150,67);
        exitButton.setStyle("-fx-font-size:30;-fx-font-weight:bold;-fx-text-fill: #472331");
        exitButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                startStage.close();
                mediaPlayer.pause();
            }
        });

        Button muteButton = new Button("MUTE"); // We added additionally music to start menu also mute button for music.
        muteButton.setStyle("-fx-font-size:20;-fx-font-weight:bold;-fx-text-fill: #472331");
        muteButton.setLayoutX(33);
        muteButton.setLayoutY(417);
        muteButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (mediaPlayer.isMute()) {
                    muteButton.setText("MUTE");
                    mediaPlayer.setMute(false);
                }
                else {
                    muteButton.setText("UNMUTE");
                    mediaPlayer.setMute(true);
                }

            }

        });

        Image image= new Image( "image\\startbackground.jpg");
        ImageView startBackground = new ImageView(image);
        startBackground.setFitHeight(500);
        startBackground.setFitWidth(500);
        startPane.getChildren().add(startBackground);
        vbox.getChildren().addAll(startButton,creditButton,exitButton); //Buttons added Vbox.
        startPane.getChildren().addAll(vbox,muteButton); // Vbox and muteButton added pane.
        startStage.setTitle("UNBLOCK BALL GAME");
        Image logo = new Image("image\\logo.jpg"); // We added logo.
        startStage.getIcons().add(logo);
        startStage.setResizable(false);
        Scene startScene = new Scene(startPane,500,500);
        startStage.setScene(startScene);
        music();
        startStage.show();
    }

    public static void viewCredit(){  //This method creates stage and text for Credit window.
        Stage creditStage = new Stage();
        Pane creditPane = new Pane();

        Image image = new Image("image\\creditbackground.jpg");
        ImageView creditBackground = new ImageView(image);
        creditBackground.setFitHeight(300);
        creditBackground.setFitWidth(300);
        creditPane.getChildren().add(creditBackground);
        Text text = new Text("Made by:");
        Text text1= new Text("Hasan PEKEDİS");
        Text text2=new Text("Hatice YAVUZSAN");
        text.setStyle("-fx-font-size:20;-fx-font-weight:bold;");
        text1.setStyle("-fx-font-size:20;-fx-font-weight:bold");
        text2.setStyle("-fx-font-size:20;-fx-font-weight:bold");
        Color paint = new Color(0.2784, 0.1373, 0.3022, 1.0); //we added special color for buttons.
        text.setFill(paint);
        text1.setFill(paint);
        text2.setFill(paint);
        text.setTranslateX(107);
        text.setTranslateY(110);
        text1.setTranslateX(85);
        text1.setTranslateY(159);
        text2.setTranslateX(66);
        text2.setTranslateY(210);
        creditPane.getChildren().add(text);
        creditPane.getChildren().add(text1);
        creditPane.getChildren().add(text2);
        creditStage.setTitle("CREDITS");
        Image logo = new Image("image\\logo.jpg");
        creditStage.getIcons().add(logo);

        Scene creditScene = new Scene(creditPane,300,300);
        creditStage.setScene(creditScene);
        creditStage.setResizable(false);
        creditStage.show();


    }


    public static void music(){ // This method for Music player.
        String path = "image\\music.mp3";
        Media h = new Media(Paths.get(path).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }

}


