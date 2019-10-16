package okelloSoftwarez.Database;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class DatabaseFx extends Application {
    private PreparedStatement preparedStatement;
    private TextField tfSSN = new TextField();
    private TextField tfcourseName = new TextField();
    private Label lblStatus = new Label();
    @Override
    public void start(Stage stage) throws Exception {
        // Initialize the database
        initializeDB();

        Button showGrade = new Button("Show Grade");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Student No : "), tfSSN, new Label("Course Name : "), tfcourseName, showGrade);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        tfcourseName.setPrefColumnCount(6);
        tfSSN.setPrefColumnCount(6);
        showGrade.setOnAction( e -> displayGrade());

        Scene scene = new Scene(vBox, 500, 80);
        stage.setScene(scene);
        stage.setTitle(" Search Results ");
        stage.show();

    }

    private void displayGrade() {

        String ssn, cName;
        ssn = tfSSN.getText().trim();
        cName = tfcourseName.getText().trim();

        try {
            preparedStatement.setString(1,ssn);
            preparedStatement.setString(2,cName);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()){
                String fName = resultSet.getString(1);
                String mName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                String courseName = resultSet.getString(4);
                String Grade = resultSet.getString(5);

                lblStatus.setText(fName + " " + mName + " " + lName + "'S Grade for :" + courseName + "is : " + Grade);
            }
            else {
                lblStatus.setText(" Student not Found");

            }


        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    private void initializeDB() {
        try {
            // Load the Driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded ...");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaBook","root","");
            System.out.println("Database Connection Successful ...");

            String queryString = "select fName, mName, lName, courseName, Grade from Student where CourseId = ? and courseName = ? ";
            preparedStatement = connection.prepareStatement(queryString);
        }
        catch (ClassNotFoundException C){
            C.printStackTrace();
        }
        catch (SQLException S){
            S.printStackTrace();
        }
    }
}
