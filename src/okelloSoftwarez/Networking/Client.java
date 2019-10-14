package okelloSoftwarez.Networking;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    DataInputStream fromServer = null;
    DataOutputStream toServer = null;
    @Override
    public void start(Stage stage) {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setLeft(new Label("Enter Radius : "));
        paneForTextField.setPadding(new Insets(5));
        paneForTextField.setStyle("-fx-border-color: green");

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();

        // text area to display details
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        // create a scene and display it on stage
        Scene scene = new Scene(mainPane,450,200);
        stage.setTitle("Client Side");
        stage.setScene(scene);
        stage.show();

        tf.setOnAction( e -> {
            try {
                  // receive radius from text field
                   double radius = Double.parseDouble(tf.getText().trim());

                  // send to server
                   toServer.writeDouble(radius);
                   toServer.flush();

                 // receive area from server
                   double area = fromServer.readDouble();

                   ta.appendText("Radius is : " + radius + "\n");
                   ta.appendText("The area From Server : " + area + "\n");

            }
            catch (IOException ex){
                System.err.println(ex);
            }

          });

          try {
              // Create a socket to connect to the server
              Socket socket = new Socket("localhost", 8000);

             // Creating Streams to read and write data from and to server
              fromServer = new DataInputStream(socket.getInputStream());
              toServer = new DataOutputStream(socket.getOutputStream());
         }
         catch (IOException ex){
            ta.appendText(ex.toString() + "\n");
        }



    }
}
