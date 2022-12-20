//Hasan Pekedis 150120068 - Hatice YAVUZSAN 150120009
//This class creates levels.

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Level {
    boolean isGameEnd;
    int level;

    Pane[][] panes= new Pane[4][4];
    String[][] imageID= new String[4][4];

    ArrayList<Pane> paneArray= new ArrayList<Pane>();
    ArrayList<Pane>	allPanes = new ArrayList<Pane>();
    ArrayList<Pane>	endPanes = new ArrayList<Pane>();




    public void addPane(GridPane pane,String str) throws FileNotFoundException {
        Scanner input = new Scanner(new File("CSE1242_spring2022_project_level"+str+".txt"));//reads levels from inputs.
        level=Integer.parseInt(str);


        while(input.hasNextLine()) {
            String[] currentLine = input.nextLine().split(",");//Creates string array for string inputs.
            String number = currentLine[0];
            String type = currentLine[1];
            String position= currentLine[2];


            switch(number) { //switch statment for detect each pane.


                case "1":
                    Pane pane1 = new Pane();
                    pane1.setPrefSize(200,200);
                    selectImages(type,position,pane,pane1,0,0,0);
                    pane.add(pane1,0,0); //Adds panes to grid pane with row and index.
                    panes[0][0]=pane1;
                    break;

                case "2":
                    Pane pane2 = new Pane();
                    pane2.setPrefSize(200,200);
                    selectImages(type,position,pane,pane2,1,0,1);
                    pane.add(pane2,1,0);
                    panes[1][0]=pane2;
                    break;

                case "3":
                    Pane pane3 = new Pane();
                    pane3.setPrefSize(200,200);
                    selectImages(type,position,pane,pane3,2,0,2);
                    pane.add(pane3,2,0);
                    panes[2][0]=pane3;
                    break;

                case "4":
                    Pane pane4 = new Pane();
                    pane4.setPrefSize(200,200);
                    selectImages(type,position,pane,pane4,3,0,3);
                    pane.add(pane4,3,0);
                    panes[3][0]=pane4;
                    break;

                case "5":
                    Pane pane5 = new Pane();
                    pane5.setPrefSize(200,200);
                    selectImages(type,position,pane,pane5,0,1,4);
                    pane.add(pane5,0,1);
                    panes[0][1]=pane5;
                    break;

                case "6":
                    Pane pane6 = new Pane();
                    pane6.setPrefSize(200,200);
                    selectImages(type,position,pane,pane6,1,1,5);
                    pane.add(pane6,1,1);
                    panes[1][1]=pane6;
                    break;

                case "7":
                    Pane pane7 = new Pane();
                    pane7.setPrefSize(200,200);
                    selectImages(type,position,pane,pane7,2,1,6);
                    pane.add(pane7,2,1);
                    panes[2][1]=pane7;
                    break;

                case "8":
                    Pane pane8 = new Pane();
                    pane8.setPrefSize(200,200);
                    selectImages(type,position,pane,pane8,3,1,7);
                    pane.add(pane8,3,1);
                    panes[3][1]=pane8;
                    break;

                case "9":
                    Pane pane9 = new Pane();
                    pane9.setPrefSize(200,200);
                    selectImages(type,position,pane,pane9,0,2,8);
                    pane.add(pane9,0,2);
                    panes[0][2]=pane9;
                    break;

                case "10":
                    Pane pane10 = new Pane();
                    pane10.setPrefSize(200,200);
                    selectImages(type,position,pane,pane10,1,2,9);
                    pane.add(pane10,1,2);
                    panes[1][2]=pane10;
                    break;

                case "11":
                    Pane pane11 = new Pane();
                    pane11.setPrefSize(200,200);
                    selectImages(type,position,pane,pane11,2,2,10);
                    pane.add(pane11,2,2);
                    panes[2][2]=pane11;
                    break;

                case "12":
                    Pane pane12 = new Pane();
                    pane12.setPrefSize(200,200);
                    selectImages(type,position,pane,pane12,3,2,11);
                    pane.add(pane12,3,2);
                    panes[3][2]=pane12;
                    break;

                case "13":
                    Pane pane13 = new Pane();
                    pane13.setPrefSize(200,200);
                    selectImages(type,position,pane,pane13,0,3,12);
                    pane.add(pane13,0,3);
                    panes[0][3]=pane13;
                    break;

                case "14":
                    Pane pane14 = new Pane();
                    pane14.setPrefSize(200,200);
                    selectImages(type,position,pane,pane14,1,3,13);
                    pane.add(pane14,1,3);
                    panes[1][3]=pane14;
                    break;

                case "15":
                    Pane pane15 = new Pane();
                    pane15.setPrefSize(200,200);
                    selectImages(type,position,pane,pane15,2,3,14);
                    pane.add(pane15, 2, 3);
                    panes[2][3]=pane15;
                    break;

                case "16":
                    Pane pane16 = new Pane();
                    pane16.setPrefSize(200, 200);
                    selectImages(type, position, pane , pane16,3,3,15);
                    pane.add(pane16, 3, 3);
                    panes[3][3]=pane16;
                    break;

            }
        }

    }


    public void selectImages(String type,String position,GridPane pane ,Pane panex,int ii,int jj,int a ) {
        //this method takes images from image folder.
        if(type.equals("Starter")) {

            if(position.equals("Vertical")) {
                Image image= new Image("image/sv.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="sv"; //add name of image to array imageID (Hint. using imageID for neihbor,target pane)
                panex.setId("bot-Starter");



            }
            else if(position.equals("Horizontal")){
                Image image= new Image("image/sh.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="sh";
                panex.setId("lft-Starter");

            }

        }
        else if(type.equals("End")) {

            if(position.equals("Vertical")) {
                Image image= new Image("image\\ev.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ev";
                panex.setId("ENDb-END");


            }
            else if(position.equals("Horizontal")){
                Image image= new Image("image\\eh.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="eh";
                panex.setId("ENDl-END");

            }
        }
        else if(type.equals("Empty")) {

            if(position.equals("Free")) {
                Image image= new Image("image\\ef.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ef";
                panex.setId("empty");



            }
            else  if(position.equals("none")){
                Image image= new Image("image\\en.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="en";
                panex.setId("empty");


            }
        }
        else if(type.equals("Pipe")) {

            if(position.equals("Vertical")) {

                Image image= new Image("image\\pv.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="pv";
                panex.setId("tb-PipeNormal");

            }
            else if(position.equals("Horizontal")){
                Image image= new Image("image\\ph.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="ph";
                panex.setId("lr-PipeNormal");


            }
            else if(position.equals("00")){
                Image image= new Image("image\\p00.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="p00";
                panex.setId("tl-PipeNormal");


            }
            else if(position.equals("01")){
                Image image= new Image("image\\p01.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="p01";
                panex.setId("tr-PipeNormal");


            }
            else if(position.equals("10")){
                Image image= new Image("image\\p10.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="p10";
                panex.setId("bl-PipeNormal");


            }
            else if(position.equals("11")){
                Image image= new Image("image\\p11.jpg");
                viewImage(image, panex);
                imageID[ii][jj]="p11";
                panex.setId("br-PipeNormal");
            }
        }
        else if(type.equals("PipeStatic")) {
            if(position.equals("Vertical")) {
                Image image= new Image("image\\psv.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="psv";
                panex.setId("tb-PipeStatic");
            }
            else if(position.equals("Horizontal")){
                Image image= new Image("image\\psh.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="psh";
                panex.setId("lr-PipeStatic");


            }
            else if(position.equals("01")){
                Image image= new Image("image\\ps01.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ps01";
                panex.setId("tr-PipeStatic");


            }
            else if(position.equals("10")){

                Image image= new Image("image\\ps10.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ps10";
                panex.setId("bl-PipeStatic");

            }
            else if(position.equals("11")){
                Image image= new Image("image\\ps11.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ps11";
                panex.setId("br-PipeStatic");

            }
            else if(position.equals("00")){
                Image image= new Image("imag\\ps00.jpg");
                viewImage(image,  panex);
                imageID[ii][jj]="ps00";
                panex.setId("tl-PipeStatic");


            }
        }

        allPanes.add(panex);
    }


    public void viewImage(Image image,Pane pane) { //Set standard fit height and width values.
        //Add images that selected in selectImages method put to the pane.
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        pane.getChildren().add(imageView);

        pane.setOnDragDetected(new EventHandler<MouseEvent>() { //Detects mouse.

            @Override
            public void handle(MouseEvent event) {

                Dragboard dragBoard= pane.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content=new ClipboardContent();
                content.putImage(image);
                dragBoard.setContent(content);
                event.consume();
            }

        });

    }

    public void startMove(Pane menuPane,GridPane grid_Pane) { //This method checks if pressed button is movable.

        grid_Pane.getChildren().forEach(event ->{

            event.setOnMousePressed(new EventHandler<MouseEvent>() {


                public void handle(MouseEvent e) {
                    int colNumber = 0;
                    int rowNumber = 0;
                    if( event.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                        rowNumber = GridPane.getRowIndex( event);
                        colNumber =  GridPane.getColumnIndex( event);


                        if(findSource(colNumber, rowNumber)) {

                            moved(menuPane,grid_Pane,colNumber , rowNumber);
                        }
                    }
                }
            });
        });
    }

    public void moved(Pane menuPane,GridPane grid_Pane,int colNumber , int rowNumber) { //This method manages drag and drop movements.

        paneArray= findTarget(imageID,colNumber,rowNumber);
        Pane pane = panes[colNumber][rowNumber];
        paneArray.forEach(event ->{

            int columnMoved=GridPane.getColumnIndex(event);
            int rowMoved= GridPane.getRowIndex(event);
            int columnMoved2= GridPane.getColumnIndex(pane);
            int rowMoved2= GridPane.getRowIndex(pane);

            event.setOnDragOver(new EventHandler<DragEvent>() { //Sets drag.

                @Override
                public void handle(DragEvent e) {
                    if(!isGameEnd) {
                        if(paneArray.contains(event)) {
                            if(findSource(colNumber, rowNumber)) {
                                e.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                    }
                    e.consume();

                }

            });

            event.setOnDragDropped(new EventHandler<DragEvent>() { //Drop panes source to target.

                @Override
                public void handle(DragEvent e) {

                    panes[columnMoved][rowMoved]=pane;
                    panes[columnMoved2][rowMoved2]=event;
                    String source= imageID[columnMoved2][rowMoved2];
                    String target= imageID[columnMoved][rowMoved];
                    imageID[columnMoved2][rowMoved2]=target;
                    imageID[columnMoved][rowMoved]=source;
                    allPanes.remove(columnMoved+rowMoved*4);
                    allPanes.add(columnMoved+rowMoved*4, pane);
                    allPanes.remove(columnMoved2+rowMoved2*4);
                    allPanes.add(columnMoved2+rowMoved2*4,event);
                    grid_Pane.getChildren().remove(pane);
                    grid_Pane.getChildren().remove(event);
                    grid_Pane.add(pane, columnMoved, rowMoved);
                    grid_Pane.add(event, columnMoved2, rowMoved2);
                    //Writes console each movement's numbers.
                    System.out.println("Move from: "+(rowMoved2+1)+","+(columnMoved2+1)+ " to: "+(rowMoved+1)+","+(columnMoved+1) );
                    gameEndCond(grid_Pane,menuPane);
                    e.setDropCompleted(true);
                    e.consume();

                }});
        });
    }

    public ArrayList<Pane> findTarget(String[][] imageID,int col,int row) { //Check is target pane is empty.

        paneArray.clear();

        for(int ii=0;ii<4;ii++) {

            for(int jj=0;jj<4;jj++) {

                String str= imageID[ii][jj];


                if(isNeighbor(ii, jj, col, row)) {

                    if(str.equals("ef")) {

                        paneArray.add(panes[ii][jj]);

                    }
                }

            }
        }

        return paneArray;


    }

    public boolean findSource(int column,int row) {//This method gives permission to transfer source to target.
        String name= imageID[column][row];

        boolean value=true;;
        if(name.equals("ef")||name.equals("eh")||name.equals("ev")||name.equals("ps00")||name.equals("ps01")||name.equals("ps10")||name.equals("ps11")||
                name.equals("psh")||name.equals("psv")||name.equals("sh")||name.equals("sv")){
            value=false;

        }

        return value;
    }

    public boolean isNeighbor(int ii,int jj,int col,int row) {//This method gives permission to transfer panes to only neighbor panes.

        boolean active=false;

        if((col-1==ii&&row==jj)||(col==ii&&row+1==jj)||(col+1==ii&&row==jj)||(col==ii&&row-1==jj)) {
            active=true;
        }

        return active;

    }

    public void gameEndCond(GridPane grid_Pane,Pane menuPane) { //This method performs control according to the id of the pane.

        String way = "";
        int emptycount = 0;
        int index = 0;
        for(int i = 0 ; i<allPanes.size();i++) {
            if(allPanes.get(i).getId().contains("Starter")) {
                if(allPanes.get(i).getId().startsWith("lft")) {
                    endPanes.add(allPanes.get(i));
                    way = "left";
                    index = i;
                }
                else if(allPanes.get(i).getId().startsWith("bot")){
                    endPanes.add(allPanes.get(i));
                    way = "bot";
                    index = i;
                }
            }
            if(allPanes.get(i).getId().equals("empty"))
                emptycount++;
        }
        for(int i =0 ; i<allPanes.size()-emptycount ; i++) {
            switch(way) {

                case "bot" :
                    if(index + 4 < 16) {
                        index = index+4;
                        if (allPanes.get(index).getId().contains("empty")) {
                            way = "empty";
                        }
                        else  if(allPanes.get(index).getId().substring(0, 2).contains("t")) {
                            if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
                                way = "right";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("l")) {
                                way = "left";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
                                way = "bot";
                                endPanes.add(allPanes.get(index));
                            }

                        }
                    }
                    break;

                case "right" :
                    if(index == 3 || index == 7 || index == 11)
                        break;
                    if(index + 1 < 16) {
                        index = index+1;
                        if (allPanes.get(index).getId().contains("empty")) {
                            way = "empty";
                        }
                        else if (allPanes.get(index).getId().contains("ENDl")) {
                            way = "END";
                            endPanes.add(allPanes.get(index));
                        }
                        else if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
                            if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
                                way = "right";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
                                way = "top";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
                                way = "bot";
                                endPanes.add(allPanes.get(index));
                            }

                        }

                    }


                    break;

                case "left" :
                    if(index == 12 || index == 4 || index == 8)
                        break;
                    if(index - 1 >= 0) {
                        index = index-1;
                        if (allPanes.get(index).getId().contains("empty")) {
                            way ="empty";
                        }
                        else if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
                            if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
                                way = "left";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
                                way = "top";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
                                way = "bot";
                                endPanes.add(allPanes.get(index));
                            }
                        }
                    }
                    break;

                case "top" :
                    if(index - 4 >= 0) {
                        index = index-4;
                        if (allPanes.get(index).getId().contains("empty")) {
                            way ="empty";
                        }
                        else if (allPanes.get(index).getId().contains("END")) {
                            way = "END";
                            endPanes.add(allPanes.get(index));
                        }
                        else if(allPanes.get(index).getId().substring(0, 2).contains("b")) {
                            if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
                                way = "left";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
                                way = "top";
                                endPanes.add(allPanes.get(index));
                            }
                            else if (allPanes.get(index).getId().substring(0, 2).contains("r")) {
                                way = "right";
                                endPanes.add(allPanes.get(index));
                            }
                        }

                    }
                    break;

                case "END" :
                    if (allPanes.size()-emptycount == endPanes.size()) {
                        isGameEnd = true;
                        for(int ii=0;ii<endPanes.size();ii++) {


                        }

                    }

                    break;

                case "empty":
                    break;

            }

        }
        endPanes.clear();
        if(isGameEnd) {
            createLevel(grid_Pane,menuPane);
        }
    }

    public void createLevel(GridPane grid_Pane,Pane menuPane)  { // Creates gameMenu objects to create level buttons and levels.

        if(level==1 ) {
            gameMenu level2= new gameMenu(grid_Pane,940, 160,menuPane,"2");
        }
        else if(level==2 ) {
            gameMenu level3= new gameMenu(grid_Pane,840, 260,menuPane,"3");
        }
        else if(level==3) {
            gameMenu level4= new gameMenu(grid_Pane,940, 260,menuPane,"4");
        }
        else if(level==4 ) {
            gameMenu level5= new gameMenu(grid_Pane,840, 360,menuPane,"5");
        }
        else if(level==5) {
            gameMenu level6= new gameMenu(grid_Pane,940, 360,menuPane,"6");
        }
        else if(level==6) { // if level counter hit 6 creates new congratulations window.
            Stage finishStage = new Stage();
            Pane finishPane = new Pane();
            Text finishText = new Text("Congratulations!");
            finishText.setStyle("-fx-font-size:30;-fx-font-weight:bold;-fx-text-fill:#472331;");
            Image image = new Image("image\\creditbackground.jpg");
            ImageView finishBackground = new ImageView(image);
            finishBackground.setFitHeight(300);
            finishBackground.setFitWidth(300);
            finishPane.getChildren().add(finishBackground);
            Color paint = new Color(0.2784, 0.1373, 0.3022, 1.0);
            finishText.setFill(paint);
            finishText.setTranslateX(40);
            finishText.setTranslateY(140);
            finishPane.getChildren().add(finishText);
            Scene finishScene = new Scene(finishPane,300,300);
            finishStage.setTitle("You finished Game!!");
            Image logo = new Image("image\\logo.jpg");
            finishStage.getIcons().add(logo);
            finishStage.setScene(finishScene);
            finishStage.show();

        }


    }



}





