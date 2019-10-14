package okelloSoftwarez.javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class LoanCalculator extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(5);

        Label Rate = new Label("Interest Rate : ");
        Label NoYears = new Label("Number of Years : ");
        Label loan = new Label("Loan Amount : ");
        Label M_payment = new Label("Monthly Payment : ");
        Label T_payment = new Label("Total Payment : ");

        TextField Rate_Field = new TextField();
        TextField year_Field = new TextField();
        TextField loan_Field = new TextField();
        TextField mp_Field = new TextField();
        TextField tp_Field = new TextField();

        Button calculate_Button = new Button("Calculate");
        GridPane.setHalignment(calculate_Button, HPos.RIGHT);

        pane.add(Rate,0,0);
        pane.add(Rate_Field,1,0);
        pane.add(NoYears,0,1);
        pane.add(year_Field,1,1);
        pane.add(loan,0,2);
        pane.add(loan_Field,1,2);
        pane.add(M_payment,0,3);
        pane.add(mp_Field,1,3);
        pane.add(T_payment,0,4);
        pane.add(tp_Field,1,4);
        pane.add(calculate_Button,1,5);

        mp_Field.setEditable(false);
        tp_Field.setEditable(false);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
