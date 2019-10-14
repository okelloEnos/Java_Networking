package okelloSoftwarez.Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class multiServer extends Application {

    // Text area for displaying contents
    private TextArea textArea = new TextArea();

    //Client number
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {

        //create a scene and display it on stage
        Scene scene = new Scene(new ScrollPane(textArea),450,200);
        stage.setTitle("Server for Many Clients");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
           try {
               // Creating A server socket
               ServerSocket serverSocket = new ServerSocket(8000);

               textArea.appendText("The Multi Server started at : " + new Date() + "\n");

               while (true){
                   // Listen to a new connection request
                   Socket socket = serverSocket.accept();

                   //if connection was successful increment clientNo
                   clientNo++;

                   Platform.runLater(() -> {
                       // Display client details
                       //client number and starting time
                       textArea.appendText("Client Number : " + clientNo + " Started At : " + new Date() + "\n");

                       InetAddress inetAddress = socket.getInetAddress();
                       // HostName
                       textArea.appendText("HostName is :" + inetAddress.getHostName() + "\n");
                       // IP Address
                       textArea.appendText("IP Address : " + inetAddress.getHostAddress() + "\n");
                   });

                   // Create and Start a new Thread for connection
                   new Thread(new handleClient(socket)).start();
               }
           }
           catch (IOException ex){
               System.err.println(ex);
           }
        }).start();
    }

    // Define a Thread class for handling new connection
    class handleClient implements Runnable{
        private Socket socket;

        public handleClient(Socket socket){
            this.socket = socket;
        }

        // Run the thread
        @Override
        public void run() {

            try {
                // Creating Input and output of data
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

                // Continue serving the Client
                while (true){
                    // Receive Radius
                    double radius = inputFromClient.readDouble();

                    //compute area
                    double area = radius*radius*Math.PI;

                    // Send Area to the client
                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        textArea.appendText("Radius received : "+ radius + "\n");
                        textArea.appendText("Area computed is : " + area + "\n");
                    });
                }
            }
            catch (IOException ex){
                ex.printStackTrace();

            }

        }
    }
}
