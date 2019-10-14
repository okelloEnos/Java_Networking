package okelloSoftwarez.Networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
    private ObjectOutputStream saveFile;
    private ObjectInputStream fromClient;

    public static void main(String[] args) {
        new StudentServer();
    }
    public StudentServer(){
        try {
            // Creating a socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server Started ...");

            // creating an object output stream file
            saveFile = new ObjectOutputStream(new FileOutputStream("StudentFile.dat",true));

            while (true){
                //Listen to connection requests
                Socket socket = serverSocket.accept();

                // create input stream to receive stream from client
                fromClient = new ObjectInputStream(socket.getInputStream());

                //create an object to read the stream
                Object object = fromClient.readObject();

                // write the data to file
                saveFile.writeObject(object);
            }
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();

        }
        catch (IOException C){
            C.printStackTrace();
        }
        finally {
            try {

                fromClient.close();
                saveFile.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
