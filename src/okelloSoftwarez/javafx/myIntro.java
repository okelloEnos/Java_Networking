package okelloSoftwarez.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class myIntro extends Application{
    @Override
    public void start(Stage primaryStage){

        Button btOK = new Button("OKELLO");
        StackPane pane = new StackPane();
        pane.getChildren().add(btOK);
        Scene scene = new Scene(pane,200,50);
        primaryStage.setTitle("MY JAVAFX");
        primaryStage.setScene(scene);
        primaryStage.show();

//        newStage.setResizable(false);
    }

//    public static void main(String[] args) {
//        Application.launch(args);
//    }
}
