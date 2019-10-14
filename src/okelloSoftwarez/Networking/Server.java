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

public class Server extends Application {
    @Override
    public void start(Stage stage) {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta),450,200);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                // Creating a server Connection
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> ta.appendText("Server Started" + new Date() + "\n"));

                // Listening to the connection
                Socket socket = serverSocket.accept();

                InetAddress inetAddress = socket.getInetAddress();

                // Creating data input and output streams
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // receiving radius
                    double radius = fromClient.readDouble();

                    // compute area
                    double area = radius * radius * Math.PI;

                    // send to client
                    toClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("Radius Received :" + radius + "\n");
                        ta.appendText("Area is :" + area + "\n");
                        ta.appendText("Host Name :" + inetAddress.getHostName() + "\n");
                        ta.appendText("IP Address" + inetAddress.getHostAddress() + "\n");
                    });
                }
                }
            catch (IOException ex){
                ex.printStackTrace();

            }

        }).start();
    }
}
