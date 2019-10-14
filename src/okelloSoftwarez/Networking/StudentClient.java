package okelloSoftwarez.Networking;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient extends Application {

    // creating text fields
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();

    private Button registerBtn = new Button("Register ");
    private Button clearBtn = new Button("Clear ");

    String host = "localhost";
    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Name : "),0,0);
        gridPane.add(tfName,1,0);
        gridPane.add(new Label("Street : "),0,1);
        gridPane.add(tfStreet,1,1);
        gridPane.add(new Label("City : "),0,2);

        HBox hBox = new HBox(2);
        gridPane.add(hBox,1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State : "), tfState, new Label("Zip : "), tfZip);
        gridPane.add(registerBtn,1,3);
        gridPane.add(clearBtn,1,3);
        GridPane.setHalignment(registerBtn, HPos.RIGHT);
        GridPane.setHalignment(clearBtn, HPos.LEFT);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(12);
        tfState.setPrefColumnCount(3);
        tfZip.setPrefColumnCount(2);

        registerBtn.setOnAction(new ButtonListener());
        clearBtn.setOnAction( e -> {
            tfName.setText(null);
            tfStreet.setText(null);
            tfCity.setText(null);
            tfState.setText(null);
            tfZip.setText(null);
        });

        Scene scene = new Scene(gridPane,450,200);
        stage.setTitle("Student Client ");
        stage.setScene(scene);
        stage.show();
    }

    //Handles the Button
    private class ButtonListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            try {
                // Establish a connection with Server
                Socket socket = new Socket(host,8000);

                // create output stream for the server
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

                //Obtain the field values
                String name = tfName.getText().trim();
                String street = tfStreet.getText().trim();
                String city = tfCity.getText().trim();
                String state = tfState.getText().trim();
                String zip = tfZip.getText().trim();

                // Create a student object and send it to server
                Student student = new Student(name,street,city,state,zip);
                toServer.writeObject(student);

            }
            catch (IOException ex){
                ex.printStackTrace();

            }
        }
    }
}
